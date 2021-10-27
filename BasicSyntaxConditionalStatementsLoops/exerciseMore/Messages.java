package BasicSyntaxConditionalStatementsLoops.exerciseMore;

import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        String message = "";
        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(scan.nextLine());
            if (number == 2) {
                message += "a";
            }
            if (number == 22) {
                message += "b";
            }
            if (number == 222) {
                message += "c";
            }
            if (number == 3) {
                message += "d";
            }
            if (number == 33) {
                message += "e";
            }
            if (number == 333) {
                message += "f";
            }
            if (number == 4) {
                message += "g";
            }
            if (number == 44) {
                message += "h";
            }
            if (number == 444) {
                message += "i";
            }
            if (number == 5) {
                message += "j";
            }
            if (number == 55) {
                message += "k";
            }
            if (number == 555) {
                message += "l";
            }
            if (number == 6) {
                message += "m";
            }
            if (number == 66) {
                message += "n";
            }
            if (number == 666) {
                message += "o";
            }
            if (number == 7) {
                message += "p";
            }
            if (number == 77) {
                message += "q";
            }
            if (number == 777) {
                message += "r";
            }
            if (number == 7777) {
                message += "s";
            }
            if (number == 8) {
                message += "t";
            }
            if (number == 88) {
                message += "u";
            }
            if (number == 888) {
                message += "v";
            }
            if (number == 9) {
                message += "w";
            }
            if (number == 99) {
                message += "x";
            }
            if (number == 999) {
                message += "y";
            }
            if (number == 9999) {
                message += "z";
            }
            if (number == 0) {
                message += " ";
            }
        }
        System.out.printf("%s", message);
    }
}
