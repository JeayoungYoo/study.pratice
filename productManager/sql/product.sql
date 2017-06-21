-- product.sql

-- jdbc ���������� ��ũ��Ʈ ����
CREATE TABLE PRODUCT (
  product_id varchar2(20) primary key,
  p_name varchar2(30) not null,
  price number not null,
  description varchar2(100)
);

insert into product
values ('nb_ss7', '�Ｚ��Ʈ��', 1570000, '�ø���7');

insert into product
values ('nb_ama4', '�ƺϿ���', 1200000, 'xcode 4');

insert into product
values ('pc_ibm',	'ibmPC', 750000, 'windows8');

select * from product;