-- member.sql
create table member(
	ID VARCHAR2(15),
	PASSWD VARCHAR2(15) NOT NULL,
	NAME VARCHAR2(20) NOT NULL,
	EMAIL VARCHAR2(30),
	GENDER CHAR(1) CHECK (GENDER IN ('M', 'F')),
	AGE NUMBER,
	PHONE CHAR(13),
	ADDRESS VARCHAR2(50),
	ENROLL_DATE DATE DEFAULT SYSDATE,
	
	CONSTRAINT PK_MEMBER PRIMARY KEY (ID)
);

INSERT INTO MEMBER VALUES
('user11', 'pass11', '홍길동', 'hong11*7@iei.or.kr', 'M', 25, '010-1234-5678', '서울시 강남구 역삼동 123'
, TO_DATE('2012-01-23', 'RRRR-MM-DD'));

INSERT INTO MEMBER values
('admin', 'admin', '관리자', 'admin@iei.or.kr', 'M', 33, '010-7777-8888', '경기도 수원시 수원동 77'
, TO_DATE('2010-01-01', 'RRRR-MM-DD'));

INSERT INTO MEMBER values
('user21', 'pass21', '김길동', 'dong11*7@iei.or.kr', 'F', 30, '010-5556-1234', '서울시 동작구 역삼동 123'
, TO_DATE('2014-01-23', 'RRRR-MM-DD'));

INSERT INTO MEMBER values
('user22', 'pass22', '박명우', 'park22@iei.or.kr', 'M', 33, '010-2424-0909', '서울시 강남구 청담동 22'
, TO_DATE('2012-07-15', 'RRRR-MM-DD'));

COMMIT;