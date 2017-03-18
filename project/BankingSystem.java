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
      
      try {
         dbaccess.open();
         sessionID = dbaccess.createNewSession();
         dbaccess.close();
      
         loginView = new LoginView(sessionID);
      }
      catch (Exception ex){
         e.printStackTrace(System.out);
      }
      
      JFrame frame = new JFrame("BankingSystem");
      frame.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent windowEvent) {
            try {
               dbaccess.open();
               dbaccess.runUpdate("delete from Sessions where sessionID="+sessionID+";");
               dbaccess.close();
            }
            catch (Exception ex) {
               e.printStackTrace(System.out);
            }
            System.exit(0);
         }
      });
      
      frame.setSize(450, 300);
      frame.getContentPane().setLayout(null);
      frame.getContentPane().add(loginView);
      frame.setVisible(true);
   }
}