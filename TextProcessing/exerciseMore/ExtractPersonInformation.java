package TextProcessing.exerciseMore;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Integer> namesAges = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            int startIndexName = 0;
            int endIndexName = 0;
            int startIndexAge = 0;
            int endIndexAge = 0;
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == '@') {
                    startIndexName = j + 1;
                }
                if (input.charAt(j) == '|') {
                    endIndexName = j;
                }
                if (input.charAt(j) == '#') {
                    startIndexAge = j + 1;
                }
                if (input.charAt(j) == '*') {
                    endIndexAge = j;
                }
            }
            String name = input.substring(startIndexName, endIndexName);
            int age = Integer.parseInt(input.substring(startIndexAge, endIndexAge));
            namesAges.put(name, age);
        }
        for (Map.Entry<String, Integer> entry : namesAges.entrySet()) {
            System.out.printf("%s is %d years old.%n", entry.getKey(), entry.getValue());
        }
    }
}
