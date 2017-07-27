-- DAY2 �������� : SELECT �⺻

-- DQL(Data Query Language) : ������ ��ȸ�� ���
-- select ���� ����

/*
  �⺻ ���� ����
  SELECT * | ��ȸ�� �÷���, �÷���
  FROM ��ȸ�� ����� ���̺��
*/

-- * : ��� �÷��� �ǹ���
-- EMPLOYEE ���̺��� ��� �÷��� �����͸� ��ȸ�� ���
SELECT * FROM EMPLOYEE;

-- ��ȸ�� �÷����� ����ؼ� ���������� �����͸� ��ȸ�� ���

SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE;

-- DISTINCT �÷��� ��� : �÷��� ��ϵ� �� �߿� ���� ������ �� ������ �� ���
-- SELECT ������ �ѹ��� ����� �� ����

-- EMPLOYEE ���̺� ���� �����ڵ� ��ȸ�� ���
SELECT DISTINCT JOB_ID
FROM EMPLOYEE;

SELECT * FROM JOB;

-- SELECT ���� ���ĵ� ����� �� ����
SELECT 23 + 32 / 4
FROM DUAL;

-- ���, �����, �޿�, 1��ġ�޿� ��ȸ�� ���
SELECT EMP_ID, EMP_NAME, SALARY, SALARY * 12
FROM EMPLOYEE;

-- ���, �����, �޿�, ���ʽ�����Ʈ, ���ʽ�����Ʈ�� ����� ������ ��ȸ�� ���
-- ���� : (�޿� + (�޿� * ���ʽ�����Ʈ)) * 12

SELECT EMP_ID, EMP_NAME, SALARY, BONUS_PCT, (SALARY + (SALARY * BONUS_PCT)) * 12 AS "1��ġ����"
FROM EMPLOYEE;

-- ��갪�� NULL �� ������, ����� ������ NULL��.
-- �÷��� ���� NULL�� ��쿡 �ٸ� ������ �ٲٴ� �Լ��� ����ؼ� �ذ��� : NVL
-- NVL(�� ���� �÷���, �ٲܰ�) : �÷����� NULL�̸� �ٲܰ����� �ٲپ ��꿡 �����


SELECT EMP_ID, EMP_NAME, SALARY, NVL(BONUS_PCT, 0) "bonus_pct", (SALARY + (SALARY * NVL(BONUS_PCT, 0))) * 12 "1��ġ����" 
FROM EMPLOYEE;

-- ��Ī(ALIAS)�� ""�� ����� �ϴ� ��� : ��Ī�� ����, ��ȣ����, ������ ���Ե� ���

-- SELECT ���� ���ͷ�(LITERAL : ��) ����� �� ����

SELECT EMP_ID ���, EMP_NAME �̸�, '����' �ٹ�����
FROM EMPLOYEE;

-- ������ : WHERE ��
-- �ݵ�� FROM �� ������ �����
-- ���̺��� ������ �����ϴ� ������ ���
-- WHERE �÷��� �񱳿����� �񱳰�
-- �񱳿����� : > (ũ��, �ʰ�), < (������, �̸�), >= (ũ�ų� ������, �̻�), <= (�۰ų� ������, ����)
--              = (������), != (���� �ʴ���, == <> ���� ������)
-- �������� : ���� ������ ���� �� ��� (&& �� AND, || �� OR, !�� NOT ���� �����)

-- �μ��ڵ尡 90�� ������ ��ȸ�� ���

SELECT * 
FROM EMPLOYEE
WHERE DEPT_ID = '90';

-- �����ڵ尡 J7�� ������ ��ȸ�� ���

SELECT *
FROM EMPLOYEE
WHERE JOB_ID = 'J7';

-- �޿��� 4�鸸�� �ʰ��ϴ� ���� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE SALARY > 4000000;


-- �μ� �ڵ尡 '90' �̰� �޿��� 2000000 ���� �� �޴� �μ��� �̸��� �μ� �ڵ�, �޿� ��ȸ

SELECT EMP_NAME AS �̸�, DEPT_ID AS �μ�, SALARY AS �޿�
FROM EMPLOYEE
WHERE DEPT_ID = 90
AND SALARY > 2000000;

-- �μ��� '90' �Ǵ� 20 �� ���� ��ȸ

SELECT EMP_NAME AS �̸�, DEPT_ID AS �μ�, SALARY AS �޿�
FROM EMPLOYEE
WHERE DEPT_ID = '90'
OR DEPT_ID = '20';

-- �޿��� 2�鸸 �̻� 4�鸸������ �������� ���, �̸�, �޿�, �����ڵ�, �μ��ڵ� ��ȸ

SELECT EMP_ID AS ���, EMP_NAME AS �̸�, SALARY AS �޿�, JOB_ID AS �����ڵ�, DEPT_ID AS �μ��ڵ�
FROM EMPLOYEE
-- WHERE SALARY >= 2000000 AND SALARY <= 4000000;
WHERE SALARY BETWEEN 2000000 AND 4000000;


-- ���� ������ (||) ���
-- ���� �÷������� �ϳ��� ��ó�� ���� �� ����

--�÷��� �÷��� ������ ���

SELECT EMP_ID || EMP_NAME || SALARY
FROM EMPLOYEE;

-- �÷��� ���ͷ��� ������ ���
SELECT EMP_NAME || '�� ������' || SALARY || '�� �Դϴ�.'
FROM EMPLOYEE;

-- �Ի��� (HIRE_DATE)�� 1995�� 1�� 1�Ϻ��� 2000�� 12�� 31�� ���̿� �Ի��� ������
-- ���, �̸�, �Ի���, �μ��ڵ� ��ȸ
-- ��¥�����ʹ� ��¥���信 ���缭 ��������ǥ�� ��� ǥ����

-- �Ϲ� �񱳿����� ����� ���

SELECT EMP_ID AS ���, EMP_NAME AS �̸�, HIRE_DATE AS �Ի���, DEPT_ID AS �μ��ڵ�
FROM EMPLOYEE
WHERE HIRE_DATE >= '95/01/01' AND HIRE_DATE <= '00/12/13';


-- BETWEEN AND ����� ���

SELECT EMP_ID AS ���, EMP_NAME AS �̸�, HIRE_DATE AS �Ի���, DEPT_ID AS �μ��ڵ�
FROM EMPLOYEE
WHERE HIRE_DATE BETWEEN '95/01/01' AND '00/12/13';

-- LIKE ������ : ���ڿ����� ������ �����ؼ� ���ϰ� ��ġ�ϴ� ������ �� �� ����ϴ� ������
-- �÷��� LIKE '����'
-- ���ڿ� ���Ͽ� ���ϵ�ī�� ���� ����� : %(0�� �̻��� ����), _(�������ڸ�)

-- ���� '��' ���� ���� ���� ��ȸ
-- ���, �̸�, �ֹι�ȣ, ��ȭ��ȣ

SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE EMP_NAME LIKE '��%';

SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE LIKE '___9_______';

-- ����̸��� '��'�ڰ� ���Ե� ������ �̸�, �ֹι�ȣ, ��ȭ��ȣ, ��ȥ���� ��ȸ
SELECT EMP_NAME AS �̸�, EMP_NO AS �ֹι�ȣ, PHONE AS ��ȭ��ȣ, MARRIAGE AS ��ȥ����
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%��%';

-- ��ȭ��ȣ�� ���� (4��°�ڸ���)�� '9'�� �����ϴ� �������� �̸�, ��ȭ��ȣ ��ȸ

SELECT EMP_NAME AS �̸�, PHONE AS ��ȭ��ȣ
FROM EMPLOYEE
WHERE PHONE LIKE '___9%';

-- ������ ������ ���� ��ȸ : ���, �̸�, �ֹι�ȣ, ��ȭ��ȣ
-- �ֹι�ȣ 8��° ���� 1�̸� ����, 2�̸� ������

SELECT EMP_ID AS ���, EMP_NAME AS �̸�, EMP_NO AS �ֹι�ȣ, PHONE AS ��ȭ��ȣ
FROM EMPLOYEE
WHERE EMP_NO LIKE '_______2%';

SELECT EMP_ID AS ���, EMP_NAME AS �̸�, EMP_NO AS �ֹι�ȣ, PHONE AS ��ȭ��ȣ
FROM EMPLOYEE
WHERE EMP_NO NOT LIKE '_______2%';

-- 

SELECT EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '____%';

-- ���ڿ������� ���ϵ�ī�� ���ڿ� ��ϵ� ���ڰ� ���� ���, ESCAPE �ɼ� �����
-- �̸��� �ּҿ��� ���̵�� '_' �� ���ڰ� 3������ ���� ��ȸ

SELECT EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE'___#_%' ESCAPE '#';

-- �÷��� IS NULL : �÷��� ���� NULL ��
-- �÷��� IS NOT NULL : �÷��� ���� NULL�� �ƴ�

-- �����ڵ� ����, �μ��� �������� ���� ���� ��ȸ

SELECT *
FROM EMPLOYEE
WHERE MGR_ID IS NULL AND DEPT_ID IS NULL;

-- �����ڴ� ���µ�, �μ��� �������� ���� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE MGR_ID IS NULL OR DEPT_ID IS NOT NULL;

-- �μ��� �������� �ʰ�, ���޵� ���� ���� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE MGR_ID IS NULL AND JOB_ID IS NULL;

-- ���ʽ�����Ʈ�� ���� ���� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE BONUS_PCT IS NULL;

-- �μ� ��ġ�� ���� �ʾҴµ�, ���ʽ�����Ʈ�� �޴� ����
SELECT *
FROM EMPLOYEE
WHERE MGR_ID IS NULL AND BONUS_PCT IS NOT NULL;

SELECT EMP_NAME, DEPT_ID, SALARY
FROM EMPLOYEE
WHERE DEPT_ID IN ( '60', '90' );

SELECT EMP_NAME, DEPT_ID, SALARY
FROM EMPLOYEE
WHERE DEPT_ID = '60'
OR DEPT_ID = '90';


-- ������ �켱���� ��
-- �μ��ڵ尡 20 �Ǵ� 90�� �������߿��� �޿��� 3�鸸���� ���� �޴� ���� �̸�, �μ��ڵ�, �޿� ��ȸ

-- ��ȣ�� ������� �ʾ��� ��
SELECT EMP_NAME, SALARY, DEPT_ID
FROM EMPLOYEE
WHERE DEPT_ID = '20'
OR DEPT_ID = '90'
AND SALARY > 3000000;

-- ��ȣ�� ������� ��
SELECT EMP_NAME, SALARY, DEPT_ID
FROM EMPLOYEE
-- WHERE ( DEPT_ID = '20' OR DEPT_ID = '90' ) AND SALARY > 3000000;
WHERE DEPT_ID IN('20', '90') AND SALARY > 3000000;

--SELECT ��������
--
--1. �μ��ڵ尡 90�̸鼭, �����ڵ尡 J2�� �������� ���, �̸�, �μ��ڵ�, �����ڵ�, �޿� ��ȸ��
--   ��Ī ������
SELECT EMP_ID AS ���, EMP_NAME AS �̸�, DEPT_ID AS �μ��ڵ�, JOB_ID AS �����ڵ�, SALARY AS �޿�
FROM EMPLOYEE
WHERE DEPT_ID = '90' AND JOB_ID = 'J2';

--2. �Ի����� '1982-01-01' �����̰ų�, �����ڵ尡 J3 �� �������� ���, �̸�, ������ ���, ���ʽ�����Ʈ ��ȸ��
SELECT EMP_ID, EMP_NAME, MGR_ID, BONUS_PCT
FROM EMPLOYEE
WHERE HIRE_DATE > '82/01/01' OR JOB_ID = 'J3';


--3. �����ڵ尡 J4�� �ƴ� �������� �޿��� ���ʽ�����Ʈ�� ����� ������ ��ȸ��.
--  ��Ī ������, ���, �����, �����ڵ�, ����(��)
--  ��, ���ʽ�����Ʈ�� null �� ���� 0���� �ٲپ� ����ϵ��� ��.

SELECT EMP_ID AS ���, EMP_NAME AS �����, SALARY AS �޿�, (SALARY + (SALARY * NVL(BONUS_PCT, 0))) * 12|| '(��)' "1��ġ ����"
FROM EMPLOYEE
WHERE JOB_ID!='J4';


--4. ���ʽ�����Ʈ�� 0.1 �̻� 0.2 ������ �������� ���, �����, �̸���, �޿�, ���ʽ�����Ʈ ��ȸ��
SELECT EMP_ID, EMP_NAME, EMAIL, SALARY, BONUS_PCT
FROM EMPLOYEE
WHERE BONUS_PCT >=0.1 AND BONUS_PCT <= 0.2;

--5. ���ʽ�����Ʈ�� 0.1 ���� �۰ų�(�̸�), 0.2 ���� ����(�ʰ�) �������� ���, �����, ���ʽ�����Ʈ, �޿�, �Ի��� ��ȸ��
SELECT EMP_ID, EMP_NAME, BONUS_PCT, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE BONUS_PCT NOT BETWEEN 0.1 AND 0.2;

--6. '1982-01-01' ���Ŀ� �Ի��� �������� �����, ���ʽ�����Ʈ, �޿� ��ȸ��
SELECT EMP_NAME, BONUS_PCT, SALARY
FROM EMPLOYEE
WHERE HIRE_DATE > '82/01/01';

--7. ���ʽ�����Ʈ�� 0.1, 0.2 �� �������� ���, �����, ���ʽ�����Ʈ, ��ȭ��ȣ ��ȸ��
SELECT EMP_ID, EMP_NAME, BONUS_PCT, PHONE
FROM EMPLOYEE
WHERE BONUS_PCT IN (0.1, 0.2);

--8. ���ʽ�����Ʈ�� 0.1�� 0.2�� �ƴ� �������� ���, �����, ���ʽ�����Ʈ, �ֹι�ȣ ��ȸ��
SELECT EMP_ID, EMP_NAME, BONUS_PCT, EMP_NO
FROM EMPLOYEE
WHERE BONUS_PCT NOT IN(0.1, 0.2);

--9. ���� '��'���� �������� ���, �����, �Ի��� ��ȸ��
--  ��, �Ի��� ���� �������� ������
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '��%'
ORDER BY HIRE_DATE ASC;

--10. �ֹι�ȣ 8��° ���� '2'�� ������ ���, �����, �ֹι�ȣ, �޿��� ��ȸ��
--  ��, �޿� ���� �������� ������

SELECT EMP_ID, EMP_NAME, EMP_NO, SALARY
FROM EMPLOYEE
WHERE EMP_NO LIKE '_______2%'
ORDER BY SALARY DESC;



