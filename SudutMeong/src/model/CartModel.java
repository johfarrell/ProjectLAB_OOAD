package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import sqlConnect.Connect;

public class CartModel {
	
	private Integer ProductID;
	private String ProductName;
	private Integer Quantity;
	public static Vector<CartModel> em = new Vector<CartModel>();
	
	public CartModel() {
		
	}
	
	public CartModel(Integer productid, String productname, Integer quantity) {
		this.ProductID=productid;
		this.ProductName=productname;
		this.Quantity=quantity;
	}
	
	public void addToCart(Integer ProductID, String ProductName, Integer Quantity){
		
		System.out.println("Barang yang masuk ke cart: "+ "ID:"+ProductID + " Name:"+ProductName + " Quantity:"+ Quantity+"\n");
		CartModel item = new CartModel();
		item.setProductID(ProductID);
		item.setProductName(ProductName);
		item.setQuantity(Quantity);
		
		em.add(item);
		
		System.out.println("Isi cart:");
		for(int i=0; i<em.size(); i++) {
			CartModel x = em.elementAt(i);
			
			System.out.println(x.getProductName()+"|"+x.getQuantity());
		}
		System.out.println("==============================================");
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
	
	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}
	
}
