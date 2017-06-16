-- DAY14 수업내용

-- 


SET SERVEROUTPUT ON;

-- 변수 : 사번저장용(VEMPNO), 이름저장용(VENAME)
-- 한선기 직원의 사번과 이름을 조회해서 변수에 저장하고, 변수 값 출력 처리

DECLARE
    VEMPNO CHAR(3);
    VENAME VARCHAR(20);
BEGIN
    SELECT EMP_ID, EMP_NAME
    INTO VEMPNO, VENAME
    FROM EMP01
    WHERE EMP_NAME = '한선기';
    SYS.DBMS_OUTPUT.PUT_LINE('사번    이름');
    SYS.DBMS_OUTPUT.PUT_LINE('---------------');
    SYS.DBMS_OUTPUT.PUT_LINE(VEMPNO || '    ' || VENAME);
END;
/


-- 변수 선언과 값 대입
-- 변수명 := 값;
DECLARE
    EMPNO NUMBER;  -- 일반(스칼라) 변수
    ENAME VARCHAR2(10);
    EPRICE CONSTANT NUMBER := 25000;  -- 상수 : 값 변경 못 함
BEGIN
    EMPNO := 1001;
    ENAME := '김사랑';
    -- EPRICE := 50000;   상수는값 변경못한다
    DBMS_OUTPUT.PUT_LINE('사번         이름           가격');
    DBMS_OUTPUT.PUT_LINE('---------------------------------');
    DBMS_OUTPUT.PUT_LINE(EMPNO || '         ' || ENAME || '         ' || EPRICE);
END;
/

-- 참조(REFERENCE) 변수
-- 변수명 테이블명.컬럼명%TYPE;
-- 다른 테이블이 컬럼과 같은 자료형으로 변수 선언한다는 뜻임

DECLARE
    VEMPNO EMPLOYEE.EMP_ID%TYPE;
    VENAME EMPLOYEE.EMP_NAME%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME
    INTO VEMPNO, VENAME
    FROM EMP01
    WHERE EMP_NAME = '한선기';
    SYS.DBMS_OUTPUT.PUT_LINE('사번    이름');
    SYS.DBMS_OUTPUT.PUT_LINE('---------------');
    SYS.DBMS_OUTPUT.PUT_LINE(VEMPNO || '    ' || VENAME);
END;
/

-- 사번을 입력받아, 해당 직언의 정보를 출력함
-- '&변수명'   :  실행시 값 입력받을 변수를 표시한 것임

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

-- 등급을 입력받아('A', 'B', 그외 다른값) 결과를 출력

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