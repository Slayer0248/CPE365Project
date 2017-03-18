package project.model;

import java.util.*;
import java.sql.*;

public class DBAccess {

   private Connection conn;


   public DBAccess() { 
   }


   public void open() {
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://cslvm74.csc.calpoly.edu/cjacob07", "cjacob07", "Ma94ne07k");
      
   }
   
   public ArrayList<Customer> runCustomerSelect(String query) {
   	  ArrayList<Customer> customers = new ArrayList<Customer>();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
         int customerID = rs.getInt("customerID");
         int ssn = rs.getInt("SSN");
         String name = rs.getString("name");
         String password = rs.getString("password");
         String address = rs.getString("address");
         String phoneNumber = rs.getString("phone");
         Customer cust = new Customer(customerID, ssn, name, password, address, phoneNumber);
         //use row to fill in customer
         customers.add(cust);
      } 
      return customers;
   }
   
   public ArrayList<CreditCard> runCreditCardSelect(String query) {
      ArrayList<CreditCard> cards = new ArrayList<CreditCard>();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
         String cardNumber = rs.getString("cardNum"); //unique
         String typeText = rs.getString("type");
         CreditCard.CardType type = convertTypeToModel(typeText);
         
         double creditLimit = Double.parseDouble(Float.toString(rs.getFloat("creditLimit")));
         double cardBalance = Double.parseDouble(Float.toString(rs.getFloat("balance"))); // < creditLimit
         boolean cardActive = rs.getInt("active") == 1; // single bit?
         CreditCard card = new CreditCard(cardNumber, type, creditLimit, cardBalance);
         card.setActive(cardActive);
         //use row to fill in card
         cards.add(card);
      } 
      return cards;
   }
   
   public ArrayList<Vender> runVenderSelect(String query) {
      ArrayList<Vender> venders = new ArrayList<Vender>();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
         int id = rs.getInt("venderID");
         String name = rs.getString("name");
         String offices = rs.getString("offices");
         Vender vender = new Vender(id, name, offices);
         //use row to fill in vender
         venders.add(vender);
      } 
      return venders;
   }
   
   public ArrayList<Ownership> runOwnershipSelect(String query) {
      ArrayList<Ownership> owners = new ArrayList<Ownership>();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
         int id = rs.getInt("customerID");
         String card = rs.getString("cardNum");
         boolean current = (rs.getInt("current") == 1);
         Ownership owner = new Ownership(id, card);
         owner.setCurrent(current);
         //use row to fill in ownership
         owners.add(owner);
      } 
      return owners;
   }
   
   public ArrayList<Payment> runPaymentSelect(String query) {
      ArrayList<Payment> payments = new ArrayList<Payment>();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
         int id = rs.getInt("paymentID");
         String card = rs.getString("cardNum");
         java.util.Date date = convertToUtilDate(rs.getDate("paymentDate"));
         double amount = Double.parseDouble(Float.toString(rs.getFloat("amount")));
         
         Payment payment = new Payment(id, card, date, amount);
         //use row to fill in payment
         payments.add(payment);
      } 
      return payments;
   }
   
   public ArrayList<Transaction> runTransactionSelect(String query) {
      ArrayList<Transaction> transactions = new ArrayList<Transaction>();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
         int id = rs.getInt("transactionID");
         int customerID = rs.getInt("customerID");
         String card = rs.getString("cardNum");
         int recieverID = rs.getInt("recieverID");
         int type = rs.getInt("recieverType");
         java.util.Date date = convertToUtilDate(rs.getDate("transactionDate"));
         double amount = Double.parseDouble(Float.toString(rs.getFloat("amount")));
         
         Transaction transaction = new Transaction(id, customerID, card, recieverID, type, date, amount);
         //use row to fill in transaction
         transactions.add(transaction);
      } 
      return transactions;
   }
   
   public ArrayList<Session> runSessionSelect(String query) {
      ArrayList<Session> sessions = new ArrayList<Session>();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
         int id = rs.getInt("sessionID");
         int customerID = rs.getInt("customerID");
         java.util.Date date = convertToUtilDate(rs.getDate("loginDate"));
         Session session = new Session(id, customer, date);
         //use row to fill in transaction
         sessions.add(session);
      } 
      return sessions;
   }
   
   public ArrayList<Membership> runMembershipSelect(String query) {
      ArrayList<Membership> members = new ArrayList<Membership>();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
         int venderID = rs.getInt("venderID");
         int customerID = rs.getInt("customerID");
         boolean reciever = rs.getInt("mainReciever")==1;
         Membership member = new Membership(venderID, customerID, reciever);
         //use row to fill in transaction
         members.add(member);
      } 
      return members;
   }
   
   
   public ResultSet runSelect(String query) {
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(query);
      return rs;
   }
   
   //insert, update, & delete query
   public void runUpdate(String query) {
      Statement stmt = conn.createStatement();
      stmt.executeUpdate(query);
   }

   public void close() {
      conn.close();
   }
   
   
   //generation helper functions
   public int createNewSession() {
      int sessionID = -1;
      int exists = 0;
      Random rand = new Random();
      ArrayList<Session> sessions = runSessionSelect("select * from Sessions;");
      while (sessionID == -1 || exists == 1) {
         exists = 0;
         sessionID = rand.nextInt(1001);
         for (int i=0; i<sessions.size(); i++) {
            if (sessions.get(i).getID() == sessionID) {
               exists = 1;
               break;
            }
         }
      }
      runUpdate("Insert into Sessions(sessionID, customerID, loginDate) values ("+sessionID+",NULL,NULL);");
      
      return sessionID;
   
   }
   
   //conversion helper functions
   public CreditCard.CardType convertTypeToModel(String text) {
      CreditCard.CardType type;
      if (typeText.equals("Visa")) {
         type = CreditCard.CardType.VISA;
      } 
      else if (typeText.equals("MC")) {
         type = CreditCard.CardType.MC;
      } 
      else if (typeText.equals("American Express")) {
         type = CreditCard.CardType.AMERICAN_EXPRESS;
      }
      else if (typeText.equals("Discover")) {
         type = CreditCard.CardType.DISCOVER;
      }
      else {
         type = CreditCard.CardType.VISA;
      }
      return type;
   }
   
   public String convertTypeToDB (CreditCard.CardType type) {
      String text;
      if (type == CreditCard.CardType.VISA) {
         text = "Visa";
      } 
      else if (type == CreditCard.CardType.MC) {
         text = "MC";
      } 
      else if (type == CreditCard.CardType.AMERICAN_EXPRESS) {
         text = "American Express";
      }
      else if (type == CreditCard.CardType.DISCOVER) {
         text = "Discover";
      }
      else {
         text = "Visa";
      }
      return text;
   }
   
   public java.util.Date convertToUtilDate(java.sql.Date date) {
      return (java.util.Date)date;
   }
   
   public java.sql.Date convertToSQLDate(java.util.Date date) {
      DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
      return java.sql.Date.valueOf(df.format(date));
   }
}