package Arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        // 0 1 2 3 4 -> 0+1 1+2 2+3 3+4

        while (numbers.length > 1) {
            int[] condensed = new int[numbers.length - 1];
            for (int i = 0; i < numbers.length - 1; i++) {
                condensed[i] = numbers[i] + numbers[i + 1];
            }
            numbers = condensed;
        }
        System.out.println(numbers[0]);
    }
}
