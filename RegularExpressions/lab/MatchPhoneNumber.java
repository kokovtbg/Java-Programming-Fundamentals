package RegularExpressions.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String phone = scan.nextLine();

        String regex = "\\+359([- ])2\\1[\\d]{3}\\1[\\d]{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher phoneMatcher = pattern.matcher(phone);

        List<String> matchedPhones = new ArrayList<>();
        while (phoneMatcher.find()) {
            matchedPhones.add(phoneMatcher.group());
        }
        System.out.println(String.join(", ", matchedPhones));
    }
}
