package AssociativeArrays.exercise;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        HashMap<String, String> companies = new HashMap<>();
        String command = scan.nextLine();
        while (!command.equals("End")) {
            String[] splitData = command.split(" -> ");
            String companyName = splitData[0];
            String employeeId = splitData[1];
            boolean existId = false;
            for (Map.Entry<String, String> entry : companies.entrySet()) {
                if (entry.getKey().equals(companyName) && entry.getValue().contains(employeeId)) {
                    existId = true;
                    break;
                }
            }
            if (!existId) {
                if (companies.containsKey(companyName)) {
                    companies.put(companyName, companies.get(companyName) + "\n-- " + employeeId);
                } else {
                    companies.put(companyName, "-- " + employeeId);
                }
            }

            command = scan.nextLine();
        }
        companies.entrySet().stream().sorted((a1, a2) -> a1.getKey().compareTo(a2.getKey())).forEach(a -> System.out.printf("%s%n%s%n", a.getKey(), a.getValue()));
    }
}
