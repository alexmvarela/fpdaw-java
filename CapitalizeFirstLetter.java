import java.util.Scanner;
import java.util.InputMismatchException;

public class CapitalizeFirstLetter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		try {
			String input = inputString(sc);
			String capitalizedString = input.substring(0, 1).toUpperCase() + input.substring(1);
			System.out.println("Capitalized string: " + capitalizedString);
		} catch(InputMismatchException e) {
			System.out.print("Exiting the program...");
		} finally {
			sc.close();
		}
    }
	
	public static String inputString (Scanner sc) throws InputMismatchException {
		System.out.println("Enter a string. Or type <exit> to quit program.");
		String input = "";
		boolean isValidString = false;
		while (!isValidString) {
			input = sc.nextLine();
			if (input.equalsIgnoreCase("exit")) {
				throw new InputMismatchException();
			} else if (!Character.isLetter(input.charAt(0))) {
				System.out.println("The first character is not a letter.\nEnter a string or type <exit> to quit.");
			} else {
				isValidString = true;
			}
		}
		return input;
	}
}
