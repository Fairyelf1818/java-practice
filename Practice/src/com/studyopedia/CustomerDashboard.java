package com.studyopedia;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JTable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDashboard extends JFrame {
    private JLabel fnameLabel, lnamLabel, unamelabel, paymentLabel;
    private JTextField fnameTextField, lnameTextField, unameTextField, paymentTextField;
    private JButton redeemButton;
    private JTable invoiceTable;
    private JLabel pointsLabel;
    private String username;

    public CustomerDashboard(String username) {
        super("Customer Dashboard");
        this.username = username;
        
       
        // Set up the GUI components
        pointsLabel = new JLabel("Points balance: 0");
        fnameLabel = new JLabel("First name:");
        fnameTextField = new JTextField();
        lnamLabel = new JLabel("Last name:");
        lnameTextField = new JTextField();
        unamelabel = new JLabel("Username:");
        unameTextField = new JTextField();
        redeemButton = new JButton("Redeem Points");
        JButton employeeDashboardButton = new JButton("Access Employee Dashboard");
        employeeDashboardButton.setPreferredSize(new Dimension(150, 30));
        redeemButton.setPreferredSize(new Dimension(150, 30));
        paymentLabel = new JLabel("Payment:");
        paymentTextField = new JTextField();

        String URL ="jdbc:mysql://localhost:3306/Organization";
        String uname="root";
        String pssword="";
        // Retrieve customer information from the database
        // Retrieve customer information from the database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, uname, pssword);
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM user WHERE username = ?");
            preparedStatement.setString(1, username); // Set the passed username

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String retrievedUsername = resultSet.getString("username");
                if (retrievedUsername.equals(username)) {
                    // The retrieved username matches the passed username
                    fnameTextField.setText(resultSet.getString("fname"));
                    lnameTextField.setText(resultSet.getString("lname"));
                    unameTextField.setText(retrievedUsername);
                } else {
                    // Handle case when the retrieved username does not match the passed username
                    fnameTextField.setText("");
                    lnameTextField.setText("");
                    unameTextField.setText("");
                }
            } else {
                // Handle case when no customer is found
                fnameTextField.setText("");
                lnameTextField.setText("");
                unameTextField.setText("");
            }

            resultSet.close();
            preparedStatement.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        // Retrieve invoice information from the database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, uname, pssword);
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT invoicedate, invoiceid, total FROM invoice");
            ResultSet resultSet = preparedStatement.executeQuery();

            // Count the number of rows in the ResultSet
            int rowCount = 0;
            while (resultSet.next()) {
                rowCount++;
            }

            if (rowCount > 0) {
                // Create a new Object array to store the data
                Object[][] data = new Object[rowCount][4];  // removed the +1 in rowCount
                String[] columnNames = { "Date", "Invoice Number", "Total", "Redemption Points" };

                // Populate the Object array with the data from the ResultSet
                //resultSet.beforeFirst();  // ik this gives issues
                int row = 0;
                while (resultSet.next()) {
                    data[row][0] = resultSet.getString("invoicedate");
                    data[row][1] = resultSet.getString("invoiceid");
                    data[row][2] = "$" + resultSet.getString("total");

                    // Calculate total with redemption points
                    double total = Double.parseDouble(resultSet.getString("total"));
                    double redeemedAmount = total * 0.01;
                    data[row][3] = String.format("%.2f", redeemedAmount);

                    row++;
                }

                // Set up the JTable
                invoiceTable = new JTable(data, columnNames);
                JScrollPane scrollPane = new JScrollPane(invoiceTable);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                getContentPane().add(scrollPane, BorderLayout.CENTER);
            } else {
                // Handle case when no invoices are found
                invoiceTable = new JTable(new Object[][] {}, new String[] {});
            }

            resultSet.close();
            preparedStatement.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        employeeDashboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EmployeeDashboardGUI();
            }

        });

        // Add the components to the GUI
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonPanel.add(redeemButton);
        buttonPanel.add(employeeDashboardButton);

        JPanel panel = new JPanel(new BorderLayout());
        JPanel infoPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        infoPanel.add(fnameLabel);
        infoPanel.add(fnameTextField);
        infoPanel.add(lnamLabel);
        infoPanel.add(lnameTextField);
        infoPanel.add(unamelabel);
        infoPanel.add(unameTextField);
        infoPanel.add(paymentLabel);
        infoPanel.add(paymentTextField);

        // Create a new JPanel for the JTable
        JPanel tablePanel = new JPanel(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(invoiceTable);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        panel.add(infoPanel, BorderLayout.NORTH);
        panel.add(pointsLabel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        invoiceTable.setPreferredScrollableViewportSize(new Dimension(0, 250));
        panel.add(new JScrollPane(invoiceTable));

        add(panel);

        // Set up the event listeners
        redeemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(null, "How many points would you like to redeem?",
                        "Redeem Points", JOptionPane.PLAIN_MESSAGE);
                double total = 0.0;
                try {
                	Class.forName("com.mysql.cj.jdbc.Driver");
                	//String connectionUrl = "jdbc:sqlserver://LAPTOP-QMHL0DNI;databaseName=Organization;trustServerCertificate=true;";
                    Connection conn = DriverManager.getConnection(URL,uname,pssword);
                    PreparedStatement preparedStatement = conn
                            .prepareStatement("SELECT SUM(total) AS total FROM invoice");
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        total = resultSet.getDouble("total");
                    }
                    resultSet.close();
                    preparedStatement.close();
                    conn.close();
                } catch (SQLException | ClassNotFoundException j) {
                    j.printStackTrace();
                }

                try {
                    int pointsToRedeem = Integer.parseInt(input);
                    double redeemedAmount = total * 0.01;
                    if (pointsToRedeem <= redeemedAmount) {
                        JOptionPane.showMessageDialog(null, "Points redeemed successfully!", "Redeem Points",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Insufficient points to redeem!", "Redeem Points",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.", "Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        employeeDashboardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Dispose of the current CustomerDashboard
                EmployeeDashboardGUI employeeDashboard = new EmployeeDashboardGUI();
                employeeDashboard.setVisible(true);
            }
        });

        // Set the window size and show the GUI
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/Organization";
        String uname = "root";
        String pssword = "";
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, uname, pssword);
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT username FROM user WHERE id = ?");
            preparedStatement.setInt(1, 1); // Assuming the username is associated with a specific ID in the database
    
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String username = resultSet.getString("username");
                CustomerDashboard customerDashboard = new CustomerDashboard(username);
                // Additional code related to the CustomerDashboard class
            }
    
            resultSet.close();
            preparedStatement.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
