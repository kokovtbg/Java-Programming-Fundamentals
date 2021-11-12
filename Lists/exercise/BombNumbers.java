package Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int[] bomb = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (bomb[0] == numbers.get(i)) {
                count++;
                if (bomb[1] > i) {
                    for (int j = i - 1; j >= 0; j--) {
                        numbers.remove(j);
                    }
                } else {
                    for (int j = i - 1; j >= i - bomb[1]; j--) {
                        numbers.remove(j);
                    }
                }
                if (bomb[1] > i) {
                    i = 0;
                } else {
                    i -= bomb[1];
                }
            }
            if (bomb[0] == numbers.get(i) && count == 1) {
                if (bomb[1] > numbers.size() - 1 - i) {
                    for (int j = numbers.size() - 1; j >= i; j--) {
                        numbers.remove(j);
                    }
                } else {
                    for (int j = i + bomb[1]; j >= i; j--) {
                        numbers.remove(j);
                    }
                }
                count = 0;
                i = -1;
            }
        }
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        System.out.println(sum);
    }
}
