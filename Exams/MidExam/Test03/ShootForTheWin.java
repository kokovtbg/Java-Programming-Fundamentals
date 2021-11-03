package Exams.MidExam.Test03;

import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] targets = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int countShots = 0;
        String input = scan.nextLine();
        while (!input.equals("End")) {
            int index = Integer.parseInt(input);
            if (index >= 0 && index <= targets.length - 1 && targets[index] != -1) {
                countShots++;
                for (int i = 0; i < targets.length; i++) {
                    if (i != index && targets[i] != -1 && targets[i] > targets[index]) {
                        targets[i] -= targets[index];
                    } else if (i != index && targets[i] != -1 && targets[i] <= targets[index]) {
                        targets[i] += targets[index];
                    }
                }
                targets[index] = -1;
            }

            input = scan.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", countShots);
        for (int i = 0; i < targets.length; i++) {
            System.out.printf("%d ", targets[i]);
        }
    }
}
