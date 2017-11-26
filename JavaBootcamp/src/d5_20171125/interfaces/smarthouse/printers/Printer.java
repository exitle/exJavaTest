package d5_20171125.interfaces.smarthouse.printers;

import d5_20171125.interfaces.smarthouse.Room;

/**
 * Created: 25.11.17.
 */
public interface Printer {

    void print(String text);
    void printInBlackWhite(String text);
    Room getRoom();

}
