package Methods.lab;

import java.util.Scanner;

public class Orders {
    public static void order(String product, int quantity, double price) {
        if (product.equals("coffee")) {
            price = 1.5;
        }
        if (product.equals("water")) {
            price = 1;
        }
        if (product.equals("coke")) {
            price = 1.4;
        }
        if (product.equals("snacks")) {
            price = 2;
        }
        System.out.printf("%.2f", price * quantity);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String product = scan.nextLine();
        int quantity = Integer.parseInt(scan.nextLine());
        double price = 0;
        order(product, quantity, price);
    }
}
