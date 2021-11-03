package Exams.MidExam.Test06August2019;

import java.util.*;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> treasureChest = Arrays.stream(scan.nextLine().split("\\|")).collect(Collectors.toList());

        String command = scan.nextLine();
        while (!command.equals("Yohoho!")) {
            String[] splitData = command.split(" ");
            if (splitData[0].equals("Loot")) {
                List<String> elementsToAdd = new ArrayList<>();
                for (int i = 1; i < splitData.length; i++) {
                    elementsToAdd.add(splitData[i]);
                }
                for (int i = 0; i < elementsToAdd.size(); i++) {
                    for (int j = 0; j < treasureChest.size(); j++) {
                        if (elementsToAdd.get(i).equals(treasureChest.get(j))) {
                            elementsToAdd.remove(i);
                            i--;
                            break;
                        }
                    }
                }
                for (int i = 0; i < elementsToAdd.size(); i++) {
                    treasureChest.add(0, elementsToAdd.get(i));
                }
            }
            if (splitData[0].equals("Drop")) {
                int index = Integer.parseInt(splitData[1]);
                if (index >= 0 && index < treasureChest.size()) {
                    treasureChest.add(treasureChest.get(index));
                    treasureChest.remove(index);
                }
            }
            if (splitData[0].equals("Steal")) {
                int count = Integer.parseInt(splitData[1]);
                if (count >= treasureChest.size()) {
                    count = treasureChest.size();
                }
                List<String> removedElements = new ArrayList<>();
                int size = treasureChest.size();
                for (int i = size - 1; i >= size - count; i--) {
                    removedElements.add(treasureChest.get(i));
                    treasureChest.remove(i);
                }
                Collections.reverse(removedElements);
                for (int i = 0; i < removedElements.size(); i++) {
                    if (i < removedElements.size() - 1) {
                        System.out.printf("%s, ", removedElements.get(i));
                    } else {
                        System.out.printf("%s%n", removedElements.get(i));
                    }
                }
            }

            command = scan.nextLine();
        }
        int sum = 0;
        for (int i = 0; i < treasureChest.size(); i++) {
            int length = treasureChest.get(i).length();
            sum += length;
        }
        if (treasureChest.size() > 0) {
            System.out.printf("Average treasure gain: %.2f pirate credits.", sum * 1.0 / treasureChest.size());
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}
