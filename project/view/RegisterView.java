package project.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import project.model.DBAccess;
import project.model.Customer;

public class RegisterView extends JPanel {
   private int sessionID;
   private JTextField nameField;
   private JTextField ssnField;
   private JTextField addressField;
   private JTextField phoneField;
   private JTextArea errorMsgLabel;
   private JPasswordField passwordField;

   public RegisterView(int id) {
      sessionID = id;
      setLayout(null);
	  setBounds(0, 0, 450, 300);
	  
	  	  JLabel nameLabel = new JLabel("Name:");
		  nameLabel.setBounds(141, 48, 46, 16);
		  add(nameLabel);
		  
		  JLabel ssnLabel = new JLabel("SSN:");
		  ssnLabel.setBounds(152, 77, 35, 16);
		  add(ssnLabel);
		  
		  JLabel addressLabel = new JLabel("Address:");
		  addressLabel.setBounds(126, 106, 61, 16);
		  add(addressLabel);
		  
		  JLabel phoneLabel = new JLabel("Phone:");
		  phoneLabel.setBounds(139, 135, 46, 16);
		  add(phoneLabel);
		  
		  JLabel passwordLabel = new JLabel("Password:");
		  passwordLabel.setBounds(119, 164, 68, 16);
		  add(passwordLabel);
		  
		  JLabel signupLabel = new JLabel("Sign Up");
		  signupLabel.setBounds(204, 20, 61, 16);
		  add(signupLabel);
		  
		  
		  nameField = new JTextField();
		  nameField.setBounds(194, 43, 130, 26);
		  add(nameField);
		  nameField.setColumns(10);
		  
		  ssnField = new JTextField();
		  ssnField.setBounds(194, 72, 130, 26);
		  add(ssnField);
		  ssnField.setColumns(10);
		  
		  addressField = new JTextField();
		  addressField.setBounds(194, 101, 130, 26);
		  add(addressField);
		  addressField.setColumns(10);
		  
		  phoneField = new JTextField();
		  phoneField.setBounds(194, 130, 130, 26);
		  add(phoneField);
		  phoneField.setColumns(10);
		  
		  passwordField = new JPasswordField();
		  passwordField.setBounds(194, 159, 130, 26);
		  add(passwordField);
		  
		  errorMsgLabel = new JTextArea("");
		  errorMsgLabel.setOpaque(false);
		  errorMsgLabel.setFocusable(false);
		  errorMsgLabel.setEditable(false);
		  errorMsgLabel.setBorder(null);
		  errorMsgLabel.setVisible(false);
		  errorMsgLabel.setForeground(Color.RED);
		  errorMsgLabel.setLineWrap(true);
		  errorMsgLabel.setBounds(48, 218, 354, 35);
		  add(errorMsgLabel);
		  
		  JButton loginButton = new JButton("Login");
		  loginButton.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  	}
		  });
		  loginButton.setBounds(81, 265, 117, 29);
		  add(loginButton);
		  
		  JButton registerButton = new JButton("Register");
		  registerButton.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  	}
		  });
		  registerButton.setBounds(259, 265, 117, 29);
		  add(registerButton);
		  
   }
}