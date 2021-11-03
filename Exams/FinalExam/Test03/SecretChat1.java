package Exams.FinalExam.Test03;

import java.util.Scanner;

public class SecretChat1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder concealedMessage = new StringBuilder(scan.nextLine());

        String command = scan.nextLine();
        while (!command.equals("Reveal")) {
            String[] commandParts = command.split(":\\|:");
            String commandName = commandParts[0];
            if (commandName.equals("InsertSpace")) {
                int index = Integer.parseInt(commandParts[1]);
                concealedMessage.insert(index, " ");
                System.out.println(concealedMessage);
            }
            if (commandName.equals("Reverse")) {
                String substring = commandParts[1];
                if (concealedMessage.toString().contains(substring)) {
                    int index = concealedMessage.indexOf(substring);
                    StringBuilder substringToManipulate = new StringBuilder();
                    substringToManipulate.append(concealedMessage.substring(index, index + substring.length()));
                    substringToManipulate.reverse();
                    concealedMessage.delete(index, index + substring.length());
                    concealedMessage.append(substringToManipulate);
                    System.out.println(concealedMessage);
                } else {
                    System.out.println("error");
                }
            }
            if (commandName.equals("ChangeAll")) {
                String substring = commandParts[1];
                String replacement = commandParts[2];
                String messageNew = concealedMessage.toString().replaceAll(substring, replacement);
                concealedMessage = new StringBuilder();
                concealedMessage.append(messageNew);
                System.out.println(concealedMessage);
            }

            command = scan.nextLine();
        }
        System.out.printf("You have a new text message: %s", concealedMessage);
    }
}
