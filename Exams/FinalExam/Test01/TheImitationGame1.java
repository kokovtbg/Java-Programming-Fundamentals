package Exams.FinalExam.Test01;

import java.util.Scanner;

public class TheImitationGame1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder encryptedMessage = new StringBuilder(scan.nextLine());
        String command = scan.nextLine();
        while (!command.equals("Decode")) {
            String[] splitData = command.split("\\|");
            String commandName = splitData[0];
            if (commandName.equals("Move")) {
                int numberOfLetters = Integer.parseInt(splitData[1]);
                String textToMove = encryptedMessage.substring(0, numberOfLetters);
                encryptedMessage.delete(0, numberOfLetters);
                encryptedMessage.append(textToMove);
            }
            if (commandName.equals("Insert")) {
                int index = Integer.parseInt(splitData[1]);
                String value = splitData[2];
                encryptedMessage.insert(index, value);
            }
            if (commandName.equals("ChangeAll")) {
                String substring = splitData[1];
                String replacement = splitData[2];
                String textToManipulate = encryptedMessage.toString();
                textToManipulate = textToManipulate.replace(substring, replacement);
                encryptedMessage = new StringBuilder();
                encryptedMessage.append(textToManipulate);
            }

            command = scan.nextLine();
        }
        System.out.printf("The decrypted message is: %s", encryptedMessage);
    }
}
