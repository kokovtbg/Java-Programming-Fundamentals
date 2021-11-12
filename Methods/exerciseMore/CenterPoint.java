package Methods.exerciseMore;

import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x1 = Integer.parseInt(scan.nextLine());
        int y1 = Integer.parseInt(scan.nextLine());
        int x2 = Integer.parseInt(scan.nextLine());
        int y2 = Integer.parseInt(scan.nextLine());

        int sum1 = sumAbs(x1, y1);
        int sum2 = sumAbs(x2, y2);
        if (sum1 <= sum2) {
            System.out.printf("(%d, %d)", x1, y1);
        } else {
            System.out.printf("(%d, %d)", x2, y2);
        }
    }

    private static int sumAbs(int x, int y) {
        return Math.abs(x) + Math.abs(y);
    }
}
