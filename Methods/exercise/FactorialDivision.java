package Methods.exercise;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double firstNum = Double.parseDouble(scan.nextLine());
        double secondNum = Double.parseDouble(scan.nextLine());

        double firstFact = 1;
        double secondFact = 1;
        for (int i = 1; i <= firstNum; i++) {
            firstFact *= i;
        }
        for (int i = 1; i <= secondNum; i++) {
            secondFact *= i;
        }
        double result = firstFact / secondFact;
        System.out.printf("%.2f", result);
    }
}
