package TextProcessing.exercise;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] strings = scan.nextLine().split(" ");
        int sum = 0;
        if (strings[0].length() == strings[1].length()) {
            for (int i = 0; i < strings[1].length(); i++) {
                sum += strings[0].charAt(i) * strings[1].charAt(i);
            }
        } else {
            if (strings[0].length() > strings[1].length()) {
                for (int i = 0; i < strings[1].length(); i++) {
                    sum += strings[0].charAt(i) * strings[1].charAt(i);
                }
                for (int i = strings[1].length(); i < strings[0].length(); i++) {
                    sum += strings[0].charAt(i);
                }
            } else {
                for (int i = 0; i < strings[0].length(); i++) {
                    sum += strings[0].charAt(i) * strings[1].charAt(i);
                }
                for (int i = strings[0].length(); i < strings[1].length(); i++) {
                    sum += strings[1].charAt(i);
                }
            }
        }
        System.out.println(sum);
    }
}
