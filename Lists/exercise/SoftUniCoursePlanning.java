package Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> schedule = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());

        String command = scan.nextLine();
        while (!command.equals("course start")) {
            List<String> commandList = Arrays.asList(command.split(":"));
            if (command.contains("Add")) {
                boolean isInList = false;
                for (int i = 0; i < schedule.size(); i++) {
                    if (commandList.get(1).equals(schedule.get(i))) {
                        isInList = true;
                        break;
                    }
                }
                if (!isInList) {
                    schedule.add(commandList.get(1));
                }
            }
            if (command.contains("Insert")) {
                boolean isInList = false;
                int index = Integer.parseInt(commandList.get(2));
                for (int i = 0; i < schedule.size(); i++) {
                    if (commandList.get(1).equals(schedule.get(i))) {
                        isInList = true;
                        break;
                    }
                }
                if (!isInList) {
                    schedule.add(index, commandList.get(1));
                }
            }
            if (command.contains("Remove")) {
                for (int i = 0; i < schedule.size(); i++) {
                    if (commandList.get(1).contains(schedule.get(i))) {
                        schedule.remove(i);
                        i = -1;
                    }
                }
            }
            if (command.contains("Swap")) {
                for (int i = 0; i < schedule.size(); i++) {
                    if (commandList.get(1).equals(schedule.get(i)) || commandList.get(2).equals(schedule.get(i))) {
                        for (int j = i + 1; j < schedule.size(); j++) {
                            if (commandList.get(1).equals(schedule.get(j)) || commandList.get(2).equals(schedule.get(j))) {
                                if (commandList.get(1).equals(schedule.get(i)) && commandList.get(2).equals(schedule.get(j))) {
                                    schedule.set(i, commandList.get(2));
                                    schedule.set(j, commandList.get(1));
                                } else if (commandList.get(2).equals(schedule.get(i)) && commandList.get(1).equals(schedule.get(j))) {
                                    schedule.set(i, commandList.get(1));
                                    schedule.set(j, commandList.get(2));
                                }
                            }
                        }
                    }
                }
            }
            if (command.contains("Exercise")) {
                boolean existExercise = false;
                boolean existLesson = false;
                int index = 0;
                for (int i = 0; i < schedule.size() - 1; i++) {
                    if (commandList.get(1).equals(schedule.get(i))) {
                        existLesson = true;
                        index = i;
                        if (commandList.get(1).contains(schedule.get(i + 1))) {
                            existExercise = true;
                            break;
                        }
                    }
                }
                if (!existLesson) {
                    schedule.add(commandList.get(1));
                    schedule.add(commandList.get(1) + "-Exercise");
                }
                if (existLesson && !existExercise) {
                    schedule.add(index + 1, commandList.get(1) + "-Exercise");
                }
            }

            command = scan.nextLine();
        }
        for (int i = 0; i < schedule.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, schedule.get(i));
        }
    }
}
