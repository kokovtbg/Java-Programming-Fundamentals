package Arrays.exercise;

import java.util.Scanner;

public class Train1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int people = Integer.parseInt(scan.nextLine());
            sum += people;
            System.out.printf("%d ", people);
        }
        System.out.printf("%n%d", sum);
    }
}
