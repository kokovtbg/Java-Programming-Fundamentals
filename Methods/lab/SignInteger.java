package Methods.lab;

import java.util.Scanner;

public class SignInteger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        String typeNumber = "";
        if (number > 0) {
            typeNumber = "positive";
        } else if (number == 0) {
            typeNumber = "zero";
        } else {
            typeNumber = "negative";
        }
        System.out.printf("The number %d is %s.", number, typeNumber);
    }
}
