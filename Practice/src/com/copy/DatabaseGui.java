package com.studyopedia.copy;

import java.awt.BorderLayout;
import java.sql.*;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DatabaseGui extends JFrame {
    private JTable table1, table2, table3;

    public DatabaseGui() {
        super("Database GUI");

        // Create the tabs for each query
        JPanel tab1 = new JPanel(new BorderLayout());
        JPanel tab2 = new JPanel(new BorderLayout());
        JPanel tab3 = new JPanel(new BorderLayout());

        // Step 1: Load the JDBC driver and establish the database connection
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/prog";
            String username = "root";
            String password = "password";
            Connection conn = DriverManager.getConnection(url, username, password);

            // Query 1: List all Developers in alphabetical order by name
            String query1 = "SELECT * FROM Developers ORDER BY name";
            Statement stmt1 = conn.createStatement();
            ResultSet rs1 = stmt1.executeQuery(query1);
            table1 = new JTable(buildTableModel(rs1));
            JScrollPane scrollPane1 = new JScrollPane(table1);
            tab1.add(scrollPane1, BorderLayout.CENTER);

            // Query 2: For each language, list the language ID and Name
            String query2 = "SELECT id, name FROM Languages";
            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(query2);
            table2 = new JTable(buildTableModel(rs2));
            JScrollPane scrollPane2 = new JScrollPane(table2);
            tab2.add(scrollPane2, BorderLayout.CENTER);

            // Query 3: List all developers with lan_eff greater than 80
            String query3 = "SELECT * FROM Developers WHERE lan_eff > 80";
            Statement stmt3 = conn.createStatement();
            ResultSet rs3 = stmt3.executeQuery(query3);
            table3 = new JTable(buildTableModel(rs3));
            JScrollPane scrollPane3 = new JScrollPane(table3);
            tab3.add(scrollPane3, BorderLayout.CENTER);

            // Step 2: Close the database connection
            conn.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Create the tabs and add them to the GUI
        TabbedPane tabs = new JTabbedPane();
        tabs.addTab("Query 1", tab1);
        tabs.addTab("Query 2", tab2);
        tabs.addTab("Query 3", tab3);
        getContentPane().add(tabs);

        // Set the size and visibility of the GUI
        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new DatabaseGui();
    }

    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        // Build a DefaultTableModel from a ResultSet
        ResultSetMetaData metaData = rs.getMetaData();

        // Get the number of columns
        int columnCount = metaData.getColumnCount();

        // Create a Vector to hold the column names
        Vector<String> columnNames = new Vector<String>();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // Create a Vector to hold the data rows
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> row = new Vector<Object>();
            for (int column = 1; column <= columnCount; column++) {
                row.add(rs.getObject( column ));
            }
            data.add(row);
            }
        return new DefaultTableModel(data, columnNames);
    }
}
