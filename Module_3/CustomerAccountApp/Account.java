package Module_3.CustomerAccountApp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {
    private double balance = 200.0;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void displayMenu() {
        System.out.println("Account Menu");
        System.out.println("Enter <D/d> for deposit");
        System.out.println("Enter <W/w> for withdrawal");
        System.out.println("Enter <B/b> for balance");
        System.out.println("Enter <Q/q> to quit");
    }

    public String getTransactionDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        return formatter.format(date);
    }
}
