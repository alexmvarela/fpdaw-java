import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;

public class PrimeNumbers {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int[] numbers = inputNumbers(sc);
			printResults(numbers);
		} catch (InputMismatchException e) {
			System.out.print("Exiting the program...");
		} finally {
			sc.close();
		}
	}
	
	public static int[] inputNumbers(Scanner sc) throws InputMismatchException {
		int[] numbers = new int[5];
		int i = 0;
		while (i < 5) {
			System.out.println("Enter an integer. (Type <exit> to quit.)");
			String input = sc.nextLine();
			if (input.equalsIgnoreCase("exit")) throw new InputMismatchException();
			try {
				numbers[i] = Integer.parseInt(input);
				i++;
			} catch (NumberFormatException e) {
				System.out.println("Invalid input.");
			}
		}
		return numbers;
	}
	
	public static void  printResults(int[] numbers) {
		System.out.println("Results for " + Arrays.toString(numbers));
		for (int number : numbers) {
			if (number < 0) {
				System.out.println("Number " + number + " is negative");
			} else if (number == 0 || number == 1) {
				System.out.println("Number " + number + " is not prime");
			} else if (number == 2) {
				System.out.println("Number " + number + " is prime");
			} else if (number % 2 == 0) {
				System.out.println("Number " + number + " is not prime");
			} else {
				int counter = 0;
				for (int i = 1; i <= number; i++) {
					if (number % i == 0) counter++;
				}
				if (counter > 2) {
					System.out.println("Number " + number + " is not prime");
				} else {
					System.out.println("Number " + number + " is prime");
				}
			}
		}
	}
}