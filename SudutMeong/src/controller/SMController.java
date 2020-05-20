package controller;

import java.util.Vector;
import model.ProductModel;
import view.ViewSM;

public class SMController {
	
	private static SMController smController;
	private ProductModel product = new ProductModel();
	
	public static SMController getInstance(){
		if(smController == null){
			return new SMController();
		} else{
			return smController;
		}
	}
	
	public ViewSM view(){
		return new ViewSM();
	}
	
	public Vector<ProductModel> getAllProduct(){
		return product.getAllProduct();
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
