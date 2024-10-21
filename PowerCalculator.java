import java.util.Scanner;

public class PowerCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the base (an integer number): ");
        while (!sc.hasNextInt()) {
            handleInvalidInput(sc, "base");
        }
        int base = sc.nextInt();
	sc.nextLine();
        
        System.out.print("Enter the exponent (an integer number): ");
        while (!sc.hasNextInt()) {
            handleInvalidInput(sc, "exponent");            
        }
        int exponent = sc.nextInt();
	sc.nextLine();

        double result = calculatePower(base, exponent);

        System.out.println(base + "^" + exponent + " = "  + result);
        
        sc.close();
    }

    public static void handleInvalidInput(Scanner sc, String input) {
	 System.out.println("Invalid input. ");
         sc.nextLine();
         System.out.print("Enter the " + input + " (an integer number): ");
    }	

    public static double calculatePower(int base, int exponent) {
    	 if (exponent < 0) {
             return 1.0 / calculatePower(base, -exponent);
    	 } else if (exponent == 0) {
             return 1.0;
    	 } else {
	     double result = 1.0;
	     for (int i = 0; i < exponent; i++) {
                 result *= base; 
	     }
	     return result;
	 }
    }
}
