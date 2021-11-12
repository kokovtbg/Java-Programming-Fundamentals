package Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scan.nextLine();
        while (command.equals("END")) {
            String[] commandData = command.split("\\s+");
            String commandName = commandData[0];
            switch (commandName){
                case "Add":
                    int numberToAdd = Integer.parseInt(commandData[1]);
                    numbers.add(numberToAdd);
                    break;
                case "Insert":
                    int numberToInsert = Integer.parseInt(commandData[1]);
                    int insertIndex = Integer.parseInt(commandData[2]);
                    if (isValidIndex(insertIndex, numbers.size())) {
                        numbers.add(insertIndex, numberToInsert);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    int removedIndex = Integer.parseInt(commandData[1]);
                    if (isValidIndex(removedIndex, numbers.size())) {
                        numbers.remove(removedIndex);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    String shiftType = commandData[1];
                    int count = Integer.parseInt(commandData[2]);
                    if (shiftType.equals("left")) {
                        shiftLeft(numbers, count);
                    } else if (shiftType.equals("right")) {
                        shiftRight(numbers, count);
                    }
                    break;
            }


            command = scan.nextLine();
        }
        for (Integer number : numbers) {
            System.out.printf("%d ", number);
        }
    }

    private static void shiftRight(List<Integer> numbers, int count) {
        for (int i = 0; i < count; i++) {
            //Взимаме последния елемент -> слагаме на първо място -> премахваме от първо място
            int lasElement = numbers.get(numbers.size() - 1);
            numbers.add(0, lasElement);
            numbers.remove(numbers.size() - 1);
        }
    }

    private static void shiftLeft(List<Integer> numbers, int count) {
        for (int i = 0; i < count; i++) {
            //Взимаме първия елемент -> слагаме на последно място -> премахваме първия елемент
            int firstNumber = numbers.get(0);
            numbers.add(firstNumber);
            numbers.remove(0);
        }
    }

    private static boolean isValidIndex (int index, int size) {
        return index >= 0 && index <= size - 1;
    }
}
