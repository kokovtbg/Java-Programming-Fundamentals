package ObjectAndClasses.exerciseMore;

public class CarEngine {
    private String carModel;
    private String engineModel;
    private String weight;
    private String color;
    private int enginePower;
    private String engineDisplacement;
    private String engineEfficiency;

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public void setEngineModel(String engineModel) {
        this.engineModel = engineModel;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public String getEngineDisplacement() {
        return engineDisplacement;
    }

    public void setEngineDisplacement(String engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }

    public String getEngineEfficiency() {
        return engineEfficiency;
    }

    public void setEngineEfficiency(String engineEfficiency) {
        this.engineEfficiency = engineEfficiency;
    }

    public CarEngine(String carModel, String engineModel, String weight, String color, int enginePower, String engineDisplacement, String engineEfficiency) {
        this.carModel = carModel;
        this.engineModel = engineModel;
        this.weight = weight;
        this.color = color;
        this.enginePower = enginePower;
        this.engineDisplacement = engineDisplacement;
        this.engineEfficiency = engineEfficiency;
    }
}
