package TextProcessing.lab;

import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] array = scan.nextLine().split(" ");

        StringBuilder textToPrint = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j <= array[i].length(); j++) {
                textToPrint.append(array[i]);
            }
        }
        System.out.printf("%s", textToPrint.toString());
    }
}
