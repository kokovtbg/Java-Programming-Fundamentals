package BasicSyntaxConditionalStatementsLoops.exerciseMore;

import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double balance = Double.parseDouble(scan.nextLine());

        String game = scan.nextLine();
        double sum = 0;
        while (!game.equals("Game Time")) {
            double price = 0;
            if (game.equals("OutFall 4")) {
                price = 39.99;
            } else if (game.equals("CS: GO")) {
                price = 15.99;
            } else if (game.equals("Zplinter Zell")) {
                price = 19.99;
            } else if (game.equals("Honored 2")) {
                price = 59.99;
            } else if (game.equals("RoverWatch")) {
                price = 29.99;
            } else if (game.equals("RoverWatch Origins Edition")) {
                price = 39.99;
            } else {
                System.out.println("Not Found");
            }
            if (price > balance) {
                System.out.println("Too Expensive");
            } else if (price <= balance && (game.equals("OutFall 4") || game.equals("CS: GO") || game.equals("Zplinter Zell") || game.equals("Honored 2") || game.equals("RoverWatch") || game.equals("RoverWatch Origins Edition"))){
                System.out.printf("Bought %s%n", game);
                balance -= price;
                sum += price;
            }
            if (balance == 0) {
                System.out.println("Out of money!");
                break;
            }

            game = scan.nextLine();
        }
        if (balance > 0) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", sum, balance);
        }
    }
}
