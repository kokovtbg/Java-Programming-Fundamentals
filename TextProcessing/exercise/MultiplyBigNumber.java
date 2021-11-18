package TextProcessing.exercise;

import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String bigNumber = scan.nextLine();
        int digit = Integer.parseInt(scan.nextLine());

        String result = "";
        int remainder = 0;
        for (int i = bigNumber.length() - 1; i >= 0; i--) {
            int currentDigit = Integer.parseInt("" + bigNumber.charAt(i));
            if (currentDigit * digit + remainder < 10) {
                currentDigit *= digit;
                currentDigit += remainder;
                remainder = 0;
            } else {
                currentDigit *= digit;
                currentDigit += remainder;
                remainder = currentDigit / 10;
                currentDigit = currentDigit % 10;
            }
            result += currentDigit;
        }
        if (remainder != 0) {
            result += remainder;
        }
        if (digit == 0) {
            result = "0";
        }
        String resultReversed = "";
        for (int i = result.length() - 1; i >= 0; i--) {
            resultReversed += result.charAt(i);
        }
        System.out.println(resultReversed);
    }
}
