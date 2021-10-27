package Arrays.exerciseMore;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        //1, 1, 2, 3, 5, 8, 13, 21, 34, 55...

        long[] numbers = new long[n + 1];
        numbers[0] = 1;
        numbers[1] = 1;

        for (int i = 2; i < n; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2];
        }
        System.out.println(numbers[n - 1]);
    }
}
