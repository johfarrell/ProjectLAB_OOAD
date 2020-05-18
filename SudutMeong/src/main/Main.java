package main;

import controller.HRMController;
import controller.LoginController;
import controller.MController;
import controller.PMController;
import controller.SMController;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
		MController.getInstance().view();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
