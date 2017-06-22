package jdbc.mvc.model.dao;

import java.sql.*;
import java.util.ArrayList;
import jdbc.mvc.model.vo.Employee;

// DAO (Database Access Object) : DB ����� ������ �ۼ��ϰ� 
// �������� DB�� ������ �����ϰ� �� ����� ���� �޴� Ŭ������
public class EmployeeDAO {
	public EmployeeDAO() {
	}

	public int insertEmployee(Employee emp) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. ����Ŭ�� ���� jdbc driver Ŭ���� ���
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. �����ͺ��̽� ����ó��
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
			
			// 3.
			/*stmt = conn.createStatement();
			
			// 4.
			String query = "insert into employee " + "(emp_id, emp_name, emp_no, email, phone, hire_date,"
					+ " job_id, salary, bonus_pct, marriage, mgr_id, dept_id) " + "values ('" + emp.getEmpid() + "', '" + emp.getEmpname() + "', '" + emp.getEmpno() + "', '" + emp.getEmail()
					 + "', '" + emp.getPhone() + "', sysdate, '" + emp.getJobid() + "', " + emp.getSalary() + ", " + emp.getBonuspct() + ", '" + emp.getMarriage() + "', '" + emp.getMgrid()
					 + "', '" + emp.getDeptid() + "')";
			
			result = stmt.executeUpdate(query);*/
			String query = "insert into employee values (?, ?, ?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, emp.getEmpid());
			pstmt.setString(2, emp.getEmpname());
			pstmt.setString(3, emp.getEmpno());
			pstmt.setString(4, emp.getEmail());
			pstmt.setString(5, emp.getPhone());
			pstmt.setString(6, emp.getJobid());
			pstmt.setInt(7, emp.getSalary());
			pstmt.setDouble(8, emp.getBonuspct());
			pstmt.setString(9, emp.getMarriage());
			pstmt.setString(10, emp.getMgrid());
			pstmt.setString(11, emp.getDeptid());
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
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public ArrayList<Employee> selectAll() {
		ArrayList<Employee> empList = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		try {
			// 1. ����Ŭ�� ���� jdbc driver Ŭ���� ���
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. �����ͺ��̽� ����ó��
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
			// 3. ���� ����� ��ü ����
			stmt = conn.createStatement();
			// 4. ������ �ۼ��ϰ� �����ϰ� �������
			String query = "select * from employee";
			rset = stmt.executeQuery(query);

			if (rset != null) {
				empList = new ArrayList<Employee>();

				while (rset.next()) {
					Employee emp = new Employee();
					emp.setEmpid(rset.getString("EMP_ID"));
					emp.setEmpname(rset.getString("EMP_NAME"));
					emp.setEmpno(rset.getString("EMP_NO"));
					emp.setEmail(rset.getString("EMAIL"));
					emp.setPhone(rset.getString("PHONE"));
					emp.setHiredate(rset.getDate("HIRE_DATE"));
					emp.setJobid(rset.getString("JOB_ID"));
					emp.setSalary(rset.getInt("SALARY"));
					emp.setBonuspct(rset.getDouble("BONUS_PCT"));
					emp.setMarriage(rset.getString("MARRIAGE"));
					emp.setMgrid(rset.getString("MGR_ID"));
					emp.setDeptid(rset.getString("DEPT_ID"));

					// empList�� �ִ� �۾�
					empList.add(emp);
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

		return empList;
	}

	public Employee selectOne(String empId) {
		Employee emp = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			// 1. ����Ŭ�� ���� jdbc driver Ŭ���� ���
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. �����ͺ��̽� ����ó��
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
			// 3. ���� ����� ��ü ����
			/*stmt = conn.createStatement();
			// 4. ������ �ۼ��ϰ� �����ϰ� �������
			String query = "select * from employee where emp_id = '" + empId + "'";
			rset = stmt.executeQuery(query);*/
			
			String query = "select * from employee where emp_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empId);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				emp = new Employee();
				emp.setEmpid(rset.getString("EMP_ID"));
				emp.setEmpname(rset.getString("EMP_NAME"));
				emp.setEmpno(rset.getString("EMP_NO"));
				emp.setEmail(rset.getString("EMAIL"));
				emp.setPhone(rset.getString("PHONE"));
				emp.setHiredate(rset.getDate("HIRE_DATE"));
				emp.setJobid(rset.getString("JOB_ID"));
				emp.setSalary(rset.getInt("SALARY"));
				emp.setBonuspct(rset.getDouble("BONUS_PCT"));
				emp.setMarriage(rset.getString("MARRIAGE"));
				emp.setMgrid(rset.getString("MGR_ID"));
				emp.setDeptid(rset.getString("DEPT_ID"));

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return emp;
	}

	public int updateEmployee(Employee emp) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. ����Ŭ�� ���� jdbc driver Ŭ���� ���
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. �����ͺ��̽� ����ó��
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
			
			// 3.
			/*stmt = conn.createStatement();
			
			// 4.
			String query = "update employee set job_id = '" + emp.getJobid() + "', salary = " +
			emp.getSalary() + ", bonus_pct = " + emp.getBonuspct() + ", dept_id = '" + emp.getDeptid() + 
			"' where emp_id = '" + emp.getEmpid() + "'";
			
			result = stmt.executeUpdate(query);*/
			
			String query = "update employee set job_id = ?, salary = ?, bonus_pct = ?, dept_id = ? where emp_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, emp.getJobid());
			pstmt.setInt(2, emp.getSalary());
			pstmt.setDouble(3, emp.getBonuspct());
			pstmt.setString(4, emp.getDeptid());
			pstmt.setString(5, emp.getEmpid());
			
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
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;

	}

	public int deleteEmployee(String empId) {
		int result = 0;
		Connection conn = null;
//		Statement stmt = null;
		PreparedStatement pstmt = null;
		

		try {
			// 1. ����Ŭ�� ���� jdbc driver Ŭ���� ���
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. �����ͺ��̽� ����ó��
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
			// 3. statement ����
			/*stmt = conn.createStatement();
			
			// 4. ������ �ۼ�, ����, ��� �ޱ�
			String query = "delete from employee where emp_id = '" + empId + "'";
			
			// DML�� executeUpdate�� �������� ������
			result = pstmt.executeUpdate(query);*/
			
			String query = "delete from employee where emp_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, String.valueOf(empId));
			result = pstmt.executeUpdate();
			
			
			// �� ó���� DML�������� �ݵ�� �ʿ��ϴ�
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
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

}
