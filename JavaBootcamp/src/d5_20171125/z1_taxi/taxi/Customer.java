package d5_20171125.z1_taxi.taxi;

/**
 * Created: 25.11.17.
 */
public class Customer {
    private String customerName;
    private Coordinates customerCoordinates;

    public Customer(String customerName, Coordinates customerCoordinates) {

        this.customerName = customerName;
        this.customerCoordinates = customerCoordinates;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Coordinates getCustomerCoordinates() {
        return customerCoordinates;
    }
}
