package ObjectAndClasses.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainVehicle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        List<Vehicle> vehicles = new ArrayList<>();

        while (!"End".equals(command)) {
            vehicles.add(new Vehicle(command));
            command = scan.nextLine();
        }

        command = scan.nextLine();
        while (!"Close the Catalogue".equals(command)) {
            String model = command;
            vehicles.stream().filter(x->x.getModel().equals(model))
                    .forEach(x-> System.out.println(x));

            command = scan.nextLine();
        }

        System.out.printf("Cars have average horsepower of: %.2f.\n"
                , calculateAverageHorsePower(vehicles, "car"));
        System.out.printf("Trucks have average horsepower of: %.2f.\n"
                , calculateAverageHorsePower(vehicles, "truck"));

    }

    private static double calculateAverageHorsePower(List<Vehicle> vehicles, String type) {
        var vehiclesHorsePowers = vehicles.stream().filter(x -> x.getType().equals(type)).mapToInt(x -> x.getHorsePowers()).toArray();
        int sum = Arrays.stream(vehiclesHorsePowers).sum();
        return (vehiclesHorsePowers.length == 0) ? 0: sum / (double) vehiclesHorsePowers.length;
    }
}
