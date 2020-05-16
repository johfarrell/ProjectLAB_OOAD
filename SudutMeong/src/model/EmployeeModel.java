package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import sqlConnect.Connect;

public class EmployeeModel {

	private String Name;
	private String Username;
	private String Password;
	private Integer Employeeid;
	private Integer Roleid;
	private Integer Salary;
	private String Status;
	private String DOB;
	
	private Connect con;
	Integer index;
	
	public EmployeeModel() {
		
	}
	
	public EmployeeModel(Integer employeeid, Integer roleid, String name, String username, String DOB, Integer salary, String status, String password) {
		this.Employeeid=employeeid;
		this.Roleid=roleid;
		this.Name=name;
		this.Username=username;
		this.DOB=DOB;
		this.Salary=salary;
		this.Status=status;
		this.Password=password;
	}
	
	public Vector<EmployeeModel> getAllEmployee(){
		con = Connect.getConnection();
		ResultSet rs = con.executeQuery("SELECT * FROM employee");
		Vector<EmployeeModel> em = new Vector<EmployeeModel>();
		index = 1;
		try {
			while(rs.next()) {
				em.add(new EmployeeModel(rs.getInt("employeeID"), rs.getInt("roleID"), rs.getString("name"), rs.getString("username"),
						rs.getString("DOB"),rs.getInt("salary"), rs.getString("status"), rs.getString("password")));
				index++;
			}
		} catch (SQLException e) {
			
		}
		return em;
	}
	
	public Vector<String> getAllUsername(){
		con = Connect.getConnection();
		ResultSet rs = con.executeQuery("SELECT username FROM employee");
		Vector<String> emuser = new Vector<String>();
		index = 1;
		try {
			while(rs.next()) {
				emuser.add(rs.getString("username"));
				index++;
			}
		} catch (SQLException e) {
			
		}
		return emuser;
	}
	
	public Vector<String> getAllPassword(){
		con = Connect.getConnection();
		ResultSet rs = con.executeQuery("SELECT password FROM employee");
		Vector<String> empass = new Vector<String>();
		index = 1;
		try {
			while(rs.next()) {
				empass.add(rs.getString("password"));
				index++;
			}
		} catch (SQLException e) {
			
		}
		return empass;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Integer getEmployeeid() {
		return Employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		Employeeid = employeeid;
	}

	public Integer getRoleid() {
		return Roleid;
	}

	public void setRoleid(Integer roleid) {
		Roleid = roleid;
	}

	public Integer getSalary() {
		return Salary;
	}

	public void setSalary(Integer salary) {
		Salary = salary;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}
}
