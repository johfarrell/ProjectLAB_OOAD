package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import model.CartModel;
import model.EmployeeModel;
import model.VoucherModel;
import view.ViewPM;
import view.ViewTM;

public class CartHandler {
	private static CartHandler cartHandler;
	private CartModel cart = new CartModel();
	
	public static CartHandler getInstance(){
		if(cartHandler == null){
			return new CartHandler();
		} else{
			return cartHandler;
		}
	}
	
	public ViewTM view(){
		return new ViewTM();
	}
	
	public void addToCart(Integer ProductID, String ProductName, Integer Quantity){
		cart.addToCart(ProductID, ProductName, Quantity);
	}
	
	public Vector<CartModel> getAllItem(){
		return cart.getAllItem();
	}
}
