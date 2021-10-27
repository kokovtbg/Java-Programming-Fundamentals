package BasicSyntaxConditionalStatementsLoops.exercise;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lostGames = Integer.parseInt(scan.nextLine());
        double headsetPrice = Double.parseDouble(scan.nextLine());
        double mousePrice = Double.parseDouble(scan.nextLine());
        double keyboardPrice = Double.parseDouble(scan.nextLine());
        double displayPrice = Double.parseDouble(scan.nextLine());

        double rageExpenses = Math.floor(lostGames / 2.0) * headsetPrice + Math.floor(lostGames / 3.0) * mousePrice + Math.floor(lostGames / 6.0) * keyboardPrice + Math.floor(lostGames / 12.0) * displayPrice;
        System.out.printf("Rage expenses: %.2f lv.", rageExpenses);
    }
}
