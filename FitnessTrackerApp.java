import java.util.Scanner;

class FitnessTracker {
    private String username;
    private int steps;
    private double distance;
    private int caloriesBurned;

    public FitnessTracker(String username) {
        this.username = username;
        this.steps = 0;
        this.distance = 0.0;
        this.caloriesBurned = 0;
    }

    public void logActivity(int steps, double distance) {
        this.steps += steps;
        this.distance += distance;
        this.caloriesBurned += calculateCaloriesBurned(distance);
    }

    private int calculateCaloriesBurned(double distance) {
        // A simple formula for calculating calories burned based on distance
        return (int) (distance * 30);
    }

    public void displaySummary() {
        System.out.println("Fitness Tracker Summary for " + username);
        System.out.println("Total Steps: " + steps);
        System.out.println("Total Distance: " + distance + " km");
        System.out.println("Total Calories Burned: " + caloriesBurned + " calories");
    }
}

public class FitnessTrackerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        FitnessTracker tracker = new FitnessTracker(username);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n1. Log Activity");
            System.out.println("2. Display Summary");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the number of steps: ");
                    int steps = scanner.nextInt();
                    System.out.print("Enter the distance (in km): ");
                    double distance = scanner.nextDouble();
                    tracker.logActivity(steps, distance);
                    break;
                case 2:
                    tracker.displaySummary();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }

        System.out.println("Thank you for using the Fitness Tracker App!");
        scanner.close();
    }
}
