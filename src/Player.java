import java.util.*;

public class Player {
    static Scanner sc = new Scanner(System.in);
    private String name;
    private int points;
    private ArrayList<Die> dice;

    //Constructor
    public Player(String name) {
        this.name = name;
        this.points = 0;
        this.dice = new ArrayList<>();
    }

    //Getters och setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public ArrayList<Die> getDice() {
        return dice;
    }
    public void setDice(ArrayList<Die> dice) {
        this.dice = dice;
    }

    //Metoder
    public void rollDice(ArrayList<Die> dice) {
        for(Die die : dice) {
            die.roll();
        }
    }

    public int getDiceValue() {
        int diceTotal=0;
        for(Die die : dice) { //Räknar ut totalen av tärningsslagen
            diceTotal+=die.getCurrentValue();
        }
        return diceTotal;
    }

    public void increaseScore() {
        this.points++;
    }

    public void addDie (ArrayList<Die> dice, int numberOfSides) {
        dice.add(new Die(numberOfSides));
    }

    public static void takeTurn(ArrayList<Player> players) {
        for(Player player : players) {
            int playerGuess;
            System.out.println("\n" + player.getName() + ", din tur! ");
            System.out.println("Gissa sammanlagda värdet på dina " + player.dice.size() + " tärningar.");
            playerGuess = sc.nextInt();
            sc.nextLine();
            player.rollDice(player.getDice()); //slår tärningarna
            for(Die die : player.getDice()) {
                System.out.println("Tärning visade " + die.getCurrentValue());
            }

            int diceTotal= player.getDiceValue(); //Hämtar totalen av tärningsslagen
            System.out.println("Totala värdet var " + diceTotal + "\n");
            if(playerGuess==diceTotal) { //Om totalen var samma som totalen av tärningsslagen
                System.out.println("Rätt gissat! Du får ett poäng!");
                player.increaseScore();

            } else {
                System.out.println("Tyvärr, inte rätt gissat.");
            }
            System.out.println("Dina poäng är " + player.getPoints());
        }
    }


    public static ArrayList<Player> createLeaderboard(ArrayList<Player> players) {
        ArrayList<Player> leaderboard = (ArrayList<Player>) players.clone(); //Klonar listan, för att inte ändra turordningen på spelarna.
        Comparator<Player> compareByPoints = new Comparator<Player>() {
            @Override
            public int compare(Player player1, Player player2) { //sorterar efter poäng istället för namn.
                return player2.getPoints() - player1.getPoints();
            }
        };
         Collections.sort(leaderboard, compareByPoints);

        return leaderboard;
    }

    public static ArrayList<Player> getWinners(ArrayList<Player> leaderBoard) {
        ArrayList<Player> winnerList = new ArrayList<>();
        for (Player player : leaderBoard) {
            if (player.getPoints() == leaderBoard.get(0).getPoints()) { //Om nästa person i poänglistan har samma som vinnaren skrivs det ut, annars avbryts loopen
                winnerList.add(player);
            } else {
                break;
            }
        }
        return winnerList;
    }
}
