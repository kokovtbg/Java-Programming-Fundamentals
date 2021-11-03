package Exams.FinalExam.Test04;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String regex = "@#+[A-Z][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9]+[A-Z]@#+";
        Pattern pattern = Pattern.compile(regex);
        String regexNumber = "\\d";
        Pattern patternNumber = Pattern.compile(regexNumber);
        for (int i = 0; i < n; i++) {
            String text = scan.nextLine();
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                Matcher matcherNumber = patternNumber.matcher(text);
                StringBuilder productGroup = new StringBuilder();
                while (matcherNumber.find()) {
                    productGroup.append(matcherNumber.group());
                }
                if (productGroup.length() > 0) {
                    System.out.printf("Product group: %s%n", productGroup.toString());
                } else {
                    System.out.printf("Product group: 00%n");
                }
            } else {
                System.out.printf("Invalid barcode%n");
            }
        }
    }
}
