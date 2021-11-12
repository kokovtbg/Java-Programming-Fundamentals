package Lists.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scan.nextLine();
        while (!command.equals("end")) {
            if (command.contains("Add")) {
                String[] commandString = command.split(" ");
                int commandNumber = Integer.parseInt(commandString[1]);
                numbers.add(commandNumber);
            }
            if (command.contains("Remove") && !command.contains("RemoveAt")) {
                String[] commandString = command.split(" ");
                int commandNumber = Integer.parseInt(commandString[1]);
                numbers.remove(Integer.valueOf(commandNumber));
            }
            if (command.contains("RemoveAt")) {
                String[] commandString = command.split(" ");
                int commandNumber = Integer.parseInt(commandString[1]);
                numbers.remove(commandNumber);
            }
            if (command.contains("Insert")) {
                String[] commandString = command.split(" ");
                int commandNumber = Integer.parseInt(commandString[1]);
                int commandIndex = Integer.parseInt(commandString[2]);
                numbers.add(commandIndex, commandNumber);
            }

            command = scan.nextLine();
        }
        for (int i = 0; i < numbers.size(); i++) {
            System.out.printf("%d ", numbers.get(i));
        }
    }
}
