-- DAY2 수업내용 : SELECT 기본

-- DQL(Data Query Language) : 데이터 조회용 언어
-- select 문이 사용됨

/*
  기본 구문 형식
  SELECT * | 조회할 컬럼명, 컬럼명
  FROM 조회에 사용할 테이블명
*/

-- * : 모든 컬럼을 의미함
-- EMPLOYEE 테이블의 모든 컬럼의 데이터를 조회할 경우
SELECT * FROM EMPLOYEE;

-- 조회할 컬럼명을 사용해서 선택적으로 데이터를 조회할 경우

SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE;

-- DISTINCT 컬럼명 사용 : 컬럼에 기록된 값 중에 같은 값들은 한 개씩만 고를 경우
-- SELECT 절에서 한번만 사용할 수 있음

-- EMPLOYEE 테이블에 사용된 직급코드 조회할 경우
SELECT DISTINCT JOB_ID
FROM EMPLOYEE;

SELECT * FROM JOB;

-- SELECT 절에 계산식도 사용할 수 있음
SELECT 23 + 32 / 4
FROM DUAL;

-- 사번, 사원명, 급여, 1년치급여 조회할 경우
SELECT EMP_ID, EMP_NAME, SALARY, SALARY * 12
FROM EMPLOYEE;

-- 사번, 사원명, 급여, 보너스포인트, 보너스포인트가 적용된 연봉을 조회할 경우
-- 계산식 : (급여 + (급여 * 보너스포인트)) * 12

SELECT EMP_ID, EMP_NAME, SALARY, BONUS_PCT, (SALARY + (SALARY * BONUS_PCT)) * 12 AS "1년치연봉"
FROM EMPLOYEE;

-- 계산값에 NULL 이 있으면, 결과는 무조건 NULL임.
-- 컬럼의 값이 NULL인 경우에 다른 값으로 바꾸는 함수를 사용해서 해결함 : NVL
-- NVL(값 읽을 컬럼명, 바꿀값) : 컬럼값이 NULL이면 바꿀값으로 바꾸어서 계산에 사용함


SELECT EMP_ID, EMP_NAME, SALARY, NVL(BONUS_PCT, 0) "bonus_pct", (SALARY + (SALARY * NVL(BONUS_PCT, 0))) * 12 "1년치연봉" 
FROM EMPLOYEE;

-- 별칭(ALIAS)에 ""로 묶어야 하는 경우 : 별칭에 숫자, 기호문자, 공백이 포함된 경우

-- SELECT 절에 리터럴(LITERAL : 값) 사용할 수 있음

SELECT EMP_ID 사번, EMP_NAME 이름, '재직' 근무상태
FROM EMPLOYEE;

-- 조건절 : WHERE 절
-- 반드시 FROM 절 다음에 사용함
-- 테이블에서 조건을 만족하는 값들을 골라냄
-- WHERE 컬럼명 비교연산자 비교값
-- 비교연산자 : > (크냐, 초과), < (작으냐, 미만), >= (크거나 같으냐, 이상), <= (작거나 같으냐, 이하)
--              = (같으냐), != (같지 않느냐, == <> 같은 연산자)
-- 논리연산자 : 값의 범위를 물을 때 사용 (&& 는 AND, || 는 OR, !는 NOT 으로 사용함)

-- 부서코드가 90인 직원만 조회할 경우

SELECT * 
FROM EMPLOYEE
WHERE DEPT_ID = '90';

-- 직급코드가 J7인 직원만 조회할 경우

SELECT *
FROM EMPLOYEE
WHERE JOB_ID = 'J7';

-- 급여가 4백만을 초과하는 직원 조회
SELECT *
FROM EMPLOYEE
WHERE SALARY > 4000000;


-- 부서 코드가 '90' 이고 급여를 2000000 보다 이 받는 부서원 이름과 부서 코드, 급여 조회

SELECT EMP_NAME AS 이름, DEPT_ID AS 부서, SALARY AS 급여
FROM EMPLOYEE
WHERE DEPT_ID = 90
AND SALARY > 2000000;

-- 부서가 '90' 또는 20 인 직원 조회

SELECT EMP_NAME AS 이름, DEPT_ID AS 부서, SALARY AS 급여
FROM EMPLOYEE
WHERE DEPT_ID = '90'
OR DEPT_ID = '20';

-- 급여가 2백만 이상 4백만이하인 직원들의 사번, 이름, 급여, 직급코드, 부서코드 조회

SELECT EMP_ID AS 사번, EMP_NAME AS 이름, SALARY AS 급여, JOB_ID AS 직급코드, DEPT_ID AS 부서코드
FROM EMPLOYEE
-- WHERE SALARY >= 2000000 AND SALARY <= 4000000;
WHERE SALARY BETWEEN 2000000 AND 4000000;


-- 연결 연산자 (||) 사용
-- 여러 컬럼값들을 하나의 값처럼 만들 때 사용법

--컬럼과 컬럼을 연결한 경우

SELECT EMP_ID || EMP_NAME || SALARY
FROM EMPLOYEE;

-- 컬럼과 리터럴을 연결한 경우
SELECT EMP_NAME || '의 월급은' || SALARY || '원 입니다.'
FROM EMPLOYEE;

-- 입사일 (HIRE_DATE)이 1995년 1월 1일부터 2000년 12월 31일 사이에 입사한 직원의
-- 사번, 이름, 입사일, 부서코드 조회
-- 날짜데이터는 날짜포멧에 맞춰서 작은따옴표로 묶어서 표현함

-- 일반 비교연산자 사용한 경우

SELECT EMP_ID AS 사번, EMP_NAME AS 이름, HIRE_DATE AS 입사일, DEPT_ID AS 부서코드
FROM EMPLOYEE
WHERE HIRE_DATE >= '95/01/01' AND HIRE_DATE <= '00/12/13';


-- BETWEEN AND 사용한 경우

SELECT EMP_ID AS 사번, EMP_NAME AS 이름, HIRE_DATE AS 입사일, DEPT_ID AS 부서코드
FROM EMPLOYEE
WHERE HIRE_DATE BETWEEN '95/01/01' AND '00/12/13';

-- LIKE 연산자 : 문자열값의 패턴을 제시해서 패턴과 일치하는 값들을 고를 때 사용하는 연산자
-- 컬럼명 LIKE '패턴'
-- 문자열 패턴에 와일드카드 문자 사용함 : %(0개 이상의 글자), _(문자한자리)

-- 성이 '김' 씨인 직원 정보 조회
-- 사번, 이름, 주민번호, 전화번호

SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE EMP_NAME LIKE '김%';

SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE LIKE '___9_______';

-- 사원이름에 '해'자가 포함된 직원의 이름, 주민번호, 전화번호, 결혼유무 조회
SELECT EMP_NAME AS 이름, EMP_NO AS 주민번호, PHONE AS 전화번호, MARRIAGE AS 결혼유무
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%해%';

-- 전화번호의 국번 (4번째자리값)이 '9'로 시작하는 직원들의 이름, 전화번호 조회

SELECT EMP_NAME AS 이름, PHONE AS 전화번호
FROM EMPLOYEE
WHERE PHONE LIKE '___9%';

-- 성별이 여자인 직원 조회 : 사번, 이름, 주민번호, 전화번호
-- 주민번호 8번째 값이 1이면 남자, 2이면 여자임

SELECT EMP_ID AS 사번, EMP_NAME AS 이름, EMP_NO AS 주민번호, PHONE AS 전화번호
FROM EMPLOYEE
WHERE EMP_NO LIKE '_______2%';

SELECT EMP_ID AS 사번, EMP_NAME AS 이름, EMP_NO AS 주민번호, PHONE AS 전화번호
FROM EMPLOYEE
WHERE EMP_NO NOT LIKE '_______2%';

-- 

SELECT EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '____%';

-- 문자열패턴의 와일드카드 문자와 기록된 문자가 같을 경우, ESCAPE 옵션 사용함
-- 이메일 주소에서 아이디와 '_' 앞 글자가 3글자인 직원 조회

SELECT EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE'___#_%' ESCAPE '#';

-- 컬럼명 IS NULL : 컬럼의 값이 NULL 인
-- 컬럼명 IS NOT NULL : 컬럼의 값이 NULL이 아닌

-- 관리자도 없고, 부서도 배정받지 않은 직원 조회

SELECT *
FROM EMPLOYEE
WHERE MGR_ID IS NULL AND DEPT_ID IS NULL;

-- 관리자는 없는데, 부서는 배정받은 직원 조회
SELECT *
FROM EMPLOYEE
WHERE MGR_ID IS NULL OR DEPT_ID IS NOT NULL;

-- 부서도 배정받지 않고, 직급도 없는 직원 조회
SELECT *
FROM EMPLOYEE
WHERE MGR_ID IS NULL AND JOB_ID IS NULL;

-- 보너스포인트가 없는 직원 조회
SELECT *
FROM EMPLOYEE
WHERE BONUS_PCT IS NULL;

-- 부서 배치는 받지 않았는데, 보너스포인트를 받는 직원
SELECT *
FROM EMPLOYEE
WHERE MGR_ID IS NULL AND BONUS_PCT IS NOT NULL;

SELECT EMP_NAME, DEPT_ID, SALARY
FROM EMPLOYEE
WHERE DEPT_ID IN ( '60', '90' );

SELECT EMP_NAME, DEPT_ID, SALARY
FROM EMPLOYEE
WHERE DEPT_ID = '60'
OR DEPT_ID = '90';


-- 연산자 우선순위 예
-- 부서코드가 20 또는 90인 지구언중에서 급여를 3백만보다 많이 받는 직원 이름, 부서코드, 급여 조회

-- 괄호를 사용하지 않았을 때
SELECT EMP_NAME, SALARY, DEPT_ID
FROM EMPLOYEE
WHERE DEPT_ID = '20'
OR DEPT_ID = '90'
AND SALARY > 3000000;

-- 괄호를 사용햇을 때
SELECT EMP_NAME, SALARY, DEPT_ID
FROM EMPLOYEE
-- WHERE ( DEPT_ID = '20' OR DEPT_ID = '90' ) AND SALARY > 3000000;
WHERE DEPT_ID IN('20', '90') AND SALARY > 3000000;

--SELECT 연습문제
--
--1. 부서코드가 90이면서, 직급코드가 J2인 직원들의 사번, 이름, 부서코드, 직급코드, 급여 조회함
--   별칭 적용함
SELECT EMP_ID AS 사번, EMP_NAME AS 이름, DEPT_ID AS 부서코드, JOB_ID AS 직급코드, SALARY AS 급여
FROM EMPLOYEE
WHERE DEPT_ID = '90' AND JOB_ID = 'J2';

--2. 입사일이 '1982-01-01' 이후이거나, 직급코드가 J3 인 직원들의 사번, 이름, 관리자 사번, 보너스포인트 조회함
SELECT EMP_ID, EMP_NAME, MGR_ID, BONUS_PCT
FROM EMPLOYEE
WHERE HIRE_DATE > '82/01/01' OR JOB_ID = 'J3';


--3. 직급코드가 J4가 아닌 직원들의 급여와 보너스포인트가 적용된 연봉을 조회함.
--  별칭 적용함, 사번, 사원명, 직급코드, 연봉(원)
--  단, 보너스포인트가 null 일 때는 0으로 바꾸어 계산하도록 함.

SELECT EMP_ID AS 사번, EMP_NAME AS 사원명, SALARY AS 급여, (SALARY + (SALARY * NVL(BONUS_PCT, 0))) * 12|| '(원)' "1년치 연봉"
FROM EMPLOYEE
WHERE JOB_ID!='J4';


--4. 보너스포인트가 0.1 이상 0.2 이하인 직원들의 사번, 사원명, 이메일, 급여, 보너스포인트 조회함
SELECT EMP_ID, EMP_NAME, EMAIL, SALARY, BONUS_PCT
FROM EMPLOYEE
WHERE BONUS_PCT >=0.1 AND BONUS_PCT <= 0.2;

--5. 보너스포인트가 0.1 보다 작거나(미만), 0.2 보다 많은(초과) 직원들의 사번, 사원명, 보너스포인트, 급여, 입사일 조회함
SELECT EMP_ID, EMP_NAME, BONUS_PCT, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE BONUS_PCT NOT BETWEEN 0.1 AND 0.2;

--6. '1982-01-01' 이후에 입사한 직원들의 사원명, 보너스포인트, 급여 조회함
SELECT EMP_NAME, BONUS_PCT, SALARY
FROM EMPLOYEE
WHERE HIRE_DATE > '82/01/01';

--7. 보너스포인트가 0.1, 0.2 인 직원들의 사번, 사원명, 보너스포인트, 전화번호 조회함
SELECT EMP_ID, EMP_NAME, BONUS_PCT, PHONE
FROM EMPLOYEE
WHERE BONUS_PCT IN (0.1, 0.2);

--8. 보너스포인트가 0.1도 0.2도 아닌 직원들의 사번, 사원명, 보너스포인트, 주민번호 조회함
SELECT EMP_ID, EMP_NAME, BONUS_PCT, EMP_NO
FROM EMPLOYEE
WHERE BONUS_PCT NOT IN(0.1, 0.2);

--9. 성이 '이'씨인 직원들의 사번, 사원명, 입사일 조회함
--  단, 입사일 기준 오름차순 정렬함
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '이%'
ORDER BY HIRE_DATE ASC;

--10. 주민번호 8번째 값이 '2'인 직원의 사번, 사원명, 주민번호, 급여를 조회함
--  단, 급여 기준 내림차순 정렬함

SELECT EMP_ID, EMP_NAME, EMP_NO, SALARY
FROM EMPLOYEE
WHERE EMP_NO LIKE '_______2%'
ORDER BY SALARY DESC;



