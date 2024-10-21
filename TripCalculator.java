import java.util.Scanner;

public class TripCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Trip Calculator!\nType <exit> to quit");

        double kilometers = handleDoubleInput(sc, "Enter the total kilometers traveled: ");
        double pricePerLiter = handleDoubleInput(sc, "Enter the price of gasoline per liter: ");
        double moneySpent = handleDoubleInput(sc, "Enter the money spent on gasoline for the trip: ");
        
        int hours = handleIntInput(sc, "Enter the time taken for the trip (hours): ", false, -1);
        int minutes = handleIntInput(sc, "Enter the time taken for the trip (minutes): ", true, hours);

        double totalHours = hours + (minutes / 60.0);
        double litersConsumed = moneySpent / pricePerLiter;
        double consumptionPer100KmLiters = (litersConsumed / kilometers) * 100;
        double consumptionPerKmLiters = litersConsumed / kilometers;
        double consumptionPer100KmEuros = (moneySpent / kilometers) * 100;
        double consumptionPerKmEuros = moneySpent / kilometers;
        double averageSpeedKmh = kilometers / totalHours;
        double averageSpeedMs = averageSpeedKmh * (1000.0 / 3600.0);

        System.out.printf("Fuel consumption per 100 km: %.2f liters, %.2f euros%n", consumptionPer100KmLiters, consumptionPer100KmEuros);
        System.out.printf("Fuel consumption per km: %.2f liters, %.2f euros%n", consumptionPerKmLiters, consumptionPerKmEuros);
        System.out.printf("Average speed: %.2f km/h (%.2f m/s)%n", averageSpeedKmh, averageSpeedMs);

        sc.close();
    }

    public static void checkExit(Scanner sc) {
        String userInput = sc.next();
        if (userInput.equalsIgnoreCase("exit")) {
            System.out.print("Exiting the program...");
            System.exit(0);
        }
    }

    public static double handleDoubleInput(Scanner sc, String message) {
        System.out.print(message);
        while (true) {
            if (sc.hasNextDouble()) {
                double userInput = sc.nextDouble();
                sc.nextLine();
                if (userInput > 0) {
                    return userInput;
                } else {
                    System.out.print("The input number must be greater than 0: ");
                }
            } else {
                checkExit(sc);
                sc.nextLine();
                System.out.print("Invalid input. Try again: ");
            }
        }
    }

    public static int handleIntInput(Scanner sc, String message, boolean isHoursSet, int inputHours) {
        System.out.print(message);
        while (true) {
            if (sc.hasNextInt()) {
                int userInput = sc.nextInt();
                sc.nextLine();
                if (!isHoursSet && userInput >= 0) {
                    return userInput;
                } else if (isHoursSet) {
                    if ((inputHours == 0 && userInput > 0) || (inputHours > 0 && userInput >= 0)) {
                        return userInput;
                    } else {
                        System.out.print("Invalid number. Total travel duration must be at least 1 minute: ");
                    }
                }
            } else {
                checkExit(sc); 
                sc.nextLine();
                System.out.print("Invalid input. Try again: ");
            }
        }
    }
}
