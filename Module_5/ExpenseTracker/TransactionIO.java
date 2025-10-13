package Module_5.ExpenseTracker;

import java.io.*;
import java.util.*;

public class TransactionIO {
    private static final String FILE_NAME = "expenses.txt";
    private static File file = new File(FILE_NAME);

    // Write list of transactions to file
    public static void bulkInsert(ArrayList<Transaction> transactions) throws IOException {
        PrintWriter output = null;
        if (file.exists()) {
            output = new PrintWriter(new FileOutputStream(file, true)); // append mode
        } else {
            output = new PrintWriter(file);
        }

        for (Transaction t : transactions) {
            output.printf("%s|%s|%.2f%n", t.getDate(), t.getDescription(), t.getAmount());
        }
        output.close();
    }

    // Read all transactions from file
    public static ArrayList<Transaction> findAll() throws IOException {
        ArrayList<Transaction> transactions = new ArrayList<>();
        if (!file.exists()) {
            return transactions;
        }

        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] parts = line.split("\\|");
            if (parts.length == 3) {
                String date = parts[0];
                String desc = parts[1];
                double amt = Double.parseDouble(parts[2]);
                transactions.add(new Transaction(date, desc, amt));
            }
        }
        input.close();
        return transactions;
    }
}
