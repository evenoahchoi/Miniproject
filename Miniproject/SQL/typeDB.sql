/*
  create sequence seq_type_idx
 
 --테이블 생성
 create table type
 (
 	type_idx int not null,
 	type varchar2(100) not null
 )
 
 --기본키
 alter table type
 	add constraint pk_type_idx primary key(type_idx);

 --Sample data
 insert into type values(seq_type_idx.nextVal,'보통예금');
 insert into type values(seq_type_idx.nextVal,'정기적금');
 insert into type values(seq_type_idx.nextVal,'정기예금');

 commit
 

select * from type


*/