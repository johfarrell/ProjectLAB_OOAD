package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import controller.HRMController;
import controller.LoginController;
import controller.MController;
import controller.PMController;
import controller.PopUpController;
import controller.SMController;
import model.EmployeeModel;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField usernameform;
	private JPasswordField passwordform;

	
	public Login() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sudutmeong Login");
		lblNewLabel.setBounds(0, 25, 482, 25);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(100, 83, 85, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(100, 115, 85, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		usernameform = new JTextField();
		usernameform.setBounds(200, 80, 181, 22);
		frame.getContentPane().add(usernameform);
		usernameform.setColumns(10);
		
		passwordform = new JPasswordField();
		passwordform.setBounds(200, 113, 181, 22);
		frame.getContentPane().add(passwordform);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = usernameform.getText();
				char[] password = passwordform.getPassword();	//Password hanya bisa disimpan dalam array of char
				String pass = String.copyValueOf(password);		//Password di konversi menjadi string
				
				Vector<EmployeeModel> employee = new Vector<EmployeeModel>();
				employee = LoginController.getInstance().getAllEmployee();
				
				Vector<String> employeeusername = new Vector<String>();
				employeeusername = LoginController.getInstance().getAllUsername();
				
				
				Vector<String> employeepassword = new Vector<String>();
				employeepassword = LoginController.getInstance().getAllPassword();
				
				if(employeeusername.contains(username)) {
					Integer posisi = employeeusername.indexOf(username);  //Cari posisi username
										
					if(employeepassword.elementAt(posisi).equals(pass)) { //Cocokin password di posisi index username
						
						EmployeeModel emplo = employee.elementAt(posisi);
						
						if(emplo.getStatus().equals("Inactive")) {
							PopUpController.getInstance().inactive();
						}else if(emplo.getStatus().equals("Active")){
							if(emplo.getRoleid() == 1) {
								System.out.println("Anda adalah Human Resource");
								frame.dispose();
								HRMController.getInstance().view();
								
							}else if(emplo.getRoleid() == 2) {
								System.out.println("Anda adalah Storage Manager");
								frame.dispose();
								SMController.getInstance().view();
								
							}else if(emplo.getRoleid() == 3) {
								System.out.println("Anda adalah Promo Manager");
								frame.dispose();
								PMController.getInstance().view();
								
							}else if(emplo.getRoleid() == 4) {
								System.out.println("Anda adalah Master Manager");
								frame.dispose();
								MController.getInstance().view();
								
							}else if(emplo.getRoleid() == 5) {
								System.out.println("Anda adalah Cashier");
								//Lempar ke View Cashier
								
							}
						}
					}else{
						PopUpController.getInstance().wrongpass();
					}
				}else {
					PopUpController.getInstance().usernamenotfound();
				}
			}
		});
		btnNewButton.setBounds(200, 170, 97, 25);
		frame.getContentPane().add(btnNewButton);
	}
}
