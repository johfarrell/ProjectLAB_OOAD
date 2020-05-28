package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewMPayment {

	private JFrame frame;
	private JTextField paymentType;
	private JTextField paymentMoney;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public ViewMPayment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 375, 275);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTotalPrice = new JLabel("Total Price:");
		lblTotalPrice.setBounds(55, 64, 72, 14);
		frame.getContentPane().add(lblTotalPrice);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrice.setBounds(144, 63, 114, 14);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblPaymentType = new JLabel("Payment Type:");
		lblPaymentType.setBounds(55, 89, 88, 14);
		frame.getContentPane().add(lblPaymentType);
		
		JLabel lblMoney = new JLabel("Money:");
		lblMoney.setBounds(55, 114, 46, 14);
		frame.getContentPane().add(lblMoney);
		
		paymentType = new JTextField();
		paymentType.setBounds(140, 88, 160, 20);
		frame.getContentPane().add(paymentType);
		paymentType.setColumns(10);
		
		paymentMoney = new JTextField();
		paymentMoney.setBounds(140, 114, 160, 20);
		frame.getContentPane().add(paymentMoney);
		paymentMoney.setColumns(10);
		
		JButton btnProcess = new JButton("PROCESS");
		btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnProcess.setBounds(211, 145, 89, 23);
		frame.getContentPane().add(btnProcess);
	}

}
