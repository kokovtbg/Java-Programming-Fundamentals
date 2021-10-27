package AssociativeArrays.exercise;

import java.util.*;
import java.util.stream.Collectors;

public class Courses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String, String> courses = new HashMap<>();
        String command = scan.nextLine();
        while (!command.equals("end")) {
            String[] splitData = command.split(" : ");
            String courseName = splitData[0];
            String studentName = splitData[1];
            if (!courses.containsKey(courseName)) {
                courses.put(courseName, studentName);
            } else {
                courses.put(courseName, courses.get(courseName) + "-" + studentName);
            }

            command = scan.nextLine();
        }
        for (Map.Entry<String, String> entry : courses.entrySet()) {
            int count = 0;
            List<String> students = new ArrayList<>();
            if (entry.getValue().contains("-")) {
                String[] splitData = entry.getValue().split("-");
                for (int i = 0; i < splitData.length; i++) {
                    count++;
                    students.add(splitData[i]);
                }
            }
            if (count == 0) {
                count++;
                students.add(entry.getValue());
            }
            System.out.printf("%s: %d%n", entry.getKey(), count);
            for (int i = 0; i < students.size(); i++) {
                System.out.printf("-- %s%n", students.get(i));
            }
        }

    }
}
