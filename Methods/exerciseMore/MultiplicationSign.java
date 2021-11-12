package Methods.exerciseMore;

import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        int num3 = Integer.parseInt(scan.nextLine());

        if (num1 == 0 || num2 == 0 || num3 == 0) {
            System.out.print("zero");
        } else if ((num1 < 0 && num2 < 0 && num3 < 0)) {
            System.out.print("negative");
        } else if (num1 < 0 || num2 < 0 || num3 < 0) {
            System.out.print("negative");
        }  else {
            System.out.print("positive");
        }
    }
}
