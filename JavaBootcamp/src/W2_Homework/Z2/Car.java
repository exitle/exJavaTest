package W2_Homework.Z2;

public class Car {
    private Person driver;
    private Person passenger;

    public Car(Person driver, Person passenger) {
        this.driver = driver;
        this.passenger = passenger;
    }

    public Person getDriver() {
        return driver;
    }

    public Person getPassenger() {
        return passenger;
    }

    public void go() {
        if (driver.getAge() < 18) {
            System.out.printf("Not allowed. %s is too young to drive.%n", driver.toString());
        } else {
            System.out.printf("Driver: %s%nPassenger: %s%n", driver.toString(), passenger.toString());
        }
    }

}
