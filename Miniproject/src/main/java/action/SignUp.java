package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class member
 */
@WebServlet("/sign_up.do")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//GET방식이든 POST방식이던 다 받을 수 있게
		request.setCharacterEncoding("UTF-8");
		
		//parameter
		String member_ID = request.getParameter("member_ID");
		
		
		// binding
		request.setAttribute("member_ID", member_ID);
		
		// forward
		RequestDispatcher disp = request.getRequestDispatcher("JSP/SignUp_Result.jsp");
		disp.forward(request, response);
		
	}

}
