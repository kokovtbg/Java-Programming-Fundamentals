package TextProcessing.lab;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String bannedWords = scan.nextLine();
        String text = scan.nextLine();

        String[] wordsToMute = bannedWords.split(", ");
        for (int i = 0; i < wordsToMute.length; i++) {
            StringBuilder asterisks = new StringBuilder();
            for (int j = 0; j < wordsToMute[i].length(); j++) {
                asterisks.append("*");
            }
            text = text.replace(wordsToMute[i], asterisks.toString());
        }
        System.out.println(text);
    }
}
