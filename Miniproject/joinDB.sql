/*


select 
	m.member_ID as m_member_ID,m.m_name,m.m_pwd,m.m_mail,m.m_tel,m.m_addr,
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




create or replace view full_view
as
select 
	m.member_ID as m_member_ID,m.m_name,m.m_pwd,m.m_mail,m.m_tel,m.m_addr,
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


*/