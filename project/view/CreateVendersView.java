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
      setLayout(null);
	  setBounds(0, 0, 450, 300);
		
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
		   
		JButton submitButton = new JButton("Create");
		  submitButton.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  	}
		  });
		  submitButton.setBounds(81, 265, 117, 29);
		  add(submitButton);
		  
		  JButton cancelButton = new JButton("Cancel");
		  cancelButton.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  	}
		  });
		  cancelButton.setBounds(259, 265, 117, 29);
		  add(cancelButton);
   }
}