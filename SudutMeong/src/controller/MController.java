package controller;

import java.util.Random;
import java.util.Vector;

import model.EmployeeModel;
import model.TransactionItemModel;
import model.TransactionModel;
import view.ViewM;
import view.ViewMDetail;

public class MController {
	
	private static MController mController;
	private EmployeeModel employee = new EmployeeModel();
	private TransactionModel transaction = new TransactionModel();
	private TransactionItemModel transactionitem = new TransactionItemModel();
	
	public static MController getInstance(){
		if(mController == null){
			return new MController();
		} else{
			return mController;
		}
	}
	
	public ViewM view(){
		return new ViewM();
	}
	
	public Vector<EmployeeModel> getAllEmployee(){
		return employee.getAllEmployee();
	}
	
	public Vector<TransactionModel> getAllTransaction(String Month, String Year){
		return transaction.getAllTransaction(Month, Year);
	}
	
	public ViewMDetail viewMDetail() {
		return new ViewMDetail();
	}
	
	public Vector<TransactionItemModel> getAllTransactionItem(String X){
		return transactionitem.getAllTransactionItem(X);
	}
	
	/*public void selectTransaction(String Month, String Year){
		
		Vector<TransactionModel> viewTransaction = new Vector<TransactionModel>();
		viewTransaction = MController.getInstance().getAllTransaction();
		
		if(!viewTransaction.contains(Year + "-" + Month)) {
			System.out.println("No Transaction"); //CONSOLE
		} else{
			String pass = getPassword();
			String status = "Active";
			//employee.addEmployee(RoleID, Name, Username, DOB, Salary, status, pass);;
			System.out.println("Transaction Exist"); //CONSOLE
		}
	}*/
	
	protected String getPassword() {//BELOM DIUBAH
        String rangePass = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder pass = new StringBuilder();
        Random rnd = new Random();
        while (pass.length() < 5) {
            int index = (int) (rnd.nextFloat() * rangePass.length());
            pass.append(rangePass.charAt(index));
        }
        String fixedPass = pass.toString();
        System.out.println("new password is "+ fixedPass);
        return fixedPass;

    }
	
	public void addEmployee(Integer RoleID, String Name, String Username, String DOB, Integer Salary){
		
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
	
	public void updateEmployee(Integer employeeID, Integer RoleID, String Name, String Username, String DOB, Integer Salary){	
		employee.updateEmployee(employeeID, RoleID, Name, Username, DOB, Salary);
		System.out.println("Update Success"); //CONSOLE
	}
	
	public void fireEmployee(Integer employeeID){
		String status = "Inactive";
		employee.fireEmployee(employeeID, status);
		System.out.println("Fire Success"); //CONSOLE
	}

}
