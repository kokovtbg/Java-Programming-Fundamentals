package Arrays.exercise;

import java.util.Scanner;

public class ZigZagArrays1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        int[] array1 = new int[n];
        int[] array2 = new int[n];
        //Четен ред -> първо число (втори масив) второ число(първи масив)
        //Нечетен ред -> първо число (първи масив) второ число(втори масив)
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            int firstNumber = Integer.parseInt(input.split(" ")[0]);
            int secondNumber = Integer.parseInt(input.split(" ")[1]);
            //Проверка дали е четен редът
            if ((i + 1) % 2 == 0) {
                array1[i] = secondNumber;
                array2[i] = firstNumber;
            } else {
                array1[i] = firstNumber;
                array2[i] = secondNumber;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", array1[i]);
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", array2[i]);
        }
    }
}
