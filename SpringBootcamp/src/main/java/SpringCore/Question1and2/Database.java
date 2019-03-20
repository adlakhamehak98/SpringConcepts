package SpringCore.Question1and2;

//Create a class Database with 2 instance variables port and name.
// Configure Database class bean in spring container through Spring XML.
// Initialize instance variables using setter method.

public class Database {
   int port;
   String name;

   public void setPort(int port) {
      this.port = port;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getPort() {
      return port;
   }

   public String getName() {
      return name;
   }
}