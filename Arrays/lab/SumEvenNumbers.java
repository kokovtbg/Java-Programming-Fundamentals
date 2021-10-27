package Arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int sumEvenNumbers = 0;
        int[] arr = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        for (int num : arr) {
            if (num % 2 == 0) {
                sumEvenNumbers += num;
            }
        }
        System.out.printf("%d", sumEvenNumbers);
    }
}
