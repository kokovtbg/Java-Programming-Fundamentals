package Exams.FinalExam.Test14August2021;

import java.util.Scanner;

public class Problem01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();

        String command = scan.nextLine();
        while (!command.equals("Sign up")) {
            String[] commandParts = command.split(" ");
            String commandName = commandParts[0];
            if (commandName.equals("Case")) {
                String lowerUpper = commandParts[1];
                if (lowerUpper.equals("lower")) {
                    username = username.toLowerCase();
                }
                if (lowerUpper.equals("upper")) {
                    username = username.toUpperCase();
                }
                System.out.println(username);
            }
            if (commandName.equals("Reverse")) {
                int startIndex = Integer.parseInt(commandParts[1]);
                int endIndex = Integer.parseInt(commandParts[2]);
                if (startIndex >= 0 && startIndex < username.length() && endIndex >= 0 && endIndex < username.length()) {
                    String textToReverse = "";
                    textToReverse = username.substring(startIndex, endIndex + 1);
                    StringBuilder reversedText = new StringBuilder();
                    for (int i = textToReverse.length() - 1; i >= 0; i--) {
                        reversedText.append(textToReverse.charAt(i));
                    }
                    System.out.println(reversedText);
                }
            }
            if (commandName.equals("Cut")) {
                String substringToManipulate = commandParts[1];
                if (username.contains(substringToManipulate)) {
                    int startIndex = username.indexOf(substringToManipulate);
                    username = username.substring(0, startIndex) + username.substring(startIndex + substringToManipulate.length());
                    System.out.println(username);
                } else {
                    System.out.printf("The word %s doesn't contain %s.%n", username, substringToManipulate);
                }
            }
            if (commandName.equals("Replace")) {
                String charToReplace = commandParts[1];
                username = username.replaceAll(charToReplace, "*");
                System.out.println(username);
            }
            if (commandName.equals("Check")) {
                String charToCheck = commandParts[1];
                if (username.contains(charToCheck)) {
                    System.out.println("Valid");
                } else {
                    System.out.printf("Your username must contain %s.%n", charToCheck);
                }
            }

            command = scan.nextLine();
        }
    }
}
