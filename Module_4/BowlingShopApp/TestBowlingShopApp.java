package Module_4.BowlingShopApp;

import java.util.Scanner;

public class TestBowlingShopApp {

    public static void displayMenu() {
        System.out.println("MENU OPTIONS");
        System.out.println("1. <b> Bowling Balls");
        System.out.println("2. <a> Bowling Bags");
        System.out.println("3. <s> Bowling Shoes");
        System.out.println("4. <x> Exit");
        System.out.print("Please choose an option: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice = "";

        while (!choice.equalsIgnoreCase("x")) {
            displayMenu();
            choice = sc.nextLine();

            if (choice.equalsIgnoreCase("x")) break;

            GenericQueue<Product> products = ProductDB.getProducts(choice);

            while (products.size() > 0) {
                Product p = products.dequeue();
                System.out.println(p.toString());
                System.out.println();
            }
        }

        System.out.println("Bye!");
        sc.close();
    }
}

