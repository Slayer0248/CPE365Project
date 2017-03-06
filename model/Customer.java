
public class Customer {

   private int customerID; //unique
   private int SSN; //unique
   private String name;
   private String address;
   private int phoneNumber;

   public Customer(int id, int ssn) {
      customerID = id;
      SSN = ssn;
      name = "";
      address = "";
      phoneNumber = 0;
   }

   public Customer(int id, int ssn, String name, String address, int phone) {
      customerID = id;
      SSN = ssn;
      this.name = name;
      this.address = address;
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
   
   public String getAddress() {
      return address;
   }
   
   public void setAddress(String address) {
      this.address = address;
   }
   
   public int getPhoneNumber() {
      return phoneNumber;
   }
   
   public void setPhoneNumber(int phone) {
      phoneNumber = phone;
   }
   
   public String toString() {
      String result = "Customer " + customerID + " - " + name + "  " + address + "  " + phoneNumber;
      return result;
   }
}
