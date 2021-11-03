package Exams.MidExam.Test02;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int employeeOneEfficiency = Integer.parseInt(scan.nextLine());
        int employeeTwoEfficiency = Integer.parseInt(scan.nextLine());
        int employeeThreeEfficiency = Integer.parseInt(scan.nextLine());
        int students = Integer.parseInt(scan.nextLine());

        int allEmployeesEfficiency = employeeOneEfficiency + employeeTwoEfficiency + employeeThreeEfficiency;
        int countHours = 0;
        while (students > 0) {
            countHours++;
            if (countHours % 4 != 0) {
                students -= allEmployeesEfficiency;
            }
        }
        System.out.printf("Time needed: %dh.", countHours);
    }
}
