package project.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import project.model.DBAccess;
import project.model.Customer;

public class HomeView extends JPanel {
   private int sessionID;
   private Customer customer;
   
   public HomeView(int id, Customer cust) {
      sessionID = id;
      customer = cust;
      setLayout(null);
	  setBounds(0, 0, 450, 300);
	  
	   JLabel nameLabel = new JLabel("");
	   nameLabel.setBounds(6, 6, 61, 16);
	   add(nameLabel);
	   
	   JButton btnLogOut = new JButton("Log out");
	   btnLogOut.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent e) {
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
	   	}
	   });
	   viewTransactionsButton.setBounds(146, 72, 158, 29);
	   add(viewTransactionsButton);
	   
	   JButton createTransactionButton = new JButton("Create Transaction");
	   createTransactionButton.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent e) {
	   	}
	   });
	   createTransactionButton.setBounds(146, 104, 158, 29);
	   add(createTransactionButton);
	   
	   JButton makePaymentButton = new JButton("Make Payment");
	   makePaymentButton.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent e) {
	   	}
	   });
	   makePaymentButton.setBounds(146, 136, 158, 29);
	   add(makePaymentButton);
	   
	   JButton manageCardsButton = new JButton("Manage Cards");
	   manageCardsButton.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent e) {
	   	}
	   });
	   manageCardsButton.setBounds(146, 168, 158, 29);
	   add(manageCardsButton);
	   
	   JButton manageVendersButton = new JButton("Manage Venders");
	   manageVendersButton.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent e) {
	   	}
	   });
	   manageVendersButton.setBounds(146, 200, 158, 29);
	   add(manageVendersButton);
   }
}