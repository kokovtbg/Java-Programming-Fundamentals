package AssociativeArrays.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WordFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> words = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());

        words = words.stream().filter(x -> x.length() % 2 == 0).collect(Collectors.toList());
        for (int i = 0; i < words.size(); i++) {
            System.out.printf("%s%n", words.get(i));
        }
    }
}
