package project.model;

import java.util.*;

public class Transaction {

   private int transactionID;
   private Date transactionDate;
   private int customerID;
   private String cardNumber;
   private int venderID;
   private double amount; //needed?

   public Transaction(int id, int customer, String card, int vender, Date date) {
      transactionID = id;
      customerID = customer;
      cardNumber = card;
      venderID = vender;
      transactionDate = date;
      amount = 0;
   }
   
   public Transaction(int id, int customer, String card, int vender, Date date, double amount) {
      transactionID = id;
      customerID = customer;
      cardNumber = card;
      venderID = vender;
      transactionDate = date;
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
   
   public int getVenderID() {
      return venderID;
   }
   
   public void setVenderID(int id) {
      venderID = id;
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