package TextProcessing.exercise;

import java.util.Scanner;

public class LettersChangeNumbers1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] passwords = input.split("\\s+");
        double totalSum = 0;
        for (String password : passwords) {
            double currentSum = getCurrentSum(password);
            totalSum += currentSum;
        }
        System.out.printf("%.2f", totalSum);
    }

    private static double getCurrentSum(String password) {
        double sum = 0;
        char firsLetter = password.charAt(0);
        char secondLetter = password.charAt(password.length() - 1);
//        int number = Integer.parseInt(password.replace(firsLetter, ' ').replace(secondLetter, ' ').trim());
        StringBuilder builder = new StringBuilder(password);
        double number = Double.parseDouble(builder.deleteCharAt(0).deleteCharAt(builder.length() - 1).toString());
//        int number = Integer.parseInt(password.substring(1, password.indexOf(secondLetter)));
        if (Character.isUpperCase(firsLetter)) {
            int positionFirstLetter = (int) firsLetter - 64;
            number = number / positionFirstLetter;
        } else {
            int positionFirstLetter = (int) firsLetter - 96;
            number = number * positionFirstLetter;
        }
        if (Character.isUpperCase(secondLetter)) {
            int positionUpperLetter = (int) secondLetter - 64;
            number = number - positionUpperLetter;
        } else {
            int positionLowerLetter = (int) secondLetter - 96;
            number = number + positionLowerLetter;
        }
        sum += number;
        return sum;
    }
}
