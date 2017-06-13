-- DAY1 수업내용 
/*
  오라클 Express edition 모듈에서는 한글 1글자가 3바이트임.
  LENGTH('문자열값') : 글자수 조회시 사용
  LENGTHB('문자열값') : 글자의 바이트수 조회시 사용하는 함수임.
*/

select length('오라클'), LENGTHB('오라클'),
        length('ORACLE'), LENGTHB('ORACLE')
FROM DUAL;  -- DUMMY TABLE(가짜 테이블명)


-- SYSDATE 함수 : 현재 날짜 조회시 사용하는 날짜 함수
select sysdate, sysdate + 1000, sysdate - 100, (sysdate - 50)-sysdate from DUAL;

0select FLOOR((sysdate - to_date('88/11/15', 'RR/MM/DD'))/365) from DUAL;



-- 현재 DB의 셋팅정보 조회시
SELECT * FROM V$NLS_PARAMETERS;

-- ****************************************************************************
-- DQL(Data Query Language) : select 문
-- 데이터 조회용 쿼리문

select EMP_ID, EMP_NAME, SALARY
from EMPLOYEE;

select *
from EMPLOYEE
where JOB_ID = 'J7'
order by SALARY asc;

select EMP_ID, EMP_NAME, SALARY, HIRE_DATE
from EMPLOYEE
where DEPT_ID = '90'
order by HIRE_DATE asc;

select EMP_NO, EMP_NAME, DEPT_NAME
from EMPLOYEE
join DEPARTMENT using(DEPT_ID)
where DEPT_ID = '90';

select * from EMPLOYEE
where DEPT_ID = '30'; -- RESULT set 이 0개일수도 있음.

/*
  SELECT 구문 형식
  
  5 SELECT  DISTINCT 컬럼명, 계산식, 함수식(컬럼명) AS 별칭, * 
  1 FROM  테이블명
  2 WHERE 컬럼명 비교연산자 비교값
  3 GROUP BY  컬럼명
  4 HAVING  그룹함수 비교연산자 비교값
  6 ORDER BY  컬럼명 정렬방식;
*/


-- 테이블의 모든 데이터 조회시
select * from EMPLOYEE;
select * from DEPARTMENT;
select * from JOB;
select * from LOCATION;
select * from COUNTRY;

-- 컬럼값의 중복값들은 한 개씩만 선택할 경우 : DISTINCT 컬럼명
select DISTINCT JOB_ID
from EMPLOYEE
order by JOB_ID asc;

select DISTINCT DEPT_ID, JOB_ID
from EMPLOYEE
order by DEPT_ID ASC;

-- 계산식 사용한 경우
-- 계산값이 NULL이면 결과도 NULL임.

SELECT EMP_NAME, SALARY*12, (SALARY+(SALARY*BONUS_PCT))*12
FROM EMPLOYEE;

-- 보너스포인트가 NULL이면, 보너스포인트 없다를 의미하므로
-- 계산식에 보너스포인트를 0을 적용하면 될 것임 : NVL (컬럼명, 바꿀값) 함수 사용함

SELECT EMP_NAME, SALARY*12 "1년급여", (SALARY+(SALARY*NVL(BONUS_PCT, 0)))*12 AS 총소득

FROM EMPLOYEE;

