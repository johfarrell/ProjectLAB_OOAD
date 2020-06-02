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

public class ResetSuccess {

	private JFrame frame;
	private JLabel newPass;
	private String password="";
	

	/**
	 * Create the application.
	 */
	public ResetSuccess(String password) {
		initialize();
		newPass.setText("New password: "+password);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 205);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Password Updated!");
		lblNewLabel.setForeground(new Color(46, 139, 87));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(12, 30, 258, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JButton okButton = new JButton("OK");
		okButton.setBounds(92, 108, 97, 25);
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		frame.getContentPane().add(okButton);
				
		newPass = new JLabel("******");
		newPass.setHorizontalAlignment(SwingConstants.CENTER);
		newPass.setBounds(0, 59, 282, 16);
		frame.getContentPane().add(newPass);
	}
}
