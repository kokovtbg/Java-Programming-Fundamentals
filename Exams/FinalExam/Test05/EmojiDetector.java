package Exams.FinalExam.Test05;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String regex = "(::[A-Z][a-z]{2,}::|\\*\\*[A-Z][a-z]{2,}\\*\\*)";
        String regexNumber = "\\d";
        int bigIntegerSum = 1;
        Pattern patternRegex = Pattern.compile(regex);
        Pattern patternNumber = Pattern.compile(regexNumber);

        Matcher matcherNumber = patternNumber.matcher(input);
        while (matcherNumber.find()) {
            bigIntegerSum *= Integer.parseInt(matcherNumber.group());
        }
        Matcher matcherEmoji = patternRegex.matcher(input);
        int countEmojis = 0;
        List<String> emojis = new ArrayList<>();
        while (matcherEmoji.find()) {
            countEmojis++;
            String clearEmoji = matcherEmoji.group().substring(2, matcherEmoji.group().length() - 2);
            int sum = 0;
            for (int i = 0; i < clearEmoji.length(); i++) {
                sum += clearEmoji.charAt(i);
            }
            if (sum > bigIntegerSum) {
                emojis.add(matcherEmoji.group());
            }
        }
        System.out.printf("Cool threshold: %s%n", bigIntegerSum);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", countEmojis);
        for (int i = 0; i < emojis.size(); i++) {
            System.out.printf("%s%n", emojis.get(i));
        }
    }
}
