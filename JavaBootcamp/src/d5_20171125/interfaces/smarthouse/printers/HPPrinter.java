package d5_20171125.interfaces.smarthouse.printers;

import d5_20171125.interfaces.smarthouse.drivers.HPPrinterDriver;

/**
 * Created: 25.11.17.
 */
public class HPPrinter implements Printer {

    HPPrinterDriver driver;

    public HPPrinter() {
        this.driver = new HPPrinterDriver();
    }

    @Override
    public void print(String text) {
        driver.print(text);
    }

    @Override
    public void printInBlackWhite(String text) {
        System.err.println("[HP] Unsupported operation");
    }
}
