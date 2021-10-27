package BasicSyntaxConditionalStatementsLoops.exerciseMore;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String myString = scan.nextLine();

        String reverseString = "";
        for (int i = (myString.length() - 1); i >= 0; i--) {
            System.out.printf("%c", myString.charAt(i));
        }
    }
}
