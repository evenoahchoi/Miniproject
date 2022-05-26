/*
 --테이블 생성
 create table member
 (
 	member_ID varchar2(100) not null, 
	m_name varchar2(100) not null,  
	m_pwd varchar2(100) not null, 
	m_mail varchar2(100) not null,  
	m_tel varchar2(100) not null
 )
 
 --기본키
 alter table member
 	add constraint member_ID primary key(member_ID);

 --Sample data
 insert into member values('Ilgildong','일길동','1111','111@naver.com','010-111-1111');
 insert into member values('Egildong','이길동','2222','2222@naver.com','010-222-2222');
 insert into member values('Samgildong','삼길동','3333','3333@naver.com','010-333-333');
 insert into member values('Sagildong','사길동','4444','4444@naver.com','010-444-4444');
   
 commit
 
update member set m_addr='서울' where member_ID='Ilgildong';  

select * from member


drop table member cascade constraints




*/