package TextProcessing.exercise;

import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        String sortedText = "";
        for (int i = 0; i < text.length(); i++) {
            sortedText += text.charAt(i);
            while (i < text.length() - 1 && text.charAt(i) == text.charAt(i + 1)) {
                i++;
            }
        }
        System.out.println(sortedText);
    }
}
