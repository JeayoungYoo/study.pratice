package jdbc.mvc.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static common.JDBCTemp.*;
import jdbc.mvc.model.vo.Employee;

public class EmployeeDAO2 {
	
	public EmployeeDAO2() {
	}

	public int insertEmployee(Employee emp) {
		int result = 0;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;

		try {
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

			if (result > 0)
				commit(conn);
			else
				rollback(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}

		return result;
	}

	public ArrayList<Employee> selectAll() {
		ArrayList<Employee> empList = null;
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rset = null;

		try {
			stmt = conn.createStatement();
			// 4. 쿼리문 작성하고 실행하고 결과받음
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

					// empList에 넣는 작업
					empList.add(emp);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
			close(conn);
		}

		return empList;
	}

	public Employee selectOne(String empId) {
		Employee emp = null;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
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

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			close(conn);
		}

		return emp;
	}

	public int updateEmployee(Employee emp) {
		int result = 0;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;

		try {
			String query = "update employee set job_id = ?, salary = ?, bonus_pct = ?, dept_id = ? where emp_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, emp.getJobid());
			pstmt.setInt(2, emp.getSalary());
			pstmt.setDouble(3, emp.getBonuspct());
			pstmt.setString(4, emp.getDeptid());
			pstmt.setString(5, emp.getEmpid());

			result = pstmt.executeUpdate();

			if (result > 0)
				commit(conn);
			else
				rollback(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}

		return result;

	}

	public int deleteEmployee(String empId) {
		int result = 0;
		Connection conn = getConnection();;
		PreparedStatement pstmt = null;

		try {
			String query = "delete from employee where emp_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empId);
			result = pstmt.executeUpdate();

			// 이 처리가 DML문에서는 반드시 필요하다
			if (result > 0)
				commit(conn);
			else
				rollback(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}

		return result;
	}

}
