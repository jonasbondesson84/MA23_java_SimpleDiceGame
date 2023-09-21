import java.util.Random;

public class Die {

    public static Random getRandomDieNumber() {
        return randomDieNumber;
    }

    public static void setRandomDieNumber(Random randomDieNumber) {
        Die.randomDieNumber = randomDieNumber;
    }

    private static Random randomDieNumber = new Random();
    private int numberOfSides;
    private int currentValue;

    public Die(int numberOfSides) {
        this.numberOfSides = numberOfSides;
        currentValue = 0;
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

    public void roll() {
        this.currentValue =  randomDieNumber.nextInt(numberOfSides)+1;
        System.out.println("Tärningen visade " + currentValue);

    }


}
