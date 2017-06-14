
-- 1. 2001 �⿡ ���� �� ���а� �л��� �� ������ �л����� ��ȸ�Ͻÿ�.
-- ���а� �ڵ�� TB_DEPARTMENT ���� �˻��Ѵ�. (Join �� ������� �ʴ´�.)
SELECT COUNT(*) �л���1
FROM TB_STUDENT
WHERE ENTRANCE_DATE BETWEEN '01/01/01' AND '01/12/31'
      AND DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                           FROM TB_DEPARTMENT
                           WHERE DEPARTMENT_NAME LIKE '���а�');
                           
-- 2. �迭�� �����С��� �а� �� ���������� 20�� �̻�, 30�� ������ �а��� �迭, �а��̸�, ������ ��ȸ�Ͻÿ�.
-- �� �а��̸��� �������� �������� �����Ͻÿ�.��
SELECT CATEGORY �迭, DEPARTMENT_NAME �а��̸�, CAPACITY ����
FROM TB_DEPARTMENT
WHERE CATEGORY LIKE '����'
      AND CAPACITY BETWEEN 20 AND 30
ORDER BY DEPARTMENT_NAME ASC;

-- 3. ���С��ڰ� �� �迭�� �Ҽ� �а��� �� �� �ִ��� �迭, �а����� ����Ͻÿ�.
-- �� �а����� ���� ������ �����Ͻÿ�
SELECT CATEGORY �迭, COUNT(DEPARTMENT_NAME) �а���
FROM TB_DEPARTMENT
WHERE CATEGORY LIKE '%��%'
GROUP BY CATEGORY
ORDER BY �а��� DESC;

-- 4. ��������а��� �����̸�, ����⵵, �ּҸ� ��ȸ�ϰ� ���̰� ���� ������ �����Ͻÿ�.
-- ������а� �ڵ�� TB_DEPARTMENT ���� �˻�����. (Join �� ������� �ʴ´�.) 
SELECT PROFESSOR_NAME �����̸�, SUBSTR(PROFESSOR_SSN, 1, 2) ����⵵, PROFESSOR_ADDRESS �ּ�
FROM TB_PROFESSOR
WHERE DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                       FROM TB_DEPARTMENT
                       WHERE DEPARTMENT_NAME LIKE '������а�')
ORDER BY 2;

-- 5. ������а� �л� �� ���￡ �����ϴ� �л��� �а���ȣ, �л��̸�, ���п��θ� ��ȸ�ϰ� 
-- �л��̸����� �������� �����Ͻÿ�. �� ���п��δ� ���� ��Y���̸� �����С����� ��N���̸� ���������� �������.
-- ������а� �ڵ�� TB_DEPARTMENT ���� ã�´�. (Join �� ������� �ʴ´�)
SELECT DEPARTMENT_NO �а���ȣ, STUDENT_NAME �л��̸�, CASE ABSENCE_YN WHEN 'Y' THEN '����'
                                                                    ELSE '����' END AS ���п���
FROM TB_STUDENT
WHERE STUDENT_ADDRESS LIKE '����%'
      AND DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                           FROM TB_DEPARTMENT
                           WHERE DEPARTMENT_NAME LIKE '������а�');

-- 6. 80����� ���л� �� ���� ���衯���� �л��� �ֹι�ȣ, �л��̸��� ��ȸ�Ͻÿ�. 
-- �� �л��̸����� �������� �����Ͻÿ�.      
SELECT '['||SUBSTR(STUDENT_SSN,1,8)||'******]' �ֹι�ȣ, STUDENT_NAME �л��̸�
FROM TB_STUDENT
WHERE STUDENT_NAME LIKE '��%'
      AND SUBSTR(STUDENT_SSN, 8, 1) LIKE '2';
      
-- 7. �迭�� ����ü�ɡ��� �а��� ������ �������� 40 �� �̻��̸� ���밭�ǽǡ�, 30 �� �̻��̸� ���߰��ǽǡ�,
-- 30�� �̸��̸� ���Ұ��ǽǡ��� �������. ��, ������ ���� ������ ���� ����.
SELECT DEPARTMENT_NAME �а��̸�, CAPACITY ����, CASE WHEN CAPACITY >= 40 THEN '�밭�ǽ�'
                                                   WHEN CAPACITY >= 30 THEN '�߰��ǽ�'
                                                   ELSE '�Ұ��ǽ�' END AS ���ǽ�ũ��
FROM TB_DEPARTMENT
WHERE CATEGORY LIKE '��ü��'
ORDER BY 2 DESC;


-- 8. �ּ����� ����⡯ �Ǵ� ����õ���� �л� �� 1900��뿡 ���� �� �л����� ��ȸ �ϰ��� �Ѵ�.
-- ���ó�¥�� ���� ���� ���� �� �Ⱓ�� ����Ͽ� ���� �� �Ⱓ�� ������ ������ ���� �Ѵ�.
-- (�� ���� �� �Ⱓ�� ������ ��(Ҵ)�� �� �ϰ�, �Ҽ��� ���� �ڸ��� ������. 
-- ���� ���� �� �Ⱓ�� ���� ��� �̸����� �������� ��������.)
SELECT STUDENT_NAME �л��̸�, TO_CHAR(ENTRANCE_DATE, 'YY"��"MM"��"DD"��"') ��������, TRUNC(MONTHS_BETWEEN(SYSDATE, ENTRANCE_DATE)/12, 0) "�����ıⰣ(��)"
FROM TB_STUDENT
WHERE (ENTRANCE_DATE < '2000/01/01' AND SUBSTR(STUDENT_NO, 1, 1) <> 'A')
      AND (STUDENT_ADDRESS LIKE '%��õ%' OR STUDENT_ADDRESS LIKE '%���%')
ORDER BY 2, 1;


-- 9. �а��� ���￡ �����ϴ� ���� �� ���̰� ���� ���� ������ ���̸� ��ȸ�Ѵ�.
-- ��, ���̰� ���� ������ ���� �Ѵ�. 
SELECT DEPARTMENT_NO �а���ȣ, FLOOR(MONTHS_BETWEEN(SYSDATE, TO_DATE(SUBSTR(PROFESSOR_SSN, 1, 6), 'RRMMDD'))/12) ����
FROM (SELECT *
      FROM TB_PROFESSOR
      WHERE PROFESSOR_ADDRESS LIKE '����%'
      ORDER BY PROFESSOR_SSN DESC
      )
WHERE ROWNUM = 1;

-- 10. 2005��1��1�Ϻ��� 2006��12��31�ϱ����� �Ⱓ�� ������ �л� �� �ּҰ� ��ϵ��� ���� ���л��� 
-- �а���ȣ, �л��̸�, ����������ȣ, ���г⵵�� ��ȸ�Ͻÿ�. ���г⵵�� �������� �������� �����Ѵ�.
SELECT DEPARTMENT_NO �а���ȣ, STUDENT_NAME �л��̸�, COACH_PROFESSOR_NO ����������ȣ, '20'||SUBSTR(ENTRANCE_DATE, 1, 2)||'��' ���г⵵
FROM TB_STUDENT
WHERE ENTRANCE_DATE BETWEEN '05/01/01' AND '06/12/31'
      AND STUDENT_ADDRESS IS NULL
      AND SUBSTR(STUDENT_SSN, 8, 1) LIKE '1'
ORDER BY 4;
