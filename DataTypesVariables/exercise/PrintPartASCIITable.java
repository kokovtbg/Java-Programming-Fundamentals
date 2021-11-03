package DataTypesVariables.exercise;

import java.util.Scanner;

public class PrintPartASCIITable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int startASCII = Integer.parseInt(scan.nextLine());
        int lastASCII = Integer.parseInt(scan.nextLine());
        // Обхождаме всички стойности
        // За всяка стойност -> Символът срещу този код

        for (int i = startASCII; i <= lastASCII; i++) {
            System.out.printf("%c ", (char) i);
        }
    }
}
