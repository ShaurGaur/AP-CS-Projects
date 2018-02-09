// Shaurya Gaur -- AP Computer Science P2 -- 2018-01-30
import java.util.ArrayList;
import java.util.Scanner;

public class Grades {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Integer> grades = new ArrayList<>();
    static int maxPoints = 0;

    public static void main(String[] args) {
        int selection;
        String[] menu = {"\nGRADES", "1 - Load Grades", "2 - Highest Grade", "3 - Lowest Grade",
                "4 - Analytics", "5 - Sort Descending", "6 - Sort Ascending", "7 - Quit\n"};
        final int QUIT = menu.length - 1;

        do {
            for (String item : menu) System.out.println(item);
            do {
                System.out.print("Type one of the above numbers to select: ");
                selection = input.nextInt();
            } while (selection < 1 || selection > QUIT);
            System.out.println();

            switch (selection) {
                case 1: loadGrades(); break;
                case 2: showHighestGrade(true); break;
                case 3: showHighestGrade(false); break;
                case 4: analytics(); break;
                case 5: sort(true); break;
                case 6: sort(false); break;
                case 0: printGrades();
                default: break;
            }
        } while(selection < QUIT);
    }

    private static void printGrades() {
        for (Integer grade : grades) System.out.printf("%s ", grade);
        System.out.println();
    }

    private static void sort(boolean descending) {
        if (grades.size() == 0) System.out.println("Load a list of grades first.");
        else {
            ArrayList<Integer> oldGrades = new ArrayList<>(); int index;
            for (Integer grade : grades) oldGrades.add(grade);
            ArrayList<Integer> newGrades = new ArrayList<>(grades.size());

            for (int i = 0; i < grades.size(); i++) {
                index = oldGrades.indexOf(getMax(oldGrades, descending));
                newGrades.add(oldGrades.get(index));
                oldGrades.remove(index);
            }

            grades = newGrades;
            printGrades();
        }
    }

    private static void loadGrades() {
        do {
            System.out.print("Possible Points for this assignment (type 100 for percent grades): ");
            maxPoints = input.nextInt();
        } while(maxPoints <= 0);

        int gradeCount;
        do {
            System.out.print("Number of Grades to Enter: ");
            gradeCount = input.nextInt();
        } while(gradeCount <= 0);

        for (int i = 0; i < gradeCount; i++) {
            int grade;
            do {
                System.out.print("Enter grade: ");
                grade = input.nextInt();
            } while(grade < 0 || grade > maxPoints);
            grades.add(new Integer(grade));
        }
    }

    private static int getMax(ArrayList<Integer> list, boolean highest) {
        int returnValue;
        if (highest) {
            returnValue = 0;
            for (Integer grade : list) {if (grade > returnValue) returnValue = grade;}
        } else {
            returnValue = maxPoints;
            for (Integer grade : list) {if (grade < returnValue) returnValue = grade;}
        }
        return returnValue;
    }

    private static void showHighestGrade(boolean highest) {
        if (grades.size() == 0) System.out.println("Load a list of grades first.");
        else if (highest) {
            int max = getMax(grades, true);
            System.out.println("Highest Grade: " + max + " (" + (100 * max / maxPoints) + "%)");
        }
        else {
            int min = getMax(grades, false);
            System.out.println("Lowest Grade: " + min + " (" + (100 * min / maxPoints) + "%)");
        }
    }

    private static void analytics() {
        if (grades.size() == 0) System.out.println("Load a list of grades first.");
        else {
            char[] letters = {'A', 'B', 'C', 'D', 'F'};
            int[] ltrCt = new int[5];
            int sum = 0;

            for (Integer grade : grades) {
                sum += grade;
                double percent = 100 * grade / maxPoints;

                if (percent >= 90) ltrCt[0]++;
                else if (percent >= 80) ltrCt[1]++;
                else if (percent >= 70) ltrCt[2]++;
                else if (percent >= 60) ltrCt[3]++;
                else ltrCt[4]++;
            }

            int average = sum / grades.size();
            double percentPassing = 100 * (ltrCt[0] + ltrCt[1] + ltrCt[2] + ltrCt[3]) / grades.size();

            System.out.println("Average: " + average + " (" + (100 * average / maxPoints) + "%)");
            for (int i = 0; i < letters.length; i++) {
                System.out.printf("%s's: %s (%s percent)%n", letters[i], ltrCt[i], 100 * ltrCt[i] / grades.size());
            }
            System.out.println("Percent passing: " + percentPassing);
        }
    }
}
