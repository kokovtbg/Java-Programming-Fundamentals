package BasicSyntaxConditionalStatementsLoops.lab;

import java.util.Scanner;

public class MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        int times = Integer.parseInt(scan.nextLine());

        if (times > 10) {
            System.out.printf("%d X %d = %d", number, times, number * times);
        }
        while (times <= 10) {
            System.out.printf("%d X %d = %d%n", number, times, number * times);
            times++;
        }
    }
}
