-- product.sql

-- jdbc 연습문제용 스크립트 파일
CREATE TABLE PRODUCT (
  product_id varchar2(20) primary key,
  p_name varchar2(30) not null,
  price number not null,
  description varchar2(100)
);

insert into product
values ('nb_ss7', '삼성노트북', 1570000, '시리즈7');

insert into product
values ('nb_ama4', '맥북에어', 1200000, 'xcode 4');

insert into product
values ('pc_ibm',	'ibmPC', 750000, 'windows8');

select * from product;