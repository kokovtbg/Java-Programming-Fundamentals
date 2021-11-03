package Exams.FinalExam.Test05;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Pirates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, int[]> townPopulationGold = new HashMap<>();
        while (!input.equals("Sail")) {
            String[] splitData = input.split("\\|\\|");
            String nameTown = splitData[0];
            int population = Integer.parseInt(splitData[1]);
            int gold = Integer.parseInt(splitData[2]);
            int[] populationGold;
            if (townPopulationGold.containsKey(nameTown)) {
                populationGold = townPopulationGold.get(nameTown);
                populationGold[0] += population;
                populationGold[1] += gold;
            } else {
                populationGold = new int[2];
                populationGold[0] = population;
                populationGold[1] = gold;
            }
            townPopulationGold.put(nameTown, populationGold);

            input = scan.nextLine();
        }
        String command = scan.nextLine();
        while (!command.equals("End")) {
            String[] splitData = command.split("=>");
            String commandName = splitData[0];
            if (commandName.equals("Plunder")) {
                String nameTown = splitData[1];
                int people = Integer.parseInt(splitData[2]);
                int gold = Integer.parseInt(splitData[3]);
                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", nameTown, gold, people);
                int[] populationGold = townPopulationGold.get(nameTown);
                populationGold[0] -= people;
                populationGold[1] -= gold;
                if (populationGold[0] == 0 || populationGold[1] == 0) {
                    townPopulationGold.remove(nameTown);
                    System.out.printf("%s has been wiped off the map!%n", nameTown);
                }
            }
            if (commandName.equals("Prosper")) {
                String nameTown = splitData[1];
                int gold = Integer.parseInt(splitData[2]);
                if (gold < 0) {
                    System.out.printf("Gold added cannot be a negative number!%n");
                } else {
                    int[] populationGold = townPopulationGold.get(nameTown);
                    populationGold[1] += gold;
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, nameTown, populationGold[1]);
                }
            }
            command = scan.nextLine();
        }
        townPopulationGold = townPopulationGold.entrySet().stream().sorted((a1, a2) -> {
            int a1Gold = a1.getValue()[1];
            int a2Gold = a2.getValue()[1];
            int result = Integer.compare(a2Gold, a1Gold);
            if (result == 0) {
                result = a1.getKey().compareTo(a2.getKey());
            }
            return result;
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2) -> a1, LinkedHashMap::new));
        if (townPopulationGold.size() > 0) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", townPopulationGold.size());
            for (Map.Entry<String, int[]> entry : townPopulationGold.entrySet()) {
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", entry.getKey(), entry.getValue()[0], entry.getValue()[1]);
            }
        }
    }
}
