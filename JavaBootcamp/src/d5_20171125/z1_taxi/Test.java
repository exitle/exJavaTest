package d5_20171125.z1_taxi;

import d5_20171125.z1_taxi.taxi.*;

/**
 * Created: 25.11.17.
 */
public class Test {
    public static void main(String[] args) {
        Car[] carTable = new Car[3];
        carTable[0] = new Car("I123", "Driver1", "Make1");
        carTable[1] = new Car("IAS7", "Driver2", "Make2");
        carTable[2] = new Car("I432", "Driver3", "Make3");

        Company taxi1 = new Company(carTable);


        Trip trip1 = taxi1.callTaxi(new Customer("Customer1", new Coordinates(40,40)));
        Trip trip2 = taxi1.callTaxi(new Customer("Customer2", new Coordinates(90,20)));
        Trip trip3 = taxi1.callTaxi(new Customer("Customer3", new Coordinates(10,80)));
        Trip trip4 = taxi1.callTaxi(new Customer("Customer4", new Coordinates(10,80)));

        trip1.printTripParameters();
        trip2.printTripParameters();
        trip3.printTripParameters();
        trip4.printTripParameters();
    }
}
