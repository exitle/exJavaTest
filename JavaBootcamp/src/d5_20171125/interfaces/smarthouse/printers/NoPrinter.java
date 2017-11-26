package d5_20171125.interfaces.smarthouse.printers;

import d5_20171125.interfaces.smarthouse.Room;

/**
 * Created: 26.11.17.
 */
public class NoPrinter implements Printer {
    @Override
    public void print(String text) {
        System.out.println("No printers available.");
    }

    @Override
    public void printInBlackWhite(String text) {
        print(text);
    }

    @Override
    public Room getRoom() {
        return null;
    }
}
