package TextProcessing.exercise;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] splitData = scan.nextLine().split("\\s+");

        double[] numbers = new double[splitData.length];
        for (int i = 0; i < splitData.length; i++) {
            double number = Double.parseDouble(splitData[i].replaceAll("[^0-9]", ""));
            if (splitData[i].charAt(0) >= 'A' && splitData[i].charAt(0) <= 'Z') {
                number /= ((int)splitData[i].charAt(0) - 64);
            } else if (splitData[i].charAt(0) >= 'a' && splitData[i].charAt(0) <= 'z') {
                number *= ((int) splitData[i].charAt(0) - 96);
            }
            if (splitData[i].charAt(splitData[i].length() - 1) >= 'A' && splitData[i].charAt(splitData[i].length() - 1) <= 'Z') {
                number -= ((int) splitData[i].charAt(splitData[i].length() - 1) - 64);
            } else if (splitData[i].charAt(splitData[i].length() - 1) >= 'a' && splitData[i].charAt(splitData[i].length() - 1) <= 'z') {
                number += ((int) splitData[i].charAt(splitData[i].length() - 1) - 96);
            }
            numbers[i] = number;
        }
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.printf("%.2f", sum);
    }
}
