package DataTypesVariables.exercise;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int quantities = Integer.parseInt(scan.nextLine());
                sum += quantities;
            if (sum > 255) {
                System.out.println("Insufficient capacity!");
                sum -= quantities;
            }
        }
        System.out.printf("%d", sum);
    }
}
