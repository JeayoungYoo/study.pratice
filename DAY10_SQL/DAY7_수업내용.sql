-- DAY7 ��������

-- SET OPERATOR (���� ������)
-- UNION (������), UNION ALL, INTERSECT (������), MINUS (������)
-- ���� ���� SELECT ���� ����� ��ĥ �� ����ϴ� ��������.
-- ������ : UNION, UNION ALL (RESULT SET �� �ϳ��� ��ħ)
-- ������ : INTERSECT (�� RESULT SET �� ����� ����� ������)
-- ������ : MINUS (ù��° RESULT SET ���� �ι�° RESULT SET �� ��ġ�ϴ� ����� ��)

-- UNION : ��ġ�ϴ� ����� �ϳ��� ����� ����
SELECT EMP_ID, ROLE_NAME
FROM EMPLOYEE_ROLE
UNION
SELECT EMP_ID, ROLE_NAME
FROM ROLE_HISTORY;

-- UNION ALL : ��� ����� ��ħ
SELECT EMP_ID, ROLE_NAME
FROM EMPLOYEE_ROLE
UNION ALL
SELECT EMP_ID, ROLE_NAME
FROM ROLE_HISTORY;

-- INTERSECT : �ߺ��Ǵ� ����� ����
SELECT EMP_ID, ROLE_NAME
FROM EMPLOYEE_ROLE
INTERSECT
SELECT EMP_ID, ROLE_NAME
FROM ROLE_HISTORY;

-- MINUS : ù��° ���� ������� �ι�° ���� ����� �ߺ��Ǵ� ���� ������
SELECT EMP_ID, ROLE_NAME
FROM EMPLOYEE_ROLE
MINUS
SELECT EMP_ID, ROLE_NAME
FROM ROLE_HISTORY;

-- SET �����ڻ��� ���ǻ���
-- SELECT ���� �÷������� �ݵ�� ���ƾ� �� : ���� (DUMMY) �÷����� ������ ������� ����
-- �� SELECT ���� ������ �÷��� �ڷ����� �ݵ�� ���ƾ� ��

SELECT EMP_NAME, JOB_ID, HIRE_DATE
FROM EMPLOYEE
WHERE DEPT_ID = '20';

SELECT DEPT_NAME, DEPT_ID
FROM DEPARTMENT
WHERE DEPT_ID = '20';

-- 50�� �μ��� �Ҽӵ� ���� �� �����ڿ� �Ϲ� ������ ���� ��ȸ�ؼ� �ϳ��� ���Ķ�.
SELECT EMP_ID, EMP_NAME, '������' AS ����
FROM EMPLOYEE
WHERE DEPT_ID = '50' AND EMP_ID = '141'
UNION
SELECT EMP_ID, EMP_NAME, '����' AS ����
FROM EMPLOYEE
WHERE DEPT_ID = '50' AND EMP_ID <> '141'
ORDER BY 3, 1;  -- �� �������� �� �� �� ����� �� ����.

SELECT 'SQL�� �����ϰ� �ֽ��ϴ�' ����, 3 ����
FROM DUAL
UNION
SELECT '�츮�� ����', 1
FROM DUAL
UNION
SELECT '���� ����ְ�', 2
FROM DUAL;

SELECT 'SQL�� �����ϰ� �ֽ��ϴ�' ����, 3 ���� FROM DUAL
UNION
SELECT '�츮�� ����', 1 FROM DUAL
UNION
SELECT '���� ����ְ�', 2 FROM DUAL
ORDER BY 2;

SELECT 'SQL�� �����ϰ� �ֽ��ϴ�' ����, 3 ���� FROM DUAL
UNION
SELECT '�츮�� ����', 1 FROM DUAL
UNION
SELECT '���� ����ְ�', 2 FROM DUAL
ORDER BY ����;

-- ���� �����ڿ� JOIN�� ����
SELECT EMP_ID, ROLE_NAME
FROM EMPLOYEE_ROLE
INTERSECT
SELECT EMP_ID, ROLE_NAME
FROM ROLE_HISTORY;

-- USING (EMP_ID, ROLE_NAME)
-- �� �÷��� ���� �ϳ��� ������ �����ϰ� ��ġ�ϴ� �׸��� ã��
-- (104, SE) = (104, SE) : ���� ��
-- (104, SE-ANLY) != (104, SE) : �ٸ� ��

SELECT EMP_ID, ROLE_NAME
FROM EMPLOYEE_ROLE
JOIN ROLE_HISTORY USING (EMP_ID, ROLE_NAME);

-- ���� �������� IN �������� ����
-- UNION �� IN �� ���� ������ ����� ���� �� ����
-- ������ �븮 �Ǵ� ����� ������ �̸��� ���޸��� ��ȸ
-- ���޼� �������� ����, ���� ������ ��� �̸��� �������� ���� ó����

SELECT EMP_NAME, JOB_TITLE
FROM EMPLOYEE
JOIN JOB USING (JOB_ID)
WHERE JOB_TITLE IN ('�븮', '���')
ORDER BY 2, 1;

-- UNION ���� �ٲٸ�
SELECT EMP_NAME, JOB_TITLE
FROM EMPLOYEE
JOIN JOB USING (JOB_ID)
WHERE JOB_TITLE = '�븮'
UNION
SELECT EMP_NAME, JOB_TITLE
FROM EMPLOYEE
JOIN JOB USING (JOB_ID)
WHERE JOB_TITLE = '���'
ORDER BY 2, 1;

-- ���� ���� (SUB QUERY)
/*
    �޼ҵ�(�޼ҵ�()) : ���� �޼ҵ尡 ������ ���� �ٱ� �޼ҵ尡 �������ڷ� �����
    �������� WHERE ������
        �÷��� �񱳿����� ���Ұ�
        - ���� ���� �������� ���ؼ� �˾Ƴ��� �ϴ� ���� ��
        �� �������� �ۼ��ؼ� ������ ���� ������� ������ �ڿ� �����
        
        �÷��� �񱳿����� (���� �� �˾Ƴ��� ������)
        ��, �÷��� �񱳿����� (SELECT ��....)
*/

--���� ���� : ������ �ȿ� ���� ������
-- �ٱ� �������� ����������� ��

-- �� : ���¿� �̶�� ������ ���� �μ��� �Ҽӵ� �������� ����� ��ȸ
-- 1. ���¿��� �Ҽӵ� �μ� ��ȸ
SELECT DEPT_ID
FROM EMPLOYEE
WHERE EMP_NAME = '���¿�';

-- 2. ��ȸ�� ������� ������ �μ������� ��ȸ
SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_ID = '50';

-- ���������� �̿��ϸ�
SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_ID = (SELECT DEPT_ID
                 FROM EMPLOYEE
                 WHERE EMP_NAME = '���¿�');

-- ���������� ������ ������ ��������, ������ ��������, ���߿� ��������,
-- ������ ���߿� ��������, ��ȣ���� ��������, ��Į�� �������� ������ ���е�.
-- �������� ������ ���� �������� �տ� ���̴� �����ڰ� �ٸ�.

-- ������ (single row) ��������
-- ���������� ������� �� ���� ���
-- ������ �������� �տ��� �Ϲ� �񱳿����� ��� ��� ������
-- <, >, <=, >=, =, !=/<>/^=

-- �� : ���¿��� ������ �����鼭, ���¿����� �޿��� ���� �޴� ������ �̸�, ����, �޿� ��ȸ
SELECT EMP_NAME, JOB_ID, SALARY
FROM EMPLOYEE
WHERE JOB_ID = (SELECT JOB_ID
                FROM EMPLOYEE
                WHERE EMP_NAME = '���¿�')
AND SALARY > (SELECT SALARY
                FROM EMPLOYEE
                WHERE EMP_NAME = '���¿�');

-- �μ��� �޿��� �հ��� ���� ū ���� ��ȸ
-- �μ���, �޿��հ� ���

SELECT T.*
FROM (SELECT DEPT_NAME, SUM(SALARY)
        FROM EMPLOYEE
        JOIN DEPARTMENT USING (DEPT_ID)
        GROUP BY DEPT_NAME
        ORDER BY 2 DESC) T
WHERE ROWNUM = 1;

SELECT DEPT_NAME, SUM(SALARY)
FROM EMPLOYEE
LEFT OUTER JOIN DEPARTMENT USING (DEPT_ID)
GROUP BY DEPT_NAME
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY))
                        FROM EMPLOYEE
                        GROUP BY DEPT_ID); -- ������ ��������
                        
-- ���������� �Ϲ������� SELECT��, FROM�� WHERE��, HAVING���� �ַ� �����
-- ���������� ORDER BY �������� ����� ���� ����.

-- ������ �������� : ������� ������ ���� ���� ��������
-- ������ �������� �տ��� ���� ���� ���� �� ������ �� �ִ� �����ڸ� ����ؾ� ��
-- �� ���� ���� ���ϴ� �Ϲ� �񱳿����� ��� �� ��
-- IN/NOT IN, > ANY, < ANY, > ALL, < ALL �����ڸ� �ַ� �����

SELECT MGR_ID
FROM EMPLOYEE
WHERE MGR_ID IS NOT NULL;

SELECT EMP_ID, EMP_NAME, '������' AS ����
FROM EMPLOYEE
WHERE EMP_ID IN (SELECT MGR_ID
                 FROM EMPLOYEE)
UNION
SELECT EMP_ID, EMP_NAME, '����'
FROM EMPLOYEE
WHERE EMP_ID NOT IN (SELECT MGR_ID FROM EMPLOYEE
                     WHERE MGR_ID IS NOT NULL)
ORDER BY 3, 1;

-- �μ����� �� �μ��� ���� �޿��� �ް� �ִ� ���� ��ȸ
-- �μ��� ���� �޿� ��ȸ
SELECT MIN(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_ID;

SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY IN (SELECT MIN(SALARY)
                 FROM EMPLOYEE
                 GROUP BY DEPT_ID);  -- ������ ����������

-- IN (�� ���� ��) : �������� ���� �߿��� �� ���� ��ġ�ϴ� ���� ������
-- NOT IN (�� ���� ��) : �������� ���� �߿� �Ѱ��� ��ġ�ϴ� ���� ���ٸ�
-- > ANY (�� ���� ��) : ���� ���� ���� �߿� �� ���� ū ���� �ִٸ�
--                     ���� ���� ������ ũ�� 
-- < ANY (�� ���� ��) : ���� ���� ���� �߿� �� ���� ���� ���� �ִٸ�
--                     ���� ū ������ ������
-- = ANY (�� ���� ��) : IN �����ڿ� ������
-- > ALL (�� ���� ��) : ���� ���� ���� ��κ��� ũ�� (���� ū ������ ũ��)
-- < ALL (�� ���� ��) : ���� ���� ���� ��κ��� ������ (���� ���� ������ ������)
-- EXIST (�� ���� ��) : ���� ������ ���� �ϳ��� �����ϴ��� (����� TRUE / FALSE ��)
-- NOT EXIST (�� ���� ��) : ���� ������ ���� �������� �ʴ���


-- SELECT ���� ���������� ����� �� ����
SELECT EMP_ID , EMP_NAME, CASE WHEN EMP_ID IN (SELECT MGR_ID
                                               FROM EMPLOYEE)
                          THEN '������' ELSE '����' END AS ����
FROM EMPLOYEE
ORDER BY 3, 1;

-- > ANY (������ ��������) : ���� ���� ������ ũ��
-- < ANY (������ ��������) : ���� ū ������ ������
-- �븮 ������ �����߿��� ���� ������ �޿��� �ּҰ����� ���� �޴� ������ ��ȸ
-- ���, �̸�, ���޸�, �޿�
SELECT EMP_ID, EMP_NAME, JOB_TITLE, SALARY
FROM EMPLOYEE
JOIN JOB USING (JOB_ID)
WHERE JOB_TITLE = '�븮' AND SALARY > ANY (SELECT SALARY
                                           FROM EMPLOYEE
                                           JOIN JOB USING (JOB_ID)
                                           WHERE JOB_TITLE = '����');
                                           
-- > ALL (������ ��������) : ���� ū ������ ũ��
-- < ALL (������ ��������) : ���� ���� ������ ������

-- ���� ������ �޿��� ���� ū ������ ���� �޴� �븮������ ���� ��ȸ
-- �����, ���޸�, �޿�

SELECT EMP_NAME, JOB_TITLE, SALARY
FROM EMPLOYEE
JOIN JOB USING (JOB_ID)
WHERE JOB_TITLE LIKE '�븮'
AND SALARY > ALL (SELECT SALARY
                  FROM EMPLOYEE
                  JOIN JOB USING (JOB_ID)
                  WHERE JOB_TITLE LIKE '����');
                                           
-- �������� ��� ��ġ 
-- SELECT ��, FROM ��, WHERE ��, GROUP BY ��, HAVING ��, ORDER BY ��
-- INSERT ��, UPDATE ��, CREATE TABLE ��, CREATE VIEW ��

-- �ڱ� ������ ��� �޿��� �ް� �ִ� ���� ��ȸ
-- �����, ���޸�, �޿�
SELECT EMP_NAME, JOB_TITLE, SALARY
FROM EMPLOYEE
RIGHT JOIN JOB USING (JOB_ID)
WHERE SALARY IN (SELECT TRUNC(AVG(SALARY), -5)
                FROM EMPLOYEE
                GROUP BY JOB_ID);
                
-- FROM ������ �������� ����� �� ���� : ���̺� ��ſ� �����
-- �ζ��� ��(INLINE VIEW) ��� �� : FROM ���� ���� ���������� ��� ����

-- ANSI ǥ�� ���� ���̺��� ��Ī ����� �� ����
-- ON ������ ���ÿ��� ��Ī ��� ������

-- �ڱ� ������ ��� �޿��� �޴� ���� ��ȸ : �ζ��� �� ���
SELECT EMP_NAME, JOB_TITLE, SALARY
FROM (SELECT JOB_ID, TRUNC(AVG(SALARY), -5) JOBAVG
      FROM EMPLOYEE
      GROUP BY JOB_ID) V
LEFT JOIN EMPLOYEE E ON (V.JOBAVG = E.SALARY
                         AND NVL(V.JOB_ID, ' ') = NVL(E.JOB_ID, ' '))
LEFT JOIN JOB J ON (E.JOB_ID = J.JOB_ID)
ORDER BY 3, 2;

-- ��κ��� ���������� ���������� ���� ���� ���� ������ ����ϴ� ������
-- ��[ȣ��]�� ���������� ���������� ���� ������ �÷����� ������ ����ؼ� ����� ����
-- ���� ������ �÷����� �ٲ��, ���������� ����� �޶���

SELECT EMP_ID, EMP_NAME, '������' AS ����
FROM EMPLOYEE E
WHERE EXISTS (SELECT NULL
              FROM EMPLOYEE
              WHERE E.EMP_ID = MGR_ID)
UNION
SELECT EMP_ID, EMP_NAME, '����'
FROM EMPLOYEE E2
WHERE NOT EXISTS (SELECT NULL
                  FROM EMPLOYEE
                  WHERE E2.EMP_ID = MGR_ID)
ORDER BY 3, 1;

-- �ڱ� ������ ��� �޿��� �޴� ���� ��ȸ : ��������� ����� ���

SELECT EMP_NAME, JOB_TITLE, SALARY
FROM EMPLOYEE E
LEFT JOIN JOB J ON (E.JOB_ID = J.JOB_ID)
WHERE SALARY = (SELECT TRUNC(AVG(SALARY), -5)
                FROM EMPLOYEE
                WHERE NVL(JOB_ID, ' ') = NVL(E.JOB_ID, ' '))
ORDER BY 2;

-- ��Į�� �������� : ������ �������� + �������
-- �� ���� �� �÷����� �����ϴ� ��ȣ���� ��������

-- �����, �μ��ڵ�, �޿�, �ش� ������ �Ҽӵ� �μ��� �޿� ����� ���϶�
SELECT EMP_NAME, DEPT_ID, SALARY,
(SELECT TRUNC(AVG(SALARY), -5) -- �ҼӺμ��� �޿���հ��� 1����
 FROM EMPLOYEE
 WHERE DEPT_ID = E.DEPT_ID) AS AVGSAL
FROM EMPLOYEE E;
              

-- CASE ǥ������ ����� ��Į�� ��������
-- �μ��� �ٹ������� 'OT' �̸� '������', �ƴϸ� '������' ���� ������ �ٹ������� ����
-- �Ҽ��� ��ȸ��
SELECT EMP_ID, EMP_NAME, CASE WHEN DEPT_ID = (SELECT DEPT_ID
                                              FROM DEPARTMENT
                                              WHERE LOC_ID = 'OT')
                         THEN '������'
                         ELSE '������' END �Ҽ�
FROM EMPLOYEE
ORDER BY �Ҽ� DESC;



-- ORDER BY ���� ��Į�� �������� ���
-- ������ �Ҽӵ� �μ��� �μ����� ū ������ �����ؼ� ���� ���� ��ȸ
SELECT EMP_ID ,EMP_NAME, DEPT_ID, HIRE_DATE
FROM EMPLOYEE E
ORDER BY (SELECT DEPT_NAME
            FROM DEPARTMENT
            WHERE DEPT_ID = E.DEPT_ID) DESC NULLS LAST;
            
-- TOP-N �м�
-- ���� �� ��, ���� �� ���� ��ȸ�� ��

-- �ζ��� ���, RANK() �Լ��� �̿��� TOP-N �м��� ��
-- ������ �߿��� �޿��� ���� ���� �޴� ���� 5�� ��ȸ

SELECT *
FROM (SELECT EMP_NAME, SALARY,
      RANK() OVER(ORDER BY SALARY DESC) ����
      FROM EMPLOYEE) V
WHERE ���� <= 5;

-- ROWNUM �� �̿��� TOP-N �м�
-- ORDER BY �� ����� ROWNUM �� ���� (�Ұ��� : ���������� �̿��ؾ� ��)
-- �� ��ȣ(ROWNUM)�� FROM ���� WHERE ���� ����ǰ� ���� ����

SELECT ROWNUM, EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
ORDER BY SALARY DESC;

-- �޿� ���� �޴� ���� 3�� ��ȸ
-- �� ��ȣ, �̸�, �޿�
SELECT ROWNUM, EMP_NAME, SALARY
FROM (SELECT *
      FROM EMPLOYEE
      ORDER BY SALARY DESC)
WHERE ROWNUM < 4 ;