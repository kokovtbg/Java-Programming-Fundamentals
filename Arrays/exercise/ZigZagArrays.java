package Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        int count = 0;
        int[] firstArray = new int[n];
        int[] secondArray = new int[n];
        for (int i = 0; i < n; i++) {
            count++;
            int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
            if (count % 2 != 0) {
                firstArray[i] = numbers[0];
                secondArray[i] = numbers[1];
            } else {
                firstArray[i] = numbers[1];
                secondArray[i] = numbers[0];
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(firstArray[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(secondArray[i] + " ");
        }
    }
}
