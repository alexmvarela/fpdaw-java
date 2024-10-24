import java.util.Scanner;

public class GuessGame {
	
	public static int numInt = 5;
    public static int numMax = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int option;
		
        do {
            System.out.println("1. Configure");
            System.out.println("2. Play");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            option = inputNumber(sc);

            switch (option) {
                case 1:
                    configureGame(sc);
                    break;
                case 2:
                    playGame(sc);
                    break;
                case 3:
                    System.out.println("Exiting the game...");
                    break;
				default:
					System.out.println("Invalid option. Try again.");
            }
        } while (option != 3);

        sc.close();
    }
	
	public static int inputNumber(Scanner sc) {
		int number = 0;
		boolean isValidInput = false;
		while (!isValidInput) {
			String input = sc.nextLine();
			try {
				number = Integer.parseInt(input);
				if (number > 0) {
					isValidInput = true;
				} else {
					System.out.println("Error: the integer input must be > 0. Try again.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Try again.");
			}
		}
		return number; 
	}

    public static void configureGame(Scanner sc) {
        System.out.print("Enter the number of allowed attempts: ");
        numInt = inputNumber(sc);
        System.out.print("Enter the maximum number for guessing: ");
        numMax = inputNumber(sc);
        System.out.println("Configuration saved: " + numInt + " attempts, max number " + numMax);
    }

    public static void playGame(Scanner sc) {
        int numOculto = (int) Math.floor(Math.random() * (numMax + 1)); 
        int attemptsLeft = numInt;
        boolean guessed = false;
		
        System.out.println("A number has been generated between 0 and " + numMax + ". Try to guess it.");

        while (attemptsLeft > 0 && !guessed) {
            System.out.println("Enter your guess: ");
            int userGuess = inputNumber(sc);
            attemptsLeft--;

            if (userGuess == numOculto) {
                System.out.println("You won! You needed " + (numInt - attemptsLeft) + " attempts.");
                guessed = true;
            } else if (userGuess < numOculto) {
                System.out.println("The hidden number is greater.");
            } else {
                System.out.println("The hidden number is smaller.");
            }

            if (attemptsLeft == 0 && !guessed) {
                System.out.println("You lost! The hidden number was: " + numOculto);
            }
        }
    }
}
