package d5_20171125.interfaces.fighters.inheritance;

import java.util.Random;

/**
 * Created: 26.11.17.
 */
public class Karate extends Fighter {

    public Karate(String name) {
        super(name, 100);
    }

    @Override
    public void punch(Fighter enemy) {
        super.punch(enemy);
        int i = (new Random()).nextInt(10);
        if (i == 1) {
            enemy.takeHit(100);
        }
    }

}
