package DataTypesVariables.lab;

import java.util.Scanner;

public class LowerUpper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char character = scan.nextLine().charAt(0);

        if ((int) character >= 97 && (int) character <= 122) {
            System.out.print("lower-case");
        }
        if ((int) character >= 65 && (int) character <= 90) {
            System.out.print("upper-case");
        }
    }
}
