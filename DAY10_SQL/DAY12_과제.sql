-- 1. 2001 년에 입학 핚 사학과 학생이 몇 명인지 학생수를 조회하시오. 사학과 코드는 TB_DEPARTMENT 에서
-- 검색핚다. (Join 을 사용하지 않는다.)
SELECT COUNT(*)
FROM TB_DEPARTMENT
WHERE DEPARTMENT_NAME LIKE '사학과'
AND DEPARTMENT_NO IN (SELECT DEPARTMENT_NO
                         FROM TB_STUDENT
                         WHERE SUBSTR(STUDENT_NO, 1, 3) LIKE 'A01');
