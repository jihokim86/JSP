package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
	public static Connection getConnection() {
		Connection conn = null;
		
		
		try {
			Context initContext = new InitialContext();
			// Context � ��ü�� �ڵ鸵�ϱ� ���� ���� ���� �����θ� �˾Ƶ���.
			//�� ���ø����̼��� ó�� ��ġ�ɶ� �����ǰ�, ��� ������ ��Ʈ�����ڿ��� JNDI namespace�� java:comp/env�κп� ���̰� ��.
			//JNDI:Java Naming and Directory Interface)�� ���̹� ���񽺷� ���� �����ϴ� �ڿ�(������ �� ��ü)�� ã�� ����(lookup)�ϱ� ���� �ڹ� API�Դϴ�.
			
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			//�ڹ� �� �������α׷������� JDNI�� "lookup()"�� ���� ���ҽ��� �����ϰ� �����ͺ��̽� Ŀ�ؼ��� ������ �̿��մϴ�.
			//lookup()�� ���� "java:/comp/0env"�� �ش��ϴ� ��ü�� ã�Ƽ� enContext�� ����
			
			DataSource ds = (DataSource)envContext.lookup("jdbc/oracle");
			//lookup()�� ���� "jdbc/oracle"�� �ش��ϴ� ��ü�� ã�Ƽ� ds�� ����
			
			conn = ds.getConnection();
			//getConnection�޼��带 �̿��ؼ� Ŀ�ؼ� Ǯ�� ���� Ŀ�ؼ� ��ü�� ���� conn������ ����
			
			/*
		     * ���� �ڵ带 �Ʒ��� ���� �ٿ��� �ۼ� �����ϴ�.
		     Context context = new InitialContext();
		     DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		     Connection conn = dataSource.getConnection(); 
		     
		     */
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//select�� ������ �� ���ҽ� ������ ���� �޼ҵ�
	public static void close(Connection conn,Statement stmt, ResultSet rs) {
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//insert, update, delete �۾��� ������ �� ���ҽ� ������ ���� �޼ҵ�
	public static void close(Connection conn,Statement stmt) {
		try {
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
