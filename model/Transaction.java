import java.util.*;

public class Transaction {

   private Date transactionDate;
   private int customerID;
   private int cardNumber;
   private int venderID;
   private double amount; //needed?

   public Transaction(int customer, int card, int vender, Date date) {
      customerID = customer;
      cardNumber = card;
      venderID = vender;
      transactionDate = date;
      amount = 0;
   }
   
   public Transaction(int customer, int card, int vender, Date date, double amount) {
      customerID = customer;
      cardNumber = card;
      venderID = vender;
      transactionDate = date;
      this.amount = amount;
   }

   public int getCustomerID() {
      return customerID;
   }
   
   public void setCustomerID(int id) {
      customerID = id;
   }
   
   public int getCardNumber() {
      return cardNumber;
   }
   
   public void setCardNumber(int num) {
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