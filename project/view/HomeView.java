package project.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import project.model.DBAccess;
import project.model.Customer;

public class HomeView extends JPanel {
   private int sessionID;
   private Customer customer;
   private DBAccess dbaccess;
   
   public HomeView(int id, Customer cust) {
      sessionID = id;
      customer = cust;
      dbaccess = new DBAccess();
      setLayout(null);
	  setBounds(0, 0, 450, 300);
	  
	   JLabel nameLabel = new JLabel(cust.getName());
	   nameLabel.setBounds(6, 6, 250, 16);
	   add(nameLabel);
	   
	   JButton btnLogOut = new JButton("Log out");
	   btnLogOut.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent e) {
	   	   try {
	   	      dbaccess.open();
		      dbaccess.runUpdate("Update Sessions set customerID = NULL, loginDate = NULL where sessionID = "+sessionID+";");
		      dbaccess.close();
		  
		      // replace view for login with Home
		      LoginView loginView = new LoginView(sessionID);
		      JPanel current = (JPanel)(((JButton)e.getSource()).getParent());
		      JFrame frame = (JFrame) SwingUtilities.windowForComponent(current);
		      frame.remove(current);
			  frame.invalidate();
			  frame.add(loginView);
			  //frame.pack();
			  frame.revalidate();
			  frame.repaint();
		   }
           catch (Exception ex) {
              ex.printStackTrace(System.out);
           }
	   	}
	   });
	   btnLogOut.setBounds(333, 6, 117, 29);
	   add(btnLogOut);
	   
	   JLabel menuLabel = new JLabel("Menu");
	   menuLabel.setBounds(205, 44, 40, 16);
	   add(menuLabel);
	   
	   JButton viewTransactionsButton = new JButton("View Transactions");
	   viewTransactionsButton.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent e) {
	   	   try {
	   	      TransactionsView transView = new TransactionsView(sessionID, customer);
	   	      JPanel current = (JPanel)(((JButton)e.getSource()).getParent());
		      JFrame frame = (JFrame) SwingUtilities.windowForComponent(current);
		      frame.remove(current);
			  frame.invalidate();
			  frame.add(transView);
			  //frame.pack();
			  frame.revalidate();
			  frame.repaint();
	   	   }
	   	   catch (Exception ex) {
              ex.printStackTrace(System.out);
           }
	   	}
	   });
	   viewTransactionsButton.setBounds(146, 72, 158, 29);
	   add(viewTransactionsButton);
	   
	   /*JButton createTransactionButton = new JButton("Create Transaction");
	   createTransactionButton.addActionListener(new ActionListener() {
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
	   createTransactionButton.setBounds(146, 104, 158, 29);
	   add(createTransactionButton);*/
	   
	   JButton makePaymentButton = new JButton("Make Payment");
	   makePaymentButton.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent e) {
	   	   try {
	   	      CreatePaymentView createPaymentView = new CreatePaymentView(sessionID, customer);
	   	      JPanel current = (JPanel)(((JButton)e.getSource()).getParent());
		      JFrame frame = (JFrame) SwingUtilities.windowForComponent(current);
		      frame.remove(current);
			  frame.invalidate();
			  frame.add(createPaymentView);
			  //frame.pack();
			  frame.revalidate();
			  frame.repaint();
	   	   }
	   	   catch (Exception ex) {
              ex.printStackTrace(System.out);
           }
	   	}
	   });
	   makePaymentButton.setBounds(146, 104, 158, 29);
	   add(makePaymentButton);
	   
	   JButton manageCardsButton = new JButton("Manage Cards");
	   manageCardsButton.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent e) {
	   	   try {
	   	      ManageCardsView manageCards = new ManageCardsView(sessionID, customer);
	   	      JPanel current = (JPanel)(((JButton)e.getSource()).getParent());
		      JFrame frame = (JFrame) SwingUtilities.windowForComponent(current);
		      frame.remove(current);
			  frame.invalidate();
			  frame.add(manageCards);
			  //frame.pack();
			  frame.revalidate();
			  frame.repaint();
	   	   }
	   	   catch (Exception ex) {
              ex.printStackTrace(System.out);
           }
	   	}
	   });
	   manageCardsButton.setBounds(146, 136, 158, 29);
	   add(manageCardsButton);
	   
	   JButton manageVendersButton = new JButton("Manage Venders");
	   manageVendersButton.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent e) {
	   	   try {
	   	      ManageVendersView manageVenders = new ManageVendersView(sessionID, customer);
	   	      JPanel current = (JPanel)(((JButton)e.getSource()).getParent());
		      JFrame frame = (JFrame) SwingUtilities.windowForComponent(current);
		      frame.remove(current);
			  frame.invalidate();
			  frame.add(manageVenders);
			  //frame.pack();
			  frame.revalidate();
			  frame.repaint();
	   	   }
	   	   catch (Exception ex) {
              ex.printStackTrace(System.out);
           }
	   	}
	   });
	   manageVendersButton.setBounds(146, 168, 158, 29);
	   add(manageVendersButton);
   }
}