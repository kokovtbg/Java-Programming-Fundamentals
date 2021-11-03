package Exams.FinalExam.Test03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String regexWordPairs = "@[a-zA-Z][a-zA-z][a-zA-Z]+@@[a-zA-Z][a-zA-z][a-zA-Z]+@|#[a-zA-Z][a-zA-z][a-zA-Z]+##[a-zA-Z][a-zA-z][a-zA-Z]+#";
        Pattern patternWordPairs = Pattern.compile(regexWordPairs);
        Matcher matcherWordPairs = patternWordPairs.matcher(input);
        List<String> wordPairs = new ArrayList<>();
        while (matcherWordPairs.find()) {
            wordPairs.add(matcherWordPairs.group());
        }
        List<String> mirrorWords = new ArrayList<>();
        for (int i = 0; i < wordPairs.size(); i++) {
            for (int j = 0; j < wordPairs.get(i).length() - 1; j++) {
                if (wordPairs.get(i).charAt(j) == '@' && wordPairs.get(i).charAt(j + 1) == '@') {
                    String firstWord = wordPairs.get(i).substring(1, j);
                    String secondWord = wordPairs.get(i).substring(j + 2, wordPairs.get(i).length() - 1);
                    String secondWordReversed = "";
                    for (int k = secondWord.length() - 1; k >= 0; k--) {
                        secondWordReversed += secondWord.charAt(k);
                    }
                    if (firstWord.equals(secondWordReversed)) {
                        mirrorWords.add(firstWord + " <=> " + secondWord);
                    }
                }
                if (wordPairs.get(i).charAt(j) == '#' && wordPairs.get(i).charAt(j + 1) == '#') {
                    String firstWord = wordPairs.get(i).substring(1, j);
                    String secondWord = wordPairs.get(i).substring(j + 2, wordPairs.get(i).length() - 1);
                    String secondWordReversed = "";
                    for (int k = secondWord.length() - 1; k >= 0; k--) {
                        secondWordReversed += secondWord.charAt(k);
                    }
                    if (firstWord.equals(secondWordReversed)) {
                        mirrorWords.add(firstWord + " <=> " + secondWord);
                    }
                }
            }
        }
        if (wordPairs.size() > 0) {
            System.out.printf("%d word pairs found!%n", wordPairs.size());
        } else {
            System.out.printf("No word pairs found!%n");
        }
        if (mirrorWords.size() > 0) {
            System.out.printf("The mirror words are:%n");
            System.out.println(String.join(", ", mirrorWords));

        } else {
            System.out.printf("No mirror words!%n");
        }
    }
}
