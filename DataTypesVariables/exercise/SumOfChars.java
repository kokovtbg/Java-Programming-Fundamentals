package DataTypesVariables.exercise;

import java.util.Scanner;

public class SumOfChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine()); // Брой на символите

        // За всеки символ -> Прочитаме -> Сумираме Int стойността
        int sum = 0; // Сума от ASCII кодовете
        for (int i = 1; i <= n; i++) {
            char character = scan.nextLine().charAt(0);
            sum += (int) character;
        }
        System.out.printf("The sum equals: %d", sum);
    }
}
