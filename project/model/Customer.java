package project.model;

public class Customer {

   private int customerID; //unique
   private int SSN; //unique
   private String name;
   private String password;
   private String address;
   private String phoneNumber;

   public Customer(int id, int ssn) {
      customerID = id;
      SSN = ssn;
      name = "";
      address = "";
      password = "";
      phoneNumber = "";
   }

   public Customer(int id, int ssn, String name, String password, String address, String phone) {
      customerID = id;
      SSN = ssn;
      this.name = name;
      this.address = address;
      this.password = password;
      phoneNumber = phone;
   }
   
   public int getID() {
      return customerID;
   }
   
   public void setID(int id) {
      customerID = id;
   }
   
   public int getSSN() {
      return SSN;
   }
   
   public void setSSN(int ssn) {
      SSN = ssn;
   }
   
   public String getName() {
      return name;
   }
   
   public void setName(String name) {
      this.name = name;
   }
   
   public String getPassword() {
      return password;
   }
   
   public void setPassword(String password) {
      this.password = password;
   }
   
   public String getAddress() {
      return address;
   }
   
   public void setAddress(String address) {
      this.address = address;
   }
   
   public String getPhoneNumber() {
      return phoneNumber;
   }
   
   public void setPhoneNumber(String phone) {
      phoneNumber = phone;
   }
   
   public String toString() {
      String result = "" + customerID + " (" + name + ")";
      return result;
   }
}
