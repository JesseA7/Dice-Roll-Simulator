import java.util.Scanner;

/**
 * Simulates rolling dice a specified number of times, and allows the user to view
 * the results either for a single roll or as a histogram of 100,000 rolls.
 * February 16, 2023
 *
 * @author Jesse Atkinson
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Check whether the input is a number, and if it is greater than 0, then prompt for the number of dice to roll
        int numDice = 0;
        while (numDice <= 0) {
            System.out.print("Enter number of dice: ");
            if (sc.hasNextInt()) {
                numDice = sc.nextInt();
                if (numDice <= 0) {
                    System.out.println("Please enter a positive number greater than 0.");
                }
            } else {
                System.out.println("Please enter a valid number.");
                sc.next();
            }
        }
        sc.nextLine(); // Clear the input field

        System.out.print("Enter number of sides for each die: ");
        String input = sc.nextLine();
        String[] sidesList = input.split(" ");
        int[] sides = new int[sidesList.length];

        for (int i = 0; i < sidesList.length; i++) {
            sides[i] = Integer.parseInt(sidesList[i].trim());
        }

        // Roll the dice using the Dice class
        for (int i = 0; i < numDice; i++) {
            Die d = new Die(sides[i]);
            System.out.println(d);
        }

        DiceCollection collection = new DiceCollection(sides);

        // Print DiceCollection to screen
        System.out.println(collection);

        // Present menu to user
        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Roll once");
            System.out.println("2. Roll 100,000 times");
            System.out.println("3. Quit");

            // Determine whether user input is a valid choice for the interface
            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1 -> {
                        // Roll once and show the results
                        collection.rollAll();
                        System.out.println(collection);
                        break;
                    }
                    case 2 -> {
                        // Roll 100,000 times and show histogram
                        int[] histogram = collection.histogram(100000);
                        System.out.println("\nHistogram of results:");
                        for (int i = 0; i < histogram.length; i++) {
                            int sum = i + collection.getMinPossibleSum();
                            if (histogram[i] > 0) {
                                System.out.println(sum + ": " + histogram[i]);
                            }
                        }
                        break;
                    }
                    case 3 -> {
                        // Quit the program
                        System.out.println("Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid input. Please enter a valid integer.");
                }
            } else {
                System.out.println("Invalid choice, please try again.");
                sc.nextLine(); // Clear the input field
            }
        }
    }
}
