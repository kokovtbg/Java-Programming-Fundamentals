package DataTypesVariables.lab;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int num = 1; num <= n; num++) {
            int sumDigits = 0;
            int digits = num;
            while (digits > 0) {
                sumDigits += digits % 10;
                digits = digits / 10;
            }
            if (sumDigits == 5 || sumDigits == 7 || sumDigits == 11) {
                System.out.printf("%d -> True%n", num);
            } else {
                System.out.printf("%d -> False%n", num);
            }
        }
    }
}
