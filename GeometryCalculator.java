import java.util.Scanner;

public class GeometryCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double radius;

        while (true) {
            System.out.print("Enter the radius (a positive real number): ");

            if (sc.hasNextDouble()) {
                radius = sc.nextDouble();
                if (radius > 0) {
                    final double PI = Math.PI;
                    double area = PI * Math.pow(radius, 2);
                    double circumferenceLength = 2 * PI * radius;
                    double volume = (4.0 / 3.0) * PI * Math.pow(radius, 3);
                    double surfaceArea = 4 * PI * Math.pow(radius, 2);
                    
                    System.out.printf("Area of the circle: %.4f%n", area);
                    System.out.printf("Circumference length: %.4f%n", circumferenceLength);
                    System.out.printf("Volume of the sphere: %.4f%n", volume);
                    System.out.printf("Surface area of the sphere: %.4f%n", surfaceArea);
                    
                    break;  
                } else {
                    System.out.println("Error: the radius must be a positive number.");
                }
            } else {
                System.out.println("Error: the radius must be a real number.");
                sc.next();            }
        }

        sc.close();
    }
}
