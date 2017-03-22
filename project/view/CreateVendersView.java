package project.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

import project.model.DBAccess;
import project.model.Customer;
import project.model.Vender;
import project.model.Ownership;

public class CreateVendersView extends JPanel {
   private JTextField nameField;
   private JTextField officesField;
   private JTextArea errorMsgLabel;
   
   private int sessionID;
   private Customer customer;
   private Vender curVender;

   private DBAccess dbaccess;

   public CreateVendersView(int id, Customer cust, Vender vender) {
      	sessionID = id;
      customer = cust;
      curVender = vender; //if null, the we're creating a new vender
      dbaccess = new DBAccess();
      setLayout(null);
	  setBounds(0, 0, 450, 300);
		
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
		
		JLabel vNameLabel = new JLabel("Name:");
		vNameLabel.setBounds(98, 111, 50, 16);
		add(vNameLabel);
		   
		JLabel lblOffices = new JLabel("Offices:");
		lblOffices.setBounds(93, 143, 58, 16);
		add(lblOffices);
		
		/*JComboBox cardComboBox = new JComboBox();
		cardComboBox.setBounds(155, 111, 175, 27);
		add(cardComboBox);*/
		   
		   
		   
		nameField = new JTextField();
		nameField.setBounds(155, 107, 175, 26);
		add(nameField);
		nameField.setColumns(10);
		   
		officesField = new JTextField();
		officesField.setBounds(155, 139, 175, 26);
		add(officesField);
		officesField.setColumns(10);
		
		
		errorMsgLabel = new JTextArea("");
		errorMsgLabel.setOpaque(false);
		errorMsgLabel.setFocusable(false);
		errorMsgLabel.setEditable(false);
		errorMsgLabel.setBorder(null);
		errorMsgLabel.setVisible(false);
	    errorMsgLabel.setForeground(Color.RED);
		errorMsgLabel.setLineWrap(true);
		errorMsgLabel.setBounds(48, 171, 354, 60);
		add(errorMsgLabel);
		   
		if (curVender!= null) {
		   //update
		   nameField.setText(curVender.getName());
		   officesField.setText(curVender.getOffices());
		}
		JButton submitButton = new JButton("Create");
		  submitButton.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  	   try {
		  	      String name = nameField.getText();
		  	      String offices = officesField.getText();
		  	      if (name.length() > 100) {
		  	         errorMsgLabel.setText("Error: Name can't be longer than 100 characters.");
					errorMsgLabel.setForeground(Color.RED);
					errorMsgLabel.setVisible(true);  
					errorMsgLabel.repaint(); 
		  	      }
		  	      else if (offices.length() > 100) {
		  	         errorMsgLabel.setText("Error: Offices can't be longer than 100 characters.");
					errorMsgLabel.setForeground(Color.RED);
					errorMsgLabel.setVisible(true);  
					errorMsgLabel.repaint(); 
					
		  	      }
		  	      else {
		  	      
		  	      dbaccess.open();
		  	      if (curVender!= null) {
		             //update
		             dbaccess.runUpdate("Update Venders set name = \"" + name + "\", offices = \""+offices+"\" where venderID= "+curVender.getID()+";");
		          }
		          else {
		             //create
		             dbaccess.runUpdate("Insert into Venders(name, offices) Values (\"" + name + "\", \"" +offices+"\");");
		          }
		          dbaccess.close();
		  	   
		   	      ManageVendersView manageVendersView = new ManageVendersView(sessionID, customer);
				  JPanel current = (JPanel)(((JButton)e.getSource()).getParent());
				  JFrame frame = (JFrame) SwingUtilities.windowForComponent(current);
				  frame.remove(current);
				  frame.invalidate();
				  frame.add(manageVendersView);
				  //frame.pack();
				  frame.revalidate();
				  frame.repaint();
				  }
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
		   	      ManageVendersView manageVendersView = new ManageVendersView(sessionID, customer);
				  JPanel current = (JPanel)(((JButton)e.getSource()).getParent());
				  JFrame frame = (JFrame) SwingUtilities.windowForComponent(current);
				  frame.remove(current);
				  frame.invalidate();
				  frame.add(manageVendersView);
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