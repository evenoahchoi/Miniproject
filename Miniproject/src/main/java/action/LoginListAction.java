package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.MemberVo;

/**
 * Servlet implementation class LoginListAction
 */

@WebServlet("/login/login.do")
public class LoginListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Parameter 얻어오기
		String member_ID = request.getParameter("member_ID");
		
		//member_ID에 해당되는 vo 1건 얻어오기
		MemberVo vo = MemberDao.getInstance().selectOne_Login(member_ID);
		
		//request binding
		request.setAttribute("vo", vo);
		
		//로그인 실패시
		if(vo==null) {
			
			RequestDispatcher disp = request.getRequestDispatcher("../login/failLogin.jsp");
			disp.forward(request, response);
			
		}else { //로그인 성공시
			
			RequestDispatcher disp = request.getRequestDispatcher("../JSP/index.jsp");
			disp.forward(request, response);
		
		}
		
	}
}