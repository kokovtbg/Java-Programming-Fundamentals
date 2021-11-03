package DataTypesVariables.exerciseMore;

import java.util.Scanner;

public class DataTypeFinder1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        while (!input.equals("END")) {
            String type = "";
            if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                type = "boolean";
            } else if (input.length() == 1) {
                char symbol = input.charAt(0);
                if (symbol < 47 || symbol > 57) {
                    type = "character"; //символ
                } else {
                    type = "integer"; //едноцифрено цяло число ->[47;58]
                }
            } else { //String, floating point, integer
                boolean isString = false;
                boolean isFloat = false;
                for (int i = 0; i < input.length(); i++) {
                    char currentSymbol = input.charAt(i);
                    //Проверка дали е символ
                    if (currentSymbol < 45 || currentSymbol > 57) {
                        isString = true;
                    }
                    //integer или floating point
                    if (currentSymbol == 46) {
                        isFloat = true;
                    }
                }
                if (isString) {
                    type = "string";
                } else {
                    //Число -> integer или floating point
                    if (isFloat) {
                        type = "floating point";
                    } else {
                        type = "integer";
                    }
                }
            }
            System.out.printf("%s is %s type%n", input, type);
            input = scan.nextLine();
        }
    }
}
