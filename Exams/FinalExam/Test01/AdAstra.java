package Exams.FinalExam.Test01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        String regex = "#(?<product1>[A-Za-z ]+)#(?<date1>\\d{2}\\/\\d{2}\\/\\d{2})#(?<calories1>\\d+)#|\\|(?<product2>[A-Za-z ]+)\\|(?<date2>\\d{2}\\/\\d{2}\\/\\d{2})\\|(?<calories2>\\d+)\\|";
        Pattern pattern = Pattern.compile(regex);
        int sumCalories = 0;
        Matcher matcher = pattern.matcher(text);
        List<String> products = new ArrayList<>();
        while (matcher.find()) {
            if (matcher.group().charAt(0) == '#') {
                products.add("Item: " + matcher.group("product1") + ", Best before: " + matcher.group("date1") + ", Nutrition: " + matcher.group("calories1"));
                sumCalories += Integer.parseInt(matcher.group("calories1"));
            }
            if (matcher.group().charAt(0) == '|') {
                products.add("Item: " + matcher.group("product2") + ", Best before: " + matcher.group("date2") + ", Nutrition: " + matcher.group("calories2"));
                sumCalories += Integer.parseInt(matcher.group("calories2"));
            }
        }
        int days = sumCalories / 2000;
        System.out.printf("You have food to last you for: %d days!%n", days);
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%s%n", products.get(i));
        }
    }
}
