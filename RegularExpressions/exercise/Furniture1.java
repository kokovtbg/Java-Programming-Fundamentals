package RegularExpressions.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regex = ">>(?<furniture>[A-Za-z]+)<<(?<price>[0-9]+\\.?[0-9]*)!(?<quantity>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);

        String input = scan.nextLine();
        List<String> furnitureList = new ArrayList<>();
        double totalMoney = 0;
        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String furniture = matcher.group("furniture");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                furnitureList.add(furniture);
                totalMoney += quantity * price;
            }

            input = scan.nextLine();
        }
        System.out.println("Bought furniture:");
        furnitureList.forEach(furniture -> System.out.println(furniture));
        System.out.printf("Total money spend: %.2f", totalMoney);
    }
}
