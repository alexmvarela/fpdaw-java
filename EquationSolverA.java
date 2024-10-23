import java.util.Scanner;

public class EquationSolverA {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            double a = handleInput(sc, "Enter coefficient a: ");
            double b = handleInput(sc, "Enter coefficient b: ");
            double c = handleInput(sc, "Enter coefficient c: ");

            if (a == 0) {
                if (b == 0) {
                    if (c == 0) {
                        System.out.println("The equation has infinite solutions.");
                    } else {
                        System.out.println("The equation has no solution.");
                    }
                } else {
                    double result = -c / b;
                    System.out.printf("The equation has one solution:\nx = %.2f%n", result);
                }
            } else {
                if (b * b - (4 * a * c) > 0) {
                    double result1 = (-b + Math.sqrt(b * b - (4 * a * c))) / (2 * a);
                    double result2 = (-b - Math.sqrt(b * b - (4 * a * c))) / (2 * a);
                    System.out.printf("The equation has two real solutions:\nx1 = %.2f\nx2 = %.2f%n", result1, result2);
                } else if (b * b - (4 * a * c) == 0) {
                    double result = -b / (2 * a);
                    System.out.printf("The equation has one real solution: x = %.2f%n", result);
                } else {
                    System.out.println("The equation has no real solutions.");
                }
            }
        } catch (InterruptedException e) {
            System.out.print("Exiting the program...");   
        } finally {
            sc.close();
        }
    }
    
    public static double handleInput(Scanner sc, String message) throws InterruptedException {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();
                    
            if (input.equalsIgnoreCase("exit")) {
                throw new InterruptedException(); 
            }

            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a valid number or type <exit> to quit.");
            }
        }
    }
}
