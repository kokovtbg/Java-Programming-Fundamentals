package ObjectAndClasses.lab;

import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().split(" ");
        Random rnd = new Random();
        for (int pos1 = 0; pos1 < words.length; pos1++) {
            int pos2 = rnd.nextInt(words.length);
            String tempWord = words[pos1];
            words[pos1] = words[pos2];
            words[pos2] = tempWord;
        }
        System.out.println(String.join(System.lineSeparator(), words));
    }
}
