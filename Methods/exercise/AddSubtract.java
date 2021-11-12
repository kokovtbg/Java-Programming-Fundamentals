package Methods.exercise;

import java.util.Scanner;

public class AddSubtract {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstInt = Integer.parseInt(scan.nextLine());
        int secondInt = Integer.parseInt(scan.nextLine());
        int thirdInt = Integer.parseInt(scan.nextLine());

        System.out.printf("%d", firstInt + secondInt - thirdInt);
    }
}
