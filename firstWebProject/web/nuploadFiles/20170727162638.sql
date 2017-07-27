-- DAY1 �������� 
/*
  ����Ŭ Express edition ��⿡���� �ѱ� 1���ڰ� 3����Ʈ��.
  LENGTH('���ڿ���') : ���ڼ� ��ȸ�� ���
  LENGTHB('���ڿ���') : ������ ����Ʈ�� ��ȸ�� ����ϴ� �Լ���.
*/

select length('����Ŭ'), LENGTHB('����Ŭ'),
        length('ORACLE'), LENGTHB('ORACLE')
FROM DUAL;  -- DUMMY TABLE(��¥ ���̺��)


-- SYSDATE �Լ� : ���� ��¥ ��ȸ�� ����ϴ� ��¥ �Լ�
select sysdate, sysdate + 1000, sysdate - 100, (sysdate - 50)-sysdate from DUAL;

0select FLOOR((sysdate - to_date('88/11/15', 'RR/MM/DD'))/365) from DUAL;



-- ���� DB�� �������� ��ȸ��
SELECT * FROM V$NLS_PARAMETERS;

-- ****************************************************************************
-- DQL(Data Query Language) : select ��
-- ������ ��ȸ�� ������

select EMP_ID, EMP_NAME, SALARY
from EMPLOYEE;

select *
from EMPLOYEE
where JOB_ID = 'J7'
order by SALARY asc;

select EMP_ID, EMP_NAME, SALARY, HIRE_DATE
from EMPLOYEE
where DEPT_ID = '90'
order by HIRE_DATE asc;

select EMP_NO, EMP_NAME, DEPT_NAME
from EMPLOYEE
join DEPARTMENT using(DEPT_ID)
where DEPT_ID = '90';

select * from EMPLOYEE
where DEPT_ID = '30'; -- RESULT set �� 0���ϼ��� ����.

/*
  SELECT ���� ����
  
  5 SELECT  DISTINCT �÷���, ����, �Լ���(�÷���) AS ��Ī, * 
  1 FROM  ���̺��
  2 WHERE �÷��� �񱳿����� �񱳰�
  3 GROUP BY  �÷���
  4 HAVING  �׷��Լ� �񱳿����� �񱳰�
  6 ORDER BY  �÷��� ���Ĺ��;
*/


-- ���̺��� ��� ������ ��ȸ��
select * from EMPLOYEE;
select * from DEPARTMENT;
select * from JOB;
select * from LOCATION;
select * from COUNTRY;

-- �÷����� �ߺ������� �� ������ ������ ��� : DISTINCT �÷���
select DISTINCT JOB_ID
from EMPLOYEE
order by JOB_ID asc;

select DISTINCT DEPT_ID, JOB_ID
from EMPLOYEE
order by DEPT_ID ASC;

-- ���� ����� ���
-- ��갪�� NULL�̸� ����� NULL��.

SELECT EMP_NAME, SALARY*12, (SALARY+(SALARY*BONUS_PCT))*12
FROM EMPLOYEE;

-- ���ʽ�����Ʈ�� NULL�̸�, ���ʽ�����Ʈ ���ٸ� �ǹ��ϹǷ�
-- ���Ŀ� ���ʽ�����Ʈ�� 0�� �����ϸ� �� ���� : NVL (�÷���, �ٲܰ�) �Լ� �����

SELECT EMP_NAME, SALARY*12 "1��޿�", (SALARY+(SALARY*NVL(BONUS_PCT, 0)))*12 AS �Ѽҵ�

FROM EMPLOYEE;

