public class Ownership {

   private int customerID;
   private int cardNumber;
   private boolean currentOwnership; // for canceling credit card. single bit? 

   public Ownership(int customer, int card) {
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
   
   public int getCardNumber() {
      return cardNumber;
   }
   
   public void setCardNumber(int num) {
      cardNumber = num;
   }

   public boolean isCurrent() {
      return currentOwnership;
   }
   
   public void setCurrent(boolean state) {
      currentOwnership = state;
   }

}