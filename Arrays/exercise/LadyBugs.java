package Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] arrayIndex = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        int[] bugsArray = new int[n];
        for (int i = 0; i < arrayIndex.length; i++) {
            if (arrayIndex[i] == i) {
                bugsArray[i] = 1;
            }
            if (arrayIndex[i] > i) {
                for (int j = 0; j < n; j++) {
                    bugsArray[arrayIndex[i]] = 1;
                }
            }
        }
        String command = scan.nextLine();
        while (!command.equals("end")) {
            String[] bugsCommand = command.split(" ");
            String bugsCommandString = bugsCommand[1];
            String bugsCommandStringInt = bugsCommand[0] + " " + bugsCommand[2];
            int[] bugsCommandArray = Arrays.stream(bugsCommandStringInt.split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
            int bugsFirstCommand = bugsCommandArray[0];
            int bugsSecondCommand = bugsCommandArray[1];
            int count = 0;
            if (bugsSecondCommand < 0) {
                bugsSecondCommand = Math.abs(bugsSecondCommand);
                if (bugsCommandString.equals("left")) {
                    bugsCommandString = "right";
                    count++;
                }
                if (bugsCommandString.equals("right") && count == 0) {
                    bugsCommandString = "left";
                }
            }
            if (bugsCommandString.equals("left")) {
                bugsArray[bugsFirstCommand] = 0;
                for (int i = bugsFirstCommand; i >= 0; i -= bugsSecondCommand) {
                    if (bugsArray[i] == 0 && i != bugsFirstCommand) {
                        bugsArray[i] = 1;
                    }
                }
            }
            if (bugsCommandString.equals("right")) {
                bugsArray[bugsFirstCommand] = 0;
                for (int i = bugsFirstCommand; i < bugsArray.length; i += bugsSecondCommand) {
                    if (bugsArray[i] == 0 && i != bugsFirstCommand) {
                        bugsArray[i] = 1;
                    }
                }

            }
            command = scan.nextLine();
        }
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", bugsArray[i]);
        }
    }
}
