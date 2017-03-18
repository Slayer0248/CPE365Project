package project;

import javax.swing.*;
import java.awt.*;

import project.view.LoginView;
import project.model.DBAccess;

public class BankingSystem {
   private int sessionID;
   private static DBAccess dbaccess;
   
 
   public static void main(String args[]) {
      dbaccess = new DBAccess();
      
      
      dbaccess.open();
      sessionID = dbaccess.createNewSession();
      dbaccess.close();
      
      LoginView loginView = new LoginView(sessionID);
      
      JFrame frame = new JFrame("BankingSystem");
      frame.addWindowListener(new java.awt.event.WindowAdapter() {
         @Override
         public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            dbaccess.open();
            dbaccess.runUpdate("delete from Sessions where sessionID="+sessionID+";");
            dbaccess.close();
            System.exit(0);
         }
      });
      frame.setSize(450, 300);
      frame.getContentPane().setLayout(null);
      frame.getContentPane().add(loginView);
      frame.setVisible(true);
   }
}