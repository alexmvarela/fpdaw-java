import java.util.Scanner;

public class QuadraticEquation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double a = inputCoefficient(sc, "Enter coefficient a:");
        double b = inputCoefficient(sc, "Enter coefficient b:");
        double c = inputCoefficient(sc, "Enter coefficient c:");

        solveQuadratic(a, b, c);

        sc.close();
    }

    public static double inputCoefficient(Scanner sc, String message) {
		System.out.println(message);
		double num = 0;
		boolean isValidInput = false;
		
		while (!isValidInput) {
			try {
				String input = sc.nextLine();
				num = Double.parseDouble(input);
				isValidInput = true;
			} catch(NumberFormatException e) {
				System.out.println("Invalid input. " + message);
			}
		}
		return num;
	}

    public static void solveQuadratic(double a, double b, double c) {
        double x =(b * b) - (4 * a * c);

        if (x > 0) {
            double root1 = (-b + Math.sqrt(x)) / (2 * a);
            double root2 = (-b - Math.sqrt(x)) / (2 * a);
            System.out.println("Roots are real:");
            System.out.printf("Root 1: %.2f%n", root1);
            System.out.printf("Root 2: %.2f%n", root2);
        } else if (x == 0) {
            double root = -b / (2 * a);
            System.out.println("Root is real:");
            System.out.printf("Root: %.2f%n", root);
        } else {
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-x) / (2 * a);
            System.out.println("Roots are complex:");
            System.out.printf("Root 1: %.2f + %.2fi%n", realPart, imaginaryPart);
            System.out.printf("Root 2: %.2f - %.2fi%n", realPart, imaginaryPart);
        }
    }
}
