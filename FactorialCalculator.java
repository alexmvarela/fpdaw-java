import java.util.Scanner;

public class FactorialCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	System.out.println("Enter an integer greater than 0: ");
        int number = handleInput(sc);
        long factorial = calculateFactorial(number);
        System.out.println(number + "! = " + factorial);
	sc.close();
    }

    public static int handleInput(Scanner sc) {
	while (true) {
	    if (!sc.hasNextInt()) {
	        System.out.println("Invalid input. Enter an integer greater than 0: ");
		sc.nextLine();
	    } else {
		int number = sc.nextInt();
		sc.nextLine();
		if (number > 0) {
		    return number;
		} else {
		    System.out.println("The integer must be greater than 0. Try again: ");
		}
	    }
    	}
    }	   

    public static long calculateFactorial(int num) {
        long result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
