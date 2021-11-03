package Exams.MidExam.Test04;

import java.util.Arrays;
import java.util.Scanner;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] neighbourhood = Arrays.stream(scan.nextLine().split("@")).mapToInt(Integer::parseInt).toArray();

        int[] helpArray = new int[neighbourhood.length];
        for (int i = 0; i < neighbourhood.length; i++) {
            helpArray[i] = neighbourhood[i];
        }
        String command = scan.nextLine();
        int currentPosition = 0;
        while (!command.equals("Love!")) {
            String[] splitData = command.split(" ");
            int jumpLength = Integer.parseInt(splitData[1]);
            if (currentPosition + jumpLength <= neighbourhood.length - 1) {
                currentPosition += jumpLength;
            } else {
                currentPosition = 0;
            }
            if (neighbourhood[currentPosition] - 2 >= 0) {
                neighbourhood[currentPosition] -= 2;
            }
            if (neighbourhood[currentPosition] == 0 && helpArray[currentPosition] == 0) {
                System.out.printf("Place %d already had Valentine's day.%n", currentPosition);
            }
            if (neighbourhood[currentPosition] == 0 && helpArray[currentPosition] != 0) {
                System.out.printf("Place %d has Valentine's day.%n", currentPosition);
                helpArray[currentPosition] = 0;
            }

            command = scan.nextLine();
        }
        System.out.printf("Cupid's last position was %d.%n", currentPosition);
        int countHouse = 0;
        for (int i = 0; i < neighbourhood.length; i++) {
            if (neighbourhood[i] == 0) {
                countHouse++;
            }
        }
        if (countHouse == neighbourhood.length) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", neighbourhood.length - countHouse);
        }
    }
}
