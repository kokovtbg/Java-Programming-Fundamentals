package DataTypesVariables.exerciseMore;

import java.util.Scanner;

public class DecryptingMessage {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int key = Integer.parseInt(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());

        String message = "";
        for (int i = 1; i <= n; i++) {
            char character = scan.nextLine().charAt(0);
            int a = (int) character + key;
            message += (char) a;
        }
        System.out.printf("%s", message);
    }
}
