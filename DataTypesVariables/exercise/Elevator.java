package DataTypesVariables.exercise;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double nPeople = Double.parseDouble(scan.nextLine());
        double pCapacity = Double.parseDouble(scan.nextLine());

        double count = Math.ceil(nPeople / pCapacity);
        System.out.printf("%.0f", count);
    }
}
