/*


select 
	m.member_ID as m_member_ID,m.m_name,m.m_pwd,m.m_mail,m.m_tel,
	a.acc_no as a_acc_no,a.member_ID as a_member_ID,a.acc_s,a.acc_e,a.type_idx as a_type_idx,
	t.type_idx as t_type_idx,t.type,
	l.list_idx,l.list_in,l.list_out,l.list_jan,l.list_date,l.acc_no as l_acc_no
from member m
full outer join account a
	on m.member_ID = a.member_ID
full outer join type t
	on a.type_idx = t.type_idx
full outer join list l
	on l.acc_no = a.acc_no
order by m.member_ID

select a_acc_no,list_in,list_out,list_jan,list_date from full_view where a_acc_no='001-001-001'
select a_acc_no,type,acc_s,acc_e,list_jan from full_view where m_member_ID='123'

create or replace view full_view
as
select 
	m.member_ID as m_member_ID,m.m_name,m.m_pwd,m.m_mail,m.m_tel,
	a.acc_no as a_acc_no,a.member_ID as a_member_ID,a.acc_s,a.acc_e,a.type_idx as a_type_idx,
	t.type_idx as t_type_idx,t.type,
	l.list_idx,l.list_in,l.list_out,l.list_jan,l.list_date,l.acc_no as l_acc_no
from member m
full outer join account a
	on m.member_ID = a.member_ID
full outer join type t
	on a.type_idx = t.type_idx
full outer join list l
	on l.acc_no = a.acc_no
order by m.member_ID

select * from full_view
*/