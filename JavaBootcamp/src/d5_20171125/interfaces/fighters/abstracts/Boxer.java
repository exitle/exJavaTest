package d5_20171125.interfaces.fighters.abstracts;

/**
 * Created: 25.11.17.
 */
public class Boxer extends Fighter {


    public Boxer(String name) {
        super(name,1000);
    }

    @Override
    public void punch(Fighter enemy) {
        enemy.takeHit(97);
    }

    @Override
    public void takeHit(int i) {
        energy -= i / 2;
    }

}
