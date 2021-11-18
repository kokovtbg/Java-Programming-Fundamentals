package TextProcessing.exercise;

import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumber3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstNumberStr = scan.nextLine();
        String secondNumberStr = scan.nextLine();
        BigInteger firstNumber = new BigInteger(firstNumberStr);
        BigInteger secondNumber = new BigInteger(secondNumberStr);

//        System.out.println(firstNumber.add(secondNumber));
//        System.out.println(firstNumber.subtract(secondNumber));
//        System.out.println(firstNumber.divide(secondNumber));
        System.out.println(firstNumber.multiply(secondNumber));
    }
}
