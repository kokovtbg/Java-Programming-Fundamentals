package RegularExpressions.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] demons = scan.nextLine().split("[, ]+");

        Map<String, Map<Integer, Double>> demonsHealthDamage = new TreeMap<>();
        String regexDouble = "-?\\d+\\.\\d+";
        String regexInt = "-?\\d+";
        Pattern patternDouble = Pattern.compile(regexDouble);
        Pattern patternInt = Pattern.compile(regexInt);
        for (int i = 0; i < demons.length; i++) {
            int health = 0;
            double damage = 0;
            Matcher matcherDouble = patternDouble.matcher(demons[i]);
            String text = demons[i];
            while (matcherDouble.find()) {
                damage += Double.parseDouble(matcherDouble.group());
                text = text.replace(matcherDouble.group(), "");
            }
            Matcher matcherInt = patternInt.matcher(text);
            while (matcherInt.find()) {
                damage += Integer.parseInt(matcherInt.group());
            }
            boolean validName = true;
            for (int j = 0; j < text.length(); j++) {
                if ((text.charAt(j) <= ')' && text.charAt(j) != ' ') || text.charAt(j) > '9') {
                    health += text.charAt(j);
                }
                if (text.charAt(j) == ' ') {
                    validName = false;
                }
                if (text.charAt(j) == '*') {
                    damage *= 2;
                }
                if (text.charAt(j) == '/') {
                    damage /= 2;
                }
            }
            if (text.length() == 0) {
                validName = false;
            }
            if (validName) {
                Map<Integer, Double> healthDamage = new HashMap<>();
                healthDamage.put(health, damage);
                demonsHealthDamage.put(demons[i], healthDamage);
            }
        }
        for (Map.Entry<String, Map<Integer, Double>> entry : demonsHealthDamage.entrySet()) {
            for (Map.Entry<Integer, Double> entry2 : entry.getValue().entrySet()) {
                System.out.printf("%s - %d health, %.2f damage%n", entry.getKey(), entry2.getKey(), entry2.getValue());
            }
        }
    }
}
