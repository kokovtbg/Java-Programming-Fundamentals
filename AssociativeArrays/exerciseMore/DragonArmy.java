package AssociativeArrays.exerciseMore;

import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, List<String>> dragons = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String dragon = scan.nextLine();
            String[] dragonSplit = dragon.split(" ");
            String dragonType = dragonSplit[0];
            String dragonName = dragonSplit[1];
            String damage = dragonSplit[2];
            String health = dragonSplit[3];
            String armor = dragonSplit[4];
            if (damage.equals("null")) {
                damage = "45";
            }
            if (health.equals("null")) {
                health = "250";
            }
            if (armor.equals("null")) {
                armor = "10";
            }
            String dragonPlus = dragonName + " -> damage: " + damage + ", health: " + health + ", armor: " + armor;
            List<String> dragonsNames;
            if (dragons.containsKey(dragonType)) {
                dragonsNames = dragons.get(dragonType);
            } else {
                dragonsNames = new ArrayList<>();
            }
            dragonsNames.add(dragonPlus);
            Collections.sort(dragonsNames);
            dragons.put(dragonType, dragonsNames);
        }
        for (Map.Entry<String, List<String>> entry : dragons.entrySet()) {
            double averageDamage = 0;
            double averageHealth = 0;
            double averageArmor = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                int startIndexDamage;
                startIndexDamage = entry.getValue().get(i).indexOf("damage") + 8;
                int currentIndexDamage = startIndexDamage;
                while (entry.getValue().get(i).charAt(currentIndexDamage) >= '0' && entry.getValue().get(i).charAt(currentIndexDamage) <= '9') {
                    currentIndexDamage++;
                }
                int endIndexDamage = currentIndexDamage;
                averageDamage += Integer.parseInt(entry.getValue().get(i).substring(startIndexDamage, endIndexDamage));

                int startIndexHealth;
                startIndexHealth = entry.getValue().get(i).indexOf("health") + 8;
                int currentIndexHealth = startIndexHealth;
                while (entry.getValue().get(i).charAt(currentIndexHealth) >= '0' && entry.getValue().get(i).charAt(currentIndexHealth) <= '9') {
                    currentIndexHealth++;
                }
                int endIndexHealth = currentIndexHealth;
                averageHealth += Integer.parseInt(entry.getValue().get(i).substring(startIndexHealth, endIndexHealth));

                int startIndexArmor;
                startIndexArmor = entry.getValue().get(i).indexOf("armor") + 7;
                int endIndexArmor = entry.getValue().get(i).length();
                averageArmor += Integer.parseInt(entry.getValue().get(i).substring(startIndexArmor, endIndexArmor));
            }
            averageDamage /= entry.getValue().size();
            averageHealth /= entry.getValue().size();
            averageArmor /= entry.getValue().size();

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", entry.getKey(), averageDamage, averageHealth, averageArmor);
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.printf("-%s%n", entry.getValue().get(i));
            }
        }
    }
}
