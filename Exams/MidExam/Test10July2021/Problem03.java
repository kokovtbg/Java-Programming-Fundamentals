package Exams.MidExam.Test10July2021;

import java.util.*;
import java.util.stream.Collectors;

public class Problem03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> deck1 = Arrays.stream(scan.nextLine().split(":")).collect(Collectors.toList());

        List<String> deck2 = new ArrayList<>();
        String command = scan.nextLine();
        while (!command.equals("Ready")) {
            String[] splitData = command.split(" ");
            if (splitData[0].equals("Add")) {
                String cardName = splitData[1];
                boolean cardInDeck = false;
                for (int i = 0; i < deck1.size(); i++) {
                    if (deck1.get(i).equals(cardName)) {
                        cardInDeck = true;
                        break;
                    }
                }
                if (cardInDeck) {
                    deck2.add(cardName);
                } else {
                    System.out.printf("Card not found.%n");
                }
            }
            if (splitData[0].equals("Insert")) {
                String cardName = splitData[1];
                int index = Integer.parseInt(splitData[2]);
                boolean cardInDeck = false;
                for (int i = 0; i < deck1.size(); i++) {
                    if (deck1.get(i).equals(cardName)) {
                        cardInDeck = true;
                        break;
                    }
                }
                if (cardInDeck && index >= 0 && index < deck1.size()) {
                    deck2.add(index, cardName);
                } else {
                    System.out.printf("Error!%n");
                }
            }
            if (splitData[0].equals("Remove")) {
                String cardName = splitData[1];
                boolean cardInDeck = false;
                for (int i = 0; i < deck2.size(); i++) {
                    if (deck2.get(i).equals(cardName)) {
                        deck2.remove(i);
                        cardInDeck = true;
                        break;
                    }
                }
                if (!cardInDeck) {
                    System.out.printf("Card not found.%n");
                }
            }
            if (splitData[0].equals("Swap")) {
                String cardOne = splitData[1];
                String cardTwo = splitData[2];
                int indexOne = 0;
                int indexTwo = 0;
                for (int i = 0; i < deck2.size(); i++) {
                    if (deck2.get(i).equals(cardOne)) {
                        indexOne = i;
                    }
                    if (deck2.get(i).equals(cardTwo)) {
                        indexTwo = i;
                    }
                }
                deck2.set(indexOne, cardTwo);
                deck2.set(indexTwo, cardOne);
            }
            if (splitData[0].equals("Shuffle")) {
                Collections.reverse(deck2);
            }

            command = scan.nextLine();
        }
        for (int i = 0; i < deck2.size(); i++) {
            System.out.printf("%s ", deck2.get(i));
        }
    }
}
