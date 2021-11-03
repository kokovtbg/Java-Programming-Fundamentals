package Exams.MidExam.Test03;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scan.nextLine();
        while (!command.equals("End")) {
            String[] splitData = command.split(" ");
            String commandData = splitData[0];
            if (commandData.equals("Shoot")) {
                int index = Integer.parseInt(splitData[1]);
                int power = Integer.parseInt(splitData[2]);
                if (index >= 0 && index <= numbers.size() - 1) {
                    numbers.set(index, numbers.get(index) - power);
                }
                if (index >= 0 && index <= numbers.size() - 1 && numbers.get(index) <= 0) {
                    numbers.remove(index);
                }
            }
            if (commandData.equals("Add")) {
                int index = Integer.parseInt(splitData[1]);
                int value = Integer.parseInt(splitData[2]);
                if (index >= 0 && index <= numbers.size() - 1) {
                    numbers.add(index, value);
                } else {
                    System.out.printf("Invalid placement!%n");
                }
            }
            if (commandData.equals("Strike")) {
                int index = Integer.parseInt(splitData[1]);
                int radius = Integer.parseInt(splitData[2]);
                if (index - radius >= 0 && index + radius <= numbers.size() - 1) {
                    for (int i = index + radius; i >= index; i--) {
                        numbers.remove(i);
                    }
                    for (int i = index - 1; i >= index - radius; i--) {
                        numbers.remove(i);
                    }
                } else {
                    System.out.printf("Strike missed!%n");
                }
            }

            command = scan.nextLine();
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (i < numbers.size() - 1) {
                System.out.printf("%d|", numbers.get(i));
            } else {
                System.out.printf("%d", numbers.get(i));
            }
        }
    }
}
