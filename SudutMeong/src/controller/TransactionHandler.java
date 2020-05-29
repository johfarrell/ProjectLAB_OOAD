package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import model.ProductModel;
import model.TransactionItemModel;
import model.TransactionModel;
import view.ViewHRM;
import view.ViewM;
import view.ViewMDetail;
import view.ViewTM;

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
	
	public boolean addProductToCart(Integer ProductID, Integer Quantity) {
		
		Vector<Integer> ProID = new Vector<Integer>();
		ProID = ProductHandler.getInstance().getAllProductID();
		
		if(ProID.contains(ProductID) != true) {
			PopUpController.getInstance().idnotfound();
		}else if(ProID.contains(ProductID)) {
			Integer index = ProID.indexOf(ProductID);
			Vector<ProductModel> product = new Vector<ProductModel>();
			product = ProductHandler.getInstance().getAllProduct();
			
			ProductModel checkstock = product.elementAt(index);
			String ProductName = checkstock.getName();
			
			if(Quantity == 0 || Quantity>checkstock.getStock()) {
				PopUpController.getInstance().checkquantity();
			}else if(Quantity != 0 && Quantity<=checkstock.getStock()) {
				CartHandler.getInstance().addToCart(ProductID, ProductName, Quantity);
				return true;
			}
		}
		return false;
	}
	
	public void addCheckOutVoucher(Integer VoucherID) {
		Vector<Integer> VouID = new Vector<Integer>();
		VouID = VoucherHandler.getInstance().getAllVoucherId();
		
		if(VouID.contains(VoucherID) != true) {
			PopUpController.getInstance().idnotfound();
		}else if(VouID.contains(VoucherID)){
			//Aktivin voucher potongannya
			//Update price nya pake vocuher potongan
		}
	}
	
	public void checkoutTransaction() throws ParseException {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		Date today_timestamp = formatter.parse(formatter.format(today));
		
		//Checkout, catat date nya ke database
		//Alter voucherID nya jadi used (kalo pake voucher)
	}
}
