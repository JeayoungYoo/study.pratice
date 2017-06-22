package product.model.dao;

import java.sql.*;
import java.util.*;
import java.io.*;

import static common.JDBCTemplate.*;
import common.JDBCTemplate;
import product.model.vo.Product;

public class ProductDAO2 {
	private Properties prop;
	
	public ProductDAO2() {
		prop = new Properties();
		try {
			prop.load(new FileReader("query.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Product selectOne(String pid) {
		Product p = null;
		Connection con = JDBCTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			/*// 1. ����Ŭ�� ���� jdbc driver Ŭ���� ���
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. �����ͺ��̽� ����ó��
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");*/
			// 3. ���� ����� ��ü ����
			/*
			 * stmt = conn.createStatement();
			 * 
			 * // 4. ������ �ۼ��ϰ� �����ϰ� ������� String query =
			 * "select * from product where product_id = '" + pid + "'"; rset =
			 * stmt.executeQuery(query);
			 */

			String query = prop.getProperty("selectOne");
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, pid);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				p = new Product();
				p.setProduct_Id(rset.getString("PRODUCT_ID"));
				p.setP_name(rset.getString("P_NAME"));
				p.setPrice(rset.getInt("PRICE"));
				p.setDescription(rset.getString("DESCRIPTION"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			close(con);
		}

		return p;
	}

	public ArrayList<Product> selectList() {
		Product p = null;
		ArrayList<Product> selectList = null;
		Connection con = JDBCTemplate.getConnection();
		Statement stmt = null;
		ResultSet rset = null;

		try {
			/*// 1. ����Ŭ�� ���� jdbc driver Ŭ���� ���
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. �����ͺ��̽� ����ó��
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");*/
			// 3. ���� ����� ��ü ����
			stmt = con.createStatement();
			// 4. ������ �ۼ��ϰ� �����ϰ� �������
			String query = prop.getProperty("selectAll");
			rset = stmt.executeQuery(query);

			if (rset != null) {
				selectList = new ArrayList<Product>();

				while (rset.next()) {

					p = new Product();
					p.setProduct_Id(rset.getString("PRODUCT_ID"));
					p.setP_name(rset.getString("P_NAME"));
					p.setPrice(rset.getInt("PRICE"));
					p.setDescription(rset.getString("DESCRIPTION"));

					// empList�� �ִ� �۾�
					selectList.add(p);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
			close(con);
		}

		return selectList;
	}

	public int insertProduct(Product p) {
		int result = 0;
		Connection con = JDBCTemplate.getConnection();
		// Statement stmt = null;
		PreparedStatement pstmt = null;

		try {
			/*Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");*/

			// 3.
			/*
			 * stmt = conn.createStatement();
			 * 
			 * 
			 * 
			 * // 4. String query = "insert into product " +
			 * "(PRODUCT_ID, P_NAME, PRICE, DESCRIPTION) " + "values ('" +
			 * p.getProduct_Id() + "', '" + p.getP_name() + "', " + p.getPrice()
			 * + ", '" + p.getDescription() + "')";
			 * 
			 * result = stmt.executeUpdate(query);
			 */

			String query = prop.getProperty("insert");

			pstmt = con.prepareStatement(query);
			// ������ �ϼ�
			pstmt.setString(1, p.getProduct_Id());
			pstmt.setString(2, p.getP_name());
			pstmt.setInt(3, p.getPrice());
			pstmt.setString(4, p.getDescription());

			result = pstmt.executeUpdate();

			if (result > 0)
				commit(con);
			else
				rollback(con);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}

		return result;
	}

	public int updateProduct(String pid, int price) {
		int result = 0;
		Connection con = JDBCTemplate.getConnection();
		PreparedStatement pstmt = null;

		try {
			// 3.
			/*
			 * stmt = conn.createStatement();
			 * 
			 * // 4. String query = "update product set PRICE = " + price +
			 * " where PRODUCT_ID = '" + pid + "'";
			 * 
			 * result = stmt.executeUpdate(query);
			 */

			String query = prop.getProperty("update");
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, price);
			pstmt.setString(2, pid);

			result = pstmt.executeUpdate();

			if (result > 0)
				commit(con);
			else
				rollback(con);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}

		return result;

	}

	public int deleteProduct(String pid) {
		int result = 0;
		Connection con = JDBCTemplate.getConnection();;
		
		PreparedStatement pstmt = null;

		try {
			/*// 1. ����Ŭ�� ���� jdbc driver Ŭ���� ���
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. �����ͺ��̽� ����ó��
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");*/
			// 3. statement ����
			/*
			 * stmt = conn.createStatement();
			 * 
			 * // 4. ������ �ۼ�, ����, ��� �ޱ� String query =
			 * "delete from product where product_id = '" + pid + "'";
			 * 
			 * // DML�� executeUpdate�� �������� ������ result =
			 * stmt.executeUpdate(query);
			 */

			String query = prop.getProperty("delete");
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, pid);

			result = pstmt.executeUpdate();

			// �� ó���� DML�������� �ݵ�� �ʿ��ϴ�
			if (result > 0)
				commit(con);
			else
				rollback(con);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			// stmt.close();
			close(con);
		}

		return result;
	}

}
