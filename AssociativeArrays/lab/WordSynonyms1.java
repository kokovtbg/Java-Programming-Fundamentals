package AssociativeArrays.lab;

import java.util.*;

public class WordSynonyms1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, List<String>> wordsSynonyms = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String word = scan.nextLine();
            String synonym = scan.nextLine();
            List<String> synonymsForCurrentWord;
            if (!wordsSynonyms.containsKey(word)) {
                synonymsForCurrentWord = new ArrayList<>();
            } else {
                synonymsForCurrentWord = wordsSynonyms.get(word);
            }
            synonymsForCurrentWord.add(synonym);
            wordsSynonyms.put(word, synonymsForCurrentWord);
        }
        for (Map.Entry<String, List<String>> entry : wordsSynonyms.entrySet()) {
            String currentWord = entry.getKey();
            List<String> synonymsForCurrentWord = entry.getValue();
            System.out.printf("%s - %s%n", currentWord, String.join(", ", synonymsForCurrentWord));
        }
    }
}
