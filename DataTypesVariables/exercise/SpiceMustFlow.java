package DataTypesVariables.exercise;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int yield = Integer.parseInt(scan.nextLine());

        //stop: yield < 100
        int count = 0;
        int sumYield = 0;
        while (yield >= 100) {
            count++;
            sumYield += yield;
            sumYield -= 26;
            yield -= 10;
        }
        sumYield -= 26;
        if (sumYield > 0 && count > 0) {
            System.out.printf("%d%n%d", count, sumYield);
        } else {
            System.out.printf("0%n0");
        }
    }
}
