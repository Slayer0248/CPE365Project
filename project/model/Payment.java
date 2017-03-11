package project.model;

import java.util.*;

public class Payment {

   private int paymentID;
   private Date paymentDate;
   private String cardNumber;
   private double paymentAmount;

   public Payment(int id, String cardNum, Date date) {
      paymentID = id;
      cardNumber = cardNum;
      paymentDate = date;
      paymentAmount = 0;
   }

   public Payment(int id, String cardNum, Date date, double amount) {
      paymentID = id;
      cardNumber = cardNum;
      paymentDate = date;
      paymentAmount = amount;
   }

   public int getID() {
      return paymentID;
   }
   
   public void setID(int id) {
      paymentID = id;
   }

   public String getCardNumber() {
      return cardNumber;
   }
   
   public void setCardNumber(String cardNum) {
      cardNumber = cardNum;
   }
   
   public Date getDate() {
      return paymentDate;
   }
   
   public void setDate(Date date) {
      paymentDate = date;
   }
   
   public double getAmount() {
      return paymentAmount;
   }
   
   public void setAmount(double amount) {
      paymentAmount = amount;
   }
}