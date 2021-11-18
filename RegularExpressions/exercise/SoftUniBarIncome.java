package RegularExpressions.exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String regex = "%(?<nameClient>[A-Z][a-z]+)%[^|$%.]*(<)(?<product>\\w+)(>)[^|$%.]*(\\|)(?<quantity>\\d+)(\\|)(?<problem>[^|$%.]*)(?<price>\\d+\\.?\\d+)\\$";
        double sum = 0;
        String input = scan.nextLine();
        while (!input.equals("end of shift")) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                StringBuilder priceBuilder = new StringBuilder();
                if (matcher.group("price").contains(".") && matcher.group("problem").length() > 0) {
                    if (matcher.group("problem").charAt(matcher.group("problem").length() - 1) >= '0' && matcher.group("problem").charAt(matcher.group("problem").length() - 1) <= '9') {
                        for (int i = 0; i < matcher.group("price").length(); i++) {
                            priceBuilder.append(matcher.group("price").charAt(i));
                        }
                        for (int i = matcher.group("problem").length() - 1; i >= 0; i--) {
                            if (matcher.group("problem").charAt(i) >= '0' && matcher.group("problem").charAt(i) <= '9') {
                                if (priceBuilder.toString().length() > 0) {
                                    priceBuilder.insert(0, matcher.group("problem").charAt(i));
                                } else {
                                    priceBuilder.append(matcher.group("problem").charAt(i));
                                }
                            }
                            if (i > 0 && !(matcher.group("problem").charAt(i - 1) >= '0' && matcher.group("problem").charAt(i - 1) <= '9')) {
                                break;
                            }
                        }
                    }
                }
                String nameClient = matcher.group("nameClient");
                String product = matcher.group("product");
                int quantity = Integer.parseInt(matcher.group("quantity"));
                double price = 0;
                if (priceBuilder.toString().length() > 0) {
                    price = Double.parseDouble(priceBuilder.toString());
                } else {
                    price = Double.parseDouble(matcher.group("price"));
                }
                System.out.printf("%s: %s - %.2f%n", nameClient, product, quantity * price);
                sum += quantity * price;
            }

            input = scan.nextLine();
        }
        System.out.printf("Total income: %.2f", sum);
    }
}
