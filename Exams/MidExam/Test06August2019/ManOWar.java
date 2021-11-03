package Exams.MidExam.Test06August2019;

import java.util.Arrays;
import java.util.Scanner;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] pirateShip = Arrays.stream(scan.nextLine().split(">")).mapToInt(Integer::parseInt).toArray();
        int[] warship = Arrays.stream(scan.nextLine().split(">")).mapToInt(Integer::parseInt).toArray();
        int maxCapacity = Integer.parseInt(scan.nextLine());

        boolean theyWin = false;
        boolean weWin = false;
        String command = scan.nextLine();
        while (!command.equals("Retire")) {
            String[] splitData = command.split(" ");
            if (splitData[0].equals("Fire")) {
                int index = Integer.parseInt(splitData[1]);
                int damage = Integer.parseInt(splitData[2]);
                if (index >= 0 && index <= warship.length - 1) {
                    warship[index] -= damage;
                    if (warship[index] <= 0) {
                        System.out.printf("You won! The enemy ship has sunken.%n");
                        weWin = true;
                        break;
                    }
                }
            }
            if (splitData[0].equals("Defend")) {
                int startIndex = Integer.parseInt(splitData[1]);
                int endIndex = Integer.parseInt(splitData[2]);
                int damage = Integer.parseInt(splitData[3]);
                if (startIndex >= 0 && startIndex <= pirateShip.length - 1 && endIndex >= 0 && endIndex <= pirateShip.length - 1) {
                    for (int i = startIndex; i <= endIndex; i++) {
                        pirateShip[i] -= damage;
                        if (pirateShip[i] <= 0) {
                            System.out.printf("You lost! The pirate ship has sunken.%n");
                            theyWin = true;
                            break;
                        }
                    }
                }
            }
            if (splitData[0].equals("Repair")) {
                int index = Integer.parseInt(splitData[1]);
                int health = Integer.parseInt(splitData[2]);
                if (index >= 0 && index <= pirateShip.length - 1) {
                    pirateShip[index] += health;
                    if (pirateShip[index] > maxCapacity) {
                        pirateShip[index] = maxCapacity;
                    }
                }
            }
            if (splitData[0].equals("Status")) {
                int count = 0;
                for (int i = 0; i < pirateShip.length; i++) {
                    if (pirateShip[i] < 0.2 * maxCapacity) {
                        count++;
                    }
                }
                System.out.printf("%d sections need repair.%n", count);
            }


            command = scan.nextLine();
        }
        if (!weWin && !theyWin) {
            int sumPirateShip = 0;
            for (int i = 0; i < pirateShip.length; i++) {
                sumPirateShip += pirateShip[i];
            }
            int sumWarShip = 0;
            for (int i = 0; i < warship.length; i++) {
                sumWarShip += warship[i];
            }
            System.out.printf("Pirate ship status: %d%n", sumPirateShip);
            System.out.printf("Warship status: %d", sumWarShip);
        }
    }
}
