package DataTypesVariables.exerciseMore;

import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        boolean openBracket = false;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            String string = scan.nextLine();
            if (string.equals("(")) {
                openBracket = true;
                count++;
            }
            if (string.equals(")") && !openBracket) {
                count++;
            }
            if (string.equals(")") && openBracket) {
                openBracket = false;
                count--;
            }
        }
        if (!openBracket && count == 0) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
