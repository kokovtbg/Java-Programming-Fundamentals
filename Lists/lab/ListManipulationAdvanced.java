package Lists.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scan.nextLine();
        while (!command.equals("end")) {
            if (command.contains("Contains")) {
                String[] commandString = command.split(" ");
                int numberToContain = Integer.parseInt(commandString[1]);
                boolean contains = false;
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) == numberToContain) {
                        contains = true;
                        break;
                    }
                }
                if (contains) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No such number");
                }
            }
            if (command.equals("Print even")) {
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) % 2 == 0) {
                        System.out.printf("%d ", numbers.get(i));
                    }
                }
                System.out.println();
            }
            if (command.equals("Print odd")) {
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) % 2 != 0) {
                        System.out.printf("%d ", numbers.get(i));
                    }
                }
                System.out.println();
            }
            if (command.equals("Get sum")) {
                int sum = 0;
                for (int i = 0; i < numbers.size(); i++) {
                    sum += numbers.get(i);
                }
                System.out.printf("%d%n", sum);
            }
            if (command.contains("Filter")) {
                String[] commandString = command.split(" ");
                int commandNumber = Integer.parseInt(commandString[2]);
                if (commandString[1].equals(">")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) > commandNumber) {
                            System.out.printf("%d ", numbers.get(i));
                        }
                    }
                    System.out.println();
                }
                if (commandString[1].equals(">=")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) >= commandNumber) {
                            System.out.printf("%d ", numbers.get(i));
                        }
                    }
                    System.out.println();
                }
                if (commandString[1].equals("<")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) < commandNumber) {
                            System.out.printf("%d ", numbers.get(i));
                        }
                    }
                    System.out.println();
                }
                if (commandString[1].equals("<=")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) <= commandNumber) {
                            System.out.printf("%d ", numbers.get(i));
                        }
                    }
                    System.out.println();
                }
            }

            command = scan.nextLine();
        }
    }
}
