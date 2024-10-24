import java.util.Scanner;
import java.util.InputMismatchException;

public class MCMCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int num1 = inputNumbers(sc, "Enter the first integer number. (Type <exit> to quit)");
			int num2 = inputNumbers(sc, "Enter the second integer number. (Type <exit> to quit)");
			if (num1 <= 0 || num2 <= 0) {
				System.out.print("Both numbers must be positive.\nExiting the program...");
			} else {
				int mcm = calculateMCM(num1, num2);
				System.out.print("MCM (" + num1 + "," + num2 + ") = " + mcm);
			}
		} catch (InputMismatchException e) {
			System.out.print("Exiting the program...");
		}finally {
			sc.close();
		}
    }
	
	public static int inputNumbers(Scanner sc, String message) throws InputMismatchException {
		int number = 0;
		boolean isValidInput = false;
		while (!isValidInput) {
			System.out.println(message);
			String input = sc.nextLine();
			if (input.equalsIgnoreCase("exit")) throw new InputMismatchException();
			try {
				number = Integer.parseInt(input);
				isValidInput = true;
			} catch (NumberFormatException e) {
				System.out.println("Invalid input.");
			}
		}
		return number;
	}
	
	public static int calculateMCM(int num1, int num2) {
		int max = Math.max(num1, num2);
        int mcm = max;
        while (mcm % num1 != 0 || mcm % num2 != 0) {
            mcm += max;
        }
        return mcm;
	}
}
