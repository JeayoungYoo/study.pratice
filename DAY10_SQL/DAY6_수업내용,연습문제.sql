-- DAY6 �������� : JOIN

-- ���� (JOIN) : �������� ���̺��� �ϳ��� ū ���̺�� ���� ����, ���ϴ� ����� ����
-- ����Ŭ������ ����ϴ� ����Ŭ ���� ������ ��� DBMS�� �������� ����ϴ� ǥ�ر����� 
-- ANSI ǥ�ر������� ǥ���� �� ����

-- ����Ŭ ���뱸�� : ��ĥ ���̺����� FROM ���� , �� �����ؼ� ������
-- ���̺��� ��ġ�� ���� �÷���� ���ǽ��� WHERE ���� �����

SELECT * 
FROM EMPLOYEE, DEPARTMENT
WHERE EMPLOYEE.DEPT_ID = DEPARTMENT.DEPT_ID;

SELECT *
FROM EMPLOYEE E, DEPARTMENT D
WHERE E.DEPT_ID = D.DEPT_ID;

SELECT EMP_NAME, E.DEPT_ID, DEPT_NAME
FROM EMPLOYEE E, DEPARTMENT D
WHERE E.DEPT_ID = D.DEPT_ID;

-- ANSI ǥ�ر��� : ���� ó���� ���� ������ ������ �����
-- ��� DBMS �� �������� ����ϴ� ������
SELECT *
FROM EMPLOYEE
JOIN DEPARTMENT USING (DEPT_ID);

SELECT EMP_NAME, DEPT_ID, DEPT_NAME
FROM EMPLOYEE
INNER JOIN DEPARTMENT USING (DEPT_ID);

SELECT *
FROM DEPARTMENT
JOIN LOCATION ON (LOC_ID = LOCATION_ID);

-- ����Ŭ ���뱸������ ����
SELECT * 
FROM DEPARTMENT D, LOCATION L
WHERE D.LOC_ID = L.LOCATION_ID;

-- ���, �����, ���޸� ��ȸ
-- ����Ŭ ���뱸��
SELECT EMP_ID, EMP_NAME, JOB_TITLE
FROM EMPLOYEE E, JOB J
WHERE E.JOB_ID = J.JOB_ID;

-- ANSI ǥ�ر���
SELECT EMP_ID, EMP_NAME, JOB_TITLE
FROM EMPLOYEE
JOIN JOB USING(JOB_ID);

-- USING �� ���� ���� �÷��� ���� ����� ���� ����
SELECT *
FROM EMPLOYEE2
JOIN DEPARTMENT USING(DEPT_ID, LOC_ID);
-- 2���� �÷����� �ϳ��� ������ ����, ���� ���� ã�Ƽ� ������

-- ������ �⺻�� EQUAL JOIN ��.
-- ����Ǵ� �÷��� ���� ��ġ�ϴ� ��鸸 ������
-- INNER JOIN �� EQUAL JOIN��.

-- OUTER JOIN
-- EQUAL JOIN �̸鼭, �� ���̺��� ������ �÷��� ���� ��ġ���� �ʴ� �൵ ���ο� ������

-- ����Ŭ ���� ����
SELECT *
FROM EMPLOYEE E, DEPARTMENT D
WHERE E.DEPT_ID = D.DEPT_ID(+);

-- ANSI ǥ�ر���
SELECT *
FROM EMPLOYEE
LEFT OUTER JOIN DEPARTMENT USING (DEPT_ID);

-- DEPARTMENT �� ���� ��� ���� ���ο� �����ϰ��� �� ���
SELECT *
FROM EMPLOYEE E, DEPARTMENT D
WHERE E.DEPT_ID(+) = D.DEPT_ID;

SELECT * 
FROM EMPLOYEE
RIGHT OUTER JOIN DEPARTMENT USING (DEPT_ID);

-- FULL OUTER JOIN
-- ���� ���̺��� �ش� �÷��� ��� ������ ������ ����� ���Խ�Ŵ
SELECT *
FROM EMPLOYEE
FULL OUTER JOIN DEPARTMENT USING (DEPT_ID);

-- ����Ŭ ���뱸���� ǥ�� �� ��
SELECT *
FROM EMPLOYEE E, DEPARTMENT D
WHERE E.DEPT_ID(+) = D.DEPT_ID(+);

-- CROSS JOIN : �� ���̺��� ������ �÷��� ���� ��쿡 �����
-- ������ ���� �÷��� ���� �� ���
-- ����� ���̺�1�� ��� X ���̺�2�� ���
SELECT *
FROM LOCATION
CROSS JOIN COUNTRY;

-- NON EQUI JOIN
-- �����ϴ� �÷��� ���� ��ġ�ϴ� ��찡 �ƴ�, ���� ������ ���ԵǴ� ����� �����ϴ� ���
SELECT *
FROM EMPLOYEE
JOIN SAL_GRADE ON (SALARY BETWEEN LOWEST AND HIGHEST);

-- SELF JOIN : ���� ���̺��� �� �� �����ϴ� ���
-- ���� ���̺� ���� �⺻Ű �÷����� �����ϴ� �ܺ�����Ű �÷��� ���� ��쿡 �ַ� �����

SELECT * 
FROM EMPLOYEE
WHERE MGR_ID IS NOT NULL;

-- �����̸��� �� ������ ������ �̸� ��ȸ
SELECT E.EMP_NAME AS ����, M.EMP_NAME AS ������
FROM EMPLOYEE E
JOIN EMPLOYEE M ON (E.MGR_ID = M.EMP_ID);

-- N ���� ���̺� ����
SELECT EMP_NAME, JOB_TITLE, DEPT_NAME, LOC_DESCRIBE, COUNTRY_NAME
FROM EMPLOYEE
JOIN JOB USING (JOB_ID)
JOIN DEPARTMENT USING (DEPT_ID)
JOIN LOCATION ON (LOC_ID = LOCATION_ID)
JOIN COUNTRY USING (COUNTRY_ID);

-- ������ �븮�̸鼭, �ƽþ������� �ٹ��ϴ� ���� ��ȸ
-- ���, �̸�, ���޸�, �μ���, �ٹ�������, �޿� ��ȸ
SELECT EMP_ID ���, EMP_NAME �̸�, JOB_TITLE ���޸�, DEPT_NAME �μ���, SALARY �޿�
FROM EMPLOYEE
JOIN JOB USING (JOB_ID)
JOIN DEPARTMENT USING (DEPT_ID)
JOIN LOCATION ON (LOC_ID = LOCATION_ID)
WHERE JOB_TITLE ='�븮' AND LOC_DESCRIBE LIKE '�ƽþ�%';

--JOIN ��������
--
--1. 2020�� 12�� 25���� ���� �������� ��ȸ�Ͻÿ�.
SELECT TO_CHAR(TO_DATE('20201225', 'YYYYMMDD'), 'DAY') FROM DUAL;

--2. �ֹι�ȣ�� 60��� ���̸鼭 ������ �����̰�, ���� �达�� �������� 
--�����, �ֹι�ȣ, �μ���, ���޸��� ��ȸ�Ͻÿ�.
SELECT EMP_NAME, EMP_NO, DEPT_NAME, JOB_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT USING (DEPT_ID)
JOIN JOB USING (JOB_ID)
WHERE SUBSTR(EMP_NO, 1, 1) LIKE '6' AND SUBSTR(EMP_NO, 8, 1) LIKE '2' AND SUBSTR(EMP_NAME, 1, 1) LIKE '��';

SELECT MIN(TRUNC((MONTHS_BETWEEN(SYSDATE, TO_DATE(SUBSTR(EMP_NO, 1, 2), 'RR')) / 12))) ���� FROM EMPLOYEE;

--3. ���� ���̰� ���� ������ ���, �����, ����, �μ���, ���޸��� ��ȸ�Ͻÿ�.
SELECT
    T.*
FROM (SELECT
        E.EMP_ID, 
        E.EMP_NAME, 
        EXTRACT(YEAR FROM SYSDATE) - TO_NUMBER('19' || SUBSTR(E.EMP_NO, 1, 2)) ����, 
        D.DEPT_NAME, 
        J.JOB_TITLE
        FROM EMPLOYEE E 
        LEFT JOIN DEPARTMENT D ON E.DEPT_ID = D.DEPT_ID
        LEFT JOIN JOB J ON E.JOB_ID = J.JOB_ID
        ORDER BY AGE ASC
    ) T
WHERE ROWNUM = 1;


--4. �̸��� '��'�ڰ� ���� �������� ���, �����, �μ����� ��ȸ�Ͻÿ�.
SELECT EMP_ID, EMP_NAME, DEPT_NAME
FROM EMPLOYEE
JOIN DEPARTMENT USING (DEPT_ID)
WHERE EMP_NAME LIKE '��%';

SELECT E.EMP_ID, E.EMP_NAME, D.DEPT_NAME
FROM EMPLOYEE E
JOIN DEPARTMENT D on E.DEPT_ID = D.DEPT_ID 
WHERE E.EMP_NAME LIKE '��%';

--5. �ؿܿ������� �ٹ��ϴ� �����, ���޸�, �μ��ڵ�, �μ����� ��ȸ�Ͻÿ�.
SELECT EMP_NAME, JOB_TITLE, DEPT_ID, DEPT_NAME
FROM EMPLOYEE
JOIN DEPARTMENT USING (DEPT_ID)
JOIN JOB USING (JOB_ID)
WHERE DEPT_NAME LIKE '�ؿܿ���%';

--6. ���ʽ�����Ʈ�� �޴� �������� �����, ���ʽ�����Ʈ, �μ���, �ٹ��������� ��ȸ�Ͻÿ�.
SELECT EMP_NAME, BONUS_PCT, DEPT_NAME, LOC_DESCRIBE
FROM EMPLOYEE
JOIN DEPARTMENT USING (DEPT_ID)
JOIN LOCATION ON (LOC_ID = LOCATION_ID)
WHERE BONUS_PCT IS NOT NULL;

--7. �μ��ڵ尡 20�� �������� �����, ���޸�, �μ���, �ٹ��������� ��ȸ�Ͻÿ�.
SELECT EMP_NAME, JOB_TITLE, DEPT_NAME, LOC_DESCRIBE
FROM EMPLOYEE
JOIN JOB USING (JOB_ID)
JOIN DEPARTMENT USING (DEPT_ID)
JOIN LOCATION ON (LOC_ID = LOCATION_ID)
WHERE DEPT_ID = '20';

--8. ���޺� ������ �ּұ޿�(MIN_SAL)���� ���� �޴� ��������
--�����, ���޸�, �޿�, ������ ��ȸ�Ͻÿ�.
--������ ���ʽ�����Ʈ�� �����Ͻÿ�.
SELECT EMP_NAME, JOB_TITLE, SALARY, (SALARY+(SALARY * NVL(BONUS_PCT, 0)))*12 ����
FROM EMPLOYEE
JOIN JOB USING (JOB_ID)
WHERE (SALARY+(SALARY * NVL(BONUS_PCT, 0)))*12 > MIN_SAL;

--9. �ѱ�(KO)�� �Ϻ�(JP)�� �ٹ��ϴ� �������� 
--�����(emp_name), �μ���(dept_name), ������(loc_describe), ������(country_name)�� ��ȸ�Ͻÿ�.
SELECT EMP_NAME, DEPT_NAME, LOC_DESCRIBE, COUNTRY_NAME
FROM EMPLOYEE
JOIN DEPARTMENT USING (DEPT_ID)
JOIN LOCATION ON (LOC_ID = LOCATION_ID)
JOIN COUNTRY USING (COUNTRY_ID)
WHERE COUNTRY_ID IN ('KO', 'JP');


--10. ���� �μ��� �ٹ��ϴ� �������� �����, �μ��ڵ�, �����̸��� ��ȸ�Ͻÿ�.
--self join ���
SELECT E.EMP_NAME, E.DEPT_ID, E1.EMP_NAME
FROM EMPLOYEE E
JOIN EMPLOYEE E1 ON (E.DEPT_ID = E1.DEPT_ID);

--11. ���ʽ�����Ʈ�� ���� ������ �߿��� �����ڵ尡 J4�� J7�� �������� �����, ���޸�, �޿��� ��ȸ�Ͻÿ�.
--��, join�� IN ����� ��
SELECT EMP_NAME, JOB_TITLE, SALARY
FROM EMPLOYEE
JOIN JOB USING (JOB_ID)
WHERE BONUS_PCT IS NULL AND JOB_ID IN ('J4', 'J7');

--12. ��ȥ�� ������ ��ȥ�� ������ ���� ��ȸ�Ͻÿ�.
SELECT DISTINCT MARRIAGE ��ȥ����, COUNT(*) ��
FROM EMPLOYEE
GROUP BY MARRIAGE;

SELECT
    SUM(T.Y) AS Y,
    SUM(T.N) AS N
FROM
(SELECT 
    SUM(CASE WHEN MARRIAGE = 'Y' THEN 1 ELSE 0 END) AS Y,
     SUM(CASE WHEN MARRIAGE = 'N' THEN 1 ELSE 0 END) AS N
FROM EMPLOYEE 
GROUP BY MARRIAGE) T;

