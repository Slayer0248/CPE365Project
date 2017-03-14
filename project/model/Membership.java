package project.model;

public class Ownership {

   private int customerID;
   private int venderID;
   private boolean reciever; // for receiving vender transactions 

   public Ownership(int customer, int vender, boolean reciever) {
      customerID = customer;
      venderID = vender;
      this.reciever = reciever;
   }
   
   public int getCustomerID() {
      return customerID;
   }
   
   public void setCustomerID(int id) {
      customerID = id;
   }
   
   public int getVenderID() {
      return venderID;
   }
   
   public void setVenderID(int id) {
      venderID = id;
   }
   

   public boolean isReciever() {
      return reciever;
   }
   
   public void setReciever(boolean state) {
      reciever = state;
   }

}