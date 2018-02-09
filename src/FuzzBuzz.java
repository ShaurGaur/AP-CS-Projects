//Shaurya Gaur / AP Comp Sci / 12-14-2017
public class FuzzBuzz {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.format("%n%-4s", i);
            if (i % 5 == 0 && i % 3 == 0) System.out.print("FUZZBUZZ!");
            else if (i % 3 == 0) System.out.print("Fuzz!");
            else if (i % 5 == 0) System.out.print("Buzz!");
}}}
