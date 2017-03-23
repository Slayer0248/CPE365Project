package project.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.text.*;
import java.util.regex.*;

import project.model.DBAccess;
import project.model.Customer;
import project.model.Transaction;
import project.model.Ownership;
import project.model.Vender;

public class CreateTransactionView extends JPanel {
   private final JLabel cardNumLabel = new JLabel("Card Number:");
   private JTextField amountField;
   private JTextField dateField;
   private JTextArea errorMsgLabel;
   private JRadioButton venderRadioButton;
   private JRadioButton customerRadioButton;
   private JComboBox recieverComboBox;
   private JComboBox cardComboBox;
   private ButtonGroup typeGroup;

   private int sessionID;
   private Customer customer;
   //private Transaction curTrans;

   private DBAccess dbaccess;

   public CreateTransactionView(int id, Customer cust) {
      sessionID = id;
      customer = cust;
      //curTrans = trans; //if null, then we're creating a new transaction
      setLayout(null);
	  setBounds(0, 0, 450, 300);

	  dbaccess = new DBAccess();
	  
	  cardNumLabel.setBounds(60, 115, 87, 16);
       add(cardNumLabel);
       
       JLabel nameLabel = new JLabel(customer.getName());
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
	   
	   JLabel recieverTypeLabel = new JLabel("To:");
	   recieverTypeLabel.setBounds(126, 55, 24, 16);
	   add(recieverTypeLabel);
	   
	   JLabel recieverIDLabel = new JLabel("Id:");
	   recieverIDLabel.setBounds(130, 83, 22, 16);
	   add(recieverIDLabel);
	   
	   JLabel amountLabel = new JLabel("Amount:");
	   amountLabel.setBounds(93, 147, 54, 16);
	   add(amountLabel);
	   
	   JLabel lblDate = new JLabel("Date (mm/dd/yyyy):");
	   lblDate.setBounds(21, 179, 150, 16);
	   add(lblDate);
	   
	   typeGroup = new ButtonGroup();
	   typeGroup.add(venderRadioButton);
	   typeGroup.add(customerRadioButton);
	   
	   try {
		   dbaccess.open();
		   ArrayList<Ownership> owns = dbaccess.runOwnershipSelect("select * from Ownership where customerID=" + cust.getID() + ";");
		   ArrayList<Vender> vends = dbaccess.runVenderSelect("select * from Venders;");
		   ArrayList<Customer> customs = dbaccess.runCustomerSelect("select * from Customers;");
		   dbaccess.close();

	   	   cardComboBox = new JComboBox(owns.toArray());
	       cardComboBox.setBounds(155, 111, 175, 27);
	       add(cardComboBox);

	       recieverComboBox = new JComboBox(vends.toArray());
		   recieverComboBox.setBounds(155, 79, 175, 27);
		   add(recieverComboBox);

	       venderRadioButton = new JRadioButton("Vender");
	       customerRadioButton = new JRadioButton("Customer");
	   	   venderRadioButton.setBounds(160, 51, 81, 23);
	       venderRadioButton.setActionCommand("0");
	       venderRadioButton.setSelected(true);
	       venderRadioButton.addItemListener(new ItemListener() {
		   	   public void itemStateChanged(ItemEvent e) {

			   	   	if (e.getStateChange() == ItemEvent.SELECTED) {
						recieverComboBox.removeAllItems();
						remove(recieverComboBox);
						recieverComboBox = new JComboBox(vends.toArray());
						recieverComboBox.setBounds(155, 79, 175, 27);
		   				add(recieverComboBox);
		   				customerRadioButton.setSelected(false);	
			   	   	}	   	   		    
		   	   }
	   	   });
	   	   add(venderRadioButton);

	   	   
		   customerRadioButton.setBounds(249, 51, 94, 23);
		   customerRadioButton.setActionCommand("1");
		   customerRadioButton.addItemListener(new ItemListener() {
		   	   public void itemStateChanged(ItemEvent e) {

			   	   	if (e.getStateChange() == ItemEvent.SELECTED) {
						recieverComboBox.removeAllItems();
						remove(recieverComboBox);
						recieverComboBox = new JComboBox(customs.toArray());
						recieverComboBox.setBounds(155, 79, 175, 27);
		   				add(recieverComboBox);	
		   				venderRadioButton.setSelected(false);
			   	   	}	   	   		    
		   	   }
	   	   });
		   add(customerRadioButton);

	   }
	   catch (Exception ex) {
           ex.printStackTrace(System.out);
       }
	   
	   
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
	   
	   JButton submitButton = new JButton("Create");
			  submitButton.addActionListener(new ActionListener() {
			  	public void actionPerformed(ActionEvent e) {
			  	
			  	try {
			  	  String amt;
			  	  String date;
			  	  boolean vendButton;
			  	  boolean custButton;
			  	  // persist transaction

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
			  submitButton.setBounds(81, 271, 117, 29);
			  add(submitButton);
			  
			  JButton cancelButton = new JButton("Cancel");
			  cancelButton.addActionListener(new ActionListener() {
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
			  cancelButton.setBounds(259, 271, 117, 29);
			  add(cancelButton);
   }
   
   
   public boolean isValidDate(String input, String format) {
    //boolean valid = false;

    try {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.parse(input);
    } catch (Exception ignore) {
       return false;
    }

    return true;
   }
   
    public boolean isDouble(String val) {
      String decimalPattern = "([0-9]*)\\.([0-9]*)";  
      boolean match = Pattern.matches(decimalPattern, val);
      return match;
   }
   
   private boolean isInt(String s) {
        for(int i = 0; i < s.length(); i++){
            if(!Character.isDigit(s.charAt(i))){
                 return false;
            }
        }
        return true;
   }
}
