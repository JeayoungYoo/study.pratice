-- 1. 2001 �⿡ ���� �� ���а� �л��� �� ������ �л����� ��ȸ�Ͻÿ�. ���а� �ڵ�� TB_DEPARTMENT ����
-- �˻�����. (Join �� ������� �ʴ´�.)
SELECT COUNT(*)
FROM TB_DEPARTMENT
WHERE DEPARTMENT_NAME LIKE '���а�'
AND DEPARTMENT_NO IN (SELECT DEPARTMENT_NO
                         FROM TB_STUDENT
                         WHERE SUBSTR(STUDENT_NO, 1, 3) LIKE 'A01');
