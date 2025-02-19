

// Abstract base class for all players
abstract class Player {
    protected String name;
    protected int stamina;
    protected int dribbling;
    protected int kickStrength;
    protected String[] roles = new String[100];
    protected int roleCount = 0;

    public Player(String name, int stamina, int dribbling, int kickStrength) {
        this.name = name;
        this.stamina = stamina;
        this.dribbling = dribbling;
        this.kickStrength = kickStrength;
    }

    public void assignRole(String role) {
        if (!canAssignRole()) {
            throw new IllegalArgumentException("Goalkeeper can only have one role!");
        }
        roles[roleCount++] = role;
        System.out.println(name + " is now also a " + role);
    }

    protected boolean canAssignRole() {
        return true;
    }

    public abstract void performAction();

    public String getName() {
        return name;
    }
}

class Striker extends Player {
    public Striker(String name, int stamina, int dribbling, int kickStrength) {
        super(name, stamina, dribbling, kickStrength);
        roles[roleCount++] = "Striker";
    }

    @Override
    public void performAction() {
        System.out.println(name + " is attacking and taking a shot!");
    }
}

class Defender extends Player {
    public Defender(String name, int stamina, int dribbling, int kickStrength) {
        super(name, stamina, dribbling, kickStrength);
        roles[roleCount++] = "Defender";
    }

    @Override
    public void performAction() {
        System.out.println(name + " is defending against an opponent's attack!");
    }
}

class MidFielder extends Player {
    public MidFielder(String name, int stamina, int dribbling, int kickStrength) {
        super(name, stamina, dribbling, kickStrength);
        roles[roleCount++] = "Midfielder";
    }

    @Override
    public void performAction() {
        System.out.println(name + " is passing the ball and controlling midfield!");
    }
}

class Goalkeeper extends Player {
    private int goalSaveCap;

    public Goalkeeper(String name, int stamina, int dribbling, int kickStrength, int goalSaveCap) {
        super(name, stamina, dribbling, kickStrength);
        this.goalSaveCap = goalSaveCap;
        roles[roleCount++] = "Goalkeeper";
    }

    @Override
    public void performAction() {
        System.out.println(name + " is saving the goal with capability: " + goalSaveCap);
    }

    @Override
    protected boolean canAssignRole() {
        return false;
    }
}

class Team {
    private Player[] players = new Player[100];
    private int playerCount = 0;

    public void addPlayer(Player player) {
        if (playerCount < 11) {
            players[playerCount++] = player;
            System.out.println(player.getName() + " added to the team.");
        } else {
            System.out.println("Team already has 11 players.");
        }
    }

    public void assistGamer() {
        System.out.println("AI assisting the gamer...");
        for (int i = 0; i < playerCount; i++) {
            players[i].performAction();
        }
    }
}

class GamerController {
    private Player currentPlayer;

    public void takeControl(Player player) {
        this.currentPlayer = player;
        System.out.println("Gamer now controls: " + player.getName());
    }

    public void switchPlayer(Player newPlayer) {
        this.currentPlayer = newPlayer;
        System.out.println("Switched control to: " + newPlayer.getName());
    }

    public void executeAttack() {
        if (currentPlayer != null) {
            System.out.println(currentPlayer.getName() + " is leading the attack!");
            currentPlayer.performAction();
        } else {
            System.out.println("No player is currently controlled.");
        }
    }

    public void executeDefense() {
        if (currentPlayer != null) {
            System.out.println(currentPlayer.getName() + " is leading the defense!");
            currentPlayer.performAction();
        } else {
            System.out.println("No player is currently controlled.");
        }
    }
}

class PlayerFactory {
    public static Player createPlayer(String type, String name, int stamina, int dribbling, int kickStrength,
            int goalSaveCap) {
        switch (type) {
            case "Striker":
                return new Striker(name, stamina, dribbling, kickStrength);
            case "Defender":
                return new Defender(name, stamina, dribbling, kickStrength);
            case "Midfielder":
                return new MidFielder(name, stamina, dribbling, kickStrength);
            case "Goalkeeper":
                return new Goalkeeper(name, stamina, dribbling, kickStrength, goalSaveCap);
            default:
                throw new IllegalArgumentException("Invalid player type");
        }
    }
}

public class FootballGame {
    public static void main(String[] args) {
        // Create a team
        Team team = new Team();

        // Creating players using the factory
        Player striker = PlayerFactory.createPlayer("Striker", "Salah", 90, 85, 95, 0);
        Player defender = PlayerFactory.createPlayer("Defender", "Van Dijk", 85, 70, 80, 0);
        Player midfielder = PlayerFactory.createPlayer("Midfielder", "Modric", 88, 92, 86, 0);
        Player goalkeeper = PlayerFactory.createPlayer("Goalkeeper", "Neuer", 85, 60, 75, 95);

        // Add players to team
        team.addPlayer(striker);
        team.addPlayer(defender);
        team.addPlayer(midfielder);
        team.addPlayer(goalkeeper);

        // Assign additional roles
        midfielder.assignRole("Striker"); // Valid
        defender.assignRole("Midfielder"); // Valid

        // Gamer controls players
        GamerController gamer = new GamerController();
        gamer.takeControl(striker);
        gamer.executeAttack();
        gamer.switchPlayer(defender);
        gamer.executeDefense();

        // AI assists during a game scenario
        team.assistGamer();

        // Handle invalid role assignment
        try {
            goalkeeper.assignRole("Striker"); // Exception should be thrown
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
