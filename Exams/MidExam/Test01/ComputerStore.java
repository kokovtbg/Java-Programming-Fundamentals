package Exams.MidExam.Test01;

import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double totalPrice = 0;
        String command = scan.nextLine();
        while (!command.equals("special") && !command.equals("regular")) {
            double prices = Double.parseDouble(command);
            if (prices >= 0) {
                totalPrice += prices;
            } else {
                System.out.printf("Invalid price!%n");
            }

            command = scan.nextLine();
        }
        if (totalPrice > 0) {
            System.out.printf("Congratulations you've just bought a new computer!\n" +
                    "Price without taxes: %.2f$\n" +
                    "Taxes: %.2f$\n" +
                    "-----------\n", totalPrice, 0.2 * totalPrice);
        } else {
            System.out.printf("Invalid order!%n");
        }
        if (command.equals("special") && totalPrice > 0) {
            System.out.printf("Total price: %.2f$", totalPrice * 1.2 * 0.9);
        } else if (command.equals("regular") && totalPrice > 0) {
            System.out.printf("Total price: %.2f$", totalPrice * 1.2);
        }
    }
}
