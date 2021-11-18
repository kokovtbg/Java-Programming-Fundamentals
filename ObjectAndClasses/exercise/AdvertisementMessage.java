package ObjectAndClasses.exercise;

import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        String[] events = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            int pos1 = rnd.nextInt(phrases.length);
            String tempWord1 = phrases[i];
            phrases[i] = phrases[pos1];
            phrases[pos1] = tempWord1;
            int pos2 = rnd.nextInt(events.length);
            String tempWord2 = events[i];
            events[i] = events[pos2];
            phrases[pos2] = tempWord2;
            int pos3 = rnd.nextInt(authors.length);
            String tempWord3 = authors[i];
            authors[i] = authors[pos3];
            authors[pos3] = tempWord3;
            int pos4 = rnd.nextInt(cities.length);
            String tempWord4 = cities[i];
            cities[i] = cities[pos4];
            cities[pos4] = tempWord4;
            System.out.printf("%s %s %s – %s%n", phrases[i], events[i], authors[i], cities[i]);
        }
    }
}
