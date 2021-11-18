package ObjectAndClasses.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student1 {
    private String firstName;
    private String lastName;
    private int age;
    private String hometown;

    public Student1(String firstName, String lastName, int age, String hometown) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.hometown = hometown;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String toString() {
        return this.firstName + " " + this.lastName + " is " + this.age + " years old";
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Student1> students = new ArrayList<>();
        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            String firstName = tokens[0];
            String lasName = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            String hometown = tokens[3];
            Student1 student = new Student1(firstName, lasName, age, hometown);
            students.add(student);

            input = scan.nextLine();
        }
        String hometown = scan.nextLine();
        for (Student1 student : students) {
            if (student.getHometown().equals(hometown)) {
                System.out.println(student);
            }
        }
    }
}
