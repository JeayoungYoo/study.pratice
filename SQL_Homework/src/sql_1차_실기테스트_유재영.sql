
-- 1. 2001 년에 입학 한 사학과 학생이 몇 명인지 학생수를 조회하시오.
-- 사학과 코드는 TB_DEPARTMENT 에서 검색한다. (Join 을 사용하지 않는다.)
SELECT COUNT(*) 학생수1
FROM TB_STUDENT
WHERE ENTRANCE_DATE BETWEEN '01/01/01' AND '01/12/31'
      AND DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                           FROM TB_DEPARTMENT
                           WHERE DEPARTMENT_NAME LIKE '사학과');
                           
-- 2. 계열이 ‘공학’인 학과 중 입학정원이 20명 이상, 30명 이하인 학과의 계열, 학과이름, 정원을 조회하시오.
-- 단 학과이름을 기준으로 오름차순 정렬하시오.”
SELECT CATEGORY 계열, DEPARTMENT_NAME 학과이름, CAPACITY 정원
FROM TB_DEPARTMENT
WHERE CATEGORY LIKE '공학'
      AND CAPACITY BETWEEN 20 AND 30
ORDER BY DEPARTMENT_NAME ASC;

-- 3. ‘학’자가 들어간 계열의 소속 학과가 몇 개 있는지 계열, 학과수를 출력하시오.
-- 단 학과수가 많은 순으로 정렬하시오
SELECT CATEGORY 계열, COUNT(DEPARTMENT_NAME) 학과수
FROM TB_DEPARTMENT
WHERE CATEGORY LIKE '%학%'
GROUP BY CATEGORY
ORDER BY 학과수 DESC;

-- 4. ‘영어영문학과’ 교수이름, 출생년도, 주소를 조회하고 나이가 많은 순으로 정렬하시오.
-- 영어영문학과 코드는 TB_DEPARTMENT 에서 검색핚다. (Join 을 사용하지 않는다.) 
SELECT PROFESSOR_NAME 교수이름, SUBSTR(PROFESSOR_SSN, 1, 2) 출생년도, PROFESSOR_ADDRESS 주소
FROM TB_PROFESSOR
WHERE DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                       FROM TB_DEPARTMENT
                       WHERE DEPARTMENT_NAME LIKE '영어영문학과')
ORDER BY 2;

-- 5. 국어국문학과 학생 중 서울에 거주하는 학생의 학과번호, 학생이름, 휴학여부를 조회하고 
-- 학생이름으로 오름차순 정렬하시오. 단 휴학여부는 값이 ‘Y’이면 ‘휴학’으로 ‘N’이면 ‘정상’으로 출력핚다.
-- 국어국문학과 코드는 TB_DEPARTMENT 에서 찾는다. (Join 을 사용하지 않는다)
SELECT DEPARTMENT_NO 학과번호, STUDENT_NAME 학생이름, CASE ABSENCE_YN WHEN 'Y' THEN '휴학'
                                                                    ELSE '정상' END AS 휴학여부
FROM TB_STUDENT
WHERE STUDENT_ADDRESS LIKE '서울%'
      AND DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                           FROM TB_DEPARTMENT
                           WHERE DEPARTMENT_NAME LIKE '국어국문학과');

-- 6. 80년생인 여학생 중 성이 ‘김’씨인 학생의 주민번호, 학생이름을 조회하시오. 
-- 단 학생이름으로 오름차순 정렬하시오.      
SELECT '['||SUBSTR(STUDENT_SSN,1,8)||'******]' 주민번호, STUDENT_NAME 학생이름
FROM TB_STUDENT
WHERE STUDENT_NAME LIKE '김%'
      AND SUBSTR(STUDENT_SSN, 8, 1) LIKE '2';
      
-- 7. 계열이 ‘예체능’인 학과의 정원을 기준으로 40 명 이상이면 ‘대강의실’, 30 명 이상이면 ‘중강의실’,
-- 30명 미만이면 ‘소강의실’로 출력핚다. 단, 정원이 많은 순으로 정렬 핚다.
SELECT DEPARTMENT_NAME 학과이름, CAPACITY 정원, CASE WHEN CAPACITY >= 40 THEN '대강의실'
                                                   WHEN CAPACITY >= 30 THEN '중강의실'
                                                   ELSE '소강의실' END AS 강의실크기
FROM TB_DEPARTMENT
WHERE CATEGORY LIKE '예체능'
ORDER BY 2 DESC;


-- 8. 주소지가 ‘경기’ 또는 ‘인천’인 학생 중 1900년대에 입학 핚 학생들을 조회 하고자 한다.
-- 오늘날짜를 기준 으로 입학 후 기간을 계산하여 입학 후 기간이 오래된 순으로 정렬 한다.
-- (단 입학 후 기간의 단위는 년(年)으 로 하고, 소수점 이하 자리는 버린다. 
-- 또한 입학 후 기간이 같을 경우 이름으로 오름차순 정렬핚다.)
SELECT STUDENT_NAME 학생이름, TO_CHAR(ENTRANCE_DATE, 'YY"년"MM"월"DD"일"') 입학일자, TRUNC(MONTHS_BETWEEN(SYSDATE, ENTRANCE_DATE)/12, 0) "입학후기간(년)"
FROM TB_STUDENT
WHERE (ENTRANCE_DATE < '2000/01/01' AND SUBSTR(STUDENT_NO, 1, 1) <> 'A')
      AND (STUDENT_ADDRESS LIKE '%인천%' OR STUDENT_ADDRESS LIKE '%경기%')
ORDER BY 2, 1;


-- 9. 학과별 서울에 거주하는 교수 중 나이가 가장 적은 교수의 나이를 조회한다.
-- 단, 나이가 적은 순으로 정렬 한다. 
SELECT DEPARTMENT_NO 학과번호, FLOOR(MONTHS_BETWEEN(SYSDATE, TO_DATE(SUBSTR(PROFESSOR_SSN, 1, 6), 'RRMMDD'))/12) 나이
FROM (SELECT *
      FROM TB_PROFESSOR
      WHERE PROFESSOR_ADDRESS LIKE '서울%'
      ORDER BY PROFESSOR_SSN DESC
      )
WHERE ROWNUM = 1;

-- 10. 2005년1월1일부터 2006년12월31일까지의 기간에 입학한 학생 중 주소가 등록되지 않은 남학생의 
-- 학과번호, 학생이름, 지도교수번호, 입학년도를 조회하시오. 입학년도를 기준으로 오름차순 정렬한다.
SELECT DEPARTMENT_NO 학과번호, STUDENT_NAME 학생이름, COACH_PROFESSOR_NO 지도교수번호, '20'||SUBSTR(ENTRANCE_DATE, 1, 2)||'년' 입학년도
FROM TB_STUDENT
WHERE ENTRANCE_DATE BETWEEN '05/01/01' AND '06/12/31'
      AND STUDENT_ADDRESS IS NULL
      AND SUBSTR(STUDENT_SSN, 8, 1) LIKE '1'
ORDER BY 4;
