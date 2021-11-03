package Exams.FinalExam.Test03;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, int[]> carsMileageFuel = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String cars = scan.nextLine();
            String[] splitData = cars.split("\\|");
            String carName = splitData[0];
            int mileage = Integer.parseInt(splitData[1]);
            int fuel = Integer.parseInt(splitData[2]);
            int[] mileageFuel = new int[2];
            mileageFuel[0] = mileage;
            mileageFuel[1] = fuel;
            carsMileageFuel.put(carName, mileageFuel);
        }
        String command = scan.nextLine();
        while (!command.equals("Stop")) {
            String[] splitData = command.split(" : ");
            String commandName = splitData[0];
            String car = splitData[1];
            if (commandName.equals("Drive")) {
                int distance = Integer.parseInt(splitData[2]);
                int fuel = Integer.parseInt(splitData[3]);
                if (fuel <= carsMileageFuel.get(car)[1]) {
                    carsMileageFuel.get(car)[0] += distance;
                    carsMileageFuel.get(car)[1] -= fuel;
                    System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);
                } else {
                    System.out.printf("Not enough fuel to make that ride%n");
                }
                if (carsMileageFuel.get(car)[0] >= 100000) {
                    carsMileageFuel.remove(car);
                    System.out.printf("Time to sell the %s!%n", car);
                }
            }
            if (commandName.equals("Refuel")) {
                int fuel = Integer.parseInt(splitData[2]);
                if (carsMileageFuel.get(car)[1] + fuel > 75) {
                    int fuelOver = carsMileageFuel.get(car)[1] + fuel;
                    int count = 0;
                    while (fuelOver > 75) {
                        fuelOver--;
                        count++;
                    }
                    fuel -= count;
                }
                carsMileageFuel.get(car)[1] += fuel;
                System.out.printf("%s refueled with %d liters%n", car, fuel);
            }
            if (commandName.equals("Revert")) {
                int kilometers = Integer.parseInt(splitData[2]);
                if (carsMileageFuel.get(car)[0] - kilometers >= 10000) {
                    carsMileageFuel.get(car)[0] -= kilometers;
                    System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);
                } else {
                    carsMileageFuel.get(car)[0] = 10000;
                }
            }

            command = scan.nextLine();
        }
        carsMileageFuel = carsMileageFuel.entrySet().stream().sorted((a1, a2) -> {
            int mileageA1 = a1.getValue()[0];
            int mileageA2 = a2.getValue()[0];
            int result = Integer.compare(mileageA2, mileageA1);
            if (result == 0) {
                result = a1.getKey().compareTo(a2.getKey());
            }
            return result;
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2) -> a1, LinkedHashMap::new));
        for (Map.Entry<String, int[]> entry : carsMileageFuel.entrySet()) {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", entry.getKey(), entry.getValue()[0], entry.getValue()[1]);
        }
    }
}
