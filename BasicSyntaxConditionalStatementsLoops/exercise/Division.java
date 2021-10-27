package BasicSyntaxConditionalStatementsLoops.exercise;

import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());

        int maxDivision = 0;
        if (number % 2 == 0) {
            maxDivision = 2;
        }
        if (number % 3 == 0) {
            maxDivision = 3;
        }
        if (number % 6 == 0) {
            maxDivision = 6;
        }
        if (number % 7 == 0) {
            maxDivision = 7;
        }
        if (number % 10 == 0) {
            maxDivision = 10;
        }
        if (maxDivision == 0) {
            System.out.println("Not divisible");
        } else {
            System.out.printf("The number is divisible by %d", maxDivision);
        }
    }
}
