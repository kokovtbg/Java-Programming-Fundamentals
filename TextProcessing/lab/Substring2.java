package TextProcessing.lab;

import java.util.Scanner;

public class Substring2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String wordToRemove = scan.nextLine();
        String input = scan.nextLine();

        while (input.contains(wordToRemove)) {
            input = removeOccurrence(input, wordToRemove);
        }
        System.out.println(input);
    }

    private static String removeOccurrence(String text, String wordToRemove) {
        int beginIndex = text.indexOf(wordToRemove);
        int endIndex = wordToRemove.length() + beginIndex;
        String firstPart = text.substring(0, beginIndex);
        String secondPart = text.substring(endIndex);
        return firstPart + secondPart;
    }
}
