package Methods.exerciseMore;

import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        if (input.equals("int")) {
            dataTypeOperation(Integer.parseInt(scan.nextLine()));
        }
        if (input.equals("real")) {
            dataTypeOperation(Double.parseDouble(scan.nextLine()));
        }
        if (input.equals("string")) {
            dataTypeOperation(scan.nextLine());
        }
    }

    private static void dataTypeOperation(int numberInt) {
        int result = 1;
        result *= numberInt * 2;
        System.out.printf("%d", result);
    }

    private static void dataTypeOperation(double numberDouble) {
        double result = 1;
        result *= numberDouble * 1.5;
        System.out.printf("%.2f", result);
    }

    private static void dataTypeOperation(String input) {
        input = "$" + input + "$";
        System.out.printf("%s", input);
    }
}
