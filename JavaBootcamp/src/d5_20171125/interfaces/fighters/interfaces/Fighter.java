package d5_20171125.interfaces.fighters.interfaces;

/**
 * Created: 25.11.17.
 */
public interface Fighter {

    void punch(Fighter enemy);

    void takeHit(int i);

    String getName();

    int getEnergy();
}
