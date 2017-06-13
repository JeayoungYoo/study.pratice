-- DAY8 수업내용

-- WITH 이름 AS (쿼리문)
-- SELECT * FROM 이름;
-- 서브쿼리에 이름을 붙여주고 메인쿼리에서 서브쿼리 사용부분에 이름을 사용함
-- 같은 서브쿼리가 여러 번 사용될 경우 SELECT 절에서 서브쿼리의 이름을 사용하면 
-- 중복 사용도 줄이고 실행 속도도 빨라진다는 장점이 있음.
-- 인라인 뷰로 사용될 서브쿼리에 주로 사용됨

-- NATURAL JOIN : 조인할 테이블의 기본키(PRIMARY KEY)를 이용한 EQUAL JOIN + INNER JOIN 임

SELECT *
FROM EMPLOYEE
NATURAL JOIN DEPARTMENT;

-- 부서별 급여의 합계가 전체 급여 총합의 20%보다 많은 부서명과 부서별 급여합계 조회
SELECT DEPT_NAME, SUM(SALARY)
FROM EMPLOYEE
JOIN DEPARTMENT USING (DEPT_ID)
GROUP BY DEPT_ID, DEPT_NAME
HAVING SUM(SALARY) > (SELECT SUM(SALARY)
                      FROM EMPLOYEE)*0.2;
                      
-- WITH 사용 SQL 문 : NATURAL JOIN 적용
WITH TOTAL_SAL AS (SELECT DEPT_NAME, SUM(SALARY) SSAL
                   FROM EMPLOYEE
                   NATURAL JOIN DEPARTMENT
                   GROUP BY DEPT_NAME)
SELECT DEPT_NAME, SSAL
FROM TOTAL_SAL -- 인라인뷰
WHERE SSAL > (SELECT SUM(SALARY) *0.2
              FROM EMPLOYEE);
              
/*
    분석함수
      오라클 분석함수는 데이터를 분석하는 목적의 함수임.
      분석함수를 사용하면, 쿼리 실행의 결과인 RESULT SET을 대상으로
      전체 그룹별이 아닌 소그룹별로 각 행에 대한 계산값을 리턴함.
      
    일반 그룹함수와 다른 점은 분석함수는 분석함수용 그룹을 별도로 정의해서
    그 그룹을 대상으로 계산을 수행한다는 것이다.
    일반 그룹함수는 그룹별로 계산을 수행한다.
    
    이때 분석함수용 그룹을 오라클에서는 윈도우(WINDOW) 라고 부름
*/

-- 사용 형식
/*
   분석함수명 ([전달인자1{, 전달인자2{, 전달인자3}}])
    OVER ([PARTITION BY 절]
          [ORDER BY 절]
          [WINDOW 절])
    FROM 테이블명
    
   분석함수명 : AVG, SUM, RANK, MAX, MIN, COUNT 등
   전달인자 : 분석함수에 따라서 0 ~ 3개까지 사용할 수 있음.
   쿼리 PARTITION 절 : PARTITION BY 표현식
                      표현식에 따라 그룹별로 단일 결과셋으로 분리하는 역할을 함
                      즉, 분석함수의 계산 대상 그룹을 지정함.
   ORDER BY 절 : PARTITION 절 뒤에 사용해야 함.
                 계산 대상 그룹에 대해 정렬작업을 수행함.
   WINDOW 절 : 분석함수 대상이 되는 테이블을 행 기준으로 범위를 더 세부적으로 정의함
               PARTITION BY 에 의해 나누어진 기준 그룹에 대해 또 다른 소그룹을 만듦.
*/

-- 등수 매기는 함수 : RANK
-- 같은 등수가 있을 때는 다음 등수값이 건너 뜀
-- 예 : 1, 1, 3

-- 급여에 대해 순위를 매긴다면 (내림차순 정렬 기준)
SELECT EMP_ID, EMP_NAME, SALARY, RANK() OVER (ORDER BY SALARY DESC) 급여순위
FROM EMPLOYEE;

-- 지정한 값의 순위를 알고자 할 경우, RANK (순위를 알고자 하는 값)
-- 급여 230만이 급여 내림차순정렬 시 몇 순위에 해당되는지 조회
SELECT RANK (2300000) WITHIN GROUP (ORDER BY SALARY DESC) 순위
FROM EMPLOYEE;

-- DENSE_RANK() : 같은 순위가 여러 개 있어도, 다음 순위를 건너뛰지 않음.
-- 예 : 1, 2, 2, 3

-- 급여 전체에 순위를 매긴다면 
SELECT EMP_NAME, DEPT_ID, SALARY, RANK() OVER(ORDER BY SALARY DESC) "순위1",
DENSE_RANK() OVER(ORDER BY SALARY DESC) "순위2",
DENSE_RANK() OVER(PARTITION BY DEPT_ID ORDER BY SALARY DESC) "그룹별순위"
FROM EMPLOYEE
ORDER BY 2;

-- RANK() 를 이용한 TOP-N 분석 방법
-- 급여 많이 받는 직원 5명 조회
SELECT *
FROM (SELECT EMP_NAME, SALARY, RANK() OVER(ORDER BY SALARY DESC) "순위"
      FROM EMPLOYEE)
WHERE 순위 <= 5;

-- 급여 적게 받는 순서로 11순위에 해당하는 직원정보 조회
-- 이름, 급여
SELECT EMP_NAME, SALARY
FROM (SELECT EMP_NAME, SALARY, DENSE_RANK() OVER(ORDER BY SALARY ASC) 순위
      FROM EMPLOYEE)
WHERE 순위 = 11;

-- CUME_DIST() : CUMulative distribution
-- PARTITION BY 에 의해 나누어진 그룹별로 각 행을 ORDER BY 절에 명시된 순서로 정렬한 후
-- 그룹별로 누적된 분산정도(상대적인 위치)를 구하는 함수임.
-- 0 < 결과값 <= 1 범위의 값임.
-- 분산정도(상대적인 위치)는 구하고자 하는 값보다 작거나 같은 값을 가진 행 수를 
-- 그룹 내의 총 행수로 나눈 것을 의미함.

-- 부서코드가 '50'인 직원들의 이름, 급여, 급여누적분산을 조회
SELECT EMP_NAME, SALARY, ROUND(CUME_DIST() OVER (ORDER BY SALARY), 1) 누적분산
FROM EMPLOYEE
WHERE DEPT_ID = '50';

-- NTILE() 함수
/*
    PARTITION을 BUCKET 이루 불리는 그룹별로 나누고, 
    PARTITION 내의 각 행을 BUCKET 에 배치하는 함수임
    예를 들어 PARTITION 안에 100 개의 행이 있다면, BUCKET을 4개로 하면
    1개의 BUCKET 당 25개의 행이 배분됨.
    정확하게 배분되지 않을 때는 근사치로 배분한 후 남는 값에 대해 최초 BUCKET 부터 채움
*/

-- 급여를 4등급으로 분류
SELECT EMP_NAME, SALARY, NTILE(4) OVER(ORDER BY SALARY) 등급
FROM EMPLOYEE;

-- ROW_NUMBER() 함수
/*
    ROWNUM 과는 관계가 없음
    각 PARTITION 내의값들을 ORDER BY 절에 의해 정렬한 후
    그 순서대로 순번을 부여함
*/

-- 사번, 이름, 급여, 입사일, 순번
-- 단 순번은 급여가 많은 순으로, 같은 급여는 입사일이 빠른사람부터

SELECT EMP_NO, EMP_NAME, SALARY, HIRE_DATE, ROW_NUMBER() OVER(ORDER BY SALARY DESC, HIRE_DATE ASC) 순번
FROM EMPLOYEE;

-- 집계함수
-- EMPLOYEE 테이블로 부터 부서코드가 '60'인 직원들의 사번, 급여, 해당 부서그룹(윈도우라고 함)의
-- 사번을 오름차순 정렬하고 급여의 합계 에 대한 집계를 구함.

-- 급여의 합계를 첫행부터 마지막행까지 구해서 "WIN1" 에 출력 처리하고, 
SELECT EMP_ID, SALARY, SUM(SALARY) OVER(PARTITION BY DEPT_ID
                                        ORDER BY EMP_ID
                                        ROWS BETWEEN UNBOUNDED PRECEDING
                                        AND UNBOUNDED FOLLOWING) "win1",
                                        
-- ROWS : 부분그룹인 윈도우의 크기를 행 집합으로 지정한다는 의미임
-- UNBOUNDED PRECEDING : 윈도우의 첫행
-- UNBOUNDED FOLLOWING : 윈도우의 마지막행

-- 첫행부터 현재 행까지의 급여의 합계를 구해서 "WIN2" 에 출력
                       SUM(SALARY) OVER(PARTITION BY DEPT_ID
                                        ORDER BY EMP_ID
                                        ROWS BETWEEN UNBOUNDED PRECEDING
                                        AND CURRENT ROW) "win2",
-- 현재 행에서 윈도우의 마지막 행까지의 급여 합계를 구해서 "win3"에 출력
                        SUM(SALARY) OVER(PARTITION BY DEPT_ID
                                        ORDER BY EMP_ID
                                        ROWS BETWEEN CURRENT ROW
                                        AND UNBOUNDED FOLLOWING) "win3"
FROM EMPLOYEE
WHERE DEPT_ID = '60';

-- 행수를 지정해서 집계를 구할 수도 있음
SELECT EMP_ID, SALARY, SUM(SALARY) OVER(PARTITION BY DEPT_ID
                                        ORDER BY EMP_ID
                                        ROWS BETWEEN 1 PRECEDING
                                        AND 1 FOLLOWING) "win1",
-- 현재 행을 중심으로 이전 행과 다음 행의 급여 합계를 구함

                       SUM(SALARY) OVER(PARTITION BY DEPT_ID
                                        ORDER BY EMP_ID
                                        ROWS BETWEEN 1 PRECEDING
                                        AND CURRENT ROW) "win2",
-- 현재 행과 이전 행까지의 급여 합계를 구함

                       SUM(SALARY) OVER(PARTITION BY DEPT_ID
                                        ORDER BY EMP_ID
                                        ROWS BETWEEN CURRENT ROW
                                        AND 1 FOLLOWING) "win3"
-- 현재 행과 다음 행의 급여 합계를 구함
FROM EMPLOYEE
WHERE DEPT_ID = '60';

-- RATIO_TO_REPORT() 함수
-- 해당 구간에서 차지하는 비율을 리턴하는 함수

-- 직원들의 총급여를 2천만원 증가시킬 때, 기존 월급비율을 적용해서
-- 각 직원이 받게 될 급여의 증가액은 ?
SELECT EMP_NAME, SALARY,
       LPAD(TRUNC(RATIO_TO_REPORT(SALARY) OVER() * 100, 0), 5) || ' %' 비율,
       TO_CHAR(TRUNC(RATIO_TO_REPORT(SALARY) OVER() * 20000000, 0) , 'L00,999,999') "추가로 받을 급여"
FROM EMPLOYEE;

-- LAG (조회할 범위, 이전위치, 기준 현재위치)
-- 지정하는 컬럼의 현재 행을 기준으로 이전 행(위쪽)의 값을 조회할 때 사용함
SELECT EMP_NAME, DEPT_ID, SALARY,
       LAG(SALARY, 1, 0) OVER (ORDER BY SALARY) 이전값,
       -- 1: 바로 위의 행 값, 0: 이전행이 없으면 0 처리함
       LAG(SALARY, 1, SALARY) OVER (ORDER BY SALARY) "조회2",
       -- 이전 행이 없으면 현재 행의 값 출력
       LAG(SALARY, 1, SALARY) OVER (PARTITION BY DEPT_ID ORDER BY SALARY) "조회3"
FROM EMPLOYEE;

-- LEAD(조회할 범위, 다음행수, 0 또는 컬럼명)
-- 다음 행의 값 조회
SELECT EMP_NAME, DEPT_ID, SALARY,
       LEAD(SALARY, 1, 0) OVER (ORDER BY SALARY) 다음값,
       -- 1: 바로 위의 행 값, 0: 이전행이 없으면 0 처리함
       LEAD(SALARY, 1, SALARY) OVER (ORDER BY SALARY) "조회2",
       -- 이전 행이 없으면 현재 행의 값 출력
       LEAD(SALARY, 1, SALARY) OVER (PARTITION BY DEPT_ID ORDER BY SALARY) "조회3"
FROM EMPLOYEE;


-- ******************************************************************************
-- DDL (Data Definition Language) : 데이터 정의 언어
-- 주로 객체를 만들고, 수정하고, 삭제하는 구문
-- 객체(Object) : 테이블, 뷰, 인덱스, 시퀀스, 동의어, 사용자, 롤(권한의 집합)등
-- CREATE, ALTER, DROP 구문
-- CREATE TABLE 테이블명
-- CREATE VIEW 뷰명
-- CREATE SEQUENCE 시퀀스명
-- CREATE INDEX 인덱스명
-- CREATE SYNONYM 동의어명
-- CREATE USER 사용자명
-- CREATE ROLE 롤명

CREATE TABLE TEST
(ID NUMBER(5),
NAME CHAR(10),
ADDRESS VARCHAR2(50)
);

ROLLBACK;

CREATE TABLE ORDERS (ORDERNO CHAR(4),
                     CUSTNO CHAR(4),
                     ORDERDATE  DATE DEFAULT SYSDATE,
                     SHIPDATE DATE,
                     SHIPADDRESS VARCHAR2(40),
                     QUANTITY NUMBER
                     );

COMMENT ON COLUMN ORDERS.ORDERNO IS '주문번호';
COMMENT ON COLUMN ORDERS.CUSTNO IS '고객번호';
COMMENT ON COLUMN ORDERS.ORDERDATE IS '주문일자';
COMMENT ON COLUMN ORDERS.SHIPDATE IS '배송일자';
COMMENT ON COLUMN ORDERS.SHIPADDRESS IS '배송주소';
COMMENT ON COLUMN ORDERS.QUANTITY IS '주문수량';

COMMIT;

-- 회원 정보 저장용 테이블 예
CREATE TABLE MEMBER(
    ID VARCHAR2(15) PRIMARY KEY,
    PASSWD VARCHAR2(15) NOT NULL,
    NAME VARCHAR2(20) NOT NULL,
    EMAIL VARCHAR2(30),
    GENDER CHAR(1),
    AGE NUMBER,
    PHONE CHAR(13),
    ADDRESS VARCHAR2(50),
    ENROLL_DATE DATE DEFAULT SYSDATE
);

CREATE TABLE NOTICE(
    NOTICE_NO NUMBER,
    NOTICE_TITLE VARCHAR2(30),
    NOTICE_WRITER VARCHAR2(15),
    NOTICE_DATE DATE DEFAULT SYSDATE,
    NOTICE_CONTENT VARCHAR2(2000),
    FILE_PATH VARCHAR2(50)
);

COMMENT ON COLUMN NOTICE.NOTICE_NO IS '글번호';
COMMENT ON COLUMN NOTICE.NOTICE_TITLE IS '글제목';
COMMENT ON COLUMN NOTICE.NOTICE_WRITER IS '작성자';
COMMENT ON COLUMN NOTICE.NOTICE_DATE IS '작성날짜';
COMMENT ON COLUMN NOTICE.NOTICE_CONTENT IS '글내용';
COMMENT ON COLUMN NOTICE.FILE_PATH IS '첨부파일경로명';

/*
    첫번째 글 추가 : 1, '첫번째 공지글', 'USER01', '안녕하세요. 공지사항을 알려드립니다.'
    두번째 글 추가 : 글번호의 가장 큰 값 + 1, '두번째 공지글', 'USER02', '알립니다. 두번째'
*/

INSERT INTO NOTICE ( NOTICE_NO, NOTICE_TITLE, NOTICE_WRITER, NOTICE_DATE,
NOTICE_CONTENT)
VALUES ( 1, '첫번째 공지글', 'user01', DEFAULT, '안녕하세요. 공지시항을 알려드립니다'
       );
       
INSERT INTO NOTICE ( NOTICE_NO, NOTICE_TITLE, NOTICE_WRITER, NOTICE_DATE,
NOTICE_CONTENT)
VALUES ((SELECT MAX(NOTICE_NO)+1 FROM NOTICE), '두번째 공지글', 'user02', DEFAULT, '알립니다. 두번째');
COMMIT;

SELECT *
FROM NOTICE;

CREATE TABLE TABLE_NOTNULL
(ID CHAR(3) NOT NULL,
SNAME VARCHAR2(20));

INSERT INTO TABLE_NOTNULL
VALUES ('100','ORACLE');

INSERT INTO TABLE_NOTNULL
VALUES (NULL,'ORACLE');

CREATE TABLE TABLE_NOTNULL2
(ID CHAR(3),
SNAME VARCHAR2(20),
CONSTRAINT TN2_ID_NN NOT NULL(ID));
