import java.util.Random;

/**
 * This program creates a Die object that has a number of sides and rolls the dice.
 * February 16, 2023
 *
 * @author Jesse Atkinson
 */
public class Die {
    /**
     * Number of sides on each die
     */
    private int numSides;
    /**
     * Dice roll result
     */
    private int roll;
    /**
     * Random number generator for rolling each die
     */
    private Random random;

    /**
     * Create a new Die object with the given number of sides
     *
     * @param numSides The number of sides on each die
     */
    public Die(int numSides) {
        this.numSides = numSides;
        this.random = new Random();
        roll();
    }

    /**
     * Get the number of sides of each die
     *
     * @return numSides The number of sides each die has
     */
    public int getNumSides() {
        return numSides;
    }

    /**
     * Get the result of the die
     *
     * @return roll The result of the die
     */
    public int getRoll() {
        return roll;
    }

    /**
     * Roll the die
     */
    public void roll() {
        roll = random.nextInt(numSides) + 1;
    }

    /**
     * Get a string representation of the die
     *
     * @return String The string representation of the die
     */
    public String toString() {
        return "d" + numSides + ": " + roll;
    }
}
