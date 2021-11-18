package RegularExpressions.exerciseMore;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantaSecretHelper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int key = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        while (!input.equals("end")) {
            StringBuilder decryptedText = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                decryptedText.append((char)(input.charAt(i) - key));
            }
            String regex = "@(?<name>[A-Za-z]+)[^@!:>-]*!(?<behavior>G|N)!";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(decryptedText);
            if (matcher.find() && matcher.group("behavior").equals("G")) {
                System.out.println(matcher.group("name"));
            }

            input = scan.nextLine();
        }
    }
}
