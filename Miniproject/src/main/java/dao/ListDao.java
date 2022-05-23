package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.ListVo;

public class ListDao {

	// single-ton : 객체 1개만 생성해서 사용하자
	static ListDao single = null;

	public static ListDao getInstance() {

		// 객체가 없으면 만들어라.
		if (single == null)
			single = new ListDao();

		return single;
	}

	private ListDao() {
		
	}

	public List<ListVo> selectList() {

		List<ListVo> list = new ArrayList<ListVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from list";

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
				int list_idx  = rs.getInt("list_idx");
				int list_in   = rs.getInt("list_in");
				int list_out   = rs.getInt("list_out");
				int list_jan   = rs.getInt("list_jan");
				String list_date   = rs.getString("list_date");
				String acc_no   = rs.getString("acc_no");
				
				
				//Vo로 포장
				ListVo vo = new ListVo();
				vo.setList_idx(list_idx);
				vo.setAcc_no(acc_no);
				vo.setList_in(list_in);
				vo.setList_out(list_out);
				vo.setList_jan(list_jan);
				vo.setList_date(list_date);

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
	
	
	public int insert(ListVo vo) {
		// TODO Auto-generated method stub
		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		// 1 2 3 4<-parameter index
		String sql = "insert into list values(?,?,?,?,?,?)";

		try {
			// 1.Connection얻어오기
			conn = DBService.getInstance().getConnection();

			// 2.PreparedStatement얻어오기
			pstmt = conn.prepareStatement(sql);

			// 3.pstmt parameter 설정
			pstmt.setInt(1, vo.getList_idx());
			pstmt.setInt(2, vo.getList_in());
			pstmt.setInt(3, vo.getList_out());
			pstmt.setInt(4, vo.getList_jan());
			pstmt.setString(5, vo.getList_date());
			pstmt.setString(6, vo.getAcc_no());

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
	
	public int delete(int list_idx) {
		// TODO Auto-generated method stub
		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete from list where list_idx=?";

		try {
			// 1.Connection얻어오기
			conn = DBService.getInstance().getConnection();

			// 2.PreparedStatement얻어오기
			pstmt = conn.prepareStatement(sql);

			// 3.pstmt parameter 설정
			pstmt.setInt(1, list_idx);

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
	
	public int update(ListVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		//                            
		String sql = "update list set list_in=?,list_out=?,list_jan=?,list_date=?,acc_no=? where list_idx=?";
		
		try {
			// 1.Connection얻어오기
			conn = DBService.getInstance().getConnection();
			
			// 2.PreparedStatement얻어오기
			pstmt = conn.prepareStatement(sql);
			
			// 3.pstmt parameter 설정
			pstmt.setInt(1, vo.getList_idx());
			pstmt.setInt(2, vo.getList_in());
			pstmt.setInt(3, vo.getList_out());
			pstmt.setInt(4, vo.getList_jan());
			pstmt.setString(5, vo.getList_date());
			pstmt.setString(6, vo.getAcc_no());
			
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

	

