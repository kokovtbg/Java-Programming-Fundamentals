package BasicSyntaxConditionalStatementsLoops.exercise;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();

        String truePassword = "";
        for (int i = (username.length() - 1); i >= 0; i--) {
            truePassword += username.charAt(i);
        }
        String password = scan.nextLine();
        int count = 0;
        while (!password.equals(truePassword)) {
            //Грешна парола
            count++;
            //Проверка дали сме достигнали 4 пъти
            if (count == 4) {
                System.out.printf("User %s blocked!", username);
                break;
            }
            System.out.println("Incorrect password. Try again.");

            password = scan.nextLine();
        }
        //entered password == truePassword
        if (password.equals(truePassword)) {
            System.out.printf("User %s logged in.", username);
        }
    }
}
