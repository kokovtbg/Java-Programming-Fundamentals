package ObjectAndClasses.exercise;

import java.nio.file.attribute.UserPrincipal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OpinionPoll {
    private String person;
    private int age;

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public OpinionPoll(String person, int age) {
        this.person = person;
        this.age = age;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<OpinionPoll> names = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] nameAge = scan.nextLine().split(" ");

            String name = nameAge[0];
            int age = Integer.parseInt(nameAge[1]);

            OpinionPoll person = new OpinionPoll(name, age);
            person.setPerson(name);
            person.setAge(age);
            if (age >= 30) {
                names.add(person);
            }
        }
        names = names.stream().sorted(Comparator.comparing(OpinionPoll::getPerson)).collect(Collectors.toList());
        for (OpinionPoll person : names) {
            System.out.printf("%s - %d%n", person.getPerson(), person.getAge());
        }
    }
}
