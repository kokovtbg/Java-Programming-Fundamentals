package RegularExpressions.lab;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String listOfNames = scan.nextLine();

        String regex = "\\b[A-Z][a-z]+ [A-Z][a-z]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(listOfNames);

        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }

    }
}
