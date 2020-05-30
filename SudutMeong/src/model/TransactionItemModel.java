package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import sqlConnect.Connect;

public class TransactionItemModel {
	private Integer TransactionID;
	private Integer ProductID;
	private Integer Quantity;
	
	private Connect con;
	Integer index;
	
public TransactionItemModel() {
		
	}
	
	public TransactionItemModel(Integer transactionid, Integer productid, Integer quantity) {
		this.TransactionID=transactionid;
		this.ProductID=productid;
		this.Quantity=quantity;
	}
	
	public Vector<TransactionItemModel> getAllTransactionItem(String ID){
		con = Connect.getConnection();
		String Query = "SELECT * FROM transactionitem WHERE transactionID = " + ID;
		PreparedStatement ps = con.prepareStatement(Query);
		Vector<TransactionItemModel> em = new Vector<TransactionItemModel>();
		index = 1;
		try {
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				em.add(new TransactionItemModel(rs.getInt("transactionID"), rs.getInt("productID"), 
						rs.getInt("quantity")));
				index++;
			}
		} catch (SQLException e) {
			
		}
		return em;
	}
	
	public Vector<TransactionItemModel> getAllTransactionItem(){
		con = Connect.getConnection();
		ResultSet rs = con.executeQuery("SELECT * FROM transactionitem");
		Vector<TransactionItemModel> em = new Vector<TransactionItemModel>();
		index = 1;
		try {
			while(rs.next()) {
				em.add(new TransactionItemModel(rs.getInt("transactionID"), rs.getInt("productID"), 
						rs.getInt("quantity")));
				index++;
			}
		} catch (SQLException e) {
			
		}
		return em;
	}
	
	public Integer getIndex(){
		getAllTransactionItem();
		return index;
	}
	
	public void addTransactionItem(Integer transactionid, Integer productid, Integer quantity){
		con = Connect.getConnection();
		//getAllTransactionItem();
		PreparedStatement ps = con.prepareStatement("INSERT INTO transactionitem VALUES (?, ?, ?)");
		try {
			ps.setInt(1, transactionid);
			ps.setInt(2, productid);
			ps.setInt(3, quantity);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Integer getTransactionID() {
		return TransactionID;
	}

	public void setTransactionID(Integer transactionID) {
		TransactionID = transactionID;
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
