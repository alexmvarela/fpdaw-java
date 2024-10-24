import java.util.Scanner;
import java.util.InputMismatchException;

public class ReplaceString {
	
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			String str1 = inputStrings(sc, 1, null, "Enter the first string. (Type <exit> to quit)");
			String str2 = inputStrings(sc, 2, str1, "Enter the second string. It must be a substring of \"" + str1 + "\". (Type <exit> to quit)");
			String str3 = inputStrings(sc, 3, null, "Enter the third string. This string will replace the substring \"" + str2 + "\" in the first string. (Type <exit> to quit)");
			String result = replaceStr(str1, str2, str3);
			System.out.println("1: " + str1 + "\n2: " + str2 + "\n3: " + str3 + "\nresult: " + result);
		} catch (InputMismatchException e) {
			System.out.print("Exiting the program...");
		} finally {
			sc.close();
		}
    }
	
	public static String inputStrings(Scanner sc, int currentString, String str1, String message) throws InputMismatchException {
		String input = "";
		boolean isValidString = false;
		
		while (!isValidString) {
			System.out.println(message);
			input = sc.nextLine();
			
			if (input.equalsIgnoreCase("exit")) {
				throw new InputMismatchException();
				
			} else if (currentString == 1 || currentString == 3) {
				if (input.trim().isEmpty()) {
					System.out.println("Invalid input: the string cannot be empty.");
				} else {
					isValidString = true;
				}
			
			} else if (currentString == 2){
				if (!str1.contains(input)) {
					System.out.println("Invalid input: it is not a substring of the first string.");
				} else {
					isValidString = true;
				}
			}
		}
		return input;
	}

    public static String replaceStr(String str1, String str2, String str3) {
		String result = "";
		int i = 0;
		
		while (i < str1.length()) { 
			if (i <= str1.length() - str2.length() && str1.substring(i, i + str2.length()).equals(str2)) {
				result += str3; 
				i += str2.length();
			} else {
				result += str1.charAt(i);
				i++;
			}
		}
		return result;
	}
}
