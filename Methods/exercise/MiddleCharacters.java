package Methods.exercise;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        if (input.length() % 2 != 0) {
            System.out.printf("%c", input.charAt(input.length() / 2));
        } else {
            System.out.printf("%c%c", input.charAt(input.length() / 2 - 1), input.charAt(input.length() / 2));
        }
    }
}
