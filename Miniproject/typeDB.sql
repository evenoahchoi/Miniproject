/*
  create sequence seq_type_idx
 
 --���̺� ����
 create table type
 (
 	type_idx int not null,
 	type varchar2(100) not null
 )
 
 --�⺻Ű
 alter table type
 	add constraint pk_type_idx primary key(type_idx);

 --Sample data
 insert into type values(seq_type_idx.nextVal,'���뿹��');
 insert into type values(seq_type_idx.nextVal,'��������');
 insert into type values(seq_type_idx.nextVal,'���⿹��');

 commit
 

select * from type


*/