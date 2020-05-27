package controller;

import java.util.Vector;
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
	
}
