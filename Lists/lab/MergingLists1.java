package Lists.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> firstList = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> thirdList = new ArrayList<>();
        if (firstList.size() <= secondList.size()) {
            for (int i = 0; i < firstList.size(); i++) {
                thirdList.add(firstList.get(i));
                thirdList.add(secondList.get(i));
            }
            for (int i = firstList.size(); i < secondList.size(); i++) {
                thirdList.add(secondList.get(i));
            }
        } else {
            for (int i = 0; i < secondList.size(); i++) {
                thirdList.add(firstList.get(i));
                thirdList.add(secondList.get(i));
            }
            for (int i = secondList.size(); i < firstList.size(); i++) {
                thirdList.add(firstList.get(i));
            }
        }
        for (int i = 0; i < thirdList.size(); i++) {
            System.out.printf("%d ", thirdList.get(i));
        }
    }
}
