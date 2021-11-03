package Exams.MidExam.Test01;

import java.util.Arrays;
import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int peopleWaiting = Integer.parseInt(scan.nextLine());
        int[] wagons = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < wagons.length; i++) {
            while (wagons[i] < 4 && peopleWaiting > 0) {
                peopleWaiting--;
                wagons[i]++;
            }
        }
        boolean hasEmptySpots = false;
        for (int i = 0; i < wagons.length; i++) {
            if (wagons[i] < 4) {
                hasEmptySpots = true;
            }
        }
        if (peopleWaiting == 0 && hasEmptySpots) {
            System.out.printf("The lift has empty spots!%n");
        }
        if (peopleWaiting > 0) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleWaiting);
        }
        for (int i = 0; i < wagons.length; i++) {
            System.out.printf("%d ", wagons[i]);
        }
    }
}
