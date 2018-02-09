//w   =   [ P(1 + r)Yr ] / [ (1 + r)Y - 1 ]

import java.text.DecimalFormat;
import java.util.Scanner;
import java.lang.Math;

public class Annuity {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Account Principal: ");
            double p = input.nextDouble();
        System.out.print("Term (years): ");
            double y = input.nextDouble();
        System.out.print("Interest rate (percent): ");
            double r = input.nextDouble() / 100;

        double w = (p * Math.pow(1+r, y) * r) / (Math.pow(1+r, y) - 1);
        System.out.println("Annual Payout: $" + round(w));
        System.out.println("Monthly Payout: $" + round(w / 12));
    }

    public static String round(double input) {
        return new DecimalFormat("#.##").format(input);
    }
}
