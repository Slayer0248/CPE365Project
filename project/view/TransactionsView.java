package project.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

import project.model.DBAccess;
import project.model.Transaction;
import project.model.Customer;

public class TransactionsView extends JPanel {
   private int sessionID;
   private Customer customer;
   private DBAccess dbaccess;
   
   private JTable transactionsTable;
   private JTextArea errorMsgLabel;
   private JPanel transactionsPanel;
   private JScrollPane transactionsScrollPane;
   private String[] columnNames = {"ID", "Card #", "Reciever Type", "Reciever ID", "Date", "Amount"};
   private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
   private JButton btnAdd;
   private JButton btnDelete;
   private JButton btnUpdate;

   public TransactionsView(int id, Customer cust) {
      sessionID = id;
      customer = cust;
      dbaccess = new DBAccess();
      setLayout(null);
	  setBounds(0, 0, 450, 300); 
	  
	  try {
	  JLabel nameLabel = new JLabel(customer.getName());
		nameLabel.setBounds(6, 6, 94, 16);
		add(nameLabel);
		
		//Possible addition: filter by card and date range
		
		transactionsPanel = new JPanel();
		transactionsPanel.setBounds(48, 90, 390, 160);
		add(transactionsPanel);
		transactionsPanel.setLayout(new BorderLayout(0, 0));
		
		transactionsTable = new JTable(getTableContent(), columnNames);
		//transactionsTable = new JTable();
		transactionsTable.setFillsViewportHeight(true);
		
		transactionsScrollPane = new JScrollPane(transactionsTable);
		transactionsScrollPane.setPreferredSize(new Dimension(390, 160));
		transactionsPanel.add(transactionsScrollPane, BorderLayout.CENTER);

		transactionsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		transactionsTable.getColumnModel().getColumn(0).setPreferredWidth(30);
		transactionsTable.getColumnModel().getColumn(1).setPreferredWidth(70);
		transactionsTable.getColumnModel().getColumn(2).setPreferredWidth(80);
		transactionsTable.getColumnModel().getColumn(3).setPreferredWidth(70);
		transactionsTable.getColumnModel().getColumn(4).setPreferredWidth(80);
		transactionsTable.getColumnModel().getColumn(5).setPreferredWidth(60);
		
		errorMsgLabel = new JTextArea("");
		errorMsgLabel.setOpaque(false);
		errorMsgLabel.setFocusable(false);
		errorMsgLabel.setEditable(false);
		errorMsgLabel.setBorder(null);
		errorMsgLabel.setVisible(false);
		errorMsgLabel.setForeground(Color.RED);
		errorMsgLabel.setLineWrap(true);
		errorMsgLabel.setBounds(48, 45, 390, 20);
		add(errorMsgLabel);

		JButton btnHome = new JButton("Home");
		btnHome.setBounds(363, 6, 81, 29);
		btnHome.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
		   	   try {
		   	      HomeView homeView = new HomeView(sessionID, customer);
				  JPanel current = (JPanel)(((JButton)e.getSource()).getParent());
				  JFrame frame = (JFrame) SwingUtilities.windowForComponent(current);
				  frame.remove(current);
				  frame.invalidate();
				  frame.add(homeView);
				  //frame.pack();
				  frame.revalidate();
				  frame.repaint();
		   	   }
		   	   catch (Exception ex) {
                  ex.printStackTrace(System.out);
               }
		   	}
		   });
		add(btnHome);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   try {
		   	      CreateTransactionView createTransView = new CreateTransactionView(sessionID, customer);
				  JPanel current = (JPanel)(((JButton)e.getSource()).getParent());
				  JFrame frame = (JFrame) SwingUtilities.windowForComponent(current);
				  frame.remove(current);
				  frame.invalidate();
				  frame.add(createTransView);
				  //frame.pack();
				  frame.revalidate();
				  frame.repaint();
		   	   }
		   	   catch (Exception ex) {
                  ex.printStackTrace(System.out);
               }
			}
		});
		btnAdd.setBounds(48, 265, 94, 29);
		add(btnAdd);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   if (transactionsTable.getSelectedRow() == -1) {
			      //error case
			      errorMsgLabel.setText("Error: No row selected to delete");
					errorMsgLabel.setForeground(Color.RED);
					errorMsgLabel.setVisible(true);
				  
				  errorMsgLabel.repaint();
			   }
			   else {
			      //delete and refresh
			   }
			}
		});
		btnDelete.setBounds(178, 265, 94, 29);
		add(btnDelete);
		
		/*btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  if (transactionsTable.getSelectedRow() == -1) {
			      //error case
			      errorMsgLabel.setText("Error: No row selected to update.");
					errorMsgLabel.setForeground(Color.RED);
					errorMsgLabel.setVisible(true);
				  
				  errorMsgLabel.repaint();
			   }
			   else {
			      //delete and refresh
			   }
			}
		});
		btnUpdate.setBounds(306, 265, 94, 29);
		add(btnUpdate);*/
		
		}
		catch (Exception ex) {
           ex.printStackTrace(System.out);
        }
   }
   
   private Object[][] getTableContent() throws Exception {
        dbaccess.open();
        transactions = dbaccess.runTransactionSelect("select * from Transactions where customerID="+customer.getID()+";");
        dbaccess.close();
		
		Object[][] result = new Object[transactions.size()][columnNames.length];
		for (int i=0; i<transactions.size(); i++) {
		    Transaction trans = transactions.get(i);
		    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			result[i][0] = "" +trans.getID();
			result[i][1] = trans.getCardNumber();
			result[i][2] = (trans.getRecieverType() == 0?"Customer":"Vender");
			result[i][3] = "" +trans.getRecieverID();
			result[i][4] = df.format(trans.getTransactionDate());
			result[i][5] = "" + trans.getAmount();
		}
		return result;
	}
}