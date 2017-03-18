package project.model;

import java.util.*;

public class Transaction {

   private int transactionID;
   private Date transactionDate;
   private int customerID;
   private String cardNumber;
   private int recieverID;
   private int recieverType; //0 = vender, 1= customer
   private double amount; //needed?

   public Transaction(int id, int customer, String card, int reciever, int type, Date date) {
      transactionID = id;
      customerID = customer;
      cardNumber = card;
      recieverID = reciever;
      recieverType = type;
      transactionDate = date;
      amount = 0;
   }
   
   public Transaction(int id, int customer, String card, int reciever, int type, Date date, double amount) {
      transactionID = id;
      customerID = customer;
      cardNumber = card;
      recieverID = vender;
      transactionDate = date;
      recieverType = type;
      this.amount = amount;
   }
   
   public int getID() {
      return transactionID;
   }
   
   public void setID(int id) {
      transactionID = id;
   }

   public int getCustomerID() {
      return customerID;
   }
   
   public void setCustomerID(int id) {
      customerID = id;
   }
   
   public String getCardNumber() {
      return cardNumber;
   }
   
   public void setCardNumber(String num) {
      cardNumber = num;
   }
   
   public int getRecieverID() {
      return recieverID;
   }
   
   public void setRecieverID(int id) {
      recieverID = id;
   }
   
   public int getRecieverType() {
      return recieverType;
   }
   
   public void setRecieverType(int type) {
      recieverType = type;
   }
   
   public Date getTransactionDate() {
      return transactionDate;
   }
   
   public void setTransactionDate(Date date) {
      transactionDate = date;
   }
   
   public double getAmount() {
      return amount;
   }
   
   public void setAmount(double amount) {
      this.amount = amount;
   }
   
   public String toString() {
      String result = "" + transactionDate + "  $" + amount + " to vender " + venderID + " from customer " + customerID;
      return result;
   }

}