package Lists.exerciseMore;

import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers1 = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> numbers2 = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> numbers3 = new ArrayList<>();
        int[] numbers4 = new int[2];
        if (numbers1.size() > numbers2.size()) {
            for (int i = 0; i < numbers2.size(); i++) {
                numbers3.add(numbers1.get(i));
                numbers3.add(numbers2.get(i));
            }
            numbers4[0] = numbers1.get(numbers1.size() - 2);
            numbers4[1] = numbers1.get(numbers1.size() - 1);
        } else if (numbers2.size() > numbers1.size()) {
            Collections.reverse(numbers2);
            for (int i = 0; i < numbers1.size(); i++) {
                numbers3.add(numbers1.get(i));
                numbers3.add(numbers2.get(i));
            }
            numbers4[0] = numbers2.get(numbers2.size() - 2);
            numbers4[1] = numbers2.get(numbers2.size() - 1);
        }
        if (numbers4[0] > numbers4[1]) {
            int tempInt = numbers4[0];
            numbers4[0] = numbers4[1];
            numbers4[1] = tempInt;
        }
        Collections.sort(numbers3);
        for (Integer integer : numbers3) {
            if (integer > numbers4[0] && integer < numbers4[1]) {
                System.out.printf("%d ", integer);
            }
        }
    }
}
