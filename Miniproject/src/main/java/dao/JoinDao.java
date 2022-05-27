package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.JoinVo;

public class JoinDao {

	//single-ton : ��ü 1���� �����ؼ� �������!
	//����ƽ��ü�� ������ �ϳ��� ���������.
	static JoinDao single = null;

	//����ƽ�� ������ ����ƽ���θ�
	public static JoinDao getInstance() {

		//��ü�� ������ �����ض� ȣ��� �ѹ��� ��ü�� ����
		if (single == null)
			single = new JoinDao();

		return single;
	}

	//�ܺο��� ��ü�� �������� ���ϰ� ����
	private JoinDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	public List<JoinVo> selectList() {

		List<JoinVo> list = new ArrayList<JoinVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from full_view";

		try {
			//1.connection ������
			//				 Ŀ���� ��ü����, DB���� Ŀ���Ǿ��
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement ������
			pstmt = conn.prepareStatement(sql);

			//3.ResultSet ������

			rs = pstmt.executeQuery();

			//4.����(record -> Vo -> list)

			while (rs.next()) {
				//rs�� ����Ű�� ��(���ڵ�)�� ���� �о�´�.

				//Vo�� ����
				JoinVo vo = new JoinVo();
				
				vo.setM_member_ID(rs.getString("m_member_ID"));
				vo.setM_name(rs.getString("m_name"));
				vo.setM_pwd(rs.getString("m_pwd"));
				vo.setM_mail(rs.getString("m_mail"));
				vo.setM_tel(rs.getString("m_tel"));
				vo.setM_addr(rs.getString("m_addr"));
				vo.setA_acc_no(rs.getString("a_acc_no"));
				vo.setA_member_ID(rs.getString("a_member_ID"));
				vo.setA_type_idx(rs.getInt("a_type_idx"));
				vo.setAcc_s(rs.getString("acc_s"));
				vo.setAcc_e(rs.getString("acc_e"));
				vo.setList_idx(rs.getInt("list_idx"));
				vo.setList_in(rs.getInt("list_in"));
				vo.setList_out(rs.getInt("list_out"));
				vo.setList_jan(rs.getInt("list_jan"));
				vo.setList_date(rs.getString("list_date"));
				vo.setL_acc_no(rs.getString("l_acc_no"));
				vo.setT_type_idx(rs.getInt("t_type_idx"));
				vo.setType(rs.getString("type"));
				
				

				//list�� �߰�

				list.add(vo);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//����(����) �Ǿ����� �ݾƶ�.(���� �������� �ݱ�)
				if (rs != null)
					rs.close(); // 3
				if (pstmt != null)
					pstmt.close(); // 2
				if (conn != null)
					conn.close(); // 1

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}
	
	//���¹�ȣ�� ���峻���� ��ȸ�ϴ� ��ü
	public JoinVo list(int idx) {

		JoinVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select a_acc_no,list_in,list_out,list_jan,list_date from full_view where a_acc_no=?";

		try {
			//1.Connection������
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatment������ : SQLó����ü
			pstmt = conn.prepareStatement(sql);

			//3.pstmt����
			
			//4.ResultSet������
			rs = pstmt.executeQuery();

			//5.����(record->Vo)
			if (rs.next()) {
				//rs�� ����Ű�� ��(���ڵ�)�� ���� �о�´�
				//Vo�� ����
				vo = new JoinVo();

				vo.setA_acc_no(rs.getString("a_acc_no"));
				vo.setList_in(Integer.parseInt(rs.getString("list_in")));
				vo.setList_out(Integer.parseInt(rs.getString("list_out")));
				vo.setList_jan(Integer.parseInt(rs.getString("list_jan")));
				vo.setList_date(rs.getString("list_date"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//����(����)�Ǿ����� �ݾƶ�(������������)
				if (rs != null)
					rs.close(); //3 
				if (pstmt != null)
					pstmt.close();//2
				if (conn != null)
					conn.close(); //1
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vo;
	}
	
	//member_ID�� ���� ���峻�� ��� �����ֱ� (����ȭ��)
	public JoinVo member_acc(int idx) {

		JoinVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select a_acc_no,type,acc_s,acc_e,list_jan from full_view where m_member_ID=?";

		try {
			//1.Connection������
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatment������ : SQLó����ü
			pstmt = conn.prepareStatement(sql);

			//3.pstmt����

			//4.ResultSet������
			rs = pstmt.executeQuery();

			//5.����(record->Vo)
			if (rs.next()) {
				//rs�� ����Ű�� ��(���ڵ�)�� ���� �о�´�
				//Vo�� ����
				vo = new JoinVo();

				vo.setA_acc_no(rs.getString("a_acc_no"));
				vo.setType(rs.getString("type"));
				vo.setAcc_s(rs.getString("acc_s"));
				vo.setAcc_e(rs.getString("acc_e"));
				vo.setList_jan(Integer.parseInt(rs.getString("list_jan")));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//����(����)�Ǿ����� �ݾƶ�(������������)
				if (rs != null)
					rs.close(); //3 
				if (pstmt != null)
					pstmt.close();//2
				if (conn != null)
					conn.close(); //1
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vo;
	}
	
}
