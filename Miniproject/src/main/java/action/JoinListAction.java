package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.MemberVo;

/**
 * Servlet implementation class JoinListAction
 */

@WebServlet("/join/join.do")
public class JoinListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String member_ID = request.getParameter("member_ID");
		String m_name     = request.getParameter("m_name");
		String m_pwd       = request.getParameter("m_pwd");
		String m_mail       = request.getParameter("m_mail");
		String m_tel          = request.getParameter("m_tel");
		String m_addr        = request.getParameter("m_addr");
		
		//Vo포장
		MemberVo vo = new MemberVo(member_ID, m_name, m_pwd, m_mail, m_tel, m_addr);
	
		//DB insert
		int res = MemberDao.getInstance().insert(vo);
		
		//CRUD명령은 Redirect방식으로 진행
		response.sendRedirect("login.do");
	}
}