package Exams.FinalExam.Test01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, String[]> piecesComposerKey = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] splitData = scan.nextLine().split("\\|");
            String pieceName = splitData[0];
            String composer = splitData[1];
            String key = splitData[2];
            String[] composerKey = new String[2];
            composerKey[0] = composer;
            composerKey[1] = key;
            piecesComposerKey.put(pieceName, composerKey);
        }
        String command = scan.nextLine();
        while (!command.equals("Stop")) {
            String[] splitData = command.split("\\|");
            String commandName = splitData[0];
            if (commandName.equals("Add")) {
                String piece = splitData[1];
                String composer = splitData[2];
                String key = splitData[3];
                if (!piecesComposerKey.containsKey(piece)) {
                    String[] composerKey = new String[2];
                    composerKey[0] = composer;
                    composerKey[1] = key;
                    piecesComposerKey.put(piece, composerKey);
                    System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                } else {
                    System.out.printf("%s is already in the collection!%n", piece);
                }
            }
            if (commandName.equals("Remove")) {
                String piece = splitData[1];
                if (piecesComposerKey.containsKey(piece)) {
                    piecesComposerKey.remove(piece);
                    System.out.printf("Successfully removed %s!%n", piece);
                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                }
            }
            if (commandName.equals("ChangeKey")) {
                String piece = splitData[1];
                String keyNew = splitData[2];
                if (piecesComposerKey.containsKey(piece)) {
                    String[] composerKey = piecesComposerKey.get(piece);
                    composerKey[1] = keyNew;
                    System.out.printf("Changed the key of %s to %s!%n", piece, keyNew);
                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                }
            }

            command = scan.nextLine();
        }
        for (Map.Entry<String, String[]> entry : piecesComposerKey.entrySet()) {
            System.out.printf("%s -> Composer: %s, Key: %s%n", entry.getKey(), entry.getValue()[0], entry.getValue()[1]);
        }
    }
}
