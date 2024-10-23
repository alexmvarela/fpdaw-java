import java.util.Scanner;
import java.util.InputMismatchException;

public class CalculateEA {

    public static void main(String[] args) {
		try {
			int terms = inputTerms();
			double e = calculateE(terms);
			System.out.printf("Calculated value of e using %d terms: %.15f", terms, e);
		} catch (InputMismatchException e) {
			System.out.print("Exiting the program...");
		}
    }
	
	public static int inputTerms() throws InputMismatchException {
		System.out.print("Enter the number of terms to calculate e: ");
		Scanner sc = new Scanner(System.in);
		while (true) {
			String input = sc.nextLine();
			if (input.equalsIgnoreCase("exit")) throw new InputMismatchException();
			try {
				int integerInput = Integer.parseInt(input);
				if (integerInput > 0) {
					return integerInput;
				} else {
					System.out.println("Invalid input. Enter an integer > 0 or type <exit> to quit: ");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Enter an integer > 0 or type <exit> to quit: ");
			}
		}
	}

    public static double calculateE(int terms) {
        double e = 1.0;
        for (int i = 1; i < terms; i++) {
            e += 1.0 / factorial(i);
        }
        return e;
    }

    public static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
