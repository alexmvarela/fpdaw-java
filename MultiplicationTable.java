import java.util.Scanner;

public class MultiplicationTable {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;

        while (true) {
            System.out.print("Enter a integer number between 1 and 9: ");
            if (sc.hasNextInt()) {
                number = sc.nextInt();
		sc.nextLine();
                if (number >= 1 && number <= 9) {
                    break;
                } else {
                    System.out.println("Error: The number must be between 1 and 9. Try again.");
                }
            } else {
                System.out.println("Error: Invalid input.");
                sc.nextLine();
            }
        }

        System.out.println("Multiplication table for " + number + ":");
        for (int i = 1; i <= 9; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }

        sc.close();
    }
}
