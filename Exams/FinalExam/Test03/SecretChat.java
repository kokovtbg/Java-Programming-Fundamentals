package Exams.FinalExam.Test03;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String concealedMessage = scan.nextLine();
        String command = scan.nextLine();
        while (!command.equals("Reveal")) {
            String[] splitData = command.split(":\\|:");
            String commandName = splitData[0];
            if (commandName.equals("InsertSpace")) {
                int index = Integer.parseInt(splitData[1]);
                concealedMessage = concealedMessage.substring(0, index) + " " + concealedMessage.substring(index);
                System.out.println(concealedMessage);
            }
            if (commandName.equals("Reverse")) {
                String substring = splitData[1];
                if (concealedMessage.contains(substring)) {
                    int index = concealedMessage.indexOf(substring);
                    StringBuilder messageBuilder = new StringBuilder();
                    messageBuilder.append(concealedMessage, 0, index);
                    messageBuilder.append(concealedMessage.substring(index + substring.length()));
                    StringBuilder reversedSubstring = new StringBuilder();
                    for (int i = substring.length() - 1; i >= 0; i--) {
                        reversedSubstring.append(substring.charAt(i));
                    }
                    concealedMessage = messageBuilder.toString() + reversedSubstring;
                    System.out.println(concealedMessage);

                } else {
                    System.out.println("error");
                }
            }
            if (commandName.equals("ChangeAll")) {
                String substring = splitData[1];
                String replacement = splitData[2];
                concealedMessage = concealedMessage.replaceAll(substring, replacement);
                System.out.println(concealedMessage);
            }

            command = scan.nextLine();
        }
        System.out.printf("You have a new text message: %s", concealedMessage);
    }
}
