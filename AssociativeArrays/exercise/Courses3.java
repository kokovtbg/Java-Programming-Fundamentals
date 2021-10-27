package AssociativeArrays.exercise;

import java.util.*;

public class Courses3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        Map<String, List<String>> courses = new LinkedHashMap<>();
        while (!input.equals("end")) {
            String courseName = input.split(" : ")[0];
            String personName = input.split(" : ")[1];

            if (!courses.containsKey(courseName)) {
                courses.put(courseName, new ArrayList<>());
            }
            courses.get(courseName).add(personName);

            input = scan.nextLine();
        }
        courses.entrySet().stream().sorted((a1, a2) -> Integer.compare(a2.getValue().size(), a1.getValue().size()))
                .forEach(a -> {
                    System.out.println(a.getKey() + ": " + a.getValue().size());
                    List<String> studentsNames = a.getValue();
                    studentsNames.stream().sorted().forEach(studentName -> System.out.println("-- " + studentName));
                });
    }
}
