package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import model.ProductModel;
import model.TransactionItemModel;
import model.TransactionModel;
import view.ViewM;
import view.ViewMDetail;

public class TransactionHandler {
	
	private static TransactionHandler transactionHandler;
	private TransactionModel transaction = new TransactionModel();
	private TransactionItemModel transactionitem = new TransactionItemModel();
	public static String m;
	public static String y;
	
	public static TransactionHandler getInstance(){
		if(transactionHandler == null){
			return new TransactionHandler();
		} else{
			return transactionHandler;
		}
	}
	
	public ViewM view(){
		return new ViewM();
	}
	
	public Vector<TransactionModel> getAllTransaction(String Month, String Year){
		return transaction.getAllTransaction(Month, Year);
	}
	
	public Vector<TransactionItemModel> getAllTransactionItem(String X){
		return transactionitem.getAllTransactionItem(X);
	}
	
	public ViewMDetail viewMDetail() {
		return new ViewMDetail();
	}
	
	public void addProductToCart(Integer ProductID, Integer Quantity) {
		Integer X = ProductHandler.getInstance().getProduct(ProductID, Quantity);
		if(X==1){
			System.out.println("Product Found");
			CartHandler.getInstance().addToCart(ProductID, Quantity);
		} else{
			System.out.println("Product Not Found");
		}
	}
}
