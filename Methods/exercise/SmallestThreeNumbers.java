package Methods.exercise;

import java.util.Scanner;

public class SmallestThreeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scan.nextLine());
        int secondNumber = Integer.parseInt(scan.nextLine());
        int thirdNumber = Integer.parseInt(scan.nextLine());

        int smallerOneTwo = Math.min(firstNumber, secondNumber);
        if (smallerOneTwo == firstNumber) {
            System.out.printf("%d", Math.min(firstNumber, thirdNumber));
        } else {
            System.out.printf("%d", Math.min(secondNumber, thirdNumber));
        }
    }
}
