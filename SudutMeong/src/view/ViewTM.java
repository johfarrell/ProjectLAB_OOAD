package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import controller.CartHandler;
import controller.ProductHandler;
import controller.TransactionHandler;
import controller.VoucherHandler;
import model.CartModel;
import model.ProductModel;
import model.VoucherModel;
import javax.swing.JComboBox;

public class ViewTM implements ActionListener{
	
	private DefaultTableModel dtm;
	private JFrame frame;
	private JTextField addProductID;
	private JTextField addQuantity;
	private JTextField checkoutVoucherID;
	private JTable table;
	private JButton btnAdd;
	private JButton btnApply;
	private JButton btnCheckout;
	private JTable table_1;
	private JComboBox<?> paymentmethod;
	private JTextField updateCartQuantity;
	private JButton btnUpdateCart;


	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public ViewTM() {
		table();
		table_1();
		initialize();
		addlistener();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 670, 740);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 629, 130);
		frame.getContentPane().add(scrollPane);
		
		scrollPane.setViewportView(table);
		
		JLabel lblA = new JLabel("ADD TO CART");
		lblA.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblA.setBounds(40, 165, 321, 14);
		frame.getContentPane().add(lblA);
		
		JLabel lblProductid = new JLabel("ProductID:");
		lblProductid.setBounds(40, 194, 65, 14);
		frame.getContentPane().add(lblProductid);
		
		addProductID = new JTextField();
		addProductID.setBounds(112, 190, 160, 20);
		frame.getContentPane().add(addProductID);
		addProductID.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(40, 233, 65, 14);
		frame.getContentPane().add(lblQuantity);
		
		addQuantity = new JTextField();
		addQuantity.setBounds(112, 229, 160, 20);
		frame.getContentPane().add(addQuantity);
		addQuantity.setColumns(10);
		
		btnAdd = new JButton("ADD");
		btnAdd.setBounds(183, 268, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		JLabel lblCheckout = new JLabel("CHECKOUT");
		lblCheckout.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCheckout.setBounds(40, 510, 140, 14);
		frame.getContentPane().add(lblCheckout);
		
		JLabel lblVoucherid = new JLabel("VoucherID:");
		lblVoucherid.setBounds(40, 539, 71, 14);
		frame.getContentPane().add(lblVoucherid);
		
		checkoutVoucherID = new JTextField();
		checkoutVoucherID.setBounds(152, 536, 160, 20);
		frame.getContentPane().add(checkoutVoucherID);
		checkoutVoucherID.setColumns(10);
		
		btnCheckout = new JButton("CHECKOUT");
		btnCheckout.setBounds(310, 642, 100, 23);
		frame.getContentPane().add(btnCheckout);
		
		JLabel lblTotalPrice = new JLabel("Total Price:");
		lblTotalPrice.setBounds(40, 575, 71, 14);
		frame.getContentPane().add(lblTotalPrice);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrice.setBounds(180, 575, 132, 14);
		frame.getContentPane().add(lblPrice);
		
		btnApply = new JButton("APPLY");
		btnApply.setBounds(321, 535, 89, 23);
		frame.getContentPane().add(btnApply);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 369, 634, 130);
		frame.getContentPane().add(scrollPane_1);
		
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel = new JLabel("CART:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 350, 56, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Payment Method:");
		lblNewLabel_1.setBounds(40, 610, 110, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		String[] method = {"Cash", "Credit"};
		paymentmethod = new JComboBox<Object>(method);
		paymentmethod.setBounds(152, 607, 100, 22);
		frame.getContentPane().add(paymentmethod);
		
		JLabel lblNewLabel_2 = new JLabel("Rp.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(152, 574, 35, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		updateCartQuantity = new JTextField();
		updateCartQuantity.setBounds(594, 507, 50, 22);
		frame.getContentPane().add(updateCartQuantity);
		updateCartQuantity.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Quantity:");
		lblNewLabel_3.setBounds(526, 510, 56, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		btnUpdateCart = new JButton("UPDATE");
		btnUpdateCart.setBounds(526, 534, 118, 25);
		frame.getContentPane().add(btnUpdateCart);
	}
	
	void table_1(){
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
	
	void table(){
		Vector<String> header = new Vector<String>();
		header.add("ProductID");
		header.add("Product Name");
		header.add("Quantity");
		Vector<CartModel> cart = new Vector<CartModel>();
		cart = CartHandler.getInstance().getAllItem();
		dtm = new DefaultTableModel(header,0);
		table = new JTable(dtm);
		table.getTableHeader();
		for(CartModel cart2 : cart){
			Vector<Object> data = new Vector<Object>();
			data.add(cart2.getProductID());
			data.add(cart2.getProductName());
			data.add(cart2.getQuantity());
			dtm.addRow(data);
		}
	}
	
	void addlistener(){
		btnAdd.addActionListener(this);
		btnApply.addActionListener(this);
		btnCheckout.addActionListener(this);
		btnUpdateCart.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnAdd)){
			Integer ProductID=0;
			Integer Quantity=0;
			
			try {
				ProductID = Integer.parseInt(addProductID.getText());
			} catch (Exception e2) {
				ProductID=0;
			}
			try {
				Quantity = Integer.parseInt(addQuantity.getText());	
			} catch (Exception e2) {
				Quantity=0;
			}
			TransactionHandler.getInstance().addProductToCart(ProductID, Quantity);
			
			
		}else if(e.getSource().equals(btnApply)) {
			Integer VoucherID=0;
			try {
				VoucherID = Integer.parseInt(checkoutVoucherID.getText());
			} catch (Exception e2) {
				VoucherID = 0;
			}
			
			TransactionHandler.getInstance().addCheckOutVoucher(VoucherID);
			
		}else if(e.getSource().equals(btnUpdateCart)) {
			Integer Quantity=-1;
			try {
				Quantity = Integer.parseInt(updateCartQuantity.getText());
			} catch (Exception e2) {
				Quantity=-1;
			}
			
			
		}else if(e.getSource().equals(btnCheckout)) {
			try {
				TransactionHandler.getInstance().checkoutTransaction();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
}
