package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import sqlConnect.Connect;

public class VoucherModel {
	
	private Integer VoucherID;
	private String Date;
	private String Status;
	private Float Discount;
	
	private Connect con;
	Integer index;

	public VoucherModel() {
		
	}
	
	public VoucherModel(Integer voucherid, String date, String status, Float discount) {
		this.VoucherID=voucherid;
		this.Date=date;
		this.Status=status;
		this.Discount=discount;
	}
	
	public Vector<VoucherModel> getAllVoucher(){
		con = Connect.getConnection();
		ResultSet rs = con.executeQuery("SELECT * FROM voucher");
		Vector<VoucherModel> em = new Vector<VoucherModel>();
		index = 1;
		try {
			while(rs.next()) {
				em.add(new VoucherModel(rs.getInt("voucherID"), rs.getString("validDate"), rs.getString("status"), rs.getFloat("discount")));
				index++;
			}
		} catch (SQLException e) {
			
		}
		System.out.println(index);
		return em;
	}
	
	public Vector<Integer> getAllVoucherId(){
		con = Connect.getConnection();
		ResultSet rs = con.executeQuery("SELECT voucherID FROM voucher");
		Vector<Integer> em = new Vector<Integer>();
		index = 1;
		try {
			while(rs.next()) {
				em.add(rs.getInt("voucherID"));
				index++;
			}
		} catch (SQLException e) {
			
		}
	
		return em;
	}
	
	public void addVoucher(float Discount, String ValidDate, String Status, Integer last){
		con = Connect.getConnection();
		getAllVoucher();
		PreparedStatement ps = con.prepareStatement("INSERT INTO voucher VALUES (?, ?, ?, ?)");
		try {
			ps.setInt(1, last);
			ps.setFloat(2, Discount);
			ps.setString(3, ValidDate);
			ps.setString(4, Status);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateVoucher(Integer VoucherID, float Discount, String ValidDate){
		con = Connect.getConnection();
		getAllVoucher();
		PreparedStatement ps = con.prepareStatement("UPDATE `voucher` SET `discount`= ?,`validDate`= ? WHERE voucherID = ?");
		try {
			ps.setFloat(1, Discount);
			ps.setString(2, ValidDate);
			ps.setInt(3, VoucherID);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteVoucher(Integer employeeID){
		con = Connect.getConnection();
		getAllVoucher();
		PreparedStatement ps = con.prepareStatement("DELETE FROM `voucher` WHERE voucherID = ?");
		try {
			ps.setInt(1, employeeID);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Integer getVoucherID() {
		return VoucherID;
	}

	public void setVoucherID(Integer voucherID) {
		VoucherID = voucherID;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Float getDiscount() {
		return Discount;
	}

	public void setDiscount(Float discount) {
		Discount = discount;
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
