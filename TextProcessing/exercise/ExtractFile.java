package TextProcessing.exercise;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] path = scan.nextLine().split("\\\\");
        String filename = "";
        String extension = "";
        for (int i = 0; i < path.length; i++) {
            if (path[i].contains(".")) {
                for (int j = 0; j < path[i].length(); j++) {
                    if (path[i].charAt(j) == '.') {
                        filename = path[i].substring(0, j);
                        extension = path[i].substring(j + 1);
                    }
                }
            }
        }
        System.out.printf("File name: %s%n", filename);
        System.out.printf("File extension: %s", extension);
    }
}
