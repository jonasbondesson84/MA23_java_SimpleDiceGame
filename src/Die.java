import java.util.Random;

public class Die {

    private static Random randomDieNumber = new Random();
    private int numberOfSides;
    private int currentValue;

    //Constructor
    public Die(int numberOfSides) {
        this.numberOfSides = numberOfSides;
        currentValue = 0;
    }

    //Getters och setters
    public static Random getRandomDieNumber() {
        return randomDieNumber;
    }
    public static void setRandomDieNumber(Random randomDieNumber) {
        Die.randomDieNumber = randomDieNumber;
    }
    public int getNumberOfSides() {
        return numberOfSides;
    }
    public void setNumberOfSides(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }
    public int getCurrentValue() {
        return currentValue;
    }
    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    //Metoder
    public void roll() {
        this.currentValue =  randomDieNumber.nextInt(numberOfSides)+1;
        System.out.println("Tärningen visade " + currentValue);

    }


}
