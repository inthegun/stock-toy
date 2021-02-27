CREATE TABLE `user` (
  `ID` varchar(100) NOT NULL,
  `PASSWORD` varchar(300) NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `AUTHORITY` varchar(50) DEFAULT 'ROLE_USER' NOT NULL ,
  `ENABLED` number(3) DEFAULT '1',
  PRIMARY KEY (`ID`)
);
# ENABLED 컬럼 : 계정의 활성화 , 비활성화 여부 ( 1: 활성화 , 0: 비활성화 )

# 출처: https://to-dy.tistory.com/85?category=720806 [todyDev]

CREATE TABLE tbl_user(
	ID varchar2(100) not null,
	PASSWORD varchar2(100) not null,
	NAME varchar(45) not null,
	AUTHORITY varchar(50) default 'ROLE_USER' NOT NULL ,
	ENABLED number(1) default 1,
	primary key(ID)
);

select * from user
select * from tbl_user

create table member(
	ID varchar2(100) primary key,
	PASSWORD varchar2(100),
	NAME varchar2(30),
	ROLE varchar2(12),
	ENABLED BOOLEAN
);

create table member(
	ID varchar2(100) primary key,
	PASSWORD varchar2(100),
	NAME varchar2(30),
	ROLE varchar2(12),
	ENABLED char(1) CONSTRAINT boolean_check CHECK(ENABLED = '0' OR ENABLED ='1')
);

drop table member;

insert into member values('member','member','회원','ROLE_USER',1);
insert into member values('admin','admin','어드민','ROLE_ADMIN',1);

select * from member;

insert into tbl_user(id,password,name) values('test','1234','testname');

# 관리자 
alter user [유저명] default tablespace [테이블스페이스] quota unlimited on [테이블스페이스];
ex) alter user myuser default tablespace users quota unlimited on users;

alter user stock default tablespace users quota unlimited on uesrs;

출처: https://dololak.tistory.com/756 [코끼리를 냉장고에 넣는 방법]

drop table user2
drop table tbl_user;