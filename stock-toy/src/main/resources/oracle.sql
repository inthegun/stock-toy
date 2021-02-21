# 회원 테이블
CREATE table tbl_member(
	MEM_ID varchar2(50) not null,
	MEM_PASSWORD varchar(100) not null,
	MEM_NAME varchar2(100),
	MEM_REGDATE varchar2(50),
	primary key(MEM_ID)
);

select * from tbl_member;  

# 임시 
insert into tbl_member values ('testid','1234','홍홍홍',to_char(sysdate,'yyyy/mm/dd hh24:mi:ss'));

drop table tbl_member;
delete tbl_member;