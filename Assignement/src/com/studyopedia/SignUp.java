package com.studyopedia;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SignUp extends JFrame {

    private JLabel firstNameLabel, lastNameLabel, usernameLabel, passwordLabel;
    private JTextField firstNameField, lastNameField, usernameField;
    private JPasswordField passwordField;
    private JButton submitButton, loginButton;

    public SignUp() {
        setTitle("Sign Up");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create labels and fields
        firstNameLabel = new JLabel("First Name:");
        lastNameLabel = new JLabel("Last Name:");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");

        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);

        // Create submit and login buttons
        submitButton = new JButton("Submit");
        loginButton = new JButton("Login");

        // Add action listener to submit button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Organization", "username", "password");
                    PreparedStatement pstmt = conn.prepareStatement("INSERT INTO user (fname, lname, username, password,type) VALUES (?, ?, ?, ?,?)");
                    pstmt.setString(1, firstName);
                    pstmt.setString(2, lastName);
                    pstmt.setString(3, username);
                    pstmt.setString(4, password);
                    pstmt.setString(4, "Customer");
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "User created successfully!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        // Add action listener to login button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Login();
                dispose(); // Close sign up window
            }
        });

        // Create panel for labels and fields
        JPanel fieldPanel = new JPanel(new GridLayout(4, 2));
        fieldPanel.add(firstNameLabel);
        fieldPanel.add(firstNameField);
        fieldPanel.add(lastNameLabel);
        fieldPanel.add(lastNameField);
        fieldPanel.add(usernameLabel);
        fieldPanel.add(usernameField);
        fieldPanel.add(passwordLabel);
        fieldPanel.add(passwordField);

        // Create panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(submitButton);
        buttonPanel.add(loginButton);

        // Add panels to main panel
        JPanel mainPanel = new JPanel(new GridLayout(2, 1));
        mainPanel.add(fieldPanel);
        mainPanel.add(buttonPanel);

        add(mainPanel);
        setVisible(true);
    }

}
