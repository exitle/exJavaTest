package W2_Homework.Z3;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
    private String name;
    private String address;
    private List<Car> cars;

    public Dealer(String name, String address, List<Car> cars) {
        this.name = name;
        this.address = address;
        this.cars = cars;
    }

    public Dealer(String name, String address) {
        this.name = name;
        this.address = address;
        this.cars = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void addCar(Car c) {
        cars.add(c);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Dealer {%nName: %s%nAddress: %s%nCars {%n", name, address));
        for (Car car : cars) {
            sb.append(String.format("\t%s%n", car.toString()));
        }
        sb.append("}\n");
        return sb.toString();
    }
}
