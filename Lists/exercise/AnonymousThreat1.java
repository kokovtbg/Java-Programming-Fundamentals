package Lists.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> names = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());

        String command = scan.nextLine();
        while (!command.equals("3:1")) {
            String[] commandData = command.split("\\s+");
            String commandName = commandData[0]; //merge or divide
            if (commandName.equals("merge")) {
                int startIndex = Integer.parseInt(commandData[1]);
                int endIndex = Integer.parseInt(commandData[2]);
                if (startIndex < 0) {
                    startIndex = 0;
                }
                if (endIndex > names.size() - 1) {
                    endIndex = names.size() - 1;
                }
                //Проверка за индексите
                boolean isStartIndexValid = isValidIndex(startIndex, names.size());
                boolean isEndIndexValid = isValidIndex(endIndex, names.size());
                if (isStartIndexValid && isEndIndexValid) {
                    String resultMerge = "";
                    for (int i = startIndex; i <= endIndex; i++) {
                        resultMerge += names.get(i);
                    }
                    for (int i = startIndex; i <= endIndex; i++) {
                        names.remove(startIndex);
                    }
                    names.add(startIndex, resultMerge);
                }
            } else if (commandName.equals("divide")) {
                int index = Integer.parseInt(commandData[1]);
                int partitions = Integer.parseInt(commandData[2]);
                String antiConcatenate = names.get(index);
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
                    names.add(i, antiConcatenateList.get(i - index));
                }
                names.remove(index + partitions);
            }
            command = scan.nextLine();
        }
        for (int i = 0; i < names.size(); i++) {
            System.out.printf("%s ", names.get(i));
        }
    }
    public static boolean isValidIndex(int index, int size) {
        return index >= 0 && index <= size - 1;
    }
}
