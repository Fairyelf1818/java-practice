package com.studyopedia.copy2;
import java.sql.*;


public class labtest2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://LAPTOP-QMHL0DNI\\SQLEXPRESS"; // replace with your database URL
        String username = ""; // replace with your database username
        String password = ""; // replace with your database password
        
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Query 1: List all parts data
            String query1 = "SELECT * FROM parts";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query1)) {
                while (rs.next()) {
                    // Retrieve the data for each part
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String manufacturer = rs.getString("manufacturer");
                    int cost = rs.getInt("cost");
                    int price = rs.getInt("price");
                    
                    // Print out the data for this part
                    System.out.println("Part ID: " + id);
                    System.out.println("Name: " + name);
                    System.out.println("Manufacturer: " + manufacturer);
                    System.out.println("Cost: $" + cost);
                    System.out.println("Price: $" + price);
                    System.out.println();
                }
            }
            
            // Query 2: Insert a new record into the parts table
            String query2 = "INSERT INTO parts (id, name, manufacturer, cost, price) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(query2)) {
                pstmt.setInt(1, 6);
                pstmt.setString(2, "oil filter");
                pstmt.setString(3, "Denso Corp");
                pstmt.setInt(4, 500);
                pstmt.setInt(5, 700);
                int rowsInserted = pstmt.executeUpdate();
                System.out.println(rowsInserted + " rows inserted.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
