-- DAY12 수업내용

-- DML(Data Manipulation Language)
-- 데이터 조작 언어
-- INSERT, UPDATE, DELETE, TRUNCATE
-- 테이블에 데이터를 추가하거나, 기록된 데이터를 변경하거나,
-- 데이터가 기록된 행을 삭제할 경우에 사용하는 구문임
-- INSERT 문 : 행을 추가함
-- UPDATE 문 : 데이터를 변경함, 행 갯수 변동없음
-- DELETE 문 : 행을 삭제함. 행 갯수가 줄어듬
-- TRUNCATE 문 : 테이블의 모든 행을 삭제함, 복구 안 됨



SELECT * FROM DCOPY;

-- WHERE 절이 생략되면 컬럼 전체의 값이 변경됨
UPDATE DCOPY
SET DNAME = '인사팀';

ROLLBACK;

UPDATE DCOPY
SET DNAME = '인사팀'
WHERE DID = '10';

SELECT * FROM DCOPY;


-- UPDATE 문에 서브쿼리 사용할 수 있음
-- SET 절과 WHERE 절에서 사용 가능함

-- 심하균 직원의 직급코드와 급여를 성해교 직원의 직급코드와 급여와 같은 값으로 변경

UPDATE EMPLOYEE
SET JOB_ID = (SELECT JOB_ID FROM EMPLOYEE
            WHERE EMP_NAME = '성해교'),
    SALARY = (SELECT SALARY FROM EMPLOYEE
            WHERE EMP_NAME = '성해교')
WHERE EMP_NAME = '심하균';

ROLLBACK;

SELECT JOB_ID, SALARY FROM EMPLOYEE
WHERE EMP_NAME = '심하균';

-- 또는 다중열 서브쿼리를 이용할 경우

UPDATE EMPLOYEE
SET (JOB_ID, SALARY) = (SELECT JOB_ID, SALARY
                        FROM EMPLOYEE
                        WHERE EMP_NAME = '성해교')
WHERE EMP_NAME = '심하균';

-- 확인
SELECT EMP_NAME, JOB_ID, SALARY
FROM EMPLOYEE
WHERE EMP_NAME IN ('심하균', '성해교');

ROLLBACK;

-- UPDATE 시에 변경할 값에 DEFAULT 키워드 사용할 수 있음
SELECT EMP_NAME, MARRIAGE
FROM EMPLOYEE
WHERE EMP_ID = '210';

UPDATE EMPLOYEE
SET MARRIAGE = DEFAULT
WHERE EMP_ID = '210';

ROLLBACK;

-- UPDATE 구문 WHERE 절에서도 서브쿼리를 사용할 수 있음

-- 해외영업2팀 직원들의 보너스포인트를 모두 0.3으로 변경하시오.

UPDATE EMPLOYEE
SET BONUS_PCT = '0.3'
WHERE DEPT_ID = (SELECT DEPT_ID
                 FROM DEPARTMENT
                 WHERE DEPT_NAME = '해외영업2팀');
                 
SELECT EMP_NAME, DEPT_ID, BONUS_PCT
FROM EMPLOYEE
WHERE DEPT_ID = (SELECT DEPT_ID
                 FROM DEPARTMENT
                 WHERE DEPT_NAME = '해외영업2팀');
                 
ROLLBACK;

-- 값 변경시 무결성 제약조건에 위배되지 않게 해야 함
UPDATE EMPLOYEE
SET DEPT_ID = '65'
WHERE DEPT_ID IS NULL;

-- INSERT 문
-- 테이블에 새 행을 추가할 때 사용함 : 행 수가 늘어남

/*
    INSERT INTO 테이블명 [(컬럼명, 컬럼명, ....)]
    VALUES (값, 값, ....);
*/

CREATE TABLE DEPT
    (DEPT_ID CHAR(2), 
     DEPT_NAME VARCHAR2(30));
     
SELECT COUNT(*) FROM DEPT;

INSERT INTO DEPT VALUES ('20', '회계팀');

SELECT COUNT(*) FROM DEPT;

INSERT INTO DEPT VALUES ('10', '인사팀');

SELECT COUNT(*) FROM DEPT;

COMMIT;

INSERT INTO EMPLOYEE ( EMP_ID, EMP_NO, EMP_NAME, EMAIL, PHONE, HIRE_DATE, 
                       JOB_ID, SALARY, BONUS_PCT, MARRIAGE, MGR_ID, DEPT_ID )
VALUES ('900', '811126-1484710', '오윤하', 'oyuh@vcc.com', '01012345678', 
        '06/01/01', 'J7', 3000000, 0, 'N', '176', '90' );

SELECT * FROM EMPLOYEE WHERE EMP_ID = '900';

ROLLBACK;

INSERT INTO EMPLOYEE VALUES
('910', '이병언', '781010-1443269', 'TK1@VCC.COM', '01077886655', '04/01/01', 'J7',
 3500000, 0.1, DEFAULT, '176', '90');
 
 SELECT * FROM EMPLOYEE
 WHERE EMP_ID = '910';

-- INSERT 시에 원하는 컬럼에만 값 기록할 수 있음 
INSERT INTO EMPLOYEE (EMP_ID, EMP_NO, EMP_NAME, PHONE, HIRE_DATE, JOB_ID,
                       SALARY, BONUS_PCT, MARRIAGE)
VALUES ('880', '860412-2377610', '한채연', '0193382662', '06/01/01', 'J7', 3000000, 0, 'N');

-- 제외된 컬럼은 값이 없어서 NULL 임
SELECT * FROM EMPLOYEE
WHERE EMP_ID = '880';


-- 값을 기록하지 않을 컬럼에는 NULL을 직접 사용해도 됨
INSERT INTO EMPLOYEE VALUES
('840', '하지언', '870115-2253408', 'ju_ha@vcc.com', NULL, '07/06/15',
'J7', NULL, NULL, 'N', NULL, NULL);
-- SQL에서는 NULL 과 '' (빈따옴표)가 같은 의미이지만 JAVA에서는 다른 의미이기 때문에 구분하여야 함

SELECT * FROM EMPLOYEE
WHERE EMP_ID = '840';

-- INSERT 시 값 대신에 DEFAULT 키워드 사용해도 됨
-- 테이블 생성시 컬럼에 설정한 DEFAULT 값이 기록에 사용됨
-- DEFAULT 가 설정 안 된 컬럼에 사용하면, NULL 처리됨
INSERT INTO EMPLOYEE (EMP_ID, EMP_NO, EMP_NAME, SALARY, MARRIAGE)
VALUES ('860', '810429-2165344', '선예진', DEFAULT, DEFAULT);

SELECT * FROM EMPLOYEE
WHERE EMP_ID = '860';

CREATE TABLE EMP
(EMP_ID CHAR(3),
EMP_NAME VARCHAR2(20),
DEPT_NAME VARCHAR2(20));

INSERT INTO EMP (SELECT EMP_ID, EMP_NAME, DEPT_NAME
                 FROM EMPLOYEE
                 LEFT OUTER JOIN DEPARTMENT USING (DEPT_ID));
-- 서브쿼리의 () 는 사용 안 해도 됨

SELECT * FROM EMP;

-- DELETE 문
-- 행을 삭제하는 구문임

DELETE FROM EMPLOYEE;
-- WHERE 절이 생략되면 테이블 안의 모든 행이 삭제됨

-- 확인
SELECT * FROM EMPLOYEE;

-- 삭제 취소
ROLLBACK;

-- 다른 테이블에서 FOREIGN KEY 제약조건으로 참조되고 있는 경우
-- 부모키에 해당하는 컬럼을 가진 행은 삭제 못 함

DELETE FROM DEPARTMENT
WHERE DEPT_ID = '30';

SELECT * FROM DEPARTMENT;

ROLLBACK;

-- 삭제하고자 할 경우
-- 방법 1 : 자식 레코드가 있는 테이블의 외래키 제약조건을 비활성화 시키고 삭제함

ALTER TABLE EMPLOYEE
-- DISABLE CONSTRAINT FK_DEPTID;  -- 비활성화시킴
-- ENABLE CONSTRAINT FK_DEPTID;  -- 활성화시킴


-- TRUNCATE : 테이블의 전체 행 삭제 구문
-- 실행 속도 빠름, 복구 안 됨
TRUNCATE TABLE DCOPY;

SELECT * FROM DCOPY;

ROLLBACK;

ALTER TABLE EMPLOYEE DROP CONSTRAINTS FK_MGRID;

ALTER TABLE EMPLOYEE ADD CONSTRAINTS FK_MGRID FOREIGN KEY (MGR_ID)

REFERENCES EMPLOYEE ON DELETE SET NULL;
DELETE FROM EMPLOYEE WHERE EMP_ID = '141';

ROLLBACK;

ALTER TABLE EMPLOYEE DROP CONSTRAINTS FK_JOBID;
ALTER TABLE EMPLOYEE ADD CONSTRAINTS FK_JOBID FOREIGN KEY (JOB_ID)
REFERENCES JOB ON DELETE CASCADE;
DELETE FROM JOB WHERE JOB_ID = 'J2';

ROLLBACK;

-- 여러 테이블에 한번에 INSERT 하기
-- 사번, 이름, 입사일에 대한 구조만 복사한 EMP_HIRE 테이블 만들기
CREATE TABLE EMP_HIRE
AS
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE 1 = 0;

SELECT * FROM EMP_HIRE;
DESC EMP_HIRE;

-- 2. 부서코드가 '20' 인 직원의 정보만 복사해 넣음
INSERT INTO EMP_HIRE
(SELECT EMP_ID, EMP_NAME, HIRE_DATE
 FROM EMPLOYEE
 WHERE DEPT_ID = '20');
 
SELECT * FROM EMP_HIRE;

ROLLBACK;  -- 방금 INSERT 취소

-- 3. 사번, 이름, 관리자사번의 구조만 복사한 EMP_MGR 테이블 만들기
CREATE TABLE EMP_MGR
AS
SELECT EMP_ID, EMP_NAME, MGR_ID
FROM EMPLOYEE
WHERE 1 = 0;

DESC EMP_MGR;

-- 4. 두 개의 테이블에 한번에 INSERT 하기
-- INSERT ALL 구문 사용함
-- 두 서브쿼리의 조건절에 내용이 같고, 서브쿼리가 참조하는 테이블도 같은 경우에 사용.

INSERT ALL
INTO EMP_HIRE VALUES (EMP_ID, EMP_NAME, HIRE_DATE)
INTO EMP_MGR VALUES (EMP_ID, EMP_NAME, MGR_ID)
(SELECT EMP_ID, EMP_NAME, HIRE_DATE, MGR_ID
 FROM EMPLOYEE
 WHERE DEPT_ID = '20');
 
SELECT * FROM EMP_HIRE;
SELECT * FROM EMP_MGR;

-- 조건을 만족하는 경우에만 INSERT ALL 되게 할 수도 있음
CREATE TABLE EMP_SAL
AS
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE 1=0;

-- EMP_HIRE 테이블에는 입사일이 2000년 1월 1일 이후에 입사한 직원의 정보만 INSERT 하고
-- EMP_SAL 테이블에는 급여가 2백만원을 초과하는 직원의 정보만 INSERT 되게 함

DELETE EMP_HIRE;
DELETE EMP_SAL;

INSERT ALL
WHEN HIRE_DATE > TO_DATE ('2000-01-01', 'YYYY-MM-DD')
THEN INTO EMP_HIRE VALUES (EMP_ID, EMP_NAME, HIRE_DATE)
WHEN SALARY > 2000000
THEN INTO EMP_SAL VALUES (EMP_ID, EMP_NAME, SALARY)
(SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
 FROM EMPLOYEE);
 
SELECT * FROM EMP_HIRE;
SELECT * FROM EMP_SAL;

-- MERGE
-- 두 테이블에서 지정하는 조건의 값이 있으면 UPDATE 되고,
-- 없으면 INSERT 되게 하는 구문

CREATE TABLE EMP001
AS
SELECT * FROM EMPLOYEE;

-- 직급이 차장인 직원들의 정보를 복사한 EMP_J4 테이블 만들기
CREATE TABLE EMP_J4
AS
SELECT * FROM EMPLOYEE
WHERE JOB_ID = 'J4';

-- UPDATE 확인을 위해
INSERT INTO JOB(JOB_ID, JOB_TITLE)
VALUES ('J8', '부장대리');

SELECT * FROM JOB;

UPDATE EMP_J4
SET JOB_ID = 'J8';

SELECT * FROM EMP_J4;

-- 일치하지 않는 경우에는 INSERT 되는지 확인을 위해 샘플 데이터 입력
INSERT INTO EMP_J4
VALUES ('999', '홍길동', '891025-1234567', 'hong999@kh.org', '0101234567', SYSDATE,
        'J4', 2850000, 0.3, 'N', '104', '90');
        
-- 실행 확인
MERGE INTO EMP001 USING EMP_J4 ON (EMP001.EMP_ID = EMP_J4.EMP_ID)
WHEN MATCHED THEN UPDATE SET EMP001.JOB_ID = EMP_J4.JOB_ID
WHEN NOT MATCHED THEN INSERT VALUES (EMP_J4.EMP_ID, 
                                     EMP_J4.EMP_NAME,
                                     EMP_J4.EMP_NO,
                                     EMP_J4.EMAIL,
                                     EMP_J4.PHONE,
                                     EMP_J4.HIRE_DATE,
                                     EMP_J4.JOB_ID,
                                     EMP_J4.SALARY,
                                     EMP_J4.BONUS_PCT,
                                     EMP_J4.MARRIAGE,
                                     EMP_J4.MGR_ID,
                                     EMP_J4.DEPT_ID);

SELECT * FROM EMP001;


ALTER TABLE EMPLOYEE
DISABLE CONSTRAINTS FK_MGRID;
SAVEPOINT S0;

INSERT INTO DEPARTMENT
VALUES ('40','기획젂략팀','A1');

SAVEPOINT S1;

UPDATE EMPLOYEE
SET DEPT_ID = '40'
WHERE DEPT_ID IS NULL;

SAVEPOINT S2;

DELETE FROM EMPLOYEE;

ROLLBACK TO S2;
SELECT COUNT(*)
FROM EMPLOYEE;
SELECT COUNT(*)
FROM EMPLOYEE
WHERE DEPT_ID = '40';

ROLLBACK TO S1;
SELECT COUNT(*)
FROM DEPARTMENT
WHERE DEPT_ID = '40';

SELECT COUNT(*)
FROM EMPLOYEE
WHERE DEPT_ID = '40';


-- 동시성 제어
SELECT EMP_NAME, MARRIAGE
FROM EMPLOYEE
WHERE EMP_ID = '143';