package ObjectAndClasses.exercise;

import java.util.*;
import java.util.stream.Collectors;

public class MainStudent {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int studentsCount = Integer.parseInt(scan.nextLine());
        List<Student> students = new ArrayList<>();
        for (int student = 1; student <= studentsCount; student++) {
            String studentData = scan.nextLine();
            String[] splitData = studentData.split("\\s+");
            String firstName = splitData[0];
            String lastName = splitData[1];
            double grade = Double.parseDouble(splitData[2]);

            Student st = new Student(firstName, lastName, grade);
            students.add(st);
        }
        students = students.stream().sorted(Comparator.comparingDouble(Student::getGrade)).collect(Collectors.toList());
        Collections.reverse(students);
        for (Student st : students) {
            System.out.println(st);
        }
    }
}
