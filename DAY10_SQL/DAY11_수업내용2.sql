GRANT CREATE SYNONYM TO student;

-- ���� ���Ǿ� ����� �׽�Ʈ
DROP TABLE SYSTBL;

CREATE TABLE SYSTBL (
    SNAME VARCHAR2(20)
);

INSERT INTO SYSTBL VALUES ('ȫ�浿');
INSERT INTO SYSTBL VALUES ('����ġ');

SELECT * FROM SYSTBL;

GRANT SELECT ON SYSTBL TO STUDENT;


-- ����� ���� ����� ����
CREATE USER user01 IDENTIFIED BY pass01;

CONN user01/pass01;
-- ���� �߻��� : ����ڿ� �����ͺ��̽� ���� ������ �ο����� �ʾұ� ������

-- ���� �ο��ϱ� : GRANT ��ɾ� �����

/*
    ����
    GRANKT �������� TO ����ھ��̵�
    [WITH ADMIN OPTION];
    
    ����ھ��̵� ��ſ� PUBLIC �� ����ϸ� ��� ����ڿ��� �ش� �ý��۱����� �ο��ϰ� ��
*/

GRANT CREATE SESSION TO user01;
SHOW USER;
SELECT * FROM USER_ROLL_PRIVS;