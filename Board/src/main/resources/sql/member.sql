create table talk_board_member(
user_id varchar2(30) primary key,
user_pwd varchar2(100) not null,
user_name varchar2(20)not null,
user_email varchar2(30) not null,
user_type number default 1 --관리자 0, 회원1
);