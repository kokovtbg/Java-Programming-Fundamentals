package Methods.exercise;

import java.util.Locale;
import java.util.Scanner;

public class VowelsCount1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine().toLowerCase(Locale.ROOT);
        printCountVowels(text);
    }

    private static void printCountVowels(String text) {
        //1. Обхождаме текста(вземаме всички символи)
        //2. Проверка дали тези символи са (a, e, i, o, u) увеличавам броя с i
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    count++;
                    break;
            }
        }
        System.out.println(count);
    }
}
