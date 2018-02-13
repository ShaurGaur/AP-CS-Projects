import java.util.ArrayList;
import java.util.Scanner;

public class Goldilocks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> output = new ArrayList<>();

        int input, ones = 0, zeros = 0;
        do {
            System.out.print("Enter a base-10 positive number less than 100: ");
            input = scanner.nextInt();
        } while (input < 0 || input >= 100);

        String binary = Integer.toBinaryString(input);

        System.out.print("Binary form: " + binary);
        for (int i = 0; i < binary.length(); i++) {
            int num = Integer.parseInt(binary.charAt(i) + "");
            if (num == 1) ones++; else zeros++;
        }

        String message = "";
        if (ones == zeros) message = "just right";
        else if (ones > zeros) message = "too heavy";
        else if (ones < zeros) message = "too light";
        System.out.printf("\nThe number is %s!", message);
    }
}