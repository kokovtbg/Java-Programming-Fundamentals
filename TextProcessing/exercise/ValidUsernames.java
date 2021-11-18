package TextProcessing.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] splitData = scan.nextLine().split(", ");
        List<String> validUsernames = new ArrayList<>();
        for (int i = 0; i < splitData.length; i++) {
            boolean correctUsername = true;
            if (splitData[i].length() < 3 || splitData[i].length() > 16) {
                correctUsername = false;
            } else {
                for (int j = 0; j < splitData[i].length(); j++) {
                    if (splitData[i].charAt(j) < '0' && splitData[i].charAt(j) != '-') {
                        correctUsername = false;
                        break;
                    }
                    if (splitData[i].charAt(j) > '9' && splitData[i].charAt(j) < 'A') {
                        correctUsername = false;
                        break;
                    }
                    if (splitData[i].charAt(j) > 'Z' && splitData[i].charAt(j) < 'a' && splitData[i].charAt(j) != '_') {
                        correctUsername = false;
                        break;
                    }
                    if (splitData[i].charAt(j) > 'z') {
                        correctUsername = false;
                    }
                }
            }
            if (correctUsername) {
                validUsernames.add(splitData[i]);
            }
        }
        for (int i = 0; i < validUsernames.size(); i++) {
            System.out.printf("%s%n", validUsernames.get(i));
        }
    }
}
