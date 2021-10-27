package AssociativeArrays.exerciseMore;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Ranking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> contests = new HashMap<>();
        String command = scan.nextLine();
        while (!command.equals("end of contests")) {
            String[] splitData = command.split(":");
            String contest = splitData[0];
            String password = splitData[1];
            contests.put(contest, password);

            command = scan.nextLine();
        }
        Map<String, Map<String, Integer>> usernamesContests = new HashMap<>();
        String input = scan.nextLine();
        while (!input.equals("end of submissions")) {
            String[] splitData = input.split("=>");
            String contest = splitData[0];
            String password = splitData[1];
            String username = splitData[2];
            int points = Integer.parseInt(splitData[3]);
            if (contests.containsKey(contest) && contests.get(contest).equals(password)) {
                if (!usernamesContests.containsKey(username)) {
                    Map<String, Integer> contestsPerUser = new HashMap<>();
                    contestsPerUser.put(contest, points);
                    contestsPerUser = contestsPerUser.entrySet().stream().sorted((a1, a2) -> a2.getValue().compareTo(a1.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2) -> a1, LinkedHashMap::new));
                    usernamesContests.put(username, contestsPerUser);
                } else {
                    Map<String, Integer> contestsPerUser = usernamesContests.get(username);
                    if (!contestsPerUser.containsKey(contest)) {
                        contestsPerUser.put(contest, points);
                        contestsPerUser = contestsPerUser.entrySet().stream().sorted((a1, a2) -> a2.getValue().compareTo(a1.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2) -> a1, LinkedHashMap::new));
                        usernamesContests.put(username, contestsPerUser);
                    } else {
                        if (contestsPerUser.get(contest) < points) {
                            contestsPerUser.put(contest, points);
                            contestsPerUser = contestsPerUser.entrySet().stream().sorted((a1, a2) -> a2.getValue().compareTo(a1.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2) -> a1, LinkedHashMap::new));
                            usernamesContests.put(username, contestsPerUser);
                        }
                    }
                }
            }

            input = scan.nextLine();
        }
        int maximum = 0;
        String bestCandidate = "";
        for (Map.Entry<String, Map<String, Integer>> entry : usernamesContests.entrySet()) {
            int sum = 0;
            for (Map.Entry<String, Integer> entry2 : entry.getValue().entrySet()) {
                sum += entry2.getValue();
            }
            if (sum > maximum) {
                maximum = sum;
                bestCandidate = entry.getKey();
            }
        }
        System.out.printf("Best candidate is %s with total %d points.%n", bestCandidate, maximum);
        System.out.printf("Ranking:%n");
        usernamesContests = usernamesContests.entrySet().stream().sorted((a1, a2) -> a1.getKey().compareTo(a2.getKey())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2) -> a1, LinkedHashMap::new));

        for (Map.Entry<String, Map<String, Integer>> entry : usernamesContests.entrySet()) {
            System.out.printf("%s%n", entry.getKey());
            for (Map.Entry<String, Integer> entry2 : entry.getValue().entrySet()) {
                System.out.printf("#  %s -> %d%n", entry2.getKey(), entry2.getValue());
            }
        }
    }
}
