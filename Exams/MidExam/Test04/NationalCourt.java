package Exams.MidExam.Test04;

import java.util.Scanner;

public class NationalCourt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int employeeOneEfficiency = Integer.parseInt(scan.nextLine());
        int employeeTwoEfficiency = Integer.parseInt(scan.nextLine());
        int employeeThreeEfficiency = Integer.parseInt(scan.nextLine());
        int people = Integer.parseInt(scan.nextLine());

        int allEmployeesEfficiencyPerHour = employeeOneEfficiency + employeeTwoEfficiency + employeeThreeEfficiency;
        int countHours = 0;
        while (people > 0) {
            countHours++;
            if (countHours % 4 != 0) {
                people -= allEmployeesEfficiencyPerHour;
            }
        }
        System.out.printf("Time needed: %dh.", countHours);
    }
}
