import java.util.Scanner;

public class Complex {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex add(Complex otherComplex) {
        double realPart = this.real + otherComplex.real;
        double imaginaryPart = this.imaginary + otherComplex.imaginary;
        return new Complex(realPart, imaginaryPart);
    }

    public Complex subtract(Complex otherComplex) {
        double realPart = this.real - otherComplex.real;
        double imaginaryPart = this.imaginary - otherComplex.imaginary;
        return new Complex(realPart, imaginaryPart);
    }

    public Complex multiply(Complex otherComplex) {
        double realPart = (this.real * otherComplex.real) - (this.imaginary * otherComplex.imaginary);
        double imaginaryPart = (this.real * otherComplex.imaginary) + (this.imaginary * otherComplex.real);
        return new Complex(realPart, imaginaryPart);
    }

    public Complex divide(Complex otherComplex) {
        double denominator = (otherComplex.real * otherComplex.real) + (otherComplex.imaginary * otherComplex.imaginary);
        double realPart = (this.real * otherComplex.real + this.imaginary * otherComplex.imaginary) / denominator;
        double imaginaryPart = ((this.imaginary * otherComplex.real) - (this.real * otherComplex.imaginary)) / denominator;
        return new Complex(realPart, imaginaryPart);
    }

	public String toComplexString() {
        if (imaginary >= 0) {
            return real + " + " + imaginary + "i";
        } else {
            return real + " - " + (-imaginary) + "i";
        }
    }

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double z1Real = inputComplex(sc, "Enter the real part of z1:");
		double z1Imaginary = inputComplex(sc, "Enter the imaginary part of z1:");
		double z2Real = inputComplex(sc, "Enter the real part of z2:");
		double z2Imaginary = inputComplex(sc, "Enter the imaginary part of z2:");
		
        Complex z1 = new Complex(z1Real, z1Imaginary);
        Complex z2 = new Complex(z2Real, z2Imaginary);

        System.out.println("z1 = " + z1.toComplexString());
        System.out.println("z2 = " + z2.toComplexString());

        Complex sum = z1.add(z2);
        System.out.println("Sum: " + sum.toComplexString());

        Complex subtraction = z1.subtract(z2);
        System.out.println("Subtraction: " + subtraction.toComplexString());

        Complex multiplication = z1.multiply(z2);
        System.out.println("Multiplication: " + multiplication.toComplexString());

        Complex division = z1.divide(z2);
        System.out.println("Division: " + division.toComplexString());
    }
	
	public static double inputComplex(Scanner sc, String message) {
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
}
