package Lists.exerciseMore;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        
        double leftSum = 0;
        double rightSum = 0;
        for (int i = 0; i < numbers.size() / 2; i++) {
            leftSum += numbers.get(i);
            if (numbers.get(i) == 0) {
                leftSum *= 0.8;
            }
        }
        for (int i = numbers.size() - 1; i >= numbers.size() / 2 + 1; i--) {
            rightSum += numbers.get(i);
            if (numbers.get(i) == 0) {
                rightSum *= 0.8;
            }
        }
        if (leftSum < rightSum) {
            System.out.printf("The winner is left with total time: %.1f", leftSum);
        } else if (rightSum < leftSum) {
            System.out.printf("The winner is right with total time: %.1f", rightSum);
        }
    }
}
