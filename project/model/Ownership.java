package project.model;

public class Ownership {

   private int customerID;
   private String cardNumber;
   private boolean currentOwnership; // for canceling credit card. single bit? 
   private int primaryCard;

   public Ownership(int customer, String card, int primary) {
      customerID = customer;
      cardNumber = card;
      currentOwnership = true;
      primaryCard = primary;
      
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
   
   public boolean isPrimary() {
      return primaryCard==1;
   }
   
   public void setPrimary(int state) {
      primaryCard = state;
   }


}