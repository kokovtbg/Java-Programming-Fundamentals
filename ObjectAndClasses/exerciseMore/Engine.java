package ObjectAndClasses.exerciseMore;

public class Engine {
    private String engineModel;
    private int enginePower;
    private String engineDisplacement;
    private String engineEfficiency;

    public String getEngineModel() {
        return engineModel;
    }

    public void setEngineModel(String engineModel) {
        this.engineModel = engineModel;
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

    public Engine(String engineModel, int enginePower, String engineDisplacement, String engineEfficiency) {
        this.engineModel = engineModel;
        this.enginePower = enginePower;
        this.engineDisplacement = engineDisplacement;
        this.engineEfficiency = engineEfficiency;
    }
}
