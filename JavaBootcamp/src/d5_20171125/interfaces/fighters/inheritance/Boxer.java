package d5_20171125.interfaces.fighters.inheritance;

/**
 * Created: 26.11.17.
 */
public class Boxer extends Fighter {

    public Boxer(String name) {
        super(name, 1000);
    }

    @Override
    public void punch(Fighter enemy){
        enemy.takeHit(1000);
    }

    @Override
    public void takeHit(int i){
        energy -= i/2;
    }

}
