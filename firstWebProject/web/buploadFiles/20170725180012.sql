-- DAY3 수업내용 : 함수

-- 함수(FUNCTION)
-- 단일행 함수와 그룹함수로 구분됨 :
-- SELECT 절에서 함께 사용 못 함. WHERE 절에서는 그룹함수 사용 못 함

-- 단일행 (SINGLE ROW) 함수 : 컬럼에 기록된 N개의 값을 읽어서 N개의 결과를 만드는 함수



SELECT EMP_ID, EMP_NAME, UPPER(EMAIL)  -- UPPER 단일함수
FROM EMPLOYEE;

SELECT EMAIL, LENGTH(EMAIL) 글자갯수
FROM EMPLOYEE;

SELECT AVG(SALARY)  -- AVG 그룹함수
FROM EMPLOYEE;

-- 그룹함수 : 컬럼에 기록된 N개의 값을 읽어서 1개의 결과를 리턴하는 함수
-- 급여 합계, 급여 평균
SELECT SUM(SALARY), AVG(SALARY)
FROM EMPLOYEE;

-- 단일행 함수와 그룹함수는 SELECT 절에서 함께 사용 못 함
-- 오라클은 객체관계형 DB 임 : 결과가 반드시 2차원 테이블 구조여야함 (사각형이어야 함)

SELECT UPPER(EMAIL), AVG(SALARY)
FROM EMPLOYEE;  -- ERROR

-- WHERE 절에서는 단일행 함수만 사용 가능함
-- 예 : 전체 직원의 급여의 평균보다 급여를 많이 받는 직원 조회
SELECT *
FROM EMPLOYEE
WHERE SALARY > AVG(SALARY); -- 서브쿼리 사용하면 처리가능

-- 서브쿼리를 이용하면 해결할 수 있음
SELECT *
FROM EMPLOYEE
WHERE SALARY >  (SELECT AVG(SALARY) FROM EMPLOYEE);

-- 단일행 함수 테스트
-- 문자열 관련 함수
-- LENGTH('문자열값' | 문자열이 기록된 컬럼명) : 글자갯수를 리턴함

SELECT LENGTH('ORACLE')
FROM DUAL;

SELECT LENGTH(EMAIL)
FROM EMPLOYEE;

-- LENGTH() 함수를 이용해서, CHAR 자료형(고정길이 문자열)과 VARCHAR2 (가변길이 문자열) 차이점 비교
CREATE TABLE LENGTH_TEST(
  VALUE1 CHAR(10),
  VALUE2 VARCHAR2(10)
);

INSERT INTO LENGTH_TEST (VALUE1, VALUE2)
VALUES ('ORACLE', 'ORACLE');

COMMIT;

SELECT * FROM LENGTH_TEST;
SELECT LENGTH(VALUE1), LENGTH(VALUE2) FROM LENGTH_TEST;

SELECT LENGTH(CHARTYPE), LENGTH(VARCHARTYPE)
FROM COLUMN_LENGTH;

-- LENGTHB('문자열값' | 문자열이 기록된 컬럼명) 함수 : 기록된 문자열 바이트의 크기를 리턴함
SELECT LENGTHB(CHARTYPE), LENGTHB(VARCHARTYPE)
FROM COLUMN_LENGTH;

-- INSTR('문자열값' | 문자열이 기록된 컬럼명, '찾을문자'[, 찾을 시작위치, 몇번째문자])
-- 찾는 문자의 위치가 리턴됨.
SELECT EMAIL, INSTR(EMAIL, '@')
FROM EMPLOYEE;

-- 이메일 주소에서 '@' 문자 바로 뒤에 있는 'K' 문자의 위치를 조회
-- 단 뒤에서 부터 검색함
SELECT EMAIL, INSTR(EMAIL, 'k', -1, 3)
FROM EMPLOYEE;


-- 함수의 중첩 사용 가능함 : 함수 안에 함수 사용
-- 이메일 주소에서 '.' 바로 뒤 문자의 위치 조회
-- 단 '.' 문자 바로 앞 글자부터 검색 시작하도록 함
SELECT EMAIL, INSTR(EMAIL, 'c', INSTR(EMAIL, '.') -1)
FROM EMPLOYEE;

-- LPAD/RPAD('문자열' | 문자열이 기록된 컬럼명, 출력너비 바이트수, '채울문자')
-- 남는 영역을 채울문자로 채움(기본은 공백문자)

SELECT EMAIL AS 원본데이터, LENGTH(EMAIL) AS 원본길이,
LPAD(EMAIL, 20, '*') AS 채우기결과, 
LENGTH(LPAD(EMAIL, 20, '*')) AS 결과길이
FROM EMPLOYEE;

SELECT EMAIL AS 원본데이터,
LENGTH(EMAIL) AS 원본길이,
RPAD(EMAIL, 20, '*') AS 적용결과,
LENGTH(RPAD(EMAIL, 20, '*')) AS 결과길이
FROM EMPLOYEE;

SELECT LTRIM('   tech') FROM DUAL;
SELECT LTRIM('   tech', ' ') FROM DUAL; 
SELECT LTRIM('000123', '0') FROM DUAL;
SELECT LTRIM('123123Tech', '123') FROM DUAL; 
SELECT LTRIM('xyxzyyyTech', 'xyz') FROM DUAL; 
SELECT LTRIM('6372Tech', '0123456789') FROM DUAL;

SELECT RTRIM('tech   ') FROM DUAL;
SELECT RTRIM('tech   ', ' ') FROM DUAL; 
SELECT RTRIM('123000', '0') FROM DUAL;
SELECT RTRIM('Tech123123', '123') FROM DUAL;
SELECT RTRIM('Techxyxzyyy', 'xyz') FROM DUAL; 
SELECT RTRIM('Tech6372', '0123456789') FROM DUAL;

SELECT TRIM('  tech  ') FROM DUAL;
SELECT TRIM('a' FROM 'aatechaaa') FROM DUAL; 
SELECT TRIM(LEADING '0' FROM '000123') FROM DUAL;
SELECT TRIM(TRAILING '1' FROM 'Tech1') FROM DUAL; 
SELECT TRIM(BOTH '1' FROM '123Tech111') FROM DUAL;
SELECT TRIM(LEADING FROM '  Tech  ') FROM DUAL;

SELECT SUBSTR('This is a test', 6, 2) FROM DUAL;
SELECT SUBSTR('This is a test', 6) FROM DUAL;
SELECT SUBSTR('이것은 연습입니다', 3, 4) FROM DUAL;
SELECT SUBSTR('TechOnTheNet', 1, 4) FROM DUAL;
SELECT SUBSTR('TechOnTheNet', -3, 3) FROM DUAL;
SELECT SUBSTR('TechOnTheNet', -6, 3) FROM DUAL;
SELECT SUBSTR('TechOnTheNet', -8, 2) FROM DUAL;

-- 직원들의 주민번호에서 생년, 생월, 생일을 각각 분리 조회
SELECT SUBSTR(EMP_NO, 1, 2) 생년, SUBSTR(EMP_NO, 3, 2) 생월, SUBSTR(EMP_NO, 5, 2) 생일
FROM EMPLOYEE;

-- 날짜 데이터에도 사용할 수 있음
-- 직원들의 입사일에서 입사년도, 입사월, 입사일을 분리 조회

SELECT SUBSTR(HIRE_DATE, 1, 2) 입사년도, SUBSTR(HIRE_DATE, 4, 2) 입사월, SUBSTR(HIRE_DATE, 7, 2) 입사년도
FROM EMPLOYEE;

-- SUBSTRB('문자열값' | 문자열이 기록된 컬럼명, 추출할 바이트위치, 추출할 바이트)
SELECT SUBSTR('ORACLE', 3, 2), SUBSTRB('ORACLE', 3, 2)
FROM DUAL;

SELECT SUBSTR('오라클', 2, 2), SUBSTRB('오라클', 4, 6)
FROM DUAL;

-- UPPER('문자열값' | 컬럼명) : 대문자로 바꾸는 함수
-- LOWER('문자열값' | 컬럼명) : 소문자로 바꾸는 함수
-- INITCAP('문자열값' | 컬럼명) : 첫글자만 대문자로 바꾸는 함수
SELECT UPPER('ORACLE'), UPPER('oracle'),
        LOWER('ORACLE'), LOWER('oracle'),
        INITCAP('ORACLE'), INITCAP('oracle')
FROM DUAL;

-- 함수 중첩 사용
-- 직원 정보에서 이름, 아이디를 조회
-- 아이디는 이메일에서 아이디 분리 추출함

SELECT EMP_NAME 이름, SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1) 아이디
FROM EMPLOYEE;

-- 직원 테이블에서 사원명, 주민번호 조회
-- 주민번호는 생년월일만 보이게 하고 뒷자리 값은 '*' 로 처리함 : 781125-*******

SELECT EMP_NAME 사원명, RPAD(SUBSTR(EMP_NO, 1 , 7), 14, '*') 주민번호
FROM EMPLOYEE;


-- 숫자처리함수 : ROUND, TRUNC, FLOOR, ABS, MOD

-- ROUND(숫자값 | 숫자가 기록된 컬럼명 | 계산식, 반올림한 자릿수)
-- 버려지는 값이 5이상이면 자동 반올림됨
-- 자릿수가 양수이면 소숫점 아래 자리를 의미함
-- 자릿수가 음수이면 소숫점 왼쪽 정수 자리를 의미함.

SELECT ROUND(125.315) FROM DUAL; 
SELECT ROUND(125.315, 0) FROM DUAL;
SELECT ROUND(125.315, 1) FROM DUAL;
SELECT ROUND(125.315, -1) FROM DUAL;
SELECT ROUND(125.315, 3) FROM DUAL; 
SELECT ROUND(-125.315, 2) FROM DUAL;

-- 직원 정보에서 사번, 이름, 급여, 보너스포인트, 보너스포인트가 적용된 연봉 조회
-- 연봉은 별칭 : 1년급여
-- 연봉은 천단위에서 반올림함

SELECT EMP_ID, EMP_NAME, SALARY, BONUS_PCT, ROUND((SALARY+(SALARY * NVL(BONUS_PCT, 0))) * 12, -4) "1년급여"
FROM EMPLOYEE;

-- TRUNC (숫자값 | 숫자가 기록된 컬럼명 | 계산식, 버릴 자릿수)
-- 반올림 없음
SELECT TRUNC(125.315), TRUNC(125.315, 0), TRUNC(125.315, 1),
TRUNC(125.315, -1), TRUNC(125.315, 3), TRUNC(-125.315, -3)
FROM DUAL; 

SELECT TRUNC(125.315) FROM DUAL; --125
SELECT TRUNC(125.315, 0) FROM DUAL;-- 125
SELECT TRUNC(125.315, 1) FROM DUAL; --125.3
SELECT TRUNC(125.315, -1) FROM DUAL; --120
SELECT TRUNC(125.315, 3) FROM DUAL; --125.315
SELECT TRUNC(-125.315, -3) FROM DUAL; 

-- 직언정보에서 급여의 평균을 구함
-- 10자리까지는 절삭함
SELECT TRUNC(AVG(SALARY), -2), FLOOR(AVG(SALARY))
FROM EMPLOYEE;

-- FLOOR(숫자값 | 숫자가 기록된 컬럼명 | 계산식) : 소숫점 아래값 버리는 함수 (정수 만드는 함수)
SELECT ROUND(123.5), TRUNC(123.5), FLOOR(123.5)
FROM DUAL;

-- ASB(숫자값 | 숫자가 기록된 컬럼명 | 계산식) : 절대값(모든 수의 양수) 구하는 함수
-- 음수가 양수로 바뀜
SELECT ABS(123), ABS(-123)
FROM DUAL;

-- 입사일 - 오늘날짜, 오늘날짜 - 입사일 = 총근무일수 (별칭)
-- 근무일수를 정수로 처리, 모두 양수로 처리함

SELECT ABS(FLOOR(HIRE_DATE-SYSDATE)) 총근무일수, ABS(FLOOR(SYSDATE-HIRE_DATE)) 총근무년수
FROM EMPLOYEE;

-- MOD(나눌값, 나눌수) : 나누기한 나머지를 구하는 함수
SELECT FLOOR(25 / 7), MOD(25, 7) FROM DUAL;

-- 사번이 홀수인 직원 정보 조회
SELECT *
FROM EMPLOYEE
WHERE MOD(EMP_ID, 2) = 1;

-- 주민번호로 여자 직원들의 정보 조회
SELECT *
FROM EMPLOYEE
WHERE MOD(SUBSTR(EMP_NO, 8, 1), 2) = 0;