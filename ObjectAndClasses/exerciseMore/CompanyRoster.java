package ObjectAndClasses.exerciseMore;

import java.util.*;
import java.util.stream.Collectors;

public class CompanyRoster {
    private String name;
    private double salary;
    private String position;
    private  String department;
    private String eMail;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public CompanyRoster(String name, double salary, String position, String department, String eMail, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.eMail = eMail;
        this.age = age;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<CompanyRoster> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split(" ");
            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];
            String eMail = "";
            int age = 0;
            if (data.length == 4) {
                eMail = "n/a";
                age = -1;
            }
            if (data.length == 5 && data[4].contains("@")) {
                eMail = data[4];
                age = -1;
            }
            if (data.length == 5 && data[4].length() >= 2 && data[4].length() <= 3) {
                eMail = "n/a";
                age = Integer.parseInt(data[4]);
            }
            if (data.length == 6) {
                eMail = data[4];
                age = Integer.parseInt(data[5]);
            }

            CompanyRoster employee = new CompanyRoster(name, salary, position, department, eMail, age);
            employee.setName(name);
            employee.setSalary(salary);
            employee.setPosition(position);
            employee.setDepartment(department);
            employee.seteMail(eMail);
            employee.setAge(age);

            employees.add(employee);

        }
        employees = employees.stream().sorted(Comparator.comparing(CompanyRoster::getDepartment)).collect(Collectors.toList());
        double sum = 0;
        double maxSum = 0;
        int count = 0;
        String bestDepartment = "";
        for (int i = 0; i < employees.size() - 1; i++) {
            sum += employees.get(i).getSalary();
            count++;
            for (int j = i + 1; j < employees.size(); j++) {
                if (employees.get(i).getDepartment().equals(employees.get(j).getDepartment())) {
                    sum += employees.get(j).getSalary();
                    count++;
                }
            }
            if (sum / count > maxSum) {
                maxSum = sum / count;
                bestDepartment = employees.get(i).getDepartment();
            }
        }
        System.out.printf("Highest Average Salary: %s%n", bestDepartment);
        employees = employees.stream().sorted(Comparator.comparingDouble(CompanyRoster::getSalary)).collect(Collectors.toList());
        Collections.reverse(employees);
        for (CompanyRoster employee : employees) {
            if (employee.getDepartment().equals(bestDepartment)) {
                System.out.printf("%s %.2f %s %d%n", employee.getName(), employee.getSalary(), employee.geteMail(), employee.getAge());
            }
        }
    }
}
