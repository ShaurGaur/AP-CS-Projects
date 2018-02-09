//Shaurya Gaur / AP Computer Science / 1-4-2018

import java.util.ArrayList; import java.util.List;
import java.util.Random; import java.util.Scanner;

public class Slots {
    public static void main(String[] args) {
        final int NUM_COUNT = 3; boolean quit = false;
        Random rand = new Random(); Scanner input = new Scanner(System.in);

        System.out.print("Starting money in pot ($): "); double money = input.nextDouble();
        System.out.print("Enter chance (1 in ____): "); int max = input.nextInt();

        while (money > 0 && !quit) {
            double bet = 0;
            while (bet == 0) {
                System.out.print("\nChoose bet: quarter (q), nickel (n) or dollar (d) - ");
                String bResp = input.next();
                if (bResp.equals("q")) bet += .25;
                else if (bResp.equals("n")) bet += .05;
                else if (bResp.equals("d")) bet += 1;
            }

            List<Integer> numList = new ArrayList<>();
            for (int i = 1; i <= NUM_COUNT; i++) {numList.add(rand.nextInt(max) + 1);}
            for (int i : numList) {System.out.format("%-4s", i);}

            boolean equal = false; int unequal = 0;
            for (int i : numList) {for (int j : numList) {if (i != j) unequal++;}}
            if (unequal == 0) equal = true;

            boolean sequence = false; int seq = 0;
            for (int i = 1; i < numList.size(); i++) {
                if (numList.get(i) == numList.get(i-1) + 1) seq++;
                else if (numList.get(i) == numList.get(i-1) - 1) seq--;
            }
            if (Math.abs(seq) == numList.size() - 1) sequence = true;

            if (equal || sequence) {
                money += bet;
                System.out.println("\nYou won! New balance: $" + money);
            } else {
                money -= bet;
                System.out.println("\nYou lost! New balance: $" + money);
            }

            if (money > 0) {
                System.out.println("Play another round? y or n");
                String qResp = input.next();
                if (qResp.equals("n")) quit = true;
            }
        }

        System.out.println("\nFinal balance: $" + money + "\nGame over!");
    }
}