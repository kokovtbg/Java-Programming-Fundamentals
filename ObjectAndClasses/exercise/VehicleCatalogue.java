package ObjectAndClasses.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue {
    private String typeOfVehicle;
    private String model;
    private String color;
    private int horsepower;

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(String typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public VehicleCatalogue(String typeOfVehicle, String model, String color, int horsepower) {
        this.typeOfVehicle = typeOfVehicle;
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        List<VehicleCatalogue> cars = new ArrayList<>();
        int sumHorsePowerCars = 0;
        int sumHorsePowerTrucks = 0;
        int countCars = 0;
        int countTrucks = 0;
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String typeVehicle = data[0];
            String model = data[1];
            String color = data[2];
            int horsepower = Integer.parseInt(data[3]);

            typeVehicle = typeVehicle.substring(0, 1).toUpperCase() + typeVehicle.substring(1).toLowerCase();

            VehicleCatalogue car = new VehicleCatalogue(typeVehicle, model, color, horsepower);
            car.setTypeOfVehicle(typeVehicle);
            car.setModel(model);
            car.setColor(color);
            car.setHorsepower(horsepower);

            cars.add(car);
            if (typeVehicle.equals("Car")) {
                sumHorsePowerCars += horsepower;
                countCars++;
            }
            if (typeVehicle.equals("Truck")) {
                sumHorsePowerTrucks += horsepower;
                countTrucks++;
            }

            input = scan.nextLine();
        }
        String models = scan.nextLine();
        while (!models.equals("Close the Catalogue")) {
            for (VehicleCatalogue car : cars) {
                if (car.getModel().equals(models)) {
                    System.out.printf("Type: %s\n" +
                            "Model: %s\n" +
                            "Color: %s\n" +
                            "Horsepower: %d\n", car.getTypeOfVehicle(), car.getModel(), car.getColor(), car.getHorsepower());
                    break;
                }
            }

            models = scan.nextLine();
        }
        if (countCars != 0 && countTrucks != 0) {
            System.out.printf("Cars have average horsepower of: %.2f.\n" +
                    "Trucks have average horsepower of: %.2f.\n", sumHorsePowerCars * 1.0 / countCars, sumHorsePowerTrucks * 1.0 / countTrucks);
        } else if (countCars == 0 && countTrucks != 0){
            System.out.printf("Cars have average horsepower of: 0.00.%n");
            System.out.printf("Trucks have average horsepower of: %.2f.", sumHorsePowerTrucks * 1.0 / countTrucks);
        } else if (countCars != 0 && countTrucks == 0) {
            System.out.printf("Cars have average horsepower of: %.2f.%n", sumHorsePowerCars * 1.0 / countCars);
            System.out.printf("Trucks have average horsepower of: 0.00.%n");
        } else if (countCars == 0 && countTrucks == 0){
            System.out.printf("Cars have average horsepower of: 0.00.%n");
            System.out.printf("Trucks have average horsepower of: 0.00.%n");
        }
    }
}
