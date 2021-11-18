package ObjectAndClasses.exerciseMore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainCarEngine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<Engine> engines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] splitData = scan.nextLine().split(" ");
            String engineModel = splitData[0];
            int enginePower = Integer.parseInt(splitData[1]);
            String engineDisplacement = "";
            String engineEfficiency = "";
            if (splitData.length == 2) {
                engineDisplacement = "n/a";
                engineEfficiency = "n/a";
            }
            if (splitData.length == 3 && splitData[2].charAt(0) >= '0' && splitData[2].charAt(0) <= '9') {
                engineDisplacement = splitData[2];
                engineEfficiency = "n/a";
            }
            if (splitData.length == 3 && splitData[2].charAt(0) >= 'A' && splitData[2].charAt(0) <= 'Z') {
                engineDisplacement = "n/a";
                engineEfficiency = splitData[2];
            }
            if (splitData.length == 4) {
                engineDisplacement = splitData[2];
                engineEfficiency = splitData[3];
            }
            Engine engine = new Engine(engineModel, enginePower, engineDisplacement, engineEfficiency);
            engine.setEngineModel(engineModel);
            engine.setEnginePower(enginePower);
            engine.setEngineDisplacement(engineDisplacement);
            engine.setEngineEfficiency(engineEfficiency);

            engines.add(engine);
        }
        int m = Integer.parseInt(scan.nextLine());
        List<CarEngine> cars = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] splitData = scan.nextLine().split(" ");
            String carModel = splitData[0];
            String engineModel = splitData[1];
            String weight = "";
            String color = "";
            if (splitData.length == 2) {
                weight = "n/a";
                color = "n/a";
            }
            if (splitData.length == 3 && splitData[2].charAt(0) >= '0' && splitData[2].charAt(0) <= '9') {
                weight = splitData[2];
                color = "n/a";
            }
            if (splitData.length == 3 && splitData[2].charAt(0) >= 'A' && splitData[2].charAt(0) <= 'Z') {
                weight = "n/a";
                color = splitData[2];
            }
            if (splitData.length == 4) {
                weight = splitData[2];
                color = splitData[3];
            }
            int enginePower = 0;
            String engineDisplacement = "";
            String engineEfficiency = "";

            CarEngine car = new CarEngine(carModel, engineModel, weight, color, enginePower, engineDisplacement, engineEfficiency);

            car.setCarModel(carModel);
            for (int j = 0; j < n; j++) {
                if (engineModel.equals(engines.get(j).getEngineModel())) {
                    enginePower = engines.get(j).getEnginePower();
                    engineDisplacement = engines.get(j).getEngineDisplacement();
                    engineEfficiency = engines.get(j).getEngineEfficiency();
                    car.setEngineModel(engineModel);
                    car.setEnginePower(enginePower);
                    car.setEngineDisplacement(engineDisplacement);
                    car.setEngineEfficiency(engineEfficiency);
                }
            }
            car.setWeight(weight);
            car.setColor(color);

            cars.add(car);
        }
        for (int i = 0; i < cars.size(); i++) {
            System.out.printf("%s:%n", cars.get(i).getCarModel());
            System.out.printf("\t%s:%n", cars.get(i).getEngineModel());
            System.out.printf("\t\tPower: %d%n", cars.get(i).getEnginePower());
            System.out.printf("\t\tDisplacement: %s%n", cars.get(i).getEngineDisplacement());
            System.out.printf("\t\tEfficiency: %s%n", cars.get(i).getEngineEfficiency());
            System.out.printf("\tWeight: %s%n", cars.get(i).getWeight());
            System.out.printf("\tColor: %s%n", cars.get(i).getColor());
        }
    }
}
