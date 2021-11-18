package TextProcessing.exerciseMore;

import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char firstChar = scan.nextLine().charAt(0);
        char secondChar = scan.nextLine().charAt(0);
        String text = scan.nextLine();
        int sum = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) > firstChar && text.charAt(i) < secondChar) {
                sum += text.charAt(i);
            }
        }
        System.out.println(sum);
    }
}
