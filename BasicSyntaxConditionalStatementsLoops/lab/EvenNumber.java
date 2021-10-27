package BasicSyntaxConditionalStatementsLoops.lab;

import java.util.Scanner;

public class EvenNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());
        while (number % 2 !=0) {
            System.out.printf("Please write an even number.%n");
            number = Integer.parseInt(scan.nextLine());
        }
        System.out.printf("The number is: %d%n", Math.abs(number));
    }
}
