public class FishFeeder {
    private String manufacturer;
    private String model;
    private int meals;

    public FishFeeder(String manufacturer, String model, int meals) {
        this.manufacturer = manufacturer;
        this.model = model;
        setMeals(meals); // Use the setter for validation
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

    public int getMeals() {
        return meals;
    }

    public void setMeals(int meals) {
        if (meals < 0) {
            throw new IllegalArgumentException("Meals cannot be negative.");
        }
        this.meals = meals;
    }

    @Override
    public String toString() {
        return "FishFeeder [manufacturer=" + manufacturer + ", model=" + model + ", meals=" + meals + "]";
    }

    public String feed() {
        if (meals > 0) {
            meals--; // Decrease meals after feeding
            return "Feeding fish..."; // Just indicating that fish are being fed
        } else {
            return "No meals left to feed.";
        }
    }

    public String fillup(int additionalMeals) {
        if (additionalMeals < 0) {
            throw new IllegalArgumentException("Cannot add negative meals.");
        }
        meals += additionalMeals;
        return "Filling up fish feeder. Current meals: " + meals;
    }
}
