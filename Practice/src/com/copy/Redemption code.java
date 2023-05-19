JButton redeemPointsButton = new JButton("Redeem Points");
redeemPointsButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        Customer customer = getCurrentCustomer(); // Retrieve the currently logged in customer
        int loyaltyPoints = customer.getLoyaltyPoints();
        if (loyaltyPoints > 0) {
            // Allow the customer to redeem their loyalty points
            String input = JOptionPane.showInputDialog(null, "You have " + loyaltyPoints + " loyalty points. How many points would you like to redeem?", "Redeem Points", JOptionPane.PLAIN_MESSAGE);
            try {
                int pointsToRedeem = Integer.parseInt(input);
                if (pointsToRedeem <= loyaltyPoints) { 
                    // Perform the redemption
                    customer.setLoyaltyPoints(loyaltyPoints - pointsToRedeem); // Subtract redeemed points from the loyalty point balance
                    customerDAO.updateCustomer(customer); // Update the customer record in the database
                    LoyaltyPoints redemption = new LoyaltyPoints();
                    redemption.setCustomerId(customer.getId());
                    redemption.setPoints(-pointsToRedeem); // Store the negative value of redeemed points in the database
                    redemption.setDate(new Date());
                    loyaltyPointsDAO.createLoyaltyPoints(redemption); // Store the redemption record in the database
                    JOptionPane.showMessageDialog(null, "Redemption successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "You only have " + loyaltyPoints + " Please enter a value less than or equal to " + loyaltyPoints + ".", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "You have no loyalty points to redeem.");
        }
    }
});

public int calculateLoyaltyPoints(Invoice invoice, Customer customer) {
    // Check if the invoice is associated with the customer
    if (invoice.getCustomerId() != customer.getId()) {
        throw new IllegalArgumentException("Invoice is not associated with the customer.");
    }
    // Calculate the loyalty points as 1% of the invoice total
    double loyaltyPoints = invoice.getTotal() * 0.01;
    // Round the loyalty points to the nearest whole number
    int roundedLoyaltyPoints = (int) Math.round(loyaltyPoints);
    return roundedLoyaltyPoints;
}
