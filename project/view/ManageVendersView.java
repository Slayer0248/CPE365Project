package project.view;

import javax.swing.*;
import java.awt.*;

import project.model.DBAccess;
import project.model.Customer;

public class ManageVendersView extends JPanel {
   private int sessionID;
   private Customer customer;


   public ManageVendersView(int id, Customer cust) {
      sessionID = id;
      customer = cust;
      setLayout(null);
	  setSize(0, 0, 450, 300); 
   }
}