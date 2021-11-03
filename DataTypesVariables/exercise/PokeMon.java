package DataTypesVariables.exercise;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstPokePowerN = Integer.parseInt(scan.nextLine());
        int distanceM = Integer.parseInt(scan.nextLine());
        int exhaustionFactorY = Integer.parseInt(scan.nextLine());

        int count = 0;
        int pokePowerN = firstPokePowerN;
        while (pokePowerN >= distanceM) {
            count++;
            pokePowerN -= distanceM;
            if (pokePowerN == firstPokePowerN * 0.5 && exhaustionFactorY != 0) {
                pokePowerN /= exhaustionFactorY;
            }
        }
        System.out.printf("%d%n%d", pokePowerN, count);
    }
}
