package d3_20171104.Klasy;

/**
 * Created by exitle on 04.11.17.
 */
public class Tire {
    private int width;
    private int profile;
    private int diameter;

    public Tire(int width, int profile, int diameter) {
        this.width = width;
        this.profile = profile;
        this.diameter = diameter;
    }

    public int getWidth() {
        return width;
    }

    public int getProfile() {
        return profile;
    }

    public int getDiameter() {
        return diameter;
    }

    public String getTireCode(){
        return "["+this.width+"/"+this.profile+" R"+this.diameter+"]";
    }

}
