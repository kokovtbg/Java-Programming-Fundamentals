package Methods.exerciseMore;

import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        long[] numbersTribonacci = new long[num];
        numbersTribonacci[0] = 1;
        numbersTribonacci[1] = 1;
        numbersTribonacci[2] = 2;
        for (int i = 0; i < numbersTribonacci.length; i++) {
            if (i > 2) {
                numbersTribonacci[i] = numbersTribonacci[i - 3] + numbersTribonacci[i - 2] + numbersTribonacci[i - 1];
            }
        }
        for (int i = 0; i < numbersTribonacci.length; i++) {
            System.out.printf("%d ", numbersTribonacci[i]);
        }
    }
}
