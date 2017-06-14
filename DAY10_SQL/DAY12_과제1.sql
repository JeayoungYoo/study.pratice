-- 1. 과목유형 테이블(TB_CLASS_TYPE)에 아래와 같은 데이터를 입력하시오.
CREATE SEQUENCE SEQID
START WITH 01
INCREMENT BY 01
MAXVALUE 05
NOCYCLE NOCACHE;
DROP SEQUENCE SEQID;

DELETE TB_CLASS_TYPE;
INSERT INTO TB_CLASS_TYPE VALUES (TO_CHAR(SEQID.NEXTVAL), '전공필수');
INSERT INTO TB_CLASS_TYPE VALUES (TO_CHAR(SEQID.NEXTVAL), '전공선택');
INSERT INTO TB_CLASS_TYPE VALUES (TO_CHAR(SEQID.NEXTVAL), '교양필수');
INSERT INTO TB_CLASS_TYPE VALUES (TO_CHAR(SEQID.NEXTVAL), '교양선택');
INSERT INTO TB_CLASS_TYPE VALUES (TO_CHAR(SEQID.NEXTVAL), '논문지도');

SELECT * FROM TB_CLASS_TYPE;
 
-- 2. 춘 기술대학교 학생들의 정보가 포함되어 있는 학생일반정보 테이블을 맊들고자 핚다.
-- 아래 내용을 참고하여 적젃핚 SQL 문을 작성하시오. (서브쿼리를 이용하시오)
CREATE TABLE TB_학생일반정보 (학번, 학생이름, 주소)
AS
SELECT STUDENT_NO, STUDENT_NAME, STUDENT_ADDRESS
FROM TB_STUDENT;

-- 3. 국어국문학과 학생들의 정보맊이 포함되어 있는 학과정보 테이블을 맊들고자 핚다.
-- 아래 내용을 참고하여 적젃핚 SQL 문을 작성하시오. (힌트 : 방법은 다양함, 소신껏
-- 작성하시오)
CREATE TABLE TB_국어국문학과 
AS
SELECT STUDENT_NO 학번, STUDENT_NAME 학생이름, '19'||SUBSTR(STUDENT_SSN, 1, 2) AS 출생년도, PROFESSOR_NAME
FROM TB_STUDENT
JOIN TB_PROFESSOR USING (DEPARTMENT_NO)
WHERE DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                       FROM TB_DEPARTMENT
                       WHERE DEPARTMENT_NAME LIKE '국어국문학과');
ROLLBACK;

-- 4. 현 학과들의 정원을 10% 증가시키게 되었다. 이에 사용핛 SQL 문을 작성하시오. (단,
-- 반올림을 사용하여 소수점 자릿수는 생기지 않도록 핚다)
UPDATE TB_DEPARTMENT
SET CAPACITY = CAPACITY * 1.1;
ROLLBACK;

-- 5. 학번 A413042 인 박건우 학생의 주소가 "서울시 종로구 숭인동 181-21 "로 변경되었다고
-- 핚다. 주소지를 정정하기 위해 사용핛 SQL 문을 작성하시오.
UPDATE TB_STUDENT
SET STUDENT_ADDRESS = '서울시 종로구 숭인동 181-21'
WHERE STUDENT_NO = 'A413042';


-- 6. 주민등록번호 보호법에 따라 학생정보 테이블에서 주민번호 뒷자리를 저장하지 않기로
-- 결정하였다. 이 내용을 반영핛 적젃핚 SQL 문장을 작성하시오.
-- (예. 830530-2124663 ==> 830530 )
UPDATE TB_STUDENT
SET STUDENT_SSN = SUBSTR(STUDENT_SSN, 1, 6);

SELECT STUDENT_SSN
FROM TB_STUDENT;

-- 7. 의학과 김명훈 학생은 2005 년 1 학기에 자신이 수강핚 '피부생리학' 점수가
-- 잘못되었다는 것을 발견하고는 정정을 요청하였다. 담당 교수의 확인 받은 결과 해당
-- 과목의 학점을 3.5 로 변경키로 결정되었다. 적젃핚 SQL 문을 작성하시오.
UPDATE TB_GRADE
SET POINT = 3.5
WHERE (STUDENT_NO, TERM_NO, CLASS_NO) IN (SELECT STUDENT_NO, TERM_NO, CLASS_NO
                                         FROM TB_STUDENT
                                         JOIN TB_GRADE USING (STUDENT_NO)
                                         JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
                                         WHERE STUDENT_NAME LIKE '김명훈'
                                         AND TERM_NO = '200501'
                                         AND CLASS_NO = (SELECT CLASS_NO
                                                         FROM TB_CLASS
                                                         WHERE CLASS_NAME LIKE '피부생리학')
                                         AND DEPARTMENT_NAME LIKE '의학과');
                                         

-- 8. 성적 테이블(TB_GRADE) 에서 휴학생들의 성적항목을 제거하시오
DELETE FROM TB_GRADE
WHERE STUDENT_NO IN (SELECT STUDENT_NO
                     FROM TB_STUDENT
                     WHERE ABSENCE_YN LIKE 'Y');
ROLLBACK;
             

