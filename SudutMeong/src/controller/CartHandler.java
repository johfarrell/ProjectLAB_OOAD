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
	
	public ViewTM view(Integer EmployeeID){
		return new ViewTM(EmployeeID);
	}
	
	public void addToCart(Integer ProductID, String ProductName, Integer Quantity){
		cart.addToCart(ProductID, ProductName, Quantity);
	}
	
	public void changeCartItem(Integer index, CartModel updatedItem) {
		cart.changeCartItem(index, updatedItem);
	}
	
	public void removeCartItem(Integer index) {
		cart.removeCartItem(index);
	}
	
	public void emptyCart(){
		cart.emptyCart();
	}
	
	public Vector<CartModel> getAllItem(){
		return cart.getAllItem();
	}
	
	public Vector<Integer> getAllItemID(){
		return cart.getAllItemID();
	}
	
	
}
