package TextProcessing.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String word = scan.nextLine();
        List<String> words = new ArrayList<>();
        while (!word.equals("end")) {
            words.add(word);
            word = scan.nextLine();
        }
        List<String> wordsReversed = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            String wordReversed = "";
            for (int j = words.get(i).length() - 1; j >= 0; j--) {
                wordReversed += words.get(i).charAt(j);
            }
            wordsReversed.add(wordReversed);
        }
        for (int i = 0; i < words.size(); i++) {
            System.out.printf("%s = %s%n", words.get(i), wordsReversed.get(i));
        }
    }
}
