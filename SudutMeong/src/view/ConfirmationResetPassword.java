package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.EmployeeHandler;
import controller.VoucherHandler;

public class ConfirmationResetPassword implements ActionListener{

	private JFrame frame;
	private JButton yesButton;
	private JButton noButton;
	private Integer EmployeeID=0;
	/**
	 * Create the application.
	 */
	public ConfirmationResetPassword(Integer EmployeeID) {
		this.EmployeeID = EmployeeID;
		initialize();
		addlistener();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 200);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Are you sure you want to reset the password ?");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 30, 382, 16);
		frame.getContentPane().add(lblNewLabel);
		
		yesButton = new JButton("YES");
		yesButton.setForeground(new Color(46, 139, 87));
		yesButton.setBounds(220, 88, 100, 30);
		frame.getContentPane().add(yesButton);
		
		noButton = new JButton("NO");
		noButton.setForeground(Color.RED);
		noButton.setBounds(62, 88, 100, 30);
		frame.getContentPane().add(noButton);
	}

	private void addlistener() {
		// TODO Auto-generated method stub
		yesButton.addActionListener(this);
		noButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(yesButton)){
			EmployeeHandler.getInstance().resetPassword(EmployeeID);
			frame.dispose();
		}else if(e.getSource().equals(noButton)) {
			frame.dispose();
		}
	}

}
