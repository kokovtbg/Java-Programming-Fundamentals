package Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbersArray = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        double rotations = Double.parseDouble(scan.nextLine());

        //51 47 32 61 21 -> 47 32 61 21 51 -> 32 61 21 51 47  //2 rotations  //0->2 1->3 2->4 3->0 4->1
        //2 4 15 31 -> 4 15 31 2 //1 rotations //0->1 1->2 2->3 3->0
        int[] newNumbersArray = new int[numbersArray.length];
        while (rotations > numbersArray.length) {
            rotations /= numbersArray.length;
        }
        if (rotations == numbersArray.length) {
            for (int i = 0; i < numbersArray.length; i++) {
                newNumbersArray[i] = numbersArray[i];
            }
        }
        if (rotations < numbersArray.length) {
            for (int i = 0; i < numbersArray.length; i++) {
                if (i <= numbersArray.length - (int) rotations - 1) {
                    newNumbersArray[i] = numbersArray[(int) (i + rotations)];
                } else {
                    newNumbersArray[i] = numbersArray[(int) (i + Math.floor(numbersArray.length / rotations) - numbersArray.length)];
                }
            }
        }
        for (int i = 0; i < numbersArray.length; i++) {
            System.out.printf("%d ", newNumbersArray[i]);
        }
    }
}
