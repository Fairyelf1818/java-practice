package com.studyopedia;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class EmployeeDashboardGUI extends JFrame {

    // Components for customer search and display panel
    private JTextField searchField;
    private JButton searchButton;
    private JTable customerTable;


    public EmployeeDashboardGUI() {
        super("Employee Dashboard");

        // Set up layout manager
        setLayout(new BorderLayout());

        // Create panels for each feature
        JPanel searchPanel = createSearchPanel();
        JPanel invoicePanel = createInvoicePanel();

        // Add panels to main window
        add(searchPanel, BorderLayout.NORTH);
        add(invoicePanel, BorderLayout.CENTER);

        // Set window properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setVisible(true);
    }

    private JPanel createSearchPanel() {
        // Set up panel with search field, search button, and customer table
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Customer Search"));
        panel.setLayout(new BorderLayout());
    
        searchField = new JTextField(40);
        searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchValue = searchField.getText();
                DefaultTableModel model = (DefaultTableModel) customerTable.getModel();
                
                for (int i = model.getRowCount() - 1; i >= 0; i--) {
                    String username = (String) model.getValueAt(i, 2);
                    if (!username.equals(searchValue)) {
                        model.removeRow(i);
                    }
                }
            }
        });
        
    
        customerTable = new JTable(
        new DefaultTableModel(new Object[] { "CustomerID", "First Name", "Last Name", "Username", "Loyalty Points" }, 0));
JScrollPane scrollPane = new JScrollPane(customerTable);

JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
searchPanel.add(searchField);
searchPanel.add(searchButton);

panel.add(searchPanel, BorderLayout.NORTH);

panel.add(scrollPane, BorderLayout.CENTER);

// Populate customer table with all customers from the database
DefaultTableModel model = (DefaultTableModel) customerTable.getModel();
try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/organization", "root", "")) {
    String query = "SELECT * FROM user";
    PreparedStatement stmt = conn.prepareStatement(query);
    ResultSet rs = stmt.executeQuery();

    int rowCount = 1; // Initialize the row count to 1

    while (rs.next()) {
        Object[] rowData = { rowCount, rs.getString("fname"), rs.getString("lname"), rs.getString("username"), rs.getInt("lpbalance") };
        model.addRow(rowData);
        rowCount++; // Increment the row count for each row
    }
} catch (SQLException ex) {
    ex.printStackTrace();
}

return panel;

}


private JPanel createInvoicePanel() {
    // Set up panel with text fields for entering invoice information
    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createTitledBorder("Invoice Entry"));
    panel.setLayout(new GridLayout(6, 7));

    // Create text fields, labels, and button
    JTextField dateField = new JTextField();
    JTextField customerid = new JTextField();
    JTextField totalField = new JTextField();
    JTextField redeemedField = new JTextField();
    JLabel dateLabel = new JLabel("Date: ");
    JLabel customeridLabel = new JLabel("Customer ID: ");
    JLabel totalLabel = new JLabel("Total: ");
    JLabel redeemedLabel = new JLabel("Redeemption points: ");
    JButton updateButton = new JButton("Update");
    JButton generateReportButton = new JButton("Generate Report");

    generateReportButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Create the report popup
            JFrame reportPopup = new JFrame("Report Popup");

            // Create a JTextArea to display the report information
            JTextArea reportTextArea = new JTextArea();
            reportTextArea.setEditable(false); // Make the text area read-only

            try {
                String URL = "jdbc:mysql://localhost:3306/Organization";
                String uname = "root";
                String pssword = ""; 

                // Establish a database connection
                Connection conn = DriverManager.getConnection(URL, uname, pssword);

                // Create a SQL statement to retrieve customer and points data
                String sql = "SELECT custid, redeemed FROM invoice";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();

                // Iterate over the result set and append the data to the text area
                StringBuilder reportBuilder = new StringBuilder();
                reportBuilder.append("Loyalty Points Report:\n\n");
                while (rs.next()) {
                    int custid = rs.getInt("custid");
                    int redeemed = rs.getInt("redeemed");
                    reportBuilder.append("Customer: ").append(custid).append(", Points: ").append(redeemed).append("\n");
                }

                // Set the text area content with the report information
                reportTextArea.setText(reportBuilder.toString());

                // Close the database resources
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }

            // Add the report text area to the report popup
            reportPopup.add(new JScrollPane(reportTextArea));

            // Configure the report popup size and visibility
            reportPopup.setSize(400, 300);
            reportPopup.setLocationRelativeTo(null);
            reportPopup.setVisible(true);
        }
    });



     // Add action listener to the update button
updateButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String date = dateField.getText();
        String custidText = customerid.getText();
        String totalText = totalField.getText();

        // Parse integer values
        int custid = Integer.parseInt(custidText);
        int total = Integer.parseInt(totalText);
        int redeemed = (int) (total * 0.1); // Calculate redeemed as 10% of total

        String URL = "jdbc:mysql://localhost:3306/Organization";
        String uname = "root";
        String pssword = ""; 

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, uname, pssword);

            // Insert data into the invoice table
            PreparedStatement invoiceStatement = conn.prepareStatement("INSERT INTO invoice (invoicedate, custid, total, redeemed) VALUES (?, ?, ?, ?)");
            invoiceStatement.setString(1, date);
            invoiceStatement.setInt(2, custid);
            invoiceStatement.setInt(3, total);
            invoiceStatement.setInt(4, redeemed);

            int rowsUpdated = invoiceStatement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Update successful!");
            } else {
                JOptionPane.showMessageDialog(null, "Update failed!");
            }
            
            // Update the lpbalance column in the user table
            PreparedStatement userStatement = conn.prepareStatement("UPDATE user SET lpbalance = lpbalance + ? WHERE id = ?");
            userStatement.setInt(1, redeemed);
            userStatement.setInt(2, custid);

            int rowsUpdatedUser = userStatement.executeUpdate();
            if (rowsUpdatedUser > 0) {
                JOptionPane.showMessageDialog(null, "User balance updated!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to update user balance!");
            }

            invoiceStatement.close();
            userStatement.close();
            conn.close();
            
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid number format: " + ex.getMessage());
        }
    }
});





    // Add components to the panel
    panel.add(dateLabel);
    panel.add(dateField);
    panel.add(customeridLabel);
    panel.add(customerid);
    panel.add(totalLabel);
    panel.add(totalField);
    panel.add(updateButton);
    panel.add(generateReportButton);

    return panel;
}


    public static void main(String[] args) {
        EmployeeDashboardGUI dashboard = new EmployeeDashboardGUI();

    }

}
