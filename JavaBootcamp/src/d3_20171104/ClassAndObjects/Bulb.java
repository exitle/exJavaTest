package d3_20171104.ClassAndObjects;

/**
 * Created by exitle on 04.11.17.
 */
public class Bulb {
    private int power;
    private int vitality;

    public Bulb() {
    }

    public Bulb(int power, int vitality) {

        this.power = power;
        this.vitality = vitality;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    @Override
    public String toString() {
        return "Bulb{" +
                "power=" + power +
                ", vitality=" + vitality +
                '}';
    }
}
