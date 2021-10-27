package Arrays.exerciseMore;

import java.util.Scanner;

public class PascalTriangle2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numRows = Integer.parseInt(scan.nextLine());
        int[] prevRow = {0, 1, 0};
        System.out.println("1");
        for (int i = 0; i < numRows - 1; i++) {
            int[] currentRow = new int[prevRow.length + 1];
            for (int j = 1; j < currentRow.length - 1; j++) {
                currentRow[j] = prevRow[j - 1] + prevRow[j];
                System.out.print(currentRow[j] + " ");
            }
            System.out.println();
            prevRow = currentRow;
        }
    }
}
