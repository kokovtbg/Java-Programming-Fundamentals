package BasicSyntaxConditionalStatementsLoops.exercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int people = Integer.parseInt(scan.nextLine());
        String typeGroup = scan.nextLine();
        String dayWeekend = scan.nextLine();

        double price = 0;
        if (typeGroup.equals("Students")) {
            if (dayWeekend.equals("Friday")) {
                price = 8.45;
            }
            if (dayWeekend.equals("Saturday")) {
                price = 9.8;
            }
            if (dayWeekend.equals("Sunday")) {
                price = 10.46;
            }
            if (people >= 30) {
                price *= 0.85;
            }
        }
        if (typeGroup.equals("Business")) {
            if (dayWeekend.equals("Friday")) {
                price = 10.9;
            }
            if (dayWeekend.equals("Saturday")) {
                price = 15.6;
            }
            if (dayWeekend.equals("Sunday")) {
                price = 16;
            }
            if (people >= 100) {
                people -= 10;
            }
        }
        if (typeGroup.equals("Regular")) {
            if (dayWeekend.equals("Friday")) {
                price = 15;
            }
            if (dayWeekend.equals("Saturday")) {
                price = 20;
            }
            if (dayWeekend.equals("Sunday")) {
                price = 22.5;
            }
            if (people >= 10 && people <= 20) {
                price *= 0.95;
            }
        }
        System.out.printf("Total price: %.2f", people * price);
    }
}
