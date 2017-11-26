package d5_20171125.interfaces.smarthouse.printers.drivers;

/**
 * Created: 25.11.17.
 */
public class LGPrinterDriver {

    public void printNow(String text) {
        System.out.println("LG " + text);
    }

    public void printNowBW(String text) {
        System.out.println("[LG] (BW) " + text);
    }

}
