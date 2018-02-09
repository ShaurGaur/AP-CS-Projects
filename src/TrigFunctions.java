import java.text.DecimalFormat;
import java.util.Scanner;
import java.lang.Math;

public class TrigFunctions {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an angle in degrees: ");
        double angle = input.nextDouble();
        angle *= Math.PI / 180;

        System.out.println("Sine: " + twoPlaces(Math.sin(angle)));
        System.out.println("Cosine: " + twoPlaces(Math.cos(angle)));
        System.out.println("Tangent: " + twoPlaces(Math.tan(angle)));
    }

    public static String twoPlaces(double input) {
        return new DecimalFormat("#.##").format(input);
    }
}
