import java.util.Scanner;

public class DivisionWithoutOperators {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dividend = handleUserInput(sc, "dividend");
        int divisor = handleUserInput(sc, "divisor");

        int quotient = 0;
        int remainder = dividend;

        while (remainder >= divisor) {
            remainder -= divisor; 
            quotient++;
        }
	
	System.out.println(dividend + " / " + divisor);
        System.out.println("Quotient: " + quotient);
        System.out.println("Remainder: " + remainder);
        
        sc.close();
    }
    
    public static int handleUserInput(Scanner sc, String divisionOperator ) {
	System.out.print("Enter the " + divisionOperator + " (an intenger number): ");
        int operator;
        while (true) {
            if (sc.hasNextInt()) {
                operator = sc.nextInt();
                sc.nextLine();
                if (divisionOperator == "divisor" && operator == 0) {
                    System.out.print("Divisor cannot be zero. Enter a valid integer: ");
                } else {
                    return operator;
                }
            } else {
                System.out.print("Invalid input. Enter an integer: ");
                sc.nextLine();
            }
        }
    }
}
