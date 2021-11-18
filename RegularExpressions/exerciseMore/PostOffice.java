package RegularExpressions.exerciseMore;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] parts = scan.nextLine().split("\\|");
        String regexFirstPart = "#[A-Z]+#|\\$[A-Z]+\\$|%[A-Z]+%|\\*[A-Z]+\\*|&[A-Z]+&";
        String regexSecondPart = "(?<ascii>\\d{2}):(?<countLetters>\\d{2})";
        String regexThirdPart = "\\b[A-Z][^ ]+";

        Pattern patternFirstPart = Pattern.compile(regexFirstPart);
        Matcher matcherFirstPart = patternFirstPart.matcher(parts[0]);
        Pattern patternSecondPart = Pattern.compile(regexSecondPart);
        if (matcherFirstPart.find()) {
            String capitalLetters = matcherFirstPart.group().substring(1, matcherFirstPart.group().length() - 1);
            Matcher matcherSecondPart = patternSecondPart.matcher(parts[1]);
            Map<Character, Integer> lettersLength = new LinkedHashMap<>();
            for (int i = 0; i < capitalLetters.length(); i++) {
                lettersLength.put(capitalLetters.charAt(i), 0);
            }
            while (matcherSecondPart.find()) {
                for (int i = 0; i < capitalLetters.length(); i++) {
                    if (capitalLetters.charAt(i) == Integer.parseInt(matcherSecondPart.group("ascii"))) {
                        lettersLength.put(capitalLetters.charAt(i), Integer.parseInt(matcherSecondPart.group("countLetters")) + 1);
                    }
                }
            }
            Pattern patternThirdPart = Pattern.compile(regexThirdPart);
            Matcher matcherThirdPart = patternThirdPart.matcher(parts[2]);
            List<String> words = new ArrayList<>();
            while (matcherThirdPart.find()) {
                String matchedWord = matcherThirdPart.group();
                for (Map.Entry<Character, Integer> entry : lettersLength.entrySet()) {
                    if (entry.getKey() == matchedWord.charAt(0) && entry.getValue() == matchedWord.length()) {
                        words.add(matchedWord);
                    }
                }
            }
            for (int i = 0; i < words.size(); i++) {
                System.out.println(words.get(i));
            }
        }
    }
}
