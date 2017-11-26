package d5_20171125.interfaces.fighters.abstracts;

import java.util.Random;

/**
 * Created: 25.11.17.
 */
public class Karate extends Fighter {


    public Karate(String name) {
        super(name, 100);
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
}
