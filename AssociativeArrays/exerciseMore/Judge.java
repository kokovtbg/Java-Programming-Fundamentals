package AssociativeArrays.exerciseMore;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Judge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> usernames = new HashMap<>();
        Map<String, Map<String, Integer>> contestsUsernames = new LinkedHashMap<>();
        String command = scan.nextLine();
        while (!command.equals("no more time")) {
            String[] splitData = command.split(" -> ");
            String username = splitData[0];
            String contest = splitData[1];
            int points = Integer.parseInt(splitData[2]);

            if (!usernames.containsKey(username)) {
                usernames.put(username, points);
            } else if (usernames.containsKey(username) && contestsUsernames.containsKey(contest) && contestsUsernames.get(contest).containsKey(username)){
                if (usernames.get(username) < points) {
                    usernames.put(username, points);
                }
            } else if (usernames.containsKey(username) && contestsUsernames.containsKey(contest) && !contestsUsernames.get(contest).containsKey(username)) {
                usernames.put(username, usernames.get(username) + points);
            } else if (usernames.containsKey(username) && !contestsUsernames.containsKey(contest)) {
                usernames.put(username, usernames.get(username) + points);
            }

            Map<String, Integer> usernamePoint;
            if (!contestsUsernames.containsKey(contest)) {
                usernamePoint = new LinkedHashMap<>();
                usernamePoint.put(username, points);
            } else {
                usernamePoint = contestsUsernames.get(contest);
                if (usernamePoint.containsKey(username) && usernamePoint.get(username) < points) {
                    usernamePoint.put(username, points);
                } else if (!usernamePoint.containsKey(username)) {
                    usernamePoint.put(username, points);
                }
            }
            usernamePoint = usernamePoint.entrySet().stream().sorted((a1, a2) -> {
                int result = a2.getValue().compareTo(a1.getValue());
                if (result == 0) {
                    result = a1.getKey().compareTo(a2.getKey());
                }
                return result;
            }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2) -> a1, LinkedHashMap::new));

            contestsUsernames.put(contest, usernamePoint);

            command = scan.nextLine();
        }

        for (Map.Entry<String, Map<String, Integer>> entry : contestsUsernames.entrySet()) {
            System.out.printf("%s: %d participants%n", entry.getKey(), entry.getValue().entrySet().size());
            int count = 0;
            for (Map.Entry<String, Integer> entry2 : entry.getValue().entrySet()) {
                count++;
                System.out.printf("%d. %s <::> %d%n", count, entry2.getKey(), entry2.getValue());
            }
        }
        usernames = usernames.entrySet().stream().sorted((a1, a2) -> {
            int result = a2.getValue().compareTo(a1.getValue());
            if (result == 0) {
                result = a1.getKey().compareTo(a2.getKey());
            }
            return result;
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2) -> a1, LinkedHashMap::new));
        System.out.printf("Individual standings:%n");
        int count = 0;
        for (Map.Entry<String, Integer> entry : usernames.entrySet()) {
            count++;
            System.out.printf("%d. %s -> %d%n", count, entry.getKey(), entry.getValue());
        }
    }
}
