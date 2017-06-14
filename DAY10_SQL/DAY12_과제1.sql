-- 1. �������� ���̺�(TB_CLASS_TYPE)�� �Ʒ��� ���� �����͸� �Է��Ͻÿ�.
CREATE SEQUENCE SEQID
START WITH 01
INCREMENT BY 01
MAXVALUE 05
NOCYCLE NOCACHE;
DROP SEQUENCE SEQID;

DELETE TB_CLASS_TYPE;
INSERT INTO TB_CLASS_TYPE VALUES (TO_CHAR(SEQID.NEXTVAL), '�����ʼ�');
INSERT INTO TB_CLASS_TYPE VALUES (TO_CHAR(SEQID.NEXTVAL), '��������');
INSERT INTO TB_CLASS_TYPE VALUES (TO_CHAR(SEQID.NEXTVAL), '�����ʼ�');
INSERT INTO TB_CLASS_TYPE VALUES (TO_CHAR(SEQID.NEXTVAL), '���缱��');
INSERT INTO TB_CLASS_TYPE VALUES (TO_CHAR(SEQID.NEXTVAL), '������');

SELECT * FROM TB_CLASS_TYPE;
 
-- 2. �� ������б� �л����� ������ ���ԵǾ� �ִ� �л��Ϲ����� ���̺��� ������� ����.
-- �Ʒ� ������ �����Ͽ� ������ SQL ���� �ۼ��Ͻÿ�. (���������� �̿��Ͻÿ�)
CREATE TABLE TB_�л��Ϲ����� (�й�, �л��̸�, �ּ�)
AS
SELECT STUDENT_NO, STUDENT_NAME, STUDENT_ADDRESS
FROM TB_STUDENT;

-- 3. ������а� �л����� �������� ���ԵǾ� �ִ� �а����� ���̺��� ������� ����.
-- �Ʒ� ������ �����Ͽ� ������ SQL ���� �ۼ��Ͻÿ�. (��Ʈ : ����� �پ���, �ҽŲ�
-- �ۼ��Ͻÿ�)
CREATE TABLE TB_������а� 
AS
SELECT STUDENT_NO �й�, STUDENT_NAME �л��̸�, '19'||SUBSTR(STUDENT_SSN, 1, 2) AS ����⵵, PROFESSOR_NAME
FROM TB_STUDENT
JOIN TB_PROFESSOR USING (DEPARTMENT_NO)
WHERE DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                       FROM TB_DEPARTMENT
                       WHERE DEPARTMENT_NAME LIKE '������а�');
ROLLBACK;

-- 4. �� �а����� ������ 10% ������Ű�� �Ǿ���. �̿� ����� SQL ���� �ۼ��Ͻÿ�. (��,
-- �ݿø��� ����Ͽ� �Ҽ��� �ڸ����� ������ �ʵ��� ����)
UPDATE TB_DEPARTMENT
SET CAPACITY = CAPACITY * 1.1;
ROLLBACK;

-- 5. �й� A413042 �� �ڰǿ� �л��� �ּҰ� "����� ���α� ���ε� 181-21 "�� ����Ǿ��ٰ�
-- ����. �ּ����� �����ϱ� ���� ����� SQL ���� �ۼ��Ͻÿ�.
UPDATE TB_STUDENT
SET STUDENT_ADDRESS = '����� ���α� ���ε� 181-21'
WHERE STUDENT_NO = 'A413042';


-- 6. �ֹε�Ϲ�ȣ ��ȣ���� ���� �л����� ���̺��� �ֹι�ȣ ���ڸ��� �������� �ʱ��
-- �����Ͽ���. �� ������ �ݿ��� ������ SQL ������ �ۼ��Ͻÿ�.
-- (��. 830530-2124663 ==> 830530 )
UPDATE TB_STUDENT
SET STUDENT_SSN = SUBSTR(STUDENT_SSN, 1, 6);

SELECT STUDENT_SSN
FROM TB_STUDENT;

-- 7. ���а� ����� �л��� 2005 �� 1 �б⿡ �ڽ��� ������ '�Ǻλ�����' ������
-- �߸��Ǿ��ٴ� ���� �߰��ϰ�� ������ ��û�Ͽ���. ��� ������ Ȯ�� ���� ��� �ش�
-- ������ ������ 3.5 �� ����Ű�� �����Ǿ���. ������ SQL ���� �ۼ��Ͻÿ�.
UPDATE TB_GRADE
SET POINT = 3.5
WHERE (STUDENT_NO, TERM_NO, CLASS_NO) IN (SELECT STUDENT_NO, TERM_NO, CLASS_NO
                                         FROM TB_STUDENT
                                         JOIN TB_GRADE USING (STUDENT_NO)
                                         JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
                                         WHERE STUDENT_NAME LIKE '�����'
                                         AND TERM_NO = '200501'
                                         AND CLASS_NO = (SELECT CLASS_NO
                                                         FROM TB_CLASS
                                                         WHERE CLASS_NAME LIKE '�Ǻλ�����')
                                         AND DEPARTMENT_NAME LIKE '���а�');
                                         

-- 8. ���� ���̺�(TB_GRADE) ���� ���л����� �����׸��� �����Ͻÿ�
DELETE FROM TB_GRADE
WHERE STUDENT_NO IN (SELECT STUDENT_NO
                     FROM TB_STUDENT
                     WHERE ABSENCE_YN LIKE 'Y');
ROLLBACK;
             

