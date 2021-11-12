package Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDonGo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int sum = 0;
        while (numbers.size() > 0) {
            int index = Integer.parseInt(scan.nextLine());
            int numberToRemove = 0;
            if (index < 0) {
                numberToRemove = numbers.get(0);
                numbers.set(0, numbers.get(numbers.size() - 1));
            } else if (index > numbers.size() - 1) {
                numberToRemove = numbers.get(numbers.size() - 1);
                numbers.set(numbers.size() - 1, numbers.get(0));
            } else {
                numberToRemove = numbers.get(index);
            }

            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) <= numberToRemove && i != index) {
                    numbers.set(i, numbers.get(i) + numberToRemove);
                } else if (numbers.get(i) > numberToRemove && i != index) {
                    numbers.set(i, numbers.get(i) - numberToRemove);
                }
            }
            sum += numberToRemove;
            if (index >= 0 && index <= numbers.size() - 1) {
                numbers.remove(index);
            }
        }
        System.out.printf("%d", sum);
    }
}
