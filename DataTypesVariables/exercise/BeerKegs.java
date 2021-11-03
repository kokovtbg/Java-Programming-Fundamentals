package DataTypesVariables.exercise;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        //1 input -> model, radius, height
        //2 volume
        //3 Max volume
        double biggestVolume = Double.MIN_VALUE;
        String biggestModel = "";
        for (int i = 1; i <= n; i++) {
            String model = scan.nextLine(); // Модел на кега
            double radius = Double.parseDouble(scan.nextLine()); // Радиус
            int height = Integer.parseInt(scan.nextLine()); // Височина
            double volume = Math.PI * radius * radius * height; // Обем
            // Проверка дали обемът е Максимален
            if (volume > biggestVolume) {
                biggestVolume = volume;
                biggestModel = model;
            }
        }
        System.out.printf("%s", biggestModel);
    }
}
