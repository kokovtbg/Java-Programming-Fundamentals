package Lists.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> sequence = Arrays.asList(scan.nextLine().split(" "));

        List<String> sequenceNew = new ArrayList<>(sequence);
        String command = scan.nextLine();
        while (!command.equals("3:1")) {
            String[] commandString = command.split(" ");
            if (command.contains("merge")) {
                int startIndex = Integer.parseInt(commandString[1]);
                int endIndex = Integer.parseInt(commandString[2]);
                if (startIndex < 0) {
                    startIndex = 0;
                }
                if (endIndex > sequence.size() - 1) {
                    endIndex = sequence.size() - 1;
                }
                String concatenate = "";
                for (int i = startIndex; i <= endIndex; i++) {
                    concatenate += sequenceNew.get(i);
                }
                for (int i = startIndex; i <= endIndex; i++) {
                    sequenceNew.set(i, "");
                }
                sequenceNew.set(startIndex, concatenate);
            }
            if (command.contains("divide")) {
                int index = Integer.parseInt(commandString[1]);
                int partitions = Integer.parseInt(commandString[2]);
                String antiConcatenate = sequenceNew.get(index);
                int countPartitions = antiConcatenate.length() / partitions;

                int count = 0;
                List<String> antiConcatenateList = new ArrayList<>();
                for (int i = 0; i < antiConcatenate.length(); i+=countPartitions) {
                    count++;
                    if (antiConcatenate.length() % partitions != 0 && count == partitions) {
                        antiConcatenateList.add(antiConcatenate.substring(i, antiConcatenate.length()));
                        break;
                    }
                    antiConcatenateList.add(antiConcatenate.substring(i, i + countPartitions));
                }
                for (int i = index; i < antiConcatenateList.size() + index; i++) {
                    sequenceNew.add(i, antiConcatenateList.get(i - index));
                }
                sequenceNew.remove(index + partitions);
            }

            command = scan.nextLine();
        }
        for (int i = 0; i < sequenceNew.size(); i++) {
            if (!sequenceNew.get(i).equals("")) {
                System.out.printf("%s ", sequenceNew.get(i));
            }
        }
    }
}
