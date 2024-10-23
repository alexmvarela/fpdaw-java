import java.util.Scanner;

public class EquationSolverB {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            double a = handleInput(sc, "Enter coefficient a: ");
            double b = handleInput(sc, "Enter coefficient b: ");
            double c = handleInput(sc, "Enter coefficient c: ");
            double[] solutions = ec2g(a, b, c);
            
            if (solutions == null) {
                System.out.println("The equation has no real solutions.");
            } else if (solutions.length == 1) {
                System.out.printf("The equation has one solution:\n x = %.2f%n", solutions[0]);
            } else {
                System.out.printf("The equation has two solutions:\nx1 = %.2f\nx2 = %.2f%n", solutions[0], solutions[1]);
            }
        } catch (InterruptedException e) {
            System.out.print("Exiting the program...");   
        } finally {
            sc.close();
        }
    }
    
    public static double[] ec2g(double a, double b, double c) {
        if (a == 0) {
            if (b == 0) {
                return null;
            } else {
                return new double[] {-c / b};
            }
        } else {
            if (b * b - (4 * a * c) > 0) {
                double result1 = (-b + Math.sqrt(b * b - (4 * a * c))) / (2 * a);
                double result2 = (-b - Math.sqrt(b * b - (4 * a * c))) / (2 * a);
                return new double[] {result1, result2};
            } else if (b * b - (4 * a * c) == 0) {
                return new double[] {-b / (2 * a)};
            } else {
                return null;
            }
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
