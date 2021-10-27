package AssociativeArrays.exerciseMore;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MOBAChallenger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Integer>> playersPositionSkill = new HashMap<>();
        String command = scan.nextLine();
        while (!command.equals("Season end")) {
            if (command.contains("->")) {
                String player = command.split(" -> ")[0];
                String position = command.split(" -> ")[1];
                int skill = Integer.parseInt(command.split(" -> ")[2]);
                Map<String, Integer> positionSkill;
                if (!playersPositionSkill.containsKey(player)) {
                    positionSkill = new HashMap<>();
                    positionSkill.put(position, skill);
                } else {
                    positionSkill = playersPositionSkill.get(player);
                    if (positionSkill.containsKey(position)) {
                        if (positionSkill.get(position) < skill) {
                            positionSkill.put(position, skill);
                        }
                    } else {
                        positionSkill.put(position, skill);
                    }
                }
                positionSkill = positionSkill.entrySet().stream().sorted((a1, a2) -> {
                    int result = a2.getValue().compareTo(a1.getValue());
                    if (result == 0) {
                        result = a1.getKey().compareTo(a2.getKey());
                    }
                    return result;
                }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2) -> a1, LinkedHashMap::new));
                playersPositionSkill.put(player, positionSkill);
            }
            if (command.contains("vs")) {
                String player1 = command.split(" vs ")[0];
                String player2 = command.split(" vs ")[1];
                if (playersPositionSkill.containsKey(player1) && playersPositionSkill.containsKey(player2)) {
                    boolean haveDuel = false;
                    String commonPosition = "";
                    for (Map.Entry<String, Integer> entry : playersPositionSkill.get(player1).entrySet()) {
                        for (Map.Entry<String, Integer> entry2 : playersPositionSkill.get(player2).entrySet()) {
                            if (entry.getKey().equals(entry2.getKey())) {
                                haveDuel = true;
                                commonPosition = entry.getKey();
                                break;
                            }
                        }
                    }
                    if (haveDuel) {
                        if (playersPositionSkill.get(player1).get(commonPosition) < playersPositionSkill.get(player2).get(commonPosition)) {
                            playersPositionSkill.remove(player1);
                        } else if (playersPositionSkill.get(player1).get(commonPosition) > playersPositionSkill.get(player2).get(commonPosition)) {
                            playersPositionSkill.remove(player2);
                        }
                    }
                }
            }

            command = scan.nextLine();
        }
        playersPositionSkill = playersPositionSkill.entrySet().stream().sorted((a1, a2) -> {
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
                result = a1.getKey().compareTo(a2.getKey());
            }
            return result;
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2) -> a1, LinkedHashMap::new));
        for (Map.Entry<String, Map<String, Integer>> entry : playersPositionSkill.entrySet()) {
            int sum = 0;
            for (Map.Entry<String, Integer> entry2 : entry.getValue().entrySet()) {
                sum += entry2.getValue();
            }
            System.out.printf("%s: %d skill%n", entry.getKey(), sum);
            for (Map.Entry<String, Integer> entry2 : entry.getValue().entrySet()) {
                System.out.printf("- %s <::> %d%n", entry2.getKey(), entry2.getValue());
            }
        }
    }
}
