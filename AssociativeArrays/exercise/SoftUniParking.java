package AssociativeArrays.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        LinkedHashMap<String, String> parking = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String command = scan.nextLine();
            String[] splitData = command.split(" ");
            String user = splitData[1];
            if (splitData[0].equals("register")) {
                String licensePlateNumber = splitData[2];
                if (parking.containsKey(user)) {
                    System.out.printf("ERROR: already registered with plate number %s%n", licensePlateNumber);
                } else {
                    parking.put(user, licensePlateNumber);
                    System.out.printf("%s registered %s successfully%n", user, licensePlateNumber);
                }
            }
            if (splitData[0].equals("unregister")) {
                if (!parking.containsKey(user)) {
                    System.out.printf("ERROR: user %s not found%n", user);
                } else {
                    parking.remove(user);
                    System.out.printf("%s unregistered successfully%n", user);
                }
            }
        }
        for (Map.Entry<String, String> entry : parking.entrySet()) {
            System.out.printf("%s => %s%n", entry.getKey(), entry.getValue());
        }
    }
}
