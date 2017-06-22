package common;

import java.sql.*;
import java.util.*;
import java.io.*;

// singleton ������ ���� ����
// ���α׷� ����Ǵ� ���� �ش� Ŭ������ ���� ��ü�� �� ���� 
// ���� ����ϵ��� ó���ϴ� ���
// �ش� Ŭ������ ��� �޼ҵ带 Static �޼ҵ�� �ۼ���
public class JDBCTemplate {
	public static Connection getConnection(){
		Connection con = null;
		Properties prop = new Properties();
		
		try {
			prop.load(new FileReader("driver.properties"));
			Class.forName(prop.getProperty("driver"));
			con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("pwd"));
			/*Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	} 
	
	public static void close(Connection con) {
		try {
			if(!con.isClosed())
				con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if (!stmt.isClosed())
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset) {
		try {
			if (!rset.isClosed())
				rset.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection con) {
		try {
			if (!con.isClosed())
				con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback (Connection con) {
		try {
			if (!con.isClosed())
				con.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
