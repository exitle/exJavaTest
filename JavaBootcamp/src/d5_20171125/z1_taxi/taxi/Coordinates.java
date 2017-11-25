package d5_20171125.z1_taxi.taxi;

/**
 * Created: 25.11.17.
 */
public class Coordinates {
    private double x;
    private double y;

    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public static double calculateDistance(Coordinates c1, Coordinates c2) {
        double a = Math.abs(c1.getX() - c2.getX());
        double b = Math.abs(c1.getY() - c2.getY());
        return Math.sqrt(a * a + b * b);
    }

}
