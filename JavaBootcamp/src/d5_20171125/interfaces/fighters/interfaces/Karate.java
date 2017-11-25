package d5_20171125.interfaces.fighters.interfaces;

import java.util.Random;

/**
 * Created: 25.11.17.
 */
public class Karate implements Fighter {
    private String name;
    private int energy;

    public Karate(String name) {
        this.name = name;
        this.energy = 100;
    }

    @Override
    public void punch(Fighter enemy) {
        enemy.takeHit(10);
        int i = (new Random()).nextInt(10);
        if (i == 1) {
            enemy.takeHit(100);
        }
    }

    @Override
    public void takeHit(int i) {
        energy -= i * 2;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getEnergy() {
        return energy;
    }
}
