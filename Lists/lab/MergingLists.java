package Lists.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers1 = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> numbers2 = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> numbers3 = new ArrayList<>();
        for (int i = 0; i < Math.min(numbers1.size(), numbers2.size()); i++) {
            numbers3.add(numbers1.get(i));
            numbers3.add(numbers2.get(i));
        }
        if (numbers1.size() < numbers2.size()) {
            for (int i = numbers1.size(); i < numbers2.size(); i++) {
                numbers3.add(numbers2.get(i));
            }
        } else if (numbers2.size() < numbers1.size()) {
            for (int i = numbers2.size(); i < numbers1.size(); i++) {
                numbers3.add(numbers1.get(i));
            }
        }
        for (int i = 0; i < numbers3.size(); i++) {
            System.out.printf("%d ", numbers3.get(i));
        }
        
    }
}
