public class AquariumController {
    private String manufacturer;
    private String model;
    private float currentTime;
    private FishFeeder fishFeeder;

    public AquariumController(String manufacturer, String model, float currentTime, FishFeeder fishFeeder) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
        this.fishFeeder = fishFeeder;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
    }

    public FishFeeder getFishFeeder() {
        return fishFeeder;
    }

    public void setFishFeeder(FishFeeder fishFeeder) {
        this.fishFeeder = fishFeeder;
    }

    @Override
    public String toString() {
        return "AquariumController [manufacturer=" + manufacturer + ", model=" + model + ", currentTime=" + currentTime
                + "]";
    }
}
