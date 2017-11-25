package d5_20171125.interfaces.fighters.interfaces;

/**
 * Created: 25.11.17.
 */
public class Boxer implements Fighter {

    private int energy;
    private String name;

    public Boxer(String name) {
        this.name = name;
        this.energy = 1000;
    }


    @Override
    public void punch(Fighter enemy) {
        enemy.takeHit(97);
    }

    @Override
    public void takeHit(int i) {
        energy -= i / 2;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    public String getName() {
        return name;
    }
}
