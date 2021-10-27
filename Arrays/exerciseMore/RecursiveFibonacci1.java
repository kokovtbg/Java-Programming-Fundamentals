package Arrays.exerciseMore;

import java.util.Scanner;

public class RecursiveFibonacci1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int position = Integer.parseInt(scan.nextLine());

        long first = 0;
        long second = 1;
        long third = first + second;

        for (int i = 1; i <= position; i++) {
            first = second;
            second = third;
            third = first + second;
        }
        System.out.println(first);
    }
}
