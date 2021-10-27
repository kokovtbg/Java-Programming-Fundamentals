package AssociativeArrays.exercise;

import java.util.*;

public class Courses2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> courseStudents = new LinkedHashMap<>();
        String command = scan.nextLine();
        while (!command.equals("end")) {
            String[] splitData = command.split(" : ");
            String nameCourse = splitData[0];
            String nameStudent = splitData[1];
            List<String> students;
            if (!courseStudents.containsKey(nameCourse)) {
                students = new ArrayList<>();
            } else {
                students = courseStudents.get(nameCourse);
            }
            students.add(nameStudent);
            Collections.sort(students);
            courseStudents.put(nameCourse, students);

            command = scan.nextLine();
        }
        courseStudents.entrySet().stream().sorted((a1, a2) -> {
            String a1String = "" + a1.getValue().size();
            String a2String = "" + a2.getValue().size();
            return a2String.compareTo(a1String);
        }).forEach(a -> {
            System.out.printf("%s: %d%n", a.getKey(), a.getValue().size());
            for (int i = 0; i < a.getValue().size(); i++) {
                System.out.printf("-- %s%n", a.getValue().get(i));
            }
        });
    }
}
