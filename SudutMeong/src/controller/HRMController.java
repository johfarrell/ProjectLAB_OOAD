package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
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
	
	public Vector<String> getAllUsername(){
		return employee.getAllUsername();
	}
	
	public Vector<String> getAllPassword(){
		return employee.getAllPassword();
	}
	
	protected String getPassword() {//BELOM DIUBAH
        String rangePass = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder pass = new StringBuilder();
        Random rnd = new Random();
        while (pass.length() < 5) {
            int index = (int) (rnd.nextFloat() * rangePass.length());
            pass.append(rangePass.charAt(index));
        }
        String fixedPass = pass.toString();
        System.out.println("Password is "+ fixedPass);
        return fixedPass;

    }
	
	public void addEmployee(Integer RoleID, String Name, String Username, String DOB, Integer Salary) throws ParseException{
		
		Vector<String> checkUsername = new Vector<String>();
		checkUsername = HRMController.getInstance().getAllUsername();
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date DOBEmp = dateFormat.parse(DOB);  
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		Date today_withouttime = formatter.parse(formatter.format(today));
        
		
		if(Salary<1) {
			PopUpController.getInstance().mustmoresalary();
		}if(DOBEmp.after(today_withouttime)) {
			PopUpController.getInstance().mustlessdate();
		}if(checkUsername.contains(Username)) {
			PopUpController.getInstance().usernameused();
		}if(RoleID < 1 || RoleID > 5) {
			PopUpController.getInstance().notvalidrole();
		}else if((RoleID > 0 || RoleID < 6) && (checkUsername.contains(Username) != true) && (DOBEmp.before(today_withouttime)) && (Salary>0)){
			String pass = getPassword();
			String status = "Active";
			employee.addEmployee(RoleID, Name, Username, DOB, Salary, status, pass);
			PopUpController.getInstance().insertsuccess();
		}
	}
	
	public void updateEmployee(Integer employeeID, Integer RoleID, String Name, String Username, String DOB, Integer Salary) throws ParseException{
		
		Vector<EmployeeModel> checkSize = new Vector<EmployeeModel>();
		checkSize = HRMController.getInstance().getAllEmployee();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date DOBEmp = dateFormat.parse(DOB);  
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		Date today_withouttime = formatter.parse(formatter.format(today));
        
		if((employeeID<0) || (employeeID>checkSize.size())) {
			PopUpController.getInstance().idnotfound();
		}else {
			Vector<String> checkUsername = new Vector<String>();
			checkUsername = HRMController.getInstance().getAllUsername();
			checkUsername.remove(employeeID-1); //REMOVE CURRENT EDITED ID
			
			if(RoleID < 1 || RoleID > 5) {
				PopUpController.getInstance().notvalidrole();
			}if(Salary<1) {
				PopUpController.getInstance().mustmoresalary();
			}if(DOBEmp.after(today_withouttime)) {
				PopUpController.getInstance().mustlessdate();
			}if(checkUsername.contains(Username)) {
				PopUpController.getInstance().usernameused();
			}else if((checkUsername.contains(Username) == false) && (DOBEmp.before(today_withouttime)) && (Salary>0) && (RoleID > 0 || RoleID < 6)){
				employee.updateEmployee(employeeID, RoleID, Name, Username, DOB, Salary);	
				PopUpController.getInstance().updatesuccess();
			}
		}
		
	}
	
	public void resetPassword(Integer employeeID){
		Vector<EmployeeModel> checkSize = new Vector<EmployeeModel>();
		checkSize = HRMController.getInstance().getAllEmployee();
		
		if((employeeID<0) || (employeeID>checkSize.size())) {
			PopUpController.getInstance().idnotfound();
		}else{
			String password = getPassword();
			employee.resetPassword(employeeID, password);
			PopUpController.getInstance().resetpasssuccess();
		}
	}
	
	public void fireEmployee(Integer employeeID){
		Vector<EmployeeModel> checkSize = new Vector<EmployeeModel>();
		checkSize = HRMController.getInstance().getAllEmployee();
		
		System.out.println(employeeID + ", size:" + checkSize.size());
		
		if((employeeID<0) || (employeeID>checkSize.size())) {
			PopUpController.getInstance().idnotfound();
		}else{
			String status = "Inactive";
			employee.fireEmployee(employeeID, status);
			PopUpController.getInstance().fired();
		}
		
	}
}
















