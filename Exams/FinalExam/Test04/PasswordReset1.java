package Exams.FinalExam.Test04;

import java.util.Scanner;

public class PasswordReset1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder password = new StringBuilder(scan.nextLine());

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
                password = new StringBuilder();
                password.append(passwordNew);
                System.out.println(password);
            }
            if (commandName.equals("Cut")) {
                int index = Integer.parseInt(splitData[1]);
                int length = Integer.parseInt(splitData[2]);
                password.delete(index, index + length);
                System.out.println(password);
            }
            if (commandName.equals("Substitute")) {
                String substring = splitData[1];
                String substitute = splitData[2];
                String passwordNew = password.toString();
                if (passwordNew.contains(substring)) {
                    passwordNew = passwordNew.replaceAll(substring, substitute);
                    password = new StringBuilder();
                    password.append(passwordNew);
                    System.out.println(password);
                } else {
                    System.out.println("Nothing to replace!");
                }
            }

            command = scan.nextLine();
        }
        System.out.printf("Your password is: %s", password);
    }
}
