package Lists.lab;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Double> numbersList = Arrays.stream(scan.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());

        for (int i = 0; i < numbersList.size() - 1; i++) {
            if (numbersList.get(i).equals(numbersList.get(i + 1))) {
                double sum = numbersList.get(i) + numbersList.get(i + 1);
                numbersList.set(i, sum);
                numbersList.remove(i + 1);
                i = -1;
            }
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.#");
        for (int i = 0; i < numbersList.size(); i++) {
            System.out.print(decimalFormat.format(numbersList.get(i)) + " ");
        }
    }
}
