package controller;

import java.util.Vector;

import model.EmployeeModel;
import view.Login;

public class LoginController {

	private static LoginController logincontroller;
	private EmployeeModel employee = new EmployeeModel();
	
	
	
	
	public static LoginController getInstance() {
		if(logincontroller == null){
			return new LoginController();
		}else {
			return logincontroller;
		}
	}
	
	public Login view() {
		return new Login();
	}

	public Vector<EmployeeModel> getAllProduct(){
		return employee.getAllEmployee();
	}
	
	public Vector<String> getAllUsername(){
		return employee.getAllUsername();
	}
	
	public Vector<String> getAllPassword(){
		return employee.getAllPassword();
	}

}