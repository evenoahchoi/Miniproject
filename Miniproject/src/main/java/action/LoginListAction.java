package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginListAction
 */

@WebServlet("/login/login.do")
public class LoginListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//0. ���ڵ���� ����
		request.setCharacterEncoding("utf-8");
		
		//1. Parameter ������
		String id   = request.getParameter("member_ID");
		String pwd  = request.getParameter("m_pwd");
		
		//2. request binding
		request.setAttribute("id", id);
		request.setAttribute("pwd", pwd);
		
		//3. Dispatcher forward
		RequestDispatcher disp = request.getRequestDispatcher("../JSP/index.jsp");
		disp.forward(request, response);
	}
}