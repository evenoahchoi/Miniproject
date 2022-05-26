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

@WebServlet("/signup/sign_up.do")
public class SignUpListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String member_ID = request.getParameter("member_ID");
		String m_name    = request.getParameter("m_name");
		String m_pwd     = request.getParameter("m_pwd");
		
		//my_signup.jsp에서 얻어온 전달인자 email
		String email1    = request.getParameter("email1");
		String email2    = request.getParameter("email2");
		
		//my_signup.jsp에서 얻어온 전달인자 tel
		String tel1     = request.getParameter("tel1");
		String tel2     = request.getParameter("tel2");
		String tel3     = request.getParameter("tel3");
		
		//vo로 포장하기 전, 각 변수 하나로 합치기
		String m_mail = String.format("%s@%s", email1, email2);
		String m_tel  = String.format("%s-%s-%s", tel1, tel2, tel3);
		
		//Vo포장
		MemberVo vo = new MemberVo(member_ID, m_name, m_pwd, m_mail, m_tel);
		
		//DB insert
		int res = MemberDao.getInstance().insert(vo);
		
		//갱신된 정보 재요청
		response.sendRedirect("index.jsp");
	}
}