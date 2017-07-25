-- DAY3 �������� : �Լ�

-- �Լ�(FUNCTION)
-- ������ �Լ��� �׷��Լ��� ���е� :
-- SELECT ������ �Բ� ��� �� ��. WHERE �������� �׷��Լ� ��� �� ��

-- ������ (SINGLE ROW) �Լ� : �÷��� ��ϵ� N���� ���� �о N���� ����� ����� �Լ�



SELECT EMP_ID, EMP_NAME, UPPER(EMAIL)  -- UPPER �����Լ�
FROM EMPLOYEE;

SELECT EMAIL, LENGTH(EMAIL) ���ڰ���
FROM EMPLOYEE;

SELECT AVG(SALARY)  -- AVG �׷��Լ�
FROM EMPLOYEE;

-- �׷��Լ� : �÷��� ��ϵ� N���� ���� �о 1���� ����� �����ϴ� �Լ�
-- �޿� �հ�, �޿� ���
SELECT SUM(SALARY), AVG(SALARY)
FROM EMPLOYEE;

-- ������ �Լ��� �׷��Լ��� SELECT ������ �Բ� ��� �� ��
-- ����Ŭ�� ��ü������ DB �� : ����� �ݵ�� 2���� ���̺� ���������� (�簢���̾�� ��)

SELECT UPPER(EMAIL), AVG(SALARY)
FROM EMPLOYEE;  -- ERROR

-- WHERE �������� ������ �Լ��� ��� ������
-- �� : ��ü ������ �޿��� ��պ��� �޿��� ���� �޴� ���� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE SALARY > AVG(SALARY); -- �������� ����ϸ� ó������

-- ���������� �̿��ϸ� �ذ��� �� ����
SELECT *
FROM EMPLOYEE
WHERE SALARY >  (SELECT AVG(SALARY) FROM EMPLOYEE);

-- ������ �Լ� �׽�Ʈ
-- ���ڿ� ���� �Լ�
-- LENGTH('���ڿ���' | ���ڿ��� ��ϵ� �÷���) : ���ڰ����� ������

SELECT LENGTH('ORACLE')
FROM DUAL;

SELECT LENGTH(EMAIL)
FROM EMPLOYEE;

-- LENGTH() �Լ��� �̿��ؼ�, CHAR �ڷ���(�������� ���ڿ�)�� VARCHAR2 (�������� ���ڿ�) ������ ��
CREATE TABLE LENGTH_TEST(
  VALUE1 CHAR(10),
  VALUE2 VARCHAR2(10)
);

INSERT INTO LENGTH_TEST (VALUE1, VALUE2)
VALUES ('ORACLE', 'ORACLE');

COMMIT;

SELECT * FROM LENGTH_TEST;
SELECT LENGTH(VALUE1), LENGTH(VALUE2) FROM LENGTH_TEST;

SELECT LENGTH(CHARTYPE), LENGTH(VARCHARTYPE)
FROM COLUMN_LENGTH;

-- LENGTHB('���ڿ���' | ���ڿ��� ��ϵ� �÷���) �Լ� : ��ϵ� ���ڿ� ����Ʈ�� ũ�⸦ ������
SELECT LENGTHB(CHARTYPE), LENGTHB(VARCHARTYPE)
FROM COLUMN_LENGTH;

-- INSTR('���ڿ���' | ���ڿ��� ��ϵ� �÷���, 'ã������'[, ã�� ������ġ, ���°����])
-- ã�� ������ ��ġ�� ���ϵ�.
SELECT EMAIL, INSTR(EMAIL, '@')
FROM EMPLOYEE;

-- �̸��� �ּҿ��� '@' ���� �ٷ� �ڿ� �ִ� 'K' ������ ��ġ�� ��ȸ
-- �� �ڿ��� ���� �˻���
SELECT EMAIL, INSTR(EMAIL, 'k', -1, 3)
FROM EMPLOYEE;


-- �Լ��� ��ø ��� ������ : �Լ� �ȿ� �Լ� ���
-- �̸��� �ּҿ��� '.' �ٷ� �� ������ ��ġ ��ȸ
-- �� '.' ���� �ٷ� �� ���ں��� �˻� �����ϵ��� ��
SELECT EMAIL, INSTR(EMAIL, 'c', INSTR(EMAIL, '.') -1)
FROM EMPLOYEE;

-- LPAD/RPAD('���ڿ�' | ���ڿ��� ��ϵ� �÷���, ��³ʺ� ����Ʈ��, 'ä�﹮��')
-- ���� ������ ä�﹮�ڷ� ä��(�⺻�� ���鹮��)

SELECT EMAIL AS ����������, LENGTH(EMAIL) AS ��������,
LPAD(EMAIL, 20, '*') AS ä�����, 
LENGTH(LPAD(EMAIL, 20, '*')) AS �������
FROM EMPLOYEE;

SELECT EMAIL AS ����������,
LENGTH(EMAIL) AS ��������,
RPAD(EMAIL, 20, '*') AS ������,
LENGTH(RPAD(EMAIL, 20, '*')) AS �������
FROM EMPLOYEE;

SELECT LTRIM('   tech') FROM DUAL;
SELECT LTRIM('   tech', ' ') FROM DUAL; 
SELECT LTRIM('000123', '0') FROM DUAL;
SELECT LTRIM('123123Tech', '123') FROM DUAL; 
SELECT LTRIM('xyxzyyyTech', 'xyz') FROM DUAL; 
SELECT LTRIM('6372Tech', '0123456789') FROM DUAL;

SELECT RTRIM('tech   ') FROM DUAL;
SELECT RTRIM('tech   ', ' ') FROM DUAL; 
SELECT RTRIM('123000', '0') FROM DUAL;
SELECT RTRIM('Tech123123', '123') FROM DUAL;
SELECT RTRIM('Techxyxzyyy', 'xyz') FROM DUAL; 
SELECT RTRIM('Tech6372', '0123456789') FROM DUAL;

SELECT TRIM('  tech  ') FROM DUAL;
SELECT TRIM('a' FROM 'aatechaaa') FROM DUAL; 
SELECT TRIM(LEADING '0' FROM '000123') FROM DUAL;
SELECT TRIM(TRAILING '1' FROM 'Tech1') FROM DUAL; 
SELECT TRIM(BOTH '1' FROM '123Tech111') FROM DUAL;
SELECT TRIM(LEADING FROM '  Tech  ') FROM DUAL;

SELECT SUBSTR('This is a test', 6, 2) FROM DUAL;
SELECT SUBSTR('This is a test', 6) FROM DUAL;
SELECT SUBSTR('�̰��� �����Դϴ�', 3, 4) FROM DUAL;
SELECT SUBSTR('TechOnTheNet', 1, 4) FROM DUAL;
SELECT SUBSTR('TechOnTheNet', -3, 3) FROM DUAL;
SELECT SUBSTR('TechOnTheNet', -6, 3) FROM DUAL;
SELECT SUBSTR('TechOnTheNet', -8, 2) FROM DUAL;

-- �������� �ֹι�ȣ���� ����, ����, ������ ���� �и� ��ȸ
SELECT SUBSTR(EMP_NO, 1, 2) ����, SUBSTR(EMP_NO, 3, 2) ����, SUBSTR(EMP_NO, 5, 2) ����
FROM EMPLOYEE;

-- ��¥ �����Ϳ��� ����� �� ����
-- �������� �Ի��Ͽ��� �Ի�⵵, �Ի��, �Ի����� �и� ��ȸ

SELECT SUBSTR(HIRE_DATE, 1, 2) �Ի�⵵, SUBSTR(HIRE_DATE, 4, 2) �Ի��, SUBSTR(HIRE_DATE, 7, 2) �Ի�⵵
FROM EMPLOYEE;

-- SUBSTRB('���ڿ���' | ���ڿ��� ��ϵ� �÷���, ������ ����Ʈ��ġ, ������ ����Ʈ)
SELECT SUBSTR('ORACLE', 3, 2), SUBSTRB('ORACLE', 3, 2)
FROM DUAL;

SELECT SUBSTR('����Ŭ', 2, 2), SUBSTRB('����Ŭ', 4, 6)
FROM DUAL;

-- UPPER('���ڿ���' | �÷���) : �빮�ڷ� �ٲٴ� �Լ�
-- LOWER('���ڿ���' | �÷���) : �ҹ��ڷ� �ٲٴ� �Լ�
-- INITCAP('���ڿ���' | �÷���) : ù���ڸ� �빮�ڷ� �ٲٴ� �Լ�
SELECT UPPER('ORACLE'), UPPER('oracle'),
        LOWER('ORACLE'), LOWER('oracle'),
        INITCAP('ORACLE'), INITCAP('oracle')
FROM DUAL;

-- �Լ� ��ø ���
-- ���� �������� �̸�, ���̵� ��ȸ
-- ���̵�� �̸��Ͽ��� ���̵� �и� ������

SELECT EMP_NAME �̸�, SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1) ���̵�
FROM EMPLOYEE;

-- ���� ���̺��� �����, �ֹι�ȣ ��ȸ
-- �ֹι�ȣ�� ������ϸ� ���̰� �ϰ� ���ڸ� ���� '*' �� ó���� : 781125-*******

SELECT EMP_NAME �����, RPAD(SUBSTR(EMP_NO, 1 , 7), 14, '*') �ֹι�ȣ
FROM EMPLOYEE;


-- ����ó���Լ� : ROUND, TRUNC, FLOOR, ABS, MOD

-- ROUND(���ڰ� | ���ڰ� ��ϵ� �÷��� | ����, �ݿø��� �ڸ���)
-- �������� ���� 5�̻��̸� �ڵ� �ݿø���
-- �ڸ����� ����̸� �Ҽ��� �Ʒ� �ڸ��� �ǹ���
-- �ڸ����� �����̸� �Ҽ��� ���� ���� �ڸ��� �ǹ���.

SELECT ROUND(125.315) FROM DUAL; 
SELECT ROUND(125.315, 0) FROM DUAL;
SELECT ROUND(125.315, 1) FROM DUAL;
SELECT ROUND(125.315, -1) FROM DUAL;
SELECT ROUND(125.315, 3) FROM DUAL; 
SELECT ROUND(-125.315, 2) FROM DUAL;

-- ���� �������� ���, �̸�, �޿�, ���ʽ�����Ʈ, ���ʽ�����Ʈ�� ����� ���� ��ȸ
-- ������ ��Ī : 1��޿�
-- ������ õ�������� �ݿø���

SELECT EMP_ID, EMP_NAME, SALARY, BONUS_PCT, ROUND((SALARY+(SALARY * NVL(BONUS_PCT, 0))) * 12, -4) "1��޿�"
FROM EMPLOYEE;

-- TRUNC (���ڰ� | ���ڰ� ��ϵ� �÷��� | ����, ���� �ڸ���)
-- �ݿø� ����
SELECT TRUNC(125.315), TRUNC(125.315, 0), TRUNC(125.315, 1),
TRUNC(125.315, -1), TRUNC(125.315, 3), TRUNC(-125.315, -3)
FROM DUAL; 

SELECT TRUNC(125.315) FROM DUAL; --125
SELECT TRUNC(125.315, 0) FROM DUAL;-- 125
SELECT TRUNC(125.315, 1) FROM DUAL; --125.3
SELECT TRUNC(125.315, -1) FROM DUAL; --120
SELECT TRUNC(125.315, 3) FROM DUAL; --125.315
SELECT TRUNC(-125.315, -3) FROM DUAL; 

-- ������������ �޿��� ����� ����
-- 10�ڸ������� ������
SELECT TRUNC(AVG(SALARY), -2), FLOOR(AVG(SALARY))
FROM EMPLOYEE;

-- FLOOR(���ڰ� | ���ڰ� ��ϵ� �÷��� | ����) : �Ҽ��� �Ʒ��� ������ �Լ� (���� ����� �Լ�)
SELECT ROUND(123.5), TRUNC(123.5), FLOOR(123.5)
FROM DUAL;

-- ASB(���ڰ� | ���ڰ� ��ϵ� �÷��� | ����) : ���밪(��� ���� ���) ���ϴ� �Լ�
-- ������ ����� �ٲ�
SELECT ABS(123), ABS(-123)
FROM DUAL;

-- �Ի��� - ���ó�¥, ���ó�¥ - �Ի��� = �ѱٹ��ϼ� (��Ī)
-- �ٹ��ϼ��� ������ ó��, ��� ����� ó����

SELECT ABS(FLOOR(HIRE_DATE-SYSDATE)) �ѱٹ��ϼ�, ABS(FLOOR(SYSDATE-HIRE_DATE)) �ѱٹ����
FROM EMPLOYEE;

-- MOD(������, ������) : �������� �������� ���ϴ� �Լ�
SELECT FLOOR(25 / 7), MOD(25, 7) FROM DUAL;

-- ����� Ȧ���� ���� ���� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE MOD(EMP_ID, 2) = 1;

-- �ֹι�ȣ�� ���� �������� ���� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE MOD(SUBSTR(EMP_NO, 8, 1), 2) = 0;