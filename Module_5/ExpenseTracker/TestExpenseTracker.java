package Module_5.ExpenseTracker;

import java.io.IOException;
import java.util.*;

public class TestExpenseTracker {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String choice = "y";

        System.out.println("Welcome to the Expense Tracker!");

        while (choice.equalsIgnoreCase("y")) {
            System.out.println("\nMENU OPTIONS");
            System.out.println("1. View all transactions");
            System.out.println("2. Add a new transaction");
            System.out.println("3. View total expenses");
            System.out.println("4. Exit");
            int menu = ValidatorIO.getInt(sc, "Choose an option: ");

            switch (menu) {
                case 1:
                    ArrayList<Transaction> list = TransactionIO.findAll();
                    if (list.isEmpty()) {
                        System.out.println("No transactions found.");
                    } else {
                        System.out.println("\n--- All Transactions ---");
                        for (Transaction t : list) {
                            System.out.printf("%s | %s | $%,6.2f%n", t.getDate(), t.getDescription(), t.getAmount());
                        }
                    }
                    break;

                case 2:
                    ArrayList<Transaction> newList = new ArrayList<>();
                    String another = "y";
                    while (another.equalsIgnoreCase("y")) {
                        String date = ValidatorIO.getString(sc, "Enter date (MM-dd-yyyy): ");
                        String desc = ValidatorIO.getString(sc, "Enter description: ");
                        double amt = ValidatorIO.getDouble(sc, "Enter amount: ");
                        newList.add(new Transaction(date, desc, amt));
                        another = ValidatorIO.getString(sc, "Add another transaction? (y/n): ");
                    }
                    TransactionIO.bulkInsert(newList);
                    System.out.println("Transactions saved!");
                    break;

                case 3:
                    ArrayList<Transaction> all = TransactionIO.findAll();
                    double total = 0;
                    for (Transaction t : all) {
                        total += t.getAmount();
                    }
                    System.out.printf("Total expenses: $%,6.2f%n", total);
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option!");
            }

            choice = ValidatorIO.getString(sc, "\nContinue? (y/n): ");
        }
        System.out.println("Goodbye!");
        sc.close();
    }
}
