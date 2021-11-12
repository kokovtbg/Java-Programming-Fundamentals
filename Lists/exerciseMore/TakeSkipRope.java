package Lists.exerciseMore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String encryptedMessage = scan.nextLine();

        String digits = encryptedMessage.replaceAll("[^0-9]", "");
        int count = 0;
        if (digits.charAt(0) == '0') {
            count++;
        }
        long numbersInt = Long.parseLong(digits);
        List<Integer> numbers = new ArrayList<>();
        while (numbersInt > 0) {
            numbers.add((int) (numbersInt % 10));
            numbersInt /= 10;
        }
        if (count > 0) {
            numbers.add(0);
        }
        Collections.reverse(numbers);
        String nonNumbersString = encryptedMessage.replaceAll("[0-9]", "");
        List<Character> nonNumbers = new ArrayList<>();
        for (int i = 0; i < nonNumbersString.length(); i++) {
            nonNumbers.add(nonNumbersString.charAt(i));
        }
        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(numbers.get(i));
            } else {
                skipList.add(numbers.get(i));
            }
        }
        String decryptedMessage = "";
        for (int i = 0; i < takeList.size(); i++) {
            for (int j = 0; j < takeList.get(i); j++) {
                decryptedMessage += nonNumbers.get(j);
                if (j == nonNumbers.size() - 1) {
                    break;
                }
            }
            if (takeList.get(i) > nonNumbers.size() - 1) {
                takeList.set(i, nonNumbers.size() - 1);
            }
            for (int j = takeList.get(i) + skipList.get(i) - 1; j >= 0; j--) {
                nonNumbers.remove(j);
            }

        }
        System.out.println(decryptedMessage);
    }
}
