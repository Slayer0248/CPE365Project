package project.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import project.model.DBAccess;
import project.model.Customer;

public class ManageCardsView extends JPanel {
   private int sessionID;
   private Customer customer;
   
   private JTable cardsTable;
   private JTextArea errorMsgLabel;
   private JPanel cardsPanel;
   private JScrollPane cardsScrollPane;
   private String[] columnNames = {"", "", "Card #", "Type", "Credit limit", "Balance", "Active"};
   private ArrayList<Integer> editStates = new ArrayList<Integer>();

   public ManageCardsView(int id, Customer cust) {
      sessionID = id;
      customer = cust;
      setLayout(null);
	  setBounds(0, 0, 450, 300); 
	  
	  JLabel nameLabel = new JLabel("");
		nameLabel.setBounds(6, 6, 94, 16);
		add(nameLabel);
		
		cardsPanel = new JPanel();
		cardsPanel.setBounds(48, 90, 354, 200);
		add(cardsPanel);
		cardsPanel.setLayout(new BorderLayout(0, 0));
		
		cardsTable = new JTable(getTableContent(), columnNames);
		//cardsTable = new JTable();
		cardsTable.setFillsViewportHeight(true);
		
		cardsScrollPane = new JScrollPane(cardsTable);
		cardsScrollPane.setPreferredSize(new Dimension(354, 200));
		cardsPanel.add(cardsScrollPane, BorderLayout.CENTER);
		
		
		errorMsgLabel = new JTextArea("");
		errorMsgLabel.setOpaque(false);
		errorMsgLabel.setFocusable(false);
		errorMsgLabel.setEditable(false);
		errorMsgLabel.setBorder(null);
		errorMsgLabel.setVisible(false);
		errorMsgLabel.setForeground(Color.RED);
		errorMsgLabel.setLineWrap(true);
		errorMsgLabel.setBounds(48, 45, 354, 35);
		add(errorMsgLabel);
		
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