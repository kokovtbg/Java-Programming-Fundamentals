package Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        int maxNumber = Integer.MIN_VALUE;
        int[] maxNumberArray = new int[numbers.length];
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] > maxNumber) {
                maxNumber = numbers[i];
                maxNumberArray[i] = maxNumber;
            }
        }
        for (int i = 0; i < maxNumberArray.length; i++) {
            if (maxNumberArray[i] == 0 && i != maxNumberArray.length - 1 && maxNumberArray[i] > maxNumberArray[i + 1]) {
                System.out.printf("%d ", maxNumberArray[i]);
            } else if (maxNumberArray[i] == 0 && i == maxNumberArray.length - 1) {
                System.out.print(0 + " ");
            } else if (maxNumberArray[i] != 0) {
                System.out.printf("%d ", maxNumberArray[i]);
            }
        }
    }
}
