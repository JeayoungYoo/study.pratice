-- 1. 다음조건에 맞는 데이터를 조회 하시오.
-- ? “서가람” 학생의 지도 교수가 지도한 학생들의 년도 별 평점을 표시하는 구문을 작성한다.
-- ? 평점은 소수점 1 자리까지만 반올림하여 표시 핚고 년도를 최근 순으로 정렬 한다.

SELECT SUBSTR(TERM_NO, 1, 4) 년도, ROUND(AVG(POINT), 1) 평점
FROM TB_GRADE
JOIN TB_STUDENT USING (STUDENT_NO)
WHERE COACH_PROFESSOR_NO = (SELECT COACH_PROFESSOR_NO
                            FROM TB_STUDENT
                            WHERE STUDENT_NAME LIKE '서가람')
GROUP BY SUBSTR(TERM_NO, 1, 4)
ORDER BY 1 DESC;

-- 2. 아래 조건에 맞는 내용을 검색 하시오.
-- ? 전체 남학생 중 휴학핚 학생의 입학 일자를 조회핚다.
-- ? 입학일자가 2001 년 1 월 1 일(포함)부터 현재까지(포함)인 학생만 표시하는 구문을 작성핚다.
-- ? 입학 일자가 최근 순으로 정렬핚다.
SELECT DEPARTMENT_NAME 학과명, STUDENT_NAME 학생명, ENTRANCE_DATE 입학일자
FROM TB_STUDENT
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
WHERE SUBSTR(STUDENT_SSN, 8, 1) IN (1, 3)
      AND ENTRANCE_DATE >= '01/01/01'
      AND ABSENCE_YN LIKE 'Y'
ORDER BY 3 DESC;

-- 3. 아래 조건에 맞는 내용을 검색 하시오
-- ? 과목을 하나도 배정 받지 못핚 교수가 지도교수인 학생수를 표시하는 구문을 작성핚다
SELECT PROFESSOR_NAME 지도교수, COUNT(STUDENT_NO) 학생수
FROM TB_PROFESSOR
LEFT JOIN TB_CLASS_PROFESSOR USING (PROFESSOR_NO)
JOIN TB_STUDENT ON (PROFESSOR_NO = COACH_PROFESSOR_NO)
WHERE TB_CLASS_PROFESSOR.CLASS_NO IS NULL
GROUP BY PROFESSOR_NAME;

-- 4. 다음조건에 맞는 데이터를 조회 하시오.
-- ? “공학”계열의 학생들 중 2009 년도 평점 이 4.0 이상인 학생을 표시하는 구문을 작성핚다.
-- ? 평점은 소수점 1 자리까지만 반올림하여 표시 핚다.
-- ? 점수가 높은 순으로 정렬 하고 같으면 학생이름순(가나다순)으로 정렬 핚다.
SELECT STUDENT_NAME 학생이름, TERM_NO 학기, AVG(POINT) 평점
FROM TB_STUDENT
JOIN TB_GRADE USING (STUDENT_NO)
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
WHERE CATEGORY LIKE '공학' AND SUBSTR(TERM_NO, 1, 4) = '2009'
GROUP BY STUDENT_NAME, TERM_NO
HAVING AVG(POINT) >= 4.0
ORDER BY 3 DESC, 1;

-- 5. 다음조건에 맞는 데이터를 조회 하시오
-- ? “김고운” 학생이 있는 과의 2007 년, 2008 년 학기 별 평점과
-- 년도 별 누적 평점, 총 평점을 표시하는 구문을 작성핚다. (평점은 소수점 1 자리까지만 반올림)
SELECT DECODE(GROUPING(SUBSTR(TERM_NO, 1, 4)), 1, ' ', SUBSTR(TERM_NO, 1, 4)) 년도, DECODE(GROUPING(SUBSTR(TERM_NO, 5, 2)), 1, ' ', `SUBSTR(TERM_NO, 5, 2)) 학기, ROUND(AVG(POINT), 1) 평점
FROM TB_GRADE
JOIN TB_STUDENT USING (STUDENT_NO)
WHERE DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                       FROM TB_STUDENT
                       WHERE STUDENT_NAME LIKE '김고운')
AND SUBSTR(TERM_NO, 1, 4) IN ('2007', '2008')
GROUP BY ROLLUP(SUBSTR(TERM_NO, 1, 4), SUBSTR(TERM_NO, 5, 2));

-- 6. 다음조건에 맞는 데이터를 조회 하시오
-- ? “문학과생태학” 과목을 진행하는 과의 2004 년도 학기 별 평점과
-- 총 평점을 표시하는 구문을 작성핚다.
-- ? 평점은 소수점 1 자리까지만 반올림하여 표시 핚다.
SELECT SUBSTR(TERM_NO, 1, 4) 년도, DECODE(GROUPING(SUBSTR(TERM_NO, 5, 2)),1,' ',SUBSTR(TERM_NO, 5, 2)) 학기, ROUND(AVG(POINT), 1) 평점
FROM TB_GRADE
JOIN TB_CLASS USING (CLASS_NO)
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                       FROM TB_CLASS
                       WHERE CLASS_NAME LIKE '문학과생태학')
AND SUBSTR(TERM_NO, 1, 4) LIKE '2004'
GROUP BY SUBSTR(TERM_NO, 1, 4), ROLLUP(SUBSTR(TERM_NO, 5, 2));

-- 7. 다음조건에 맞는 데이터를 조회 하시오.
-- ? 최근 10 년을 기준으로 누적 수강생수가 가장 많았던 과목 중 상위 3 순위를 표시하는 구문을
-- 작성핚다. 상위 3 순위에 동일핚 순위가 있을 경우 모두 표시 핚다.
-- ? 누적 수강생수가 많은 순으로 정렬 핚다.
SELECT 과목이름, 누적수강생수
FROM (SELECT CLASS_NAME 과목이름,  COUNT(STUDENT_NO) 누적수강생수, DENSE_RANK() OVER(ORDER BY COUNT(STUDENT_NO) DESC) 순위
      FROM TB_CLASS
      JOIN TB_GRADE USING (CLASS_NO)
      WHERE TO_NUMBER(SUBSTR(TERM_NO, 1, 4)) > 2006
      GROUP BY CLASS_NAME, CLASS_NO
      )
WHERE 순위 < 4;

-- 8. 학생번호가 총 7 자리이고 'A'로 시작하며 4 번째 자리 데이터가 '3'인 학생 중 지도교수의 성이
-- '이'씨인 학생을 학생이름 순(가나다순)으로 표시하는 구문을 작성 하시오
SELECT STUDENT_NAME 학생이름, PROFESSOR_NAME 지도교수
FROM TB_STUDENT
JOIN TB_PROFESSOR ON (COACH_PROFESSOR_NO = PROFESSOR_NO)
WHERE (LENGTH(STUDENT_NO) = 7 AND SUBSTR(STUDENT_NO, 1, 1) LIKE 'A' AND SUBSTR(STUDENT_NO, 4, 1) LIKE '3') AND PROFESSOR_NAME LIKE '이%'
ORDER BY 1;

-- 9. 다음조건에 맞는 데이터를 조회 하시오
-- ? “예체능”과 “의학” 계열의 모든 학과를 학과이름과 학생수로 표시하는 구문을 작성 하시오.
-- ? 계열이름 순(가나다순)으로 정렬 하고 같으면 학생수가 많은 순으로 정렬 핚다.
SELECT CATEGORY 계열, DEPARTMENT_NAME 학과이름, COUNT(STUDENT_NO) 학생수
FROM TB_STUDENT
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
WHERE CATEGORY IN ('예체능', '의학') 
GROUP BY CATEGORY, DEPARTMENT_NAME
ORDER BY 1;

-- 10. ?행정학과?의 모든 과목을 선수 과목과 함께 과목이름순(가나다순)으로 표시하는 구문을 작성 하시오.
-- (선수과목이 없을 출력되지 않는다.)
SELECT A.CLASS_NAME 과목, B.CLASS_NAME 선수과목
FROM TB_CLASS A
JOIN TB_CLASS B ON (A.PREATTENDING_CLASS_NO = B.CLASS_NO)
WHERE A.DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                         FROM TB_DEPARTMENT
                         WHERE DEPARTMENT_NAME LIKE '행정학과');
                         
-- 11. 다음조건에 맞는 데이터를 조회 하시오
-- ? 최근 10 년을 기준으로 누적 수강생수가 가장 많았던 과목 중 상위 5 개를 조회 핚다.
-- ? 누적 수강생수가 가장 많은 순으로 정렬 핚다.
SELECT 과목번호, 과목이름
FROM (SELECT CLASS_NO 과목번호, CLASS_NAME 과목이름, RANK() OVER(ORDER BY COUNT(STUDENT_NO) DESC) 순위
      FROM TB_CLASS
      JOIN TB_GRADE USING (CLASS_NO)
      WHERE TO_NUMBER(SUBSTR(TERM_NO, 1, 4)) > 2006
      GROUP BY CLASS_NO, CLASS_NAME
      )
WHERE 순위 < 6;

-- 12. 다음조건에 맞는 VIEW 를 생성 하시오.
-- ? VIEW 이름: V_ENGLISH , VIEW 컬럼: “학생이름”과 “평점”
-- ? “영어영문학과” 학생들의 학생이름과 평점을 VIEW 로 생성 핚다.
-- ? 평점은 소수점 1 자리까지만 반올림하여 표시 핚다.
-- ? 점수가 높은 순으로 정렬 하고 같으면 학생 명으로 오름차순 정렬 핚다.
CREATE VIEW V_ENGLISH AS
SELECT STUDENT_NAME 학생이름, ROUND(AVG(POINT), 1) 평점
FROM TB_STUDENT
JOIN TB_GRADE USING (STUDENT_NO)
WHERE DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                       FROM TB_DEPARTMENT
                       WHERE DEPARTMENT_NAME LIKE '영어영문학과')
GROUP BY STUDENT_NAME
ORDER BY 2 DESC, 1;

SELECT * FROM V_ENGLISH;

-- 13. 다음 조건에 맞게 데이터를 수정 하시오.
-- ? ?이대은?학생과 ?김김훈? 학생이 2002 년 01 학기에 ?현대생물학연구? 과목을 같이 수강 하였다
-- ? ?이대은? 학생의 점수를 ?김김훈? 학생의 점수로 수정 핚다.
UPDATE TB_GRADE
SET POINT = (SELECT POINT
             FROM TB_GRADE
             JOIN TB_CLASS USING (CLASS_NO)
             WHERE STUDENT_NO = (SELECT STUDENT_NO
                                 FROM TB_STUDENT
                                 WHERE STUDENT_NAME LIKE '김김훈')
             AND TERM_NO LIKE '200201'
             AND CLASS_NAME LIKE '현대생물학연구')
                                 
WHERE STUDENT_NO = (SELECT STUDENT_NO
                    FROM TB_STUDENT
                    WHERE STUDENT_NAME LIKE '이대은')
AND CLASS_NO = (SELECT CLASS_NO
                FROM TB_CLASS
                WHERE CLASS_NAME LIKE '현대생물학연구')
AND TERM_NO = '200201';

-- 14. 다음 조건에 맞는 DDL 을 작성 하시오.
-- ? 모든 계열 별 학생 수와 등록금의 합을 확인 핛 수 있도록 TABLE 을 생성 핚다.
-- ? 학생 일인당 등록금은 4 백만원이다.
-- ? Table 이름은 TB_TUITION 로 핚다.
-- ? Table 의 컬럼명은 다음과 같다.
-- ? 카테고리: CATEGORY
-- ? 학생수: STUDENT_COUNT
-- ? 등록금합: TUITION_SUM
-- ? 서브쿼리를 이용하여 하나의 문장으로 작성 하시오
CREATE TABLE TB_TUITION (CATEGORY, STUDENT_COUNT, TUITION_SUM)
AS
SELECT CATEGORY, COUNT(STUDENT_NO), TO_NUMBER(COUNT(STUDENT_NO)*4000000)
FROM TB_STUDENT
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
GROUP BY CATEGORY
;

SELECT * FROM TB_TUITION;

-- 15. 아래의 Table 과 sequence 가 생성 되어 있다.
-- 이 TABLE 에 조건에서 주어진 데이터를 입력 하시오.
CREATE TABLE TB_BOOKS
( BOOK_ID NUMBER PRIMARY KEY,
  BOOKNAME VARCHAR2(50),
  BOOKPRICE NUMBER);

CREATE SEQUENCE SEQID
INCREMENT BY 1
START WITH 100
MAXVALUE 999
NOCYCLE NOCACHE;

INSERT INTO TB_BOOKS VALUES (SEQID.NEXTVAL, 'JAVA Programming', 30000);

SELECT * FROM TB_BOOKS;