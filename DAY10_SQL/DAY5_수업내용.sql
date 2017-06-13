-- DAY5 �������� : �׷��Լ�, ORDER BY��, GROUP BY��, HAVING��

-- �׷��Լ� : ���� ���� ���� �о �ϳ��� ����� ����� �Լ�
-- SUM, AVG, MIN, MAX, COUNT

-- SUM([DISTINCT] �÷���)
SELECT SUM(SALARY), SUM(DISTINCT SALARY)
FROM EMPLOYEE
WHERE DEPT_ID = '50'
OR DEPT_ID IS NULL;

SELECT AVG(BONUS_PCT) AS �⺻���,
AVG(DISTINCT BONUS_PCT) AS �ߺ��������,
AVG(NVL(BONUS_PCT,0)) AS NULL�������
FROM EMPLOYEE
WHERE DEPT_ID IN ('50', '90')
OR DEPT_ID IS NULL;

SELECT MAX(JOB_ID), MIN(JOB_ID), MAX(HIRE_DATE), MIN(HIRE_DATE),
MAX(SALARY), MIN(SALARY)
FROM EMPLOYEE
WHERE DEPT_ID IN ('50','90');

-- COUNT(*) : ��ü ��� ����(NULL ����)
-- COUNT(�÷���) : ���� ��ϵ� �� ���� ����(NULL ����)
-- COUNT(DISTINCT �÷���) : �ߺ����� ������ �� ���� ����(NULL ����)

SELECT COUNT(*),
COUNT(JOB_ID),
COUNT(DISTINCT JOB_ID)
FROM EMPLOYEE
WHERE DEPT_ID = '50'
OR DEPT_ID IS NULL;

SELECT EMP_NAME, HIRE_DATE, DEPT_ID
FROM EMPLOYEE
WHERE HIRE_DATE > TO_DATE('20030101','YYYYMMDD')
ORDER BY DEPT_ID DESC, HIRE_DATE, EMP_NAME;

SELECT EMP_NAME AS �̸�,
HIRE_DATE AS �Ի���,
DEPT_ID AS �μ��ڵ�
FROM EMPLOYEE
WHERE HIRE_DATE > TO_DATE('20030101','YYYYMMDD')
ORDER BY �μ��ڵ� DESC, �Ի���, �̸�;

SELECT EMP_NAME AS �̸�,
HIRE_DATE AS �Ի���,
DEPT_ID AS �μ��ڵ�
FROM EMPLOYEE
WHERE HIRE_DATE > TO_DATE('20030101','YYYYMMDD')
ORDER BY 3 DESC, 2, 1 NULLS LAST;

-- *****************************************************************************
-- ORDER BY �� : SELECT �� �÷� �������� ���� ���Ľ�ų �� ���
-- ORDER BY �÷��� [ASC] | DESC
-- ORDER BY �÷��� ���Ĺ��, �÷��� ���Ĺ��, �÷��� ���Ĺ��, ....
-- ù��° �÷��� ���ؼ� �����ϰ�, ù��° �÷����� ���� ���鿡 ���ؼ� �ι�° �÷����� ������
-- SELECT ���� �� �������� �ۼ���
-- ��������� ���� �������� �۵���

/*
5 : SELECT �÷��� [AS] ��Ī, ����, �Լ���
1 : FROM ���̺��
2 : WHERE �÷��� �Ǵ� �������Լ��� ������ �񱳰� �Ǵ� �������Լ���
3 : GROUP BY �÷���
4 : HAVING �׷��Լ� �񱳿����� �񱳰�
6 : ORDER BY �÷��� | ��Ī | �÷����� ���Ĺ�� NULLS FIRST | LAST
*/

SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE DEPT_ID = '50' OR DEPT_ID IS NULL
ORDER BY SALARY DESC, 1 DESC;

-- 2003�� 1�� 1�� ���Ŀ� �Ի��� �������� ��ȸ
-- �μ��ڵ� ���� �������� �����ϰ�, ���� �μ��ڵ��� ���� �Ի��� ���� �������� �����ϰ�
-- �Ի����� ������ �̸� ���� ������������ ó����
-- �̸�, �Ի���, �μ��ڵ�, �޿�
-- ��, NULL �� ��ġ�� �Ʒ������� ��

SELECT EMP_NAME �̸�, HIRE_DATE �Ի���, DEPT_ID �μ��ڵ�, SALARY �޿�
FROM EMPLOYEE
WHERE HIRE_DATE > '03/01/01'
ORDER BY �μ��ڵ� DESC NULLS LAST, �Ի���, �̸�;

-- GROUP BY ��
-- ���� ������ ���� �� ��ϵ� �÷��� �������� ���� ������ �׷����� ���� �� �����
-- GROUP BY �÷��� | �׷칭�� ����� ���� ����
-- ���� ���� ������ ��� �ϳ��� ����� ����� �� �� �����
-- �׷����� ���� ���鿡 ���ؼ��� SELECT ������ �׷��Լ��� ����ؼ� ����� ����� ����

SELECT EMP_NAME, SALARY, DEPT_ID
FROM EMPLOYEE;

-- �μ��� �޿��� �հ踦 ����
SELECT DEPT_ID, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_ID
ORDER BY DEPT_ID NULLS LAST;

-- ���޺� �޿��� �հ�, �޿��� ���, ������ ��ȸ
SELECT JOB_ID, SUM(SALARY) "�޿��� �հ�", TRUNC(AVG(SALARY)) "�޿��� ���", COUNT(*) "������ ��ȸ"
FROM EMPLOYEE
GROUP BY JOB_ID
ORDER BY JOB_ID NULLS LAST;

-- GROUP BY���� ������� ���� �÷��� SELECT���� �׷��Լ��� ���� ��� �� ��
SELECT DEPT_ID, JOB_ID, SUM(SALARY) "�޿��� �հ�", TRUNC(AVG(SALARY)) "�޿��� ���", COUNT(*) "������ ��ȸ"
FROM EMPLOYEE
GROUP BY JOB_ID
ORDER BY JOB_ID NULLS LAST; -- ERROR

SELECT DEPT_ID, JOB_ID, SUM(SALARY) "�޿��� �հ�", TRUNC(AVG(SALARY)) "�޿��� ���", COUNT(*) "������ ��ȸ"
FROM EMPLOYEE
GROUP BY DEPT_ID, JOB_ID
ORDER BY JOB_ID NULLS LAST;

-- GROUP BY ���� �׷��� ���� ���� �Լ����� ����� ���� ����
-- ������ �׷��հ�, �޿����(õ�������� �ݿø�ó��), ������ ��ȸ
SELECT DECODE(SUBSTR(EMP_NO, 8, 1), '1', '��', '3', '��', '��') ����,
        SUM(SALARY), ROUND(AVG(SALARY), -4), COUNT(*)
FROM EMPLOYEE
GROUP BY DECODE(SUBSTR(EMP_NO, 8, 1), '1', '��', '3', '��', '��')
ORDER BY ����;


SELECT DEPT_ID AS �μ�,
ROUND(AVG(SALARY),-4) AS ��ձ޿�
FROM EMPLOYEE
GROUP BY DEPT_ID
ORDER BY 1;

SELECT DECODE(SUBSTR(EMP_NO,8,1),
'1', '��', '3', '��', '��') AS ����,
ROUND(AVG(SALARY),-4) AS ��ձ޿�
FROM EMPLOYEE
GROUP BY DECODE(SUBSTR(EMP_NO,8,1),
'1', '��', '3', '��', '��')
ORDER BY 2;

SELECT DEPT_ID,
COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_ID
ORDER BY 1;


-- ����(��Ī���)
SELECT DEPT_ID AS �μ�,
SUM(SALARY)
FROM EMPLOYEE
GROUP BY �μ�;

SELECT MAX(SUM(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_ID;

SELECT DEPT_ID, MAX(SUM(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_ID;

-- HAVING �� : GROUP BY �� �Ʒ��� �����
-- �ݵ�� GROUP BY�� �Բ� ����ؾ� ��
-- �׷� ��� ����ϴ� �׷��Լ� ������� ���� ����ó������
-- HAVING ���� �׷��Լ� ���ó���� ����ǰ�, ������ �����ϴ� ����鸸 ��󳻼�
-- SELECT ���� ��ȸ��

-- �μ��� �޿��հ� �� 9�鸸�� �ʰ��ϴ� �μ��� �޿��հ� ��ȸ

SELECT DEPT_ID, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_ID
HAVING SUM(SALARY) > 9000000;

-- �μ��� �޿��հ� �� �޿��հ谡 �ִ��� �μ��ڵ�� �޿��հ� ��ȸ
SELECT DEPT_ID �μ��ڵ�, SUM(SALARY) �޿��հ�
FROM EMPLOYEE
GROUP BY DEPT_ID
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY)) FROM EMPLOYEE GROUP BY DEPT_ID);

-- �м��Լ�
-- RANK() �Լ� : ����(���) ó���ϴ� �Լ�

-- �ش� ���� ���� ��ü �������� ������ ��ȸ�ϰ��� �� ��
-- RANK(������ �˰��� �ϴ� ��) WITHIN GROUP (ORDER BY ���� ���Ե� �÷��� ���Ĺ��)
SELECT RANK(2300000) WITHIN GROUP (ORDER BY SALARY DESC) ����
FROM EMPLOYEE;

-- �÷� ��ü ���� ������ �ű� ���
SELECT EMP_NAME, SALARY, RANK() OVER (ORDER BY SALARY DESC) ����
FROM EMPLOYEE;
--ORDER BY ����;

-- ROLLUP() �Լ� : gROUP BY �������� �����
-- �׷캰�� ��� ����� ����� ���� �����踦 ���� �� �����

SELECT DEPT_ID, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_ID;

SELECT DEPT_ID, SUM(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(DEPT_ID);

SELECT DEPT_ID, SUM(SALARY), MAX(SALARY), MIN(SALARY), AVG(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(DEPT_ID);
-- �׷��Լ��� ���� ������鿡 ���� �����谡 �ڵ� �߰���

-- �ǽ� : �μ��ڵ�� �����ڵ带 �Բ� �׷��� ����, �޿��� �հ踦 ����
-- ROLLUP �����
SELECT DEPT_ID, JOB_ID, SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_ID IS NOT NULL AND JOB_ID IS NOT NULL
GROUP BY ROLLUP(DEPT_ID, JOB_ID);

SELECT DEPT_ID, JOB_ID, SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_ID IS NOT NULL AND JOB_ID IS NOT NULL
GROUP BY CUBE(DEPT_ID, JOB_ID);

SELECT DEPT_ID, JOB_ID, SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_ID IS NOT NULL AND JOB_ID IS NOT NULL
GROUP BY ROLLUP(DEPT_ID), ROLLUP(JOB_ID);

SELECT DEPT_ID, JOB_ID, SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_ID IS NOT NULL AND JOB_ID IS NOT NULL
GROUP BY ROLLUP(JOB_ID), ROLLUP(DEPT_ID);

SELECT DEPT_ID, JOB_ID, SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_ID IS NOT NULL AND JOB_ID IS NOT NULL
GROUP BY CUBE(DEPT_ID), CUBE(JOB_ID);

SELECT DEPT_ID, JOB_ID, SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_ID IS NOT NULL AND JOB_ID IS NOT NULL
GROUP BY CUBE(JOB_ID), CUBE(DEPT_ID);

-- �׷��Լ� �ǽ� **************************************

-- �μ��� �޿����, �޿��� õ�������� �ݿø��ǰ� ��.
SELECT DEPT_ID, ROUND(AVG(SALARY), -4) "�μ��� �޿����"
FROM EMPLOYEE
GROUP BY DEPT_ID;

-- ������ �޿� ���  : group by ���� ���� ��� ����
-- DECODE, SUBSTR ���
-- ������ �Ȱ��� �ԷµǾ�� ��
SELECT DECODE(SUBSTR(EMP_NO, 8, 1), '1', '��', '3', '��', '��'), AVG(SALARY) "������ �޿� ���"
FROM EMPLOYEE
GROUP BY DECODE(SUBSTR(EMP_NO, 8, 1), '1', '��', '3', '��', '��');



-- �ǽ� : ���޺� �޿��� �հ�� �ο����� ��ȸ��
-- ����� ����, �޿��հ�, �ο��� 
SELECT JOB_ID ����, SUM(SALARY) �޿��հ�, COUNT(*) �ο���
FROM EMPLOYEE
GROUP BY ROLLUP (JOB_ID);


-- �ǽ� : �μ��ڵ�� �����ڵ带 �Բ� �׷��� ����, 
-- �޿��� �հ踦 ����
-- ROLLUP �����
SELECT DEPT_ID �μ��ڵ�, JOB_ID �����ڵ�, SUM(SALARY) "�޿��� �հ�"
FROM EMPLOYEE
GROUP BY ROLLUP(DEPT_ID, JOB_ID);


-- ************************************************
-- rollup �Լ�  
/* �μ�/������ ����ӱ� ��ȸ */
SELECT DEPT_ID �μ�, JOB_ID ����, AVG(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(DEPT_ID, JOB_ID);

-- cube �Լ�
SELECT DEPT_ID �μ�, JOB_ID ����, ROUND(AVG(SALARY), -4) "�μ�/������ ����ӱ�"
FROM EMPLOYEE
GROUP BY CUBE(DEPT_ID, JOB_ID);


-- GROUPING
-- SELECT ���� GROUP BY �������� �����
-- �÷� �׷� ���� �� �����
-- �׷� ��� ����� ���̸� 0 ǥ����
-- ���賽 ���̸� 1�� ǥ����
-- CUBE, ROLLUP�Լ� ���� �̿��ϴ� �Լ���
SELECT DEPT_ID, JOB_ID, SUM(SALARY),
        GROUPING(DEPT_ID) "�μ��� �׷��� ����", GROUPING(JOB_ID) "���޺� �׷��� ����"
FROM EMPLOYEE
WHERE DEPT_ID IS NOT NULL AND JOB_ID IS NOT NULL
GROUP BY ROLLUP(DEPT_ID, JOB_ID);


SELECT DEPT_ID, JOB_ID, SUM(SALARY),
        GROUPING(DEPT_ID) "�μ��� �׷��� ����", GROUPING(JOB_ID) "���޺� �׷��� ����"
FROM EMPLOYEE
WHERE DEPT_ID IS NOT NULL AND JOB_ID IS NOT NULL
GROUP BY CUBE(DEPT_ID, JOB_ID);

-- GROUPING SETS
-- �׷캰�� ��� ó���� ���� ���� SELECT ���� �ϳ��� ��ģ ����� ���� �� �����

-- �μ���, ���޺�, �����ں� �޿��� ����� ����
SELECT DEPT_ID, JOB_ID, MGR_ID, AVG(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_ID, JOB_ID, MGR_ID
UNION ALL

-- �μ���, �����ں� �޿��� ����� ����
SELECT DEPT_ID, NULL, MGR_ID, AVG(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_ID, MGR_ID
UNION ALL
-- ���޺�, �����ں� �޿��� ����� ����
SELECT NULL, JOB_ID, MGR_ID, AVG(SALARY)
FROM EMPLOYEE
GROUP BY JOB_ID, MGR_ID;

-- ���� ó�������� GROUPING SETS �� �ٲٸ�
SELECT DEPT_ID, JOB_ID, MGR_ID, AVG(SALARY)
FROM EMPLOYEE
GROUP BY GROUPING SETS((DEPT_ID, JOB_ID, MGR_ID), (DEPT_ID, MGR_ID), (JOB_ID, MGR_ID));

SELECT DEPT_ID, JOB_ID, MGR_ID, AVG(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(DEPT_ID, (JOB_ID, MGR_ID));

-- ROWID : ���� �ĺ��ϴ� �࿡ ���� ID ��
-- �����ͺ��̽��� �ڵ����� ����, ���� �� ��, ��ȸ�� �� �� ����
SELECT ROWID, EMP_ID
FROM EMPLOYEE;