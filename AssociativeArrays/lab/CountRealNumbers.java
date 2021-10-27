package AssociativeArrays.lab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> counts = new TreeMap<>();
        for (double num : numbers) {
            if (!counts.containsKey(num)) {
                counts.put(num, 0);
            }
            counts.put(num, counts.get(num) + 1);
        }
        for (Map.Entry<Double, Integer> entry : counts.entrySet()) {
            DecimalFormat decimalFormat = new DecimalFormat("#.#######");
            System.out.printf("%s -> %d%n", decimalFormat.format(entry.getKey()), entry.getValue());
        }
    }
}
