package d6_20171126.generic;

/**
 * Created: 26.11.17.
 */
public class Box<T> {

    private T inBox;

    public Box(T inBox) {
        this.inBox = inBox;
    }

    public T getInBox() {
        return inBox;
    }
}
