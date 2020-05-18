package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import controller.LoginController;
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
	
	public void addEmployee(Integer RoleID, String Name, String Username, String DOB, Integer Salary, String Status, String Password){
		con = Connect.getConnection();
		getAllEmployee();
		PreparedStatement ps = con.prepareStatement("INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		try {
			ps.setInt(1, index);
			ps.setInt(2, RoleID);
			ps.setString(3, Name);
			ps.setString(4, Username);
			ps.setString(5, DOB);
			ps.setInt(6, Salary);
			ps.setString(7, Status);
			ps.setString(8, Password);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateEmployee(Integer employeeID, Integer RoleID, String Name, String Username, String DOB, Integer Salary){
		con = Connect.getConnection();
		getAllEmployee();
		PreparedStatement ps = con.prepareStatement("UPDATE `employee` SET `employeeID`= ?,`roleID`= ?,`name`= ?,`username`= ?,"
				+ "`DOB`= ?,`salary`= ? WHERE employeeID = ?");
		try {
			ps.setInt(1, employeeID);
			ps.setInt(2, RoleID);
			ps.setString(3, Name);
			ps.setString(4, Username);
			ps.setString(5, DOB);
			ps.setInt(6, Salary);
			ps.setInt(7, employeeID);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void resetPassword(Integer employeeID, String password){
		con = Connect.getConnection();
		
		PreparedStatement ps = con.prepareStatement("UPDATE `employee` SET `password`= ? WHERE employeeID = ?");
		try {
			ps.setString(1, password);
			ps.setInt(2, employeeID);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void fireEmployee(Integer employeeID, String status){
		con = Connect.getConnection();
		
		PreparedStatement ps = con.prepareStatement("UPDATE `employee` SET `status`= ? WHERE employeeID = ?");
		try {
			ps.setString(1, status);
			ps.setInt(2, employeeID);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
