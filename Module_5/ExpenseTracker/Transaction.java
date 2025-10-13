package Module_5.ExpenseTracker;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private String date;
    private String description;
    private double amount;

    // No-arg constructor (defaults)
    public Transaction() {
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        this.date = formatter.format(today);
        this.description = "";
        this.amount = 0.0;
    }

    // Arg constructor
    public Transaction(String date, String description, double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    // Getters and setters
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    @Override
    public String toString() {
        return String.format("%s\n%s\n$%,6.2f", date, description, amount);
    }
}

