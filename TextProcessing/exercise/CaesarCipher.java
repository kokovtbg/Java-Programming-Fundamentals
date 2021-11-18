package TextProcessing.exercise;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();

        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int characterToAddInt = (int) text.charAt(i) + 3;
            char characterToAdd = (char) characterToAddInt;
            encryptedText.append(characterToAdd);
        }
        System.out.println(encryptedText);
    }
}
