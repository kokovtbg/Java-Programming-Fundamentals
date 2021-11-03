package Exams.FinalExam.Test04;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String password = scan.nextLine();
        String command = scan.nextLine();
        while (!command.equals("Done")) {
            String[] splitData = command.split(" ");
            String commandName = splitData[0];
            if (commandName.equals("TakeOdd")) {
                StringBuilder passwordNew = new StringBuilder();
                for (int i = 0; i < password.length(); i++) {
                    if (i % 2 != 0) {
                        passwordNew.append(password.charAt(i));
                    }
                }
                password = passwordNew.toString();
                System.out.println(password);
            }
            if (commandName.equals("Cut")) {
                int index = Integer.parseInt(splitData[1]);
                int length = Integer.parseInt(splitData[2]);
                password = password.substring(0, index) + password.substring(index + length);
                System.out.println(password);
            }
            if (commandName.equals("Substitute")) {
                String substring = splitData[1];
                String substitute = splitData[2];
                if (password.contains(substring)) {
                    password = password.replaceAll(substring, substitute);
                    System.out.println(password);
                } else {
                    System.out.printf("Nothing to replace!%n");
                }
            }

            command = scan.nextLine();
        }
        System.out.printf("Your password is: %s", password);
    }
}
