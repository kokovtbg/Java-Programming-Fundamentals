package Exams.FinalExam.Test02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        String regex = "=[A-Z][a-zA-Z][a-zA-Z]+=|\\/[A-Z][a-zA-Z][a-zA-Z]+\\/";
        Pattern pattern = Pattern.compile(regex);
        List<String> locations = new ArrayList<>();
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            locations.add(matcher.group().substring(1, matcher.group().length() - 1));
        }
        int points = 0;
        for (int i = 0; i < locations.size(); i++) {
            points += locations.get(i).length();
        }
        System.out.print("Destinations: ");
        System.out.println(String.join(", ", locations));
        System.out.printf("Travel Points: %d", points);
    }
}
