-- DAY9 ��������

-- ������ ���Ἲ �������ǵ�(CONSTRAINTS)
-- ���̺� �ԷµǴ� ���鿡 ������ ���� �ϱ����� �ڵ� �˻����� �ǹ���
-- ���̺� ���� �� �ش� �÷��� ���������� ������
-- ���̺� ���� ������ ���� ������ ���� ����.

-- NOT NULL ��������
-- �÷��� ���� �ݵ�� ����ؾ� �� (�ʼ��Է��׸��� ����)
-- �÷� ���������� ������ �� �ִ� ����������

CREATE TABLE TESTNN (
    NNID NUMBER(5) NOT NULL,    -- �÷� ����
    NN_NAME VARCHAR2(20)
);

INSERT INTO TESTNN (NNID, NN_NAME)
-- VALUES (NULL, NULL);  -- NNID �� NOT NULL �������� �����
-- ����
VALUES (NULL, 'ORACLE'); -- ERROR


INSERT INTO TESTNN
VALUES (1, NULL);

SELECT * FROM TESTNN;

-- ���̺� ���� ���� ��
CREATE TABLE TESTNN2 (
    NN_ID NUMBER(5) CONSTRAINT T2NNID NOT NULL,
    NN_NAME VARCHAR2(20)
    

    -- ���̺� ������ �������� �ۼ� ��ġ
    -- [CONSTRAINT �̸�] ������������ (�������÷���);
--    CONSTRAINT T2NNAME NOT NULL (NN_NAME)
    -- NOT NULL ���������� ���̺� �������� ������ �� ����
);


-- UNIQUE ��������
-- �ش� �÷��� �ߺ���(������ �ι��Է�) �Է��� ���� ����������
-- ���� ���� �� �� ��� ���ϴ� �÷��� ��
CREATE TABLE TESTUN (
    UN_ID CHAR(3) UNIQUE,
    UN_NAME VARCHAR2(10) NOT NULL
);

ROLLBACK;
INSERT INTO TESTUN
VALUES ('AAA', 'ORACLE'); --ERROR

INSERT INTO TESTUN
VALUES ('AAA', 'JAVA');

INSERT INTO TESTUN
VALUES ('AAB', 'JAVA');

INSERT INTO TESTUN
VALUES (NULL, 'JAVA');
-- UNIQUE �������� �÷����� NULL �� ����� �� ����

SELECT *FROM TESTUN;

CREATE TABLE TESTUN2 (
    UN_ID2 CHAR(3) CONSTRAINT T2UN2 UNIQUE,
    UN_NAME2 VARCHAR2(10) CONSTRAINT T2UN2NN NOT NULL
);

CREATE TABLE TESTUN3 (
    UN_ID3 CHAR(3),
    UN_NAME3 VARCHAR2(10) CONSTRAINT T3UN3NN NOT NULL,
    CONSTRAINT T3UNID3 UNIQUE (UN_ID3)
);

CREATE TABLE TABLE_UNIQUE2 (
    ID CHAR(3), SNAME VARCHAR2(20), SCODE CHAR(2),
    CONSTRAINT TN2_ID_UN UNIQUE (ID,SNAME)
);

INSERT INTO TABLE_UNIQUE2
VALUES ('100', 'ORACLE', '01');

INSERT INTO TABLE_UNIQUE2
VALUES ('200', 'ORACLE', '01');   -- 2���� Ŀ���� ��� �ϳ��� ������ ��

INSERT INTO TABLE_UNIQUE2
VALUES ('200','ORACLE','02');   -- ����

SELECT * FROM TABLE_UNIQUE2;

-- UNIQUE �������� ���� �÷����� NULL ����� �� ����
-- ��, ���� ���� �÷��� ��� UNIQUE ���������� ������ ��쿡�� ���� �����
-- ���� �÷� ��� NULL �� ���� �ߺ� ��� ������
INSERT INTO TABLE_UNIQUE2
VALUES (NULL, NULL, '02');

INSERT INTO TABLE_UNIQUE2
VALUES (NULL, NULL, '03');

-- ������ �÷��� �ϳ��� ���� ��ϵǸ� �ߺ� �˻���
INSERT INTO TABLE_UNIQUE2
VALUES (NULL, 'JAVA', '04');

INSERT INTO TABLE_UNIQUE2
VALUES (NULL, 'JAVA', '05');   -- ERROR

SELECT * FROM TABLE_UNIQUE2;

CREATE TABLE TABLE_PK (
    ID CHAR(3) PRIMARY KEY,
    SNAME VARCHAR2(20)
);

-- PRIMARY KEY (�⺻Ű) ��������
-- ���̺��� �� ���� ������ ã�� ���� ����� �÷��� ������
-- NOT NULL + UNIQUE
-- �� ���̺� �� ���� ����� �� ����

INSERT INTO TABLE_PK
VALUES ('100','ORACLE');

INSERT INTO TABLE_PK
VALUES ('100','IBM');  -- ERROR

INSERT INTO TABLE_PK
VALUES (NULL, 'SUN');  -- ERROR : ID �÷��� NULL ���

-- �� ���̺� �� �� ���� ������ �� ����
CREATE TABLE TESTPK2 (
    PID NUMBER PRIMARY KEY,
    PNAME VARCHAR2(15) PRIMARY KEY
);  -- ERROR

-- �÷��������� �̸� �ٿ� ����
CREATE TABLE TESTPK2 (
    PID NUMBER CONSTRAINT T2PID PRIMARY KEY,
    PNAME VARCHAR2(15),
    PDATE DATE
);

-- ���̺� �������� �̸� �ٿ� ����
CREATE TABLE TESTPK3 (
    PID NUMBER,
    PNAME VARCHAR2(15),
    PDATE DATE,
    CONSTRAINT T3PID PRIMARY KEY (PID)
);

CREATE TABLE TABLE_PK2 (
    ID CHAR(3),
    SNAME VARCHAR2(20),
    SCODE CHAR(2),
    CONSTRAINT TP2_PK PRIMARY KEY (ID,SNAME)
);

INSERT INTO TABLE_PK2
VALUES ('100','ORACLE','01');

INSERT INTO TABLE_PK2
VALUES ('200','ORACLE','01');


INSERT INTO TABLE_PK2
VALUES ('100','ORACLE','02');  -- ERROR : 2���� ��� �ϳ��� ������ ��
-- �ߺ���

INSERT INTO TABLE_PK2
VALUES (NULL,'ORACLE','01');  -- ERROR : ���� �÷����� NULL ��� �� ��

SELECT * FROM TABLE_PK2;


-- CHECK : Ŀ���� ��ϵǴ� ���� ���� ������ �� �� ����
-- CHECK (�÷��� ������ �񱳰�) : �񱳰��� ���ͷ��� �����, �Լ� ��� ����.

CREATE TABLE TABLE_CHECK (
    EMP_ID CHAR(3) PRIMARY KEY,
    SALARY NUMBER CHECK ( SALARY > 0 ),
    MARRIAGE CHAR(1),
    CONSTRAINT CHK_MRG CHECK ( MARRIAGE IN ( 'Y','N' ) ) 
);

INSERT INTO TABLE_CHECK
VALUES ('100', -100, 'Y');   -- ERROR : SALARY �÷��� ����� ���� ������.

INSERT INTO TABLE_CHECK
VALUES ('100', 500, '?');  -- ERROR : 


CREATE TABLE TABLE_CHECK2 (
    ID CHAR(3) PRIMARY KEY,
    HIREDATE DATE CHECK ( HIREDATE < SYSDATE ) 
);  -- CHECK ���ǿ� �Լ� ��� �� �� (���ͷ� : �� �� ����� �� ����)

CREATE TABLE TABLE_CHECK3 (
    EID CHAR(3) PRIMARY KEY,
    ENAME VARCHAR2(10) NOT NULL,
    SALARY NUMBER ,
    MARRIAGE CHAR(1),
    CHECK ( SALARY > 0 AND SALARY < 1000000 )
);  -- ���� ������ ������ �� ����.

CREATE TABLE TESTCHK (
    C_NAME VARCHAR2(15 CHAR) PRIMARY KEY,
    C_PRICE NUMBER(5) CONSTRAINT TCHK_PRICE CHECK (C_PRICE >= 1 AND C_PRICE <= 99999),
    C_LEVEL CHAR(1),
    C_DATE DATE CHECK (C_DATE > TO_DATE('2016/01/01', 'YYYY/MM/DD')),   -- BUG (�Լ���� ����)
    CONSTRAINT TCHK_CLEVEL CHECK (C_LEVEL = 'A' OR C_LEVEL = 'B' OR C_LEVEL = 'C')
);

-- FOREIGN KEY (�ܺ�Ű/�ܷ�Ű/����Ű) ��������
-- �ٸ� ���̺��� �����ϴ� ���� ����ϴ� �÷� ������ ����ϴ� ��������
-- �����(�����ϴ� : REFERENCES) ���̺��� �����ϴ� ���� ����� �� ����
-- NULL �� ����� �� ����.
-- �����ϴ� ���� �ش��ϴ� �÷��� �ݵ�� �⺻Ű(PRIMARY KEY)�̰ų�,
-- UNIQUE ���������� ������ �÷��� ������ �� ����

--[CONSTRAINT �������̸� FOREIGN KEY (������ �÷���)]
-- REFERENCES ���������̺�� [(�������÷���)]
-- ����� ���̺��� ���� �÷��� �������� �ʴ� ���� ����ϸ� ������.

CREATE TABLE TABLE_FK (
    ID CHAR(3),
    SNAME VARCHAR2(20),
    LID CHAR(2) REFERENCES LOCATION ( LOCATION_ID )
);

INSERT INTO TABLE_FK
VALUES ('200','ORACLE','C1');
-- ERROR : LOCATION ���̺��� LOCATION_ID �÷��� �������� �ʴ� ���� ����Ͽ���

CREATE TABLE TABLE_FK2 (
    ID CHAR(3),
    SNAME VARCHAR2(20),
    LID CHAR(2),
    CONSTRAINT FK1 FOREIGN KEY ( LID ) REFERENCES LOCATION ( LOCATION_ID )
);


CREATE TABLE TABLE_NOPK (
    ID CHAR(3),
    SNAME VARCHAR2(20)
);

CREATE TABLE TABLE_FK3 (
    ID CHAR(3) REFERENCES TABLE_NOPK,
    SNAME VARCHAR2(20)
);

CREATE TABLE TABLE_FK3 (
    ID CHAR(3) REFERENCES TABLE_NOPK(ID),
    SNAME VARCHAR2(20)
);  -- PRIMARY KEY �� UNIQUE �÷��̾ƴ�


-- FOREIGN KEY �������� ������ �߰��� �� �ִ� ���� �ɼ�(���û���)
-- DELETION OPTION
-- �⺻ �������� �θ�Ű�� �ش��ϴ� �÷� ���� ���� ���� �� ��

-- ON DELETE RESTRICT (�⺻����)
-- �ڽ�Ű�� �մ� �θ�Ű�� ���� �Ұ���
DELETE FROM DEPARTMENT
WHERE DEPT_ID = '90';  -- ERROR
-- EMPLOYEE �� DEPT_ID �÷����� '90'�� ���ǰ� ����

-- ON DELETE SET NULL
-- �θ�Ű�� �����Ǹ� �ڽ�Ű�� NULL�� �����
CREATE TABLE EMPCPY (
    EMP_ID CHAR(3) PRIMARY KEY,
    DEPT_ID CHAR(2) REFERENCES DEPARTMENT ON DELETE SET NULL
);

INSERT INTO EMPCPY
VALUES ('111', '30');

SELECT * FROM EMPCPY;

DELETE FROM DEPARTMENT 
WHERE DEPT_ID = '30';

ROLLBACK;   -- ���� ���

-- ON DELETE CASCADE : �θ�Ű ������ �ڽ� ���ڵ� �Բ� ������
CREATE TABLE EMPCPY2 (
    EMP_ID CHAR(3) PRIMARY KEY,
    DEPT_ID CHAR(2) REFERENCES DEPARTMENT ON DELETE CASCADE
);

INSERT INTO EMPCPY2
VALUES ('777', '30');

SELECT * FROM EMPCPY2;  -- �ڽ� ���ڵ� ���� Ȯ��

DELETE FROM DEPARTMENT
WHERE DEPT_ID = '30';

ROLLBACK;  -- ���� ���

-- ������ �θ� ���̺��� �θ�Ű�� ���� �÷��̸�, �ڽ�Ű�� �÷��� �����ؾ� ��
-- PRIMARY KEY (ID, SNAME) �� ���, �Ǵ� UNIQUE (ID, SNAME) �� ���
-- FOREIGN KEY (ID, SNAME) �̾�� �Ѵٴ� �ǹ���.

    
CREATE TABLE CONSTRAINT_EMP
(EID CHAR(3) CONSTRAINT PKEID PRIMARY KEY,
ENAME VARCHAR2(20) CONSTRAINT NENAME NOT NULL,
ENO CHAR(14) CONSTRAINT NENO NOT NULL CONSTRAINT UENO UNIQUE,
EMAIL VARCHAR2(25) CONSTRAINT UEMAIL UNIQUE,
PHONE VARCHAR2(12),
HIRE_DATE DATE DEFAULT SYSDATE,
JID CHAR(2) CONSTRAINT FKJID REFERENCES JOB ON DELETE SET NULL,
SALARY NUMBER,
BONUS_PCT NUMBER,
MARRIAGE CHAR(1) DEFAULT 'N' CONSTRAINT CHK CHECK (MARRIAGE IN ('Y','N')),
MID CHAR(3) CONSTRAINT FKMID REFERENCES CONSTRAINT_EMP ON DELETE SET NULL,
DID CHAR(2),
CONSTRAINT FKDID FOREIGN KEY (DID) REFERENCES DEPARTMENT ON DELETE CASCADE
);

-- SELECT ���� ����� ���̺� ��� ������ �������� �����
CREATE TABLE TABLE_SUBQUERY1
AS SELECT EMP_ID, EMP_NAME, SALARY, DEPT_NAME, JOB_TITLE
FROM EMPLOYEE
LEFT JOIN DEPARTMENT USING (DEPT_ID)
LEFT JOIN JOB USING (JOB_ID);

SELECT * FROM TABLE_SUBQUERY1;

-- ���̺� ���� Ȯ�ο� ��ɾ� : DESCRIBE | DESC ���̺��;
DESC TABLE_SUBQUERY1;

-- ���������� �̿��ؼ� ������ ���̺��� ������ ���, 
-- �÷���, �ڷ���, NOT NULL ��������, DEFAULT ���� �����
-- ������ �������ǵ��� ���� �� ��.

-- ���, �̸�, �޿�, ���޸�, �μ���, �ٹ�������, �Ҽӱ����� ��ȸ
-- ��ȸ�� ����� EMP_LIST ���̺� ������

CREATE TABLE EMP_LIST AS
SELECT EMP_ID, EMP_NAME, SALARY, JOB_TITLE, DEPT_NAME, LOC_DESCRIBE, COUNTRY_NAME
FROM EMPLOYEE
LEFT JOIN JOB USING (JOB_ID)
LEFT JOIN DEPARTMENT USING (DEPT_ID)
LEFT JOIN LOCATION ON (LOC_ID = LOCATION_ID)
LEFT JOIN COUNTRY USING (COUNTRY_ID);

SELECT * FROM EMP_LIST;

CREATE TABLE EMP_LIST AS
SELECT EMP_ID, EMP_NAME, SALARY, JOB_TITLE, DEPT_NAME, LOC_DESCRIBE, COUNTRY_NAME
FROM EMPLOYEE E, JOB J, DEPARTMENT D, LOCATION LO, COUNTRY C
WHERE E.JOB_ID = J.JOB_ID(+) AND E.DEPT_ID = D.DEPT_ID(+) AND D.LOC_ID = LO.LOCATION_ID(+)
AND LO.COUNTRY_ID = C.COUNTRY_ID(+);

SELECT * FROM EMP_LIST;

CREATE TABLE EMP_MAN AS
SELECT * FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) IN ('1', '3');

DROP TABLE EMP_FEMAIL;

CREATE TABLE EMP_FEMAIL AS
SELECT * FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) IN ('2', '4');

CREATE TABLE PART_LIST AS
SELECT DEPT_NAME, JOB_TITLE, EMP_NAME, EMP_ID
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (EMPLOYEE.DEPT_ID = DEPARTMENT.DEPT_ID)
LEFT JOIN JOB ON (EMPLOYEE.JOB_ID = JOB.JOB_ID)
ORDER BY DEPARTMENT.DEPT_ID;

SELECT * FROM PART_LIST;

COMMENT ON COLUMN PART_LIST.DEPT_NAME IS '�μ���';
COMMENT ON COLUMN PART_LIST.JOB_TITLE IS '���޸�';
COMMENT ON COLUMN PART_LIST.EMP_NAME IS '�����';
COMMENT ON COLUMN PART_LIST.EMP_ID IS '�����';

CREATE TABLE PHONEBOOK (
    ID CHAR(3),
    PNAME VARCHAR2(20) CONSTRAINT NN_PBNAME NOT NULL,
    PHONE VARCHAR2(15) CONSTRAINT NN_PBPHONE NOT NULL,
    ADDRESS VARCHAR2(100) DEFAULT '����� ���α�',
    CONSTRAINT PK_PBID PRIMARY KEY(ID),
    CONSTRAINT UN_PBPHONE UNIQUE (PHONE)
);

INSERT INTO PHONEBOOK
VALUES ('A01', 'ȫ�浿', '010-1234-5678', DEFAULT);

SELECT * FROM PHONEBOOK;

-- ������ ��ųʸ� (����)
-- ����ڰ� ������ ��� ��ü������ ���̺� ������ ����ǰ� ����
-- ���� ���, ����ڰ� ���� �������ǵ� ����ǰ� ����
-- USER_CONSTRAINTS 

DESC USER_CONSTRAINTS;

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME
FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'PHONEBOOK';

-- CONSTRAINT_TYPE 
-- P : PRIMARY KEY
-- U : UNIQUE
-- C : CHECK, NOT NULL
-- R : FOREIGN KEY

-- ���������� ������ ���̺��� ���� ��, �����ʹ� �������� �ʰ� 
-- ������ ������ ��� 
-- �������� WHERE 1 = 0 �ϸ� ��
CREATE TABLE DEPT_COPY
AS
SELECT * FROM DEPARTMENT
WHERE 1 = 0;

SELECT * FROM DEPT_COPY;
DESC DEPT_COPY;

DESC DEPARTMENT;

-- ���������� �� ���̺� ���� ��, ���������� �÷����� ������� �ʰ�
-- �÷����� �ٸ��� ������ ���� �ִ�.
CREATE TABLE JOB_COPY (�����ڵ�, ���޸�, �����޿�, �ְ�޿�)
AS
SELECT * FROM JOB;

DESC JOB_COPY;
SELECT * FROM JOB_COPY;

-- �������� SELECT ���� �÷��� ��Ī �ٿ��൵ ���� ����� ����
CREATE TABLE DCOPY
AS
SELECT DEPT_ID DID, DEPT_NAME DNAME, LOC_ID LID
FROM DEPARTMENT;

DESC DCOPY;
SELECT * FROM DCOPY;

-- ���������� �� ���̺��� ���� ��, �÷����� �ٲٸ鼭 �������ǵ� �߰��� �� ����
-- �ܺ�Ű ������ �߰��� �� ���� (references ���̺�� (�÷���))
CREATE TABLE TABLE_SUBQUERY3 (
    EID PRIMARY KEY,
    ENAME,
    SALARY CHECK (SALARY > 2000000),
    DNAME,
    JTITLE NOT NULL
) AS
SELECT EMP_ID, EMP_NAME, SALARY, DEPT_NAME, NVL(JOB_TITLE, '������')
FROM EMPLOYEE
LEFT JOIN DEPARTMENT USING (DEPT_ID)
LEFT JOIN JOB USING (JOB_ID)
WHERE SALARY > 2000000;

SELECT * FROM TABLE_SUBQUERY3;

-- ������ ��ųʸ��� Ȯ���� ��
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, SEARCH_CONDITION
FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'TABLE_SUBQUERY3';







    