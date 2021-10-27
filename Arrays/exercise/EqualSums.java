package Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        int count = 0;
        int index = 0;
        int sum = 0;
        int leftSumInt = 0;
        int rightSumInt = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            leftSumInt = sum - numbers[i];
            for (int j = i; j < numbers.length; j++) {
                rightSumInt += numbers[j];
                if (j == i) {
                    rightSumInt -= numbers[i];
                }
            }
            if (leftSumInt == rightSumInt && i != 0) {
                count++;
                index = i;
            }
            rightSumInt = 0;
        }
        if (numbers.length == 1) {
            System.out.println(0);
        } else if (count == 0) {
            System.out.println("no");
        } else {
            System.out.printf("%d", index);
        }
    }
}
