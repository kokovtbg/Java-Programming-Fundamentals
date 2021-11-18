package TextProcessing.exercise;

import java.util.Scanner;

public class CaesarCipher1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        StringBuilder encryptedText = new StringBuilder();

        for (char symbol : text.toCharArray()) {
            char encryptedSymbol = (char) (symbol + 3);
            encryptedText.append(encryptedSymbol);
        }
        System.out.println(encryptedText);
    }
}
