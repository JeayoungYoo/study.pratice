--1. 2001 �⿡ ���� �� ���а� �л��� �� ������ �л����� ��ȸ�Ͻÿ�. 
--���а� �ڵ�� TB_DEPARTMENT ���� �˻��Ѵ�. (Join �� ������� �ʴ´�.)

SELECT 	DEPARTMENT_NO 
FROM 	TB_DEPARTMENT
WHERE 	DEPARTMENT_NAME = '���а�';

SELECT 	COUNT(*) �л��� 
FROM 	TB_STUDENT
WHERE 	DEPARTMENT_NO = '003' 
AND ENTRANCE_DATE LIKE '01%';

--2. �迭�� �����С��� �а� �� ���������� 20 �� �̻�, 30 �� ������ �а��� 
--   �迭, �а��̸�, ������ ��ȸ�Ͻÿ�.
--�� �а��̸��� �������� �������� �����Ͻÿ�.��

SELECT 	CATEGORY �迭, DEPARTMENT_NAME �а��̸�, CAPACITY ����
FROM 	TB_DEPARTMENT
WHERE 	CAPACITY BETWEEN 20 AND 30 
AND CATEGORY = '����';

--3. ���С��ڰ� �� �迭�� �Ҽ� �а��� �� �� �ִ��� �迭, �а����� ����Ͻÿ�. 
--�� �а����� ���� ������ �����Ͻÿ�.
SELECT	CATEGORY �迭, COUNT(*) AS �а���
FROM 	TB_DEPARTMENT 
WHERE 	CATEGORY LIKE '%��%'
GROUP BY CATEGORY
ORDER BY 2 DESC;

--4. ��������а��� �����̸�, ����⵵, �ּҸ� ��ȸ�ϰ� ���̰� ���� ������ �����Ͻÿ�. 
--������а� �ڵ�� TB_DEPARTMENT ���� �˻��Ѵ�. (Join �� ������� �ʴ´�.)
SELECT 	DEPARTMENT_NO 
FROM 	TB_DEPARTMENT
WHERE 	DEPARTMENT_NAME = '������а�';

SELECT PROFESSOR_NAME �����̸�, 
          SUBSTR(PROFESSOR_SSN, 1, 2) ����⵵, 
          PROFESSOR_ADDRESS �ּ� 
FROM	TB_PROFESSOR 
WHERE	DEPARTMENT_NO = '002'
ORDER BY 2;

--5. ������а� �л� �� ���￡ �����ϴ� �л��� 
--�а���ȣ, �л��̸�, ���п��θ� ��ȸ�ϰ� �л��̸����� �������� �����Ͻÿ�. 
--�� ���п��δ� ���� ��Y���̸� �����С����� ��N���̸� ���������� ����Ѵ�. 
--������а� �ڵ�� TB_DEPARTMENT ���� ã�´�. (Join �� ������� �ʴ´�)
SELECT 	DEPARTMENT_NO 
FROM 	TB_DEPARTMENT
WHERE 	DEPARTMENT_NAME = '������а�';

SELECT DEPARTMENT_NO �а���ȣ, STUDENT_NAME �л��̸�, 
          DECODE(ABSENCE_YN, 'Y', '����', 'N', '����') ���п���
FROM 	TB_STUDENT
WHERE	DEPARTMENT_NO = '001'
AND STUDENT_ADDRESS LIKE '%����%'
ORDER BY 2;


--6. 80 ����� ���л� �� ���� ���衯���� �л��� �ֹι�ȣ, �л��̸��� ��ȸ�Ͻÿ�. 
--�� �л��̸����� �������� �����Ͻÿ�.
SELECT '[' || SUBSTR(STUDENT_SSN, 1, 8) || '******]' AS "[�ֹι�ȣ]",
          STUDENT_NAME �̸�
FROM TB_STUDENT
WHERE STUDENT_SSN LIKE '80%'
AND SUBSTR(STUDENT_SSN, 8, 1) = '2'
AND STUDENT_NAME LIKE '��%'
ORDER BY 2;


--7. �迭�� ����ü�ɡ��� �а��� ������ �������� 
--40 �� �̻��̸� ���밭�ǽǡ�, 30 �� �̻��̸� ���߰��ǽǡ�, 30 ��̸��̸� ���Ұ��ǽǡ��� ����Ѵ�. 
--��, ������ ���� ������ ���� �Ѵ�.
SELECT	DEPARTMENT_NAME �а��̸�, CAPACITY ��������, 
            CASE WHEN CAPACITY >= 40 THEN '�밭�ǽ�'
                    WHEN CAPACITY >=30 THEN '�߰��ǽ�'
                    ELSE '�Ұ��ǽ�' 
            END AS ���ǽ�ũ��
FROM 	TB_DEPARTMENT
WHERE	CATEGORY = '��ü��'
ORDER BY 2 DESC, 1;

--8. �ּ����� ����⡯ �Ǵ� ����õ���� �л� �� 1900��뿡 ���� �� �л����� ��ȸ �ϰ��� �Ѵ�. 
--���ó�¥�� �������� ���� �� �Ⱓ�� ����Ͽ� ���� �� �Ⱓ�� ������ ������ ���� �Ѵ�. 
--(�� ���� �� �Ⱓ�� ������ ��(Ҵ)���� �ϰ�, �Ҽ��� ���� �ڸ��� ������. 
--���� ���� �� �Ⱓ�� ���� ��� �̸����� �������� �����Ѵ�.)
SELECT STUDENT_NAME �л��̸�,
          TO_CHAR(ENTRANCE_DATE, 'YY"��" MM"��" DD"��"') ��������,
          TRUNC((MONTHS_BETWEEN(SYSDATE, ENTRANCE_DATE) / 12), 0) || '��' AS "�����ıⰣ(��)"
FROM 	TB_STUDENT
WHERE 	(STUDENT_ADDRESS LIKE '%���%' OR STUDENT_ADDRESS LIKE '%��õ%') 
AND ENTRANCE_DATE LIKE '9%'
ORDER BY 3 DESC, 1;

--9. �а��� ���￡ �����ϴ� ���� �� ���̰� ���� ���� ������ ���̸� ��ȸ�Ѵ�. 
--��, ���̰� ���� ������ �����Ѵ�
SELECT 	DEPARTMENT_NO �а���ȣ, 
        MIN(TO_NUMBER(TO_CHAR(SYSDATE,'YYYY')) - 
                (TO_NUMBER(SUBSTR(PROFESSOR_SSN,1,2)) + 1900)) ����
FROM 	TB_PROFESSOR
WHERE 	PROFESSOR_ADDRESS LIKE '%����%'
GROUP BY DEPARTMENT_NO 
ORDER BY 2;

--10. 2005��1��1�Ϻ��� 2006��12��31�ϱ����� �Ⱓ�� ������ �л� �� 
--�ּҰ� ��ϵ��� ���� ���л��� �а���ȣ, �л��̸�, ����������ȣ, ���г⵵�� ��ȸ�Ͻÿ�. 
--���г⵵�� �������� �������� �����Ѵ�.
SELECT 	DEPARTMENT_NO �а���ȣ, STUDENT_NAME �л��̸�, 
            COACH_PROFESSOR_NO ����������ȣ, 
            TO_CHAR(ENTRANCE_DATE, 'YYYY') || '��' AS ���г⵵
FROM 	TB_STUDENT
WHERE 	STUDENT_ADDRESS IS NULL 
AND TO_CHAR(ENTRANCE_DATE, 'YYYY') BETWEEN 2005 AND 2007 
AND SUBSTR(STUDENT_SSN, 8, 1) = 1
ORDER BY 4,2;


