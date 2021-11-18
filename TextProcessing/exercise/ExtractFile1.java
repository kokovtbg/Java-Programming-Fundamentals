package TextProcessing.exercise;

import java.util.Scanner;

public class ExtractFile1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] path = scan.nextLine().split("\\\\");
        String fullFileName = path[path.length - 1];
        String[] fullFileNameArr = fullFileName.split("\\.");
        String filename = fullFileNameArr[0];
        String extension = fullFileNameArr[1];
        System.out.printf("File name: %s%n", filename);
        System.out.printf("File extension: %s", extension);
    }
}
