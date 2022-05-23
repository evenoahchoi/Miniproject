package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {

	//OracleDriver Loading..
	//ojdbc14.jar필수적으로 해야하는데
	//ojdbc6.jar일때는 생략가능
	static {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// single-ton : 객체 1개만 생성해서 사용하자
	static DBService single = null;

	public static DBService getInstance() {

		// 객체가 없으면 만들어라.
		if (single == null)
			single = new DBService();

		return single;
	}

	// 외부에서 생성하지 않도록
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
