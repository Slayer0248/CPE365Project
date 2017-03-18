package project.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import project.model.DBAccess;
import project.model.Customer;

public class TransactionsView extends JPanel {
   private int sessionID;
   private Customer customer;
   private JTable transactionsTable;
   private JPanel transactionsPanel;
   private JScrollPane transactionsScrollPane;
   private String[] columnNames = {"ID", "CustomerID", "Card #", "Reciever Type", "Reciever ID", "Date", "Amount"};

   public TransactionsView(int id, Customer cust) {
      sessionID = id;
      customer = cust;
      setLayout(null);
	  setBounds(0, 0, 450, 300); 
	  
	  JLabel nameLabel = new JLabel("");
		nameLabel.setBounds(6, 6, 94, 16);
		add(nameLabel);
		
		//Possible addition: filter by card and date range
		
		transactionsPanel = new JPanel();
		transactionsPanel.setBounds(48, 90, 354, 200);
		add(transactionsPanel);
		transactionsPanel.setLayout(new BorderLayout(0, 0));
		
		transactionsTable = new JTable(null, columnNames);
		//transactionsTable = new JTable();
		transactionsTable.setFillsViewportHeight(true);
		
		transactionsScrollPane = new JScrollPane(transactionsTable);
		transactionsScrollPane.setPreferredSize(new Dimension(354, 200));
		transactionsPanel.add(transactionsScrollPane, BorderLayout.CENTER);

		JButton btnHome = new JButton("Home");
		btnHome.setBounds(363, 6, 81, 29);
		btnHome.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
		   	}
		   });
		add(btnHome);
   }
   
   private Object[][] getTableContent() {
		int rowCount = 1;
		Object[][] result = new Object[rowCount][columnNames.length];
		for (int i=0; i<rowCount; i++) {
			if (i<rowCount-1) {
				
				
			}
			else {
				JButton btnAdd = new JButton("+");
				btnAdd.setBounds(0, 0, 20, 29);
				result[i][0] = btnAdd;
				
				for (int j=1; j<columnNames.length; j++) {
					result[i][j] = "";
				}
				
			}
		}
		return result;
	}
}