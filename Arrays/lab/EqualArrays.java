package Arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr1 = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int[] arr2 = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        int sum = 0;
        int count = 0;
        boolean areEqual = false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == arr2[i]) {
                sum += arr1[i];
                areEqual = true;
            } else {
                count = i;
                areEqual = false;
                break;
            }
        }
        if (areEqual) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        } else {
            System.out.printf("Arrays are not identical. Found difference at %d index.", count);
        }
    }
}
