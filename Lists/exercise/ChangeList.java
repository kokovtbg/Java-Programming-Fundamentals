package Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scan.nextLine();
        while (!command.equals("end")) {
            if (command.contains("Delete")) {
                String[] commandString = command.split(" ");
                int numberToDelete = Integer.parseInt(commandString[1]);
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) == numberToDelete) {
                        numbers.remove(Integer.valueOf(numberToDelete));
                        i = -1;
                    }
                }
            }
            if (command.contains("Insert")) {
                String[] commandString = command.split(" ");
                int numberToInsert = Integer.parseInt(commandString[1]);
                int index = Integer.parseInt(commandString[2]);
                numbers.add(index, numberToInsert);
            }

            command = scan.nextLine();
        }
        for (int i = 0; i < numbers.size(); i++) {
            System.out.printf("%d ", numbers.get(i));
        }
    }
}
