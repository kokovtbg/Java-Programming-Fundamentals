package AssociativeArrays.lab;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        double[] nums = Arrays.stream(input).mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> numbers = new TreeMap<>();
        for (double number : nums) {
            if (!numbers.containsKey(number)) {
                numbers.put(number, 1);
            } else {
                int occurrences = numbers.get(number);
                occurrences++;
                numbers.put(number, occurrences);
            }
        }
        for (Map.Entry<Double, Integer> entry : numbers.entrySet()) {
            System.out.printf("%s -> %d%n", Math.round(entry.getKey()), entry.getValue());
        }
    }
}
