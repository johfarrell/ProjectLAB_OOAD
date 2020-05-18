package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import controller.HRMController;
import controller.MController;
import model.EmployeeModel;
import model.TransactionModel;

public class ViewM implements ActionListener{
	
	private DefaultTableModel dtm;
	private JFrame frame;
	private JTextField viewMonth;
	private JTextField viewYear;
	private JButton btnSearch;
	private JTextField insertRoleID;
	private JTextField insertName;
	private JTextField insertUsername;
	private JDateChooser insertDOB;
	private JTextField insertSalary;
	private JButton btnInsert;
	private JTextField updateID;
	private JTextField updateName;
	private JTextField updateUsername;
	private JTextField updateSalary;
	private JTextField updateRoleID;
	private JDateChooser updateDOB;
	private JButton btnUpdate;
	private JTextField fireID;
	private JButton btnFire;
	private JButton btnRefresh;
	private JButton btnRefresh2;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public ViewM() {
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
		frame.setBounds(100, 100, 665, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 634, 130);
		frame.getContentPane().add(scrollPane);
		
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Search Transaction Report");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(40, 185, 217, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblMonth = new JLabel("Month:");
		lblMonth.setBounds(40, 207, 46, 14);
		frame.getContentPane().add(lblMonth);
		
		viewMonth = new JTextField();
		viewMonth.setBounds(96, 204, 160, 20);
		frame.getContentPane().add(viewMonth);
		viewMonth.setColumns(10);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setBounds(286, 207, 46, 14);
		frame.getContentPane().add(lblYear);
		
		viewYear = new JTextField();
		viewYear.setBounds(326, 204, 160, 20);
		frame.getContentPane().add(viewYear);
		viewYear.setColumns(10);
		
		btnSearch = new JButton("SEARCH");
		btnSearch.setBounds(537, 203, 89, 23);
		frame.getContentPane().add(btnSearch);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 263, 634, 130);
		frame.getContentPane().add(scrollPane_1);
		
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblInsertEmployee = new JLabel("INSERT EMPLOYEE");
		lblInsertEmployee.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInsertEmployee.setBounds(40, 437, 217, 14);
		frame.getContentPane().add(lblInsertEmployee);
		
		JLabel lblRoleId = new JLabel("Role ID:");
		lblRoleId.setBounds(40, 462, 46, 14);
		frame.getContentPane().add(lblRoleId);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(40, 493, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(40, 526, 75, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblDob = new JLabel("DOB:");
		lblDob.setBounds(40, 561, 46, 14);
		frame.getContentPane().add(lblDob);
		
		JLabel lblSalary = new JLabel("Salary:");
		lblSalary.setBounds(40, 596, 46, 14);
		frame.getContentPane().add(lblSalary);
		
		insertRoleID = new JTextField();
		insertRoleID.setBounds(105, 462, 160, 20);
		frame.getContentPane().add(insertRoleID);
		insertRoleID.setColumns(10);
		
		insertName = new JTextField();
		insertName.setBounds(105, 490, 160, 20);
		frame.getContentPane().add(insertName);
		insertName.setColumns(10);
		
		insertUsername = new JTextField();
		insertUsername.setBounds(105, 523, 160, 20);
		frame.getContentPane().add(insertUsername);
		insertUsername.setColumns(10);
		
		insertSalary = new JTextField();
		insertSalary.setBounds(105, 593, 160, 20);
		frame.getContentPane().add(insertSalary);
		insertSalary.setColumns(10);
		
		btnInsert = new JButton("INSERT");
		btnInsert.setBounds(176, 624, 89, 23);
		frame.getContentPane().add(btnInsert);
		
		insertDOB = new JDateChooser();
		insertDOB.setBounds(105, 561, 160, 20);
		frame.getContentPane().add(insertDOB);
		
		JLabel lblUpdateEmployee = new JLabel("UPDATE EMPLOYEE");
		lblUpdateEmployee.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUpdateEmployee.setBounds(326, 437, 229, 14);
		frame.getContentPane().add(lblUpdateEmployee);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setBounds(326, 462, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblName_1 = new JLabel("Name:");
		lblName_1.setBounds(326, 493, 46, 14);
		frame.getContentPane().add(lblName_1);
		
		JLabel lblUsername_1 = new JLabel("Username:");
		lblUsername_1.setBounds(326, 526, 67, 14);
		frame.getContentPane().add(lblUsername_1);
		
		JLabel lblDob_1 = new JLabel("DOB:");
		lblDob_1.setBounds(326, 561, 46, 14);
		frame.getContentPane().add(lblDob_1);
		
		JLabel lblSalary_1 = new JLabel("Salary:");
		lblSalary_1.setBounds(326, 596, 46, 14);
		frame.getContentPane().add(lblSalary_1);
		
		JLabel lblRoleId_1 = new JLabel("Role ID:");
		lblRoleId_1.setBounds(326, 628, 46, 14);
		frame.getContentPane().add(lblRoleId_1);
		
		updateID = new JTextField();
		updateID.setBounds(400, 459, 160, 20);
		frame.getContentPane().add(updateID);
		updateID.setColumns(10);
		
		updateName = new JTextField();
		updateName.setBounds(400, 490, 160, 20);
		frame.getContentPane().add(updateName);
		updateName.setColumns(10);
		
		updateUsername = new JTextField();
		updateUsername.setBounds(400, 523, 160, 20);
		frame.getContentPane().add(updateUsername);
		updateUsername.setColumns(10);
		
		updateDOB = new JDateChooser();
		updateDOB.setBounds(400, 561, 160, 20);
		frame.getContentPane().add(updateDOB);
		
		updateSalary = new JTextField();
		updateSalary.setBounds(400, 593, 160, 20);
		frame.getContentPane().add(updateSalary);
		updateSalary.setColumns(10);
		
		updateRoleID = new JTextField();
		updateRoleID.setBounds(400, 625, 160, 20);
		frame.getContentPane().add(updateRoleID);
		updateRoleID.setColumns(10);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(471, 656, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JLabel lblFireEmployee = new JLabel("FIRE EMPLOYEE");
		lblFireEmployee.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFireEmployee.setBounds(40, 701, 193, 14);
		frame.getContentPane().add(lblFireEmployee);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(40, 726, 46, 14);
		frame.getContentPane().add(lblId);
		
		fireID = new JTextField();
		fireID.setBounds(105, 726, 160, 20);
		frame.getContentPane().add(fireID);
		fireID.setColumns(10);
		
		btnFire = new JButton("FIRE");
		btnFire.setBounds(176, 757, 89, 23);
		frame.getContentPane().add(btnFire);
		
		btnRefresh = new JButton("REFRESH");
		btnRefresh.setBounds(555, 152, 89, 23);
		frame.getContentPane().add(btnRefresh);
		
		btnRefresh2 = new JButton("REFRESH");
		btnRefresh2.setBounds(555, 404, 89, 23);
		frame.getContentPane().add(btnRefresh2);
	}
	
	void table(){
		Vector<String> header = new Vector<String>();
		header.add("TransactionID");
		header.add("PurchaseDate");
		header.add("VoucherID");
		header.add("EmployeeID");
		header.add("PaymentType");
		Vector<TransactionModel> transaction = new Vector<TransactionModel>();
		transaction = MController.getInstance().getAllTransaction(2,2);
		dtm = new DefaultTableModel(header,0);
		table = new JTable(dtm);
		table.getTableHeader();
		for(TransactionModel transaction2 : transaction){
			Vector<Object> data = new Vector<Object>();
			data.add(transaction2.getTransactionID());
			data.add(transaction2.getPurchaseDate());
			data.add(transaction2.getVoucherID());
			data.add(transaction2.getEmployeeID());
			data.add(transaction2.getPaymentType());
			dtm.addRow(data);
		}
	}
	
	void table_1(){
		Vector<String> header = new Vector<String>();
		header.add("ID");
		header.add("RoleID");
		header.add("Name");
		header.add("Username");
		header.add("DOB");
		header.add("Salary");
		header.add("Status");
		header.add("Password");
		Vector<EmployeeModel> employee = new Vector<EmployeeModel>();
		employee = HRMController.getInstance().getAllEmployee();
		dtm = new DefaultTableModel(header,0);
		table_1 = new JTable(dtm);
		table_1.getTableHeader();
		for(EmployeeModel employee2 : employee){
			Vector<Object> data = new Vector<Object>();
			data.add(employee2.getEmployeeid());
			data.add(employee2.getRoleid());
			data.add(employee2.getName());
			data.add(employee2.getUsername());
			data.add(employee2.getDOB());
			data.add(employee2.getSalary());
			data.add(employee2.getStatus());
			data.add(employee2.getPassword());
			dtm.addRow(data);
		}
	}

	void addlistener(){
		btnInsert.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnFire.addActionListener(this);
		btnRefresh.addActionListener(this);
		btnRefresh2.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnInsert)){
			int RoleID = Integer.parseInt(insertRoleID.getText());
			String Name = insertName.getText();
			String Username = insertUsername.getText();
			Date date = insertDOB.getDate();  
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
            String DOB = dateFormat.format(date);  
			int Salary = Integer.parseInt(insertSalary.getText());
			MController.getInstance().addEmployee(RoleID, Name, Username, DOB, Salary);;
			
		} else if(e.getSource().equals(btnUpdate)){
			int employeeID = Integer.parseInt(updateID.getText());
			int RoleID = Integer.parseInt(updateRoleID.getText());
			String Name = updateName.getText();
			String Username = updateUsername.getText();
			int Salary = Integer.parseInt(updateSalary.getText());
			Date date = updateDOB.getDate();  
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
            String DOB = dateFormat.format(date);
			MController.getInstance().updateEmployee(employeeID, RoleID, Name, Username, DOB, Salary);
			
		} else if(e.getSource().equals(btnFire)){
			int employeeID = Integer.parseInt(fireID.getText());
			MController.getInstance().fireEmployee(employeeID);
			
		} else if(e.getSource().equals(btnRefresh2)) {
			   frame.dispose();
			   new ViewM();
		}
	}
}
