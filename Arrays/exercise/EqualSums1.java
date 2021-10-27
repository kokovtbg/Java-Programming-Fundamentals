package Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        boolean isFound = false;
        for (int index = 0; index < numbers.length; index++) {
            int currentElement = numbers[index];
            int leftSum = 0; //Сума на елементите вляво
            int rightSum = 0; //Сума на елементите вдясно

            //Лява сума -> 0 до моя индекс
            for (int leftIndex = 0; leftIndex < index; leftIndex++) {
                leftSum += numbers[leftIndex];
            }
            //Дясна сума -> моя индекс + 1 до последния (numbers.length - 1)
            for (int rightIndex = index + 1; rightIndex <= numbers.length - 1; rightIndex++) {
                rightSum += numbers[rightIndex];
            }
            //Проверка дали лява и дясна са равни
            if (leftSum == rightSum) {
                System.out.println(index);
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("no");
        }
    }
}
