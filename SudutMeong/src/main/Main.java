package main;

import controller.EmployeeHandler;
import controller.TransactionHandler;
import controller.VoucherHandler;
import controller.ProductHandler;
import controller.RoleHandler;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
		TransactionHandler.getInstance().view();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
