package Arrays.exerciseMore;

import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

//          1
//         1 1
//        1 2 1
//       1 3 3 1        numbers[2] = numbers[1] + numbers[2]
//      1 4 6 4 1       numbers[2] = numbers[1] + numbers[2]/numbers[3] = numbers[2] + numbers[3]
//     1 5 10 10 5 1
//        1 6 15 20 15 6 1
//        1 7 21 35 35 21 7 1
//        1 8 28 56 70 56 28 8 1
//        1 9 36 84 126 126 84 36 9 1
//        1 10 45 120 210 252 210 120 45 10 1
//        1 11 55 165 330 462 462 330 165 55 11 1
//        1 12 66 220 495 792 924 792 495 220 66 12 1

        int[] numbers = new int[n];
        numbers[0] = 1;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                if (j == i) {
                    numbers[j] = 1;
                    break;
                }
                if (j > 1) {
                    numbers[j] = numbers[j - 1] + numbers[j];
                }
                if (numbers[j] != 0) {
                    System.out.printf("%d ", numbers[j]);
                }
            }
            System.out.println();
        }
    }
}
