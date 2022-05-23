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
		//id=hong&pwd=1234&name=ȫ�浿&email=hong1234&email2=gmail.com&gender=on&��õ��1=&MBTI=ENFP&profile=����+�ٷ�+��¥+ȫ�浿%21
	
		//0���� �������ڵ�����
		//(POST��û�� ������ ó�� /GET��û�ÿ��� ���ص� ��)
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

//---------�� [Business Logic]--------------------------

//---------�� [presentation Logic]----------------------
		
		
		//����ó��
		response.setContentType("text/html; charset=utf-8;");
		
		
		//HTML���� ���� -> ������ ����
		StringBuffer sbHtml = new StringBuffer();
		
		sbHtml.append("<html><head><title>���</title></head>");
		sbHtml.append("<body>");
	    sbHtml.append("<table border='1' width='400'>"); 
		sbHtml.append(String.format("<tr><th>���̵�</th><td>%s</td></tr>", member_ID));
		sbHtml.append(String.format("<tr><th>��й�ȣ</th><td>%s</td></tr>", pwdMasking));
		sbHtml.append(String.format("<tr><th>�̸�</th><td>%s</td></tr>", m_name));
		sbHtml.append(String.format("<tr><th>email</th><td>%s</td></tr>", m_email));
		sbHtml.append(String.format("<tr><th>��ȭ��ȣ</th><td>%s</td></tr>", m_tel));
		sbHtml.append("<tr><th colspan='2'><a href='member_input.html'>�ٽ��ϱ�</a></th></tr>");
		sbHtml.append("</table></body></html>");
		
		
		//����
		response.getWriter().print(sbHtml.toString());
		
	}

}
