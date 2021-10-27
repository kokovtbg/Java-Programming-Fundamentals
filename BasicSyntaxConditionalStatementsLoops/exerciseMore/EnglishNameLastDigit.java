package BasicSyntaxConditionalStatementsLoops.exerciseMore;

import java.util.Scanner;

public class EnglishNameLastDigit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());

        String numberString = "" + number;
        if (numberString.charAt(numberString.length() - 1) == '1') {
            System.out.println("one");
        }
        if (numberString.charAt(numberString.length() - 1) == '2') {
            System.out.println("two");
        }
        if (numberString.charAt(numberString.length() - 1) == '3') {
            System.out.println("three");
        }
        if (numberString.charAt(numberString.length() - 1) == '4') {
            System.out.println("four");
        }
        if (numberString.charAt(numberString.length() - 1) == '5') {
            System.out.println("five");
        }
        if (numberString.charAt(numberString.length() - 1) == '6') {
            System.out.println("six");
        }
        if (numberString.charAt(numberString.length() - 1) == '7') {
            System.out.println("seven");
        }
        if (numberString.charAt(numberString.length() - 1) == '8') {
            System.out.println("eight");
        }
        if (numberString.charAt(numberString.length() - 1) == '9') {
            System.out.println("nine");
        }
        if (numberString.charAt(numberString.length() - 1) == '0') {
            System.out.println("zero");
        }
    }
}
