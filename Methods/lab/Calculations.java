package Methods.lab;

import java.util.Scanner;

public class Calculations {
    public static void add(int numberOne, int numberTwo) {
        System.out.println(numberOne + numberTwo);
    }

    public static void subtract(int numberOne, int numberTwo) {
        System.out.println(numberOne - numberTwo);
    }

    public static void multiply(int numberOne, int numberTwo) {
        System.out.println(numberOne * numberTwo);
    }

    public static void divide(int numberOne, int numberTwo) {
        System.out.println(numberOne / numberTwo);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        int numberOne = Integer.parseInt(scan.nextLine());
        int numberTwo = Integer.parseInt(scan.nextLine());

        if (command.equals("add")) {
            add(numberOne, numberTwo);
        }
        if (command.equals("subtract")) {
            subtract(numberOne, numberTwo);
        }
        if (command.equals("multiply")) {
            multiply(numberOne,numberTwo);
        }
        if (command.equals("divide")) {
            divide(numberOne, numberTwo);
        }
    }
}
