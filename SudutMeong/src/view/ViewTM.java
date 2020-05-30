package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	private DefaultTableModel dtm_1;
	private JFrame frmCashier;
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
	private JLabel lblPrice;
	private Float appliedVoucher=0.0f;
	
	private Integer EmployeeID;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public ViewTM(Integer EmployeeID) {
		
		this.EmployeeID = EmployeeID;
		
		init_table();
		table();
		init_table_1();
		table_1();
		initialize();
		addlistener();
		frmCashier.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCashier = new JFrame();
		frmCashier.setTitle("Cashier");
		frmCashier.setBounds(100, 100, 670, 740);
		frmCashier.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCashier.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 358, 629, 130);
		frmCashier.getContentPane().add(scrollPane);
		
		scrollPane.setViewportView(table);
		
		JLabel lblA = new JLabel("ADD TO CART");
		lblA.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblA.setBounds(40, 165, 321, 14);
		frmCashier.getContentPane().add(lblA);
		
		JLabel lblProductid = new JLabel("ProductID:");
		lblProductid.setBounds(40, 194, 65, 14);
		frmCashier.getContentPane().add(lblProductid);
		
		addProductID = new JTextField();
		addProductID.setBounds(112, 190, 160, 20);
		frmCashier.getContentPane().add(addProductID);
		addProductID.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(40, 233, 65, 14);
		frmCashier.getContentPane().add(lblQuantity);
		
		addQuantity = new JTextField();
		addQuantity.setBounds(112, 229, 160, 20);
		frmCashier.getContentPane().add(addQuantity);
		addQuantity.setColumns(10);
		
		btnAdd = new JButton("ADD");
		btnAdd.setBounds(183, 268, 89, 23);
		frmCashier.getContentPane().add(btnAdd);
		
		JLabel lblCheckout = new JLabel("CHECKOUT");
		lblCheckout.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCheckout.setBounds(40, 510, 140, 14);
		frmCashier.getContentPane().add(lblCheckout);
		
		JLabel lblVoucherid = new JLabel("VoucherID:");
		lblVoucherid.setBounds(40, 539, 71, 14);
		frmCashier.getContentPane().add(lblVoucherid);
		
		checkoutVoucherID = new JTextField();
		checkoutVoucherID.setBounds(152, 536, 160, 20);
		frmCashier.getContentPane().add(checkoutVoucherID);
		checkoutVoucherID.setColumns(10);
		
		btnCheckout = new JButton("CHECKOUT");
		btnCheckout.setBounds(310, 642, 100, 23);
		frmCashier.getContentPane().add(btnCheckout);
		
		JLabel lblTotalPrice = new JLabel("Total Price:");
		lblTotalPrice.setBounds(40, 575, 71, 14);
		frmCashier.getContentPane().add(lblTotalPrice);
		
		lblPrice = new JLabel("0");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrice.setBounds(180, 575, 132, 14);
		frmCashier.getContentPane().add(lblPrice);
		
		btnApply = new JButton("APPLY");
		btnApply.setBounds(321, 535, 89, 23);
		frmCashier.getContentPane().add(btnApply);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 634, 130);
		frmCashier.getContentPane().add(scrollPane_1);
		
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel = new JLabel("CART:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 340, 56, 16);
		frmCashier.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Payment Method:");
		lblNewLabel_1.setBounds(40, 610, 110, 16);
		frmCashier.getContentPane().add(lblNewLabel_1);
		
		String[] method = {"Cash", "Credit"};
		paymentmethod = new JComboBox<Object>(method);
		paymentmethod.setBounds(152, 607, 100, 22);
		frmCashier.getContentPane().add(paymentmethod);
		
		JLabel lblNewLabel_2 = new JLabel("Rp.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(152, 574, 35, 16);
		frmCashier.getContentPane().add(lblNewLabel_2);
		
		updateCartQuantity = new JTextField();
		updateCartQuantity.setBounds(594, 507, 50, 22);
		frmCashier.getContentPane().add(updateCartQuantity);
		updateCartQuantity.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Quantity:");
		lblNewLabel_3.setBounds(526, 510, 56, 16);
		frmCashier.getContentPane().add(lblNewLabel_3);
		
		btnUpdateCart = new JButton("UPDATE");
		btnUpdateCart.setBounds(526, 534, 118, 25);
		frmCashier.getContentPane().add(btnUpdateCart);
	}
	
	
	void init_table_1(){
		Vector<String> header = new Vector<String>();
		header.add("ID");
		header.add("Name");
		header.add("Description");
		header.add("Price");
		header.add("Stock");
		dtm_1 = new DefaultTableModel(header,0);
		table_1 = new JTable(dtm_1);
		table_1.getTableHeader();
	}
	void table_1(){

		Vector<ProductModel> product = new Vector<ProductModel>();
		product = ProductHandler.getInstance().getAllProduct();
		
		for(ProductModel product2 : product){
			Vector<Object> data = new Vector<Object>();
			data.add(product2.getProductID());
			data.add(product2.getName());
			data.add(product2.getDescription());
			data.add(product2.getPrice());
			data.add(product2.getStock());
			dtm_1.addRow(data);
		}
		
	}
	
	void init_table() {
		Vector<String> header = new Vector<String>();
		header.add("ProductID");
		header.add("Product Name");
		header.add("Quantity");
		dtm = new DefaultTableModel(header,0);
		table = new JTable(dtm);
		table.getTableHeader();
	}
	void table(){
		
		Vector<CartModel> cart = new Vector<CartModel>();
		cart = CartHandler.getInstance().getAllItem();
		
		for(CartModel cart2 : cart){
			Vector<Object> data = new Vector<Object>();
			data.add(cart2.getProductID());
			data.add(cart2.getProductName());
			data.add(cart2.getQuantity());
			dtm.addRow(data);
		}
	}
	
	Float changeTotalPrice(Float DiscountVoucher) {
		Vector<CartModel> oncart = new Vector<CartModel>();
		oncart = CartHandler.getInstance().getAllItem();
		
		Float totalPrice = 0.0f;
		
		for(CartModel cart2 : oncart){
			Vector<Integer> ProID = new Vector<Integer>();
			ProID = ProductHandler.getInstance().getAllProductID();
			
			Integer index = ProID.indexOf(cart2.getProductID());
			Vector<ProductModel> product = new Vector<ProductModel>();
			product = ProductHandler.getInstance().getAllProduct();
			ProductModel checkprice = product.elementAt(index);
			
			
			Integer currentItemQuantity = cart2.getQuantity();
			
			Integer currentPrice = currentItemQuantity*checkprice.getPrice();
			totalPrice+=currentPrice;
			
		}
		
		totalPrice=totalPrice*((100.0f-DiscountVoucher)/100);
				
		String total = String.valueOf(totalPrice); 
		lblPrice.setText(total);
		
		return totalPrice;
	}
	
	
	
	Integer quantityProductID;
	void addlistener(){
		btnAdd.addActionListener(this);
		btnApply.addActionListener(this);
		btnCheckout.addActionListener(this);
		btnUpdateCart.addActionListener(this);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Integer row = table.getSelectedRow();
				String quantity = (String) table.getValueAt(row, 2);
				updateCartQuantity.setText(quantity+"");
								
				quantityProductID = Integer.parseInt((String) table.getValueAt(row, 0));
			}
		});
		
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Integer row = table_1.getSelectedRow();
				Integer ID = (Integer)table_1.getValueAt(row, 0);
				addProductID.setText(ID+"");
			}
		});
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
			String x = TransactionHandler.getInstance().addProductToCart(ProductID, Quantity);
						
			if(x.equals("not_exist")) {
				
				Vector<Integer> ProID = new Vector<Integer>();
				ProID = ProductHandler.getInstance().getAllProductID();
				
				Integer index = ProID.indexOf(ProductID);
				Vector<ProductModel> product = new Vector<ProductModel>();
				product = ProductHandler.getInstance().getAllProduct();
				
				ProductModel checkstock = product.elementAt(index);
				String ProductName = checkstock.getName();
                
                Vector<Object> data = new Vector<Object>();		//Tambahin langsung ke tabel
    			data.add(addProductID.getText());
    			data.add(ProductName);
    			data.add(addQuantity.getText());
    			dtm.addRow(data);

                dtm.fireTableDataChanged();
                changeTotalPrice(appliedVoucher);
			}else if(x.equals("exist_instock")) {
				
				for(int i=0; i<table.getRowCount(); i++) {
					if(Integer.parseInt((String) table.getValueAt(i, 0)) == ProductID) {	//Cari di tabel
						Integer oldQuantity = Integer.parseInt((String) table.getValueAt(i, 2));	//Ganti value nya jadi yang baru
						Integer newQuantity = oldQuantity+Quantity;
						String cartQuantity = Integer.toString(newQuantity);
						
						table.setValueAt(cartQuantity, i, 2);
						dtm.fireTableDataChanged();
					}
				}
				changeTotalPrice(appliedVoucher);
			}else if(x.equals("exist_outofstock")) {
				//Nothing Happened
			}
			
			
		}else if(e.getSource().equals(btnApply)) {
			Integer VoucherID=0;
			try {
				VoucherID = Integer.parseInt(checkoutVoucherID.getText());
			} catch (Exception e2) {
				VoucherID = 0;
			}
			
			appliedVoucher = TransactionHandler.getInstance().addCheckOutVoucher(VoucherID);
			
			changeTotalPrice(appliedVoucher);
			
		}else if(e.getSource().equals(btnUpdateCart)) {
			Integer Quantity=-1;
			try {
				Quantity = Integer.parseInt(updateCartQuantity.getText());
			} catch (Exception e2) {
				Quantity=-1;
			}
			
			String x = TransactionHandler.getInstance().updateCartQuantity(quantityProductID, Quantity);
			
			if(x.equals("quantity_changed")) {
				for(int i=0; i<table.getRowCount(); i++) {
					if(Integer.parseInt((String) table.getValueAt(i, 0)) == quantityProductID) {	//Cari di tabel
						String cartQuantity = Integer.toString(Quantity); //Ganti value nya jadi yang baru
						
						table.setValueAt(cartQuantity, i, 2);
						dtm.fireTableDataChanged();
					}
				}
				changeTotalPrice(appliedVoucher);
			}else if(x.equals("product_removed")) {
				Integer indexRemove;
				
				for(int i=0; i<table.getRowCount(); i++) {
					if(Integer.parseInt((String) table.getValueAt(i, 0)) == quantityProductID) {	//Cari di tabel
						indexRemove=i;
						((DefaultTableModel)table.getModel()).removeRow(indexRemove);  //Remove dari tabel
						dtm.fireTableDataChanged();
						break;
					}
				}
				changeTotalPrice(appliedVoucher);
			}else if(x.equals("outofstock")) {
				//Nothing Happened
			}
			
		}else if(e.getSource().equals(btnCheckout)) {
			Integer VoucherID=0;
			String PaymentType;
			
			try {
				VoucherID = Integer.parseInt(checkoutVoucherID.getText());
			} catch (Exception e2) {
				VoucherID=0;
			}
			
			PaymentType = paymentmethod.getSelectedItem().toString();
			String status=null;
			try {
				status = TransactionHandler.getInstance().checkoutTransaction(this.EmployeeID, VoucherID, PaymentType);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(status.equals("done")) {
				//VoucherUsed, inisialisasi ulang jadi 0 discount
				appliedVoucher = 0.0f;
				changeTotalPrice(appliedVoucher);
				
				//Update table Cart
				dtm.setRowCount(0);
				table();
				dtm.fireTableDataChanged();
				
				//Update table Stock
				dtm_1.setRowCount(0);
				table_1();
				dtm_1.fireTableDataChanged();
				
			}
		}
		
	}
}
