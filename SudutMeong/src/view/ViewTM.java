package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		checkoutVoucherID.setBounds(112, 536, 160, 20);
		frame.getContentPane().add(checkoutVoucherID);
		checkoutVoucherID.setColumns(10);
		
		btnCheckout = new JButton("CHECKOUT");
		btnCheckout.setBounds(40, 610, 100, 23);
		frame.getContentPane().add(btnCheckout);
		
		JLabel lblTotalPrice = new JLabel("Total Price:");
		lblTotalPrice.setBounds(40, 575, 71, 14);
		frame.getContentPane().add(lblTotalPrice);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrice.setBounds(122, 574, 172, 14);
		frame.getContentPane().add(lblPrice);
		
		btnApply = new JButton("APPLY");
		btnApply.setBounds(295, 535, 89, 23);
		frame.getContentPane().add(btnApply);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 369, 634, 130);
		frame.getContentPane().add(scrollPane_1);
		
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel = new JLabel("CART:");
		lblNewLabel.setBounds(12, 344, 56, 16);
		frame.getContentPane().add(lblNewLabel);
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
		header.add("Quantity");
		Vector<CartModel> cart = new Vector<CartModel>();
		cart = CartHandler.getInstance().getAllItem();
		dtm = new DefaultTableModel(header,0);
		table = new JTable(dtm);
		table.getTableHeader();
		for(CartModel cart2 : cart){
			Vector<Object> data = new Vector<Object>();
			data.add(cart2.getProductID());
			data.add(cart2.getQuantity());
			dtm.addRow(data);
		}
	}
	
	void addlistener(){
		btnAdd.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnAdd)){
			Integer ProductID = Integer.parseInt(addProductID.getText());
			Integer Stock = Integer.parseInt(addQuantity.getText());
			TransactionHandler.getInstance().addProductToCart(ProductID, Stock);
			
		}else if(e.getSource().equals(btnApply)) {
			
		}else if(e.getSource().equals(btnCheckout)) {
			
		}
		
	}
}
