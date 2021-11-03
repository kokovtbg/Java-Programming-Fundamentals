package DataTypesVariables.lab;

import java.util.Scanner;

public class ConcatNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String nameOne = scan.nextLine();
        String nameTwo = scan.nextLine();
        String delimiter = scan.nextLine();

        String concatNames = String.format("%s%s%s", nameOne, delimiter, nameTwo);
        System.out.println(concatNames);
    }
}
