package Lists.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<String> names = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String command = scan.nextLine();
            if (command.contains("is going")) {
                boolean isInList = false;
                String[] commandString = command.split(" ");
                for (int j = 0; j < names.size(); j++) {
                    if (names.get(j).equals(commandString[0])) {
                        System.out.printf("%s is already in the list!%n", commandString[0]);
                        isInList = true;
                        break;
                    }
                }
                if (!isInList) {
                    names.add(commandString[0]);
                }
            }
            if (command.contains("is not going")) {
                boolean isNotInList = true;
                String[] commandString = command.split(" ");
                for (int j = 0; j < names.size(); j++) {
                    if (names.get(j).equals(commandString[0])) {
                        names.remove(j);
                        isNotInList = false;
                        break;
                    }
                }
                if (isNotInList) {
                    System.out.printf("%s is not in the list!%n", commandString[0]);
                }
            }
        }
        for (int i = 0; i < names.size(); i++) {
            System.out.printf("%s%n", names.get(i));
        }
    }
}
