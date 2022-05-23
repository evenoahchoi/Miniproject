package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {

	//OracleDriver Loading..
	//ojdbc14.jar�ʼ������� �ؾ��ϴµ�
	//ojdbc6.jar�϶��� ��������
	static {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// single-ton : ��ü 1���� �����ؼ� �������
	static DBService single = null;

	public static DBService getInstance() {

		// ��ü�� ������ ������.
		if (single == null)
			single = new DBService();

		return single;
	}

	// �ܺο��� �������� �ʵ���
	private DBService() {
		// TODO Auto-generated constructor stub

	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		
		String url  = "jdbc:oracle:thin:@localhost:1521:xe"; 
		String user = "test";
		String pwd  = "test";
		
		conn = DriverManager.getConnection(url, user, pwd);
		
		
		return conn;
	}
	
	

}
