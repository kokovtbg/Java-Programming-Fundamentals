package Exams.FinalExam.Test02;

import java.util.Scanner;

public class WorldTour1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder initialDestination = new StringBuilder(scan.nextLine());

        String command = scan.nextLine();
        while (!command.equals("Travel")) {
            String[] commandParts = command.split(":");
            String commandName = commandParts[0];
            switch (commandName) {
                case "Add Stop":
                    int insertIndex = Integer.parseInt(commandParts[1]);
                    String textToInsert = commandParts[2];
                    if (indexIsValid(insertIndex, initialDestination.toString())) {
                        initialDestination.insert(insertIndex, textToInsert);
                        System.out.println(initialDestination);
                    }
                    break;
                case "Remove Stop":
                    int removeBeginIndex = Integer.parseInt(commandParts[1]);
                    int removeEndIndex = Integer.parseInt(commandParts[2]);
                    if (indexIsValid(removeBeginIndex, initialDestination.toString())
                            && indexIsValid(removeEndIndex, initialDestination.toString())) {
                        initialDestination.delete(removeBeginIndex, removeEndIndex + 1);
                    }
                    System.out.println(initialDestination);
                    break;
                case "Switch":
                    String oldString = commandParts[1];
                    String newString = commandParts[2];
                    String destinationAsString = initialDestination.toString();
                    destinationAsString = destinationAsString.replaceAll(oldString, newString);
                    initialDestination = new StringBuilder(destinationAsString);
                    System.out.println(initialDestination);
                    break;
            }

            command = scan.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s", initialDestination);
    }
    public static boolean indexIsValid(int index, String text) {
        return index >= 0 && index < text.length();
    }
}
