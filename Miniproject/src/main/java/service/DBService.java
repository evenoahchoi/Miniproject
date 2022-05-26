package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBService {
	
	//�������� !!
	DataSource ds;
	
	//single-ton : ��ü 1���� �����ؼ� �������!
	//����ƽ��ü�� ������ �ϳ��� ���������.

	static DBService single = null;

	//����ƽ�� ������ ����ƽ���θ�
	public static DBService getInstance() {

		//��ü�� ������ �����ض� ȣ��� �ѹ��� ��ü�� ����
		if (single == null)
			single = new DBService();

		return single;
	}

	//�ܺο��� ��ü�� �������� ���ϰ� ����
	private DBService() {
		// TODO Auto-generated constructor stub
		//JNDI(Java Naming Directory(�˻�) Interface)
		
		try {
			//1.InitialContext���� ���̹��� ����� �� �ִ� ��ü
			InitialContext ic = new InitialContext();
			
			//2.Resource�� ����� Context���� ���ϱ�
			//���ý�Ʈ ��ġ�� ã��
			//		���� ����ǰ� �ִ� �� context������ ���Ѵ�.
			//Context context = (Context)ic.lookup("java:comp/env");
			
			//3.Context ���� Resource������ ȹ��
			//ds = (DataSource) context.lookup("jdbc/oracle_test");
			
			//����� �ѹ��� �� ���� �ִ�. 2 + 3
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/oracle_test");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//DBCP�� ����� Ŀ�ؼ� ������
	public Connection getConnection() throws SQLException {
	
		//�̾ȿ��� ���ܸ� ó���ع�����,
		//�ٱ��� ����ڴ� � ������ ������ �� �� ������
		//����ڿ��� Exception�� throws �Ѵ�.
		
		return ds.getConnection();
		
		
	}
	

}
