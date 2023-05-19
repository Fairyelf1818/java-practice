package com.studyopedia;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeDashboardGUI extends JFrame {

    // Components for customer search and display panel
    private JTextField searchField;
    private JButton searchButton;
    private JTable customerTable;

    // Components for invoice entry panel
    private JTextField dateField;
    private JTextField invoiceNumberField;
    private JTextField totalField;
    private JTextField loyaltyPointsField;
    private JButton submitButton;

    // Components for loyalty point report panel
    private JTextField startDateField;
    private JTextField endDateField;
    private JButton generateReportButton;

    public EmployeeDashboardGUI() {
        super("Employee Dashboard");

        // Set up layout manager
        setLayout(new BorderLayout());

        // Create panels for each feature
        JPanel searchPanel = createSearchPanel();
        JPanel invoicePanel = createInvoicePanel();
        JPanel reportPanel = createReportPanel();

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
                // Perform search based on searchField value
                // Update customerTable with search results
            }
        });

        customerTable = new JTable(
                new DefaultTableModel(new Object[] { "First Name", "Last Name", "Username", "Loyalty Points" }, 0));
        JScrollPane scrollPane = new JScrollPane(customerTable);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        panel.add(searchPanel, BorderLayout.NORTH);

        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createReportPanel() {
        // create a new JPanel to hold the report
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Report"));

        // add a label to display the report
        JLabel reportLabel = new JLabel("This is a sample report.");
        panel.add(reportLabel);

        return panel;
    }

    private JPanel createInvoicePanel() {
        // Set up panel with text fields for entering invoice information
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Invoice Entry"));
        panel.setLayout(new GridLayout(6, 7));

        dateField = new JTextField();
        invoiceNumberField = new JTextField();
        totalField = new JTextField();

        JTextField redeemedField = new JTextField();
        redeemedField = new JTextField();
        JLabel dateLabel = new JLabel("Date: ");
        JLabel invoiceNumberLabel = new JLabel("Invoice Number: ");
        JLabel totalLabel = new JLabel("Total: ");
        JLabel redeemedLabel = new JLabel("Redeemed: ");
        JButton updateButton = new JButton("Update");
        JButton generateReportButton = new JButton("Generate Report");

        // Add an ActionListener to the button
        generateReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create the report popup
                JFrame reportPopup = new JFrame("Report Popup");

                // create a JTextArea to display the report information
                JTextArea reportTextArea = new JTextArea();
                reportTextArea.setEditable(false); // make the text area read-only

                // add the report information to the text area
                reportTextArea.setText("Loyalty Points Report:\n\n" +
                        "Customer 1: 100 points\n" +
                        "Customer 2: 50 points\n" +
                        "Customer 3: 75 points\n");

                // add the text area to a JScrollPane for scrolling
                JScrollPane scrollPane = new JScrollPane(reportTextArea);

                // ... add report GUI components to the popup ...
                reportPopup.add(scrollPane);
                reportPopup.setSize(400, 300);
                reportPopup.setVisible(true);

            }
        });


        panel.add(dateLabel);
        panel.add(dateField);
        panel.add(invoiceNumberLabel);
        panel.add(invoiceNumberField);
        panel.add(totalLabel);
        panel.add(totalField);
        panel.add(redeemedLabel);
        panel.add(redeemedField);
        panel.add(updateButton);
        panel.add(generateReportButton);

        return panel;
    }

    public static void main(String[] args) {
        EmployeeDashboardGUI dashboard = new EmployeeDashboardGUI();

    }

}
