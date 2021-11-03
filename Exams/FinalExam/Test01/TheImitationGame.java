package Exams.FinalExam.Test01;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String encryptedMessage = scan.nextLine();
        String command = scan.nextLine();
        while (!command.equals("Decode")) {
            String[] splitData = command.split("\\|");
            String commandName = splitData[0];
            if (commandName.equals("Move")) {
                int numberOfLetters = Integer.parseInt(splitData[1]);
                if (numberOfLetters >= 0 && numberOfLetters <= encryptedMessage.length()) {
                    String textToMove = encryptedMessage.substring(0, numberOfLetters);
                    encryptedMessage = encryptedMessage.substring(numberOfLetters) + textToMove;
                }
            }
            if (commandName.equals("Insert")) {
                int index = Integer.parseInt(splitData[1]);
                String value = splitData[2];
                if (index >= 0 && index <= encryptedMessage.length()) {
                    encryptedMessage = encryptedMessage.substring(0, index) + value + encryptedMessage.substring(index);
                }
            }
            if (commandName.equals("ChangeAll")) {
                String substring = splitData[1];
                String replacement = splitData[2];
                encryptedMessage = encryptedMessage.replaceAll(substring, replacement);
            }

            command = scan.nextLine();
        }
        System.out.printf("The decrypted message is: %s", encryptedMessage);
    }
}
