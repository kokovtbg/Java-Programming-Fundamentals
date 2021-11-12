package Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int capacity = Integer.parseInt(scan.nextLine());

        String command = scan.nextLine();
        while (!command.equals("end")) {
            if (command.contains("Add")) {
                String[] commandString = command.split(" ");
                int numberPeople = Integer.parseInt(commandString[1]);
                numbers.add(numberPeople);
            }
            if (command.charAt(0) >= 48 && command.charAt(0) <= 57) {
                int numberPeople = Integer.parseInt(command);
                for (int i = 0; i < numbers.size(); i++) {
                    if (numberPeople + numbers.get(i) <= capacity) {
                        numbers.set(i, numbers.get(i) + numberPeople);
                        break;
                    }
                }
            }

            command = scan.nextLine();
        }
        for (int i = 0; i < numbers.size(); i++) {
            System.out.printf("%d ", numbers.get(i));
        }
    }
}
