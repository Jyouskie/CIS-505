package Module_2.SportsTeamApp;

import java.util.Scanner;

public class TestSportsTeamApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice = "y";

        while (choice.equalsIgnoreCase("y")) {
            // Get team name
            System.out.print("  Enter a team name: ");
            String teamName = sc.nextLine();
            Team team = new Team(teamName);

            // Get players
            System.out.print("  Enter player names (comma separated, no spaces): ");
            String playerInput = sc.nextLine();
            String[] players = playerInput.split(",");

            for (String p : players) {
                team.addPlayer(p);
            }

            // Display results
            System.out.println("\n");
            System.out.println("--Team Summary--");
            System.out.println("  Number of players in team: " + team.getPlayerCount());
            System.out.print("  Players on team: ");
            for (int i = 0; i < team.getPlayerCount(); i++) {
                System.out.print(team.getPlayers()[i] + " ");
            }
            System.out.println("\n");
            

            // Continue?
            System.out.print("  Continue? (y/n): ");
            choice = sc.nextLine();
        }

        System.out.println("  Program ended.");
    }
}