-- DAY4 �������� : �Լ�

-- ������ �Լ� �׽�Ʈ
-- ��¥ ó�� �Լ�
-- SYSDATE �Լ� : �ý������� ���� ���� ��¥�� �ð��� ��ȸ
SELECT SYSDATE
FROM DUAL;

-- ����Ŭ������ ȯ�漳��, ��ü ���� �������� ��� ��������ϰ� ����.
-- ������ ��ųʸ�(������ ����) ������ ���̺��� ���·� ���� ���� �����ϰ� ����.
-- ������ ��ųʸ��� DB �ý����� ������.
-- ����� ������ ��ȸ�� ���� ����
-- ȯ�漳���� ���õ� �κ��� ���� ������ ������ �� ����.

SELECT *
FROM SYS.NLS_SESSION_PARAMETERS;

-- ��¥ ����� ���õ� ������ ��ȸ
SELECT VALUE
FROM SYS.NLS_SESSION_PARAMETERS
WHERE PARAMETER = 'NLS_DATE_FORMAT';

-- ��¥ ���� ����
ALTER SESSION
SET NLS_DATE_FORMAT = 'DD-MON-RR';

COMMIT;

-- Ȯ��
SELECT SYSDATE FROM DUAL;

ALTER SESSION
SET NLS_DATE_FORMAT = 'RR/MM/DD';

COMMIT;

SELECT SYSDATE FROM DUAL;

SELECT EMP_NAME, HIRE_DATE, ADD_MONTHS( HIRE_DATE, 240 )
FROM EMPLOYEE;

-- ���� ��¥���� 10�� �� ��¥��?
SELECT SYSDATE, ADD_MONTHS(SYSDATE, 120)
FROM DUAL;

-- ������ �߿��� �ٹ������ 20�� �̻�� ���� ��ȸ
-- ���, �̸�, �μ��ڵ�, �����ڵ�, �Ի��� ��Ī ó�� ��ȸ
SELECT EMP_ID ���, EMP_NAME �̸�, DEPT_ID �μ��ڵ�, JOB_ID �����ڵ�, HIRE_DATE �Ի���
FROM EMPLOYEE
WHERE ADD_MONTHS( HIRE_DATE, 240 ) < SYSDATE;

SELECT MONTHS_BETWEEN( '09/01/01', '09/03/14' )
FROM DUAL;

SELECT MONTHS_BETWEEN( '09/07/01', '09/03/14' )
FROM DUAL;

SELECT MONTHS_BETWEEN( '09/03/01', '09/03/01' )
FROM DUAL;

SELECT MONTHS_BETWEEN( '09/08/02', '09/06/02' )
FROM DUAL;

-- �������� �̸�, �Ի���, ��������� �ٹ��ϼ�, �ٹ�������, �ٹ���� ��ȸ
SELECT EMP_NAME �̸�, HIRE_DATE �Ի���, TRUNC(SYSDATE-HIRE_DATE) "��������� �ٹ��ϼ�",
TRUNC(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)) �ٹ�������, TRUNC(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)/12) �ٹ����
FROM EMPLOYEE;

-- NEXT_DAY(��¥������ | ��¥�� ��ϵ� �÷���, '�����̸�')
-- ������ ��¥ ���� ��¥���� ���� ����� �ش� ������ ��¥�� ������
SELECT SYSDATE, NEXT_DAY(SYSDATE, '�Ͽ���')
FROM DUAL;

-- �����ͺ��̽��� ��� �� �ѱ���� ������ �Ǿ� �ֱ� ������ �����̸��� �ѱ۷� �����.
-- ����� �����̸� ����ϸ� ������
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'SUNDAY')
FROM DUAL;

-- ������� �̸��� ����Ϸ���, �� �������ؾ� ��
ALTER SESSION
SET NLS_LANGUAGE = AMERICAN;

COMMIT;

SELECT SYSDATE, NEXT_DAY(SYSDATE, 'SUNDAY')
FROM DUAL;

ALTER SESSION
SET NLS_LANGUAGE = KOREAN;

COMMIT;

-- LAST_DAY(��¥������ | ��¥�� ��ϵ� �÷���)
-- ������ ��¥�� ���� ������ ��¥�� ������
SELECT LAST_DAY(SYSDATE)
FROM DUAL;

-- ���� ���̺��� �����, �Ի���, �Ի��� ���� �ٹ��ϼ� ��ȸ
SELECT EMP_NAME �����, HIRE_DATE �Ի���, (LAST_DAY(HIRE_DATE)-HIRE_DATE) "�Ի��� ���� �ٹ��ϼ�"
FROM EMPLOYEE;

-- ���� ��¥ ��ȸ �Լ�
SELECT SYSDATE, SYSTIMESTAMP, CURRENT_DATE, CURRENT_TIMESTAMP
FROM DUAL;

-- SUBSTR() �Լ��� �Ի�⵵, �Ի��, �Ի��� �и� ���� ��ȸ
SELECT SUBSTR(HIRE_DATE, 1, 2) �Ի���, SUBSTR(HIRE_DATE, 4, 2) �Ի��, SUBSTR(HIRE_DATE, 7, 2) �Ի���
FROM EMPLOYEE;

-- EXTRACT(������ ���� FROM ��¥������) : ��¥�����Ϳ��� ���ϴ� ������ ����
SELECT EXTRACT(YEAR FROM SYSDATE),
        EXTRACT(MONTH FROM SYSDATE),
        EXTRACT(DAY FROM SYSDATE)
FROM DUAL;

-- ������ �̸�, �Ի���, �ٹ���� ��ȸ
-- EXTRACT ���

SELECT EMP_NAME �̸�, HIRE_DATE �Ի���, (EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE)) �ٹ����
FROM EMPLOYEE;

SELECT EMP_NAME �̸�, HIRE_DATE �Ի���, FLOOR(MONTHS_BETWEEN(SYSDATE, HIRE_DATE) / 12) �ٹ����
FROM EMPLOYEE;

-- ����ȯ �Լ�
-- �ڵ�����ȯ�� ���
SELECT 20 + '10' FROM DUAL;
-- ����� ����ȯ
SELECT 20 + TO_NUMBER('10') FROM DUAL;

-- �ڵ�����ȯ�� �� �Ǵ� ���
SELECT SYSDATE - '15/03/25' FROM DUAL;

-- ����ȯ�ؾ� ��
SELECT SYSDATE - TO_DATE('15/03/25', 'YY/MM/DD')
FROM DUAL;

SELECT SYSDATE - TO_DATE('2015�� 3�� 25��', 'YYYY"��" MM"��" DD"��"')
FROM DUAL;

SELECT TO_CHAR(1234, '99999'), TO_CHAR(1234, '09999'), TO_CHAR(1234, 'L99999'), TO_CHAR(1234, '99,999'), TO_CHAR(1234, '09,999'),
TO_CHAR(1000, '9.9EEEE'), TO_CHAR(1234, '999') 
FROM DUAL;

-- �����, �޿�, ���ʽ�����Ʈ ��ȸ
-- �޿��� �տ� ��ȭ���� ǥ���ϰ�, ù���� ���б�ȣ�� ǥ����
-- ���ʽ�����Ʈ�� �Ҽ��� �Ʒ� ��°�ڸ����� ǥ����

SELECT EMP_NAME �����, '\ '||TO_CHAR(SALARY, 'L99,999,999') �޿�, TO_CHAR(NVL(BONUS_PCT, 0), '90.00') ���ʽ�����Ʈ
FROM EMPLOYEE;

SELECT TO_CHAR( SYSDATE, 'PM HH24:MI:SS' ), TO_CHAR(SYSDATE, 'AM HH:MI:SS' ), TO_CHAR( SYSDATE, 'MON DY, YYYY' ),
TO_CHAR(SYSDATE, 'YYYY-fmMM-DD DAY' ), TO_CHAR( SYSDATE, 'YYYY-MM-fmDD DAY' ), TO_CHAR( SYSDATE, 'Year, Q' )
FROM DUAL;

SELECT SYSDATE,
        TO_CHAR(SYSDATE, 'YYYY'), TO_CHAR(SYSDATE, 'RRRR'), 
        TO_CHAR(SYSDATE, 'YY'), TO_CHAR(SYSDATE, 'RR'),
        TO_CHAR(SYSDATE, 'YEAR')
FROM DUAL;

SELECT HIRE_DATE, 
        TO_CHAR(HIRE_DATE, 'YYYY "��"'), TO_CHAR(HIRE_DATE, 'RRRR "��"'),
        TO_CHAR(HIRE_DATE, 'YY'), TO_CHAR(HIRE_DATE, 'RR'),
        TO_CHAR(HIRE_DATE, 'YEAR')
FROM EMPLOYEE;

SELECT SYSDATE,
        TO_CHAR(SYSDATE, 'YYYY "��" MM "��"'),
        TO_CHAR(SYSDATE, 'MM'), TO_CHAR(SYSDATE, 'MONTH'),
        TO_CHAR(SYSDATE, 'MON'), TO_CHAR(SYSDATE, 'RM')
FROM DUAL;

SELECT SYSDATE, TO_CHAR(SYSDATE, '"1�����" DDD "��°"'), TO_CHAR(SYSDATE, '"1�ޱ���" DD "��°"'),
                  TO_CHAR(SYSDATE, '"1�ֱ���" D "��°"')
FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'Q"��б�"'), TO_CHAR(SYSDATE, 'DAY'), TO_CHAR(SYSDATE, 'DY')
FROM DUAL;

-- ���� ���̺��� �����, �Ի��� ��ȸ
-- �Ի����� ������ �����ؼ� '2016�� 05�� 19�� (��)' �������� ��� ó����

SELECT TO_CHAR(HIRE_DATE, 'YYYY"��" MM"��" DD"��" "("DY")"') �Ի���
FROM EMPLOYEE;


SELECT EMP_NAME, HIRE_DATE,
        TO_CHAR(HIRE_DATE, 'YYYY-MM-DD AM HH:MI:SS'),
        TO_CHAR(HIRE_DATE, 'YYYY-fmMM-DD AM HH:MI:SS'),
        TO_CHAR(HIRE_DATE, 'YYYY-fmMM-DD HH24:MI:SS')
FROM EMPLOYEE
WHERE EMP_ID = 100;


-- ��¥������ �񱳿���� �ð��� ���� ��¥�����Ϳ� �ð��� ���� ��¥�����ʹ� �� ������ �� ����
SELECT EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE HIRE_DATE = '90/04/01';  -- ��� �� ����

-- �ذ���
SELECT EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE HIRE_DATE LIKE '90/04/01';

SELECT EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE TO_CHAR(HIRE_DATE, 'YY/MM/DD') = '90/04/01';

-- ��¥�� ��ϵǾ� ������ ��¥�� �񱳿��� �� ������.
SELECT EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE HIRE_DATE = '04/04/30';

SELECT EMP_NAME AS �̸�,
TO_CHAR(HIRE_DATE, 'YYYY-MM-DD') AS �Ի���
FROM EMPLOYEE
WHERE JOB_ID = 'J7';

SELECT EMP_NAME AS �̸�,
TO_CHAR(HIRE_DATE, 'YYYY"��" MM"��" DD"��"') AS �Ի���
FROM EMPLOYEE
WHERE JOB_ID = 'J7';

SELECT EMP_NAME AS �̸�,
SUBSTR(HIRE_DATE,1,2)||'�� '||
SUBSTR(HIRE_DATE,4,2)||'�� '||
SUBSTR(HIRE_DATE,7,2)||'��' AS �Ի���
FROM EMPLOYEE
WHERE JOB_ID = 'J7';

SELECT TO_DATE( '20100101', 'YYYYMMDD') FROM DUAL; -- 10/01/01
SELECT TO_CHAR( '20100101', 'YYYY, MON') FROM DUAL; -- N/A(����)
SELECT TO_CHAR( TO_DATE( '20100101', 'YYYYMMDD'),
'YYYY, MON') FROM DUAL; -- 2010, 1��
SELECT TO_DATE( '041030 143000', 'YYMMDD HH24MISS' ) FROM DUAL; --04/10/30
SELECT TO_CHAR( TO_DATE( '041030 143000', 'YYMMDD HH24MISS' ),
'DD-MON-YY HH:MI:SS PM' ) FROM DUAL; -- 30-10��-04 02:30:00 ����
SELECT TO_DATE( '980630', 'YYMMDD' ) FROM DUAL; -- 98/06/30
SELECT TO_CHAR( TO_DATE( '980630', 'YYMMDD' ),
'YYYY.MM.DD') FROM DUAL; 

SELECT EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE HIRE_DATE = TO_DATE('900401 133030','YYMMDD HH24MISS');

SELECT EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE TO_CHAR(HIRE_DATE, 'YYMMDD') = '900401';

SELECT EMP_NAME, HIRE_DATE, TO_CHAR(HIRE_DATE, 'YYYY/MM/DD')
FROM EMPLOYEE
WHERE EMP_NAME = '�Ѽ���';

-- RR �� YY �� ����
-- ���ڸ� �⵵�� ���ڸ� �⵵�� �ٲ� ��
-- ���� �⵵ (16 : 50 ���� ����) �϶�,
-- �ٲ� �⵵�� 50�̸��̸� 2000�⵵�� ����, �ٲ� �⵵�� 50 �̻��̸� 1900�� �����

SELECT HIRE_DATE, TO_CHAR(HIRE_DATE, 'RRRR'), TO_CHAR(HIRE_DATE, 'YYYY')
FROM EMPLOYEE;

-- ���� �⵵�� �ٲ� �⵵�� �� �� 50�̸��̸�, Y, R �ƹ��ų� ����ص� �� : ���� ���Ⱑ �����
SELECT TO_CHAR(TO_DATE('160505', 'YYMMDD'), 'YYYY-MM-DD'),
        TO_CHAR(TO_DATE('160505', 'RRMMDD'), 'RRRR-MM-DD'),
        TO_CHAR(TO_DATE('160505', 'YYMMDD'), 'RRRR-MM-DD'),
        TO_CHAR(TO_DATE('160505', 'RRMMDD'), 'YYYY-MM-DD')
FROM DUAL;

-- ���� �⵵�� 50�̸��̰�, �ٲ� �⵵�� 50�̻��� ��
-- �⵵�� �ٲ� �� Y ���� ���� ����(2000��) ���� �ٲ�
-- R�� ����ϸ� ���� ����(1900��) �����
SELECT TO_CHAR(TO_DATE('990101', 'YYMMDD'), 'YYYY-MM-DD'),
        TO_CHAR(TO_DATE('990101', 'RRMMDD'), 'RRRR-MM-DD'),
        TO_CHAR(TO_DATE('990101', 'YYMMDD'), 'RRRR-MM-DD'),
        TO_CHAR(TO_DATE('990101', 'RRMMDD'), 'YYYY-MM-DD')
FROM DUAL;

-- ��� : ���ڸ� ��¥�� �ٲ� �� �⵵�� 'R' ����ϸ� ��

SELECT EMP_NAME, EMP_NO, SUBSTR(EMP_NO,1,6)AS �պκ�, SUBSTR(EMP_NO,8) AS �޺κ�, 
TO_NUMBER( SUBSTR(EMP_NO,1,6) ) + TO_NUMBER( SUBSTR(EMP_NO,8) ) AS ���
FROM EMPLOYEE
WHERE EMP_ID = '101';

-- NVL(�÷���, �÷��� ���� NULL �� �� �ٲ� ��)
SELECT EMP_NAME, NVL(BONUS_PCT, 0.0), NVL(DEPT_ID, '00'), NVL(JOB_ID, 'J0')
FROM EMPLOYEE;

-- NVL2(�÷���, �ٲܰ�1, �ٲܰ�2)
-- �ش� �÷��� ���� ������ �ٲܰ�1�� �ٲٰ�, NULL�̸� �ٲܰ�2�� �ٲ�

-- ���� �������� ���ʽ�����Ʈ�� 0.2�̸��̰ų� NULL�� �������� ��ȸ
-- ���, �����, ���ʽ�����Ʈ, ���溸�ʽ�����Ʈ

SELECT EMP_ID ���, EMP_NAME �����, BONUS_PCT ���������ʽ�����Ʈ, NVL2(BONUS_PCT, 0.15, 0.05) �����ĺ��ʽ�����Ʈ
FROM EMPLOYEE
WHERE BONUS_PCT < 0.2 OR BONUS_PCT IS NULL;

SELECT EMP_NAME, DECODE(SUBSTR(EMP_NO,8,1), '1', '��', '2', '��', '3', '��', '4', '��') AS ����
FROM EMPLOYEE
WHERE DEPT_ID = '50';

SELECT EMP_NAME, DECODE(SUBSTR(EMP_NO,8,1), '1', '��', '3', '��', '��') AS ����
FROM EMPLOYEE
WHERE DEPT_ID = '50';

SELECT EMP_ID, EMP_NAME, DECODE(MGR_ID, NULL, '����', MGR_ID) AS ������
FROM EMPLOYEE
WHERE JOB_ID = 'J4';

SELECT EMP_ID, EMP_NAME, NVL(MGR_ID, '����') AS ������
FROM EMPLOYEE
WHERE JOB_ID = 'J4';

SELECT EMP_NAME, JOB_ID, SALARY, DECODE(JOB_ID, 'J7', SALARY*1.1, 'J6', SALARY*1.15, 'J5', SALARY*1.2, SALARY*1.05) AS �λ�޿�
FROM EMPLOYEE;

SELECT EMP_NAME, JOB_ID, SALARY,
CASE JOB_ID
      WHEN 'J7' THEN TO_CHAR(SALARY*1.1)
      WHEN 'J6' THEN TO_CHAR(SALARY*1.15)
      WHEN 'J5' THEN TO_CHAR(SALARY*1.2)
      ELSE TO_CHAR(SALARY*1.05) END AS �λ�޿�
FROM EMPLOYEE;

SELECT EMP_ID, EMP_NAME, SALARY,
CASE WHEN SALARY <= 3000000 THEN '�ʱ�'
      WHEN SALARY <= 4000000 THEN '�߱�'
      ELSE '���' END AS ����
FROM EMPLOYEE
ORDER BY ����; --�������� ���� ó����