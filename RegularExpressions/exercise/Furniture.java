package RegularExpressions.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String regex = "(>>)(?<furnitureName>[A-Z]\\w+)(<<)(?<price>\\d+\\.?\\d+)(!)(?<quantity>\\d+)";
        List<String> furniture = new ArrayList<>();
        double sum = 0;
        String input = scan.nextLine();
        while (!input.equals("Purchase")) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            furniture.add(matcher.group("furnitureName"));
            sum += Double.parseDouble(matcher.group("price")) * Integer.parseInt(matcher.group("quantity"));
        }

            input = scan.nextLine();
        }
        System.out.printf("Bought furniture:%n");
        for (int i = 0; i < furniture.size(); i++) {
            System.out.println(furniture.get(i));
        }
        System.out.printf("Total money spend: %.2f", sum);
    }
}
