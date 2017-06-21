
package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTemp {
	
	public static Connection getConnection() {
		Connection con = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	public static void close(Connection con) {
		try {
			if (!con.isClosed())
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

	public static void rollback(Connection con) {
		try {
			if (!con.isClosed())
				con.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
