package ObjectAndClasses.exercise;

import java.util.*;
import java.util.stream.Collectors;

public class Students {
    private String firstName;
    private String lastName;
    private double grade;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Students(String firstName, String lastName, double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<Students> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split(" ");
            String firstName = data[0];
            String lastName = data[1];
            double grade = Double.parseDouble(data[2]);

            Students student = new Students(firstName, lastName, grade);
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setGrade(grade);
            students.add(student);
        }
        students = students.stream().sorted(Comparator.comparingDouble(Students::getGrade)).collect(Collectors.toList());
        Collections.reverse(students);
        for (Students student : students) {
            System.out.printf("%s %s: %.2f%n", student.getFirstName(), student.getLastName(), student.getGrade());
        }
    }
}
