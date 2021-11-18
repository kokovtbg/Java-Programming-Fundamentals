package TextProcessing.exerciseMore;

import java.util.*;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<String, String> treasureCoordinate = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equals("find")) {
            String decryptedText = "";
            List<String> listText = new ArrayList<>();
            int currentIndex = 0;
            for (int i = 0; i < input.length(); i++) {
                if (i % numbers.length == 0 && i != 0) {
                    listText.add(input.substring(currentIndex, i));
                    currentIndex = i;
                }
            }
            listText.add(input.substring(currentIndex));
            for (int i = 0; i < listText.size(); i++) {
                for (int j = 0; j < listText.get(i).length(); j++) {
                    decryptedText += (char) (listText.get(i).charAt(j) - numbers[j]);
                }
            }
            String treasureType = "";
            String coordinates = "";
            int startIndexTreasure = 0;
            int startIndexCoordinates = 0;
            boolean hasTreasure = false;
            for (int i = 0; i < decryptedText.length(); i++) {
                if (!hasTreasure && decryptedText.charAt(i) == '&') {
                    startIndexTreasure = i + 1;
                    hasTreasure = true;
                    i++;
                }
                if (hasTreasure && decryptedText.charAt(i) == '&') {
                    treasureType = decryptedText.substring(startIndexTreasure, i);
                }
                if (decryptedText.charAt(i) == '<') {
                    startIndexCoordinates = i + 1;
                }
                if (decryptedText.charAt(i) == '>') {
                    coordinates = decryptedText.substring(startIndexCoordinates, i);
                }
            }
            treasureCoordinate.put(treasureType, coordinates);
            input = scan.nextLine();
        }
        for (Map.Entry<String, String> entry : treasureCoordinate.entrySet()) {
            System.out.printf("Found %s at %s%n", entry.getKey(), entry.getValue());
        }
    }
}
