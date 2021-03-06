package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.MemberVo;

public class MemberDao {

	// single-ton : 객체 1개만 생성해서 사용하자
	static MemberDao single = null;

	public static MemberDao getInstance() {

		// 객체가 없으면 만들어라.
		if (single == null)
			single = new MemberDao();

		return single;
	}

	private MemberDao() {
		
	}

	
	//회원 전체조회
	public List<MemberVo> selectList() {

		List<MemberVo> list = new ArrayList<MemberVo>();

		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		
		String sql = "select * from member";

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
				String member_ID = rs.getString("member_ID");
				String m_name    = rs.getString("m_name");
				String m_pwd     = rs.getString("m_pwd");
				String m_mail    = rs.getString("m_mail");
				String m_tel     = rs.getString("m_tel");
				//Vo로 포장
				MemberVo vo = new MemberVo();
				vo.setMember_ID(member_ID);
				vo.setM_name(m_name);
				vo.setM_pwd(m_pwd);
				vo.setM_mail(m_mail);
				vo.setM_tel(m_tel);
				//list추가
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close(); //3번째
				if (pstmt != null)
					pstmt.close(); //2번째
				if (conn != null)
					conn.close(); //1번째
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//idx로 조회
	//idx에 해당되는 객체 1건 구하기
	public MemberVo selectOne_Login(String member_ID) {

		MemberVo vo = null;

		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;

		String sql = "select * from member where member_ID=?";

		try {
			conn  = DBService.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			//Parameter index setting
			pstmt.setString(1, member_ID);
			
			rs = pstmt.executeQuery();
			//member_ID는 기본키이기 때문에, 조회가 되거나/안 되거나이기때문에 처리할 행 수는 1 or 0
			if (rs.next()) {
				
				vo = new MemberVo();
				
				vo.setMember_ID(rs.getString("member_ID"));
				vo.setM_pwd(rs.getString("m_pwd"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return vo;
	}
	
	
	//insert
	public int insert(MemberVo vo) {
		
		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		// 1 2 3 4<-parameter index
		String sql = "insert into member values(?,?,?,?,?)";
		try {
			// 1.Connection얻어오기
			conn = DBService.getInstance().getConnection();
			// 2.PreparedStatement얻어오기
			pstmt = conn.prepareStatement(sql);
			// 3.pstmt parameter 설정
			pstmt.setString(1, vo.getMember_ID());
			pstmt.setString(2, vo.getM_name());
			pstmt.setString(3, vo.getM_pwd());
			pstmt.setString(4, vo.getM_mail());
			pstmt.setString(5, vo.getM_tel());
			// 4.insert : res<-처리된 행수반환
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}//insert() end
	
	
	//delete
	public int delete(String member_ID) {

		int res = 0;

		Connection        conn  = null;
		PreparedStatement pstmt = null;

		String sql = "delete from member where member_ID=?";

		try {
			// 1.Connection얻어오기
			conn = DBService.getInstance().getConnection();
			// 2.PreparedStatement얻어오기
			pstmt = conn.prepareStatement(sql);
			// 3.pstmt parameter 설정
			pstmt.setString(1, member_ID);
			// 4.DML(insert,update,delete) : res<-처리된 행수반환
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}//delete() end
	
	
	
	//update
	public int update(MemberVo vo) {
		
		int res = 0;
		
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		
		String sql = "update member set m_name=?,m_pwd=?,m_mail=?,m_tel=? where member_ID=?";
		
		try {
			// 1.Connection얻어오기
			conn = DBService.getInstance().getConnection();
			// 2.PreparedStatement얻어오기
			pstmt = conn.prepareStatement(sql);
			// 3.pstmt parameter 설정
			pstmt.setString(1, vo.getM_name());
			pstmt.setString(2, vo.getM_pwd());
			pstmt.setString(3, vo.getM_mail());
			pstmt.setString(4, vo.getM_tel());
			pstmt.setString(5, vo.getMember_ID());
			
			// 4.DML(insert,update,delete) : res<-처리된 행수반환
			res = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}//update() end
}