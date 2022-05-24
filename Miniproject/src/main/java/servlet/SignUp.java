package servlet;

import java.io.IOException;
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
		
		//member_register.do?
		//id=hong&pwd=1234&name=홍길동&email=hong1234&email2=gmail.com&gender=on&추천인1=&MBTI=ENFP&profile=제가+바로+진짜+홍길동%21
	
		//0순위 수신인코딩설정
		//(POST요청시 무조건 처리 /GET요청시에는 안해도 됨)
		request.setCharacterEncoding("UTF-8");
		
		
		String member_ID = request.getParameter("member_ID");

		String m_pwd = request.getParameter("m_pwd");

		
		//System.out.println(pwdMasking.substring(pwd.length()/2,pwd.length()));
		
		
		
		StringBuffer sbPwd = new StringBuffer();
		//String pwdMasking = pwd.substring(0, pwd.length()/2);
		
		sbPwd.append(m_pwd.substring(0, m_pwd.length()/2));
		
		for(int i=m_pwd.length()/2; i<m_pwd.length(); i++) {
			
			sbPwd.append("*");
			
		}
		

		
		String pwdMasking = sbPwd.toString();
		
		String m_name = request.getParameter("m_name");
		
		String m_email = String.format( "%s@%s", request.getParameter("email"), request.getParameter("email2"));

		
		String m_tel = request.getParameter("m_tel");

//---------▲ [Business Logic]--------------------------

//---------▼ [presentation Logic]----------------------
		
		
		//응답처리
		response.setContentType("text/html; charset=utf-8;");
		
		
		//HTML동적 생성 -> 저장할 버퍼
		StringBuffer sbHtml = new StringBuffer();
		
		sbHtml.append("<html><head><title>결과</title></head>");
		sbHtml.append("<body>");
	    sbHtml.append("<table border='1' width='400'>"); 
		sbHtml.append(String.format("<tr><th>아이디</th><td>%s</td></tr>", member_ID));
		sbHtml.append(String.format("<tr><th>비밀번호</th><td>%s</td></tr>", pwdMasking));
		sbHtml.append(String.format("<tr><th>이름</th><td>%s</td></tr>", m_name));
		sbHtml.append(String.format("<tr><th>email</th><td>%s</td></tr>", m_email));
		sbHtml.append(String.format("<tr><th>전화번호</th><td>%s</td></tr>", m_tel));
		sbHtml.append("<tr><th colspan='2'><a href='member_input.html'>다시하기</a></th></tr>");
		sbHtml.append("</table></body></html>");
		
		
		//전송
		response.getWriter().print(sbHtml.toString());
		
	}

}
