package main;

import controller.EmployeeHandler;
import controller.ProductHandler;
import controller.RoleHandler;
import controller.TransactionHandler;
import controller.VoucherHandler;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
		VoucherHandler.getInstance().view();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
