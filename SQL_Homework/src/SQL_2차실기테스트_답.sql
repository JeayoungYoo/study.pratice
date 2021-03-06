-- SQL 2차 실기 모범답안

-- 1.
SELECT SUBSTR(TERM_NO, 1, 4) 년도, ROUND(AVG(POINT), 1) 평점
FROM TB_GRADE
JOIN TB_STUDENT USING (STUDENT_NO)
WHERE COACH_PROFESSOR_NO = (SELECT COACH_PROFESSOR_NO 
                              FROM TB_STUDENT 
                              WHERE STUDENT_NAME = '서가람')
GROUP BY SUBSTR(TERM_NO, 1, 4)
ORDER BY 1;

-- 2.
--황진석 …… 이민영   총 52개
SELECT   DEPARTMENT_NAME 학과명,
         STUDENT_NAME 학생명,
				 ENTRANCE_DATE 입학일자
FROM     TB_STUDENT
JOIN     TB_DEPARTMENT USING (DEPARTMENT_NO)
WHERE    SUBSTR(STUDENT_SSN, 8, 1) IN ('1', '3')
AND      ABSENCE_YN = 'Y'
AND      ENTRANCE_DATE BETWEEN TO_DATE('20010101', 'YYYYMMDD') AND SYSDATE
ORDER BY 3 DESC;

-- 3.
SELECT    PROFESSOR_NAME 지도교수,
          COUNT(STUDENT_NO) 학생수
FROM      TB_PROFESSOR
LEFT JOIN TB_CLASS_PROFESSOR USING (PROFESSOR_NO)
JOIN      TB_STUDENT ON (COACH_PROFESSOR_NO = PROFESSOR_NO)
WHERE     CLASS_NO IS NULL
GROUP BY  PROFESSOR_NAME;


-- 4.
SELECT STUDENT_NAME 학생명, SUBSTR(TERM_NO, 1, 6) 학기, ROUND(AVG(POINT), 1) 평점
FROM TB_STUDENT 
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
JOIN TB_GRADE USING (STUDENT_NO)
WHERE SUBSTR(TERM_NO, 1, 4) IN ('2009')
AND CATEGORY = '공학'
GROUP BY STUDENT_NAME, DEPARTMENT_NAME, SUBSTR(TERM_NO, 1, 6) 
HAVING ROUND(AVG(POINT),1) >= 4.0 
ORDER BY 3 DESC, 1 ASC;

-- 5.
SELECT SUBSTR(TERM_NO, 1, 4) 년도 , SUBSTR(TERM_NO, 5, 2) 학기, ROUND(AVG(POINT), 1) 평점
FROM TB_GRADE
JOIN TB_STUDENT S USING (STUDENT_NO)
JOIN TB_DEPARTMENT D ON (S.DEPARTMENT_NO = D.DEPARTMENT_NO)
WHERE D.DEPARTMENT_NO = (SELECT DEPARTMENT_NO 
                            FROM TB_STUDENT 
                            WHERE STUDENT_NAME = '김고운')
AND SUBSTR(TERM_NO, 1, 4) < 2009 AND  SUBSTR(TERM_NO, 1, 4) > 2006 
GROUP BY ROLLUP(SUBSTR(TERM_NO, 1,4)), ROLLUP(SUBSTR(TERM_NO, 5,2))
ORDER BY 1, 2;

-- 6.
SELECT SUBSTR(TERM_NO, 1,4) 년도,
			 NVL(SUBSTR(TERM_NO, 5, 2), '-') 학기,
 			 ROUND(AVG(POINT), 1) 평점
FROM   TB_GRADE 
JOIN   TB_STUDENT USING (STUDENT_NO)
WHERE  TERM_NO LIKE '2004%'
AND    DEPARTMENT_NO = (SELECT DEPARTMENT_NO 
                          FROM  TB_CLASS
												  WHERE CLASS_NAME = '문학과생태학' )
AND    SUBSTR(TERM_NO, 5, 2) IS NOT NULL                 
GROUP BY ROLLUP  (SUBSTR(TERM_NO, 5, 2)), SUBSTR(TERM_NO, 1, 4)
ORDER BY 1;


-- 7.
SELECT 과목이름, 누적수강생수 
FROM (SELECT  CLASS_NO, CLASS_NAME 과목이름, 
              COUNT(*) 누적수강생수, RANK() OVER (ORDER BY COUNT(*) DESC) AS 순위
      FROM TB_CLASS
      JOIN TB_GRADE USING (CLASS_NO)
      WHERE TO_NUMBER(TO_CHAR(SYSDATE, 'YYYY'), '9999') 
              - TO_NUMBER(SUBSTR(TERM_NO, 1, 4), '9999') <= 10
      GROUP BY  CLASS_NO, CLASS_NAME
      ORDER BY 3 DESC) 
WHERE 순위 <= 3;

-- 8.
SELECT STUDENT_NAME 학생이름, PROFESSOR_NAME 지도교수
FROM TB_STUDENT
JOIN TB_PROFESSOR ON (COACH_PROFESSOR_NO = PROFESSOR_NO)
WHERE LENGTH(STUDENT_NO) = 7
AND STUDENT_NO LIKE 'A__3%'
AND PROFESSOR_NAME LIKE '이%'
ORDER BY 1;

-- 9.
SELECT CATEGORY,
        DEPARTMENT_NAME 학과명,
        COUNT(STUDENT_NO) AS 학생수
FROM TB_DEPARTMENT 
LEFT JOIN TB_STUDENT USING(DEPARTMENT_NO)
WHERE CATEGORY = '예체능' OR CATEGORY= '의학'
GROUP BY  CATEGORY,  DEPARTMENT_NAME
ORDER BY 1, 3 DESC ;

-- 10.
SELECT TC1.CLASS_NAME 과목, TC2.CLASS_NAME 선수과목
FROM TB_CLASS TC1
JOIN (SELECT C2.CLASS_NAME, C2.CLASS_NO
      FROM TB_CLASS C1 
      JOIN TB_CLASS C2 ON C2.PREATTENDING_CLASS_NO = C1.CLASS_NO)  TC2 
      ON TC1.CLASS_NO = TC2.CLASS_NO
WHERE DEPARTMENT_NO IN (SELECT DEPARTMENT_NO 
                           FROM TB_DEPARTMENT 
                           WHERE DEPARTMENT_NAME = '행정학과')
ORDER BY 1;

- 11.
SELECT *
FROM (SELECT CLASS_NO 과목번호, CLASS_NAME 과목이름, COUNT(STUDENT_NO) 누적수강
       FROM  TB_CLASS
       JOIN  TB_GRADE USING (CLASS_NO)
       WHERE SUBSTR(TERM_NO,1,4) >= 2017
       GROUP BY CLASS_NO, CLASS_NAME 
       ORDER BY COUNT(STUDENT_NO) DESC)
WHERE ROWNUM <= 5;

-- 12.
CREATE OR REPLACE VIEW V_ENGLISH
AS
SELECT STUDENT_NAME 학생이름, ROUND(AVG(POINT), 1) 평점 
FROM TB_STUDENT
JOIN TB_GRADE USING (STUDENT_NO)
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
WHERE DEPARTMENT_NO = (SELECT DEPARTMENT_NO 
                          FROM TB_DEPARTMENT 
                          WHERE DEPARTMENT_NAME = '영어영문학과')
GROUP BY STUDENT_NAME
ORDER BY 1;

SELECT * FROM V_ENGLISH;

-- 13.
UPDATE TB_GRADE SET POINT = (SELECT POINT
                                FROM TB_STUDENT
                                JOIN TB_GRADE USING (STUDENT_NO)
                                JOIN TB_CLASS USING (CLASS_NO)
                                WHERE CLASS_NAME = '현대생물학연구'
                                AND TERM_NO = '200201' 
                                AND STUDENT_NAME = '김김훈')
WHERE STUDENT_NO = (SELECT STUDENT_NO
                      FROM TB_STUDENT
                      JOIN TB_GRADE USING (STUDENT_NO)
                      JOIN TB_CLASS USING (CLASS_NO)
                      WHERE CLASS_NAME = '현대생물학연구'
                      AND TERM_NO = '200201' 
                      AND STUDENT_NAME = '이대은')
AND TERM_NO = '200201'
AND CLASS_NO = (SELECT CLASS_NO 
                  FROM TB_CLASS
                  WHERE CLASS_NAME = '현대생물학연구');

ROLLBACK;

-- 14.
CREATE TABLE TB_TUITION (CATEGORY, STUDENT_COUNT, TUITION_SUM)
AS 
SELECT CATEGORY, COUNT(STUDENT_NO) STUDENT_COUNT, COUNT(STUDENT_NO)*4000000 TUITION_SUM
FROM TB_STUDENT
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
GROUP BY CATEGORY;

-- 15.
CREATE  TABLE  TB_BOOKS ( 
  BOOK_ID  CHAR(5)  PRIMARY  KEY,
  BOOKNAME  VARCHAR2(50),
  BOOKPRICE  NUMBER
);

CREATE  SEQUENCE  SEQID
INCREMENT  BY   1
START   WITH   100
MAXVALUE   999
NOCYCLE    
NOCACHE;

INSERT INTO TB_BOOKS 
VALUES (SEQID.NEXTVAL, 'JAVA Programming', 30000);

SELECT * FROM TB_BOOKS;


