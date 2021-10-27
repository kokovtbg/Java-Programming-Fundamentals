package Arrays.lab;

import java.util.Scanner;

public class DayWeek {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] days = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };
        int dayNumber = Integer.parseInt(scan.nextLine());
        if (dayNumber >= 1 && dayNumber <= 7) {
            System.out.println(days[dayNumber - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
