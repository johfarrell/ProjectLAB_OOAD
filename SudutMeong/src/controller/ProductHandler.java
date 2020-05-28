package controller;

import java.util.Vector;

import model.EmployeeModel;
import model.ProductModel;
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
	
	public Vector<String> getProductID(){
		return product.checkProductID();
	}
	
	public Vector<Integer> getStock(){
		return product.checkStock();
	}
	
	
	public  Integer getProduct(Integer ProductID, Integer Stock){
		Vector<Integer> checkStock = getStock();
		Vector<String> checkProduct = getProductID();
		Integer x = 0;
		String check = ProductID.toString();
		System.out.println(checkStock);
		if(checkProduct.contains(check)){
			Integer loc = checkProduct.indexOf(ProductID);	
			System.out.println(loc);
			if(Stock==1){
				x = 1;
			} else{
				x = 0;
			}
			/*if(checkStock.elementAt(posisi+2)>=Stock){
				x = 1;
			} else{
				x = 0;
			}*/
		}
		System.out.println(x);
		return x;
	}
	
	public void addProduct(String Name, String Description, Integer Price, Integer Stock){
			product.addProduct(Name, Description, Price, Stock);
			System.out.println("Insert Success"); //CONSOLE
	}

	public void updateProduct(Integer ProductID, String Name, String Description, Integer Price, Integer Stock){	
		product.updateProduct(ProductID, Name, Description, Price, Stock);
		System.out.println("Update Success"); //CONSOLE
	}
	
	public void deleteProduct(Integer ProductID){	
		product.deleteProduct(ProductID);
		System.out.println("Delete Success"); //CONSOLE
	}
	
}
