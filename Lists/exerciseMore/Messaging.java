package Lists.exerciseMore;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scan.nextLine();

        String message = "";
        for (int i = 0; i < numbers.size(); i++) {
            int sum = 0;
            int number = numbers.get(i);
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
            int count = 0;
            if (sum > input.length() - 1) {
                while (sum > input.length() - 1) {
                    sum -= input.length() - 1;
                    count++;
                }
            }
            if (count > 0) {
                sum--;
            }
            message += input.charAt(sum);
            input = input.substring(0, sum) + input.substring(sum + 1);
        }
        System.out.println(message);
    }
}
