package d5_20171125.z1_taxi.taxi;

/**
 * Created: 25.11.17.
 */
public class Trip {
    private Customer customer;
    private Car car;

    public Trip(Customer customer, Car car) {
        this.customer = customer;
        this.car = car;
    }

    public void printTripParameters() {
        if(car==null){
            System.out.println("No cars available.");
        } else {
            System.out.printf("Customer: %s\nDriver: %s\nRoad: [%s,%s]->[%s,%s]\n\n",
                    customer.getCustomerName(),
                    car.getDriversName(),
                    car.getCarCoordinates().getX(),
                    car.getCarCoordinates().getY(),
                    customer.getCustomerCoordinates().getX(),
                    customer.getCustomerCoordinates().getY()
            );
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public Car getCar() {
        return car;
    }
}
