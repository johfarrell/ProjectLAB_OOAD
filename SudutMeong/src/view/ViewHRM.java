package view;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.HRMController;
import model.EmployeeModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewHRM implements ActionListener{

	private JFrame frame;
	private DefaultTableModel dtm;
	private JTable table;
	private JLabel lblInsert;
	private JLabel lblRole;
	private JLabel lblName;
	private JLabel lblUsername;
	private JLabel lblDob;
	private JLabel lblSalary;
	private JTextField insertSalary;
	private JTextField insertDOB;
	private JTextField insertUsername;
	private JTextField insertName;
	private JTextField insertRoleID;
	private JButton btnInsert;
	private JLabel lblUpdate;
	private JLabel lblId;
	private JLabel lblName_1;
	private JLabel lblUsername_1;
	private JLabel lblDob_1;
	private JLabel lblSalary_1;
	private JTextField updateUsername;
	private JTextField updateName;
	private JTextField updateID;
	private JTextField updateDOB;
	private JTextField updateSalary;
	private JButton btnUpdate;
	private JLabel lblResetfire;
	private JLabel lblId_1;
	private JTextField resetID;
	private JLabel lbId_2;
	private JTextField fireID;
	private JButton btnReset;
	private JButton btnFire;
	private JLabel lblFire;
	private JLabel lblRoleid;
	private JTextField updateRoleID;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public ViewHRM() {
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
		frame.setBounds(100, 100, 565, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 529, 130);
		frame.getContentPane().add(scrollPane);
	
		scrollPane.setViewportView(table);
		
		lblInsert = new JLabel("INSERT");
		lblInsert.setBounds(35, 152, 46, 14);
		frame.getContentPane().add(lblInsert);
		
		lblRole = new JLabel("RoleID:");
		lblRole.setBounds(35, 180, 46, 14);
		frame.getContentPane().add(lblRole);
		
		lblName = new JLabel("Name:");
		lblName.setBounds(35, 205, 46, 14);
		frame.getContentPane().add(lblName);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setBounds(35, 230, 73, 14);
		frame.getContentPane().add(lblUsername);
		
		lblDob = new JLabel("DOB:");
		lblDob.setBounds(35, 255, 46, 14);
		frame.getContentPane().add(lblDob);
		
		lblSalary = new JLabel("Salary:");
		lblSalary.setBounds(35, 280, 46, 14);
		frame.getContentPane().add(lblSalary);
		
		insertSalary = new JTextField();
		insertSalary.setBounds(105, 277, 147, 20);
		frame.getContentPane().add(insertSalary);
		insertSalary.setColumns(10);
		
		insertDOB = new JTextField();
		insertDOB.setBounds(105, 252, 147, 20);
		frame.getContentPane().add(insertDOB);
		insertDOB.setColumns(10);
		
		insertUsername = new JTextField();
		insertUsername.setBounds(105, 227, 147, 20);
		frame.getContentPane().add(insertUsername);
		insertUsername.setColumns(10);
		
		insertName = new JTextField();
		insertName.setBounds(105, 202, 147, 20);
		frame.getContentPane().add(insertName);
		insertName.setColumns(10);
		
		insertRoleID = new JTextField();
		insertRoleID.setBounds(105, 177, 147, 20);
		frame.getContentPane().add(insertRoleID);
		insertRoleID.setColumns(10);
		
		btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnInsert.setBounds(163, 308, 89, 23);
		frame.getContentPane().add(btnInsert);
		
		lblUpdate = new JLabel("UPDATE");
		lblUpdate.setBounds(295, 152, 46, 14);
		frame.getContentPane().add(lblUpdate);
		
		lblId = new JLabel("ID:");
		lblId.setBounds(295, 180, 46, 14);
		frame.getContentPane().add(lblId);
		
		lblName_1 = new JLabel("Name:");
		lblName_1.setBounds(295, 205, 46, 14);
		frame.getContentPane().add(lblName_1);
		
		lblUsername_1 = new JLabel("Username:");
		lblUsername_1.setBounds(295, 230, 73, 14);
		frame.getContentPane().add(lblUsername_1);
		
		lblDob_1 = new JLabel("DOB:");
		lblDob_1.setBounds(295, 255, 46, 14);
		frame.getContentPane().add(lblDob_1);
		
		lblSalary_1 = new JLabel("Salary:");
		lblSalary_1.setBounds(295, 280, 46, 14);
		frame.getContentPane().add(lblSalary_1);
		
		lblRoleid = new JLabel("RoleID:");
		lblRoleid.setBounds(295, 308, 46, 14);
		frame.getContentPane().add(lblRoleid);
		
		updateUsername = new JTextField();
		updateUsername.setBounds(362, 224, 150, 20);
		frame.getContentPane().add(updateUsername);
		updateUsername.setColumns(10);
		
		updateName = new JTextField();
		updateName.setBounds(362, 199, 150, 20);
		frame.getContentPane().add(updateName);
		updateName.setColumns(10);
		
		updateID = new JTextField();
		updateID.setBounds(362, 174, 150, 20);
		frame.getContentPane().add(updateID);
		updateID.setColumns(10);
		
		updateDOB = new JTextField();
		updateDOB.setBounds(362, 249, 150, 20);
		frame.getContentPane().add(updateDOB);
		updateDOB.setColumns(10);
		
		updateSalary = new JTextField();
		updateSalary.setBounds(362, 274, 150, 20);
		frame.getContentPane().add(updateSalary);
		updateSalary.setColumns(10);
		
		updateRoleID = new JTextField();
		updateRoleID.setBounds(362, 305, 150, 20);
		frame.getContentPane().add(updateRoleID);
		updateRoleID.setColumns(10);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(423, 336, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		lblResetfire = new JLabel("RESET PASSWORD");
		lblResetfire.setBounds(35, 370, 103, 14);
		frame.getContentPane().add(lblResetfire);
		
		lblId_1 = new JLabel("ID:");
		lblId_1.setBounds(35, 388, 46, 14);
		frame.getContentPane().add(lblId_1);
		
		resetID = new JTextField();
		resetID.setBounds(105, 385, 147, 20);
		frame.getContentPane().add(resetID);
		resetID.setColumns(10);
		
		btnReset = new JButton("RESET");
		btnReset.setBounds(163, 416, 89, 23);
		frame.getContentPane().add(btnReset);
		
		lblFire = new JLabel("FIRE");
		lblFire.setBounds(295, 370, 46, 14);
		frame.getContentPane().add(lblFire);
		
		lbId_2 = new JLabel("ID:");
		lbId_2.setBounds(295, 388, 46, 14);
		frame.getContentPane().add(lbId_2);
		
		fireID = new JTextField();
		fireID.setBounds(362, 385, 150, 20);
		frame.getContentPane().add(fireID);
		fireID.setColumns(10);
		
		btnFire = new JButton("FIRE");
		btnFire.setBounds(423, 416, 89, 23);
		frame.getContentPane().add(btnFire);
	}
	
	void table(){
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
		table = new JTable(dtm);
		table.getTableHeader();
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
		btnReset.addActionListener(this);
		btnFire.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnInsert)){
			int RoleID = Integer.parseInt(insertRoleID.getText());
			String Name = insertName.getText();
			String Username = insertUsername.getText();
			String DOB = insertDOB.getText();
			int Salary = Integer.parseInt(insertSalary.getText());
			HRMController.getInstance().addEmployee(RoleID, Name, Username, DOB, Salary);;
			
		} else if(e.getSource().equals(btnUpdate)){
			int employeeID = Integer.parseInt(updateID.getText());
			int RoleID = Integer.parseInt(updateRoleID.getText());
			String Name = updateName.getText();
			String Username = updateUsername.getText();
			int Salary = Integer.parseInt(updateSalary.getText());
			String DOB = updateDOB.getText();
			HRMController.getInstance().updateEmployee(employeeID, RoleID, Name, Username, DOB, Salary);
			
		} else if(e.getSource().equals(btnReset)){
			int employeeID = Integer.parseInt(resetID.getText());
			HRMController.getInstance().resetPassword(employeeID);
		} else if(e.getSource().equals(btnFire)){
			int employeeID = Integer.parseInt(fireID.getText());
			HRMController.getInstance().fireEmployee(employeeID);
		}
	}
}
