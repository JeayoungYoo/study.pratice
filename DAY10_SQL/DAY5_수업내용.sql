-- DAY5 수업내용 : 그룹함수, ORDER BY절, GROUP BY절, HAVING절

-- 그룹함수 : 여러 개의 값을 읽어서 하나의 결과를 만드는 함수
-- SUM, AVG, MIN, MAX, COUNT

-- SUM([DISTINCT] 컬럼명)
SELECT SUM(SALARY), SUM(DISTINCT SALARY)
FROM EMPLOYEE
WHERE DEPT_ID = '50'
OR DEPT_ID IS NULL;

SELECT AVG(BONUS_PCT) AS 기본평균,
AVG(DISTINCT BONUS_PCT) AS 중복제거평균,
AVG(NVL(BONUS_PCT,0)) AS NULL포함평균
FROM EMPLOYEE
WHERE DEPT_ID IN ('50', '90')
OR DEPT_ID IS NULL;

SELECT MAX(JOB_ID), MIN(JOB_ID), MAX(HIRE_DATE), MIN(HIRE_DATE),
MAX(SALARY), MIN(SALARY)
FROM EMPLOYEE
WHERE DEPT_ID IN ('50','90');

-- COUNT(*) : 전체 행수 리턴(NULL 포함)
-- COUNT(컬럼명) : 값이 기록된 행 갯수 리턴(NULL 제외)
-- COUNT(DISTINCT 컬럼명) : 중복값을 제외한 행 갯수 리턴(NULL 제외)

SELECT COUNT(*),
COUNT(JOB_ID),
COUNT(DISTINCT JOB_ID)
FROM EMPLOYEE
WHERE DEPT_ID = '50'
OR DEPT_ID IS NULL;

SELECT EMP_NAME, HIRE_DATE, DEPT_ID
FROM EMPLOYEE
WHERE HIRE_DATE > TO_DATE('20030101','YYYYMMDD')
ORDER BY DEPT_ID DESC, HIRE_DATE, EMP_NAME;

SELECT EMP_NAME AS 이름,
HIRE_DATE AS 입사일,
DEPT_ID AS 부서코드
FROM EMPLOYEE
WHERE HIRE_DATE > TO_DATE('20030101','YYYYMMDD')
ORDER BY 부서코드 DESC, 입사일, 이름;

SELECT EMP_NAME AS 이름,
HIRE_DATE AS 입사일,
DEPT_ID AS 부서코드
FROM EMPLOYEE
WHERE HIRE_DATE > TO_DATE('20030101','YYYYMMDD')
ORDER BY 3 DESC, 2, 1 NULLS LAST;

-- *****************************************************************************
-- ORDER BY 절 : SELECT 한 컬럼 기준으로 값을 정렬시킬 때 사용
-- ORDER BY 컬럼명 [ASC] | DESC
-- ORDER BY 컬럼명 정렬방식, 컬럼명 정렬방식, 컬럼명 정렬방식, ....
-- 첫번째 컬럼에 대해서 정렬하고, 첫번째 컬럼에서 같은 값들에 대해서 두번째 컬럼으로 정렬함
-- SELECT 구문 맨 마지막에 작성함
-- 실행순서도 가장 마지막에 작동됨

/*
5 : SELECT 컬럼명 [AS] 별칭, 계산식, 함수식
1 : FROM 테이블명
2 : WHERE 컬럼명 또는 단일행함수식 연산자 비교값 또는 단일행함수식
3 : GROUP BY 컬럼명
4 : HAVING 그룹함수 비교연산자 비교값
6 : ORDER BY 컬럼명 | 별칭 | 컬럼순번 정렬방식 NULLS FIRST | LAST
*/

SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE DEPT_ID = '50' OR DEPT_ID IS NULL
ORDER BY SALARY DESC, 1 DESC;

-- 2003년 1월 1일 이후에 입사한 직원정보 조회
-- 부서코드 기준 내림차순 정렬하고, 같은 부서코드일 때는 입사일 기준 오름차순 정렬하고
-- 입사일이 같으면 이름 기준 오름차순정렬 처리함
-- 이름, 입사일, 부서코드, 급여
-- 단, NULL 의 위치는 아래쪽으로 둠

SELECT EMP_NAME 이름, HIRE_DATE 입사일, DEPT_ID 부서코드, SALARY 급여
FROM EMPLOYEE
WHERE HIRE_DATE > '03/01/01'
ORDER BY 부서코드 DESC NULLS LAST, 입사일, 이름;

-- GROUP BY 절
-- 같은 값들이 여러 개 기록된 컬럼을 기준으로 같은 값들을 그룹으로 묶을 때 사용함
-- GROUP BY 컬럼명 | 그룹묶을 결과에 대한 계산식
-- 여러 개의 값들을 묶어서 하나의 결과를 얻고자 할 때 사용함
-- 그룹으로 묶은 값들에 대해서는 SELECT 절에서 그룹함수를 사용해서 계산의 결과를 얻음

SELECT EMP_NAME, SALARY, DEPT_ID
FROM EMPLOYEE;

-- 부서별 급여의 합계를 구함
SELECT DEPT_ID, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_ID
ORDER BY DEPT_ID NULLS LAST;

-- 직급별 급여의 합계, 급여의 평균, 직원수 조회
SELECT JOB_ID, SUM(SALARY) "급여의 합계", TRUNC(AVG(SALARY)) "급여의 평균", COUNT(*) "직원수 조회"
FROM EMPLOYEE
GROUP BY JOB_ID
ORDER BY JOB_ID NULLS LAST;

-- GROUP BY절에 기록하지 않은 컬럼은 SELECT절에 그룹함수와 같이 사용 못 함
SELECT DEPT_ID, JOB_ID, SUM(SALARY) "급여의 합계", TRUNC(AVG(SALARY)) "급여의 평균", COUNT(*) "직원수 조회"
FROM EMPLOYEE
GROUP BY JOB_ID
ORDER BY JOB_ID NULLS LAST; -- ERROR

SELECT DEPT_ID, JOB_ID, SUM(SALARY) "급여의 합계", TRUNC(AVG(SALARY)) "급여의 평균", COUNT(*) "직원수 조회"
FROM EMPLOYEE
GROUP BY DEPT_ID, JOB_ID
ORDER BY JOB_ID NULLS LAST;

-- GROUP BY 절에 그룹을 묶기 위한 함수식을 사용할 수도 있음
-- 성별별 그룹합계, 급여평균(천단위에서 반올림처리), 직원수 조회
SELECT DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '3', '남', '여') 성별,
        SUM(SALARY), ROUND(AVG(SALARY), -4), COUNT(*)
FROM EMPLOYEE
GROUP BY DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '3', '남', '여')
ORDER BY 성별;


SELECT DEPT_ID AS 부서,
ROUND(AVG(SALARY),-4) AS 평균급여
FROM EMPLOYEE
GROUP BY DEPT_ID
ORDER BY 1;

SELECT DECODE(SUBSTR(EMP_NO,8,1),
'1', '남', '3', '남', '여') AS 성별,
ROUND(AVG(SALARY),-4) AS 평균급여
FROM EMPLOYEE
GROUP BY DECODE(SUBSTR(EMP_NO,8,1),
'1', '남', '3', '남', '여')
ORDER BY 2;

SELECT DEPT_ID,
COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_ID
ORDER BY 1;


-- 에러(별칭사용)
SELECT DEPT_ID AS 부서,
SUM(SALARY)
FROM EMPLOYEE
GROUP BY 부서;

SELECT MAX(SUM(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_ID;

SELECT DEPT_ID, MAX(SUM(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_ID;

-- HAVING 절 : GROUP BY 절 아래에 사용함
-- 반드시 GROUP BY와 함께 사용해야 함
-- 그룹 묶어서 계산하는 그룹함수 결과값에 대한 조건처리절임
-- HAVING 에서 그룹함수 계산처리가 실행되고, 조건을 만족하는 결과들만 골라내서
-- SELECT 에서 조회됨

-- 부서별 급여합계 중 9백만을 초과하는 부서와 급여합계 조회

SELECT DEPT_ID, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_ID
HAVING SUM(SALARY) > 9000000;

-- 부서별 급여합계 중 급여합계가 최대인 부서코드와 급여합계 조회
SELECT DEPT_ID 부서코드, SUM(SALARY) 급여합계
FROM EMPLOYEE
GROUP BY DEPT_ID
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY)) FROM EMPLOYEE GROUP BY DEPT_ID);

-- 분석함수
-- RANK() 함수 : 순위(등수) 처리하는 함수

-- 해당 값에 대해 전체 값에서의 순위를 조회하고자 할 때
-- RANK(순위를 알고자 하는 값) WITHIN GROUP (ORDER BY 값이 포함된 컬럼명 정렬방식)
SELECT RANK(2300000) WITHIN GROUP (ORDER BY SALARY DESC) 순위
FROM EMPLOYEE;

-- 컬럼 전체 값에 순위를 매길 경우
SELECT EMP_NAME, SALARY, RANK() OVER (ORDER BY SALARY DESC) 순위
FROM EMPLOYEE;
--ORDER BY 순위;

-- ROLLUP() 함수 : gROUP BY 절에서만 사용함
-- 그룹별로 묶어서 계산한 결과에 대한 총집계를 구할 때 사용함

SELECT DEPT_ID, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_ID;

SELECT DEPT_ID, SUM(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(DEPT_ID);

SELECT DEPT_ID, SUM(SALARY), MAX(SALARY), MIN(SALARY), AVG(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(DEPT_ID);
-- 그룹함수로 계산된 결과값들에 대한 총집계가 자동 추가됨

-- 실습 : 부서코드와 직급코드를 함께 그룹을 묶고, 급여의 합계를 구함
-- ROLLUP 사용함
SELECT DEPT_ID, JOB_ID, SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_ID IS NOT NULL AND JOB_ID IS NOT NULL
GROUP BY ROLLUP(DEPT_ID, JOB_ID);

SELECT DEPT_ID, JOB_ID, SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_ID IS NOT NULL AND JOB_ID IS NOT NULL
GROUP BY CUBE(DEPT_ID, JOB_ID);

SELECT DEPT_ID, JOB_ID, SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_ID IS NOT NULL AND JOB_ID IS NOT NULL
GROUP BY ROLLUP(DEPT_ID), ROLLUP(JOB_ID);

SELECT DEPT_ID, JOB_ID, SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_ID IS NOT NULL AND JOB_ID IS NOT NULL
GROUP BY ROLLUP(JOB_ID), ROLLUP(DEPT_ID);

SELECT DEPT_ID, JOB_ID, SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_ID IS NOT NULL AND JOB_ID IS NOT NULL
GROUP BY CUBE(DEPT_ID), CUBE(JOB_ID);

SELECT DEPT_ID, JOB_ID, SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_ID IS NOT NULL AND JOB_ID IS NOT NULL
GROUP BY CUBE(JOB_ID), CUBE(DEPT_ID);

-- 그룹함수 실습 **************************************

-- 부서별 급여평균, 급여는 천단위에서 반올림되게 함.
SELECT DEPT_ID, ROUND(AVG(SALARY), -4) "부서별 급여평균"
FROM EMPLOYEE
GROUP BY DEPT_ID;

-- 성별별 급여 평균  : group by 절에 계산식 사용 가능
-- DECODE, SUBSTR 사용
-- 계산식이 똑같이 입력되어야 함
SELECT DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '3', '남', '여'), AVG(SALARY) "성별별 급여 평균"
FROM EMPLOYEE
GROUP BY DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '3', '남', '여');



-- 실습 : 직급별 급여의 합계와 인원수를 조회함
-- 출력은 직급, 급여합게, 인원수 
SELECT JOB_ID 직급, SUM(SALARY) 급여합계, COUNT(*) 인원수
FROM EMPLOYEE
GROUP BY ROLLUP (JOB_ID);


-- 실습 : 부서코드와 직급코드를 함께 그룹을 묶고, 
-- 급여의 합계를 구함
-- ROLLUP 사용함
SELECT DEPT_ID 부서코드, JOB_ID 직급코드, SUM(SALARY) "급여의 합계"
FROM EMPLOYEE
GROUP BY ROLLUP(DEPT_ID, JOB_ID);


-- ************************************************
-- rollup 함수  
/* 부서/직업별 평균임금 조회 */
SELECT DEPT_ID 부서, JOB_ID 직업, AVG(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(DEPT_ID, JOB_ID);

-- cube 함수
SELECT DEPT_ID 부서, JOB_ID 직업, ROUND(AVG(SALARY), -4) "부서/직업별 평균임금"
FROM EMPLOYEE
GROUP BY CUBE(DEPT_ID, JOB_ID);


-- GROUPING
-- SELECT 절과 GROUP BY 저에서만 사용함
-- 컬럼 그룹 묶을 때 사용함
-- 그룹 묶어서 계산한 값이면 0 표시함
-- 집계낸 값이면 1을 표시함
-- CUBE, ROLLUP함수 사용시 이용하는 함수임
SELECT DEPT_ID, JOB_ID, SUM(SALARY),
        GROUPING(DEPT_ID) "부서별 그루핑 상태", GROUPING(JOB_ID) "직급별 그루핑 상태"
FROM EMPLOYEE
WHERE DEPT_ID IS NOT NULL AND JOB_ID IS NOT NULL
GROUP BY ROLLUP(DEPT_ID, JOB_ID);


SELECT DEPT_ID, JOB_ID, SUM(SALARY),
        GROUPING(DEPT_ID) "부서별 그루핑 상태", GROUPING(JOB_ID) "직급별 그루핑 상태"
FROM EMPLOYEE
WHERE DEPT_ID IS NOT NULL AND JOB_ID IS NOT NULL
GROUP BY CUBE(DEPT_ID, JOB_ID);

-- GROUPING SETS
-- 그룹별로 묶어서 처리한 여러 개의 SELECT 문을 하나로 합친 결과를 원할 때 사용함

-- 부서별, 직급별, 관리자별 급여의 평균을 구함
SELECT DEPT_ID, JOB_ID, MGR_ID, AVG(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_ID, JOB_ID, MGR_ID
UNION ALL

-- 부서별, 관리자별 급여의 평균을 구함
SELECT DEPT_ID, NULL, MGR_ID, AVG(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_ID, MGR_ID
UNION ALL
-- 직급별, 관리자별 급여의 평균을 구함
SELECT NULL, JOB_ID, MGR_ID, AVG(SALARY)
FROM EMPLOYEE
GROUP BY JOB_ID, MGR_ID;

-- 위의 처리과정을 GROUPING SETS 로 바꾸면
SELECT DEPT_ID, JOB_ID, MGR_ID, AVG(SALARY)
FROM EMPLOYEE
GROUP BY GROUPING SETS((DEPT_ID, JOB_ID, MGR_ID), (DEPT_ID, MGR_ID), (JOB_ID, MGR_ID));

SELECT DEPT_ID, JOB_ID, MGR_ID, AVG(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(DEPT_ID, (JOB_ID, MGR_ID));

-- ROWID : 행을 식별하는 행에 대한 ID 값
-- 데이터베이스가 자동으로 붙임, 수정 못 함, 조회만 할 수 있음
SELECT ROWID, EMP_ID
FROM EMPLOYEE;