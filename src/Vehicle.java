public class Vehicle {

    private String make;
    private String model;
    private String vin;
    private int year;
    private String color;
    private String fuelType;

    public Vehicle(String make, String model, String vin, int year, String color, String fuelType) {
        this.make = make;
        this.model = model;
        this.vin = vin;
        this.year = year;
        this.color = color;
        this.fuelType = fuelType;
    }


    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}
