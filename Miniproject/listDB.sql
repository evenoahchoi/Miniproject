/*
  create sequence seq_list_idx
 
 --테이블 생성
 create table list
 (
 	list_idx int not null,
 	list_in int ,
 	list_out int ,
 	list_jan int not null,
 	list_date date not null,
 	acc_no varchar2(100) not null
 )
 
 --기본키
 alter table list
 	add constraint pk_list_idx primary key(list_idx);

alter table list
	add constraint fk_list_acc_no foreign key(acc_no) 
	                                 references account(acc_no)


 --Sample data
 insert into list values(seq_type_idx.nextVal,100,null,100,'2022-05-20','001-001-001');

 commit
 
drop table list
select * from list


*/