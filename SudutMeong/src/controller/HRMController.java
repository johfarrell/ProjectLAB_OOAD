package controller;

import java.util.Random;
import java.util.Vector;

import model.EmployeeModel;
import view.ViewHRM;

public class HRMController {
	
	private static HRMController hrmController;
	private EmployeeModel employee = new EmployeeModel();
	
	public static HRMController getInstance(){
		if(hrmController == null){
			return new HRMController();
		} else{
			return hrmController;
		}
	}
	
	public ViewHRM view(){
		return new ViewHRM();
	}
	
	public Vector<EmployeeModel> getAllEmployee(){
		return employee.getAllEmployee();
	}
	
	protected String getPassword() {//BELOM DIUBAH
        String rangePass = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder pass = new StringBuilder();
        Random rnd = new Random();
        while (pass.length() < 5) {
            int index = (int) (rnd.nextFloat() * rangePass.length());
            pass.append(rangePass.charAt(index));
        }
        String fixedPass = pass.toString();
        return fixedPass;

    }
	
	public void addEmployee(int RoleID, String Name, String Username, String DOB, int Salary){
		
		Vector<String> checkUsername = new Vector<String>();
		checkUsername = LoginController.getInstance().getAllUsername();//MASIH NGAMBIL DARI LOGIN CONTROLLER
		
		if(checkUsername.contains(Username)) {
			System.out.println("Username Used"); //CONSOLE
		} else{
			String pass = getPassword();
			String status = "Active";
			employee.addEmployee(RoleID, Name, Username, DOB, Salary, status, pass);;
			System.out.println("Insert Success"); //CONSOLE
		}
	}
	
	public void updateEmployee(int employeeID, int RoleID, String Name, String Username, String DOB, int Salary){	
		employee.updateEmployee(employeeID, RoleID, Name, Username, DOB, Salary);
	}
	
	public void resetPassword(int employeeID){
		String password = getPassword();
		employee.resetPassword(employeeID, password);
	}
	
	public void fireEmployee(int employeeID){
		String status = "Inactive";
		employee.resetPassword(employeeID, status);
	}
}
















