package Methods.exercise;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= n; i++) {
            int count = 0;
            int sum = 0;
            int number = i;
            while (number > 0) {
                sum += number % 10;
                if ((number % 10) % 2 != 0) {
                    count++;
                }
                number /= 10;
            }
            if (sum % 8 == 0 && count >= 1) {
                System.out.println(i);
            }
        }
    }
}
