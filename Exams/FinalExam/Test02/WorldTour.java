package Exams.FinalExam.Test02;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String tour = scan.nextLine();
        String command = scan.nextLine();
        while (!command.equals("Travel")) {
            String[] splitData = command.split(":");
            String commandName = splitData[0];
            if (commandName.equals("Add Stop")) {
                int index = Integer.parseInt(splitData[1]);
                String string = splitData[2];
                if (index >= 0 && index <= tour.length() - 1) {
                    tour = tour.substring(0, index) + string + tour.substring(index);
                }
            }
            if (commandName.equals("Remove Stop")) {
                int startIndex = Integer.parseInt(splitData[1]);
                int endIndex = Integer.parseInt(splitData[2]);
                if (startIndex >= 0 && startIndex <= tour.length() - 1 && endIndex >= 0 && endIndex <= tour.length() - 1) {
                    tour = tour.substring(0, startIndex) + tour.substring(endIndex + 1);
                }
            }
            if (commandName.equals("Switch")) {
                String oldString = splitData[1];
                String newString = splitData[2];
                tour = tour.replaceAll(oldString, newString);
            }
            System.out.println(tour);

            command = scan.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s", tour);
    }
}
