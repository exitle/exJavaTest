package d5_20171125.interfaces.smarthouse;

import d5_20171125.interfaces.smarthouse.printers.HPPrinter;
import d5_20171125.interfaces.smarthouse.printers.Printer;
import d5_20171125.interfaces.smarthouse.tv.LGTV;
import d5_20171125.interfaces.smarthouse.tv.SamsungTV;
import d5_20171125.interfaces.smarthouse.tv.TV;

/**
 * Created: 25.11.17.
 */
public class SmartHouse {

    Printer printer;
    TV[] tvTab;

    public SmartHouse() {
        printer = new HPPrinter();
        tvTab = new TV[2];
        tvTab[0] = new SamsungTV();
        tvTab[1] = new LGTV();
    }

    public void print(String text) {
        printer.print(text);
    }

    public void printBW(String text) {
        printer.printInBlackWhite(text);
    }

    public void shutdown() {
        for (TV tv : tvTab) {
            tv.shutdown();
        }
    }

}
