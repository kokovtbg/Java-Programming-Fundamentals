package AssociativeArrays.exercise;

import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String, Integer> mapLegend = new HashMap<>();

        TreeMap<String, Integer> mapJunk = new TreeMap<>();
        String shards = "shards";
        String fragments = "fragments";
        String motes = "motes";
        mapLegend.put(shards, 0);
        mapLegend.put(fragments, 0);
        mapLegend.put(motes, 0);
        String command = scan.nextLine();
        while (true) {
            String[] splitData = command.split(" ");
            int quantity = 0;
            boolean completeGame = false;
            for (int i = 0; i < splitData.length; i++) {
                if (i % 2 == 0) {
                    quantity = Integer.parseInt(splitData[i]);
                } else {
                    String material = splitData[i].toLowerCase(Locale.ROOT);
                    if (mapLegend.containsKey(material)) {
                        mapLegend.put(material, mapLegend.get(material) + quantity);
                    } else {
                        if (mapJunk.containsKey(material)) {
                            mapJunk.put(material, mapJunk.get(material) + quantity);
                        } else {
                            mapJunk.put(material, quantity);
                        }
                    }
                    if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                        if (mapLegend.get(material) >= 250) {
                            if (material.equalsIgnoreCase("shards")) {
                                System.out.printf("Shadowmourne obtained!%n");
                            } else if (material.equalsIgnoreCase("fragments")) {
                                System.out.printf("Valanyr obtained!%n");
                            } else {
                                System.out.printf("Dragonwrath obtained!%n");
                            }
                            mapLegend.put(material, mapLegend.get(material) - 250);
                            completeGame = true;
                            break;
                        }
                    }
                }
            }
            if (completeGame) {
                break;
            }
            command = scan.nextLine();
        }
        mapLegend.entrySet().stream().sorted((e1, e2) -> {
            int res = e2.getValue().compareTo(e1.getValue());
            if (res == 0) {
                res = e1.getKey().compareTo(e2.getKey());
            }
            return res;
        }).forEach(e -> System.out.printf("%s: %d%n", e.getKey(), Math.round(e.getValue())));
        for (Map.Entry<String, Integer> entry : mapJunk.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), Math.round(entry.getValue()));
        }
    }
}
