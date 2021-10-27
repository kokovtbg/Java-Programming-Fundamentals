package BasicSyntaxConditionalStatementsLoops.exercise;

import java.util.Scanner;

public class TriangleOfNumbers2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        //n на брой реда
        for (int row = 1; row <= n; row++) {
            //отпечатвам колкото е броя на реда
            for (int count = 1; count <= row; count++) {
                System.out.printf("%d ", row);
            }
            System.out.println();
        }
    }
}
