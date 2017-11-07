package d4_20171105.Product;

/**
 * Created: 05.11.17.
 */
public class Run {
    public static void main(String[] args) {
        int MAX_PRODS = 20;

        Product[] bierdonka = new Product[MAX_PRODS];
        Product[] lidl = new Product[MAX_PRODS];

        fillGenericProducts(MAX_PRODS, bierdonka);
        fillGenericProducts(MAX_PRODS, lidl);

        cheapestProduct(bierdonka).print();
        cheapestProduct(lidl).print();
    }

    private static void fillGenericProducts(int MAX_PRODS, Product[] prod) {
        for (int i = 0; i < MAX_PRODS; i++) {
            prod[i] = new Product("GenericName_" + i, generateRandomPrice());
        }
    }

    private static double generateRandomPrice() {
        return 3 + (Math.random() * ((50 - 2) + 1));
    }

    private static Product cheapestProduct(Product[] p) {
        double cheapest = Integer.MAX_VALUE;
        Product cheapestProd = null;
        for (Product product : p) {
            if (product.getPrice() < cheapest) {
                cheapest = product.getPrice();
                cheapestProd = product;
            }
        }
        return cheapestProd;
    }


}
