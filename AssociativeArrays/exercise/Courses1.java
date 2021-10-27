package AssociativeArrays.exercise;

import java.util.*;

public class Courses1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        HashMap<String, Integer> courses = new HashMap<>();
        String command = scan.nextLine();
        while (!command.equals("end")) {
            String[] splitData = command.split(" : ");
            String courseName = splitData[0];
            String nameStudent = splitData[1];
            int count = 1;
            boolean existCourse = false;
            String textToAdd = "";
            String textToRemove = "";
            for (Map.Entry<String, Integer> entry : courses.entrySet()) {
                if (entry.getKey().contains(courseName)) {
                    int startIndex = 0;
                    for (int i = 0; i < entry.getKey().length(); i++) {
                        if (entry.getKey().charAt(i) == '-') {
                            startIndex = i;
                            break;
                        }
                    }
                    textToAdd = entry.getKey().substring(startIndex);
                    textToRemove = entry.getKey().substring(0, startIndex);
                    for (int i = 0; i < textToAdd.length() - 1; i++) {
                        if (textToAdd.charAt(i) == '-' && textToAdd.charAt(i + 1) == '-') {
                            count++;
                        }
                    }
                    existCourse = true;
                }
            }
            if (!existCourse) {
                courses.put(courseName + ": " + count + "\n-- " + nameStudent, count);
            } else {
                courses.remove(textToRemove + textToAdd);
                courses.put(courseName + ": " + count + "\n" + textToAdd + "\n-- " + nameStudent, count);
            }

            command = scan.nextLine();
        }
        TreeMap<String, Integer> students = new TreeMap<>();
        HashMap<String, Integer> sortedStudents = new HashMap<>();
        for (Map.Entry<String, Integer> entry : courses.entrySet()) {
            String courseName = "";
            String textToAddTree = "";
            int count = entry.getValue();
            int startIndex = 0;
            for (int i = 0; i < entry.getKey().length() - 1; i++) {
                if (entry.getKey().charAt(i) == ':') {
                    courseName = entry.getKey().substring(0, i);
                }
                if (count == 1 && entry.getKey().charAt(i) == '-' && entry.getKey().charAt(i + 1) == '-') {
                    textToAddTree = entry.getKey().substring(i);
                    students.put(textToAddTree, 0);
                    if (students.entrySet().size() == 1) {
                        students.remove(textToAddTree);
                    }
                    break;
                }
                if (entry.getKey().charAt(i) == '-' && entry.getKey().charAt(i + 1) == '-') {
                    if (startIndex > 0) {
                        textToAddTree = entry.getKey().substring(startIndex, i - 1);
                        students.put(textToAddTree, 0);
                        count--;
                        startIndex = 0;
                        i--;
                    }
                }
                if (entry.getKey().charAt(i) == '-' && entry.getKey().charAt(i + 1) == '-') {
                    startIndex = i;
                    i += 3;
                }
            }
            String sortedStudentsString = "";
            int countStudents = students.size();
            for (Map.Entry<String, Integer> entrySt : students.entrySet()) {
                if (countStudents > 1) {
                    countStudents--;
                    sortedStudentsString += entrySt.getKey() + "\n";
                } else {
                    sortedStudentsString += entrySt.getKey();
                }
            }
            if (!sortedStudentsString.equals("")) {
                sortedStudents.put(courseName + ": " + entry.getValue() + "\n" + sortedStudentsString, entry.getValue());
            } else {
                sortedStudents.put(entry.getKey(), entry.getValue());
            }
            students = new TreeMap<>();
        }

        sortedStudents.entrySet().stream().sorted((a1, a2) -> a2.getValue().compareTo(a1.getValue())).forEach(a -> System.out.printf("%s%n", a.getKey()));
    }
}
