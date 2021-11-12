package Lists.exerciseMore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double savings = Double.parseDouble(scan.nextLine());
        List<Integer> drumSet = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> drumSetToManipulate = new ArrayList<>();
        for (int i = 0; i < drumSet.size(); i++) {
            drumSetToManipulate.add(drumSet.get(i));
        }
        String input = scan.nextLine();
        while (!input.equals("Hit it again, Gabsy!")) {
            int hitPower = Integer.parseInt(input);
            for (int i = 0; i < drumSetToManipulate.size(); i++) {
                drumSetToManipulate.set(i, drumSetToManipulate.get(i) - hitPower);
                if (drumSetToManipulate.get(i) <= 0) {
                    if (savings >= drumSet.get(i) * 3) {
                        savings -= drumSet.get(i) * 3;
                        drumSetToManipulate.set(i, drumSet.get(i));
                    } else {
                        drumSetToManipulate.remove(i);
                        drumSet.remove(i);
                        i--;
                    }
                }
            }

            input = scan.nextLine();
        }
        for (int i = 0; i < drumSetToManipulate.size(); i++) {
            System.out.printf("%d ", drumSetToManipulate.get(i));
        }
        System.out.println("");
        System.out.printf("Gabsy has %.2flv.", savings);
    }
}
