package Methods.exerciseMore;

import java.util.Scanner;

public class LongerLine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x1 = Integer.parseInt(scan.nextLine());
        int y1 = Integer.parseInt(scan.nextLine());
        int x2 = Integer.parseInt(scan.nextLine());
        int y2 = Integer.parseInt(scan.nextLine());
        int x3 = Integer.parseInt(scan.nextLine());
        int y3 = Integer.parseInt(scan.nextLine());
        int x4 = Integer.parseInt(scan.nextLine());
        int y4 = Integer.parseInt(scan.nextLine());

        if (longerLine(x1, y1, x2, y2) > longerLine(x3, y3, x4, y4)) {
            System.out.printf("(%d, %d)(%d, %d)", x1, y1, x2, y2);
        } else if (longerLine(x1, y1, x2, y2) == longerLine(x3, y3, x4, y4)) {
            if (sumAbs(x1, y1) <= sumAbs(x2, y2)) {
                if (sumAbs(x3, y3) <= sumAbs(x4, y4)) {
                    if (sumAbs(x1, y1) <= sumAbs(x3, y3)) {
                        System.out.printf("(%d, %d)(%d, %d)", x1, y1, x2, y2);
                    } else {
                        System.out.printf("(%d, %d)(%d, %d)", x3, y3, x4, y4);
                    }
                } else {
                    if (sumAbs(x1, y1) <= sumAbs(x4, y4)) {
                        System.out.printf("(%d, %d)(%d, %d)", x1, y1, x2, y2);
                    } else {
                        System.out.printf("(%d, %d)(%d, %d)", x3, y3, x4, y4);
                    }
                }
            } else {
                if (sumAbs(x3, y3) <= sumAbs(x4, y4)) {
                    if (sumAbs(x2, y2) <= sumAbs(x3, y3)) {
                        System.out.printf("(%d, %d)(%d, %d)", x1, y1, x2, y2);
                    } else {
                        System.out.printf("(%d, %d)(%d, %d)", x3, y3, x4, y4);
                    }
                } else {
                    if (sumAbs(x2, y2) <= sumAbs(x4, y4)) {
                        System.out.printf("(%d, %d)(%d, %d)", x1, y1, x2, y2);
                    } else {
                        System.out.printf("(%d, %d)(%d, %d)", x3, y3, x4, y4);
                    }
                }
            }
        } else {
            System.out.printf("(%d, %d)(%d, %d)", x3, y3, x4, y4);
        }

    }

    private static int longerLine(int x1, int y1, int x2, int y2) {
        return sumAbs(x1, y1) + sumAbs(x2, y2);
    }

    private static int sumAbs(int x, int y) {
        return Math.abs(x) + Math.abs(y);
    }
}
