package d5_20171125.interfaces.fighters.abstracts;

/**
 * Created: 25.11.17.
 */
public abstract class Fighter {
    private String name;
    protected int energy;

    public Fighter(String name, int energy) {
        this.name = name;
        this.energy=energy;
    }

    public abstract void punch(Fighter enemy);
    public abstract void takeHit(int i);

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }
}
