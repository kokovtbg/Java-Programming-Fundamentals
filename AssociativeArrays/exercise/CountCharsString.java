package AssociativeArrays.exercise;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CountCharsString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String sequence = scan.nextLine();

        String helpSequence = "";
        LinkedHashMap<Character, Integer> mapCountChars = new LinkedHashMap<>();
        for (int i = 0; i < sequence.length(); i++) {
            int count = 1;
            boolean hasChar = false;
            for (int j = 0; j < helpSequence.length(); j++) {
                if (helpSequence.charAt(j) == sequence.charAt(i)) {
                    hasChar = true;
                    break;
                }
            }
            if (i < sequence.length() - 1) {
                for (int j = i + 1; j < sequence.length(); j++) {
                    if (sequence.charAt(i) == sequence.charAt(j) && sequence.charAt(i) != ' ' && !hasChar) {
                        count++;
                    }
                }
            }

            if (!hasChar && sequence.charAt(i) != ' ') {
                mapCountChars.put(sequence.charAt(i), count);
            }
            helpSequence += sequence.charAt(i);
        }
        for (Map.Entry<Character, Integer> entry : mapCountChars.entrySet()) {
            System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
