package BasicSyntaxConditionalStatementsLoops.exercise;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        double sum = 0;
        while (!command.equals("Start")) {
            double money = Double.parseDouble(command);
            if (money == 0.1 || money == 0.2 || money == 0.5 || money == 1 || money == 2) {
                sum += money;
            } else {
                System.out.printf("Cannot accept %.2f%n", money);
            }
            command = scan.nextLine();
        }
        double price = 0;
        String command2 = scan.nextLine();
        while (!command2.equals("End")) {
            if (command2.equals("Nuts")) {
                price = 2;
            }
            if (command2.equals("Water")) {
                price = 0.7;
            }
            if (command2.equals("Crisps")) {
                price = 1.5;
            }
            if (command2.equals("Soda")) {
                price = 0.8;
            }
            if (command2.equals("Coke")) {
                price = 1;
            }
            if (!command2.equals("Nuts") && !command2.equals("Water") && !command2.equals("Crisps") && !command2.equals("Soda") && !command2.equals("Coke")) {
                System.out.printf("Invalid product%n");
            }
            if (sum < price) {
                System.out.println("Sorry, not enough money");
            }
            if (sum >= price && (command2.equals("Nuts") || command2.equals("Water") || command2.equals("Crisps") || command2.equals("Soda") || command2.equals("Coke"))) {
                sum -= price;
                System.out.printf("Purchased %s%n", command2);
            }

            command2 = scan.nextLine();
        }
        System.out.printf("Change: %.2f", sum);
    }
}
