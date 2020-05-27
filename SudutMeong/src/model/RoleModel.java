package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import sqlConnect.Connect;

public class RoleModel {
	
	private Integer RoleId;
	private String Role;
	
	private Connect con;
	
public RoleModel() {
		
	}
	
	public RoleModel(Integer roleid, String role) {
		this.RoleId=roleid;
		this.Role=role;
	}
	
	public Vector<RoleModel> getAllRole(){
		con = Connect.getConnection();
		ResultSet rs = con.executeQuery("SELECT * FROM role");
		Vector<RoleModel> em = new Vector<RoleModel>();
		try {
			while(rs.next()) {
				em.add(new RoleModel(rs.getInt("roleID"), rs.getString("name")));
			}
		} catch (SQLException e) {
			
		}
		return em;
	}

	public Integer getRoleId() {
		return RoleId;
	}

	public void setRoleId(Integer roleId) {
		RoleId = roleId;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

}
