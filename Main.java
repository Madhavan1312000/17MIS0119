import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
   static final String DB_URL = "jdbc:mysql://localhost/MADHAVAN";
   static final String USER = "guest";
   static final String PASS = "guest123";
   static final String QUERY = "SELECT SKU, DESCRIPTION, YEAR, CAPACITY, URL, PRICE, SELLER_INFORMATION, OFFER_DESCRIPTION, COUNTRY FROM Main";

   public static void main(String[] args) {
      
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();) {		      
         System.out.println("Fetching records without condition...");
         ResultSet rs = stmt.executeQuery(QUERY);
         while(rs.next()){
            
            System.out.print("SKU: " + rs.getInt("SKU"));
            System.out.print(", DESCRIPTION: " + rs.getString("DESCRIPTION"));
            System.out.print(", YEAR: " + rs.getInt("YEAR"));
            System.out.print(", CAPACITY: " + rs.getInt("CAPACITY"));
            System.out.print(", URL: " + rs.getString("URL"));
            System.out.print(", PRICE: " + rs.getInt("PRICE"));
            System.out.println(", SELLER_INFORMATION : " + rs.getString("SELLER_INFORMATION"));
            System.out.println(", OFFER_DESCRIPTION: " + rs.getString("OFFER_DESCRIPTION"));
            System.out.println(", COUNTRY: " + rs.getString("COUNTRY"));
         }

        
         System.out.println("Fetching records with condition...");
         String sql = "SELECT SKU, DESCRIPTION, YEAR, CAPACITY, URL, PRICE, SELLER_INFORMATION, OFFER_DESCRIPTION, COUNTRY FROM Main" +
            " WHERE COUNTRY = USA ";
         rs = stmt.executeQuery(sql);

         while(rs.next()){
            
            System.out.print("SKU: " + rs.getInt("SKU"));
            System.out.print(", DESCRIPTION: " + rs.getString("DESCRIPTION"));
            System.out.print(", YEAR: " + rs.getInt("YEAR"));
            System.out.print(", CAPACITY: " + rs.getInt("CAPACITY"));
            System.out.print(", URL: " + rs.getString("URL"));
            System.out.print(", PRICE: " + rs.getInt("PRICE"));
            System.out.println(", SELLER_INFORMATION : " + rs.getString("SELLER_INFORMATION"));
            System.out.println(", OFFER_DESCRIPTION: " + rs.getString("OFFER_DESCRIPTION"));
            System.out.println(", COUNTRY: " + rs.getString("COUNTRY"));
         }
         rs.close();
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}