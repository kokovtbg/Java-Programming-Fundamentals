package DataTypesVariables.exerciseMore;

import java.util.Scanner;

public class DataTypeFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        String dataType = "";
        while (!input.equals("END")) {

            boolean isFloating = false;
            boolean isString = false;
            boolean isInt = false;
            for (int i = 0; i <= input.length() - 1; i++) {
                if (input.equals("true") || input.equals("false") || input.equals("True") || input.equals("False")) {
                    dataType = "boolean";
                } else if ((input.charAt(0) == '-' || (input.charAt(0) >= 48 && input.charAt(0) <= 57)) && (!isFloating && !isString)) {
                    dataType = "integer";
                    isInt = true;
                    if (input.charAt(0) == '-' && input.charAt(1) == '0' && input.charAt(2) != '.') {
                        dataType = "string";
                        isString = true;
                        isFloating = false;
                        isInt = false;
                    }
                    if (input.charAt(0) == '0' && input.charAt(1) != '.' && input.charAt(i) >= 48 && input.charAt(i) <= 57) {
                        dataType = "string";
                        isString = true;
                        isFloating = false;
                        isInt = false;
                    }
                    if ((input.charAt(i) < 48 && input.charAt(i) != '.' && i != 0) || input.charAt(i) > 57) {
                        dataType = "string";
                        isString = true;
                        isFloating = false;
                        isInt = false;
                    }
                    if (i == input.length() - 1 && input.charAt(i) == '.') {
                        dataType = "string";
                        isString = true;
                        isFloating = false;
                        isInt = false;
                    }
                    if (input.charAt(i) == '.' && i != input.length() - 1) {
                        dataType = "floating point";
                        isFloating = true;
                        isString = false;
                        isInt = false;
                    }
                } else if (isFloating && (input.charAt(i) < 48 || input.charAt(i) > 57)) {
                    dataType = "string";
                    isString = true;
                    isFloating= false;
                    isInt = false;
                } else if (input.length() == 1 && (input.charAt(0) < 48 || input.charAt(0) > 57)) {
                    dataType = "character";
                } else if (!isFloating && !isInt) {
                    dataType = "string";
                }
            }
            System.out.printf("%s is %s type%n", input, dataType);

            input = scan.nextLine();
        }
    }
}
