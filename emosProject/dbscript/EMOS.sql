-- EMOS계정

-- 기존 테이블이 있으면 삭제
drop table member cascade constraints;
drop table store cascade constraints;
drop table customer cascade constraints;
drop table menu cascade constraints;
drop table order_menu cascade constraints;
drop table reply cascade constraints;


-- 회원정보
create table member(
  user_num number constraint pk_userNum primary key,
  phone varchar2(100) constraint nn_userPhone not null,
  name varchar2(2000),
  password varchar2(100) constraint nn_password not null,
  birth varchar2(100),
  gender varchar2(100),
  type number(1),
  verse number(1)
--  comment on table member is '회원정보';
--  comment on column user_num is '';
);

insert into member values(1, '010-1234-5678', '관리자', 'admin', '940513', '남', 1, 1);
--select * from member;

-- 업체정보저장
create table store(
  store_num number constraint pk_storeNum primary key,
  store_name varchar2(50) constraint nn_storeName not null,
  phone number constraint nn_compPhone not null,
  ceo varchar2(20) constraint nn_ceo not null,
  address varchar2(200) constraint nn_address not null,
  qr varchar2(50),
  map varchar2(50) constraint nn_map not null,
  store_serial varchar2(20) constraint nn_storeSerial not null,
  homepage varchar2(30)
);

-- 주문내역저장
create table customer(
  order_num number constraint pk_orderNum primary key,
  store_num number constraint nn_orderStoreNum not null,
  order_time date constraint nn_orderTime not null,
  order_type number constraint nn_orderType not null,
  order_way date constraint nn_orderWay not null,
  state number constraint nn_state not null,
  user_num number,
  constraint fk_storeNum foreign key(store_num) references store(store_num),
  constraint fk_userNum foreign key(user_num) references member(user_num)
);

-- 모든 상품의 정보 저장
create table menu(
  menu_num number constraint pk_menuNum primary key,
  store_num number constraint nn_storeMenuNum not null,
  menu_name varchar2(30) constraint nn_menuName not null,
  price int constraint nn_menuPrice not null,
  menu_type varchar2(30) constraint nn_menuType not null,
  dpn number,
  constraint fk_storeMenuNum foreign key(store_num) references store(store_num)
);

-- 주문상품 내역 저장
create table order_menu(
  order_menu_num number constraint pk_orderMenuNum primary key,
  order_num number constraint nn_orderNum not null,
  menu_num number constraint nn_menuNum not null,
  ea int constraint nn_ea not null,
  price int constraint nn_orderPrice not null,
  constraint fk_orderNum foreign key(order_num) references customer(order_num),
  constraint fk_menuNum foreign key(menu_num) references menu(menu_num)
);

-- 댓글, 상품명 평점 후기글 내역 저장
create table reply(
  reply_num number constraint pk_replyNum primary key,
  store_num number constraint nn_replyStoreNum not null,
  user_num number constraint nn_userNum not null,
  content varchar2(2000) constraint nn_content not null,
  point number constraint nn_point not null,
  reply_date date constraint nn_replyDate not null,
  constraint fk_replyStoreNum foreign key(store_num) references store(store_num),
  constraint fk_replyUserNum foreign key(user_num) references member(user_num)
);

commit;

