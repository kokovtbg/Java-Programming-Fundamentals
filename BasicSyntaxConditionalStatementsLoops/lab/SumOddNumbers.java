package BasicSyntaxConditionalStatementsLoops.lab;

import java.util.Scanner;

public class SumOddNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            System.out.printf("%d%n", 2 * i - 1);
            sum += 2 * i - 1;
        }
        System.out.printf("Sum: %d", sum);
    }
}
