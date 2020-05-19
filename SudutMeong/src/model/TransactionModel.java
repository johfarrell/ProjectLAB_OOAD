package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import sqlConnect.Connect;

public class TransactionModel {
	private Integer TransactionID;
	private String PurchaseDate;
	private Integer VoucherID;
	private Integer EmployeeID;
	private String PaymentType;
	
	private Connect con;
	Integer index;
	
	public TransactionModel() {
		
	}
	
	public TransactionModel(Integer transactionid, String purchasedate, Integer voucherid, Integer employeeid, String paymenttype) {
		this.TransactionID=transactionid;
		this.PurchaseDate=purchasedate;
		this.VoucherID=voucherid;
		this.EmployeeID=employeeid;
		this.PaymentType=paymenttype;
	}
	
	public Vector<TransactionModel> getAllTransaction(String Month, String Year){
		con = Connect.getConnection();
		String Query = "SELECT * FROM transaction WHERE MONTH(purchase_datetime) = " + Month + " AND YEAR(purchase_datetime) = " + Year;
		PreparedStatement ps = con.prepareStatement(Query);
		Vector<TransactionModel> em = new Vector<TransactionModel>();
		index = 1;
		try {
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				em.add(new TransactionModel(rs.getInt("transactionID"), rs.getString("purchase_datetime"), rs.getInt("voucherID"), 
						rs.getInt("employeeID"), rs.getString("paymentType")));
				index++;
			}
		} catch (SQLException e) {
			
		}
		return em;
	}
	
	/*public Vector<TransactionModel> getAllTransaction(){
		con = Connect.getConnection();
		//ResultSet rs = con.executeQuery("SELECT * FROM transaction WHERE MONTH(purchase_datetime) = 5  AND YEAR(purchase_datetime) = 2020");
		ResultSet rs = con.executeQuery("SELECT * FROM transaction");
		Vector<TransactionModel> em = new Vector<TransactionModel>();
		index = 1;
		try {
			while(rs.next()) {
				em.add(new TransactionModel(rs.getInt("transactionID"), rs.getString("purchase_datetime"), rs.getInt("voucherID"), 
						rs.getInt("employeeID"), rs.getString("paymentType")));
				index++;
			}
		} catch (SQLException e) {
			
		}
		return em;
	}*/

	public Integer getTransactionID() {
		return TransactionID;
	}

	public void setTransactionID(Integer transactionID) {
		TransactionID = transactionID;
	}

	public String getPurchaseDate() {
		return PurchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		PurchaseDate = purchaseDate;
	}

	public Integer getVoucherID() {
		return VoucherID;
	}

	public void setVoucherID(Integer voucherID) {
		VoucherID = voucherID;
	}

	public Integer getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		EmployeeID = employeeID;
	}

	public String getPaymentType() {
		return PaymentType;
	}

	public void setPaymentType(String paymentType) {
		PaymentType = paymentType;
	}

	public Connect getCon() {
		return con;
	}

	public void setCon(Connect con) {
		this.con = con;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}
}
