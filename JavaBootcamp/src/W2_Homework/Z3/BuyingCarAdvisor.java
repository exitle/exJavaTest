package W2_Homework.Z3;

import java.util.List;

public class BuyingCarAdvisor {
    private List<Dealer> dealers;

    public BuyingCarAdvisor(List<Dealer> dealers) {
        this.dealers = dealers;
    }

    public Car findBestOffer() {
        double bestPrice = Double.MAX_VALUE;
        Car c = new Car();
        for (Dealer dealer : dealers) {
            for (Car car : dealer.getCars()) {
                double carPrice = car.getPrice();
                if (carPrice < bestPrice) {
                    bestPrice = carPrice;
                    c = car;
                }
            }
        }
        return c;
    }

    public void printOffers() {
        for (Dealer dealer : dealers) {
            System.out.println(dealer.toString());
        }
    }
}
