package TextProcessing.lab;

import java.util.Scanner;

public class DigitsLettersOther {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();

        String digits = text.replaceAll("[^0-9]", "");
        StringBuilder letters = new StringBuilder();
        StringBuilder otherChars = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if ((text.charAt(i) >= 'a' && text.charAt(i) <= 'z') || (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z')) {
                letters.append(text.charAt(i));
            }
            if ((text.charAt(i) < 'a' && text.charAt(i) > 'Z') || (text.charAt(i) < 'A' && text.charAt(i) > '9') || text.charAt(i) < '0' || text.charAt(i) > 'z') {
                otherChars.append(text.charAt(i));
            }
        }
        System.out.println(digits);
        System.out.println(letters);
        System.out.println(otherChars);
    }
}
