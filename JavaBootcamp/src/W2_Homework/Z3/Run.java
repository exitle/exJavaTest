package W2_Homework.Z3;

import java.util.List;

public class Run {
    public static void main(String[] args) {
        List<Dealer> ld = new GenericInputData().generateDealerList(5, 10);
        BuyingCarAdvisor bca = new BuyingCarAdvisor(ld);

        bca.printOffers();
        System.out.printf("Best offer:%n\t%s", bca.findBestOffer().toString());
    }
}
