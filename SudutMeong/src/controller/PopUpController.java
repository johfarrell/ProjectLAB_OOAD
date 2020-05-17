package controller;

import view.UsernameNotFound;
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
}
