package Methods.exercise;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String pass = scan.nextLine();

        boolean isValid = true;
        int count = 0;
        if (pass.length() < 6 || pass.length() > 10) {
            System.out.println("Password must be between 6 and 10 characters");
            isValid = false;
        }
        for (int i = 0; i < pass.length(); i++) {
            if (pass.charAt(i) < 48 || (pass.charAt(i) > 57 && pass.charAt(i) < 65) || (pass.charAt(i) > 90 && pass.charAt(i) < 97) || pass.charAt(i) > 122) {
                System.out.println("Password must consist only of letters and digits");
            isValid = false;
            break;
            }
        }
        for (int i = 0; i < pass.length(); i++) {
            if (pass.charAt(i) >= 48 && pass.charAt(i) <= 57) {
                count++;
            }
        }
        if (count < 2) {
            System.out.println("Password must have at least 2 digits");
            isValid = false;
        }
        if (isValid) {
            System.out.println("Password is valid");
        }
    }
}
