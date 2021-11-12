package Methods.lab;

import java.util.Scanner;

public class SignInteger1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printSign(Integer.parseInt(scanner.nextLine()));
    }
    public static void printSign(int number) {
        String typeNumber = "";
        if (number > 0) {
            typeNumber = "positive";
        } else if (number == 0) {
            typeNumber = "zero";
        } else {
            typeNumber = "negative";
        }
        System.out.printf("The number %d is %s", number, typeNumber);
    }
}
