package com.studyopedia.copy;

import java.sql.*;

public class labplswork {
    public static void main(String arg[])
    {
        Connection connection = null;
        try {
            // Trying to connect
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://LAPTOP-QMHL0DNI\\SQLEXPRESS/PARTS",
                "PARTS", "");

            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            // Query 1
            resultSet = statement.executeQuery(
                "select * from PART");
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String manufacturer = resultSet.getString("manufacturer");
            int cost = resultSet.getInt("cost");
            int price = resultSet.getInt("price");
            
            // Print out the data for this 
            System.out.println("Part ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Manufacturer: " + manufacturer);
            System.out.println("Cost: $" + cost);
            System.out.println("Price: $" + price);
            System.out.println();
       
            // query2
            String query2 = "INSERT INTO PART (id, name, manufacturer, cost, price) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = connection.prepareStatement(query2)) {
                pstmt.setInt(1, 6);
                pstmt.setString(2, "oil filter");
                pstmt.setString(3, "Denso Corp");
                pstmt.setInt(4, 500);
                pstmt.setInt(5, 700);
                int rowsInserted = pstmt.executeUpdate();
                System.out.println(rowsInserted + " rows inserted.");
            }
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    } //god hekl;p me
}

