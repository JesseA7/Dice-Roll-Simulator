/**
 * This program creates a collection of rolled dice and displays the results.
 * February 16, 2023
 *
 * @author Jesse Atkinson
 */
public class DiceCollection {
    // Initialize Die array
    private Die[] dice;

    /**
     * Constructor for the DiceCollection class
     *
     * @param numSides The number of sides of the dice
     */
    public DiceCollection(int[] numSides) {
        dice = new Die[numSides.length];
        for (int i = 0; i < numSides.length; i++) {
            dice[i] = new Die(numSides[i]);
        }
    }

    /**
     * Calculate the sum of the dice
     *
     * @return sum The sum of the dice
     */
    public int getCurrentSum() {
        int sum = 0;
        for (Die d : dice) {
            sum += d.getRoll();
        }
        return sum;
    }

    /**
     * Calculate the minimum possible sum of the dice
     *
     * @return minSum The minimum sum of the dice
     */
    public int getMinPossibleSum() {
        int minSum = 0;
        for (int i = 0; i < dice.length; i++) {
            minSum += 1;
        }
        return minSum;
    }

    /**
     * Calculate the maximum possible sum of the dice
     *
     * @return maxSum The maximum sum of the dice
     */
    public int getMaxPossibleSum() {
        int maxSum = 0;
        for (Die die : dice) {
            maxSum += die.getNumSides();
        }
        return maxSum;
    }

    /**
     * Roll all the dice from the array
     */
    public void rollAll() {
        for (Die d : dice) {
            d.roll();
        }
    }

    /**
     * String method to display the dice collection
     *
     * @return String The dice collection results
     */
    public String toString() {
        StringBuilder result = new StringBuilder("\nDice Collection:\n");
        for (Die d : dice) {
            result.append(d.toString()).append("\n");
        }
        result.append("Min: ").append(getMinPossibleSum());
        result.append(" Max: ").append(getMaxPossibleSum());
        result.append(" Current: ").append(getCurrentSum());
        return result.toString();
    }

    /**
     * Histogram method that displays the histogram results
     *
     * @param numRolls The number of rolls to make
     * @return counters The number of times each die was rolled
     */
    public int[] histogram(int numRolls) {
        int[] counters = new int[getMaxPossibleSum() - getMinPossibleSum() + 1];
        for (int i = 0; i < numRolls; i++) {
            rollAll();
            counters[getCurrentSum() - getMinPossibleSum()]++;
        }
        return counters;
    }
}

