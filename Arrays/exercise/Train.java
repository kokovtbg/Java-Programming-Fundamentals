package Arrays.exercise;

import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nWagons = Integer.parseInt(scan.nextLine());

        int sum = 0;
        int[] people = new int[nWagons];
        for (int i = 0; i < people.length; i++) {
            people[i] = Integer.parseInt(scan.nextLine());
            sum += people[i];
        }
        for (int person : people) {
            System.out.print(person + " ");
        }
        System.out.printf("%n%d", sum);
    }
}
