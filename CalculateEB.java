import java.util.Scanner;
import java.util.InputMismatchException;

public class CalculateEB {

    public static void main(String[] args) {
		try {
			int terms = handleInput("Enter the number of terms to calculate e: ");
			int precision = handleInput("Enter the number of decimal places for the calculation of e: ");
			double e = calculateE(terms, precision);
			 System.out.printf("Calculated value of e using %d terms: %." + precision + "f", terms, e);
		} catch (InputMismatchException e) {
			System.out.print("Exiting the program...");
		}
    }
	
	public static int handleInput(String message) throws InputMismatchException {
		System.out.print(message);
		Scanner sc = new Scanner(System.in);
		while (true) {
			String input = sc.nextLine();
			if (input.equalsIgnoreCase("exit")) throw new InputMismatchException();
			try {
				int integerInput = Integer.parseInt(input);
				if (integerInput > 0) {
					return integerInput;
				} else {
					System.out.println("Invalid input. Enter an integer > 0 or type <exit> to quit:");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Enter an integer > 0 or type <exit> to quit:");
			}
		}
	}

    public static double calculateE(int terms, int precision) {
        double e = 1.0;
        for (int i = 1; i < terms; i++) {
            e += 1.0 / factorial(i);
        }
        return Math.round(e * Math.pow(10, precision)) / Math.pow(10, precision);
    }

    public static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
