package RegularExpressions.exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regex = "\\b[A-Za-z]+[._-]*[A-Za-z]*@[A-Za-z]+-?[A-Za-z]+\\.[A-Za-z]+\\.?[A-Za-z]*\\b";
        String text = scan.nextLine();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
