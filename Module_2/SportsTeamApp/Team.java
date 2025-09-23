package Module_2.SportsTeamApp;

public class Team {
    private String teamName = "";
    private String[] players = new String[20];
    private int playerCount = 0;

    //constructor
    public Team(String teamName) {
        this.teamName = teamName;

    }
    
    // Add player
    public void addPlayer(String player) {
        players[playerCount] = player;
        playerCount++;
    }
    
    //Getters
    public String[] getPlayers() {
        return players;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public String getTeamName() {
        return teamName;
    }
}
