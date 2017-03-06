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
         Customer cust = new Customer();
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
         CreditCard card = new CreditCard();
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
         Vender vender = new Vender();
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
         Ownership owner = new Ownership();
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
         Payment payment = new Payment();
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
         Transaction transaction = new Transaction();
         //use row to fill in transaction
         transactions.add(transaction);
      } 
      return transactions;
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
}