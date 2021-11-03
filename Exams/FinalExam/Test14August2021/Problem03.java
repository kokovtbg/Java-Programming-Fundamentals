package Exams.FinalExam.Test14August2021;

import java.util.*;
import java.util.stream.Collectors;

public class Problem03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> animalFood = new TreeMap<>();
        Map<String, List<String>> areaAnimals = new TreeMap<>();

        List<String> existingArea = new ArrayList<>();
        String command = scan.nextLine();
        while (!command.equals("EndDay")) {
            String[] commandParts = command.split("[ -]");
            String commandName = commandParts[0];
            if (commandName.equals("Add:")) {
                String animalName = commandParts[1];
                int neededFood = Integer.parseInt(commandParts[2]);
                String area = commandParts[3];
                if (!animalFood.containsKey(animalName)) {
                    animalFood.put(animalName, neededFood);
                } else {
                    animalFood.put(animalName, animalFood.get(animalName) + neededFood);
                }
                if (!existingArea.contains(area)) {
                    List<String> animals = new ArrayList<>();
                    animals.add(animalName);
                    areaAnimals.put(area, animals);
                } else {
                    List<String> animals = areaAnimals.get(area);
                    if (!animals.contains(animalName)) {
                        animals.add(animalName);
                        areaAnimals.put(area, animals);
                    }
                }

                existingArea.add(area);
            }
            if (commandName.equals("Feed:")) {
                String animalName = commandParts[1];
                int food = Integer.parseInt(commandParts[2]);
                if (animalFood.containsKey(animalName)) {
                    animalFood.put(animalName, animalFood.get(animalName) - food);
                    if (animalFood.get(animalName) <= 0) {
                        for (Map.Entry<String, List<String>> entry : areaAnimals.entrySet()) {
                            List<String> animals = entry.getValue();
                            animals.remove(animalName);
                        }
                        animalFood.remove(animalName);
                        System.out.printf("%s was successfully fed%n", animalName);
                    }
                }
            }

            command = scan.nextLine();
        }
        System.out.printf("Animals:%n");
        animalFood.entrySet().stream().sorted((a1, a2) -> Integer.compare(a2.getValue(), a1.getValue())).forEach(a -> System.out.printf(" %s -> %dg%n", a.getKey(), a.getValue()));
        System.out.printf("Areas with hungry animals:%n");
        areaAnimals = areaAnimals.entrySet().stream().sorted((a1, a2) -> Integer.compare(a2.getValue().size(), a1.getValue().size())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2) -> a1, LinkedHashMap::new));
        for (Map.Entry<String, List<String>> entry : areaAnimals.entrySet()) {
            if (entry.getValue().size() > 0) {
                System.out.printf(" %s: %d%n", entry.getKey(), entry.getValue().size());
            }
        }
    }
}
