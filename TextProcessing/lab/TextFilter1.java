package TextProcessing.lab;

import java.util.Scanner;

public class TextFilter1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] forbiddenWords = scan.nextLine().split(", ");
        String text = scan.nextLine();

        for (String forbiddenWord : forbiddenWords) {
            String wordOfStars = convertWordToStars(forbiddenWord);
            text = text.replace(forbiddenWord, wordOfStars);
        }
        System.out.println(text);
    }
    public static String convertWordToStars(String forbiddenWord) {
        String wordOfStars = "";
        for (int i = 0; i < forbiddenWord.length(); i++) {
            wordOfStars += "*";
        }
        return wordOfStars;
    }
}
