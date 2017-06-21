package product.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import product.model.vo.Product;

public class ProductDAO {
	
	public ProductDAO(){}
	
	public Product selectOne(String pid){
		Product p = null;
		Connection conn = null;
//		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			// 1. 오라클에 대한 jdbc driver 클래스 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. 데이터베이스 연결처리
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
			// 3. 쿼리 실행용 객체 생성
			/*stmt = conn.createStatement();
			
			// 4. 쿼리문 작성하고 실행하고 결과받음
			String query = "select * from product where product_id = '" + pid + "'";
			rset = stmt.executeQuery(query);*/
			
			String query = "select * from product where product_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pid);
			
			rset = pstmt.executeQuery();
			
			

			if (rset.next()) {
				p = new Product();
				p.setProduct_Id(rset.getString("PRODUCT_ID"));
				p.setP_name(rset.getString("P_NAME"));
				p.setPrice(rset.getInt("PRICE"));
				p.setDescription(rset.getString("DESCRIPTION"));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
//				stmt.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return p;
	}
	
	public ArrayList<Product> selectList(){
		Product p = null;
		ArrayList<Product> selectList = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		try {
			// 1. 오라클에 대한 jdbc driver 클래스 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. 데이터베이스 연결처리
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
			// 3. 쿼리 실행용 객체 생성
			stmt = conn.createStatement();
			// 4. 쿼리문 작성하고 실행하고 결과받음
			String query = "select * from product";
			rset = stmt.executeQuery(query);

			if (rset != null) {
				selectList = new ArrayList<Product>();

				while (rset.next()) {
					
					p = new Product();
					p.setProduct_Id(rset.getString("PRODUCT_ID"));
					p.setP_name(rset.getString("P_NAME"));
					p.setPrice(rset.getInt("PRICE"));
					p.setDescription(rset.getString("DESCRIPTION"));
					
					// empList에 넣는 작업
					selectList.add(p);
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return selectList;
	}
	
	public int insertProduct(Product p){
		int result = 0;
		Connection conn = null;
//		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
			
			// 3.
			/*stmt = conn.createStatement();
			
			
			
			// 4.
			String query = "insert into product " + "(PRODUCT_ID, P_NAME, PRICE, DESCRIPTION) " + "values ('" + p.getProduct_Id() + "', '" + p.getP_name() + "', " + 
			p.getPrice() + ", '" + p.getDescription() + "')";
			
			result = stmt.executeUpdate(query);*/
			
			String query = "insert into product values (?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(query);
			// 쿼리문 완성
			pstmt.setString(1, p.getProduct_Id());
			pstmt.setString(2, p.getP_name());
			pstmt.setInt(3, p.getPrice());
			pstmt.setString(4, p.getDescription());
			
			result = pstmt.executeUpdate();
			
			if(result > 0)
				conn.commit();
			else
				conn.rollback();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				stmt.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	
	public int updateProduct(String pid, int price){
		int result = 0;
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. 오라클에 대한 jdbc driver 클래스 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. 데이터베이스 연결처리
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
			
			// 3.
			/*stmt = conn.createStatement();
			
			// 4.
			String query = "update product set PRICE = " + price + " where PRODUCT_ID = '" + pid + "'";
			
			result = stmt.executeUpdate(query);*/
			
			String query = "update product set price = ?" + " where product_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, price);
			pstmt.setString(2, pid);
			
			result = pstmt.executeUpdate();
			
			if(result > 0)
				conn.commit();
			else
				conn.rollback();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
//				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
		
	}
	
	public int deleteProduct(String pid){
		int result = 0;
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;

		try {
			// 1. 오라클에 대한 jdbc driver 클래스 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. 데이터베이스 연결처리
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
			// 3. statement 생성
			/*stmt = conn.createStatement();
			
			// 4. 쿼리문 작성, 실행, 결과 받기
			String query = "delete from product where product_id = '" + pid + "'";
			
			// DML은 executeUpdate로 쿼리문을 날린다
			result = stmt.executeUpdate(query);*/
			
			String query = "delete from product where product_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pid);
			
			result = pstmt.executeUpdate();
			
			
			// 이 처리가 DML문에서는 반드시 필요하다
			if (result > 0)
				conn.commit();
			else
				conn.rollback();
			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
//				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	
}
