package Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        1 23 29 18 43 21 20
//        Add 5  1 23 29 18 43 21 20 5
//        Remove 5  1 23 29 18 43 20 5
//        Shift left 3(first->last 3 times) 18 43 20 5 1 23 29
//        Shift left 1(first->last 1 time) 43 20 5 1 23 29 18
//        End

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scan.nextLine();

        while (!command.equals("End")) {
            String[] commandString = command.split(" ");
            if (command.contains("Add")) {
                int numberToAdd = Integer.parseInt(commandString[1]);
                numbers.add(numberToAdd);
            }
            if (command.contains("Insert")) {
                int numberToInsert = Integer.parseInt(commandString[1]);
                int index = Integer.parseInt(commandString[2]);
                if (index > numbers.size() - 1 || index < 0) {
                    System.out.println("Invalid index");
                } else {
                    numbers.add(index, numberToInsert);
                }
            }
            if (command.contains("Remove")) {
                int index = Integer.parseInt(commandString[1]);
                if (index > numbers.size() - 1 || index < 0) {
                    System.out.println("Invalid index");
                } else {
                    numbers.remove(index);
                }
            }
            if (command.contains("Shift left")) {
                int count = Integer.parseInt(commandString[2]);
                for (int i = 1; i <= count; i++) {
                    numbers.add(numbers.get(0));
                    numbers.remove(0);
                }
            }
            if (command.contains("Shift right")) {
                int count = Integer.parseInt(commandString[2]);
                for (int i = 1; i <= count; i++) {
                    numbers.add(0, numbers.get(numbers.size() - 1));
                    numbers.remove(numbers.size() - 1);
                }
            }

            command = scan.nextLine();
        }
        for (int i = 0; i < numbers.size(); i++) {
            System.out.printf("%d ", numbers.get(i));
        }
    }
}
