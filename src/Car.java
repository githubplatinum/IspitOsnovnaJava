public class Car extends Vehicle {
    private String make;

    private  static String model;
    private String vin;
    private int year;
    private  String color;
    private  String fuelType;

    private int doorNumber;
    private  String bodyStyle;


    public Car(String make,
               String model,
               String vin,
               int year,
               String color,
               String fuelType,
               int doorNumber,
               String bodyStyle) {
        super(make, model, vin, year, color, fuelType);
        this.doorNumber = doorNumber;
        this.bodyStyle = bodyStyle;
    }

    public int getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(int doorNumber) {
        this.doorNumber = doorNumber;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + getMake() + '\'' +
                ", vin='" + getVin() + '\'' +
                ", year=" + getYear() +
                ", color='" + getColor() + '\'' +
                ", fuelType='" + getFuelType() + '\'' +
                ", doorNumber=" + getDoorNumber() +
                ", bodyStyle='" + getBodyStyle() + '\'' +
                '}';
    }
}
