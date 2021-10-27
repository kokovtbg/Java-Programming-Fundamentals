package Arrays.exerciseMore;

import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortPrintArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            int sum = 0;
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == 'A' || input.charAt(j) == 'a' || input.charAt(j) == 'E' || input.charAt(j) == 'e' || input.charAt(j) == 'I' || input.charAt(j) == 'i' || input.charAt(j) == 'O' || input.charAt(j) == 'o' || input.charAt(j) == 'U' || input.charAt(j) == 'u') {
                    sum += input.charAt(j) * input.length();
                } else {
                    sum += input.charAt(j) / input.length();
                }
            }
            numbers[i] = sum;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%d%n", numbers[i]);
        }
    }
}
