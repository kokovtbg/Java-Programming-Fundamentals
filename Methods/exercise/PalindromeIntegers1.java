package Methods.exercise;

import java.util.Scanner;

public class PalindromeIntegers1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        while (!command.equals("END")) {
            System.out.println(isPalindrome(command));

            command = scan.nextLine();
        }
    }

    //Метод за проверка дали е палиндром
    private static boolean isPalindrome(String number) {
        //Проверка дали числото е същото като на обратно
        String reverseNumber = getReversedNumber(number);
        return number.equals(reverseNumber);
    }

    private static String getReversedNumber(String number) {
        //Обхождаме числото от последния към първия елемент
        String reversed = "";
        for (int i = number.length() - 1; i >= 0; i--) {
            char currentElement = number.charAt(i);
            reversed += currentElement;
        }
        return reversed;
    }
}
