import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;

public class SortNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		try {
			int[] numbers = inputNumbers(sc);
			System.out.println("Numbers: " + Arrays.toString(numbers));
			int[] sortedNumbers = sortNumbers(numbers);
			System.out.println("Sorted numbers: " + Arrays.toString(sortedNumbers));
		} catch (InputMismatchException e) {
			System.out.print("Exiting the program...");
		} finally {
			sc.close();
		}
	}
	
	public static int[] inputNumbers(Scanner sc) throws InputMismatchException {
		System.out.println("Enter 7 integer numbers. Or type <exit> to quit program");
		int[] numbers = new int[7];
		int i = 0;
		while (i < 7) {
			System.out.println("Number " + (i + 1) + ":");
			String input = sc.nextLine();
			if (input.equalsIgnoreCase("exit")) throw new InputMismatchException();
			try {
				numbers[i] = Integer.parseInt(input);
				i++;
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Enter an integer or type <exit> to quit: ");
			}
		}
		return numbers;
	}
	
	public static int[] sortNumbers(int[] numbers) {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 6 - i; j++) {
				if (numbers[j] > numbers[j + 1]) {
					int num = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = num;
				}
			}
		}
		return numbers;
	}
}	

