package Methods.exercise;

import java.util.Scanner;

public class PasswordValidator1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String password = scan.nextLine();
        //Проверка за дължина - от 6 до 10 включително
        //Ако дължината не е валидна -> print
        boolean isValidLength = isValidLength(password);
        if (!isValidLength) {
            System.out.println("Password must be between 6 and 10 characters");
        }

        //Проверка дали съдържа само букви и цифри
        boolean isValidContent = isValidContent(password);
        if (!isValidContent) {
            System.out.println("Password must consist only of letters and digits");
        }

        //Проверка дали има поне 2 цифри
        boolean isValidCount = isValidCountDigit(password);
        if (!isValidCount) {
            System.out.println("Password must have at least 2 digits");
        }

        //Проверка дали е валидна по всички параметри
        if (isValidLength && isValidContent && isValidCount) {
            System.out.println("Password is valid");
        }
    }

    //Метод за проверка на дължина -> true false
    private static boolean isValidLength(String password) {
        if (password.length() >= 6 && password.length() <= 10) {
            return true;
        } else {
            return false;
        }
    }

    //Метод за проверка на съдържание на букви и цифри -> true false
    private static boolean isValidContent(String password) {
        for (int i = 0; i < password.length(); i++) {
            char currentSymbol = password.charAt(i);
            //Ако символът ми е различен от буква или цифра
            if (!Character.isLetterOrDigit(currentSymbol)) {
                return false;
            }
        }
        //Обходил съм всички символи и никой не ми е различен от буква или цифра
        return true;
    }

    //Метода за проверка на броя на цифрите -> true false
    private static boolean isValidCountDigit (String password) {
        //true -> Броя на цифрите >= 2
        //false -> Броя на цифрите < 2
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            char currentSymbol = password.charAt(i);
            if (Character.isDigit(currentSymbol)) {
                count++;
            }
        }
        return count >= 2;
    }
}
