package Arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class EvenOddSubtraction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int evenSum = 0;
        int oddSum = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                evenSum += num;
            } else {
                oddSum += num;
            }
        }
        System.out.printf("%d", evenSum - oddSum);
    }
}
