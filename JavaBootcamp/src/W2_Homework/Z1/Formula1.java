package W2_Homework.Z1;

public class Formula1 {
    private String brand;
    private String driverName;

    public Formula1(String brand, String driverName) {
        this.brand = brand;
        this.driverName = driverName;
    }

    public String getBrand() {
        return brand;
    }

    public String getDriverName() {
        return driverName;
    }

    @Override
    public String toString() {
        return "Formula1{" +
                "brand='" + brand + '\'' +
                ", driverName='" + driverName + '\'' +
                '}';
    }
}
