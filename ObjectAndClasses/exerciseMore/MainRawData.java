package ObjectAndClasses.exerciseMore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainRawData {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<RawData> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] splitData = scan.nextLine().split(" ");
            String model = splitData[0];
            int engineSpeed = Integer.parseInt(splitData[1]);
            int enginePower = Integer.parseInt(splitData[2]);
            int cargoWeight = Integer.parseInt(splitData[3]);
            String cargoType = splitData[4];
            double tire1Pressure = Double.parseDouble(splitData[5]);
            int tire1Age = Integer.parseInt(splitData[6]);
            double tire2Pressure = Double.parseDouble(splitData[7]);
            int tire2Age = Integer.parseInt(splitData[8]);
            double tire3Pressure = Double.parseDouble(splitData[9]);
            int tire3Age = Integer.parseInt(splitData[10]);
            double tire4Pressure = Double.parseDouble(splitData[11]);
            int tire4Age = Integer.parseInt(splitData[12]);

            RawData car = new RawData(model, engineSpeed, enginePower, cargoWeight, cargoType, tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);
            car.setModel(model);
            car.setEngineSpeed(engineSpeed);
            car.setEnginePower(enginePower);
            car.setCargoWeight(cargoWeight);
            car.setCargoType(cargoType);
            car.setTire1Pressure(tire1Pressure);
            car.setTire1Age(tire1Age);
            car.setTire2Pressure(tire2Pressure);
            car.setTire2Age(tire2Age);
            car.setTire3Pressure(tire3Pressure);
            car.setTire3Age(tire3Age);
            car.setTire4Pressure(tire4Pressure);
            car.setTire4Age(tire4Age);

            cars.add(car);
        }
        String command = scan.nextLine();
        if (command.equals("fragile")) {
            for (int i = 0; i < cars.size(); i++) {
                if (cars.get(i).getCargoType().equals("fragile")) {
                    if (cars.get(i).getTire1Pressure() < 1 || cars.get(i).getTire2Pressure() < 1 || cars.get(i).getTire3Pressure() < 1 || cars.get(i).getTire4Pressure() < 1) {
                        System.out.println(cars.get(i).getModel());
                    }
                }
            }
        } else if (command.equals("flamable")) {
            for (int i = 0; i < cars.size(); i++) {
                if (cars.get(i).getCargoType().equals("flamable")) {
                    if (cars.get(i).getEnginePower() > 250) {
                        System.out.println(cars.get(i).getModel());
                    }
                }
            }
        }
    }
}
