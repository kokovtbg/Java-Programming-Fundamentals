package Exams.FinalExam.Test04;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HeroesCodeLogicVII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, int[]> heroesCodeLogic = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String heroes = scan.nextLine();
            String[] splitData = heroes.split(" ");
            String heroName = splitData[0];
            int hp = Integer.parseInt(splitData[1]);
            int mp = Integer.parseInt(splitData[2]);
            int[] hpMp = new int[2];
            hpMp[0] = hp;
            hpMp[1] = mp;
            heroesCodeLogic.put(heroName, hpMp);
        }
        String command = scan.nextLine();
        while (!command.equals("End")) {
            String[] splitData = command.split(" - ");
            String commandName = splitData[0];
            if (commandName.equals("CastSpell")) {
                String heroName = splitData[1];
                int mpNeeded = Integer.parseInt(splitData[2]);
                String spellName = splitData[3];
                if (heroesCodeLogic.get(heroName)[1] >= mpNeeded) {
                    heroesCodeLogic.get(heroName)[1] -= mpNeeded;
                    System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, heroesCodeLogic.get(heroName)[1]);
                } else {
                    System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                }
            }
            if (commandName.equals("TakeDamage")) {
                String heroName = splitData[1];
                int damage = Integer.parseInt(splitData[2]);
                String attacker = splitData[3];
                heroesCodeLogic.get(heroName)[0] -= damage;
                if (heroesCodeLogic.get(heroName)[0] > 0) {
                    System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, heroesCodeLogic.get(heroName)[0]);
                } else {
                    heroesCodeLogic.remove(heroName);
                    System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                }
            }
            if (commandName.equals("Recharge")) {
                String heroName = splitData[1];
                int amount = Integer.parseInt(splitData[2]);
                if (heroesCodeLogic.get(heroName)[1] + amount > 200) {
                    int count = 0;
                    int rechargeNormal = heroesCodeLogic.get(heroName)[1] + amount;
                    while (rechargeNormal > 200) {
                        rechargeNormal--;
                        count++;
                    }
                    amount -= count;
                }
                heroesCodeLogic.get(heroName)[1] += amount;
                System.out.printf("%s recharged for %d MP!%n", heroName, amount);
            }
            if (commandName.equals("Heal")) {
                String heroName = splitData[1];
                int amount = Integer.parseInt(splitData[2]);
                if (heroesCodeLogic.get(heroName)[0] + amount > 100) {
                    int count = 0;
                    int healNormal = heroesCodeLogic.get(heroName)[0] + amount;
                    while (healNormal > 100) {
                        healNormal--;
                        count++;
                    }
                    amount -= count;
                }
                heroesCodeLogic.get(heroName)[0] += amount;
                System.out.printf("%s healed for %d HP!%n", heroName, amount);
            }

            command = scan.nextLine();
        }
        heroesCodeLogic = heroesCodeLogic.entrySet().stream().sorted((a1, a2) -> {
            int a1HP = a1.getValue()[0];
            int a2HP = a2.getValue()[0];
            int result = Integer.compare(a2HP, a1HP);
            if (result == 0) {
                result = a1.getKey().compareTo(a2.getKey());
            }
            return result;
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2) -> a1, LinkedHashMap::new));

        for (Map.Entry<String, int[]> entry : heroesCodeLogic.entrySet()) {
            System.out.printf("%s%n", entry.getKey());
            System.out.printf("  HP: %d%n", entry.getValue()[0]);
            System.out.printf("  MP: %d%n", entry.getValue()[1]);
        }
    }
}
