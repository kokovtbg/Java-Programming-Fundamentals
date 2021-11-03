package DataTypesVariables.exercise;

import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        double maxSnowballValue = Double.MIN_VALUE;
        double maxSnowballSnow = 0;
        double maxSnowballTime  = 0;
        double maxSnowballQuality = 0;
        for (int i = 1; i <= n; i++) {
            double snowballSnow = Double.parseDouble(scan.nextLine());
            double snowballTime = Double.parseDouble(scan.nextLine());
            double snowballQuality = Double.parseDouble(scan.nextLine());
            double snowballValue = Math.pow(snowballSnow / snowballTime, snowballQuality);
            if (snowballValue > maxSnowballValue) {
                maxSnowballValue = snowballValue;
                maxSnowballSnow = snowballSnow;
                maxSnowballTime = snowballTime;
                maxSnowballQuality = snowballQuality;
            }
        }
        System.out.printf("%.0f : %.0f = %.0f (%.0f)", maxSnowballSnow, maxSnowballTime, maxSnowballValue, maxSnowballQuality);
    }
}
