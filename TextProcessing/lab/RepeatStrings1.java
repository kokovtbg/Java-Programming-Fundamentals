package TextProcessing.lab;

import java.util.Arrays;
import java.util.Scanner;

public class RepeatStrings1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().split(" ");

        for (String word : words) {
            String repeatedWord = repeatWord(word, word.length());
            System.out.print(repeatedWord);
        }
    }

    private static String repeatWord(String word, int length) {
        String result = "";
        for (int i = 0; i < length; i++) {
            result += word;
        }
        return result;
    }
}
