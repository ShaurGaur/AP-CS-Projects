import java.lang.Math;
public class PowersTable {
    public static void main(String[] args) {
        System.out.format("%8s%8s%8s%8s%8s%n", "x^1", "x^2", "x^3", "x^4", "x^5");
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 6; j++) System.out.format("%8s", (int) Math.pow(i, j));
            System.out.format("%n");
        }
    }
}