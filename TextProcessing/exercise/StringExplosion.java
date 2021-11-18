package TextProcessing.exercise;

import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();

        StringBuilder textAfterExplosion = new StringBuilder();
        int powerExplosion = 0;
        for (int i = 0; i < text.length(); i++) {
            textAfterExplosion.append(text.charAt(i));
            if (i < text.length() - 1 && text.charAt(i) == '>') {
                powerExplosion += Integer.parseInt("" + text.charAt(i + 1));
                int index = i;
                if (powerExplosion > text.length() - 1) {
                    powerExplosion = text.length() - 1 - i;
                }
                while (powerExplosion > 0) {
                    if (i < text.length() - 1 && text.charAt(i + 1) == '>' && i != index) {
                        break;
                    }
                    powerExplosion--;
                    i++;
                }

            }
        }
        System.out.println(textAfterExplosion);
    }
}
