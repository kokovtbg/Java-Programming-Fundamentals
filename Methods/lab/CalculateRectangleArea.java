package Methods.lab;

import java.util.Scanner;

public class CalculateRectangleArea {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double width = Double.parseDouble(scan.nextLine());
        double height = Double.parseDouble(scan.nextLine());
        double area = calcRectangleArea(width, height);
        System.out.printf("%.0f", area);
    }

    public static double calcRectangleArea(double width, double height) {
        return width * height;
    }
}
