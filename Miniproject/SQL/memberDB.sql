/*
 --���̺� ����
 create table member
 (
 	member_ID varchar2(100) not null, 
	m_name varchar2(100) not null,  
	m_pwd varchar2(100) not null, 
	m_mail varchar2(100) not null,  
	m_tel varchar2(100) not null
 )
 
 --�⺻Ű
 alter table member
 	add constraint member_ID primary key(member_ID);

 --Sample data
 insert into member values('Ilgildong','�ϱ浿','1111','111@naver.com','010-111-1111');
 insert into member values('Egildong','�̱浿','2222','2222@naver.com','010-222-2222');
 insert into member values('Samgildong','��浿','3333','3333@naver.com','010-333-333');
 insert into member values('Sagildong','��浿','4444','4444@naver.com','010-444-4444');
   
 commit
 
update member set m_addr='����' where member_ID='Ilgildong';  

select * from member


drop table member cascade constraints




*/