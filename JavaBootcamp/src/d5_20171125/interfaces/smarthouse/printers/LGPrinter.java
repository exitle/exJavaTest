package d5_20171125.interfaces.smarthouse.printers;

import d5_20171125.interfaces.smarthouse.Room;
import d5_20171125.interfaces.smarthouse.printers.drivers.LGPrinterDriver;

/**
 * Created: 25.11.17.
 */
public class LGPrinter implements Printer {

    private LGPrinterDriver driver;
    private Room room;

    public LGPrinter(Room room) {
        this.driver = new LGPrinterDriver();
        this.room=room;
    }

    @Override
    public void print(String text) {
        driver.printNow(text);
    }

    @Override
    public void printInBlackWhite(String text) {
        driver.printNowBW(text);
    }

    @Override
    public Room getRoom() {
        return room;
    }
}
