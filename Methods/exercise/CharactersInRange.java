package Methods.exercise;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char charOne = scan.nextLine().charAt(0);
        char charTwo = scan.nextLine().charAt(0);

        if (charOne > charTwo) {
            char charThree = charOne;
            charOne = charTwo;
            charTwo = charThree;
        }
        for (int i = charOne + 1; i < charTwo; i++) {
            System.out.printf("%c ", i);
        }
    }
}
