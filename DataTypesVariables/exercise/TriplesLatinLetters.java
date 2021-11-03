package DataTypesVariables.exercise;

import java.util.Scanner;

public class TriplesLatinLetters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 97; i <= n + 96; i++) {
            for (int j = 97; j <= n + 96; j++) {
                for (int k = 97; k <= n + 96; k++) {
                    System.out.printf("%c%c%c%n", i, j, k);
                }
            }
        }
    }
}
