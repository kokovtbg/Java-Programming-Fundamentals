package Exams.MidExam.Test02;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String command = scan.nextLine();
        while (!command.equals("end")) {
            String[] splitData = command.split(" ");
            if (splitData[0].equals("swap")) {
                int index1 = Integer.parseInt(splitData[1]);
                int index2 = Integer.parseInt(splitData[2]);
                int number = numbers[index1];
                numbers[index1] = numbers[index2];
                numbers[index2] = number;
            }
            if (splitData[0].equals("multiply")) {
                int index1 = Integer.parseInt(splitData[1]);
                int index2 = Integer.parseInt(splitData[2]);
                numbers[index1] = numbers[index1] * numbers[index2];
            }
            if (splitData[0].equals("decrease")) {
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] -= 1;
                }
            }

            command = scan.nextLine();
        }
        for (int i = 0; i < numbers.length; i++) {
            if (i < numbers.length - 1) {
                System.out.printf("%d, ", numbers[i]);
            } else {
                System.out.printf("%d", numbers[i]);
            }
        }
    }
}
