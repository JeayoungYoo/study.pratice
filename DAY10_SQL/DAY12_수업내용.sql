-- DAY12 ��������

-- DML(Data Manipulation Language)
-- ������ ���� ���
-- INSERT, UPDATE, DELETE, TRUNCATE
-- ���̺� �����͸� �߰��ϰų�, ��ϵ� �����͸� �����ϰų�,
-- �����Ͱ� ��ϵ� ���� ������ ��쿡 ����ϴ� ������
-- INSERT �� : ���� �߰���
-- UPDATE �� : �����͸� ������, �� ���� ��������
-- DELETE �� : ���� ������. �� ������ �پ��
-- TRUNCATE �� : ���̺��� ��� ���� ������, ���� �� ��



SELECT * FROM DCOPY;

-- WHERE ���� �����Ǹ� �÷� ��ü�� ���� �����
UPDATE DCOPY
SET DNAME = '�λ���';

ROLLBACK;

UPDATE DCOPY
SET DNAME = '�λ���'
WHERE DID = '10';

SELECT * FROM DCOPY;


-- UPDATE ���� �������� ����� �� ����
-- SET ���� WHERE ������ ��� ������

-- ���ϱ� ������ �����ڵ�� �޿��� ���ر� ������ �����ڵ�� �޿��� ���� ������ ����

UPDATE EMPLOYEE
SET JOB_ID = (SELECT JOB_ID FROM EMPLOYEE
            WHERE EMP_NAME = '���ر�'),
    SALARY = (SELECT SALARY FROM EMPLOYEE
            WHERE EMP_NAME = '���ر�')
WHERE EMP_NAME = '���ϱ�';

ROLLBACK;

SELECT JOB_ID, SALARY FROM EMPLOYEE
WHERE EMP_NAME = '���ϱ�';

-- �Ǵ� ���߿� ���������� �̿��� ���

UPDATE EMPLOYEE
SET (JOB_ID, SALARY) = (SELECT JOB_ID, SALARY
                        FROM EMPLOYEE
                        WHERE EMP_NAME = '���ر�')
WHERE EMP_NAME = '���ϱ�';

-- Ȯ��
SELECT EMP_NAME, JOB_ID, SALARY
FROM EMPLOYEE
WHERE EMP_NAME IN ('���ϱ�', '���ر�');

ROLLBACK;

-- UPDATE �ÿ� ������ ���� DEFAULT Ű���� ����� �� ����
SELECT EMP_NAME, MARRIAGE
FROM EMPLOYEE
WHERE EMP_ID = '210';

UPDATE EMPLOYEE
SET MARRIAGE = DEFAULT
WHERE EMP_ID = '210';

ROLLBACK;

-- UPDATE ���� WHERE �������� ���������� ����� �� ����

-- �ؿܿ���2�� �������� ���ʽ�����Ʈ�� ��� 0.3���� �����Ͻÿ�.

UPDATE EMPLOYEE
SET BONUS_PCT = '0.3'
WHERE DEPT_ID = (SELECT DEPT_ID
                 FROM DEPARTMENT
                 WHERE DEPT_NAME = '�ؿܿ���2��');
                 
SELECT EMP_NAME, DEPT_ID, BONUS_PCT
FROM EMPLOYEE
WHERE DEPT_ID = (SELECT DEPT_ID
                 FROM DEPARTMENT
                 WHERE DEPT_NAME = '�ؿܿ���2��');
                 
ROLLBACK;

-- �� ����� ���Ἲ �������ǿ� ������� �ʰ� �ؾ� ��
UPDATE EMPLOYEE
SET DEPT_ID = '65'
WHERE DEPT_ID IS NULL;

-- INSERT ��
-- ���̺� �� ���� �߰��� �� ����� : �� ���� �þ

/*
    INSERT INTO ���̺�� [(�÷���, �÷���, ....)]
    VALUES (��, ��, ....);
*/

CREATE TABLE DEPT
    (DEPT_ID CHAR(2), 
     DEPT_NAME VARCHAR2(30));
     
SELECT COUNT(*) FROM DEPT;

INSERT INTO DEPT VALUES ('20', 'ȸ����');

SELECT COUNT(*) FROM DEPT;

INSERT INTO DEPT VALUES ('10', '�λ���');

SELECT COUNT(*) FROM DEPT;

COMMIT;

INSERT INTO EMPLOYEE ( EMP_ID, EMP_NO, EMP_NAME, EMAIL, PHONE, HIRE_DATE, 
                       JOB_ID, SALARY, BONUS_PCT, MARRIAGE, MGR_ID, DEPT_ID )
VALUES ('900', '811126-1484710', '������', 'oyuh@vcc.com', '01012345678', 
        '06/01/01', 'J7', 3000000, 0, 'N', '176', '90' );

SELECT * FROM EMPLOYEE WHERE EMP_ID = '900';

ROLLBACK;

INSERT INTO EMPLOYEE VALUES
('910', '�̺���', '781010-1443269', 'TK1@VCC.COM', '01077886655', '04/01/01', 'J7',
 3500000, 0.1, DEFAULT, '176', '90');
 
 SELECT * FROM EMPLOYEE
 WHERE EMP_ID = '910';

-- INSERT �ÿ� ���ϴ� �÷����� �� ����� �� ���� 
INSERT INTO EMPLOYEE (EMP_ID, EMP_NO, EMP_NAME, PHONE, HIRE_DATE, JOB_ID,
                       SALARY, BONUS_PCT, MARRIAGE)
VALUES ('880', '860412-2377610', '��ä��', '0193382662', '06/01/01', 'J7', 3000000, 0, 'N');

-- ���ܵ� �÷��� ���� ��� NULL ��
SELECT * FROM EMPLOYEE
WHERE EMP_ID = '880';


-- ���� ������� ���� �÷����� NULL�� ���� ����ص� ��
INSERT INTO EMPLOYEE VALUES
('840', '������', '870115-2253408', 'ju_ha@vcc.com', NULL, '07/06/15',
'J7', NULL, NULL, 'N', NULL, NULL);
-- SQL������ NULL �� '' (�����ǥ)�� ���� �ǹ������� JAVA������ �ٸ� �ǹ��̱� ������ �����Ͽ��� ��

SELECT * FROM EMPLOYEE
WHERE EMP_ID = '840';

-- INSERT �� �� ��ſ� DEFAULT Ű���� ����ص� ��
-- ���̺� ������ �÷��� ������ DEFAULT ���� ��Ͽ� ����
-- DEFAULT �� ���� �� �� �÷��� ����ϸ�, NULL ó����
INSERT INTO EMPLOYEE (EMP_ID, EMP_NO, EMP_NAME, SALARY, MARRIAGE)
VALUES ('860', '810429-2165344', '������', DEFAULT, DEFAULT);

SELECT * FROM EMPLOYEE
WHERE EMP_ID = '860';

CREATE TABLE EMP
(EMP_ID CHAR(3),
EMP_NAME VARCHAR2(20),
DEPT_NAME VARCHAR2(20));

INSERT INTO EMP (SELECT EMP_ID, EMP_NAME, DEPT_NAME
                 FROM EMPLOYEE
                 LEFT OUTER JOIN DEPARTMENT USING (DEPT_ID));
-- ���������� () �� ��� �� �ص� ��

SELECT * FROM EMP;

-- DELETE ��
-- ���� �����ϴ� ������

DELETE FROM EMPLOYEE;
-- WHERE ���� �����Ǹ� ���̺� ���� ��� ���� ������

-- Ȯ��
SELECT * FROM EMPLOYEE;

-- ���� ���
ROLLBACK;

-- �ٸ� ���̺��� FOREIGN KEY ������������ �����ǰ� �ִ� ���
-- �θ�Ű�� �ش��ϴ� �÷��� ���� ���� ���� �� ��

DELETE FROM DEPARTMENT
WHERE DEPT_ID = '30';

SELECT * FROM DEPARTMENT;

ROLLBACK;

-- �����ϰ��� �� ���
-- ��� 1 : �ڽ� ���ڵ尡 �ִ� ���̺��� �ܷ�Ű ���������� ��Ȱ��ȭ ��Ű�� ������

ALTER TABLE EMPLOYEE
-- DISABLE CONSTRAINT FK_DEPTID;  -- ��Ȱ��ȭ��Ŵ
-- ENABLE CONSTRAINT FK_DEPTID;  -- Ȱ��ȭ��Ŵ


-- TRUNCATE : ���̺��� ��ü �� ���� ����
-- ���� �ӵ� ����, ���� �� ��
TRUNCATE TABLE DCOPY;

SELECT * FROM DCOPY;

ROLLBACK;

ALTER TABLE EMPLOYEE DROP CONSTRAINTS FK_MGRID;

ALTER TABLE EMPLOYEE ADD CONSTRAINTS FK_MGRID FOREIGN KEY (MGR_ID)

REFERENCES EMPLOYEE ON DELETE SET NULL;
DELETE FROM EMPLOYEE WHERE EMP_ID = '141';

ROLLBACK;

ALTER TABLE EMPLOYEE DROP CONSTRAINTS FK_JOBID;
ALTER TABLE EMPLOYEE ADD CONSTRAINTS FK_JOBID FOREIGN KEY (JOB_ID)
REFERENCES JOB ON DELETE CASCADE;
DELETE FROM JOB WHERE JOB_ID = 'J2';

ROLLBACK;

-- ���� ���̺� �ѹ��� INSERT �ϱ�
-- ���, �̸�, �Ի��Ͽ� ���� ������ ������ EMP_HIRE ���̺� �����
CREATE TABLE EMP_HIRE
AS
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE 1 = 0;

SELECT * FROM EMP_HIRE;
DESC EMP_HIRE;

-- 2. �μ��ڵ尡 '20' �� ������ ������ ������ ����
INSERT INTO EMP_HIRE
(SELECT EMP_ID, EMP_NAME, HIRE_DATE
 FROM EMPLOYEE
 WHERE DEPT_ID = '20');
 
SELECT * FROM EMP_HIRE;

ROLLBACK;  -- ��� INSERT ���

-- 3. ���, �̸�, �����ڻ���� ������ ������ EMP_MGR ���̺� �����
CREATE TABLE EMP_MGR
AS
SELECT EMP_ID, EMP_NAME, MGR_ID
FROM EMPLOYEE
WHERE 1 = 0;

DESC EMP_MGR;

-- 4. �� ���� ���̺� �ѹ��� INSERT �ϱ�
-- INSERT ALL ���� �����
-- �� ���������� �������� ������ ����, ���������� �����ϴ� ���̺� ���� ��쿡 ���.

INSERT ALL
INTO EMP_HIRE VALUES (EMP_ID, EMP_NAME, HIRE_DATE)
INTO EMP_MGR VALUES (EMP_ID, EMP_NAME, MGR_ID)
(SELECT EMP_ID, EMP_NAME, HIRE_DATE, MGR_ID
 FROM EMPLOYEE
 WHERE DEPT_ID = '20');
 
SELECT * FROM EMP_HIRE;
SELECT * FROM EMP_MGR;

-- ������ �����ϴ� ��쿡�� INSERT ALL �ǰ� �� ���� ����
CREATE TABLE EMP_SAL
AS
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE 1=0;

-- EMP_HIRE ���̺��� �Ի����� 2000�� 1�� 1�� ���Ŀ� �Ի��� ������ ������ INSERT �ϰ�
-- EMP_SAL ���̺��� �޿��� 2�鸸���� �ʰ��ϴ� ������ ������ INSERT �ǰ� ��

DELETE EMP_HIRE;
DELETE EMP_SAL;

INSERT ALL
WHEN HIRE_DATE > TO_DATE ('2000-01-01', 'YYYY-MM-DD')
THEN INTO EMP_HIRE VALUES (EMP_ID, EMP_NAME, HIRE_DATE)
WHEN SALARY > 2000000
THEN INTO EMP_SAL VALUES (EMP_ID, EMP_NAME, SALARY)
(SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
 FROM EMPLOYEE);
 
SELECT * FROM EMP_HIRE;
SELECT * FROM EMP_SAL;

-- MERGE
-- �� ���̺��� �����ϴ� ������ ���� ������ UPDATE �ǰ�,
-- ������ INSERT �ǰ� �ϴ� ����

CREATE TABLE EMP001
AS
SELECT * FROM EMPLOYEE;

-- ������ ������ �������� ������ ������ EMP_J4 ���̺� �����
CREATE TABLE EMP_J4
AS
SELECT * FROM EMPLOYEE
WHERE JOB_ID = 'J4';

-- UPDATE Ȯ���� ����
INSERT INTO JOB(JOB_ID, JOB_TITLE)
VALUES ('J8', '����븮');

SELECT * FROM JOB;

UPDATE EMP_J4
SET JOB_ID = 'J8';

SELECT * FROM EMP_J4;

-- ��ġ���� �ʴ� ��쿡�� INSERT �Ǵ��� Ȯ���� ���� ���� ������ �Է�
INSERT INTO EMP_J4
VALUES ('999', 'ȫ�浿', '891025-1234567', 'hong999@kh.org', '0101234567', SYSDATE,
        'J4', 2850000, 0.3, 'N', '104', '90');
        
-- ���� Ȯ��
MERGE INTO EMP001 USING EMP_J4 ON (EMP001.EMP_ID = EMP_J4.EMP_ID)
WHEN MATCHED THEN UPDATE SET EMP001.JOB_ID = EMP_J4.JOB_ID
WHEN NOT MATCHED THEN INSERT VALUES (EMP_J4.EMP_ID, 
                                     EMP_J4.EMP_NAME,
                                     EMP_J4.EMP_NO,
                                     EMP_J4.EMAIL,
                                     EMP_J4.PHONE,
                                     EMP_J4.HIRE_DATE,
                                     EMP_J4.JOB_ID,
                                     EMP_J4.SALARY,
                                     EMP_J4.BONUS_PCT,
                                     EMP_J4.MARRIAGE,
                                     EMP_J4.MGR_ID,
                                     EMP_J4.DEPT_ID);

SELECT * FROM EMP001;


ALTER TABLE EMPLOYEE
DISABLE CONSTRAINTS FK_MGRID;
SAVEPOINT S0;

INSERT INTO DEPARTMENT
VALUES ('40','��ȹ������','A1');

SAVEPOINT S1;

UPDATE EMPLOYEE
SET DEPT_ID = '40'
WHERE DEPT_ID IS NULL;

SAVEPOINT S2;

DELETE FROM EMPLOYEE;

ROLLBACK TO S2;
SELECT COUNT(*)
FROM EMPLOYEE;
SELECT COUNT(*)
FROM EMPLOYEE
WHERE DEPT_ID = '40';

ROLLBACK TO S1;
SELECT COUNT(*)
FROM DEPARTMENT
WHERE DEPT_ID = '40';

SELECT COUNT(*)
FROM EMPLOYEE
WHERE DEPT_ID = '40';


-- ���ü� ����
SELECT EMP_NAME, MARRIAGE
FROM EMPLOYEE
WHERE EMP_ID = '143';