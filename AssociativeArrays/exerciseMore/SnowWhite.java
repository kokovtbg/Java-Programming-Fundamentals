package AssociativeArrays.exerciseMore;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SnowWhite {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Integer>> hatColorNamePhysics = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equals("Once upon a time")) {
            String dwarfName = input.split(" <:> ")[0];
            String dwarfHatColor = input.split(" <:> ")[1];
            int dwarfPhysics = Integer.parseInt(input.split(" <:> ")[2]);
            Map<String, Integer> namePhysics;
            if (!hatColorNamePhysics.containsKey(dwarfHatColor)) {
                namePhysics = new HashMap<>();
                namePhysics.put(dwarfName, dwarfPhysics);
            } else {
                namePhysics = hatColorNamePhysics.get(dwarfHatColor);
                if (namePhysics.containsKey(dwarfName)) {
                    if (namePhysics.get(dwarfName) < dwarfPhysics) {
                        namePhysics.put(dwarfName, dwarfPhysics);
                    }
                } else {
                    namePhysics.put(dwarfName, dwarfPhysics);
                }
            }
            namePhysics = namePhysics.entrySet().stream().sorted((a1, a2) -> {
                int result = a2.getValue().compareTo(a1.getValue());
                if (result == 0) {
                    result = a2.getKey().compareTo(a1.getKey());
                }
                return result;
            }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2) -> a1, LinkedHashMap::new));
            hatColorNamePhysics.put(dwarfHatColor, namePhysics);

            input = scan.nextLine();
        }
        hatColorNamePhysics = hatColorNamePhysics.entrySet().stream().sorted((a1, a2) -> {
            int sum1 = 0;
            for (Map.Entry<String, Integer> entry : a1.getValue().entrySet()) {
                sum1 += entry.getValue();
            }
            int sum2 = 0;
            for (Map.Entry<String, Integer> entry : a2.getValue().entrySet()) {
                sum2 += entry.getValue();
            }
            int result = Integer.compare(sum2, sum1);
            if (result == 0) {
                result = Integer.compare(a2.getValue().size(), a1.getValue().size());
            }
            return result;
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2) -> a1, LinkedHashMap::new));

        for (Map.Entry<String, Map<String, Integer>> entry : hatColorNamePhysics.entrySet()) {
            for (Map.Entry<String, Integer> entry2 : entry.getValue().entrySet()) {
                System.out.printf("(%s) %s <-> %d%n", entry.getKey(), entry2.getKey(), entry2.getValue());
            }
        }
    }
}
