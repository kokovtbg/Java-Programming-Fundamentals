package AssociativeArrays.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> resourcesQuantity = new LinkedHashMap<>();

        String resource = scan.nextLine();
        while (!resource.equals("stop")) {
            int quantity = Integer.parseInt(scan.nextLine());

            if (resourcesQuantity.containsKey(resource)) {
                resourcesQuantity.put(resource, resourcesQuantity.get(resource) + quantity);
            } else {
                resourcesQuantity.put(resource, quantity);
            }

            resource = scan.nextLine();
        }
        resourcesQuantity.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
