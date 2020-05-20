package view;

import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.MController;
import model.TransactionItemModel;
import model.TransactionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewMDetail {
	
	private DefaultTableModel dtm;
	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public ViewMDetail() {
		table();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Transaction Detail");
		frame.setBounds(100, 100, 300, 175);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 264, 80);
		frame.getContentPane().add(scrollPane);
		
		scrollPane.setViewportView(table);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnClose.setBounds(95, 102, 89, 23);
		frame.getContentPane().add(btnClose);
	}
	
	void table(){
		Vector<String> header = new Vector<String>();
		header.add("TransactionID");
		header.add("ProductID");
		header.add("Quantity");
		Vector<TransactionItemModel> transactionitem = new Vector<TransactionItemModel>();
		System.out.print(ViewM.getTransactionIDView());
		String X = ViewM.getTransactionIDView().toString();
		transactionitem = MController.getInstance().getAllTransactionItem(X);
		dtm = new DefaultTableModel(header,0);
		table = new JTable(dtm);
		table.getTableHeader();
		for(TransactionItemModel transaction2 : transactionitem){
			Vector<Object> data = new Vector<Object>();
			data.add(transaction2.getTransactionID());
			data.add(transaction2.getProductID());
			data.add(transaction2.getQuantity());
			dtm.addRow(data);
		}
	}
}
