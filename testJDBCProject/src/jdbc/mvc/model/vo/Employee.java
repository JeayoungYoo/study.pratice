package jdbc.mvc.model.vo;

import java.sql.Date;

// vo (value object) : db ���̺��� �� ���� ���� ����� ��ü
// do (domain object) == entity == dto(data transfer object)
// bean 

// ��� �ʵ�� �ݵ�� private �̾�� ��
// �⺻ �����ڿ� �Ű������� �ִ� ������ �ۼ��ؾ� ��
// ��� �ʵ忡 ���� getter / setter �� �����ؾ���
// �ݵ�� ����ȭ���Ѿ� ��

public class Employee implements java.io.Serializable {
	private String empid;
	private String empname;
	private String empno;
	private String email;
	private String phone;
	private Date hiredate;
	private String jobid;
	private int salary;
	private double bonuspct;
	private String marriage;
	private String mgrid;
	private String deptid;
	
	public Employee(){}

	public Employee(String empid, String empname, String empno, String email, String phone, Date hiredate, String jobid,
			int salary, double bonuspct, String marriage, String mgrid, String deptid) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.empno = empno;
		this.email = email;
		this.phone = phone;
		this.hiredate = hiredate;
		this.jobid = jobid;
		this.salary = salary;
		this.bonuspct = bonuspct;
		this.marriage = marriage;
		this.mgrid = mgrid;
		this.deptid = deptid;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public double getBonuspct() {
		return bonuspct;
	}

	public void setBonuspct(double bonuspct) {
		this.bonuspct = bonuspct;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getMgrid() {
		return mgrid;
	}

	public void setMgrid(String mgrid) {
		this.mgrid = mgrid;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	@Override
	public String toString() {
		return empid + ", " + empname + ", " + empno + ", " + email
				+ ", " + phone + ", " + hiredate + ", " + jobid + ", " + salary
				+ ", " + bonuspct + ", " + marriage + ", " + mgrid + ", " + deptid;
	}
	

}
