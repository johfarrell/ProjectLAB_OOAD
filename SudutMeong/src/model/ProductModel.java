package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import sqlConnect.Connect;

public class ProductModel {
	
	private Integer ProductID;
	private String Name;
	private String Description;
	private Integer Price;
	private Integer Stock;
	
	private Connect con;
	Integer index;

	public ProductModel() {

	}
	
	public ProductModel(Integer productid, String name, String description, Integer price, Integer stock) {
		this.ProductID=productid;
		this.Name=name;
		this.Description=description;
		this.Price=price;
		this.Stock=stock;
	}
	
	public Vector<ProductModel> getAllProduct(){
		con = Connect.getConnection();
		ResultSet rs = con.executeQuery("SELECT * FROM product");
		Vector<ProductModel> em = new Vector<ProductModel>();
		index = 1;
		try {
			while(rs.next()) {
				em.add(new ProductModel(rs.getInt("productID"), rs.getString("name"), rs.getString("description"), rs.getInt("price"),
						rs.getInt("stock")));
				index++;
			}
		} catch (SQLException e) {
			
		}
		return em;
	}
	
	public void addProduct(Integer Last, String Name, String Description, Integer Price, Integer Stock){
		con = Connect.getConnection();
		getAllProduct();
		PreparedStatement ps = con.prepareStatement("INSERT INTO product VALUES (?, ?, ?, ?, ?)");
		try {
			ps.setInt(1, Last);
			ps.setString(2, Name);
			ps.setString(3, Description);
			ps.setInt(4, Price);
			ps.setInt(5, Stock);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateProduct(Integer ProductID, String Name, String Description, Integer Price, Integer Stock){
		con = Connect.getConnection();
		getAllProduct();
		PreparedStatement ps = con.prepareStatement("UPDATE `product` SET `name`=?,`description`=?,`price`=?,`stock`=? WHERE productID=?");
		try {
			ps.setString(1, Name);
			ps.setString(2, Description);
			ps.setInt(3, Price);
			ps.setInt(4, Stock);
			ps.setInt(5, ProductID);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteProduct(Integer ProductID){
		con = Connect.getConnection();
		getAllProduct();
		PreparedStatement ps = con.prepareStatement("DELETE FROM `product` WHERE productID = ?");
		try {
			ps.setInt(1, ProductID);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Vector<Integer> getAllProductID(){
		con = Connect.getConnection();
		ResultSet rs = con.executeQuery("SELECT productID FROM product");
		Vector<Integer> emuser = new Vector<Integer>();
		index = 1;
		try {
			while(rs.next()) {
				emuser.add(rs.getInt("productID"));
				index++;
			}
		} catch (SQLException e) {
			
		}
		return emuser;
	}
	
	public Vector<Integer> checkStock(){
		con = Connect.getConnection();
		ResultSet rs = con.executeQuery("SELECT stock FROM product");
		Vector<Integer> emuser = new Vector<Integer>();
		index = 1;
		try {
			while(rs.next()) {
				emuser.add(rs.getInt("stock"));
				index++;
			}
		} catch (SQLException e) {
			
		}
		return emuser;
	}

	public Integer getProductID() {
		return ProductID;
	}

	public void setProductID(Integer productID) {
		ProductID = productID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Integer getPrice() {
		return Price;
	}

	public void setPrice(Integer price) {
		Price = price;
	}

	public Integer getStock() {
		return Stock;
	}

	public void setStock(Integer stock) {
		Stock = stock;
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
