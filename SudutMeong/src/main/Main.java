package main;
import java.util.Scanner;

import controller.LoginController;
import sqlConnect.Connect;

public class Main {
	static int roleID;
	Scanner sc = new Scanner(System.in);

	/*
	-1 = Human Resource
	-2 = Storage Manager
	-3 = Promo Manager
	-4 = Master Manager
	-5 = Cashier
	*/

	Connect connect;

	public Main() {
		// TODO Auto-generated constructor stub
		LoginController.getInstance().view();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
