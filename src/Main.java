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
        numberOfPlayers = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numberOfPlayers; i++) { //Lägger till valt antal spelare
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

        for (Player player : players) { //Lägger till valt antal tärningar, med valt antal sidor på tärningarna.
            for (int i = 0; i < numberOfDice; i++) {
                player.addDie(player.getDice(), numberOfSides);
            }
        }
        ArrayList<Player> leaderBoard = new ArrayList<>();
        for (int i = 0; i < NUMBR_TURNS; i++) {  //Spelar ett antal omgångar NUMBR_TURNS
            System.out.println("\nOmgång nummer " + (i + 1));
            Player.takeTurn(players);
                System.out.println("\nPoängställning efter omgång " + (i + 1)); //Skriver ut en poängställning efter varje omgång.
                leaderBoard = Player.createLeaderboard(players);
                for (Player player : leaderBoard) {
                    System.out.println(player.getName() + " - " + player.getPoints() + " poäng.");
                }
        }

        System.out.println("\nVinnare är:");
        for (Player player : leaderBoard) {
            if (player.getPoints() == leaderBoard.get(0).getPoints()) { //Om nästa person i poänglistan har samma som vinnaren skrivs det ut, annars avbryts loopen
                System.out.println(player.getName());
            } else {
                break;
            }
        }

        System.out.println("\nTack för att ni har spelat!");

    }
}

