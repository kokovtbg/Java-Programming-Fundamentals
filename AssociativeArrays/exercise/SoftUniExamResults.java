package AssociativeArrays.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();
        Map<String, Integer> students = new HashMap<>();
        Map<String, Integer> courses = new HashMap<>();
        while (!command.equals("exam finished")) {
            if (command.contains("banned")) {
                String[] splitData = command.split("-");
                String username = splitData[0];
                students.remove(username);
                command = scan.nextLine();
                continue;
            }
            String[] splitData = command.split("-");
            String userName = splitData[0];
            String language = splitData[1];
            int points = Integer.parseInt(splitData[2]);
            if (students.containsKey(userName)) {
                if (students.get(userName) < points) {
                    students.put(userName, points);
                }
            } else {
                students.put(userName, points);
            }
            if (courses.containsKey(language)) {
                courses.put(language, courses.get(language) + 1);
            } else {
                courses.put(language, 1);
            }

            command = scan.nextLine();
        }
        System.out.printf("Results:%n");
        students.entrySet().stream().sorted((a1, a2) -> {
            int result = a2.getValue().compareTo(a1.getValue());
            if (result == 0) {
                result = a1.getKey().compareTo(a2.getKey());
            }
            return result;
        }).forEach(a -> System.out.printf("%s | %d%n", a.getKey(), a.getValue()));
        System.out.printf("Submissions:%n");
        courses.entrySet().stream().sorted((a1, a2) -> {
            int result = a2.getValue().compareTo(a1.getValue());
            if (result == 0) {
                result = a1.getKey().compareTo(a2.getKey());
            }
            return result;
        }).forEach(a -> System.out.printf("%s - %d%n", a.getKey(), a.getValue()));
    }
}
