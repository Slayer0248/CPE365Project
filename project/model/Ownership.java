package project.model;

public class Ownership {

   private int customerID;
   private String cardNumber;
   private boolean currentOwnership; // for canceling credit card. single bit? 

   public Ownership(int customer, String card) {
      customerID = customer;
      cardNumber = card;
      currentOwnership = true;
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

   public boolean isCurrent() {
      return currentOwnership;
   }
   
   public void setCurrent(boolean state) {
      currentOwnership = state;
   }

}