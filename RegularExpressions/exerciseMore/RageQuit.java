package RegularExpressions.exerciseMore;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String rageQuit = scan.nextLine();
        String regex = "[^0-9]+[0-9]+";
        Pattern pattern = Pattern.compile(regex);
        String rageQuitWithoutNumbers = rageQuit.replaceAll("[0-9]", "").toLowerCase();
        StringBuilder uniqueCharacters = new StringBuilder();
        for (int i = 0; i < rageQuitWithoutNumbers.length(); i++) {
            if (!uniqueCharacters.toString().contains(rageQuitWithoutNumbers.charAt(i) + "")) {
                uniqueCharacters.append(rageQuitWithoutNumbers.charAt(i));
            }
        }
        StringBuilder messageRageQuit = new StringBuilder();
        Matcher matcher = pattern.matcher(rageQuit);
        while (matcher.find()) {
            int countLetters = Integer.parseInt(matcher.group().replaceAll("[^0-9]", ""));
            for (int i = 1; i <= countLetters; i++) {
                messageRageQuit.append(matcher.group().replaceAll("[0-9]", "").toUpperCase());
            }
        }
        System.out.printf("Unique symbols used: %d%n", uniqueCharacters.length());
        System.out.println(messageRageQuit);
    }
}
