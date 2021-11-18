package TextProcessing.exercise;

import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumber1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigInteger bigNumber = new BigInteger(scan.nextLine());
        int digit = Integer.parseInt(scan.nextLine());
        BigInteger multiply = bigNumber.multiply(BigInteger.valueOf(digit));
        System.out.println(multiply);
    }
}
