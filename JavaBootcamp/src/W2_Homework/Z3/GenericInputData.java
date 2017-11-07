package W2_Homework.Z3;

import java.util.ArrayList;
import java.util.List;

public class GenericInputData {

    public List<Dealer> generateDealerList(int dn, int cn) {
        return generateDealers(dn, cn);
    }

    private static List<Dealer> generateDealers(int dn, int cn) {
        List<Dealer> ld = new ArrayList<>();
        for (int i = 0; i < dn; i++) {
            Dealer d = new Dealer("dealerName_" + i, "dealerAddress_" + generateRandomInt());
            generateCars(d, cn);
            ld.add(d);
        }
        return ld;
    }

    private static void generateCars(Dealer d, int n) {
        for (int i = 0; i < n; i++) {
            Car c = new Car("brand_" + generateRandomInt(), "Model_" + generateRandomInt(), generateRandomDbl());
            d.addCar(c);
        }
    }

    private static int generateRandomInt() {
        return 1 + (int) (Math.random() * (50 - 1));
    }

    private static double generateRandomDbl() {
        return 5000 + Math.random() * (40000 - 5000);
    }

}
