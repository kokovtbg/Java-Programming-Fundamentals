package Exams.MidExam.Test03;

import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int energy = Integer.parseInt(scan.nextLine());

        int countWins = 0;
        boolean isDead = false;
        String command = scan.nextLine();
        while (!command.equals("End of battle")) {
            int distance = Integer.parseInt(command);
            if (energy - distance >= 0) {
                countWins++;
                energy -= distance;
            } else {
                isDead = true;
                break;
            }
            if (countWins % 3 == 0) {
                energy += countWins;
            }

            command = scan.nextLine();

        }
        if (isDead) {
            System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", countWins, energy);
        } else {
            System.out.printf("Won battles: %d. Energy left: %d", countWins, energy);
        }
    }
}
