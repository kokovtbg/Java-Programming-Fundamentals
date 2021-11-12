package Methods.lab;

import java.util.Scanner;

public class MultiplyEvensOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());

        if (number < 0) {
            number = Math.abs(number);
        }
        int sumEven = 0;
        int sumOdd = 0;
        while (number > 0) {
            if ((number % 10) % 2 == 0) {
                sumEven += number % 10;
            }
            if ((number % 10) % 2 != 0) {
                sumOdd += number % 10;
            }
            number /= 10;
        }
        System.out.println(sumEven * sumOdd);
    }
}
