package Methods.exercise;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a' || input.charAt(i) == 'A' || input.charAt(i) == 'E' || input.charAt(i) == 'e' || input.charAt(i) == 'I' || input.charAt(i) == 'i' || input.charAt(i) == 'O' || input.charAt(i) == 'o' || input.charAt(i) == 'U' || input.charAt(i) == 'u' || input.charAt(i) == 'Y' || input.charAt(i) == 'y') {
                count++;
            }
        }
        System.out.println(count);
    }
}
