package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginForm {

	
	public LoginForm() {
		initComponents();
		
	}
	
	
	
	public void initComponents(){
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setSize(550,350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		
		panel.setLayout(null);

		JLabel title = new JLabel("Sudutmeong Login");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(12, 28, 508, 30);
		title.setFont(title.getFont ().deriveFont (20f));
		panel.add(title);

		JLabel username = new JLabel("Username:");
		username.setBounds(150, 85, 70, 35);
		panel.add(username);
		JFormattedTextField usernamefield = new JFormattedTextField();
		usernamefield.setBounds(250, 85, 135, 35);
		panel.add(usernamefield);

		JLabel password = new JLabel("Password:");
		password.setBounds(150, 145, 70, 35);
		panel.add(password);
		JPasswordField passwordfield = new JPasswordField();
		passwordfield.setBounds(250, 145, 135, 35);
		panel.add(passwordfield);
		
		JButton loginbutton = new JButton("Login");
		loginbutton.setBounds(200, 215, 130, 32);
		panel.add(loginbutton);
		
		frame.setVisible(true);
		
		loginbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				String username;
				char[] password;
				
				username = usernamefield.getText();
				password = passwordfield.getPassword();
				
				//Check Hasil Form di terminal
				System.out.println(username);
				System.out.println(password);
			}
		});
		
		
	}

}
