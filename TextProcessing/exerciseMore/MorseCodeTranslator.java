package TextProcessing.exerciseMore;

import java.util.List;
import java.util.Scanner;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] morseCode = scan.nextLine().split(" \\| ");
        String[] morseCodeTranslate = new String[morseCode.length];
        for (int i = 0; i < morseCode.length; i++) {
            StringBuilder word = new StringBuilder();
            String[] morseCodeWord = morseCode[i].split(" ");
            for (int j = 0; j < morseCodeWord.length; j++) {
                if (morseCodeWord[j].equals(".-")) {
                    word.append("A");
                }
                if (morseCodeWord[j].equals("-...")) {
                    word.append("B");
                }
                if (morseCodeWord[j].equals("-.-.")) {
                    word.append("C");
                }
                if (morseCodeWord[j].equals("-..")) {
                    word.append("D");
                }
                if (morseCodeWord[j].equals(".")) {
                    word.append("E");
                }
                if (morseCodeWord[j].equals("..-.")) {
                    word.append("F");
                }
                if (morseCodeWord[j].equals("--.")) {
                    word.append("G");
                }
                if (morseCodeWord[j].equals("....")) {
                    word.append("H");
                }
                if (morseCodeWord[j].equals("..")) {
                    word.append("I");
                }
                if (morseCodeWord[j].equals(".---")) {
                    word.append("J");
                }
                if (morseCodeWord[j].equals("-.-")) {
                    word.append("K");
                }
                if (morseCodeWord[j].equals(".-..")) {
                    word.append("L");
                }
                if (morseCodeWord[j].equals("--")) {
                    word.append("M");
                }
                if (morseCodeWord[j].equals("-.")) {
                    word.append("N");
                }
                if (morseCodeWord[j].equals("---")) {
                    word.append("O");
                }
                if (morseCodeWord[j].equals(".--.")) {
                    word.append("P");
                }
                if (morseCodeWord[j].equals("--.-")) {
                    word.append("Q");
                }
                if (morseCodeWord[j].equals(".-.")) {
                    word.append("R");
                }
                if (morseCodeWord[j].equals("...")) {
                    word.append("S");
                }
                if (morseCodeWord[j].equals("-")) {
                    word.append("T");
                }
                if (morseCodeWord[j].equals("..-")) {
                    word.append("U");
                }
                if (morseCodeWord[j].equals("...-")) {
                    word.append("V");
                }
                if (morseCodeWord[j].equals(".--")) {
                    word.append("W");
                }
                if (morseCodeWord[j].equals("-..-")) {
                    word.append("X");
                }
                if (morseCodeWord[j].equals("-.--")) {
                    word.append("Y");
                }
                if (morseCodeWord[j].equals("--..")) {
                    word.append("Z");
                }
            }
            morseCodeTranslate[i] = word.toString();
        }
        for (int i = 0; i < morseCodeTranslate.length; i++) {
            System.out.printf("%s ", morseCodeTranslate[i]);
        }
    }
}
