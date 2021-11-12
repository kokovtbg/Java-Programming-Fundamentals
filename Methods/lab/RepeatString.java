package Methods.lab;

import java.util.Scanner;

public class RepeatString {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int count = Integer.parseInt(scan.nextLine());
        System.out.println(repeatString(input, count));
    }

    public static String repeatString(String str, int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += str;
        }
        return result;
    }
}
