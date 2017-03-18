package project.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import project.model.DBAccess;
import project.model.Customer;

public class LoginView extends JPanel {
   private JTextField usernameField;
   private JPasswordField passwordField;
   private JTextArea errorMsgLabel;
   private int sessionID;

   public LoginView(int id) {
        sessionID = id;
      	setLayout(null);
		setBounds(0, 0, 450, 300);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(111, 106, 66, 16);
		add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(114, 134, 63, 16);
		add(passwordLabel);
		
		usernameField = new JTextField();
		usernameField.setEditable(true);
		usernameField.setEnabled(true);
		usernameField.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		usernameField.setBounds(189, 101, 130, 26);
		add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setEditable(true);
		passwordField.setEnabled(true);
		passwordField.setBounds(189, 129, 130, 26);
		add(passwordField);
		
		errorMsgLabel = new JTextArea("");
		errorMsgLabel.setOpaque(false);
		errorMsgLabel.setFocusable(false);
		errorMsgLabel.setEditable(false);
		errorMsgLabel.setBorder(null);
		errorMsgLabel.setVisible(false);
		errorMsgLabel.setForeground(Color.RED);
		errorMsgLabel.setLineWrap(true);
		errorMsgLabel.setBounds(48, 170, 354, 60);
		add(errorMsgLabel);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = new String(passwordField.getPassword());
				String username = usernameField.getText();
				if (username.length() > 100) {
					errorMsgLabel.setText("Error: username length is longer than 100 characters.");
					errorMsgLabel.setVisible(true);
				}
				else if (password.length() > 100) {
					errorMsgLabel.setText("Error: password length is longer than 100 characters.");
					errorMsgLabel.setVisible(true);
				}
				
				//Run select query to get the customers
				
				//error check select results 
				
				// update sessions table given current session id
				
				// replace view for login with Home
				
				
			}
		});
		loginButton.setBounds(106, 247, 117, 29);
		add(loginButton);
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// replace view for login with Register view
				
			}
		});
		registerButton.setBounds(251, 247, 117, 29);
		add(registerButton);
   }
}