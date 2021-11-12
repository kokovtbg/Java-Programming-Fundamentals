package Methods.exercise;

import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                System.out.printf("%d ", n);
            }
            System.out.println();
        }
    }
}
