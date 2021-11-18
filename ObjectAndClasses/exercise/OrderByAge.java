package ObjectAndClasses.exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OrderByAge {
    private String name;
    private int iD;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public OrderByAge(String name, int iD, int age) {
        this.name = name;
        this.iD = iD;
        this.age = age;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<OrderByAge> names = new ArrayList<>();
        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] data = input.split(" ");
            String name = data[0];
            int identification = Integer.parseInt(data[1]);
            int age = Integer.parseInt(data[2]);

            OrderByAge person = new OrderByAge(name, identification, age);
            person.setName(name);
            person.setiD(identification);
            person.setAge(age);
            names.add(person);

            input = scan.nextLine();
        }
        names = names.stream().sorted(Comparator.comparingInt(OrderByAge::getAge)).collect(Collectors.toList());
        for (OrderByAge person : names) {
            System.out.printf("%s with ID: %d is %d years old.%n", person.getName(), person.getiD(), person.getAge());
        }
    }
}
