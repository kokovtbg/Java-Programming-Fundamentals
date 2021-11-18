package TextProcessing.exercise;

import java.util.Scanner;

public class ValidUsernames1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().split(", ");

        for (String word : words) {
            if (isValidWord(word)) {
                System.out.println(word);
            }
        }
    }

    private static boolean isValidWord(String word) {
        if (!(word.length() >= 3 && word.length() <= 16)) {
            return false;
        }
        for (char symbol : word.toCharArray()) {
            if (!(Character.isLetterOrDigit(symbol) || symbol == '-' || symbol == '_')) {
                return false;
            }
        }
        return true;
    }
}
