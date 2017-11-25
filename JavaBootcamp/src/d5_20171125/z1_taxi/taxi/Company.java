package d5_20171125.z1_taxi.taxi;

import static d5_20171125.z1_taxi.taxi.Coordinates.calculateDistance;

/**
 * Created: 25.11.17.
 */
public class Company {
    private Car[] carTable;
    private int availableCars;

    public Company(Car[] carTable) {
        this.carTable = carTable;
        this.availableCars = countAvailableCars();
    }

    private Car getClosestCar(Coordinates customerCoordinates) {
        double minDistance = Double.MAX_VALUE;
        Car closestCar = null;
        if (availableCars == 0) {
            return null;
        } else {
            for (Car car : carTable) {
                if (car.isAvailable()) {
                    double distance = calculateDistance(customerCoordinates, car.getCarCoordinates());
                    if (distance < minDistance) {
                        minDistance = distance;
                        closestCar = car;
                    }
                }
            }
        }
        return closestCar;
    }

    public Trip callTaxi(Customer customer) {
        Trip trip = null;
        if (availableCars > 0) {
            Coordinates custCoords = customer.getCustomerCoordinates();
            Car car = getClosestCar(custCoords);
            trip = new Trip(customer, car);
            car.setBusy();
//            car.setCarCoordinates(custCoords);
            updateAvailableCars();
        } else {
            trip = new Trip(customer, null);
        }
        return trip;
    }

    public int countAvailableCars() {
        int count = 0;
        for (Car car : carTable) {
            if (car.isAvailable())
                count++;
        }
        return count;
    }

    private void updateAvailableCars() {
        availableCars = countAvailableCars();
    }

}
