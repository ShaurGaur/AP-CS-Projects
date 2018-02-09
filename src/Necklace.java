//Shaurya Gaur | 12/12/17 | AP CS Period 2

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Necklace {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        System.out.print("First starting number: ");
        int first = input.nextInt();
        System.out.print("Second starting number: ");
        int second = input.nextInt();
        numList.add(first);
        numList.add(second);
        int ult = second;
        int penult = first;

        do {
            int nextNum = (ult + penult) % 10;
            numList.add(nextNum);
            ult = numList.get(numList.size() - 1);
            penult = numList.get(numList.size() - 2);
        } while (!(ult == second && penult == first));

        for (int num : numList) {System.out.print(num + " ");}
    }
}