package d5_20171125.z1_taxi.taxi;

/**
 * Created: 25.11.17.
 */
public class Car {
    private String carId;
    private String driversName;
    private String carMake;
    private boolean isAvailable;
    private Coordinates carCoordinates;

    public Car(String carId, String driversName, String carMake) {
        this.carId = carId;
        this.driversName = driversName;
        this.carMake = carMake;
        this.isAvailable=true;
        this.carCoordinates = new Coordinates(50,50);
    }

    public String getCarId() {
        return carId;
    }

    public String getDriversName() {
        return driversName;
    }

    public String getCarMake() {
        return carMake;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Coordinates getCarCoordinates() {
        return carCoordinates;
    }

    public void setAvailable() {
        isAvailable = true;
    }

    public void setBusy() {
        isAvailable = false;
    }

    public void setCarCoordinates(Coordinates carCoordinates) {
        this.carCoordinates = carCoordinates;
    }

}
