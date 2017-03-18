package project.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import project.model.DBAccess;
import project.model.Customer;

public class CreatePaymentView extends JPanel {
   private final JLabel cardNumLabel = new JLabel("Card Number:");
   private JTextField amountField;
   private JTextField dateField;
   private JTextArea errorMsgLabel;

   private int sessionID;
   private Customer customer;


   public CreatePaymentView(int id, Customer cust) {
      sessionID = id;
      customer = cust;
      setLayout(null);
	  setBounds(0, 0, 450, 300);
	  
	  cardNumLabel.setBounds(60, 115, 87, 16);
	    add(cardNumLabel);
		
		JLabel nameLabel = new JLabel("");
		nameLabel.setBounds(6, 6, 94, 16);
		add(nameLabel);
		   
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(363, 6, 81, 29);
		btnHome.addActionListener(new ActionListener() {
	       public void actionPerformed(ActionEvent e) {
		   }
		});
		add(btnHome);
		
		JLabel amountLabel = new JLabel("Amount:");
		amountLabel.setBounds(93, 147, 54, 16);
		add(amountLabel);
		   
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(113, 179, 38, 16);
		add(lblDate);
		
		JComboBox cardComboBox = new JComboBox();
		cardComboBox.setBounds(155, 111, 175, 27);
		add(cardComboBox);
		   
		   
		   
		amountField = new JTextField();
		amountField.setBounds(155, 143, 175, 26);
		add(amountField);
		amountField.setColumns(10);
		   
		dateField = new JTextField();
		dateField.setBounds(155, 175, 175, 26);
		add(dateField);
		dateField.setColumns(10);
		
		
		errorMsgLabel = new JTextArea("");
		errorMsgLabel.setOpaque(false);
		errorMsgLabel.setFocusable(false);
		errorMsgLabel.setEditable(false);
		errorMsgLabel.setBorder(null);
		errorMsgLabel.setVisible(false);
	    errorMsgLabel.setForeground(Color.RED);
		errorMsgLabel.setLineWrap(true);
		errorMsgLabel.setBounds(48, 207, 354, 60);
		add(errorMsgLabel);
		   
		JButton createButton = new JButton("Create");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		createButton.setBounds(160, 271, 117, 29);
		add(createButton);
   }
}