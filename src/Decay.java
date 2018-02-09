import java.lang.Math;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Decay {
    static Scanner input = new Scanner(System.in);
    static double e = Math.E;

    public static void main(String[] args) {
        System.out.println("1. Final Amount");
        System.out.println("2. Initial Amount");
        System.out.println("3. Constant (half-life)");
        System.out.print("Find: ");
        int choice = input.nextInt();

        switch (choice) {
            case 1: findFinal(); break;
            case 2: findInitial(); break;
            case 3: findHalfLife(); break;
            default: break;
        }
    }

    public static void findInitial() {
        double y = promptDub("final mass");
        double t = promptDub("elapsed time in years");
        double k = promptDub("half-life constant");

        double n = y / Math.pow(e, -k*t);
        System.out.println("Initial mass: " + round(n));
    }

    public static void findFinal() {
        double n = promptDub("initial mass");
        double t = promptDub("elapsed time in years");
        double k = promptDub("half-life constant");

        double y = n * Math.pow(e, -k*t);
        System.out.println("Final mass: " + round(y));
    }

    public static void findHalfLife() {
        double y = promptDub("final mass");
        double n = promptDub("initial mass");
        double t = promptDub("elapsed time in years");

        double k = Math.log(y/n) / t;
        System.out.println("Half-life constant: " + round(k));
    }

    public static double promptDub(String item) {
        System.out.printf("Enter %s: ", item);
        return input.nextDouble();
    }

    public static String round(double input) {
        return new DecimalFormat("#.#####").format(input);
    }
}

