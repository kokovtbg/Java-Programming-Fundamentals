package Exams.MidExam.Test10July2021;

import java.util.Scanner;

public class Problem01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int biscuitsDayWorker = Integer.parseInt(scan.nextLine());
        int workers = Integer.parseInt(scan.nextLine());
        int otherFactoryProduction = Integer.parseInt(scan.nextLine());

        int production = 0;
        for (int i = 1; i <= 30; i++) {
            if (i % 3 == 0) {
                production += biscuitsDayWorker * workers * 0.75;
            } else {
                production += biscuitsDayWorker * workers;
            }
        }
        System.out.printf("You have produced %d biscuits for the past month.%n", production);
        if (production > otherFactoryProduction) {
            System.out.printf("You produce %.2f percent more biscuits.", (production - otherFactoryProduction) * 1.0 * 100 / otherFactoryProduction);
        } else {
            System.out.printf("You produce %.2f percent less biscuits.", (otherFactoryProduction - production) * 1.0 * 100 / otherFactoryProduction);
        }
    }
}
