package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import project.view.LoginView;
import project.model.DBAccess;

public class BankingSystem {
   private static int sessionID;
   private static DBAccess dbaccess;
   
 
   public static void main(String args[]) {
      dbaccess = new DBAccess();
      LoginView loginView;
      JFrame frame = new JFrame("BankingSystem");
      
      try {
         dbaccess.open();
         sessionID = dbaccess.createNewSession();
         dbaccess.close();
      
         loginView = new LoginView(sessionID);
         frame.setMinimumSize(new Dimension(488, 338));
         frame.setSize(488, 338);
         frame.setLayout(null);
         frame.add(loginView);
         //frame.pack();
         frame.setVisible(true);
         frame.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent windowEvent) {
            try {
               dbaccess.open();
               dbaccess.runUpdate("delete from Sessions where sessionID="+sessionID+";");
               dbaccess.close();
            }
            catch (Exception e) {
               e.printStackTrace(System.out);
            }
            System.exit(0);
         }
         });
      }
      catch (Exception e){
         e.printStackTrace(System.out);
      }
      
      
      
      
      
   }
}