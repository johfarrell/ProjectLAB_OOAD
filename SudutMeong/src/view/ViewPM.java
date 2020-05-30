package view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;

import controller.EmployeeHandler;
import controller.ProductHandler;
import controller.VoucherHandler;
import model.ProductModel;
import model.VoucherModel;
import javax.swing.JButton;

public class ViewPM implements ActionListener{
	
	private DefaultTableModel dtm;
	private JFrame frame;
	private JTable table;
	private JTextField insertDiscount;
	private JDateChooser insertValidDate;
	private JButton btnInsert;
	private JTextField updateDiscount;
	private JTextField updateID;
	private JDateChooser updateValidDate;
	private JButton btnUpdate;
	private JTextField deleteID;
	private JButton btnDelete;
	private JButton btnRefresh;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public ViewPM() {
		init_table();
		table();
		initialize();
		addlistener();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Promo Manager");
		frame.setBounds(100, 100, 670, 585);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 634, 130);
		frame.getContentPane().add(scrollPane);
		
		scrollPane.setViewportView(table);
		
		JLabel lblInsertVoucher = new JLabel("INSERT VOUCHER");
		lblInsertVoucher.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInsertVoucher.setBounds(40, 200, 168, 14);
		frame.getContentPane().add(lblInsertVoucher);
		
		JLabel lblNewLabel = new JLabel("Discount:");
		lblNewLabel.setBounds(50, 225, 86, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valid Date:");
		lblNewLabel_1.setBounds(50, 256, 87, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		insertDiscount = new JTextField();
		insertDiscount.setBounds(133, 225, 160, 20);
		frame.getContentPane().add(insertDiscount);
		insertDiscount.setColumns(10);
		
		insertValidDate = new JDateChooser();
		insertValidDate.setBounds(134, 256, 162, 20);
		frame.getContentPane().add(insertValidDate);
		
		btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnInsert.setBounds(204, 287, 89, 23);
		frame.getContentPane().add(btnInsert);
		
		JLabel lblUpdateVoucher = new JLabel("UPDATE VOUCHER");
		lblUpdateVoucher.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUpdateVoucher.setBounds(363, 200, 168, 14);
		frame.getContentPane().add(lblUpdateVoucher);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(373, 228, 46, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblDiscount = new JLabel("Discount:");
		lblDiscount.setBounds(373, 259, 86, 14);
		frame.getContentPane().add(lblDiscount);
		
		JLabel lblValidDate = new JLabel("Valid Date:");
		lblValidDate.setBounds(373, 294, 73, 14);
		frame.getContentPane().add(lblValidDate);
		
		updateID = new JTextField();
		updateID.setBounds(439, 225, 162, 20);
		frame.getContentPane().add(updateID);
		updateID.setColumns(10);
		
		updateDiscount = new JTextField();
		updateDiscount.setBounds(441, 256, 160, 20);
		frame.getContentPane().add(updateDiscount);
		updateDiscount.setColumns(10);
		
		updateValidDate = new JDateChooser();
		updateValidDate.setBounds(441, 290, 160, 20);
		frame.getContentPane().add(updateValidDate);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(512, 321, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JLabel lblDeleteVoucher = new JLabel("DELETE VOUCHER");
		lblDeleteVoucher.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDeleteVoucher.setBounds(40, 346, 143, 14);
		frame.getContentPane().add(lblDeleteVoucher);
		
		JLabel lblId_1 = new JLabel("ID:");
		lblId_1.setBounds(67, 383, 46, 14);
		frame.getContentPane().add(lblId_1);
		
		deleteID = new JTextField();
		deleteID.setBounds(133, 380, 160, 20);
		frame.getContentPane().add(deleteID);
		deleteID.setColumns(10);
		
		btnDelete = new JButton("DELETE");
		btnDelete.setBounds(204, 411, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(560, 143, 80, 25);
		frame.getContentPane().add(btnRefresh);
	}
	
	void init_table() {
		Vector<String> header = new Vector<String>();
		header.add("ID");
		header.add("Discount");
		header.add("Valid Date");
		dtm = new DefaultTableModel(header,0);
		table = new JTable(dtm);
		table.getTableHeader();
	}
	
	void table(){
		Vector<VoucherModel> voucher = new Vector<VoucherModel>();
		voucher = VoucherHandler.getInstance().getAllVoucher();
		for(VoucherModel voucher2 : voucher){
			Vector<Object> data = new Vector<Object>();
			data.add(voucher2.getVoucherID());
			data.add(voucher2.getDiscount());
			data.add(voucher2.getDate());
			dtm.addRow(data);
		}
	}
	
	void addlistener(){
		btnInsert.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnRefresh.addActionListener(this);
		btnDelete.addActionListener(this);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Integer row = table.getSelectedRow();
				Integer ID = (Integer)table.getValueAt(row, 0);
				float Discount = (float)table.getValueAt(row, 1);
				String ValidDate = (String)table.getValueAt(row, 2);

				updateID.setText(ID+"");
				updateDiscount.setText(Discount+"");
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date ValidDateParse = new Date();
				try {
					ValidDateParse = dateFormat.parse(ValidDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				updateValidDate.setDate(ValidDateParse);
			
				deleteID.setText(ID+"");
				
			}
		});
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnInsert)){
			
			Float Discount = 0.0f;
			
			try {
				Discount = Float.parseFloat(insertDiscount.getText());
			} catch (Exception e2) {
				Discount = 0.0f;
			}
			
			Date date = insertValidDate.getDate();  
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
            String ValidDate = dateFormat.format(date);
			try {
				VoucherHandler.getInstance().addVoucher(Discount, ValidDate);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dtm.setRowCount(0);
			table();
			dtm.fireTableDataChanged();
			
		} else if(e.getSource().equals(btnUpdate)){
			
			Float Discount = 0.0f;
			Integer VoucherID=0;
			
			
			try {
				Discount = Float.parseFloat(updateDiscount.getText());
			} catch (Exception e2) {
				Discount = 0.0f;
			}
			try {
				VoucherID = Integer.parseInt(updateID.getText());
			} catch (Exception e2) {
				VoucherID=0;
			}
			
			Date date = updateValidDate.getDate();  
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
            String ValidDate = dateFormat.format(date);
			try {
				VoucherHandler.getInstance().updateVoucher(VoucherID, Discount, ValidDate);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dtm.setRowCount(0);
			table();
			dtm.fireTableDataChanged();
			
		} else if(e.getSource().equals(btnDelete)){
			Integer VoucherID=0;
			
			try {
				VoucherID = Integer.parseInt(deleteID.getText());
			} catch (Exception e2) {
				VoucherID=0;
			}
			VoucherHandler.getInstance().deleteVoucher(VoucherID);
			dtm.setRowCount(0);
			table();
			dtm.fireTableDataChanged();
			
		} else if(e.getSource().equals(btnRefresh)) {
			   frame.dispose();
			   new ViewPM();
		}
	}
}
