-- DAY8 ��������

-- WITH �̸� AS (������)
-- SELECT * FROM �̸�;
-- ���������� �̸��� �ٿ��ְ� ������������ �������� ���κп� �̸��� �����
-- ���� ���������� ���� �� ���� ��� SELECT ������ ���������� �̸��� ����ϸ� 
-- �ߺ� ��뵵 ���̰� ���� �ӵ��� �������ٴ� ������ ����.
-- �ζ��� ��� ���� ���������� �ַ� ����

-- NATURAL JOIN : ������ ���̺��� �⺻Ű(PRIMARY KEY)�� �̿��� EQUAL JOIN + INNER JOIN ��

SELECT *
FROM EMPLOYEE
NATURAL JOIN DEPARTMENT;

-- �μ��� �޿��� �հ谡 ��ü �޿� ������ 20%���� ���� �μ���� �μ��� �޿��հ� ��ȸ
SELECT DEPT_NAME, SUM(SALARY)
FROM EMPLOYEE
JOIN DEPARTMENT USING (DEPT_ID)
GROUP BY DEPT_ID, DEPT_NAME
HAVING SUM(SALARY) > (SELECT SUM(SALARY)
                      FROM EMPLOYEE)*0.2;
                      
-- WITH ��� SQL �� : NATURAL JOIN ����
WITH TOTAL_SAL AS (SELECT DEPT_NAME, SUM(SALARY) SSAL
                   FROM EMPLOYEE
                   NATURAL JOIN DEPARTMENT
                   GROUP BY DEPT_NAME)
SELECT DEPT_NAME, SSAL
FROM TOTAL_SAL -- �ζ��κ�
WHERE SSAL > (SELECT SUM(SALARY) *0.2
              FROM EMPLOYEE);
              
/*
    �м��Լ�
      ����Ŭ �м��Լ��� �����͸� �м��ϴ� ������ �Լ���.
      �м��Լ��� ����ϸ�, ���� ������ ����� RESULT SET�� �������
      ��ü �׷캰�� �ƴ� �ұ׷캰�� �� �࿡ ���� ��갪�� ������.
      
    �Ϲ� �׷��Լ��� �ٸ� ���� �м��Լ��� �м��Լ��� �׷��� ������ �����ؼ�
    �� �׷��� ������� ����� �����Ѵٴ� ���̴�.
    �Ϲ� �׷��Լ��� �׷캰�� ����� �����Ѵ�.
    
    �̶� �м��Լ��� �׷��� ����Ŭ������ ������(WINDOW) ��� �θ�
*/

-- ��� ����
/*
   �м��Լ��� ([��������1{, ��������2{, ��������3}}])
    OVER ([PARTITION BY ��]
          [ORDER BY ��]
          [WINDOW ��])
    FROM ���̺��
    
   �м��Լ��� : AVG, SUM, RANK, MAX, MIN, COUNT ��
   �������� : �м��Լ��� ���� 0 ~ 3������ ����� �� ����.
   ���� PARTITION �� : PARTITION BY ǥ����
                      ǥ���Ŀ� ���� �׷캰�� ���� ��������� �и��ϴ� ������ ��
                      ��, �м��Լ��� ��� ��� �׷��� ������.
   ORDER BY �� : PARTITION �� �ڿ� ����ؾ� ��.
                 ��� ��� �׷쿡 ���� �����۾��� ������.
   WINDOW �� : �м��Լ� ����� �Ǵ� ���̺��� �� �������� ������ �� ���������� ������
               PARTITION BY �� ���� �������� ���� �׷쿡 ���� �� �ٸ� �ұ׷��� ����.
*/

-- ��� �ű�� �Լ� : RANK
-- ���� ����� ���� ���� ���� ������� �ǳ� ��
-- �� : 1, 1, 3

-- �޿��� ���� ������ �ű�ٸ� (�������� ���� ����)
SELECT EMP_ID, EMP_NAME, SALARY, RANK() OVER (ORDER BY SALARY DESC) �޿�����
FROM EMPLOYEE;

-- ������ ���� ������ �˰��� �� ���, RANK (������ �˰��� �ϴ� ��)
-- �޿� 230���� �޿� ������������ �� �� ������ �ش�Ǵ��� ��ȸ
SELECT RANK (2300000) WITHIN GROUP (ORDER BY SALARY DESC) ����
FROM EMPLOYEE;

-- DENSE_RANK() : ���� ������ ���� �� �־, ���� ������ �ǳʶ��� ����.
-- �� : 1, 2, 2, 3

-- �޿� ��ü�� ������ �ű�ٸ� 
SELECT EMP_NAME, DEPT_ID, SALARY, RANK() OVER(ORDER BY SALARY DESC) "����1",
DENSE_RANK() OVER(ORDER BY SALARY DESC) "����2",
DENSE_RANK() OVER(PARTITION BY DEPT_ID ORDER BY SALARY DESC) "�׷캰����"
FROM EMPLOYEE
ORDER BY 2;

-- RANK() �� �̿��� TOP-N �м� ���
-- �޿� ���� �޴� ���� 5�� ��ȸ
SELECT *
FROM (SELECT EMP_NAME, SALARY, RANK() OVER(ORDER BY SALARY DESC) "����"
      FROM EMPLOYEE)
WHERE ���� <= 5;

-- �޿� ���� �޴� ������ 11������ �ش��ϴ� �������� ��ȸ
-- �̸�, �޿�
SELECT EMP_NAME, SALARY
FROM (SELECT EMP_NAME, SALARY, DENSE_RANK() OVER(ORDER BY SALARY ASC) ����
      FROM EMPLOYEE)
WHERE ���� = 11;

-- CUME_DIST() : CUMulative distribution
-- PARTITION BY �� ���� �������� �׷캰�� �� ���� ORDER BY ���� ��õ� ������ ������ ��
-- �׷캰�� ������ �л�����(������� ��ġ)�� ���ϴ� �Լ���.
-- 0 < ����� <= 1 ������ ����.
-- �л�����(������� ��ġ)�� ���ϰ��� �ϴ� ������ �۰ų� ���� ���� ���� �� ���� 
-- �׷� ���� �� ����� ���� ���� �ǹ���.

-- �μ��ڵ尡 '50'�� �������� �̸�, �޿�, �޿������л��� ��ȸ
SELECT EMP_NAME, SALARY, ROUND(CUME_DIST() OVER (ORDER BY SALARY), 1) �����л�
FROM EMPLOYEE
WHERE DEPT_ID = '50';

-- NTILE() �Լ�
/*
    PARTITION�� BUCKET �̷� �Ҹ��� �׷캰�� ������, 
    PARTITION ���� �� ���� BUCKET �� ��ġ�ϴ� �Լ���
    ���� ��� PARTITION �ȿ� 100 ���� ���� �ִٸ�, BUCKET�� 4���� �ϸ�
    1���� BUCKET �� 25���� ���� ��е�.
    ��Ȯ�ϰ� ��е��� ���� ���� �ٻ�ġ�� ����� �� ���� ���� ���� ���� BUCKET ���� ä��
*/

-- �޿��� 4������� �з�
SELECT EMP_NAME, SALARY, NTILE(4) OVER(ORDER BY SALARY) ���
FROM EMPLOYEE;

-- ROW_NUMBER() �Լ�
/*
    ROWNUM ���� ���谡 ����
    �� PARTITION ���ǰ����� ORDER BY ���� ���� ������ ��
    �� ������� ������ �ο���
*/

-- ���, �̸�, �޿�, �Ի���, ����
-- �� ������ �޿��� ���� ������, ���� �޿��� �Ի����� �����������

SELECT EMP_NO, EMP_NAME, SALARY, HIRE_DATE, ROW_NUMBER() OVER(ORDER BY SALARY DESC, HIRE_DATE ASC) ����
FROM EMPLOYEE;

-- �����Լ�
-- EMPLOYEE ���̺�� ���� �μ��ڵ尡 '60'�� �������� ���, �޿�, �ش� �μ��׷�(�������� ��)��
-- ����� �������� �����ϰ� �޿��� �հ� �� ���� ���踦 ����.

-- �޿��� �հ踦 ù����� ����������� ���ؼ� "WIN1" �� ��� ó���ϰ�, 
SELECT EMP_ID, SALARY, SUM(SALARY) OVER(PARTITION BY DEPT_ID
                                        ORDER BY EMP_ID
                                        ROWS BETWEEN UNBOUNDED PRECEDING
                                        AND UNBOUNDED FOLLOWING) "win1",
                                        
-- ROWS : �κб׷��� �������� ũ�⸦ �� �������� �����Ѵٴ� �ǹ���
-- UNBOUNDED PRECEDING : �������� ù��
-- UNBOUNDED FOLLOWING : �������� ��������

-- ù����� ���� ������� �޿��� �հ踦 ���ؼ� "WIN2" �� ���
                       SUM(SALARY) OVER(PARTITION BY DEPT_ID
                                        ORDER BY EMP_ID
                                        ROWS BETWEEN UNBOUNDED PRECEDING
                                        AND CURRENT ROW) "win2",
-- ���� �࿡�� �������� ������ ������� �޿� �հ踦 ���ؼ� "win3"�� ���
                        SUM(SALARY) OVER(PARTITION BY DEPT_ID
                                        ORDER BY EMP_ID
                                        ROWS BETWEEN CURRENT ROW
                                        AND UNBOUNDED FOLLOWING) "win3"
FROM EMPLOYEE
WHERE DEPT_ID = '60';

-- ����� �����ؼ� ���踦 ���� ���� ����
SELECT EMP_ID, SALARY, SUM(SALARY) OVER(PARTITION BY DEPT_ID
                                        ORDER BY EMP_ID
                                        ROWS BETWEEN 1 PRECEDING
                                        AND 1 FOLLOWING) "win1",
-- ���� ���� �߽����� ���� ��� ���� ���� �޿� �հ踦 ����

                       SUM(SALARY) OVER(PARTITION BY DEPT_ID
                                        ORDER BY EMP_ID
                                        ROWS BETWEEN 1 PRECEDING
                                        AND CURRENT ROW) "win2",
-- ���� ��� ���� ������� �޿� �հ踦 ����

                       SUM(SALARY) OVER(PARTITION BY DEPT_ID
                                        ORDER BY EMP_ID
                                        ROWS BETWEEN CURRENT ROW
                                        AND 1 FOLLOWING) "win3"
-- ���� ��� ���� ���� �޿� �հ踦 ����
FROM EMPLOYEE
WHERE DEPT_ID = '60';

-- RATIO_TO_REPORT() �Լ�
-- �ش� �������� �����ϴ� ������ �����ϴ� �Լ�

-- �������� �ѱ޿��� 2õ���� ������ų ��, ���� ���޺����� �����ؼ�
-- �� ������ �ް� �� �޿��� �������� ?
SELECT EMP_NAME, SALARY,
       LPAD(TRUNC(RATIO_TO_REPORT(SALARY) OVER() * 100, 0), 5) || ' %' ����,
       TO_CHAR(TRUNC(RATIO_TO_REPORT(SALARY) OVER() * 20000000, 0) , 'L00,999,999') "�߰��� ���� �޿�"
FROM EMPLOYEE;

-- LAG (��ȸ�� ����, ������ġ, ���� ������ġ)
-- �����ϴ� �÷��� ���� ���� �������� ���� ��(����)�� ���� ��ȸ�� �� �����
SELECT EMP_NAME, DEPT_ID, SALARY,
       LAG(SALARY, 1, 0) OVER (ORDER BY SALARY) ������,
       -- 1: �ٷ� ���� �� ��, 0: �������� ������ 0 ó����
       LAG(SALARY, 1, SALARY) OVER (ORDER BY SALARY) "��ȸ2",
       -- ���� ���� ������ ���� ���� �� ���
       LAG(SALARY, 1, SALARY) OVER (PARTITION BY DEPT_ID ORDER BY SALARY) "��ȸ3"
FROM EMPLOYEE;

-- LEAD(��ȸ�� ����, �������, 0 �Ǵ� �÷���)
-- ���� ���� �� ��ȸ
SELECT EMP_NAME, DEPT_ID, SALARY,
       LEAD(SALARY, 1, 0) OVER (ORDER BY SALARY) ������,
       -- 1: �ٷ� ���� �� ��, 0: �������� ������ 0 ó����
       LEAD(SALARY, 1, SALARY) OVER (ORDER BY SALARY) "��ȸ2",
       -- ���� ���� ������ ���� ���� �� ���
       LEAD(SALARY, 1, SALARY) OVER (PARTITION BY DEPT_ID ORDER BY SALARY) "��ȸ3"
FROM EMPLOYEE;


-- ******************************************************************************
-- DDL (Data Definition Language) : ������ ���� ���
-- �ַ� ��ü�� �����, �����ϰ�, �����ϴ� ����
-- ��ü(Object) : ���̺�, ��, �ε���, ������, ���Ǿ�, �����, ��(������ ����)��
-- CREATE, ALTER, DROP ����
-- CREATE TABLE ���̺��
-- CREATE VIEW ���
-- CREATE SEQUENCE ��������
-- CREATE INDEX �ε�����
-- CREATE SYNONYM ���Ǿ��
-- CREATE USER ����ڸ�
-- CREATE ROLE �Ѹ�

CREATE TABLE TEST
(ID NUMBER(5),
NAME CHAR(10),
ADDRESS VARCHAR2(50)
);

ROLLBACK;

CREATE TABLE ORDERS (ORDERNO CHAR(4),
                     CUSTNO CHAR(4),
                     ORDERDATE  DATE DEFAULT SYSDATE,
                     SHIPDATE DATE,
                     SHIPADDRESS VARCHAR2(40),
                     QUANTITY NUMBER
                     );

COMMENT ON COLUMN ORDERS.ORDERNO IS '�ֹ���ȣ';
COMMENT ON COLUMN ORDERS.CUSTNO IS '����ȣ';
COMMENT ON COLUMN ORDERS.ORDERDATE IS '�ֹ�����';
COMMENT ON COLUMN ORDERS.SHIPDATE IS '�������';
COMMENT ON COLUMN ORDERS.SHIPADDRESS IS '����ּ�';
COMMENT ON COLUMN ORDERS.QUANTITY IS '�ֹ�����';

COMMIT;

-- ȸ�� ���� ����� ���̺� ��
CREATE TABLE MEMBER(
    ID VARCHAR2(15) PRIMARY KEY,
    PASSWD VARCHAR2(15) NOT NULL,
    NAME VARCHAR2(20) NOT NULL,
    EMAIL VARCHAR2(30),
    GENDER CHAR(1),
    AGE NUMBER,
    PHONE CHAR(13),
    ADDRESS VARCHAR2(50),
    ENROLL_DATE DATE DEFAULT SYSDATE
);

CREATE TABLE NOTICE(
    NOTICE_NO NUMBER,
    NOTICE_TITLE VARCHAR2(30),
    NOTICE_WRITER VARCHAR2(15),
    NOTICE_DATE DATE DEFAULT SYSDATE,
    NOTICE_CONTENT VARCHAR2(2000),
    FILE_PATH VARCHAR2(50)
);

COMMENT ON COLUMN NOTICE.NOTICE_NO IS '�۹�ȣ';
COMMENT ON COLUMN NOTICE.NOTICE_TITLE IS '������';
COMMENT ON COLUMN NOTICE.NOTICE_WRITER IS '�ۼ���';
COMMENT ON COLUMN NOTICE.NOTICE_DATE IS '�ۼ���¥';
COMMENT ON COLUMN NOTICE.NOTICE_CONTENT IS '�۳���';
COMMENT ON COLUMN NOTICE.FILE_PATH IS '÷�����ϰ�θ�';

/*
    ù��° �� �߰� : 1, 'ù��° ������', 'USER01', '�ȳ��ϼ���. ���������� �˷��帳�ϴ�.'
    �ι�° �� �߰� : �۹�ȣ�� ���� ū �� + 1, '�ι�° ������', 'USER02', '�˸��ϴ�. �ι�°'
*/

INSERT INTO NOTICE ( NOTICE_NO, NOTICE_TITLE, NOTICE_WRITER, NOTICE_DATE,
NOTICE_CONTENT)
VALUES ( 1, 'ù��° ������', 'user01', DEFAULT, '�ȳ��ϼ���. ���������� �˷��帳�ϴ�'
       );
       
INSERT INTO NOTICE ( NOTICE_NO, NOTICE_TITLE, NOTICE_WRITER, NOTICE_DATE,
NOTICE_CONTENT)
VALUES ((SELECT MAX(NOTICE_NO)+1 FROM NOTICE), '�ι�° ������', 'user02', DEFAULT, '�˸��ϴ�. �ι�°');
COMMIT;

SELECT *
FROM NOTICE;

CREATE TABLE TABLE_NOTNULL
(ID CHAR(3) NOT NULL,
SNAME VARCHAR2(20));

INSERT INTO TABLE_NOTNULL
VALUES ('100','ORACLE');

INSERT INTO TABLE_NOTNULL
VALUES (NULL,'ORACLE');

CREATE TABLE TABLE_NOTNULL2
(ID CHAR(3),
SNAME VARCHAR2(20),
CONSTRAINT TN2_ID_NN NOT NULL(ID));
