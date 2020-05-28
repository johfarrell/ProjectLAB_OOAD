package controller;

import java.util.Vector;

import model.EmployeeModel;
import model.ProductModel;
import sun.security.krb5.internal.crypto.Des;
import view.ViewSM;

public class ProductHandler {
	
	private static ProductHandler productHandler;
	private ProductModel product = new ProductModel();
	
	public static ProductHandler getInstance(){
		if(productHandler == null){
			return new ProductHandler();
		} else{
			return productHandler;
		}
	}
	
	public ViewSM view(){
		return new ViewSM();
	}
	
	public Vector<ProductModel> getAllProduct(){
		return product.getAllProduct();
	}
	
	public Vector<Integer> getAllProductID(){
		return product.getAllProductID();
	}
	
	public Vector<Integer> getStock(){
		return product.checkStock();
	}
	
	
	public  Integer getProduct(Integer ProductID, Integer Stock){
		Vector<Integer> checkStock = getStock();
		Vector<Integer> checkProduct = getAllProductID();
		Integer x = 0;
		Integer check = ProductID;
		System.out.println(checkStock);
		if(checkProduct.contains(check)){
			Integer loc = checkProduct.indexOf(ProductID);	
			System.out.println(loc);
			if(Stock==1){
				x = 1;
			} else{
				x = 0;
			}
		}
		System.out.println(x);
		return x;
	}
	
	public void addProduct(String Name, String Description, Integer Price, Integer Stock){
		
		Vector<Integer> ProID = new Vector<Integer>();
		ProID = ProductHandler.getInstance().getAllProductID();
		Integer lastid = ProID.lastElement()+1;
		
		if(Stock<=0) {
			PopUpController.getInstance().notvalidstock();
		}if(Price<=0) {
			PopUpController.getInstance().notvalidprice();
		}if(Description.length()>250) {
			PopUpController.getInstance().desctoolong();
		}if(Name.isEmpty()) {
			PopUpController.getInstance().namecannotbeempty();
		}else if(Name.isEmpty()!=true && Description.length()<251 && Price>0 && Stock>0) {
			product.addProduct(lastid, Name, Description, Price, Stock);
			PopUpController.getInstance().insertsuccess();
		}
		
	}

	public void updateProduct(Integer ProductID, String Name, String Description, Integer Price, Integer Stock){	
		
		Vector<Integer> ProID = new Vector<Integer>();
		ProID = ProductHandler.getInstance().getAllProductID();
		
		if(ProID.contains(ProductID) != true) {
			PopUpController.getInstance().idnotfound();
		}else if(ProID.contains(ProductID)) {
			if(Stock<=0) {
				PopUpController.getInstance().notvalidstock();
			}if(Price<=0) {
				PopUpController.getInstance().notvalidprice();
			}if(Description.length()>250) {
				PopUpController.getInstance().desctoolong();
			}if(Name.isEmpty()) {
				PopUpController.getInstance().namecannotbeempty();
			}else if(Name.isEmpty()!=true && Description.length()<251 && Price>0 && Stock>0) {
				product.updateProduct(ProductID, Name, Description, Price, Stock);
				PopUpController.getInstance().updatesuccess();
			}
		}
		
	}
	
	public void deleteProduct(Integer ProductID){	
		
		Vector<Integer> ProID = new Vector<Integer>();
		ProID = ProductHandler.getInstance().getAllProductID();
		
		if(ProID.contains(ProductID) != true) {
			PopUpController.getInstance().idnotfound();
		}else if(ProID.contains(ProductID)) {
			product.deleteProduct(ProductID);
			PopUpController.getInstance().productdel();
		}
		
	}
	
}
