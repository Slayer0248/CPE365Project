package project.model;

public class Vender {

   private int venderID; //unique
   private String venderName;
   private String venderOffices;

   public Vender(int id) {
      venderID = id;
      venderName = "";
      venderOffices = "";
   }
   
   public Vender(int id, String name, String offices) {
      venderID = id;
      venderName = name;
      venderOffices = offices;
   }

   public int getID() {
      return venderID;
   }
   
   public void setID(int id) {
      venderID = id;
   }
   
   public String getName() {
      return venderName;
   }
   
   public void setName(String name) {
      venderName = name;
   }
   
   public String getOffices() {
      return venderOffices;
   }
   
   public void setOffices(String offices) {
      venderOffices = offices;
   }
   
}