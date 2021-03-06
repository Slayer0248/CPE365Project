package project.model;

import java.util.*;

public class Session {

   private int sessionID;
   private int customerID;
   private Date loginDate; // for canceling credit card. single bit? 

   public Session(int id) {
      sessionID = id;
      customerID = -1;
      loginDate = null;
   }
   
   public Session(int id, int customer, Date date) {
      sessionID = id;
      customerID = customer;
      loginDate = date;
   }
   
   public int getID() {
      return sessionID;
   }
   
   public void setID(int id) {
      sessionID = id;
   }
   
   public int getCustomerID() {
      return customerID;
   }
   
   public void setCustomerID(int id) {
      customerID = id;
   }
   
   

   public Date getLoginDate() {
      return loginDate;
   }
   
   public void setLoginDate(Date date) {
      loginDate = date;
   }

}