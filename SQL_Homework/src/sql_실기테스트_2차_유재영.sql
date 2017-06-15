-- 1. �������ǿ� �´� �����͸� ��ȸ �Ͻÿ�.
-- ? ���������� �л��� ���� ������ ������ �л����� �⵵ �� ������ ǥ���ϴ� ������ �ۼ��Ѵ�.
-- ? ������ �Ҽ��� 1 �ڸ������� �ݿø��Ͽ� ǥ�� ���� �⵵�� �ֱ� ������ ���� �Ѵ�.

SELECT SUBSTR(TERM_NO, 1, 4) �⵵, ROUND(AVG(POINT), 1) ����
FROM TB_GRADE
JOIN TB_STUDENT USING (STUDENT_NO)
WHERE COACH_PROFESSOR_NO = (SELECT COACH_PROFESSOR_NO
                            FROM TB_STUDENT
                            WHERE STUDENT_NAME LIKE '������')
GROUP BY SUBSTR(TERM_NO, 1, 4)
ORDER BY 1 DESC;

-- 2. �Ʒ� ���ǿ� �´� ������ �˻� �Ͻÿ�.
-- ? ��ü ���л� �� ������ �л��� ���� ���ڸ� ��ȸ����.
-- ? �������ڰ� 2001 �� 1 �� 1 ��(����)���� �������(����)�� �л��� ǥ���ϴ� ������ �ۼ�����.
-- ? ���� ���ڰ� �ֱ� ������ ��������.
SELECT DEPARTMENT_NAME �а���, STUDENT_NAME �л���, ENTRANCE_DATE ��������
FROM TB_STUDENT
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
WHERE SUBSTR(STUDENT_SSN, 8, 1) IN (1, 3)
      AND ENTRANCE_DATE >= '01/01/01'
      AND ABSENCE_YN LIKE 'Y'
ORDER BY 3 DESC;

-- 3. �Ʒ� ���ǿ� �´� ������ �˻� �Ͻÿ�
-- ? ������ �ϳ��� ���� ���� ���� ������ ���������� �л����� ǥ���ϴ� ������ �ۼ�����
SELECT PROFESSOR_NAME ��������, COUNT(STUDENT_NO) �л���
FROM TB_PROFESSOR
LEFT JOIN TB_CLASS_PROFESSOR USING (PROFESSOR_NO)
JOIN TB_STUDENT ON (PROFESSOR_NO = COACH_PROFESSOR_NO)
WHERE TB_CLASS_PROFESSOR.CLASS_NO IS NULL
GROUP BY PROFESSOR_NAME;

-- 4. �������ǿ� �´� �����͸� ��ȸ �Ͻÿ�.
-- ? �����С��迭�� �л��� �� 2009 �⵵ ���� �� 4.0 �̻��� �л��� ǥ���ϴ� ������ �ۼ�����.
-- ? ������ �Ҽ��� 1 �ڸ������� �ݿø��Ͽ� ǥ�� ����.
-- ? ������ ���� ������ ���� �ϰ� ������ �л��̸���(�����ټ�)���� ���� ����.
SELECT STUDENT_NAME �л��̸�, TERM_NO �б�, AVG(POINT) ����
FROM TB_STUDENT
JOIN TB_GRADE USING (STUDENT_NO)
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
WHERE CATEGORY LIKE '����' AND SUBSTR(TERM_NO, 1, 4) = '2009'
GROUP BY STUDENT_NAME, TERM_NO
HAVING AVG(POINT) >= 4.0
ORDER BY 3 DESC, 1;

-- 5. �������ǿ� �´� �����͸� ��ȸ �Ͻÿ�
-- ? ����� �л��� �ִ� ���� 2007 ��, 2008 �� �б� �� ������
-- �⵵ �� ���� ����, �� ������ ǥ���ϴ� ������ �ۼ�����. (������ �Ҽ��� 1 �ڸ������� �ݿø�)
SELECT DECODE(GROUPING(SUBSTR(TERM_NO, 1, 4)), 1, ' ', SUBSTR(TERM_NO, 1, 4)) �⵵, DECODE(GROUPING(SUBSTR(TERM_NO, 5, 2)), 1, ' ', `SUBSTR(TERM_NO, 5, 2)) �б�, ROUND(AVG(POINT), 1) ����
FROM TB_GRADE
JOIN TB_STUDENT USING (STUDENT_NO)
WHERE DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                       FROM TB_STUDENT
                       WHERE STUDENT_NAME LIKE '����')
AND SUBSTR(TERM_NO, 1, 4) IN ('2007', '2008')
GROUP BY ROLLUP(SUBSTR(TERM_NO, 1, 4), SUBSTR(TERM_NO, 5, 2));

-- 6. �������ǿ� �´� �����͸� ��ȸ �Ͻÿ�
-- ? �����а������С� ������ �����ϴ� ���� 2004 �⵵ �б� �� ������
-- �� ������ ǥ���ϴ� ������ �ۼ�����.
-- ? ������ �Ҽ��� 1 �ڸ������� �ݿø��Ͽ� ǥ�� ����.
SELECT SUBSTR(TERM_NO, 1, 4) �⵵, DECODE(GROUPING(SUBSTR(TERM_NO, 5, 2)),1,' ',SUBSTR(TERM_NO, 5, 2)) �б�, ROUND(AVG(POINT), 1) ����
FROM TB_GRADE
JOIN TB_CLASS USING (CLASS_NO)
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                       FROM TB_CLASS
                       WHERE CLASS_NAME LIKE '���а�������')
AND SUBSTR(TERM_NO, 1, 4) LIKE '2004'
GROUP BY SUBSTR(TERM_NO, 1, 4), ROLLUP(SUBSTR(TERM_NO, 5, 2));

-- 7. �������ǿ� �´� �����͸� ��ȸ �Ͻÿ�.
-- ? �ֱ� 10 ���� �������� ���� ���������� ���� ���Ҵ� ���� �� ���� 3 ������ ǥ���ϴ� ������
-- �ۼ�����. ���� 3 ������ ������ ������ ���� ��� ��� ǥ�� ����.
-- ? ���� ���������� ���� ������ ���� ����.
SELECT �����̸�, ������������
FROM (SELECT CLASS_NAME �����̸�,  COUNT(STUDENT_NO) ������������, DENSE_RANK() OVER(ORDER BY COUNT(STUDENT_NO) DESC) ����
      FROM TB_CLASS
      JOIN TB_GRADE USING (CLASS_NO)
      WHERE TO_NUMBER(SUBSTR(TERM_NO, 1, 4)) > 2006
      GROUP BY CLASS_NAME, CLASS_NO
      )
WHERE ���� < 4;

-- 8. �л���ȣ�� �� 7 �ڸ��̰� 'A'�� �����ϸ� 4 ��° �ڸ� �����Ͱ� '3'�� �л� �� ���������� ����
-- '��'���� �л��� �л��̸� ��(�����ټ�)���� ǥ���ϴ� ������ �ۼ� �Ͻÿ�
SELECT STUDENT_NAME �л��̸�, PROFESSOR_NAME ��������
FROM TB_STUDENT
JOIN TB_PROFESSOR ON (COACH_PROFESSOR_NO = PROFESSOR_NO)
WHERE (LENGTH(STUDENT_NO) = 7 AND SUBSTR(STUDENT_NO, 1, 1) LIKE 'A' AND SUBSTR(STUDENT_NO, 4, 1) LIKE '3') AND PROFESSOR_NAME LIKE '��%'
ORDER BY 1;

-- 9. �������ǿ� �´� �����͸� ��ȸ �Ͻÿ�
-- ? ����ü�ɡ��� �����С� �迭�� ��� �а��� �а��̸��� �л����� ǥ���ϴ� ������ �ۼ� �Ͻÿ�.
-- ? �迭�̸� ��(�����ټ�)���� ���� �ϰ� ������ �л����� ���� ������ ���� ����.
SELECT CATEGORY �迭, DEPARTMENT_NAME �а��̸�, COUNT(STUDENT_NO) �л���
FROM TB_STUDENT
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
WHERE CATEGORY IN ('��ü��', '����') 
GROUP BY CATEGORY, DEPARTMENT_NAME
ORDER BY 1;

-- 10. ?�����а�?�� ��� ������ ���� ����� �Բ� �����̸���(�����ټ�)���� ǥ���ϴ� ������ �ۼ� �Ͻÿ�.
-- (���������� ���� ��µ��� �ʴ´�.)
SELECT A.CLASS_NAME ����, B.CLASS_NAME ��������
FROM TB_CLASS A
JOIN TB_CLASS B ON (A.PREATTENDING_CLASS_NO = B.CLASS_NO)
WHERE A.DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                         FROM TB_DEPARTMENT
                         WHERE DEPARTMENT_NAME LIKE '�����а�');
                         
-- 11. �������ǿ� �´� �����͸� ��ȸ �Ͻÿ�
-- ? �ֱ� 10 ���� �������� ���� ���������� ���� ���Ҵ� ���� �� ���� 5 ���� ��ȸ ����.
-- ? ���� ���������� ���� ���� ������ ���� ����.
SELECT �����ȣ, �����̸�
FROM (SELECT CLASS_NO �����ȣ, CLASS_NAME �����̸�, RANK() OVER(ORDER BY COUNT(STUDENT_NO) DESC) ����
      FROM TB_CLASS
      JOIN TB_GRADE USING (CLASS_NO)
      WHERE TO_NUMBER(SUBSTR(TERM_NO, 1, 4)) > 2006
      GROUP BY CLASS_NO, CLASS_NAME
      )
WHERE ���� < 6;

-- 12. �������ǿ� �´� VIEW �� ���� �Ͻÿ�.
-- ? VIEW �̸�: V_ENGLISH , VIEW �÷�: ���л��̸����� ��������
-- ? ��������а��� �л����� �л��̸��� ������ VIEW �� ���� ����.
-- ? ������ �Ҽ��� 1 �ڸ������� �ݿø��Ͽ� ǥ�� ����.
-- ? ������ ���� ������ ���� �ϰ� ������ �л� ������ �������� ���� ����.
CREATE VIEW V_ENGLISH AS
SELECT STUDENT_NAME �л��̸�, ROUND(AVG(POINT), 1) ����
FROM TB_STUDENT
JOIN TB_GRADE USING (STUDENT_NO)
WHERE DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                       FROM TB_DEPARTMENT
                       WHERE DEPARTMENT_NAME LIKE '������а�')
GROUP BY STUDENT_NAME
ORDER BY 2 DESC, 1;

SELECT * FROM V_ENGLISH;

-- 13. ���� ���ǿ� �°� �����͸� ���� �Ͻÿ�.
-- ? ?�̴���?�л��� ?�����? �л��� 2002 �� 01 �б⿡ ?��������п���? ������ ���� ���� �Ͽ���
-- ? ?�̴���? �л��� ������ ?�����? �л��� ������ ���� ����.
UPDATE TB_GRADE
SET POINT = (SELECT POINT
             FROM TB_GRADE
             JOIN TB_CLASS USING (CLASS_NO)
             WHERE STUDENT_NO = (SELECT STUDENT_NO
                                 FROM TB_STUDENT
                                 WHERE STUDENT_NAME LIKE '�����')
             AND TERM_NO LIKE '200201'
             AND CLASS_NAME LIKE '��������п���')
                                 
WHERE STUDENT_NO = (SELECT STUDENT_NO
                    FROM TB_STUDENT
                    WHERE STUDENT_NAME LIKE '�̴���')
AND CLASS_NO = (SELECT CLASS_NO
                FROM TB_CLASS
                WHERE CLASS_NAME LIKE '��������п���')
AND TERM_NO = '200201';

-- 14. ���� ���ǿ� �´� DDL �� �ۼ� �Ͻÿ�.
-- ? ��� �迭 �� �л� ���� ��ϱ��� ���� Ȯ�� �� �� �ֵ��� TABLE �� ���� ����.
-- ? �л� ���δ� ��ϱ��� 4 �鸸���̴�.
-- ? Table �̸��� TB_TUITION �� ����.
-- ? Table �� �÷����� ������ ����.
-- ? ī�װ�: CATEGORY
-- ? �л���: STUDENT_COUNT
-- ? ��ϱ���: TUITION_SUM
-- ? ���������� �̿��Ͽ� �ϳ��� �������� �ۼ� �Ͻÿ�
CREATE TABLE TB_TUITION (CATEGORY, STUDENT_COUNT, TUITION_SUM)
AS
SELECT CATEGORY, COUNT(STUDENT_NO), TO_NUMBER(COUNT(STUDENT_NO)*4000000)
FROM TB_STUDENT
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
GROUP BY CATEGORY
;

SELECT * FROM TB_TUITION;

-- 15. �Ʒ��� Table �� sequence �� ���� �Ǿ� �ִ�.
-- �� TABLE �� ���ǿ��� �־��� �����͸� �Է� �Ͻÿ�.
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