package Exams.MidExam.Test10July2021;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> biscuits = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());

        String command = scan.nextLine();
        while (!command.equals("No More Money")) {
            String[] splitData = command.split(" ");
            if (splitData[0].equals("OutOfStock")) {
                String biscuit = splitData[1];
                for (int i = 0; i < biscuits.size(); i++) {
                    if (biscuits.get(i).equals(biscuit)) {
                        biscuits.set(i, "None");
                    }
                }
            }
            if (splitData[0].equals("Required")) {
                String biscuit = splitData[1];
                int index = Integer.parseInt(splitData[2]);
                if (index >= 0 && index < biscuits.size()) {
                    if (!biscuits.get(index).equals("None")) {
                        biscuits.set(index, biscuit);
                    }
                }
            }
            if (splitData[0].equals("Last")) {
                String biscuit = splitData[1];
                biscuits.add(biscuit);
            }

            command = scan.nextLine();
        }
        for (int i = 0; i < biscuits.size(); i++) {
            if (!biscuits.get(i).equals("None")) {
                System.out.printf("%s ", biscuits.get(i));
            }
        }
    }
}
