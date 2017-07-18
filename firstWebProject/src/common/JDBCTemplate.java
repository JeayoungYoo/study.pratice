package common;

import java.sql.*;
import java.util.*;
import java.io.*;

public class JDBCTemplate {
	public static Connection getConnection() {
		Connection con = null;
		Properties prop = new Properties();


		try {
			String path = JDBCTemplate.class.getResource("./").getPath();
			prop.load(new FileReader(path + "driver.properties"));
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String id = prop.getProperty("user");
			String pw = prop.getProperty("passwd");
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	public static void close(Connection con) {
		try {
			if (con != null && con.isClosed())
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt) {
		try {
			if (stmt != null && stmt.isClosed())
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rset) {
		try {
			if (rset != null && rset.isClosed())
				rset.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void commit(Connection con) {
			try {
				if(con != null && !con.isClosed())
					con.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	public static void rollback(Connection con) {
		try {
			if(con != null && !con.isClosed())
				con.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
