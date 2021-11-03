package DataTypesVariables.exerciseMore;

import java.util.Scanner;

public class FloatingEquality {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double numberOne = Double.parseDouble(scan.nextLine());
        double numberTwo = Double.parseDouble(scan.nextLine());

        double diff = Math.abs(numberOne - numberTwo);
        if (diff >= 0.000001) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }
}
