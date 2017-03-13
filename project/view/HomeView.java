package project.view;

import javax.swing.*;
import java.awt.*;

import project.model.DBAccess;
import project.model.Customer;

public class HomeView extends JPanel {
   private int sessionID;
   private Customer customer;
   
   public HomeView(int id, Customer cust) {
      sessionID = id;
      customer = cust;
      setLayout(null);
	  setSize(450, 300);
   }
}