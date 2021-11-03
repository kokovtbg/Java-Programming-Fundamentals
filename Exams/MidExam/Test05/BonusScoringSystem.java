package Exams.MidExam.Test05;

import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countStudents = Integer.parseInt(scan.nextLine());
        int countLectures = Integer.parseInt(scan.nextLine());
        int additionalBonus = Integer.parseInt(scan.nextLine());

        double maxBonus = Double.MIN_VALUE;
        int maxAttendedLectures = 0;
        for (int i = 1; i <= countStudents; i++) {
            int studentAttendances = Integer.parseInt(scan.nextLine());
            double bonus = Math.ceil(studentAttendances * 1.0 / countLectures * (5 + additionalBonus));
            if (bonus > maxBonus) {
                maxBonus = bonus;
                maxAttendedLectures = studentAttendances;
            }
        }
        System.out.printf("Max Bonus: %.0f.%nThe student has attended %d lectures.", maxBonus, maxAttendedLectures);
    }
}
