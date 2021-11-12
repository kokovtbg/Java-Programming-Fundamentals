package Methods.lab;

import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner  scan = new Scanner(System.in);
        double numberOne = Double.parseDouble(scan.nextLine());
        char operator = scan.nextLine().charAt(0);
        double numberTwo = Double.parseDouble(scan.nextLine());

        double result = 0;
        if (operator == '+') {
            result = numberOne + numberTwo;
        }
        if (operator == '-') {
            result = numberOne - numberTwo;
        }
        if (operator == '*') {
            result = numberOne * numberTwo;
        }
        if (operator == '/') {
            result = numberOne / numberTwo;
        }
        System.out.printf("%.0f", result);
    }
}
