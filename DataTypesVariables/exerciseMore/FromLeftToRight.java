package DataTypesVariables.exerciseMore;

import java.util.Scanner;

public class FromLeftToRight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= n; i++) {
            int firstSum = 0;
            int totalSum = 0;
            String twoNumbers = scan.nextLine();
            for (int j = 0; j <= twoNumbers.length() - 1; j++) {
                if (twoNumbers.charAt(j) == '1') {
                    totalSum += 1;
                }
                if (twoNumbers.charAt(j) == '2') {
                    totalSum += 2;
                }
                if (twoNumbers.charAt(j) == '3') {
                    totalSum += 3;
                }
                if (twoNumbers.charAt(j) == '4') {
                    totalSum += 4;
                }
                if (twoNumbers.charAt(j) == '5') {
                    totalSum += 5;
                }
                if (twoNumbers.charAt(j) == '6') {
                    totalSum += 6;
                }
                if (twoNumbers.charAt(j) == '7') {
                    totalSum += 7;
                }
                if (twoNumbers.charAt(j) == '8') {
                    totalSum += 8;
                }
                if (twoNumbers.charAt(j) == '9') {
                    totalSum += 9;
                }

                if (twoNumbers.charAt(j) == (char) 32) {
                    firstSum = totalSum;

                }

            }
            System.out.printf("%d%n", Math.max(firstSum, totalSum - firstSum));
        }
    }
}
