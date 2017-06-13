-- DAY6 수업내용 : JOIN

-- 조인 (JOIN) : 여러개의 테이블을 하나의 큰 테이블로 만든 다음, 원하는 결과를 선택
-- 오라클에서만 사용하는 오라클 전용 구문과 모든 DBMS가 공통으로 사용하는 표준구문인 
-- ANSI 표준구문으로 표현할 수 있음

-- 오라클 전용구문 : 합칠 테이블명들을 FROM 절에 , 로 구분해서 나열함
-- 테이블을 합치기 위한 컬럼명과 조건식을 WHERE 절에 명시함

SELECT * 
FROM EMPLOYEE, DEPARTMENT
WHERE EMPLOYEE.DEPT_ID = DEPARTMENT.DEPT_ID;

SELECT *
FROM EMPLOYEE E, DEPARTMENT D
WHERE E.DEPT_ID = D.DEPT_ID;

SELECT EMP_NAME, E.DEPT_ID, DEPT_NAME
FROM EMPLOYEE E, DEPARTMENT D
WHERE E.DEPT_ID = D.DEPT_ID;

-- ANSI 표준구문 : 조인 처리를 위한 구문을 별도로 기술함
-- 모든 DBMS 가 공통으로 사용하는 구문임
SELECT *
FROM EMPLOYEE
JOIN DEPARTMENT USING (DEPT_ID);

SELECT EMP_NAME, DEPT_ID, DEPT_NAME
FROM EMPLOYEE
INNER JOIN DEPARTMENT USING (DEPT_ID);

SELECT *
FROM DEPARTMENT
JOIN LOCATION ON (LOC_ID = LOCATION_ID);

-- 오라클 전용구문으로 변경
SELECT * 
FROM DEPARTMENT D, LOCATION L
WHERE D.LOC_ID = L.LOCATION_ID;

-- 사번, 사원명, 직급명 조회
-- 오라클 전용구문
SELECT EMP_ID, EMP_NAME, JOB_TITLE
FROM EMPLOYEE E, JOB J
WHERE E.JOB_ID = J.JOB_ID;

-- ANSI 표준구문
SELECT EMP_ID, EMP_NAME, JOB_TITLE
FROM EMPLOYEE
JOIN JOB USING(JOB_ID);

-- USING 에 여러 개의 컬럼을 나열 기술할 수도 있음
SELECT *
FROM EMPLOYEE2
JOIN DEPARTMENT USING(DEPT_ID, LOC_ID);
-- 2개의 컬럼값을 하나의 값으로 보고, 같은 값을 찾아서 조인함

-- 조인은 기본이 EQUAL JOIN 임.
-- 연결되는 컬럼의 값이 일치하는 행들만 조인함
-- INNER JOIN 도 EQUAL JOIN임.

-- OUTER JOIN
-- EQUAL JOIN 이면서, 두 테이블의 지정한 컬럼의 값이 일치하지 않는 행도 조인에 포함함

-- 오라클 전용 구문
SELECT *
FROM EMPLOYEE E, DEPARTMENT D
WHERE E.DEPT_ID = D.DEPT_ID(+);

-- ANSI 표준구문
SELECT *
FROM EMPLOYEE
LEFT OUTER JOIN DEPARTMENT USING (DEPT_ID);

-- DEPARTMENT 가 가진 모든 행을 조인에 포함하고자 할 경우
SELECT *
FROM EMPLOYEE E, DEPARTMENT D
WHERE E.DEPT_ID(+) = D.DEPT_ID;

SELECT * 
FROM EMPLOYEE
RIGHT OUTER JOIN DEPARTMENT USING (DEPT_ID);

-- FULL OUTER JOIN
-- 양쪽 테이블의 해당 컬럼의 모든 값들을 조인의 결과에 포함시킴
SELECT *
FROM EMPLOYEE
FULL OUTER JOIN DEPARTMENT USING (DEPT_ID);

-- 오라클 전용구문은 표현 못 함
SELECT *
FROM EMPLOYEE E, DEPARTMENT D
WHERE E.DEPT_ID(+) = D.DEPT_ID(+);

-- CROSS JOIN : 두 테이블을 연결할 컬럼이 없는 경우에 사용함
-- 조인할 조건 컬럼이 없을 때 사용
-- 결과는 테이블1의 행수 X 테이블2의 행수
SELECT *
FROM LOCATION
CROSS JOIN COUNTRY;

-- NON EQUI JOIN
-- 지정하는 컬럼의 값이 일치하는 경우가 아닌, 값의 범위에 포함되는 행들을 연결하는 방식
SELECT *
FROM EMPLOYEE
JOIN SAL_GRADE ON (SALARY BETWEEN LOWEST AND HIGHEST);

-- SELF JOIN : 같은 테이블을 두 번 조인하는 경우
-- 같은 테이블 안의 기본키 컬럼값을 참조하는 외부참조키 컬럼이 있을 경우에 주로 사용함

SELECT * 
FROM EMPLOYEE
WHERE MGR_ID IS NOT NULL;

-- 직원이름과 그 직원의 관리자 이름 조회
SELECT E.EMP_NAME AS 직원, M.EMP_NAME AS 관리자
FROM EMPLOYEE E
JOIN EMPLOYEE M ON (E.MGR_ID = M.EMP_ID);

-- N 개의 테이블 조인
SELECT EMP_NAME, JOB_TITLE, DEPT_NAME, LOC_DESCRIBE, COUNTRY_NAME
FROM EMPLOYEE
JOIN JOB USING (JOB_ID)
JOIN DEPARTMENT USING (DEPT_ID)
JOIN LOCATION ON (LOC_ID = LOCATION_ID)
JOIN COUNTRY USING (COUNTRY_ID);

-- 직급이 대리이면서, 아시아지역에 근무하는 직원 조회
-- 사번, 이름, 직급명, 부서명, 근무지역명, 급여 조회
SELECT EMP_ID 사번, EMP_NAME 이름, JOB_TITLE 직급명, DEPT_NAME 부서명, SALARY 급여
FROM EMPLOYEE
JOIN JOB USING (JOB_ID)
JOIN DEPARTMENT USING (DEPT_ID)
JOIN LOCATION ON (LOC_ID = LOCATION_ID)
WHERE JOB_TITLE ='대리' AND LOC_DESCRIBE LIKE '아시아%';

--JOIN 연습문제
--
--1. 2020년 12월 25일이 무슨 요일인지 조회하시오.
SELECT TO_CHAR(TO_DATE('20201225', 'YYYYMMDD'), 'DAY') FROM DUAL;

--2. 주민번호가 60년대 생이면서 성별이 여자이고, 성이 김씨인 직원들의 
--사원명, 주민번호, 부서명, 직급명을 조회하시오.
SELECT EMP_NAME, EMP_NO, DEPT_NAME, JOB_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT USING (DEPT_ID)
JOIN JOB USING (JOB_ID)
WHERE SUBSTR(EMP_NO, 1, 1) LIKE '6' AND SUBSTR(EMP_NO, 8, 1) LIKE '2' AND SUBSTR(EMP_NAME, 1, 1) LIKE '김';

SELECT MIN(TRUNC((MONTHS_BETWEEN(SYSDATE, TO_DATE(SUBSTR(EMP_NO, 1, 2), 'RR')) / 12))) 나이 FROM EMPLOYEE;

--3. 가장 나이가 적은 직원의 사번, 사원명, 나이, 부서명, 직급명을 조회하시오.
SELECT
    T.*
FROM (SELECT
        E.EMP_ID, 
        E.EMP_NAME, 
        EXTRACT(YEAR FROM SYSDATE) - TO_NUMBER('19' || SUBSTR(E.EMP_NO, 1, 2)) 나이, 
        D.DEPT_NAME, 
        J.JOB_TITLE
        FROM EMPLOYEE E 
        LEFT JOIN DEPARTMENT D ON E.DEPT_ID = D.DEPT_ID
        LEFT JOIN JOB J ON E.JOB_ID = J.JOB_ID
        ORDER BY AGE ASC
    ) T
WHERE ROWNUM = 1;


--4. 이름에 '성'자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하시오.
SELECT EMP_ID, EMP_NAME, DEPT_NAME
FROM EMPLOYEE
JOIN DEPARTMENT USING (DEPT_ID)
WHERE EMP_NAME LIKE '성%';

SELECT E.EMP_ID, E.EMP_NAME, D.DEPT_NAME
FROM EMPLOYEE E
JOIN DEPARTMENT D on E.DEPT_ID = D.DEPT_ID 
WHERE E.EMP_NAME LIKE '성%';

--5. 해외영업팀에 근무하는 사원명, 직급명, 부서코드, 부서명을 조회하시오.
SELECT EMP_NAME, JOB_TITLE, DEPT_ID, DEPT_NAME
FROM EMPLOYEE
JOIN DEPARTMENT USING (DEPT_ID)
JOIN JOB USING (JOB_ID)
WHERE DEPT_NAME LIKE '해외영업%';

--6. 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하시오.
SELECT EMP_NAME, BONUS_PCT, DEPT_NAME, LOC_DESCRIBE
FROM EMPLOYEE
JOIN DEPARTMENT USING (DEPT_ID)
JOIN LOCATION ON (LOC_ID = LOCATION_ID)
WHERE BONUS_PCT IS NOT NULL;

--7. 부서코드가 20인 직원들의 사원명, 직급명, 부서명, 근무지역명을 조회하시오.
SELECT EMP_NAME, JOB_TITLE, DEPT_NAME, LOC_DESCRIBE
FROM EMPLOYEE
JOIN JOB USING (JOB_ID)
JOIN DEPARTMENT USING (DEPT_ID)
JOIN LOCATION ON (LOC_ID = LOCATION_ID)
WHERE DEPT_ID = '20';

--8. 직급별 연봉의 최소급여(MIN_SAL)보다 많이 받는 직원들의
--사원명, 직급명, 급여, 연봉을 조회하시오.
--연봉에 보너스포인트를 적용하시오.
SELECT EMP_NAME, JOB_TITLE, SALARY, (SALARY+(SALARY * NVL(BONUS_PCT, 0)))*12 연봉
FROM EMPLOYEE
JOIN JOB USING (JOB_ID)
WHERE (SALARY+(SALARY * NVL(BONUS_PCT, 0)))*12 > MIN_SAL;

--9. 한국(KO)과 일본(JP)에 근무하는 직원들의 
--사원명(emp_name), 부서명(dept_name), 지역명(loc_describe), 국가명(country_name)을 조회하시오.
SELECT EMP_NAME, DEPT_NAME, LOC_DESCRIBE, COUNTRY_NAME
FROM EMPLOYEE
JOIN DEPARTMENT USING (DEPT_ID)
JOIN LOCATION ON (LOC_ID = LOCATION_ID)
JOIN COUNTRY USING (COUNTRY_ID)
WHERE COUNTRY_ID IN ('KO', 'JP');


--10. 같은 부서에 근무하는 직원들의 사원명, 부서코드, 동료이름을 조회하시오.
--self join 사용
SELECT E.EMP_NAME, E.DEPT_ID, E1.EMP_NAME
FROM EMPLOYEE E
JOIN EMPLOYEE E1 ON (E.DEPT_ID = E1.DEPT_ID);

--11. 보너스포인트가 없는 직원들 중에서 직급코드가 J4와 J7인 직원들의 사원명, 직급명, 급여를 조회하시오.
--단, join과 IN 사용할 것
SELECT EMP_NAME, JOB_TITLE, SALARY
FROM EMPLOYEE
JOIN JOB USING (JOB_ID)
WHERE BONUS_PCT IS NULL AND JOB_ID IN ('J4', 'J7');

--12. 기혼인 직원과 미혼인 직원의 수를 조회하시오.
SELECT DISTINCT MARRIAGE 결혼여부, COUNT(*) 명
FROM EMPLOYEE
GROUP BY MARRIAGE;

SELECT
    SUM(T.Y) AS Y,
    SUM(T.N) AS N
FROM
(SELECT 
    SUM(CASE WHEN MARRIAGE = 'Y' THEN 1 ELSE 0 END) AS Y,
     SUM(CASE WHEN MARRIAGE = 'N' THEN 1 ELSE 0 END) AS N
FROM EMPLOYEE 
GROUP BY MARRIAGE) T;

