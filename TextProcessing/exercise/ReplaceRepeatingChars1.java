package TextProcessing.exercise;

import java.util.Scanner;

public class ReplaceRepeatingChars1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        StringBuilder newText = new StringBuilder();
        char firstLetter = input.charAt(0);
        newText.append(firstLetter);
        for (int i = 1; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if (currentSymbol != newText.charAt(newText.length() - 1)) {
                newText.append(currentSymbol);
            }
        }
        System.out.println(newText);
    }
}
