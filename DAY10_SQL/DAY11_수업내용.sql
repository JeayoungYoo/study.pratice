-- DAY11 ��������
-- DDL ��Ÿ ��ü��

-- ������(SEQUENCE)
-- �ڵ� ��ȣ(����) �߻���
-- ���������� ���� ���� �ڵ����� �����ϴ� ��ü

-- ������ ����� 1
CREATE SEQUENCE SEQ_EMPID
START WITH 300  -- �ʱⰪ : 300���� ������
INCREMENT BY 5  -- ������ : 5�� ����
MAXVALUE 310    -- �ִ밪 : 310���� ���� �� �� �̻� �� �߻� �� ��
NOCYCLE         -- 310���� ���� �� �� �̻� �� �߻� ����
NOCACHE;        -- �̸� �޸𸮿� �������� ����

-- ������.NEXTVAL ����ؼ� �� �ٻ���Ŵ

SELECT SEQ_EMPID.NEXTVAL FROM DUAL;
-- MAXVALUE �� �����ϸ�, NOCYCLE �̱� ������ 4ȸ ���� ���� �߻� Ȯ��

-- ������ ��ųʸ��� ����� : USER_SEQUENCES
DESC USER_SEQUENCES;

SELECT SEQUENCE_NAME, CACHE_SIZE, LAST_NUMBER
FROM USER_SEQUENCES
WHERE SEQUENCE_NAME IN ('SEQ_EMPID', 'SEQ2_EMPID');
-- LAST_NUMBER ����
-- NOCACHE �̸�, ���� ��ȯ�� ��
-- CACHE ����̸�, CACHE �� ������ ���� ��������
--        (�޸𸮿� ������ �������� ���� ������ ���ֵ�)

/*
    �������
    CREATE SEQUENCE �������̸�
    [START WITH ���۰�]    -- �����Ǹ� �⺻���� 1��
    [INCREMENT BY ������]      -- ���� �����, �����Ǹ� �⺻���� 1��
    [MAXVALUE N | NOMAXVALUE]      -- �������� ����� �����. ������ �� ����
        -- NOMAXVALUE �����ϸ�, ���� ���������� ���� 10^27���� �߻���
        -- ���������� ���� -1���� ������
        
    [MINVALUE N | NOMINVALUE]      -- �������� ����� �����. �ּҰ� ����
        -- ���������� ���� 1, ���������϶��� -10^26
    [CYCLE | NOCYCLE]   -- �ִ�/�ּҰ� ���� �� �ݺ����� ����, ��ȯ�� ���۰��� ������ 1��
    [CACHE ���� | NOCACHE]    -- �޸𸮿� ������ �� ���� ���� ����, �ּҰ� 2����, �⺻�� 20��
*/

CREATE SEQUENCE SEQ2_EMPID
START WITH 5
INCREMENT BY 5
MAXVALUE 15
CYCLE
NOCACHE;

SELECT SEQ2_EMPID.NEXTVAL FROM DUAL;
-- 4ȸ ������ 1, 6, 11 �� �ݺ������� ������

-- ������ �����
-- NEXTVAL �Ӽ� : ���ο� ������ �� ��ȯ
-- �������̸�, NEXTVAL�� �����

-- CURRVAL �Ӽ� : ���� �������� Ȯ��
-- �������̸�.CURRVAL �� �����
-- ó�� NEXTVAL �� �ѹ� ����� �� ����� �� ����

CREATE SEQUENCE SEQ3_EMPID
START WITH 300
INCREMENT BY 5
MAXVALUE 310
NOCYCLE NOCACHE;

SELECT SEQ3_EMPID.CURRVAL FROM DUAL;
-- NEXTVAL �Ӽ� ��������� ����� �� ����

SELECT SEQ3_EMPID.NEXTVAL FROM DUAL;
SELECT SEQ3_EMPID.CURRVAL FROM DUAL;

-- ������ ��� : �ַ� ��ϰ� �ڵ� �߻��� ���� �����
CREATE SEQUENCE SEQID
START WITH 300
INCREMENT BY 1
MAXVALUE 310
NOCYCLE NOCACHE;

INSERT INTO EMPLOYEE (EMP_ID, EMP_NO, EMP_NAME)
VALUES (TO_CHAR(SEQID.NEXTVAL), '850130-1558215', '�迵��');

SELECT * FROM EMPLOYEE
WHERE EMP_ID = '300';

INSERT INTO EMPLOYEE (EMP_ID, EMP_NO, EMP_NAME)
VALUES (TO_CHAR(SEQID.NEXTVAL), '840221-1368450', '����ǥ');

SELECT * FROM EMPLOYEE
WHERE EMP_ID = '301';


CREATE SEQUENCE SEQID2
INCREMENT BY 1
START WITH 300
MAXVALUE 310
NOCYCLE NOCACHE;

SELECT SEQID2.NEXTVAL FROM DUAL;

SELECT SEQID2.NEXTVAL FROM DUAL;

ALTER SEQUENCE SEQID2
INCREMENT BY 5;

SELECT SEQID2.NEXTVAL FROM DUAL;


CREATE SEQUENCE SEQ1
INCREMENT BY 1
START WITH 1
NOCACHE;
SELECT SEQ1.NEXTVAL FROM DUAL;
SELECT SEQ1.CURRVAL FROM DUAL;

CREATE SEQUENCE SEQ2
INCREMENT BY 1
START WITH 1
CACHE 5;
SELECT SEQ2.NEXTVAL FROM DUAL;
SELECT SEQ2.CURRVAL FROM DUAL;

SELECT SEQUENCE_NAME,
CACHE_SIZE,
LAST_NUMBER
FROM USER_SEQUENCES
WHERE SEQUENCE_NAME IN ('SEQ1','SEQ2'); 

--������ ��������
-- DROP SEQUENCE ��������;
DROP SEQUENCE SEQID2;


-- �ε���(INDEX) **********************************************************
-- SQL ��ɹ� (SELECT) ��ó���ӵ��� ����Ű�� ���� �÷��� ���ؼ� �����ϴ� ����Ŭ ��ü
-- �ε��� ���α����� B* Ʈ������ �������� ������
-- �÷��� ���ؼ� �ε����� �����ϸ� �̿� ���� ���� Ʈ���� ������ ��
-- �ε����� �����ϱ� ���� �ð��� �ʿ��ϰ�, �ε����� ���� �߰� ��������� �ʿ���
-- �ݵ�� �������� �ƴϴ�
-- �ε��� ���� �Ŀ� DML �۾��� ����Ǹ�,�ε����� ����� ���� ����ǹǷ�
--      ����Ʈ�� ������ ���� ������ �Ǿ�� �ϹǷ�, DML �۾��� �ξ� ���ſ����� ��


-- ����
-- �˻� �ӵ��� ����
-- �ý��ۿ� �ɸ��� ���ϸ� �ٿ��� �ý��� ��ü ������ ����Ŵ

-- ����
-- �ε����� ���� �߰����� ������ �ʿ��ϴ�
-- �ε��� ���� �ð��� �ɸ�
-- ������ ���� �۾�(INSERT, UPDATE, DELETE)�� ���� �߻��ϴ� ��쿡�� ������ ������ ���ϵ�

-- �÷���(Ű����)�� ���� ��ϵ� ��ġ(ROWID)�� ���ĵ� ���·� ������
-- Ű���带 �̿��Ͽ� ���ϴ� ������ ��ϵ� ���� ������ ã������ �������� ����


-- �ε��� ���� ����
-- CREATE [UNIQUE] INDEX �ε����̸�
-- ON ���̺�� (�÷���, �÷��� | �Լ��� | ����);

-- �ε����� ����
-- 1. ���� �ε��� (UNIQUE INDEX)
-- 2. ����� �ε��� (NONUNIQUE INDEX)
-- 3. ���� �ε��� (SINGLE INDEX)
-- 4. ���� �ε��� ( COMPOSITE INDEX)
-- 5. �Լ� ��� �ε��� (FUNCTION BASED INDEX)

-- �ε����� ����
-- �ε����� �����ϴ� ��� �÷��� ����
-- UNIQUE INDEX, NONUNIQUE INDEX�� ����

-- UNIQUE INDEX
-- UNIQUE INDEX �� ������ �÷����� �ߺ��� ���Ե� �� ����.
-- ����Ŭ�� 'PRIMARY KEY' ���������� �����ϸ� �ڵ����� �ش� �÷��� UNIQUE INDEX�� ������

-- NONUNIQUE INDEX
-- ����ϰ� ���Ǵ� �Ϲ� �÷��� ������� ������
-- �ַ� ���� ����� ���� �������� ������

-- UNIQUE INDEX ����
CREATE UNIQUE INDEX IDX_DNM
ON DEPARTMENT (DEPT_NAME);

-- NONUNIQUE INDEX ����
CREATE INDEX IDX_JID
ON EMPLOYEE (JOB_ID);

-- �ε��� ���� �ǽ� -----------------------------------------------------

-- 1. EMPLOYEE ���̺��� EMP_NAME

CREATE UNIQUE INDEX IDX_ENM ON EMPLOYEE(EMP_NAME);

-- 2. ������ ���� ���ο� �����͸� �Է��� ����,
-- ���� ������ �����غ��ÿ�
INSERT INTO EMPLOYEE (EMP_ID, EMP_NO, EMP_NAME)
VALUES ('400', '871120-1243877', '���켷');
-- EMP_NAME �÷��� �̹� '���켷' �̸��� �����Ͱ� �����ϱ� ������ �ߺ��Ǵ� ���� �Էµ� �� ����
-- UNIQUE INDEX�� UNIQUE ���������� ����� ����

CREATE UNIQUE INDEX IDX_DID ON EMPLOYEE(DEPT_ID);


DESC USER_INDEXS;
DESC USER_IND_COLUMNS;

SELECT INDEX_NAME, COLUMN_NAME, INDEX_TYPE, UNIQUENESS;



-- �˻� �ӵ� ���� ����
-- EMPLOYEE ���̺��� ��� ������ ���������� ������
-- EMPL01, EMPL02 ���̺��� ����
-- EMPL01, EMP_ID �÷��� ���� UNIQUE INDEX �����
-- �˻��ӵ� �� ��ȸ�� : �� ���̺� ���� ���� �׽�Ʈ
-- EMP_ID �� ������ ���� ���� ��ȸ�� : �ӵ� Ȯ����

CREATE TABLE EMPL01
AS
SELECT * FROM EMPLOYEE;

CREATE TABLE EMPL02
AS
SELECT * FROM EMPLOYEE;

CREATE UNIQUE INDEX IDX_EID
ON EMPL01(EMP_ID);

SELECT * FROM EMPL01
WHERE EMP_ID = '141';

SELECT * FROM EMPL02
WHERE EMP_ID = '141';


-- ���� �ε���
-- �� ���� �÷����� ������ �ε��� => ���� (SINGLE) �ε���
-- �� ���̻��� �÷����� �ε����� �����ϴ� ��

CREATE TABLE DEPT01
AS
SELECT * FROM DEPARTMENT;

-- �μ���ȣ�� �μ����� �����Ͽ� �ε��� �����ϱ�
CREATE INDEX IDX_DEPT01_COMP
ON DEPT01 (DEPT_ID, DEPT_NAME);

-- ������ ��ųʸ����� Ȯ���� ��
SELECT INDEX_NAME, COLUMN_NAME
FROM USER_IND_COLUMNS
WHERE TABLE_NAME = 'DEPT01';

-- �Լ� ��� �ε���
-- SELECT ���̳� WHERE ���� ��������̳� �Լ����� ���� ���
-- ������ �ε��� ������ ���� �ʴ´�.
-- �������� �˻��ϴ� ��찡 ���ٸ�, �����̳� �Լ����� �ε����� ���� �� ����

CREATE TABLE EMP01
AS
SELECT * FROM EMPLOYEE;

CREATE INDEX IDX_EMP01_SALCALC
ON EMP01 ((SALARY + (SALARY * NVL(BONUS_PCT, 0))*12));

SELECT INDEX_NAME, COLUMN_NAME
FROM USER_IND_COLUMNS
WHERE TABLE_NAME = 'EMP01';


-- ���Ǿ� (SYNONYM) *********************************************************
-- �ٸ� �����ͺ��̽��� ���� ��ü�� ���� ������.
-- ���� ����ڰ� ���̺��� ������ ���, �ٸ� ����ڰ� ���̺� ������ ��
-- ����ڸ�.���̺�� ���� ǥ����
-- �̶� ���Ǿ �����ϸ� �����ϰ� ����� �� ����

-- �������
-- CREATE SYNONYM ���Ӹ� FOR ����ڸ�.��ü��;

-- �� : ���̺�� ���Ӹ� �����
CREATE SYNONYM EP FOR EMPLOYEE;

SELECT * FROM EP;

-- �� :
SELECT * FROM SCOTT.EMP;   -- ERROR ���Ѿ���

SELECT * FROM SYS.DUAL;

-- ���Ǿ�� ��� ����ڸ� ������� �ϴ� ����(PUBLIC) ���Ǿ��
-- ���� ����ڸ� ������� �ϴ� ����� ���Ǿ ����.
-- ���� ���Ǿ�� SYSTEM �������� ������ ��.

/*
    CREATE PUBLIC SYNONYM ���Ǿ��̸�
    FOR ����ڸ�.��ü��;
*/

-- SYSTEM �� �ο��� SYSTBL ���̺� SELECT �� �� �ִ��� Ȯ��
SELECT * FROM SYSTEM.SYSTBL;

CREATE SYNONYM STB
FOR SYSTEM.SYSTBL;

SELECT * FROM STB;

-- ���Ǿ� �����ϱ�
-- DROP SYNONYM �̸�;
-- ����� ���Ǿ� : �ش� ����� �������� ������
DROP SYNONYM EP;

SELECT * FROM EP; -- ERROR : ������

-- ���� ���Ǿ� : SYSTEM �������� ������
-- DROP PUBLIC SYNONYM �̸�;


-- ����� ����
-- ����� ������ ��ȣ ����, ���Ѻο�

-- ����Ŭ �����ͺ��̽� ��ġ�ϸ�, �⺻������ �����Ǵ� ������ 
-- SYS, SYSTEM, HR(�������), SCOTT(11G ������ ����)

-- ������ ���� �����ͺ��̽� ������
--  : ����ڰ� �����ͺ��̽��� ��ü(���̺�, �� ��)�� ���� Ư�� ������ ���� �� �ְ� ��
--    �ټ��� ����ڰ� �����ϴ� �����ͺ��̽� ������ ���� ���� ������
--    �����ͺ��̽��� �����ϴ� ����ڸ��� ���� �ٸ� ���Ѱ� ���� �ο���

-- ���� : ����ڰ� Ư�� ���̺� ������ �� �ֵ��� �ϰų�,
--        �ش� ���̺� SQL��(SELECT/INSERT/UPDATE/DELETE)�� ����� �� �ֵ��� ������ �δ� ��

/*
    �ý��� ���� : �����ͺ��̽� �����ڰ� ������ �ִ� ����
        CREATE USER (����� ���� �����)
        DROP USER (����� ���� ����)
        DROP ANY TABLE (������ ���̺� ���� ����)
        QUERY REWRITE (�Լ� ��� �ε��� ����)
        BACKUP ANY TABLE (���̺� ���)
        
    �ý��� �����ڰ� ����ڿ��� �ο��ϴ� ����
        CREATE SESSION (�����ͺ��̽��� ����)
        CREATE TABLE (���̺� ����)
        CREATE VIEW (�� ����)
        CREATE SEQUENCE (������ ����)
        CREATE PROCEDURE (���ν���/�Լ� ����)
    
    ��ü ���� : ��ü�� ������ �� �ִ� ����
*/

-- ����� ���� ����
-- �����ͺ��̽��� ������ �� �ִ� ���̵�� ��ȣ�� ����
/*
    ����
    CREATE USER ����ھ��̵� IDENTIFIED BY ��ȣ;
*/
