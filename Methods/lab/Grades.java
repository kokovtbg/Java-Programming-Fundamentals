package Methods.lab;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double grade = Double.parseDouble(scan.nextLine());

        String typeGrade = "";
        if (grade >= 2 && grade <= 2.99) {
            typeGrade = "Fail";
        } else if (grade >= 3 && grade <= 3.49) {
            typeGrade = "Poor";
        } else if (grade >= 3.5 && grade <= 4.49) {
            typeGrade = "Good";
        } else if (grade >= 4.5 && grade <= 5.49) {
            typeGrade = "Very good";
        } else if (grade >= 5.5 && grade <= 6) {
            typeGrade = "Excellent";
        }
        System.out.println(typeGrade);
    }
}
