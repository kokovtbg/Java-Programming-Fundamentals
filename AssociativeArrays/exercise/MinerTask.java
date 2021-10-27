package AssociativeArrays.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, Integer> mapMiner = new LinkedHashMap<>();
        int count = 0;
        String resource = "";
        String command = scan.nextLine();
        while (!command.equals("stop")) {
            count++;
            if (count % 2 != 0) {
                resource = command;
                if (!mapMiner.containsKey(resource)) {
                    mapMiner.put(command, 0);
                }
            } else {
                int quantity = Integer.parseInt(command);
                if (mapMiner.containsKey(resource)) {
                    mapMiner.put(resource, mapMiner.get(resource) + quantity);
                }
            }

            command = scan.nextLine();
        }
        for (Map.Entry<String, Integer> entry : mapMiner.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
