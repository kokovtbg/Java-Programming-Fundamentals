package BasicSyntaxConditionalStatementsLoops.exerciseMore;

import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double number1 = Double.parseDouble(scan.nextLine());
        double number2 = Double.parseDouble(scan.nextLine());
        double number3 = Double.parseDouble(scan.nextLine());

        double maxOneTwo = Math.max(number1, number2);
        if (maxOneTwo == number1) {
            System.out.printf("%.0f%n", Math.max(number1, number3));
            if (Math.max(number1, number3) == number1) {
                System.out.printf("%.0f%n", number3);
            } else {
                System.out.printf("%.0f%n", number1);
            }
            System.out.printf("%.0f", number2);
        } else {
            System.out.printf("%.0f%n", Math.max(number2, number3));
            if (Math.max(number2, number3) == number2) {
                System.out.printf("%.0f%n", number3);
            } else {
                System.out.printf("%.0f%n", number2);
            }
            System.out.printf("%.0f", number1);
        }
    }
}
