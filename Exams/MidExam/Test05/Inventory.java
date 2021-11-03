package Exams.MidExam.Test05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> items = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());

        String command = scan.nextLine();
        while (!command.equals("Craft!")) {
            String[] data = command.split(" - ");
            if (data[0].equals("Collect")) {
                boolean isInList = false;
                for (int i = 0; i < items.size(); i++) {
                    if (data[1].equals(items.get(i))) {
                        isInList = true;
                        break;
                    }
                }
                if (!isInList) {
                    items.add(data[1]);
                }
            }
            if (data[0].equals("Drop")) {
                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).equals(data[1])) {
                        items.remove(i);
                        break;
                    }
                }
            }
            if (data[0].equals("Combine Items")) {
                String[] combineItems = data[1].split(":");
                String oldItem = combineItems[0];
                String newItem = combineItems[1];
                for (int i = 0; i < items.size(); i++) {
                    if (oldItem.equals(items.get(i))) {
                        if (i < items.size() - 1) {
                            items.add(i + 1, newItem);
                        } else {
                            items.add(newItem);
                        }
                    }
                }
            }
            if (data[0].equals("Renew")) {
                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).equals(data[1])) {
                        items.remove(i);
                        items.add(data[1]);
                        break;
                    }
                }
            }
            command = scan.nextLine();
        }
        for (int i = 0; i < items.size(); i++) {
            if (i < items.size() - 1) {
                System.out.printf("%s, ", items.get(i));
            } else {
                System.out.printf("%s", items.get(i));
            }
        }
    }
}
