package TextProcessing.lab;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstString = scan.nextLine();
        String secondString = scan.nextLine();

        for (int i = 0; i < secondString.length(); i++) {
            int countLetters = firstString.length();
            int count = 0;
            for (int j = 0; j < firstString.length(); j++) {
                if (secondString.charAt(i) == firstString.charAt(j)) {
                    countLetters--;
                    i++;
                    count++;
                }
            }
            if (countLetters == 0) {
                if (i > firstString.length()) {
                    secondString = secondString.substring(0, i - firstString.length()) + secondString.substring(i);
                } else {
                    secondString = secondString.substring(i);
                }
                i = -1;
            }
            if (countLetters != 0 && countLetters < firstString.length()) {
                i--;
            }
        }
        System.out.println(secondString);
    }
}
