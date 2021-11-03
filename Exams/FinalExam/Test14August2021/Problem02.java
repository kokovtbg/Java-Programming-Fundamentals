package Exams.FinalExam.Test14August2021;

import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        String regex = "^(\\$|%)(?<tag>[A-Z][a-z][a-z]+)(\\1): \\[(?<group1>[0-9]+)\\]\\|\\[(?<group2>[0-9]+)\\]\\|\\[(?<group3>[0-9]+)\\]\\|$";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                System.out.printf("%s: ", matcher.group("tag"));
                System.out.printf("%c", (char) Integer.parseInt(matcher.group("group1")));
                System.out.printf("%c", (char) Integer.parseInt(matcher.group("group2")));
                System.out.printf("%c%n", (char) Integer.parseInt(matcher.group("group3")));
            } else {
                System.out.printf("Valid message not found!%n");
            }
        }
    }
}
