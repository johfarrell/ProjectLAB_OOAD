package controller;

import java.util.Vector;

import model.RoleModel;
import view.Login;

public class RoleHandler {

	private static RoleHandler roleHandler;
	private RoleModel role = new RoleModel();
	
	public static RoleHandler getInstance(){
		if(roleHandler == null){
			return new RoleHandler();
		} else{
			return roleHandler;
		}
	}
	
	public Login view(){
		return new Login();
	}
	
	public Vector<RoleModel> getAllRole(){
		return role.getAllRole();
	}
	
}