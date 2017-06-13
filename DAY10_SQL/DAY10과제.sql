-- 1. �迭 ������ ������ ī�װ� ���̺��� ������� ����. ������ ���� ���̺��� �ۼ��Ͻÿ�.
CREATE TABLE TB_CATEGORY (
    NAME VARCHAR2(10),
    USE_YNM CHAR(1) DEFAULT 'Y'
);

-- 2. ���� ������ ������ ���̺��� ������� ����. ������ ���� ���̺��� �ۼ��Ͻÿ�.
CREATE TABLE TB_CLASS_TYPE (
    NO VARCHAR2(5) PRIMARY KEY,
    NAME VARCHAR2(10)
);


-- 3. TB_CATAGORY ���̺��� NAME �÷��� PRIMARY KEY �� �����Ͻÿ�.
-- (KEY �̸��� �������� �ʾƵ� ������. ���� KEY �̸� �����ϰ��� ���ٸ� �̸��� ������
-- �˾Ƽ� ������ �̸��� �������.)
ALTER TABLE TB_CATEGORY 
ADD CONSTRAINT PK_NAME PRIMARY KEY (NAME);


-- 4. TB_CLASS_TYPE ���̺��� NAME �÷��� NULL ���� ���� �ʵ��� �Ӽ��� �����Ͻÿ�.
ALTER TABLE TB_CLASS_TYPE
MODIFY NAME NOT NULL;

-- 5. �� ���̺��� �÷� ���� NO �� ���� ���� Ÿ���� �����ϸ鼭 ũ��� 10 ����, �÷�����
-- NAME �� ���� ���C������ ���� Ÿ���� �����ϸ鼭 ũ�� 20 ���� �����Ͻÿ�.
ALTER TABLE TB_CATEGORY
MODIFY (NAME VARCHAR2(20));
ALTER TABLE TB_CLASS_TYPE
MODIFY (NAME VARCHAR2(20), NO VARCHAR(10));

-- 6. �� ���̺��� NO �÷��� NAME �÷��� �̸��� �� �� TB_ �� ������ ���̺� �̸��� �տ�
-- ���� ���·� ��������. (ex. CATEGORY_NAME)
ALTER TABLE TB_CATEGORY
RENAME COLUMN NAME TO CATEGORY_NAME;

ALTER TABLE TB_CLASS_TYPE
RENAME COLUMN NAME TO CLASS_TYPE_NAME;
ALTER TABLE TB_CLASS_TYPE
RENAME COLUMN NO TO CLASS_TYPE_NO;


-- 7. TB_CATAGORY ���̺�� TB_CLASS_TYPE ���̺��� PRIMARY KEY �̸��� ������ ���� �����Ͻÿ�. 
-- Primary Key �� �̸��� ?PK_ + �÷��̸�?���� �����Ͻÿ�. (ex. PK_CATEGORY_NAME ) 
ALTER TABLE TB_CATEGORY
RENAME CONSTRAINT PK_NAME TO PKNAME;
ALTER TABLE TB_CLASS_TYPE
RENAME CONSTRAINT SYS_C007222 TO PKNO;

-- 8. ������ ����INSERT ���� ��������. 
INSERT INTO TB_CATEGORY VALUES ('����','Y');
INSERT INTO TB_CATEGORY VALUES ('�ڿ�����','Y');
INSERT INTO TB_CATEGORY VALUES ('����','Y');
INSERT INTO TB_CATEGORY VALUES ('��ü��','Y');
INSERT INTO TB_CATEGORY VALUES ('�ι���ȸ','Y');
COMMIT;

-- 9.TB_DEPARTMENT �� CATEGORY �÷��� TB_CATEGORY ���̺��� CATEGORY_NAME �÷��� �θ� ������ 
-- �����ϵ��� FOREIGN KEY �� �����Ͻÿ�. 
-- �� �� KEY �̸��� FK_���̺��̸�_�÷��̸����� ��������. (ex. FK_DEPARTMENT_CATEGORY )
ALTER TABLE TB_DEPARTMENT
ADD CONSTRAINT FK_DEPARTMENT_CATEGORY FOREIGN KEY (CATEGORY) 
REFERENCES TB_CATEGORY (CATEGORY_NAME);


-- 10. �� ������б� �л����� �������� ���ԵǾ� �ִ� �л��Ϲ����� VIEW�� ������� ����.
-- �Ʒ� ������ �����Ͽ� ������ SQL ���� �ۼ��Ͻÿ�.
CREATE OR REPLACE VIEW VM_�л��Ϲ����� ("�й�", "�л��̸�", "�ּ�") 
AS
SELECT STUDENT_NO, STUDENT_NAME, STUDENT_ADDRESS
FROM TB_STUDENT;


SELECT * FROM VM_�л��Ϲ�����;

-- 11. �� ������б��� 1 �⿡ �� ���� �а����� �л��� ���������� ���� ����� ��������.
-- �̸� ���� ����� �л��̸�, �а��̸�, ��米���̸� ���� �����Ǿ� �ִ� VIEW �� ����ÿ�.
-- �̶� ���� ������ ���� �л��� ���� �� ������ ����Ͻÿ� (��, �� VIEW �� �ܼ� SELECT ���� �� ��� �а����� ���ĵǾ� ȭ�鿡 �������� ����ÿ�.) 
CREATE OR REPLACE VIEW VM_������� ("�л��̸�", "�а��̸�", "���������̸�")
AS
SELECT DISTINCT STUDENT_NAME, DEPARTMENT_NAME, PROFESSOR_NAME
FROM TB_STUDENT S, TB_DEPARTMENT D, TB_PROFESSOR P
WHERE S.DEPARTMENT_NO = D.DEPARTMENT_NO(+) AND S.DEPARTMENT_NO = P.DEPARTMENT_NO(+);

SELECT * FROM VM_�������;

-- 12. ��� �а��� �а��� �л� ���� Ȯ���� �� �ֵ��� ������ VIEW �� �ۼ��� ����.
CREATE OR REPLACE VIEW VM_�а����л���
AS
SELECT DEPARTMENT_NAME, COUNT(STUDENT_NO) AS "STUDENT_COUNT"
FROM TB_STUDENT 
JOIN TB_DEPARTMENT  USING (DEPARTMENT_NO)
GROUP BY DEPARTMENT_NAME;

SELECT * FROM VM_�а����л���;

-- 13. ������ ������ �л��Ϲ����� View�� ���ؼ� �й��� A213046�� 
-- �л��� �̸��� ���� �̸����� �����ϴ� SQL ���� �ۼ��Ͻÿ�.

UPDATE VM_�л��Ϲ�����
SET �л��̸� = '���翵'
WHERE �й� = 'A213046';

SELECT * FROM VM_�л��Ϲ�����;

ROLLBACK;

-- 14. 13�������� ���� VIEW�� ���ؼ� �����Ͱ� ����� �� �ִ� ��Ȳ�� �������� 
-- VIEW�� ��� �����ؾ� �ϴ��� �ۼ��Ͻÿ�.
CREATE OR REPLACE VIEW VM_�л��Ϲ����� ("�й�", "�л��̸�", "�ּ�") 
AS
SELECT STUDENT_NO, STUDENT_NAME, STUDENT_ADDRESS
FROM TB_STUDENT
WITH READ ONLY;

UPDATE VM_�л��Ϲ�����
SET �л��̸� = '���翵'
WHERE �й� = 'A213046';

-- 15. �� ������б��� �ų� ������û ��A�� �Ǹ� Ư�� �α� ����鿡 ���� ��û�� ���� ������ �ǰ� �ִ�. 
-- �ֱ� 3 ���� �������� �����ο��� ���� ���Ҵ� 3 ������ ã�� ������ �ۼ��غ��ÿ�
SELECT *
FROM (SELECT CLASS_NO �����ȣ, CLASS_NAME �����̸�, COUNT(STUDENT_NO) AS "������������(��)"
      FROM TB_CLASS
      JOIN TB_GRADE USING (CLASS_NO)
      WHERE SUBSTR(TB_GRADE.TERM_NO, 1, 4) IN ('2007', '2008', '2009', '2006', '2005')
      GROUP BY CLASS_NO, CLASS_NAME
      ORDER BY COUNT(STUDENT_NO) DESC)
WHERE ROWNUM < 4;

-- �̰� 5���ε� ������ ���� �Ȱ��� ���ͼ� ����س���
