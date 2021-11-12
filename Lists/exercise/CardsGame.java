package Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> player1 = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> player2 = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < player1.size(); i++) {
            if (player1.get(i) > player2.get(i)) {
                player1.add(player1.get(i));
                player1.add(player2.get(i));
                player1.remove(i);
                player2.remove(i);
            } else if (player2.get(i) > player1.get(i)) {
                player2.add(player2.get(i));
                player2.add(player1.get(i));
                player2.remove(i);
                player1.remove(i);
            } else {
                player1.remove(i);
                player2.remove(i);
            }
            if (player1.size() == 0 || player2.size() == 0) {
                break;
            }
            i = -1;
        }
        int sum = 0;
        if (player1.size() == 0) {
            for (int i = 0; i < player2.size(); i++) {
                sum += player2.get(i);
            }
        }
        if (player2.size() == 0) {
            for (int i = 0; i < player1.size(); i++) {
                sum += player1.get(i);
            }
        }
        if (player1.size() == 0) {
            System.out.printf("Second player wins! Sum: %d", sum);
        } else {
            System.out.printf("First player wins! Sum: %d", sum);
        }
    }
}
