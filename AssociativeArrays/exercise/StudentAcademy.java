package AssociativeArrays.exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        LinkedHashMap<String, Double> students = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String nameStudent = scan.nextLine();
            double grade = Double.parseDouble(scan.nextLine());
            if (!students.containsKey(nameStudent)) {
                students.put(nameStudent, grade);
            } else {
                students.put(nameStudent, (students.get(nameStudent) + grade) / 2);
            }
        }
        students.entrySet().stream().filter(a -> a.getValue() >= 4.5).sorted((a1, a2) -> a2.getValue().compareTo(a1.getValue())).forEach(a -> System.out.printf("%s -> %.2f%n", a.getKey(), a.getValue()));
    }
}
