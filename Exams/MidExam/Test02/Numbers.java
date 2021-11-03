package Exams.MidExam.Test02;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        double averageSum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            averageSum += numbers.get(i);
        }
        averageSum /= numbers.size();
        Collections.sort(numbers);
        Collections.reverse(numbers);
        int count = 0;
        boolean hasNumbers = false;
        for (int i = 0; i < numbers.size(); i++) {
            count++;
            if (numbers.get(i) > averageSum && count <= 5) {
                System.out.printf("%d ", numbers.get(i));
                hasNumbers = true;
            }
        }
        if (!hasNumbers) {
            System.out.println("No");
        }
    }
}
