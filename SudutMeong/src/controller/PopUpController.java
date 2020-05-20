package controller;

import view.DateMustLess;
import view.DateMustMore;
import view.DeleteSuccess;
import view.FireSuccess;
import view.IDNotFound;
import view.InactiveEmployee;
import view.InsertSuccess;
import view.NotValidDiscount;
import view.NotValidRole;
import view.ResetSuccess;
import view.SalaryMustMore;
import view.UpdateSuccess;
import view.UsernameNotFound;
import view.UsernameUsed;
import view.WrongPassword;

public class PopUpController {

	private static PopUpController popupController;
	
	public static PopUpController getInstance() {
		if(popupController == null){
			return new PopUpController();
		} else{
			return popupController;
		}
	}
	
	public PopUpController() {
		
	}

	public WrongPassword wrongpass() {
		return new WrongPassword();
	}
	
	public UsernameNotFound usernamenotfound() {
		return new UsernameNotFound();
	}
	
	public InactiveEmployee inactive() {
		return new InactiveEmployee();
	}
	
	public InsertSuccess insertsuccess() {
		return new InsertSuccess();
	}
	
	public UpdateSuccess updatesuccess() {
		return new UpdateSuccess();
	}
	
	public ResetSuccess resetpasssuccess() {
		return new ResetSuccess();
	}
	
	public UsernameUsed usernameused() {
		return new UsernameUsed();
	}
	
	public FireSuccess fired() {
		return new FireSuccess();
	}
	
	public DeleteSuccess voucherdel() {
		return new DeleteSuccess();
	}
	
	public NotValidRole notvalidrole() {
		return new NotValidRole();
	}
	
	public NotValidDiscount notvaliddisc() {
		return new NotValidDiscount();
	}
	
	public DateMustLess mustlessdate() {
		return new DateMustLess();
	}
	
	public DateMustMore mustmoredate() {
		return new DateMustMore();
	}
	
	public SalaryMustMore mustmoresalary() {
		return new SalaryMustMore();
	}
	
	public IDNotFound idnotfound() {
		return new IDNotFound();
	}
	
}
