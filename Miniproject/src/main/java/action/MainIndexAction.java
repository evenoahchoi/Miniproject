package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class member
 */
@WebServlet("/JSP/index.do")
public class MainIndexAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//GET방식이든 POST방식이던 다 받을 수 있게
		request.setCharacterEncoding("UTF-8");
		
		
		List list = null;
		
		
		// binding
		request.setAttribute("list", list);
		
		// forward
		RequestDispatcher disp = request.getRequestDispatcher("JSP/index.jsp");
		disp.forward(request, response);
		
	}

}
