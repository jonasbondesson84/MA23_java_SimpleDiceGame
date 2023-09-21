import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();
        int numberOfPlayers;
        int numberOfDice;
        int numberOfSides;
        int NUMBR_TURNS = 5;

        System.out.println("Hur många spelare?");
        numberOfPlayers= sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numberOfPlayers; i++) {
            String name;
            System.out.println("Ange spelarnamn:");
            name = sc.nextLine();
            players.add(new Player(name));
        }
        System.out.println("Hur många tärningar ska varje spelar få??");
        numberOfDice = sc.nextInt();
        sc.nextLine();

        System.out.println("Hur många sidor ska tärningarna ha?");
        numberOfSides = sc.nextInt();
        sc.nextLine();

        for(Player player: players) {
            //System.out.println("Spelare: " + player.getName());
            for(int i = 0; i<numberOfDice; i++) {
                player.addDie(player.getDice(), numberOfSides);
            }
        }
        for (int i = 0; i < NUMBR_TURNS; i++) {
            System.out.println("\nOmgång nummer " + (i+1));
            Player.takeTurn(players);
            System.out.println("\nPoängställning:");
            for(Player player : Player.createLeaderboard(players)) {
                System.out.println(player.getName() + " - " + player.getPoints() + " poäng.");
            }

        }
        System.out.println("Vinnare är:");
        ArrayList<Player> leaderBoard = Player.createLeaderboard(players);
        for(Player player : leaderBoard){
            if (player.getPoints()==leaderBoard.get(0).getPoints()) {
                System.out.println(player.getName());
            }
        }


    }
}

