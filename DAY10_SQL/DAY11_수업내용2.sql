GRANT CREATE SYNONYM TO student;

-- 공개 동의어 만들기 테스트
DROP TABLE SYSTBL;

CREATE TABLE SYSTBL (
    SNAME VARCHAR2(20)
);

INSERT INTO SYSTBL VALUES ('홍길동');
INSERT INTO SYSTBL VALUES ('전우치');

SELECT * FROM SYSTBL;

GRANT SELECT ON SYSTBL TO STUDENT;


-- 사용자 계정 만들기 연습
CREATE USER user01 IDENTIFIED BY pass01;

CONN user01/pass01;
-- 에러 발생함 : 사용자에 데이터베이스 접속 권한을 부여하지 않았기 때문에

-- 권한 부여하기 : GRANT 명령어 사용함

/*
    형식
    GRANKT 권한종류 TO 사용자아이디
    [WITH ADMIN OPTION];
    
    사용자아이디 대신에 PUBLIC 을 기술하면 모든 사용자에게 해당 시스템권한을 부여하게 됨
*/

GRANT CREATE SESSION TO user01;
SHOW USER;
SELECT * FROM USER_ROLL_PRIVS;