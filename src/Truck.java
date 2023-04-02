public class Truck extends Vehicle  {
    String make;
    String model;
    String vin;
    int year;
    String color;
    String fuelType;

    double maxPayload;

    public double getMaxPayload() {
        return maxPayload;
    }

    public void setMaxPayload(double maxPayload) {
        this.maxPayload = maxPayload;
    }

    public Truck(String make, String model, String vin, int year,
                 String color, String fuelType, double maxPayload) {
        super(make, model,vin, year, color, fuelType);
        this.maxPayload = maxPayload;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "make='" + getMake() + '\'' +
                ", model='" + getModel() + '\'' +
                ", vin='" + getVin() + '\'' +
                ", year=" + getYear() +  '\'' +
                ", color='" + getColor() + '\'' +
                ", fuelType='" + getFuelType() + '\'' +
                ", maxPayload=" + getMaxPayload() +
                '}';
    }
}
