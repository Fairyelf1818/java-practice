package com.studyopedia.copy2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI implements ActionListener {

    private JFrame frame;
    private JTextField textField;
    private JButton[] buttons;
    private String[] buttonLabels = {
        "7", "8", "9", "+",
        "4", "5", "6", "-",
        "1", "2", "3", "*",
        ".", "0", "=", "/"
    };
    private double firstNumber = 0;
    private String operation = "";

    public CalculatorGUI() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(280, 40));
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        textField.setEditable(false);

        JPanel panel = new JPanel(new GridLayout(4, 4, 5, 5));
        buttons = new JButton[buttonLabels.length];

        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 24));
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }

        frame.getContentPane().add(BorderLayout.NORTH, textField);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String label = ((JButton)e.getSource()).getText();

        if (label.matches("\\d") || label.equals(".")) {
            textField.setText(textField.getText() + label);
        } else if (label.equals("+")) {
            firstNumber = Double.parseDouble(textField.getText());
            operation = "+";
            textField.setText("");
        } else if (label.equals("-")) {
            firstNumber = Double.parseDouble(textField.getText());
            operation = "-";
            textField.setText("");
        } else if (label.equals("*")) {
            firstNumber = Double.parseDouble(textField.getText());
            operation = "*";
            textField.setText("");
        } else if (label.equals("/")) {
            firstNumber = Double.parseDouble(textField.getText());
            operation = "/";
            textField.setText("");
        } else if (label.equals("=")) {
            double secondNumber = Double.parseDouble(textField.getText());
            double result = 0;

            if (operation.equals("+")) {
                result = firstNumber + secondNumber;
            } else if (operation.equals("-")) {
                result = firstNumber - secondNumber;
            } else if (operation.equals("*")) {
                result = firstNumber * secondNumber;
            } else if (operation.equals("/")) {
                result = firstNumber / secondNumber;
            }

            textField.setText(Double.toString(result));
            firstNumber = 0;
            operation = "";
        }
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}
