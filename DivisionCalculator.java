import java.util.Scanner;

public class DivisionCalculator {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counter = 0;
		boolean exit = false;
		
        while (!exit) {
			int dividend = inputNumber(sc, "Dividend: enter an integer. (Exit --> dividend = -1 and divisor = -1)");
			int divisor = inputNumber(sc, "Divisor: enter an integer. (Exit --> dividend = -1 and divisor = -1))");
            if (dividend == -1 && divisor == -1) {
                exit = true;
            } else {
				try {
					int result = dividend / divisor;
					System.out.println(dividend + " / " + divisor + " = " + result);
					counter++;
				} catch (ArithmeticException e) {
					System.out.println("Error: Division by zero is not allowed.");
				}
			}
        }

        System.out.println("Total divisions: " + counter);
        sc.close();
    }
	
	public static int inputNumber(Scanner sc, String message) {
		int number = 0;
		boolean isValidInput = false;
		while (!isValidInput) {
			System.out.println(message);
			String input = sc.nextLine();
			try {
				number = Integer.parseInt(input);
				isValidInput = true;
			} catch (NumberFormatException e) {
				System.out.println("Invalid input.");
			}
		}
		return number;
	}
}
