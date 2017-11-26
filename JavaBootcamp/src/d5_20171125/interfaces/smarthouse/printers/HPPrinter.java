package d5_20171125.interfaces.smarthouse.printers;

import d5_20171125.interfaces.smarthouse.Room;
import d5_20171125.interfaces.smarthouse.printers.drivers.HPPrinterDriver;

/**
 * Created: 25.11.17.
 */
public class HPPrinter implements Printer {

    private HPPrinterDriver driver;
    private Room room;

    public HPPrinter(Room room) {
        this.driver = new HPPrinterDriver();
        this.room=room;
    }

    @Override
    public void print(String text) {
        driver.print(text);
    }

    @Override
    public void printInBlackWhite(String text) {
        System.err.println("[HP] Unsupported operation");
    }

    @Override
    public Room getRoom() {
        return room;
    }
}
