package AssociativeArrays.lab;

import java.util.*;
import java.util.stream.Collectors;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> sequence = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());

        List<String> sequence2 = new ArrayList<>();
        List<String> sequence3 = new ArrayList<>();
        for (int i = 0; i < sequence.size(); i++) {
            int count = 1;
            boolean existWord = false;
            for (int j = 0; j < sequence3.size(); j++) {
                if (sequence3.get(j).equalsIgnoreCase(sequence.get(i))) {
                    existWord = true;
                    break;
                }
            }
            if (i < sequence.size() - 1) {
                for (int j = i + 1; j < sequence.size(); j++) {
                    if (sequence.get(i).equalsIgnoreCase(sequence.get(j)) && !existWord) {
                        count++;
                    }
                }
            }
            if (count % 2 != 0 && !existWord) {
                sequence2.add(sequence.get(i).toLowerCase(Locale.ROOT));
            }
            sequence3.add(sequence.get(i).toLowerCase(Locale.ROOT));
        }
        for (int i = 0; i < sequence2.size(); i++) {
            if (i < sequence2.size() - 1) {
                System.out.printf("%s, ", sequence2.get(i));
            } else {
                System.out.printf("%s ", sequence2.get(i));
            }
        }
    }
}
