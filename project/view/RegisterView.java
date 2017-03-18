package project.view;

import javax.swing.*;
import java.awt.*;

import project.model.DBAccess;
import project.model.Customer;

public class RegisterView extends JPanel {
   private int sessionID;

   public RegisterView(int id) {
      sessionID = id;
      setLayout(null);
	  setBounds(0, 0, 450, 300);
   }
}