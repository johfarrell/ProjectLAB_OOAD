package main;

import controller.HRMController;
import controller.LoginController;
import controller.PMController;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
		LoginController.getInstance().view();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
