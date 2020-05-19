package view;

import java.util.Date;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;

public class ViewHRM implements ActionListener{

	private DefaultTableModel dtm;
	private JFrame frame;
	private JTable table;
	private JLabel lblInsert;
	private JLabel lblRole;
	private JLabel lblName;
	private JLabel lblUsername;
	private JLabel lblDob;
	private JLabel lblSalary;
	private JTextField insertSalary;
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
	private JTextField updateSalary;
	private JButton btnUpdate;
	private JLabel lblResetfire;
	private JLabel lblId_1;
	private JTextField resetID;
	private JLabel lbId_2;
	private JTextField fireID;
	private JButton btnReset;
	private JButton btnFire;
	private JButton btnRefresh;
	private JLabel lblFire;
	private JLabel lblRoleid;
	private JTextField updateRoleID;
	private JDateChooser insertDOB;
	JDateChooser updateDOB;

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
		frame = new JFrame("Human Resource Manager");
		frame.setBounds(100, 100, 670, 585);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 11, 632, 130);
		frame.getContentPane().add(scrollPane);

		scrollPane.setViewportView(table);

		lblInsert = new JLabel("INSERT EMPLOYEE");
		lblInsert.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInsert.setBounds(20, 181, 180, 14);
		frame.getContentPane().add(lblInsert);

		lblRole = new JLabel("RoleID:");
		lblRole.setBounds(55, 210, 46, 14);
		frame.getContentPane().add(lblRole);

		lblName = new JLabel("Name:");
		lblName.setBounds(55, 240, 46, 14);
		frame.getContentPane().add(lblName);

		lblUsername = new JLabel("Username:");
		lblUsername.setBounds(55, 270, 70, 14);
		frame.getContentPane().add(lblUsername);

		lblDob = new JLabel("DOB:");
		lblDob.setBounds(55, 300, 46, 14);
		frame.getContentPane().add(lblDob);

		lblSalary = new JLabel("Salary:");
		lblSalary.setBounds(55, 330, 46, 14);
		frame.getContentPane().add(lblSalary);

		insertSalary = new JTextField();
		insertSalary.setBounds(130, 328, 160, 20);
		frame.getContentPane().add(insertSalary);
		insertSalary.setColumns(10);

		insertUsername = new JTextField();
		insertUsername.setBounds(130, 268, 160, 20);
		frame.getContentPane().add(insertUsername);
		insertUsername.setColumns(10);

		insertName = new JTextField();
		insertName.setBounds(130, 238, 160, 20);
		frame.getContentPane().add(insertName);
		insertName.setColumns(10);

		insertRoleID = new JTextField();
		insertRoleID.setBounds(130, 208, 160, 20);
		frame.getContentPane().add(insertRoleID);
		insertRoleID.setColumns(10);

		btnInsert = new JButton("INSERT");
		btnInsert.setBounds(201, 361, 89, 23);
		frame.getContentPane().add(btnInsert);

		lblUpdate = new JLabel("UPDATE EMPLOYEE");
		lblUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUpdate.setBounds(350, 181, 240, 14);
		frame.getContentPane().add(lblUpdate);

		lblId = new JLabel("ID:");
		lblId.setBounds(385, 210, 46, 14);
		frame.getContentPane().add(lblId);

		lblName_1 = new JLabel("Name:");
		lblName_1.setBounds(385, 240, 46, 14);
		frame.getContentPane().add(lblName_1);

		lblUsername_1 = new JLabel("Username:");
		lblUsername_1.setBounds(385, 270, 70, 14);
		frame.getContentPane().add(lblUsername_1);

		lblDob_1 = new JLabel("DOB:");
		lblDob_1.setBounds(385, 300, 46, 14);
		frame.getContentPane().add(lblDob_1);

		lblSalary_1 = new JLabel("Salary:");
		lblSalary_1.setBounds(385, 330, 46, 14);
		frame.getContentPane().add(lblSalary_1);

		lblRoleid = new JLabel("RoleID:");
		lblRoleid.setBounds(385, 360, 46, 14);
		frame.getContentPane().add(lblRoleid);

		updateUsername = new JTextField();
		updateUsername.setBounds(460, 268, 160, 20);
		frame.getContentPane().add(updateUsername);
		updateUsername.setColumns(10);

		updateName = new JTextField();
		updateName.setBounds(460, 238, 160, 20);
		frame.getContentPane().add(updateName);
		updateName.setColumns(10);

		updateID = new JTextField();
		updateID.setBounds(460, 208, 160, 20);
		frame.getContentPane().add(updateID);
		updateID.setColumns(10);

		updateSalary = new JTextField();
		updateSalary.setBounds(460, 328, 160, 20);
		frame.getContentPane().add(updateSalary);
		updateSalary.setColumns(10);

		updateRoleID = new JTextField();
		updateRoleID.setBounds(460, 358, 160, 20);
		frame.getContentPane().add(updateRoleID);
		updateRoleID.setColumns(10);

		btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(531, 391, 89, 23);
		frame.getContentPane().add(btnUpdate);

		lblResetfire = new JLabel("RESET PASSWORD");
		lblResetfire.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblResetfire.setBounds(12, 427, 180, 14);
		frame.getContentPane().add(lblResetfire);

		lblId_1 = new JLabel("ID:");
		lblId_1.setBounds(55, 456, 46, 14);
		frame.getContentPane().add(lblId_1);

		resetID = new JTextField();
		resetID.setBounds(130, 454, 160, 20);
		frame.getContentPane().add(resetID);
		resetID.setColumns(10);

		btnReset = new JButton("RESET");
		btnReset.setBounds(201, 487, 89, 23);
		frame.getContentPane().add(btnReset);

		lblFire = new JLabel("FIRE EMPLOYEE");
		lblFire.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFire.setBounds(350, 427, 240, 14);
		frame.getContentPane().add(lblFire);

		lbId_2 = new JLabel("ID:");
		lbId_2.setBounds(385, 456, 46, 14);
		frame.getContentPane().add(lbId_2);

		fireID = new JTextField();
		fireID.setBounds(460, 453, 160, 20);
		frame.getContentPane().add(fireID);
		fireID.setColumns(10);

		btnFire = new JButton("FIRE");
		btnFire.setBounds(531, 487, 89, 23);
		frame.getContentPane().add(btnFire);

		insertDOB = new JDateChooser();
		insertDOB.setBounds(130, 298, 160, 22);
		frame.getContentPane().add(insertDOB);

		updateDOB = new JDateChooser();
		updateDOB.setBounds(460, 298, 160, 22);
		frame.getContentPane().add(updateDOB);

		btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(560, 143, 80, 25);
		frame.getContentPane().add(btnRefresh);
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
		btnRefresh.addActionListener(this);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Integer row = table.getSelectedRow();
				Integer ID = (Integer)table.getValueAt(row, 0);
				Integer RoleID = (Integer)table.getValueAt(row, 1);
				String Name = (String)table.getValueAt(row, 2);
				String Username = (String)table.getValueAt(row, 3);
				//Date DOB = (Date)table.getValueAt(row, 4);
				Integer Salary = (Integer)table.getValueAt(row, 5);
	            
				updateID.setText(ID+"");
				updateRoleID.setText(RoleID+"");
				updateName.setText(Name);
				updateUsername.setText(Username);
				//updateDOB.setDate(DOB);
				updateSalary.setText(Salary+"");
				
				resetID.setText(ID+"");
				fireID.setText(ID+"");
				
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnInsert)){

			Integer RoleID=0;
			Integer Salary=0;

			try {
				RoleID = Integer.parseInt(insertRoleID.getText());
			} catch (Exception e2) {
				RoleID = 0;
			}
			
			try {
				Salary = Integer.parseInt(insertSalary.getText());
			} catch (Exception e2) {
				Salary = 0;
			}
			
			String Name = insertName.getText();
			String Username = insertUsername.getText();
			Date date = insertDOB.getDate();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String DOB = dateFormat.format(date);

			try {
				HRMController.getInstance().addEmployee(RoleID, Name, Username, DOB, Salary);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if(e.getSource().equals(btnUpdate)){

			Integer RoleID=0;
			Integer Salary=0;
			Integer employeeID=-1;

			try {
				RoleID = Integer.parseInt(updateRoleID.getText());
			} catch (Exception e2) {
				RoleID = 0;
			}
			
			try {
				Salary = Integer.parseInt(updateSalary.getText());
			} catch (Exception e2) {
				Salary = 0;
			}
			
			try {
				employeeID = Integer.parseInt(updateID.getText());
			} catch (Exception e2) {
				employeeID=-1;
			}

			String Name = updateName.getText();
			String Username = updateUsername.getText();
			Date date = updateDOB.getDate();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String DOB = dateFormat.format(date);

			try {
				HRMController.getInstance().updateEmployee(employeeID, RoleID, Name, Username, DOB, Salary);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if(e.getSource().equals(btnReset)){
			Integer employeeID=-1;

			try {
				employeeID = Integer.parseInt(resetID.getText());
			} catch (Exception e2) {
				employeeID=-1;
			}

			HRMController.getInstance().resetPassword(employeeID);

		} else if(e.getSource().equals(btnFire)){
			Integer employeeID=-1;
			try {
				employeeID = Integer.parseInt(fireID.getText());
			} catch (Exception e2) {
				employeeID=-1;
			}

			HRMController.getInstance().fireEmployee(employeeID);
		} else if(e.getSource().equals(btnRefresh)) {
			frame.dispose();
			new ViewHRM();
		}
	}
}
