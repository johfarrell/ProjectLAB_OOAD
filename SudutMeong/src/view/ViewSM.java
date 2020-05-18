package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.HRMController;
import controller.PMController;
import controller.SMController;
import model.EmployeeModel;
import model.ProductModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSM window = new ViewSM();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		frame = new JFrame();
		frame.setBounds(100, 100, 670, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 634, 130);
		frame.getContentPane().add(scrollPane);
		
		scrollPane.setViewportView(table);
		
		JLabel lblUpdateProduct = new JLabel("UPDATE PRODUCT");
		lblUpdateProduct.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUpdateProduct.setBounds(330, 205, 182, 14);
		frame.getContentPane().add(lblUpdateProduct);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(330, 230, 46, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblName_1 = new JLabel("Name:");
		lblName_1.setBounds(330, 258, 46, 14);
		frame.getContentPane().add(lblName_1);
		
		JLabel lblDescription_1 = new JLabel("Description:");
		lblDescription_1.setBounds(330, 289, 78, 14);
		frame.getContentPane().add(lblDescription_1);
		
		JLabel lblPrice_1 = new JLabel("Price:");
		lblPrice_1.setBounds(330, 319, 46, 14);
		frame.getContentPane().add(lblPrice_1);
		
		updateID = new JTextField();
		updateID.setBounds(405, 227, 160, 20);
		frame.getContentPane().add(updateID);
		updateID.setColumns(10);
		
		updateName = new JTextField();
		updateName.setBounds(405, 255, 160, 20);
		frame.getContentPane().add(updateName);
		updateName.setColumns(10);
		
		updateDescription = new JTextField();
		updateDescription.setBounds(405, 286, 160, 20);
		frame.getContentPane().add(updateDescription);
		updateDescription.setColumns(10);
		
		updatePrice = new JTextField();
		updatePrice.setBounds(405, 316, 160, 20);
		frame.getContentPane().add(updatePrice);
		updatePrice.setColumns(10);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnUpdate.setBounds(476, 347, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JLabel lblDeleteProduct = new JLabel("DELETE PRODUCT");
		lblDeleteProduct.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDeleteProduct.setBounds(75, 416, 151, 14);
		frame.getContentPane().add(lblDeleteProduct);
		
		JLabel lblId_1 = new JLabel("ID:");
		lblId_1.setBounds(75, 441, 46, 14);
		frame.getContentPane().add(lblId_1);
		
		deleteID = new JTextField();
		deleteID.setBounds(102, 438, 160, 20);
		frame.getContentPane().add(deleteID);
		deleteID.setColumns(10);
		
		btnDelete = new JButton("DELETE");
		btnDelete.setBounds(173, 465, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		btnRefresh = new JButton("REFRESH");
		btnRefresh.setBounds(555, 152, 89, 23);
		frame.getContentPane().add(btnRefresh);
		
		lblInsertProduct = new JLabel("INSERT PRODUCT");
		lblInsertProduct.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInsertProduct.setBounds(63, 207, 163, 14);
		frame.getContentPane().add(lblInsertProduct);
		
		lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(63, 230, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lblDescription = new JLabel("Description:");
		lblDescription.setBounds(63, 258, 72, 14);
		frame.getContentPane().add(lblDescription);
		
		lblPrice = new JLabel("Price:");
		lblPrice.setBounds(63, 289, 72, 14);
		frame.getContentPane().add(lblPrice);
		
		lblStock = new JLabel("Stock:");
		lblStock.setBounds(63, 319, 46, 14);
		frame.getContentPane().add(lblStock);
		
		insertName = new JTextField();
		insertName.setBounds(134, 227, 160, 20);
		frame.getContentPane().add(insertName);
		insertName.setColumns(10);
		
		insertDescription = new JTextField();
		insertDescription.setBounds(134, 255, 160, 20);
		frame.getContentPane().add(insertDescription);
		insertDescription.setColumns(10);
		
		insertPrice = new JTextField();
		insertPrice.setBounds(134, 286, 160, 20);
		frame.getContentPane().add(insertPrice);
		insertPrice.setColumns(10);
		
		insertStock = new JTextField();
		insertStock.setBounds(134, 316, 160, 20);
		frame.getContentPane().add(insertStock);
		insertStock.setColumns(10);
		
		btnInsert = new JButton("INSERT");
		btnInsert.setBounds(205, 347, 89, 23);
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
		product = SMController.getInstance().getAllProduct();
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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnInsert)){
			String Name = insertName.getText();
			String Description = insertDescription.getText();
			Integer Price = Integer.parseInt(insertPrice.getText());
			Integer Stock = Integer.parseInt(insertStock.getText());
			SMController.getInstance().addProduct(Name, Description, Price, Stock);
			
		} else if(e.getSource().equals(btnUpdate)){
			Integer ProductID = Integer.parseInt(updateID.getText());
			String Name = updateName.getText();
			String Description = updateDescription.getText();
			Integer Price = Integer.parseInt(updatePrice.getText());
				SMController.getInstance().updateProduct(ProductID, Name, Description, Price);
				
		} else if(e.getSource().equals(btnDelete)){
			Integer ProductID = Integer.parseInt(deleteID.getText());
			SMController.getInstance().deleteProduct(ProductID);
			
		} else if(e.getSource().equals(btnRefresh)) {
			   frame.dispose();
			   new ViewSM();
		}
	}
}
