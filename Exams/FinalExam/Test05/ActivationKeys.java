package Exams.FinalExam.Test05;

import java.util.Locale;
import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String key = scan.nextLine();
        String command = scan.nextLine();
        while (!command.equals("Generate")) {
            String[] splitData = command.split(">>>");
            String commandName = splitData[0];
            if (commandName.equals("Contains")) {
                String substring = splitData[1];
                if (key.contains(substring)) {
                    System.out.printf("%s contains %s%n", key, substring);
                } else {
                    System.out.printf("Substring not found!%n");
                }
            }
            if (commandName.equals("Flip")) {
                String lowerUpper = splitData[1];
                int startIndex = Integer.parseInt(splitData[2]);
                int endIndex = Integer.parseInt(splitData[3]);
                if (lowerUpper.equals("Lower")) {
                    key = key.substring(0, startIndex) + key.substring(startIndex, endIndex).toLowerCase() + key.substring(endIndex);
                } else if (lowerUpper.equals("Upper")) {
                    key = key.substring(0, startIndex) + key.substring(startIndex, endIndex).toUpperCase() + key.substring(endIndex);
                }
                System.out.println(key);
            }
            if (commandName.equals("Slice")) {
                int startIndex = Integer.parseInt(splitData[1]);
                int endIndex = Integer.parseInt(splitData[2]);
                key = key.substring(0, startIndex) + key.substring(endIndex);
                System.out.println(key);
            }

            command = scan.nextLine();
        }
        System.out.printf("Your activation key is: %s", key);
    }
}
