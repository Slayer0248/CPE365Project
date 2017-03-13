package project.view;

import javax.swing.*;
import java.awt.*;

import project.model.DBAccess;
import project.model.Customer;

public class ManageCardsView extends JPanel {
   private int sessionID;
   private Customer customer;

   public ManageCardsView(int id, Customer cust) {
      sessionID = id;
      customer = cust;
      setLayout(null);
	  setSize(450, 300); 
   }
}