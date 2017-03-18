package project.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import project.model.DBAccess;
import project.model.Customer;

public class ManageBudgetsView extends JPanel {
   private int sessionID;
   private Customer customer;


   public ManageBudgetsView(int id, Customer cust) {
      sessionID = id;
      customer = cust;
      setLayout(null);
	  setBounds(0, 0, 450, 300);
   }
}