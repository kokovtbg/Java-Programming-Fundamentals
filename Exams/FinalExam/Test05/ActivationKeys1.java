package Exams.FinalExam.Test05;

import java.util.Locale;
import java.util.Scanner;

public class ActivationKeys1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder activationKey = new StringBuilder(scan.nextLine());

        String command = scan.nextLine();
        while (!command.equals("Generate")) {
            String[] commandParts = command.split(">>>");
            String commandName = commandParts[0];
            if (commandName.equals("Contains")) {
                String substring = commandParts[1];
                if (activationKey.toString().contains(substring)) {
                    System.out.printf("%s contains %s%n", activationKey, substring);
                } else {
                    System.out.println("Substring not found!");
                }
            }
            if (commandName.equals("Flip")) {
                String upperLower = commandParts[1];
                int startIndex = Integer.parseInt(commandParts[2]);
                int endIndex = Integer.parseInt(commandParts[3]);
                if (upperLower.equals("Upper")) {
                    String activationKeyNew = activationKey.substring(0, startIndex) + activationKey.substring(startIndex, endIndex).toUpperCase() + activationKey.substring(endIndex);
                    activationKey = new StringBuilder();
                    activationKey.append(activationKeyNew);
                } else if (upperLower.equals("Lower")) {
                    String activationKeyNew = activationKey.substring(0, startIndex) + activationKey.substring(startIndex, endIndex).toLowerCase() + activationKey.substring(endIndex);
                    activationKey = new StringBuilder();
                    activationKey.append(activationKeyNew);
                }
                System.out.println(activationKey);
            }
            if (commandName.equals("Slice")) {
                int startIndex = Integer.parseInt(commandParts[1]);
                int endIndex = Integer.parseInt(commandParts[2]);
                activationKey.delete(startIndex, endIndex);
                System.out.println(activationKey);
            }

            command = scan.nextLine();
        }
        System.out.printf("Your activation key is: %s", activationKey);
    }
}
