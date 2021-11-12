package Methods.exercise;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        while (!input.equals("END")) {
            int number = Integer.parseInt(input);
            String firstHalfInput = "";
            String secondHalfInput = "";
            for (int i = 0; i < input.length() / 2; i++) {
                firstHalfInput += input.charAt(i);
            }
            for (int i = input.length() - 1; i > input.length() / 2; i--) {
                secondHalfInput += input.charAt(i);
            }
            if (firstHalfInput.equals(secondHalfInput)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            input = scan.nextLine();
        }
    }
}
