package project.model;

public class CreditCard {

   public enum CardType {VISA, MC, AMERICAN_EXPRESS, DISCOVER};
   
   private String cardNumber; //unique
   private CardType type;
   private double creditLimit;
   private double cardBalance; // < creditLimit
   private boolean cardActive; // single bit?
   


   public CreditCard(String cardNum) {
      cardNumber = cardNum;
      type = CardType.VISA;
      creditLimit = 0;
      cardBalance = 0;
      cardActive = false;
   }

   public CreditCard(String cardNum, CardType type, double limit, double balance) {
      cardNumber = cardNum;
      this.type = type;
      creditLimit = limit;
      cardBalance = balance;
      cardActive = false;
   }
   
   public String getCardNumber() {
      return cardNumber;
   }
   
   public void setCardNumber(String cardNum) {
      cardNumber = cardNum;
   }
   
   public CardType getType() {
      return type;
   }
   
   public void setType(CardType type) {
      this.type = type;
   }
   
   public double getCreditLimit() {
      return creditLimit;
   }
   
   public void setCreditLimit(double limit) {
      creditLimit = limit;
   }
   
   public double getBalance() {
      return cardBalance;
   }
   
   public void setBalance(double balance) {
      cardBalance = balance;
   }
   
   public boolean isActive() {
      return cardActive;
   }
   
   public void setActive(boolean status) {
      cardActive = status;
   }
   
   public String toString() {
      String result = "Card #" + cardNumber + " - limit:" + creditLimit + ", balance:" + cardBalance;
      return result;
   }

}