package d5_20171125.interfaces.fighters.inheritance;

import java.util.Random;

/**
 * Created: 26.11.17.
 */
public class Fighter {
    protected String name;
    protected int energy;

    public Fighter(String name, int energy) {
        this.name = name;
        this.energy = energy;
    }

    public void punch(Fighter enemy) {
        enemy.takeHit(10);
    }

    public void takeHit(int i) {
        energy -= i;
    }

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }
}
