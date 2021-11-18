package ObjectAndClasses.lab;

import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigInteger firstNum = new BigInteger(scan.nextLine());
        BigInteger secondNum = new BigInteger(scan.nextLine());
        BigInteger sum = new BigInteger(String.valueOf(0));

        sum = sum.add(firstNum);
        sum = sum.add(secondNum);
        System.out.println(sum);
    }
}
