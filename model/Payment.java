import java.util.*;

public class Payment {

   private Date paymentDate;
   private int cardNumber;
   private double paymentAmount;

   public Payment(int cardNum, Date date) {
      cardNumber = cardNum;
      paymentDate = date;
      paymentAmount = 0;
   }

   public Payment(int cardNum, Date date, double amount) {
      cardNumber = cardNum;
      paymentDate = date;
      paymentAmount = amount;
   }

   public int getCardNumber() {
      return cardNumber;
   }
   
   public void setCardNumber(int cardNum) {
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