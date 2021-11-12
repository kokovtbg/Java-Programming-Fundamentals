package Lists.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> numbersString = Arrays.asList(scan.nextLine().split("\\|"));

        List<String> numbers = new ArrayList<>();
        for (int i = numbersString.size() - 1; i >= 0; i--) {
            numbers.add(numbersString.get(i).replaceAll("[^0-9,-]", ""));
        }
        for (int i = 0; i < numbers.size(); i++) {
            String numberToSplit = "";
            if (numbers.get(i).length() > 1) {
                for (int j = 0; j < numbers.get(i).length(); j++) {
                    if (j == 0 && numbers.get(i).charAt(j) != '-') {
                        numberToSplit += numbers.get(i).charAt(0) + " " + numbers.get(i).charAt(1);
                    }
                    if (j == 0 && numbers.get(i).charAt(j) == '-') {
                        numberToSplit += numbers.get(i).charAt(j) + "" + numbers.get(i).charAt(j + 1);
                    }
                    if (j <= numbers.get(i).length() - 2 && j != 0 && numbers.get(i).charAt(j) != '-') {
                        numberToSplit +=" " + numbers.get(i).charAt(j + 1);
                    }
                    if (j <= numbers.get(i).length() - 2 && j != 0 && numbers.get(i).charAt(j) == '-') {
                        numberToSplit += numbers.get(i).charAt(j + 1);
                    }
                }
            }
            if (numbers.get(i).length() > 1) {
                numbers.set(i, numberToSplit);
            }
        }
        for (int i = 0; i < numbers.size(); i++) {
            System.out.printf("%s ", numbers.get(i));
        }
    }
}
