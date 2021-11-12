package Methods.lab;

import java.util.Scanner;

public class GreaterTwoValues {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String type = scan.nextLine();
        if (type.equals("int")) {
            int firstNum = Integer.parseInt(scan.nextLine());
            int secondNum = Integer.parseInt(scan.nextLine());
            System.out.print(getMax(firstNum, secondNum));
        }
        if (type.equals("char")) {
            char firstChar = scan.nextLine().charAt(0);
            char secondChar = scan.nextLine().charAt(0);
            System.out.print(getMax(firstChar, secondChar));
        }
        if (type.equals("string")) {
            String firstString = scan.nextLine();
            String secondString = scan.nextLine();
            System.out.print(getMax(firstString, secondString));
        }
    }

    static int getMax(int firstNum, int secondNum) {
        if (firstNum > secondNum) {
            return firstNum;
        }
        return secondNum;
    }

    static char getMax(char firstChar, char secondChar) {
        if (firstChar > secondChar) {
            return firstChar;
        }
        return secondChar;
    }

    static String getMax(String firstString, String secondString) {
        if (firstString.compareTo(secondString) >= 0) {
            return firstString;
        }
        return secondString;
    }
}
