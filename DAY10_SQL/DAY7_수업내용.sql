-- DAY7 수업내용

-- SET OPERATOR (집합 연산자)
-- UNION (합집합), UNION ALL, INTERSECT (교집합), MINUS (차집합)
-- 여러 개의 SELECT 문의 결과를 합칠 때 사용하는 연산자임.
-- 합집합 : UNION, UNION ALL (RESULT SET 을 하나로 합침)
-- 교집합 : INTERSECT (각 RESULT SET 의 공통된 결과만 선택함)
-- 차집합 : MINUS (첫번째 RESULT SET 에서 두번째 RESULT SET 과 일치하는 결과를 뺌)

-- UNION : 일치하는 결과는 하나만 결과로 포함
SELECT EMP_ID, ROLE_NAME
FROM EMPLOYEE_ROLE
UNION
SELECT EMP_ID, ROLE_NAME
FROM ROLE_HISTORY;

-- UNION ALL : 모든 결과를 합침
SELECT EMP_ID, ROLE_NAME
FROM EMPLOYEE_ROLE
UNION ALL
SELECT EMP_ID, ROLE_NAME
FROM ROLE_HISTORY;

-- INTERSECT : 중복되는 결과만 선택
SELECT EMP_ID, ROLE_NAME
FROM EMPLOYEE_ROLE
INTERSECT
SELECT EMP_ID, ROLE_NAME
FROM ROLE_HISTORY;

-- MINUS : 첫번째 쿼리 결과에서 두번째 쿼리 결과와 중복되는 행을 제외함
SELECT EMP_ID, ROLE_NAME
FROM EMPLOYEE_ROLE
MINUS
SELECT EMP_ID, ROLE_NAME
FROM ROLE_HISTORY;

-- SET 연산자사용시 주의사항
-- SELECT 절에 컬럼갯수가 반드시 같아야 함 : 더미 (DUMMY) 컬럼으로 갯수를 맞출수도 있음
-- 각 SELECT 절에 나열된 컬럼별 자료형이 반드시 같아야 함

SELECT EMP_NAME, JOB_ID, HIRE_DATE
FROM EMPLOYEE
WHERE DEPT_ID = '20';

SELECT DEPT_NAME, DEPT_ID
FROM DEPARTMENT
WHERE DEPT_ID = '20';

-- 50번 부서에 소속된 직원 중 관리자와 일반 직원을 따로 조회해서 하나로 합쳐라.
SELECT EMP_ID, EMP_NAME, '관리자' AS 구분
FROM EMPLOYEE
WHERE DEPT_ID = '50' AND EMP_ID = '141'
UNION
SELECT EMP_ID, EMP_NAME, '직원' AS 구분
FROM EMPLOYEE
WHERE DEPT_ID = '50' AND EMP_ID <> '141'
ORDER BY 3, 1;  -- 맨 마지막에 딱 한 번 사용할 수 있음.

SELECT 'SQL을 공부하고 있습니다' 문장, 3 순서
FROM DUAL
UNION
SELECT '우리는 지금', 1
FROM DUAL
UNION
SELECT '아주 재미있게', 2
FROM DUAL;

SELECT 'SQL을 공부하고 있습니다' 문장, 3 순서 FROM DUAL
UNION
SELECT '우리는 지금', 1 FROM DUAL
UNION
SELECT '아주 재미있게', 2 FROM DUAL
ORDER BY 2;

SELECT 'SQL을 공부하고 있습니다' 문장, 3 순서 FROM DUAL
UNION
SELECT '우리는 지금', 1 FROM DUAL
UNION
SELECT '아주 재미있게', 2 FROM DUAL
ORDER BY 순서;

-- 집합 연산자와 JOIN의 관계
SELECT EMP_ID, ROLE_NAME
FROM EMPLOYEE_ROLE
INTERSECT
SELECT EMP_ID, ROLE_NAME
FROM ROLE_HISTORY;

-- USING (EMP_ID, ROLE_NAME)
-- 두 컬럼의 값을 하나의 값으로 생각하고 일치하는 항목을 찾음
-- (104, SE) = (104, SE) : 같은 값
-- (104, SE-ANLY) != (104, SE) : 다른 값

SELECT EMP_ID, ROLE_NAME
FROM EMPLOYEE_ROLE
JOIN ROLE_HISTORY USING (EMP_ID, ROLE_NAME);

-- 집합 연산자의 IN 연산자의 관계
-- UNION 과 IN 이 서로 동일한 결과를 만들 수 있음
-- 직급이 대리 또는 사원인 직원의 이름과 직급명을 조회
-- 직급순 오름차순 정렬, 같은 직급일 경우 이름순 오름차순 정렬 처리함

SELECT EMP_NAME, JOB_TITLE
FROM EMPLOYEE
JOIN JOB USING (JOB_ID)
WHERE JOB_TITLE IN ('대리', '사원')
ORDER BY 2, 1;

-- UNION 으로 바꾸면
SELECT EMP_NAME, JOB_TITLE
FROM EMPLOYEE
JOIN JOB USING (JOB_ID)
WHERE JOB_TITLE = '대리'
UNION
SELECT EMP_NAME, JOB_TITLE
FROM EMPLOYEE
JOIN JOB USING (JOB_ID)
WHERE JOB_TITLE = '사원'
ORDER BY 2, 1;

-- 서브 쿼리 (SUB QUERY)
/*
    메소드(메소드()) : 안의 메소드가 리턴한 값을 바깥 메소드가 전달인자로 사용함
    쿼리문의 WHERE 절에서
        컬럼명 비교연산자 비교할값
        - 비교할 값이 쿼리문을 통해서 알아내야 하는 값일 때
        따 쿼리문을 작성해서 실행한 다음 결과값을 연산자 뒤에 기록함
        
        컬럼명 비교연산자 (비교할 값 알아내는 쿼리문)
        즉, 컬럼명 비교연산자 (SELECT 문....)
*/

--서브 쿼리 : 쿼리문 안에 사용된 쿼리문
-- 바깥 쿼리문을 메인쿼리라고 함

-- 예 : 나승원 이라는 직원과 같은 부서에 소속된 직원들의 명단을 조회
-- 1. 나승원이 소속된 부서 조회
SELECT DEPT_ID
FROM EMPLOYEE
WHERE EMP_NAME = '나승원';

-- 2. 조회된 결과값을 가지고 부서원들을 조회
SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_ID = '50';

-- 서브쿼리를 이용하면
SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_ID = (SELECT DEPT_ID
                 FROM EMPLOYEE
                 WHERE EMP_NAME = '나승원');

-- 서브쿼리의 유형은 단일행 서브쿼리, 다중행 서브쿼리, 다중열 서브쿼리,
-- 다중행 다중열 서브쿼리, 상호연관 서브쿼리, 스칼라 서브쿼리 등으로 구분됨.
-- 서브쿼리 유형에 따라 서브쿼리 앞에 붙이는 연산자가 다름.

-- 단일행 (single row) 서브쿼리
-- 서브쿼리의 결과값이 한 개인 경우
-- 단일행 서브쿼리 앞에는 일반 비교연산자 모두 사용 가능함
-- <, >, <=, >=, =, !=/<>/^=

-- 예 : 나승원과 직급이 같으면서, 나승원보다 급여를 많이 받는 직원의 이름, 직급, 급여 조회
SELECT EMP_NAME, JOB_ID, SALARY
FROM EMPLOYEE
WHERE JOB_ID = (SELECT JOB_ID
                FROM EMPLOYEE
                WHERE EMP_NAME = '나승원')
AND SALARY > (SELECT SALARY
                FROM EMPLOYEE
                WHERE EMP_NAME = '나승원');

-- 부서별 급여의 합계중 가장 큰 값을 조회
-- 부서명, 급여합계 출력

SELECT T.*
FROM (SELECT DEPT_NAME, SUM(SALARY)
        FROM EMPLOYEE
        JOIN DEPARTMENT USING (DEPT_ID)
        GROUP BY DEPT_NAME
        ORDER BY 2 DESC) T
WHERE ROWNUM = 1;

SELECT DEPT_NAME, SUM(SALARY)
FROM EMPLOYEE
LEFT OUTER JOIN DEPARTMENT USING (DEPT_ID)
GROUP BY DEPT_NAME
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY))
                        FROM EMPLOYEE
                        GROUP BY DEPT_ID); -- 단일행 서브쿼리
                        
-- 서브쿼리는 일반적으로 SELECT절, FROM절 WHERE절, HAVING절에 주로 사용함
-- 예외적으로 ORDER BY 절에서도 사용할 수도 있음.

-- 다중행 서브쿼리 : 결과값의 갯수가 여러 개인 서브쿼리
-- 다중행 서브쿼리 앞에는 여러 개의 값을 비교 연산할 수 있는 연산자를 사용해야 함
-- 한 개의 값을 비교하는 일반 비교연산자 사용 못 함
-- IN/NOT IN, > ANY, < ANY, > ALL, < ALL 연산자를 주로 사용함

SELECT MGR_ID
FROM EMPLOYEE
WHERE MGR_ID IS NOT NULL;

SELECT EMP_ID, EMP_NAME, '관리자' AS 구분
FROM EMPLOYEE
WHERE EMP_ID IN (SELECT MGR_ID
                 FROM EMPLOYEE)
UNION
SELECT EMP_ID, EMP_NAME, '직원'
FROM EMPLOYEE
WHERE EMP_ID NOT IN (SELECT MGR_ID FROM EMPLOYEE
                     WHERE MGR_ID IS NOT NULL)
ORDER BY 3, 1;

-- 부서별로 그 부서의 최저 급여를 받고 있는 직원 조회
-- 부서별 최저 급여 조회
SELECT MIN(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_ID;

SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY IN (SELECT MIN(SALARY)
                 FROM EMPLOYEE
                 GROUP BY DEPT_ID);  -- 다중행 서브쿼리임

-- IN (값 여러 개) : 여러개의 값들 중에서 한 개라도 일치하는 값이 있으면
-- NOT IN (값 여러 개) : 여러개의 값들 중에 한개라도 일치하는 값이 없다면
-- > ANY (값 여러 개) : 여러 개의 값들 중에 한 개라도 큰 값이 있다면
--                     가장 작은 값보다 크냐 
-- < ANY (값 여러 개) : 여러 개의 값들 중에 한 개라도 작은 값이 있다면
--                     가장 큰 값보다 작으냐
-- = ANY (값 여러 개) : IN 연산자와 동일함
-- > ALL (값 여러 개) : 여러 개의 값들 모두보다 크냐 (가장 큰 값보다 크냐)
-- < ALL (값 여러 개) : 여러 개의 값들 모두보다 작으냐 (가장 작은 값보다 작으냐)
-- EXIST (값 여러 개) : 메인 쿼리에 값이 하나라도 존재하느냐 (결과는 TRUE / FALSE 임)
-- NOT EXIST (값 여러 개) : 메인 쿼리에 값이 존재하지 않느냐


-- SELECT 절에 서브쿼리를 사용할 수 있음
SELECT EMP_ID , EMP_NAME, CASE WHEN EMP_ID IN (SELECT MGR_ID
                                               FROM EMPLOYEE)
                          THEN '관리자' ELSE '직원' END AS 구분
FROM EMPLOYEE
ORDER BY 3, 1;

-- > ANY (다중행 서브쿼리) : 가장 작은 값보다 크냐
-- < ANY (다중행 서브쿼리) : 가장 큰 값보다 작으냐
-- 대리 직급의 직원중에서 과장 직급의 급여의 최소값보다 많이 받는 직원을 조회
-- 사번, 이름, 직급명, 급여
SELECT EMP_ID, EMP_NAME, JOB_TITLE, SALARY
FROM EMPLOYEE
JOIN JOB USING (JOB_ID)
WHERE JOB_TITLE = '대리' AND SALARY > ANY (SELECT SALARY
                                           FROM EMPLOYEE
                                           JOIN JOB USING (JOB_ID)
                                           WHERE JOB_TITLE = '과장');
                                           
-- > ALL (다중행 서브쿼리) : 가장 큰 값보다 크냐
-- < ALL (다중행 서브쿼리) : 가장 작은 값보다 작으냐

-- 과장 직급의 급여의 가장 큰 값보다 많이 받는 대리직급의 직원 조회
-- 사원명, 직급명, 급여

SELECT EMP_NAME, JOB_TITLE, SALARY
FROM EMPLOYEE
JOIN JOB USING (JOB_ID)
WHERE JOB_TITLE LIKE '대리'
AND SALARY > ALL (SELECT SALARY
                  FROM EMPLOYEE
                  JOIN JOB USING (JOB_ID)
                  WHERE JOB_TITLE LIKE '과장');
                                           
-- 서브쿼리 사용 위치 
-- SELECT 절, FROM 절, WHERE 절, GROUP BY 절, HAVING 절, ORDER BY 절
-- INSERT 문, UPDATE 문, CREATE TABLE 문, CREATE VIEW 문

-- 자기 직급의 평균 급여를 받고 있는 직원 조회
-- 사원명, 직급명, 급여
SELECT EMP_NAME, JOB_TITLE, SALARY
FROM EMPLOYEE
RIGHT JOIN JOB USING (JOB_ID)
WHERE SALARY IN (SELECT TRUNC(AVG(SALARY), -5)
                FROM EMPLOYEE
                GROUP BY JOB_ID);
                
-- FROM 절에서 서브쿼리 사용할 수 있음 : 테이블 대신에 사용함
-- 인라인 뷰(INLINE VIEW) 라고 함 : FROM 절에 사용된 서브쿼리의 결과 집합

-- ANSI 표준 사용시 테이블의 별칭 사용할 수 있음
-- ON 연산자 사용시에만 별칭 사용 가능함

-- 자기 직급의 평균 급여를 받는 직원 조회 : 인라인 뷰 사용
SELECT EMP_NAME, JOB_TITLE, SALARY
FROM (SELECT JOB_ID, TRUNC(AVG(SALARY), -5) JOBAVG
      FROM EMPLOYEE
      GROUP BY JOB_ID) V
LEFT JOIN EMPLOYEE E ON (V.JOBAVG = E.SALARY
                         AND NVL(V.JOB_ID, ' ') = NVL(E.JOB_ID, ' '))
LEFT JOIN JOB J ON (E.JOB_ID = J.JOB_ID)
ORDER BY 3, 2;

-- 대부분의 서브쿼리는 서브쿼리가 만든 값을 메인 쿼리가 사용하는 구조임
-- 상[호연]관 서브쿼리는 서브쿼리가 메인 쿼리의 컬럼값을 가져다 사용해서 결과를 만듦
-- 메인 쿼리의 컬럼값이 바뀌면, 서브쿼리의 결과도 달라짐

SELECT EMP_ID, EMP_NAME, '관리자' AS 구분
FROM EMPLOYEE E
WHERE EXISTS (SELECT NULL
              FROM EMPLOYEE
              WHERE E.EMP_ID = MGR_ID)
UNION
SELECT EMP_ID, EMP_NAME, '직원'
FROM EMPLOYEE E2
WHERE NOT EXISTS (SELECT NULL
                  FROM EMPLOYEE
                  WHERE E2.EMP_ID = MGR_ID)
ORDER BY 3, 1;

-- 자기 직급의 평균 급여를 받는 직원 조회 : 상관쿼리를 사용한 경우

SELECT EMP_NAME, JOB_TITLE, SALARY
FROM EMPLOYEE E
LEFT JOIN JOB J ON (E.JOB_ID = J.JOB_ID)
WHERE SALARY = (SELECT TRUNC(AVG(SALARY), -5)
                FROM EMPLOYEE
                WHERE NVL(JOB_ID, ' ') = NVL(E.JOB_ID, ' '))
ORDER BY 2;

-- 스칼라 서브쿼리 : 단일행 서브쿼리 + 상관쿼리
-- 한 행의 한 컬럼값만 리턴하는 상호연관 서브쿼리

-- 사원명, 부서코드, 급여, 해당 직원이 소속된 부서의 급여 평균을 구하라
SELECT EMP_NAME, DEPT_ID, SALARY,
(SELECT TRUNC(AVG(SALARY), -5) -- 소속부서의 급여평균값은 1개임
 FROM EMPLOYEE
 WHERE DEPT_ID = E.DEPT_ID) AS AVGSAL
FROM EMPLOYEE E;
              

-- CASE 표현식을 사용한 스칼라 서브쿼리
-- 부서의 근무지역이 'OT' 이면 '지역팀', 아니면 '본사팀' 으로 직원의 근무지역에 대한
-- 소속을 조회함
SELECT EMP_ID, EMP_NAME, CASE WHEN DEPT_ID = (SELECT DEPT_ID
                                              FROM DEPARTMENT
                                              WHERE LOC_ID = 'OT')
                         THEN '지역팀'
                         ELSE '본사팀' END 소속
FROM EMPLOYEE
ORDER BY 소속 DESC;



-- ORDER BY 절에 스칼라 서브쿼리 사용
-- 직원이 소속된 부서의 부서명이 큰 값부터 정렬해서 직원 정보 조회
SELECT EMP_ID ,EMP_NAME, DEPT_ID, HIRE_DATE
FROM EMPLOYEE E
ORDER BY (SELECT DEPT_NAME
            FROM DEPARTMENT
            WHERE DEPT_ID = E.DEPT_ID) DESC NULLS LAST;
            
-- TOP-N 분석
-- 상위 몇 개, 하위 몇 개를 조회할 때

-- 인라인 뷰와, RANK() 함수를 이용한 TOP-N 분석의 예
-- 직원들 중에서 급여를 가장 많이 받는 직원 5명 조회

SELECT *
FROM (SELECT EMP_NAME, SALARY,
      RANK() OVER(ORDER BY SALARY DESC) 순위
      FROM EMPLOYEE) V
WHERE 순위 <= 5;

-- ROWNUM 을 이용한 TOP-N 분석
-- ORDER BY 한 결과에 ROWNUM 을 붙임 (불가능 : 서브쿼리를 이용해야 함)
-- 행 번호(ROWNUM)는 FROM 절과 WHERE 절이 실행되고 부터 붙음

SELECT ROWNUM, EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
ORDER BY SALARY DESC;

-- 급여 많이 받는 직원 3명 조회
-- 행 번호, 이름, 급여
SELECT ROWNUM, EMP_NAME, SALARY
FROM (SELECT *
      FROM EMPLOYEE
      ORDER BY SALARY DESC)
WHERE ROWNUM < 4 ;