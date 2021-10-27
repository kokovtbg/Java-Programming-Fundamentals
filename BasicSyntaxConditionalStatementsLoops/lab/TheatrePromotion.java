package BasicSyntaxConditionalStatementsLoops.lab;

import java.util.Scanner;

public class TheatrePromotion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String day = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());

        int price = 0;
        if (day.equals("Weekday")) {
            if (age >= 0 && age <= 18) {
                price = 12;
            }
            if (age > 18 && age <= 64) {
                price = 18;
            }
            if (age > 64 && age <= 122) {
                price = 12;
            }
        }
        if (day.equals("Weekend")) {
            if (age >= 0 && age <= 18) {
                price = 15;
            }
            if (age > 18 && age <= 64) {
                price = 20;
            }
            if (age > 64 && age <= 122) {
                price = 15;
            }
        }
        if (day.equals("Holiday")) {
            if (age >= 0 && age <= 18) {
                price = 5;
            }
            if (age > 18 && age <= 64) {
                price = 12;
            }
            if (age > 64 && age <= 122) {
                price = 10;
            }
        }
        if (price == 0) {
            System.out.println("Error!");
        } else {
            System.out.printf("%d$", price);
        }
    }
}
