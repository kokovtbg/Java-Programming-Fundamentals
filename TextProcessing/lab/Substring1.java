package TextProcessing.lab;

import java.util.Scanner;

public class Substring1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String key = scan.nextLine();
        String text = scan.nextLine();

        int index = text.indexOf(key);
        while (index != -1) {
            text = text.replace(key, "");
            index = text.indexOf(key);
        }
        System.out.println(text);
    }
}
