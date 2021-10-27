package BasicSyntaxConditionalStatementsLoops.exercise;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        int multiply = 1;
        int multiply2 = 0;
        if (n / 10 == 0) {
            for (int i = 1; i <= n; i++) {
                multiply *= i;
            }
            multiply2 += multiply;
        } else {
            int number = n;
            while (number / 10 != 0) {
                int multiply1 = 1;
                for (int i = 1; i <= (number % 10); i++) {
                    multiply1 *= i;
                }
                multiply2 += multiply1;
                number = number / 10;
            }
            for (int i = 1; i <= number; i++) {
                multiply *= i;
            }
            multiply2 += multiply;
        }

        if (multiply2 == n) {
            System.out.print("yes");
        } else {
            System.out.print("no");
        }
    }
}
