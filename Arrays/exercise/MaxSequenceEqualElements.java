package Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceEqualElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        int count = 0;
        int[] maxSequence = new int[2];
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                count++;
                if (maxSequence[0] < count) {
                    maxSequence[0] = count;
                    maxSequence[1] = numbers[i];
                }
            }
            if (numbers[i] != numbers[i + 1]) {
                count = 0;
            }
        }
        int number = maxSequence[1];
        int numberCount = maxSequence[0];
        int[] numberArray = new int[numberCount + 1];
        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i] = number;
        }
        for (int i = 0; i < numberArray.length; i++) {
            System.out.printf("%d ", numberArray[i]);
        }
    }
}
