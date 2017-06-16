-- DAY14 ��������

-- 


SET SERVEROUTPUT ON;

-- ���� : ��������(VEMPNO), �̸������(VENAME)
-- �Ѽ��� ������ ����� �̸��� ��ȸ�ؼ� ������ �����ϰ�, ���� �� ��� ó��

DECLARE
    VEMPNO CHAR(3);
    VENAME VARCHAR(20);
BEGIN
    SELECT EMP_ID, EMP_NAME
    INTO VEMPNO, VENAME
    FROM EMP01
    WHERE EMP_NAME = '�Ѽ���';
    SYS.DBMS_OUTPUT.PUT_LINE('���    �̸�');
    SYS.DBMS_OUTPUT.PUT_LINE('---------------');
    SYS.DBMS_OUTPUT.PUT_LINE(VEMPNO || '    ' || VENAME);
END;
/


-- ���� ����� �� ����
-- ������ := ��;
DECLARE
    EMPNO NUMBER;  -- �Ϲ�(��Į��) ����
    ENAME VARCHAR2(10);
    EPRICE CONSTANT NUMBER := 25000;  -- ��� : �� ���� �� ��
BEGIN
    EMPNO := 1001;
    ENAME := '����';
    -- EPRICE := 50000;   ����°� ������Ѵ�
    DBMS_OUTPUT.PUT_LINE('���         �̸�           ����');
    DBMS_OUTPUT.PUT_LINE('---------------------------------');
    DBMS_OUTPUT.PUT_LINE(EMPNO || '         ' || ENAME || '         ' || EPRICE);
END;
/

-- ����(REFERENCE) ����
-- ������ ���̺��.�÷���%TYPE;
-- �ٸ� ���̺��� �÷��� ���� �ڷ������� ���� �����Ѵٴ� ����

DECLARE
    VEMPNO EMPLOYEE.EMP_ID%TYPE;
    VENAME EMPLOYEE.EMP_NAME%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME
    INTO VEMPNO, VENAME
    FROM EMP01
    WHERE EMP_NAME = '�Ѽ���';
    SYS.DBMS_OUTPUT.PUT_LINE('���    �̸�');
    SYS.DBMS_OUTPUT.PUT_LINE('---------------');
    SYS.DBMS_OUTPUT.PUT_LINE(VEMPNO || '    ' || VENAME);
END;
/

-- ����� �Է¹޾�, �ش� ������ ������ �����
-- '&������'   :  ����� �� �Է¹��� ������ ǥ���� ����

DECLARE
    VENO EMPLOYEE.EMP_ID%TYPE;
    VENAME EMPLOYEE.EMP_NAME%TYPE;
    VSAL EMPLOYEE.SALARY%TYPE;
    VHIREDATE EMPLOYEE.HIRE_DATE%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE
    INTO VENO, VENAME, VSAL, VHIREDATE
    FROM EMPLOYEE
    WHERE EMP_ID = '&EID' ;
    
    DBMS_OUTPUT.PUT_LINE(VENO || ', ' || VENAME || ', ' || VSAL || ', ' || VHIREDATE);
    
END;
/

-- ����� �Է¹޾�('A', 'B', �׿� �ٸ���) ����� ���

DECLARE
    GRADE CHAR(1);
BEGIN
    GRADE := '&VAL';
    
    CASE GRADE
        WHEN 'A' THEN
            DBMS_OUTPUT.PUT_LINE('Excellent');
        WHEN 'B' THEN
            DBMS_OUTPUT.PUT_LINE('Good');
        ELSE NULL;
    END CASE;
END;
/