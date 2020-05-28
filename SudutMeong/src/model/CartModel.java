package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import sqlConnect.Connect;

public class CartModel {
	
	private Integer ProductID;
	private Integer Quantity;
	public static Vector<CartModel> em = new Vector<CartModel>();
	
	public CartModel() {
		
	}
	
	public CartModel(Integer productid, Integer quantity) {
		this.ProductID=productid;
		this.Quantity=quantity;
	}
	
	public void addToCart(Integer ProductID, Integer Quantity){
		System.out.println(ProductID);
		System.out.println(Quantity);
		//em.add(ProductID, Quantity);
	}
	
	public Vector<CartModel> getAllItem(){
		System.out.println(em);
		return em;
	}

	public Integer getProductID() {
		return ProductID;
	}

	public void setProductID(Integer productID) {
		ProductID = productID;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}
	
	
}
