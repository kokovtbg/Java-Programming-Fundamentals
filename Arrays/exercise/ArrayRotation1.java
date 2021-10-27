package Arrays.exercise;

import java.util.Scanner;

public class ArrayRotation1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine(); //"51 47 32 61 21"
        String[] numbers = input.split(" "); //"51 47 32 61 21"->["51", "47", "32", "61", "21"]
        int countRotations = Integer.parseInt(scan.nextLine());//Брой ротации

        for (int rotation = 1; rotation <= countRotations; rotation++) {
            //Ротация
            //1. Вземам първи елемент
            String firstElement = numbers[0];
            //2. Местя всички елементи с един наляво(индексът на елементът = индекс - 1)
            for (int index = 0; index < numbers.length - 1; index++) {
                numbers[index] = numbers[index + 1];
            }
            //3. Последният индекс = първия елемент
            numbers[numbers.length - 1] = firstElement;
        }
        System.out.println(String.join(" ", numbers));
    }
}
