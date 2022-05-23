package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.AccountVo;

public class AccountDao {

	// single-ton : 객체 1개만 생성해서 사용하자
	static AccountDao single = null;

	public static AccountDao getInstance() {

		// 객체가 없으면 만들어라.
		if (single == null)
			single = new AccountDao();

		return single;
	}

	private AccountDao() {
		
	}

	public List<AccountVo> selectList() {

		List<AccountVo> list = new ArrayList<AccountVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from account";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatment얻어오기
			pstmt = conn.prepareStatement(sql);

			//3.ResultSet얻어오기
			rs = pstmt.executeQuery();

			//4.포장(record->Vo->List)
			while (rs.next()) {
				//rs가 가리키는 행(레코드)의 값을 읽어오기
				String acc_no  = rs.getString("acc_no");
				String member_ID   = rs.getString("member_ID");
				String acc_s   = rs.getString("acc_s");
				String acc_e   = rs.getString("acc_e");
				int type_idx   = rs.getInt("type_idx");
				
				
				//Vo로 포장
				AccountVo vo = new AccountVo();
				vo.setMember_ID(member_ID);
				vo.setAcc_no(acc_no);
				vo.setAcc_s(acc_s);
				vo.setAcc_e(acc_e);
				vo.setType_idx(type_idx);

				//list추가
				list.add(vo);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//연결되어있으면 닫아라
				if (rs != null)
					rs.close(); //3번째
				if (pstmt != null)
					pstmt.close(); //2번째
				if (conn != null)
					conn.close(); //1번째
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return list;
	}
	
	
	public int insert(AccountVo vo) {
		// TODO Auto-generated method stub
		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		// 1 2 3 4<-parameter index
		String sql = "insert into account values(?,?,?,?,?)";

		try {
			// 1.Connection얻어오기
			conn = DBService.getInstance().getConnection();

			// 2.PreparedStatement얻어오기
			pstmt = conn.prepareStatement(sql);

			// 3.pstmt parameter 설정
			pstmt.setString(1, vo.getAcc_no());
			pstmt.setString(2, vo.getMember_ID());
			pstmt.setString(3, vo.getAcc_s());
			pstmt.setString(4, vo.getAcc_e());
			pstmt.setInt(5, vo.getType_idx());

			// 4.insert : res<-처리된 행수반환
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return res;

	}
	
	public int delete(String acc_no) {
		// TODO Auto-generated method stub
		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete from account where acc_no=?";

		try {
			// 1.Connection얻어오기
			conn = DBService.getInstance().getConnection();

			// 2.PreparedStatement얻어오기
			pstmt = conn.prepareStatement(sql);

			// 3.pstmt parameter 설정
			pstmt.setString(1, acc_no);

			// 4.DML(insert,update,delete) : res<-처리된 행수반환
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return res;

	}
	
	public int update(AccountVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		//                            
		String sql = "update account set acc_s=?,acc_e=?,type_idx=? where acc_no=?";
		
		try {
			// 1.Connection얻어오기
			conn = DBService.getInstance().getConnection();
			
			// 2.PreparedStatement얻어오기
			pstmt = conn.prepareStatement(sql);
			
			// 3.pstmt parameter 설정
			pstmt.setString(1, vo.getAcc_no());
			pstmt.setString(2, vo.getMember_ID());
			pstmt.setString(3, vo.getAcc_s());
			pstmt.setString(4, vo.getAcc_e());
			pstmt.setInt(5, vo.getType_idx());
			
			// 4.DML(insert,update,delete) : res<-처리된 행수반환
			res = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return res;
		
	}
}

	

