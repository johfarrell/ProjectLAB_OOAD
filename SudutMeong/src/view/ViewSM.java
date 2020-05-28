package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.EmployeeHandler;
import controller.VoucherHandler;
import controller.ProductHandler;
import model.EmployeeModel;
import model.ProductModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class ViewSM implements ActionListener{
	
	private DefaultTableModel dtm;
	private JFrame frame;
	private JTable table;
	private JTextField updateID;
	private JTextField updateName;
	private JTextField updateDescription;
	private JTextField updatePrice;
	private JButton btnUpdate;
	private JTextField deleteID;
	private JButton btnDelete;
	private JButton btnRefresh;
	private JLabel lblInsertProduct;
	private JLabel lblNewLabel;
	private JLabel lblDescription;
	private JLabel lblPrice;
	private JLabel lblStock;
	private JTextField insertName;
	private JTextField insertDescription;
	private JTextField insertPrice;
	private JTextField insertStock;
	private JButton btnInsert;
	private JTextField updateStock;

	/**
	 * Create the application.
	 */
	public ViewSM() {
		table();
		initialize();
		addlistener();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Storage Manager");
		frame.setBounds(100, 100, 670, 585);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 634, 130);
		frame.getContentPane().add(scrollPane);
		
		scrollPane.setViewportView(table);
		
		JLabel lblUpdateProduct = new JLabel("UPDATE PRODUCT");
		lblUpdateProduct.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUpdateProduct.setBounds(370, 206, 182, 14);
		frame.getContentPane().add(lblUpdateProduct);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(370, 231, 46, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblName_1 = new JLabel("Name:");
		lblName_1.setBounds(370, 259, 46, 14);
		frame.getContentPane().add(lblName_1);
		
		JLabel lblDescription_1 = new JLabel("Description:");
		lblDescription_1.setBounds(370, 290, 78, 14);
		frame.getContentPane().add(lblDescription_1);
		
		JLabel lblPrice_1 = new JLabel("Price:");
		lblPrice_1.setBounds(370, 320, 46, 14);
		frame.getContentPane().add(lblPrice_1);
		
		JLabel lblStock_1 = new JLabel("Stock:");
		lblStock_1.setBounds(370, 350, 46, 14);
		frame.getContentPane().add(lblStock_1);
		
		updateID = new JTextField();
		updateID.setBounds(445, 228, 160, 20);
		frame.getContentPane().add(updateID);
		updateID.setColumns(10);
		
		updateName = new JTextField();
		updateName.setBounds(445, 256, 160, 20);
		frame.getContentPane().add(updateName);
		updateName.setColumns(10);
		
		updateDescription = new JTextField();
		updateDescription.setBounds(445, 287, 160, 20);
		frame.getContentPane().add(updateDescription);
		updateDescription.setColumns(10);
		
		updatePrice = new JTextField();
		updatePrice.setBounds(445, 317, 160, 20);
		frame.getContentPane().add(updatePrice);
		updatePrice.setColumns(10);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		updateStock = new JTextField();
		updateStock.setBounds(445, 348, 160, 20);
		frame.getContentPane().add(updateStock);
		updateStock.setColumns(10);
		btnUpdate.setBounds(516, 379, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JLabel lblDeleteProduct = new JLabel("DELETE PRODUCT");
		lblDeleteProduct.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDeleteProduct.setBounds(50, 414, 151, 14);
		frame.getContentPane().add(lblDeleteProduct);
		
		JLabel lblId_1 = new JLabel("ID:");
		lblId_1.setBounds(50, 439, 46, 14);
		frame.getContentPane().add(lblId_1);
		
		deleteID = new JTextField();
		deleteID.setBounds(121, 439, 160, 20);
		frame.getContentPane().add(deleteID);
		deleteID.setColumns(10);
		
		btnDelete = new JButton("DELETE");
		btnDelete.setBounds(192, 470, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(560, 143, 80, 25);
		frame.getContentPane().add(btnRefresh);
		
		lblInsertProduct = new JLabel("INSERT PRODUCT");
		lblInsertProduct.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInsertProduct.setBounds(50, 206, 163, 14);
		frame.getContentPane().add(lblInsertProduct);
		
		lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(50, 229, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lblDescription = new JLabel("Description:");
		lblDescription.setBounds(50, 257, 72, 14);
		frame.getContentPane().add(lblDescription);
		
		lblPrice = new JLabel("Price:");
		lblPrice.setBounds(50, 288, 72, 14);
		frame.getContentPane().add(lblPrice);
		
		lblStock = new JLabel("Stock:");
		lblStock.setBounds(50, 318, 46, 14);
		frame.getContentPane().add(lblStock);
		
		insertName = new JTextField();
		insertName.setBounds(121, 226, 160, 20);
		frame.getContentPane().add(insertName);
		insertName.setColumns(10);
		
		insertDescription = new JTextField();
		insertDescription.setBounds(121, 254, 160, 20);
		frame.getContentPane().add(insertDescription);
		insertDescription.setColumns(10);
		
		insertPrice = new JTextField();
		insertPrice.setBounds(121, 285, 160, 20);
		frame.getContentPane().add(insertPrice);
		insertPrice.setColumns(10);
		
		insertStock = new JTextField();
		insertStock.setBounds(121, 315, 160, 20);
		frame.getContentPane().add(insertStock);
		insertStock.setColumns(10);
		
		btnInsert = new JButton("INSERT");
		btnInsert.setBounds(192, 346, 89, 23);
		frame.getContentPane().add(btnInsert);
	}
	
	void table(){
		Vector<String> header = new Vector<String>();
		header.add("ID");
		header.add("Name");
		header.add("Description");
		header.add("Price");
		header.add("Stock");
		Vector<ProductModel> product = new Vector<ProductModel>();
		product = ProductHandler.getInstance().getAllProduct();
		dtm = new DefaultTableModel(header,0);
		table = new JTable(dtm);
		table.getTableHeader();
		for(ProductModel product2 : product){
			Vector<Object> data = new Vector<Object>();
			data.add(product2.getProductID());
			data.add(product2.getName());
			data.add(product2.getDescription());
			data.add(product2.getPrice());
			data.add(product2.getStock());
			dtm.addRow(data);
		}
	}
	
	void addlistener(){
		btnInsert.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnRefresh.addActionListener(this);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Integer row = table.getSelectedRow();
				Integer ID = (Integer)table.getValueAt(row, 0);
				String Name = (String)table.getValueAt(row, 1);
				String Description = (String)table.getValueAt(row, 2);
				Integer Price = (Integer)table.getValueAt(row, 3);
				Integer Stock = (Integer)table.getValueAt(row,4);

				updateID.setText(ID+"");
				updateName.setText(Name+"");
				updateDescription.setText(Description+"");
				updatePrice.setText(Price+"");
				updateStock.setText(Stock+"");
				
				deleteID.setText(ID+"");
				
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnInsert)){
			
			Integer Price=0;
			Integer Stock=0;
			
			String Name = insertName.getText();
			String Description = insertDescription.getText();
			
			try {
				Price = Integer.parseInt(insertPrice.getText());
			} catch (Exception e2) {
				// TODO: handle exception
				Price = 0;
			}
			
			try {
				Stock = Integer.parseInt(insertStock.getText());
			} catch (Exception e2) {
				// TODO: handle exception
				Stock = 0;
			}
			
			ProductHandler.getInstance().addProduct(Name, Description, Price, Stock);
			
		} else if(e.getSource().equals(btnUpdate)){
			
			Integer Price=0;
			Integer Stock=0;
			Integer ProductID=0;
			
			
			String Name = updateName.getText();
			String Description = updateDescription.getText();
			
			try {
				Price = Integer.parseInt(updatePrice.getText());
			} catch (Exception e2) {
				Price = 0;
			}
			try {
				Stock = Integer.parseInt(updateStock.getText());
			} catch (Exception e2) {
				Stock = 0;
			}
			try {
				ProductID = Integer.parseInt(updateID.getText());
			} catch (Exception e2) {
				ProductID = 0;
			}
			
			ProductHandler.getInstance().updateProduct(ProductID, Name, Description, Price, Stock);
				
		} else if(e.getSource().equals(btnDelete)){
			
			Integer ProductID=0;
			
			try {
				ProductID = Integer.parseInt(deleteID.getText());
			} catch (Exception e2) {
				ProductID = 0;
			}
			ProductHandler.getInstance().deleteProduct(ProductID);
			
		} else if(e.getSource().equals(btnRefresh)) {
			   frame.dispose();
			   new ViewSM();
		}
	}
}
