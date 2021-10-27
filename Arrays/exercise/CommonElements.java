package Arrays.exercise;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] elementsOne = scan.nextLine().split(" ");
        String[] elementsTwo = scan.nextLine().split(" ");

        for (int i = 0; i < elementsOne.length; i++) {
            for (int j = 0; j < elementsTwo.length; j++) {
                if (elementsOne[i].equals(elementsTwo[j])) {
                    System.out.print(elementsOne[i] + " ");
                }
            }
        }
    }
}
