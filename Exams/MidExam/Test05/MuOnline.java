package Exams.MidExam.Test05;

import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int health = 100;
        int bitcoins = 0;
        int countRooms = 0;
        String[] command = scan.nextLine().split("\\|");
        for (int i = 0; i < command.length; i++) {
            countRooms++;
            String[] data = command[i].split(" ");
            if (data[0].equals("potion")) {
                int healthAdded = Integer.parseInt(data[1]);
                if (health + healthAdded > 100) {
                    healthAdded = 100 - health;
                    health = 100;
                } else {
                    health += healthAdded;
                }
                System.out.printf("You healed for %d hp.%n", healthAdded);
                System.out.printf("Current health: %d hp.%n", health);
            } else if (data[0].equals("chest")) {
                bitcoins += Integer.parseInt(data[1]);
                System.out.printf("You found %d bitcoins.%n", Integer.parseInt(data[1]));
            } else {
                String nameMonster = data[0];
                health -= Integer.parseInt(data[1]);
                if (health > 0) {
                    System.out.printf("You slayed %s.%n", nameMonster);
                } else {
                    System.out.printf("You died! Killed by %s.%n", nameMonster);
                    System.out.printf("Best room: %d%n", countRooms);
                    break;
                }
            }
        }
        if (health > 0) {
            System.out.printf("You've made it!%nBitcoins: %d%nHealth: %d", bitcoins, health);
        }
    }
}
