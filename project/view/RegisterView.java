package project.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import project.model.DBAccess;
import project.model.Customer;

public class RegisterView extends JPanel {
   private int sessionID;
   private DBAccess dbaccess;
   
   private JTextField nameField;
   private JTextField ssnField;
   private JTextField addressField;
   private JTextField phoneField;
   private JTextArea errorMsgLabel;
   private JPasswordField passwordField;

   public RegisterView(int id) {
      sessionID = id;
      dbaccess = new DBAccess();
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
		  	   // replace view for register with login view
		  	   JPanel current = (JPanel)(((JButton)e.getSource()).getParent());
			   JFrame frame = (JFrame) SwingUtilities.windowForComponent(current);
			   LoginView loginView = new LoginView(sessionID);
			   //frame.setSize(450, 300);
			   frame.remove(current);
			   frame.invalidate();
			   frame.add(loginView);
			   frame.revalidate();
			   frame.repaint();
			   
		  	}
		  });
		  loginButton.setBounds(81, 265, 117, 29);
		  add(loginButton);
		  
		  JButton registerButton = new JButton("Register");
		  registerButton.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  	    try {
		  	    String password = new String(passwordField.getPassword());
				String username = nameField.getText();
				String ssn = ssnField.getText();
				String address = addressField.getText();
				String phone = phoneField.getText();
				
				dbaccess.open();
				int loginCount = dbaccess.getCount("select count(*) as count from Customers where name =\"" + username + "\" and password = \"" + password+"\";");
				int ssnCount = dbaccess.getCount("select count(*) as count from Customers where SSN =" + ssn + ";");
				dbaccess.close();
				
				if (username.length() > 100) {
					errorMsgLabel.setText("Error: username length is longer than 100 characters.");
					errorMsgLabel.setForeground(Color.RED);
					errorMsgLabel.setVisible(true);
					
				}
				else if (!isInt(ssn)) {
					errorMsgLabel.setText("Error: SSN must be an Integer.");
					errorMsgLabel.setForeground(Color.RED);
					errorMsgLabel.setVisible(true);
				}
				else if (ssn.length() > 9) {
					errorMsgLabel.setText("Error: SSN length is longer than 9 digits.");
					errorMsgLabel.setForeground(Color.RED);
					errorMsgLabel.setVisible(true);
				}
				else if (address.length() > 100) {
					errorMsgLabel.setText("Error: address length is longer than 100 characters.");
					errorMsgLabel.setForeground(Color.RED);
					errorMsgLabel.setVisible(true);
				}
				else if (!isInt(phone)) {
					errorMsgLabel.setText("Error: Phone number must be an Integer.");
					errorMsgLabel.setForeground(Color.RED);
					errorMsgLabel.setVisible(true);
				}
				else if (phone.length() > 10) {
					errorMsgLabel.setText("Error: Phone number length is longer than 10 digits.");
					errorMsgLabel.setForeground(Color.RED);
					errorMsgLabel.setVisible(true);
				}
				else if (password.length() > 100) {
					errorMsgLabel.setText("Error: password length is longer than 100 characters.");
					errorMsgLabel.setForeground(Color.RED);
					errorMsgLabel.setVisible(true);
				}
				else if (loginCount > 0) {
					errorMsgLabel.setText("Error: This username & password combination already exists.");
					errorMsgLabel.setForeground(Color.RED);
					errorMsgLabel.setVisible(true);
				}
				else if (ssnCount > 0) {
					errorMsgLabel.setText("Error: This SSN already exists.");
					errorMsgLabel.setForeground(Color.RED);
					errorMsgLabel.setVisible(true);
				}
				else {
				    //insert customer into database
				    String query = "Insert into Customers(SSN, name, password, address, phone) values("+ssn+", \""+ username+"\", \"" +password+"\", \""+address+"\", \"" +phone+"\");";
				    dbaccess.open();
				    dbaccess.runUpdate(query);
				    dbaccess.close();
				    
				
				    errorMsgLabel.setText("Customer was added successfully!");
					errorMsgLabel.setForeground(Color.GREEN);
					errorMsgLabel.setVisible(true);
				}
				
				errorMsgLabel.repaint();
				}
                catch (Exception ex) {
                  ex.printStackTrace(System.out);
                }
		  	}
		  });
		  registerButton.setBounds(259, 265, 117, 29);
		  add(registerButton);
		  
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