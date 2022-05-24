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

	//single-ton : 객체 1개만 생성해서 사용하자!
	//스태틱객체는 무조건 하나만 만들어진다.
	static JoinDao single = null;

	//스태틱은 무조건 스태틱으로만
	public static JoinDao getInstance() {

		//객체가 없으면 생성해라 호출된 한번만 객체를 생성
		if (single == null)
			single = new JoinDao();

		return single;
	}

	//외부에서 객체를 생성하지 못하게 막음
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
			//1.connection 얻어오기
			//				 커낵션 객체생성, DB에게 커낵션얻기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement 얻어오기
			pstmt = conn.prepareStatement(sql);

			//3.ResultSet 얻어오기

			rs = pstmt.executeQuery();

			//4.포장(record -> Vo -> list)

			while (rs.next()) {
				//rs가 가리키는 행(레코드)의 값을 읽어온다.

				//Vo로 포장
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
				
				

				//list에 추가

				list.add(vo);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//연결(생성) 되었으면 닫아라.(생성 역순으로 닫기)
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
}
