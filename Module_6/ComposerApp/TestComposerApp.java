package Module_6.ComposerApp;

import java.util.List;
import java.util.Scanner;

public class TestComposerApp {

    private static void displayMenu() {
        System.out.println("WELCOME TO THE COMPOSER APP");
        System.out.println("---------------------------");
        System.out.println("1 - List composers");
        System.out.println("2 - Find composer by id");
        System.out.println("3 - Add a new composer");
        System.out.println("4 - Exit");
        System.out.print("Enter option: ");
    }

    private static void listAll(ComposerDao dao) {
        List<Composer> list = dao.findAll();
        if (list.isEmpty()) {
            System.out.println("No composers found.\n");
            return;
        }
        System.out.println();
        for (Composer c : list) {
            System.out.println(c);
            System.out.println();
        }
    }

    private static void findOne(Scanner sc, ComposerDao dao) {
        System.out.print("Enter composer id: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid integer. Enter composer id: ");
            sc.next();
        }
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        Composer c = dao.findBy(id);
        if (c == null) {
            System.out.println("Composer not found.\n");
        } else {
            System.out.println("\n" + c + "\n");
        }
    }

    private static void addOne(Scanner sc, ComposerDao dao) {
        System.out.print("Enter new composer id: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid integer. Enter new composer id: ");
            sc.next();
        }
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter composer name: ");
        String name = sc.nextLine();

        System.out.print("Enter composer genre: ");
        String genre = sc.nextLine();

        dao.insert(new Composer(id, name, genre));
        System.out.println("Composer added.\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ComposerDao dao = new MemComposerDao();

        String keepGoing = "y";
        while (keepGoing.equalsIgnoreCase("y")) {
            displayMenu();
            String opt = sc.nextLine().trim();

            switch (opt) {
                case "1":
                    listAll(dao);
                    break;
                case "2":
                    findOne(sc, dao);
                    break;
                case "3":
                    addOne(sc, dao);
                    break;
                case "4":
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option.\n");
            }

            System.out.print("Continue? (y/n): ");
            keepGoing = sc.nextLine().trim();
            System.out.println();
        }

        System.out.println("Goodbye!");
        sc.close();
    }
}
