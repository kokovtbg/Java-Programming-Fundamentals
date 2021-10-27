package Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        int countDNA = 0;
        int bestCount = 0;
        int bestCountDNA = 0;
        int index = 0;
        int sumNotBest = 0;
        boolean sameIndex = false;
        int[] best = new int[n];
        int maxSum = Integer.MIN_VALUE;
        String command = scan.nextLine();
        while (!command.equals("Clone them!")) {
            int[] numbers = Arrays.stream(command.split("!")).mapToInt(e -> Integer.parseInt(e)).toArray();
            int count = 0;

            countDNA++;
            for (int i = 0; i < n - 1; i++) {
                int sum = 0;
                if (numbers[i] == 1 && numbers[i + 1] == 1) {
                    count++;
                    if (count > 1) {
                        index--;
                    }
                    if (index == i) {
                        sameIndex = true;
                        for (int j = 0; j < n; j++) {
                            sum += numbers[j];
                        }
                        if (sum > maxSum) {
                            maxSum = sum;
                            for (int j = 0; j < n; j++) {
                                best[j] = numbers[j];
                                bestCountDNA = countDNA;
                            }
                        }
                    }
                    if (i < index && bestCount <= count) {
                        index = i;
                        bestCountDNA = countDNA;
                        for (int j = 0; j < n; j++) {
                            best[j] = numbers[j];
                            sum += numbers[j];
                        }
                        sumNotBest = sum;
                    }
                    if (index < i && !sameIndex && bestCount == count) {
                        index = i;
                        bestCountDNA = countDNA;
                        for (int j = 0; j < n; j++) {
                            best[j] = numbers[j];
                            sum += numbers[j];
                        }
                        sumNotBest = sum;
                    }
                }
            }
            bestCount = count;
            command = scan.nextLine();
        }
        if (sameIndex) {
            System.out.printf("Best DNA sample %d with sum: %d.%n", bestCountDNA, maxSum);
        } else {
            System.out.printf("Best DNA sample %d with sum: %d.%n", bestCountDNA, sumNotBest);
        }
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", best[i]);
        }
    }
}
