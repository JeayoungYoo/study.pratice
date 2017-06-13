-- DAY11 수업내용
-- DDL 기타 객체들

-- 시퀀스(SEQUENCE)
-- 자동 번호(정수) 발생기
-- 순차적으로 정수 값을 자동으로 생성하는 객체

-- 시퀀스 만들기 1
CREATE SEQUENCE SEQ_EMPID
START WITH 300  -- 초기값 : 300부터 시작함
INCREMENT BY 5  -- 증가값 : 5씩 증가
MAXVALUE 310    -- 최대값 : 310까지 생성 후 더 이상 값 발생 안 함
NOCYCLE         -- 310까지 생성 후 더 이상 값 발생 안함
NOCACHE;        -- 미리 메모리에 생성하지 않음

-- 시퀀스.NEXTVAL 사용해서 값 바생시킴

SELECT SEQ_EMPID.NEXTVAL FROM DUAL;
-- MAXVALUE 에 도달하면, NOCYCLE 이기 때문에 4회 사용시 에러 발생 확인

-- 데이터 딕셔너리에 저장됨 : USER_SEQUENCES
DESC USER_SEQUENCES;

SELECT SEQUENCE_NAME, CACHE_SIZE, LAST_NUMBER
FROM USER_SEQUENCES
WHERE SEQUENCE_NAME IN ('SEQ_EMPID', 'SEQ2_EMPID');
-- LAST_NUMBER 값은
-- NOCACHE 이면, 새로 반환될 값
-- CACHE 사용이면, CACHE 로 생성된 이후 시퀀스값
--        (메모리에 생성된 시퀀스도 사용된 것으로 간주됨)

/*
    사용형식
    CREATE SEQUENCE 시퀀스이름
    [START WITH 시작값]    -- 생략되면 기본값은 1임
    [INCREMENT BY 증가량]      -- 정수 사용함, 생략되면 기본값은 1임
    [MAXVALUE N | NOMAXVALUE]      -- 오름차순 진행시 사용함. 마지막 값 지정
        -- NOMAXVALUE 지정하면, 값은 오름차순일 때는 10^27까지 발생됨
        -- 내림차순일 때는 -1까지 생성됨
        
    [MINVALUE N | NOMINVALUE]      -- 내림차순 진행시 사용함. 최소값 지정
        -- 오름차순일 때는 1, 내림차순일때는 -10^26
    [CYCLE | NOCYCLE]   -- 최대/최소값 도달 후 반복여부 결정, 순환시 시작값은 무조건 1임
    [CACHE 갯수 | NOCACHE]    -- 메모리에 생성해 둘 값의 갯수 지정, 최소값 2개임, 기본값 20임
*/

CREATE SEQUENCE SEQ2_EMPID
START WITH 5
INCREMENT BY 5
MAXVALUE 15
CYCLE
NOCACHE;

SELECT SEQ2_EMPID.NEXTVAL FROM DUAL;
-- 4회 사용부터 1, 6, 11 이 반복적으로 생성됨

-- 시퀀스 사용방법
-- NEXTVAL 속성 : 새로운 시퀀스 값 반환
-- 시퀀스이름, NEXTVAL로 사용함

-- CURRVAL 속성 : 현재 시퀀스값 확인
-- 시퀀스이름.CURRVAL 로 사용함
-- 처음 NEXTVAL 이 한번 실행된 후 사용할 수 있음

CREATE SEQUENCE SEQ3_EMPID
START WITH 300
INCREMENT BY 5
MAXVALUE 310
NOCYCLE NOCACHE;

SELECT SEQ3_EMPID.CURRVAL FROM DUAL;
-- NEXTVAL 속성 사용전에는 사용할 수 없음

SELECT SEQ3_EMPID.NEXTVAL FROM DUAL;
SELECT SEQ3_EMPID.CURRVAL FROM DUAL;

-- 시퀀스 사용 : 주로 기록값 자동 발생을 위해 사용함
CREATE SEQUENCE SEQID
START WITH 300
INCREMENT BY 1
MAXVALUE 310
NOCYCLE NOCACHE;

INSERT INTO EMPLOYEE (EMP_ID, EMP_NO, EMP_NAME)
VALUES (TO_CHAR(SEQID.NEXTVAL), '850130-1558215', '김영민');

SELECT * FROM EMPLOYEE
WHERE EMP_ID = '300';

INSERT INTO EMPLOYEE (EMP_ID, EMP_NO, EMP_NAME)
VALUES (TO_CHAR(SEQID.NEXTVAL), '840221-1368450', '구준표');

SELECT * FROM EMPLOYEE
WHERE EMP_ID = '301';


CREATE SEQUENCE SEQID2
INCREMENT BY 1
START WITH 300
MAXVALUE 310
NOCYCLE NOCACHE;

SELECT SEQID2.NEXTVAL FROM DUAL;

SELECT SEQID2.NEXTVAL FROM DUAL;

ALTER SEQUENCE SEQID2
INCREMENT BY 5;

SELECT SEQID2.NEXTVAL FROM DUAL;


CREATE SEQUENCE SEQ1
INCREMENT BY 1
START WITH 1
NOCACHE;
SELECT SEQ1.NEXTVAL FROM DUAL;
SELECT SEQ1.CURRVAL FROM DUAL;

CREATE SEQUENCE SEQ2
INCREMENT BY 1
START WITH 1
CACHE 5;
SELECT SEQ2.NEXTVAL FROM DUAL;
SELECT SEQ2.CURRVAL FROM DUAL;

SELECT SEQUENCE_NAME,
CACHE_SIZE,
LAST_NUMBER
FROM USER_SEQUENCES
WHERE SEQUENCE_NAME IN ('SEQ1','SEQ2'); 

--시퀀스 삭제구문
-- DROP SEQUENCE 시퀀스명;
DROP SEQUENCE SEQID2;


-- 인덱스(INDEX) **********************************************************
-- SQL 명령문 (SELECT) 의처리속도를 향상시키기 위해 컬럼에 대해서 생성하는 오라클 객체
-- 인덱스 내부구조는 B* 트리구조 형식으로 구성됨
-- 컬럼에 대해서 인덱스를 생성하면 이에 대한 이진 트리가 생성이 됨
-- 인덱스를 생성하기 위한 시간도 필요하고, 인덱스를 위한 추가 저장공간도 필요함
-- 반드시 좋은것은 아니다
-- 인덱스 생성 후에 DML 작업이 수행되면,인덱스가 사용한 값이 변경되므로
--      이진트리 구조도 같이 변경이 되어야 하므로, DML 작업이 훨씬 무거워지게 됨


-- 장점
-- 검색 속도가 빠름
-- 시스템에 걸리는 부하를 줄여서 시스템 전체 성능을 향상시킴

-- 단점
-- 인덱스를 위한 추가적인 공간이 필요하다
-- 인덱스 생성 시간이 걸림
-- 데이터 변경 작업(INSERT, UPDATE, DELETE)이 자주 발생하는 경우에는 오히려 성능이 저하됨

-- 컬럼값(키워드)과 값이 기록된 위치(ROWID)가 정렬된 상태로 구성됨
-- 키워드를 이용하여 원하는 내용이 기록된 행을 빠르게 찾기위한 목적으로 사용됨


-- 인덱스 생성 구문
-- CREATE [UNIQUE] INDEX 인덱스이름
-- ON 테이블명 (컬럼명, 컬럼명 | 함수식 | 계산식);

-- 인덱스의 종류
-- 1. 고유 인덱스 (UNIQUE INDEX)
-- 2. 비고유 인덱스 (NONUNIQUE INDEX)
-- 3. 단일 인덱스 (SINGLE INDEX)
-- 4. 결합 인덱스 ( COMPOSITE INDEX)
-- 5. 함수 기반 인덱스 (FUNCTION BASED INDEX)

-- 인덱스의 유형
-- 인덱스를 생성하는 대상 컬럼에 따라
-- UNIQUE INDEX, NONUNIQUE INDEX로 구분

-- UNIQUE INDEX
-- UNIQUE INDEX 가 생성된 컬럼에는 중복값 포함될 수 없다.
-- 오라클은 'PRIMARY KEY' 제약조건을 적용하면 자동으로 해당 컬럼에 UNIQUE INDEX를 생성함

-- NONUNIQUE INDEX
-- 빈번하게 사용되는 일반 컬럼을 대상으로 생성함
-- 주로 성능 향상을 위한 목적으로 생성함

-- UNIQUE INDEX 생성
CREATE UNIQUE INDEX IDX_DNM
ON DEPARTMENT (DEPT_NAME);

-- NONUNIQUE INDEX 생성
CREATE INDEX IDX_JID
ON EMPLOYEE (JOB_ID);

-- 인덱스 생성 실습 -----------------------------------------------------

-- 1. EMPLOYEE 테이블의 EMP_NAME

CREATE UNIQUE INDEX IDX_ENM ON EMPLOYEE(EMP_NAME);

-- 2. 다음과 같이 새로운 데이터를 입력해 보고,
-- 오류 원인을 생각해보시오
INSERT INTO EMPLOYEE (EMP_ID, EMP_NO, EMP_NAME)
VALUES ('400', '871120-1243877', '감우섭');
-- EMP_NAME 컬럼에 이미 '감우섭' 이름의 데이터가 존재하기 때문에 중복되는 값은 입력될 수 없음
-- UNIQUE INDEX는 UNIQUE 제약조건의 기능을 수행

CREATE UNIQUE INDEX IDX_DID ON EMPLOYEE(DEPT_ID);


DESC USER_INDEXS;
DESC USER_IND_COLUMNS;

SELECT INDEX_NAME, COLUMN_NAME, INDEX_TYPE, UNIQUENESS;



-- 검색 속도 비교해 보기
-- EMPLOYEE 테이블의 모든 정보를 서브쿼리로 복사한
-- EMPL01, EMPL02 테이블을 만듦
-- EMPL01, EMP_ID 컬럼에 대해 UNIQUE INDEX 만들기
-- 검색속도 비교 조회함 : 두 테이블에 대해 각각 테스트
-- EMP_ID 를 가지고 직원 정보 조회함 : 속도 확인함

CREATE TABLE EMPL01
AS
SELECT * FROM EMPLOYEE;

CREATE TABLE EMPL02
AS
SELECT * FROM EMPLOYEE;

CREATE UNIQUE INDEX IDX_EID
ON EMPL01(EMP_ID);

SELECT * FROM EMPL01
WHERE EMP_ID = '141';

SELECT * FROM EMPL02
WHERE EMP_ID = '141';


-- 결합 인덱스
-- 한 개의 컬럼으로 구성한 인덱스 => 단일 (SINGLE) 인덱스
-- 두 개이상의 컬럼으로 인덱스를 구성하는 것

CREATE TABLE DEPT01
AS
SELECT * FROM DEPARTMENT;

-- 부서번호와 부서명을 결합하여 인덱스 생성하기
CREATE INDEX IDX_DEPT01_COMP
ON DEPT01 (DEPT_ID, DEPT_NAME);

-- 데이터 딕셔너리에서 확인해 봄
SELECT INDEX_NAME, COLUMN_NAME
FROM USER_IND_COLUMNS
WHERE TABLE_NAME = 'DEPT01';

-- 함수 기반 인덱스
-- SELECT 절이나 WHERE 절에 산술계산식이나 함수식이 사용된 경우
-- 계산식은 인덱스 적용을 받지 않는다.
-- 계산식으로 검색하는 경우가 많다면, 수식이나 함수식을 인덱스로 만들 수 있음

CREATE TABLE EMP01
AS
SELECT * FROM EMPLOYEE;

CREATE INDEX IDX_EMP01_SALCALC
ON EMP01 ((SALARY + (SALARY * NVL(BONUS_PCT, 0))*12));

SELECT INDEX_NAME, COLUMN_NAME
FROM USER_IND_COLUMNS
WHERE TABLE_NAME = 'EMP01';


-- 동의어 (SYNONYM) *********************************************************
-- 다른 데이터베이스가 가진 객체에 대한 별명임.
-- 여러 사용자가 테이블을 공유할 경우, 다른 사용자가 테이블에 접근할 때
-- 사용자명.테이블명 으로 표현함
-- 이때 동의어를 적용하면 간단하게 기술할 수 있음

-- 생성방법
-- CREATE SYNONYM 줄임말 FOR 사용자명.객체명;

-- 예 : 테이블명 줄임말 만들기
CREATE SYNONYM EP FOR EMPLOYEE;

SELECT * FROM EP;

-- 예 :
SELECT * FROM SCOTT.EMP;   -- ERROR 권한없음

SELECT * FROM SYS.DUAL;

-- 동의어는 모든 사용자를 대상으로 하는 공개(PUBLIC) 동의어와
-- 개별 사용자를 대상으로 하는 비공개 동의어가 있음.
-- 공개 동의어는 SYSTEM 계정에서 만들어야 함.

/*
    CREATE PUBLIC SYNONYM 동의어이름
    FOR 사용자명.객체명;
*/

-- SYSTEM 이 부여한 SYSTBL 테이블에 SELECT 할 수 있는지 확인
SELECT * FROM SYSTEM.SYSTBL;

CREATE SYNONYM STB
FOR SYSTEM.SYSTBL;

SELECT * FROM STB;

-- 동의어 제거하기
-- DROP SYNONYM 이름;
-- 비공개 동의어 : 해당 사용자 계정에서 삭제함
DROP SYNONYM EP;

SELECT * FROM EP; -- ERROR : 삭제됨

-- 공개 동의어 : SYSTEM 계정에서 제거함
-- DROP PUBLIC SYNONYM 이름;


-- 사용자 관리
-- 사용자 계정과 암호 설정, 권한부여

-- 오라클 데이터베이스 설치하면, 기본적으로 제공되는 계정은 
-- SYS, SYSTEM, HR(잠겨있음), SCOTT(11G 에서는 없음)

-- 보안을 위한 데이터베이스 관리자
--  : 사용자가 데이터베이스의 객체(테이블, 뷰 등)에 대한 특정 권한을 가질 수 있게 함
--    다수의 사용자가 공유하는 데이터베이스 정보에 대한 보한 설정함
--    데이터베이스에 접근하는 사용자마다 서로 다른 권한과 롤을 부여함

-- 권한 : 사용자가 특정 테이블에 접근할 수 있도록 하거나,
--        해당 테이블에 SQL문(SELECT/INSERT/UPDATE/DELETE)을 사용할 수 있도록 제한을 두는 것

/*
    시스템 권한 : 데이터베이스 관리자가 가지고 있는 권한
        CREATE USER (사용자 계정 만들기)
        DROP USER (사용자 계정 삭제)
        DROP ANY TABLE (임의의 테이블 삭제 권한)
        QUERY REWRITE (함수 기반 인덱스 생성)
        BACKUP ANY TABLE (테이블 백업)
        
    시스템 관리자가 사용자에게 부여하는 권한
        CREATE SESSION (데이터베이스에 접속)
        CREATE TABLE (테이블 생성)
        CREATE VIEW (뷰 생성)
        CREATE SEQUENCE (시퀀스 생성)
        CREATE PROCEDURE (프로시져/함수 생성)
    
    객체 권한 : 객체를 조작할 수 있는 권한
*/

-- 사용자 계정 생성
-- 데이터베이스에 접속할 수 있는 아이디와 암호를 만듦
/*
    형식
    CREATE USER 사용자아이디 IDENTIFIED BY 암호;
*/
