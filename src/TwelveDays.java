//Shaurya Gaur / AP Comp Sci P2 / 12-14-2017
public class TwelveDays {
    public static void main(String[] args) {
        int t = 0;
        for (int i = 1; i <= 12; i++) for (int j = 1; j <= i; j++) t += j;
        System.out.println("Total gifts: "+t);
    }
}
