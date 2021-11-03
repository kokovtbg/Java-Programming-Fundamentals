package Exams.FinalExam.Test02;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, double[]> plantsRarityRating = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] splitData = scan.nextLine().split("<->");
            String plantName = splitData[0];
            double rarity = Double.parseDouble(splitData[1]);
            if (!plantsRarityRating.containsKey(plantName)) {
                double[] rarityRating = new double[2];
                rarityRating[0] = rarity;
                plantsRarityRating.put(plantName, rarityRating);
            } else {
                double[] rarityRating = plantsRarityRating.get(plantName);
                rarityRating[0] = rarity;
                plantsRarityRating.put(plantName, rarityRating);
            }
        }
        String command = scan.nextLine();
        while (!command.equals("Exhibition")) {
            String[] splitData = command.split(" ");
            String commandName = splitData[0];
            if (commandName.equals("Rate:")) {
                String plantName = splitData[1];
                double rating = Double.parseDouble(splitData[3]);
                if (plantsRarityRating.containsKey(plantName)) {
                    double[] rarityRating = plantsRarityRating.get(plantName);
                    if (rarityRating[1] != 0) {
                        rarityRating[1] = (rarityRating[1] + rating) / 2;
                    } else {
                        rarityRating[1] = rating;
                    }
                } else {
                    System.out.println("error");
                }
            }
            if (commandName.equals("Update:")) {
                String plantName = splitData[1];
                double rarityNew = Double.parseDouble(splitData[3]);
                if (plantsRarityRating.containsKey(plantName)) {
                    double[] rarityRating = plantsRarityRating.get(plantName);
                    rarityRating[0] = rarityNew;
                } else {
                    System.out.println("error");
                }
            }
            if (commandName.equals("Reset:")) {
                String plantName = splitData[1];
                if (plantsRarityRating.containsKey(plantName)) {
                    double[] rarityRating = plantsRarityRating.get(plantName);
                    rarityRating[1] = 0;
                } else {
                    System.out.println("error");
                }
            }

            command = scan.nextLine();
        }
        plantsRarityRating = plantsRarityRating.entrySet().stream().sorted((a1, a2) -> {
            double rarityA1 = a1.getValue()[0];
            double rarityA2 = a2.getValue()[0];
            int result = Double.compare(rarityA2, rarityA1);
            if (result == 0) {
                result = Double.compare(a2.getValue()[1], a1.getValue()[1]);
            }
            return result;
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2) -> a1, LinkedHashMap::new));
        System.out.printf("Plants for the exhibition:%n");
        for (Map.Entry<String, double[]> entry : plantsRarityRating.entrySet()) {
            System.out.printf("- %s; Rarity: %.0f; Rating: %.2f%n", entry.getKey(), entry.getValue()[0], entry.getValue()[1]);
        }
    }
}
