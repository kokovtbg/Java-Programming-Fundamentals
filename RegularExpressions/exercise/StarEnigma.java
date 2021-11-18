package RegularExpressions.exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();
        String regex = "[^@!:>-]*@(?<namePlanet>[A-Z][a-z]+)[^@!:>-]*:(?<population>\\d+)![^@!:>-]*(?<attackType>A|D)[^@!:>-]*![^@!:>-]*->[^@!:>-]*(?<soldiers>\\d+)[^@!:>-]*";
        for (int i = 0; i < n; i++) {
            String text = scan.nextLine();
            int countStars = 0;
            String textIgnoreCase = text.toLowerCase(Locale.ROOT);
            for (int j = 0; j < textIgnoreCase.length(); j++) {
                if (textIgnoreCase.charAt(j) == 's' || textIgnoreCase.charAt(j) == 't' || textIgnoreCase.charAt(j) == 'a' || textIgnoreCase.charAt(j) == 'r') {
                    countStars++;
                }
            }
            StringBuilder decryptedText = new StringBuilder();
            for (int j = 0; j < text.length(); j++) {
                char characterToAdd = (char) (text.charAt(j) - countStars);
                decryptedText.append(characterToAdd);
            }

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(decryptedText);
            if (matcher.find()) {
                if (matcher.group("attackType").equals("A")) {
                    attackedPlanets.add(matcher.group("namePlanet"));
                }
                if (matcher.group("attackType").equals("D")) {
                    destroyedPlanets.add(matcher.group("namePlanet"));
                }
            }
        }
        Collections.sort(attackedPlanets);
        Collections.sort(destroyedPlanets);
        System.out.printf("Attacked planets: %d%n", attackedPlanets.size());
        for (int i = 0; i < attackedPlanets.size(); i++) {
            System.out.printf("-> %s%n", attackedPlanets.get(i));
        }
        System.out.printf("Destroyed planets: %d%n", destroyedPlanets.size());
        for (int i = 0; i < destroyedPlanets.size(); i++) {
            System.out.printf("-> %s%n", destroyedPlanets.get(i));
        }
    }
}
