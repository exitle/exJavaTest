package d4_20171105.Product;

/**
 * Created: 05.11.17.
 */
public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void print() {
        System.out.printf("Cheapest product: %s (%.2f)%n", getName(), getPrice());
    }
}
