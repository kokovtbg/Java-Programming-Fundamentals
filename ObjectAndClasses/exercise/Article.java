package ObjectAndClasses.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Article {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] article = scan.nextLine().split(", ");
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String command = scan.nextLine();
            String[] commandData = command.split(": ");
            if (commandData[0].equals("Edit")) {
                article[1] = commandData[1];
            }
            if (commandData[0].equals("ChangeAuthor")) {
                article[2] = commandData[1];
            }
            if (commandData[0].equals("Rename")) {
                article[0] = commandData[1];
            }
        }
        System.out.printf("%s - %s: %s", article[0], article[1], article[2]);
    }
}
