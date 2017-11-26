package d5_20171125.interfaces.smarthouse.tv;

import d5_20171125.interfaces.smarthouse.Room;
import d5_20171125.interfaces.smarthouse.tv.drivers.LGTVDriver;

/**
 * Created: 25.11.17.
 */
public class LGTV implements TV {
    LGTVDriver driver;
    Room room;

    public LGTV(Room room) {
        this.driver = new LGTVDriver();
        this.room = room;
    }

    @Override
    public void shutdown() {
        System.out.printf("[%s] ", room);
        driver.powerOff();
    }

    @Override
    public Room getRoom() {
        return room;
    }
}
