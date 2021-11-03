package Exams.MidExam.Test01;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> sequence = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());

        int moves = 0;
        boolean hasWon = false;
        String command = scan.nextLine();
        while (!command.equals("end")) {
            moves++;
            String[] splitData = command.split(" ");
            int index1 = Integer.parseInt(splitData[0]);
            int index2 = Integer.parseInt(splitData[1]);
            if (index1 == index2 || index1 < 0 || index2 < 0 || index1 > sequence.size() - 1 || index2 > sequence.size() - 1) {
                if (!hasWon) {
                    String elementToAdd = "-" + moves + "a";
                    sequence.add(sequence.size() / 2, elementToAdd);
                    sequence.add(sequence.size() / 2, elementToAdd);
                    System.out.printf("Invalid input! Adding additional elements to the board%n");
                }
            } else {
                if (sequence.get(index1).equals(sequence.get(index2))) {
                    System.out.printf("Congrats! You have found matching elements - %s!%n", sequence.get(index1));
                    if (index1 < index2) {
                        sequence.remove(index2);
                        sequence.remove(index1);
                    } else {
                        sequence.remove(index1);
                        sequence.remove(index2);
                    }
                } else {
                    System.out.printf("Try again!%n");
                }
            }
            if (sequence.size() == 0) {
                if (!hasWon) {
                    System.out.printf("You have won in %d turns!%n", moves);
                }
                hasWon = true;
            }

            command = scan.nextLine();
        }
        if (sequence.size() > 0) {
            System.out.printf("Sorry you lose :(%n");
            for (int i = 0; i < sequence.size(); i++) {
                System.out.printf("%s ", sequence.get(i));
            }
        }
    }
}
