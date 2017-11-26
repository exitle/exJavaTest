package d5_20171125.interfaces;

import d5_20171125.interfaces.smarthouse.SmartHouse;

/**
 * Created: 25.11.17.
 */
public class Main {
    public static void main(String[] args) {
        SmartHouse sh = new SmartHouse();
        sh.print(0,"test");
        sh.printBW(1,"test");
        sh.shutdown();
    }
}
