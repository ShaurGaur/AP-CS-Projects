// Shaurya Gaur / AP Computer Science Period 2 / 2018-2-6
import java.util.Scanner;

public class DoubledLetters {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String userVal = input.nextLine();

        String[] words = userVal.split(" ");
        boolean[] doubledVowels = new boolean[words.length];
        boolean[] doubledConsonants = new boolean[words.length];

        for (int j = 0; j < words.length; j++) {
            String word = words[j].toLowerCase();
            for (int i = 0; i < word.length() - 1; i++) {
                if (word.charAt(i) == word.charAt(i + 1)) {
                    if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' ||
                            word.charAt(i) == 'o' || word.charAt(i) == 'u') doubledVowels[j] = true;
                    else doubledConsonants[j] = true;
                }
            }
        }

        for (int i = 0; i < words.length; i++)
            if (doubledVowels[i] && !doubledConsonants[i]) System.out.print(words[i] + " ");
    }
}
