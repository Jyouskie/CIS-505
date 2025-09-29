package Module_3.CustomerAccountApp;

import java.util.Scanner;

public class TestCustomerAccountApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get customer ID
        System.out.print("Enter a customer ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        Customer customer = CustomerDB.getCustomer(id);
        Account account = new Account();

        System.out.println("\nWelcome " + customer.getName());
        System.out.println("Balance: $" + account.getBalance());
        System.out.println("Transaction Date: " + account.getTransactionDate());
        System.out.println();

        String choice = "";
        while (!choice.equalsIgnoreCase("Q")) {
            account.displayMenu();
            System.out.print("\nEnter option: ");
            choice = sc.nextLine();

            switch (choice.toUpperCase()) {
                case "D":
                    System.out.print("Enter deposit amount: ");
                    double deposit = sc.nextDouble();
                    sc.nextLine();
                    account.deposit(deposit);
                    System.out.println("Deposited $" + deposit);
                    break;
                case "W":
                    System.out.print("Enter withdrawal amount: ");
                    double withdraw = sc.nextDouble();
                    sc.nextLine();
                    account.withdraw(withdraw);
                    System.out.println("Withdrew $" + withdraw);
                    break;
                case "B":
                    System.out.println("Current balance: $" + account.getBalance());
                    break;
                case "Q":
                    System.out.println("\n--- Customer Info ---");
                    System.out.println(customer.toString());
                    System.out.println("Final Balance: $" + account.getBalance());
                    break;
                default:
                    System.out.println("Invalid option.");
            }
            System.out.println();
        }

        sc.close();
    }
}

