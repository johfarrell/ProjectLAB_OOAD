import javax.swing.*;

public class LoginForm {

	public LoginForm() {
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setSize(550,350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);

		JLabel title = new JLabel("Sudutmeong Login");
		title.setBounds(180, 28, 300, 30);
		title.setFont(title.getFont ().deriveFont (20f));
		panel.add(title);

		JLabel username = new JLabel("Username:");
		username.setBounds(150, 85, 132, 35);
		panel.add(username);
		JFormattedTextField usernamefield = new JFormattedTextField();
		usernamefield.setBounds(250, 85, 135, 35);
		panel.add(usernamefield);

		JLabel password = new JLabel("Password:");
		password.setBounds(150, 145, 132, 35);
		panel.add(password);
		JPasswordField passwordfield = new JPasswordField();
		passwordfield.setBounds(250, 145, 135, 35);
		panel.add(passwordfield);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(200, 200, 130, 32);
		panel.add(btnNewButton);
		
		frame.setVisible(true);
	}

}
