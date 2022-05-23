/*
 --테이블 생성
 create table account
 (
 	acc_no varchar2(100) not null,
 	member_ID varchar2(100) not null, 
	acc_s date not null,  
	acc_e date,
	type_idx int not null
 )
 
 --기본키
 alter table account
 	add constraint acc_no primary key(acc_no);
 	
alter table account
	add constraint fk_account_member_ID foreign key(member_ID) 
	                                 references member(member_ID)	
 	
alter table account
	add constraint fk_account_type_idx foreign key(type_idx) 
	                                 references type(type_idx)
	                                 
	                                 



 --Sample data
 insert into account values('001-001-001','Ilgildong','2020-01-01',null,1);
 insert into account values('002-002-002','Egildong','2020-02-02',null,1);
 insert into account values('003-003-003','Samgildong','2020-03-03',null,1);
 insert into account values('004-004-004','Sagildong','2020-04-04','2025-04-04',3);
  
 commit
  
drop table account
select * from account
select * from member
select * from type
select * from list


update account set acc_s='2022-12-12',acc_e='2022-12-12',type_idx=1 where acc_no='001-001-001'


*/