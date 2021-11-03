package Exams.MidExam.Test04;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> vegetables = Arrays.stream(scan.nextLine().split("!")).collect(Collectors.toList());

        String command = scan.nextLine();
        while (!command.equals("Go Shopping!")) {
            String[] splitData = command.split(" ");
            if (splitData[0].equals("Urgent")) {
                boolean isInList = false;
                for (int i = 0; i < vegetables.size(); i++) {
                    if (vegetables.get(i).equals(splitData[1])) {
                        isInList = true;
                        break;
                    }
                }
                if (!isInList) {
                    vegetables.add(0, splitData[1]);
                }
            }
            if (splitData[0].equals("Unnecessary")) {
                for (int i = 0; i < vegetables.size(); i++) {
                    if (vegetables.get(i).equals(splitData[1])) {
                        vegetables.remove(i);
                        break;
                    }
                }
            }
            if (splitData[0].equals("Correct")) {
                String oldItem = splitData[1];
                String newItem = splitData[2];
                for (int i = 0; i < vegetables.size(); i++) {
                    if (vegetables.get(i).equals(oldItem)) {
                        vegetables.set(i, newItem);
                    }
                }
            }
            if (splitData[0].equals("Rearrange")) {
                for (int i = 0; i < vegetables.size() - 1; i++) {
                    if (vegetables.get(i).equals(splitData[1])) {
                        vegetables.add(splitData[1]);
                        vegetables.remove(i);
                        break;
                    }
                }
            }

            command = scan.nextLine();
        }
        for (int i = 0; i < vegetables.size(); i++) {
            if (i < vegetables.size() - 1) {
                System.out.printf("%s, ", vegetables.get(i));
            } else {
                System.out.printf("%s", vegetables.get(i));
            }
        }
    }
}
