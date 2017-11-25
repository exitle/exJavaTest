package d5_20171125.interfaces.smarthouse.printers;

import d5_20171125.interfaces.smarthouse.drivers.LGPrinterDriver;

/**
 * Created: 25.11.17.
 */
public class LGPrinter implements Printer {

    LGPrinterDriver driver;

    public LGPrinter() {
        this.driver = new LGPrinterDriver();
    }

    @Override
    public void print(String text) {
        driver.printNow(text);
    }

    @Override
    public void printInBlackWhite(String text) {
        driver.printNowBW(text);
    }
}
