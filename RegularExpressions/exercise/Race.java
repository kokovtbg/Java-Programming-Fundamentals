package RegularExpressions.exercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] namesRacers = scan.nextLine().split(", ");
        Map<String, Integer> racersDistance = new LinkedHashMap<>();

        for (int i = 0; i < namesRacers.length; i++) {
            racersDistance.put(namesRacers[i], 0);
        }
        String input = scan.nextLine();
        while (!input.equals("end of race")) {
            char[] chars = input.toCharArray();
            String nameRacer = "";
            int distance = 0;
            for (int i = 0; i < chars.length; i++) {
                if ((chars[i] >= 'a' && chars[i] <= 'z') || (chars[i] >= 'A' && chars[i] <= 'Z')) {
                    nameRacer += chars[i];
                }
                if (chars[i] >= '1' && chars[i] <= '9') {
                    distance += Integer.parseInt("" + chars[i]);
                }
            }
            if (racersDistance.containsKey(nameRacer)) {
                racersDistance.put(nameRacer, racersDistance.get(nameRacer) + distance);
            }

            input = scan.nextLine();
        }
        racersDistance = racersDistance.entrySet().stream().sorted((a1, a2) -> a2.getValue().compareTo(a1.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2) -> a1, LinkedHashMap::new));
        int count = 0;
        for (Map.Entry<String, Integer> entry : racersDistance.entrySet()) {
            count++;
            if (count == 1) {
                System.out.printf("1st place: %s%n", entry.getKey());
            }
            if (count == 2) {
                System.out.printf("2nd place: %s%n", entry.getKey());
            }
            if (count == 3) {
                System.out.printf("3rd place: %s%n", entry.getKey());
            }
        }
    }
}
