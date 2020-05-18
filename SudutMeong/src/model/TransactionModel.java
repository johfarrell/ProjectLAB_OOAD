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
	
	public TransactionModel(Integer transactionid, String purchasedate, Integer voucherid, Integer employeeid, String paymenttype) {
		this.TransactionID=transactionid;
		this.PurchaseDate=purchasedate;
		this.VoucherID=voucherid;
		this.EmployeeID=employeeid;
		this.PaymentType=paymenttype;
	}
	
	public Vector<TransactionModel> getAllTransaction(Integer Month, Integer Year){
		con = Connect.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM transactione WHERE MONTH(purchase_datetime) = ?  AND YEAR(purchase_datetime) = ?");
		Vector<TransactionModel> em = new Vector<TransactionModel>();
		index = 1;
		try {
			ps.setInt(1, Month);
			ps.setInt(1, Year);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				em.add(new TransactionModel(rs.getInt("transactionID"), rs.getString("purhcase_datetime"), rs.getInt("voucherID"), 
						rs.getInt("employeeID"), rs.getString("paymentType")));
				index++;
			}
		} catch (SQLException e) {
			
		}
		return em;
	}

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
	
	
}
