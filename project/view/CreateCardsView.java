package project.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

import project.model.DBAccess;
import project.model.Customer;
import project.model.CreditCard;
import project.model.Ownership;

public class CreateCardsView extends JPanel {
   private final JLabel cardNumLabel = new JLabel("Card Number:");
   private JTextField creditLimitField;
   private JTextField balanceField;
   private JTextField cardField;
   private JTextArea errorMsgLabel;
   private JCheckBox currentCheckBox;
   private JCheckBox activeCheckBox;
   private JComboBox cardTypeComboBox;
	
	
   private int sessionID;
   private Customer customer;
   private CreditCard curCard;
   private Ownership curOwnership;

   private DBAccess dbaccess;
   
   public CreateCardsView(int id, Customer cust, CreditCard card, Ownership ownership) {
      sessionID = id;
      customer = cust;
      curCard = card; //if null, the we're creating a new card
      curOwnership = ownership;
      dbaccess = new DBAccess();
      setLayout(null);
	  setBounds(0, 0, 450, 300);
	  
	       cardNumLabel.setBounds(60, 83, 87, 16);
	       add(cardNumLabel);
	       
	       JLabel nameLabel = new JLabel("");
		   nameLabel.setBounds(6, 6, 94, 16);
		   add(nameLabel);
		   
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
		   
		   JLabel cardTypeLabel = new JLabel("Type:");
		   cardTypeLabel.setBounds(113, 115, 39, 16);
		   add(cardTypeLabel);
		   
		   JLabel creditLimitLabel = new JLabel("Credit limit:");
		   creditLimitLabel.setBounds(72, 147, 75, 16);
		   add(creditLimitLabel);
		   
		   JLabel lblBalance = new JLabel("Balance:");
		   lblBalance.setBounds(95, 179, 57, 16);
		   add(lblBalance);
		   
		   currentCheckBox = new JCheckBox("Current");
		   currentCheckBox.setBounds(160, 51, 81, 23);
		   currentCheckBox.setActionCommand("current");
		   add(currentCheckBox);
		   
		   activeCheckBox = new JCheckBox("Active");
		   activeCheckBox.setBounds(249, 51, 94, 23);
		   activeCheckBox.setActionCommand("active");
		   add(activeCheckBox);
		   
		   
		   /*recieverComboBox = new JComboBox();
		   recieverComboBox.setBounds(155, 79, 175, 27);
		   add(recieverComboBox);*/
		   
		   cardTypeComboBox = new JComboBox();
		   cardTypeComboBox.setBounds(155, 111, 175, 27);
		   add(cardTypeComboBox);
		   
		   
		   
		   creditLimitField = new JTextField();
		   creditLimitField.setBounds(155, 143, 175, 26);
		   add(creditLimitField);
		   creditLimitField.setColumns(10);
		   
		   balanceField = new JTextField();
		   balanceField.setBounds(155, 175, 175, 26);
		   add(balanceField);
		   balanceField.setColumns(10);
		   
		   cardField = new JTextField();
		   cardField.setBounds(155, 79, 175, 26);
		   add(cardField);
		   cardField.setColumns(10);
		   
		   errorMsgLabel = new JTextArea("");
		   errorMsgLabel.setOpaque(false);
		   errorMsgLabel.setFocusable(false);
		   errorMsgLabel.setEditable(false);
		   errorMsgLabel.setBorder(null);
		   errorMsgLabel.setVisible(false);
		   errorMsgLabel.setForeground(Color.RED);
		   errorMsgLabel.setLineWrap(true);
		   errorMsgLabel.setBounds(48, 207, 354, 55);
		   add(errorMsgLabel);
		   
		   if (curCard != null && curOwnership != null) {
		     //set with current values
		   }
		   
		   JButton submitButton = new JButton(curCard != null? "Update":"Create");
			  submitButton.addActionListener(new ActionListener() {
			  	public void actionPerformed(ActionEvent e) {
			  	 try {
			  	  dbaccess.open();
			  	 
			  	  if (curCard != null && curOwnership != null) {
		             //update
		          }
		          else  {
		             //create
		             
		          }
		          
		          ManageCardsView manageCardsView = new ManageCardsView(sessionID, customer);
				  JPanel current = (JPanel)(((JButton)e.getSource()).getParent());
				  JFrame frame = (JFrame) SwingUtilities.windowForComponent(current);
				  frame.remove(current);
				  frame.invalidate();
				  frame.add(manageCardsView);
				  //frame.pack();
				  frame.revalidate();
				  frame.repaint();
				  }
		          catch (Exception ex) {
                  ex.printStackTrace(System.out);
                 }
			  	}
			  });
			  submitButton.setBounds(81, 265, 117, 29);
			  add(submitButton);
			  
			  JButton cancelButton = new JButton("Cancel");
			  cancelButton.addActionListener(new ActionListener() {
			  	public void actionPerformed(ActionEvent e) {
			  	  try {
		   	      ManageCardsView manageCardsView = new ManageCardsView(sessionID, customer);
				  JPanel current = (JPanel)(((JButton)e.getSource()).getParent());
				  JFrame frame = (JFrame) SwingUtilities.windowForComponent(current);
				  frame.remove(current);
				  frame.invalidate();
				  frame.add(manageCardsView);
				  //frame.pack();
				  frame.revalidate();
				  frame.repaint();
		   	   }
		   	   catch (Exception ex) {
                  ex.printStackTrace(System.out);
               }
			  	}
			  });
			  cancelButton.setBounds(259, 265, 117, 29);
			  add(cancelButton);
   }
}