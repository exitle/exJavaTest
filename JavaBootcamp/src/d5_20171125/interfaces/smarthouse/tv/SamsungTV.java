package d5_20171125.interfaces.smarthouse.tv;

import d5_20171125.interfaces.smarthouse.Room;
import d5_20171125.interfaces.smarthouse.tv.drivers.SamsungTVDriver;

/**
 * Created: 25.11.17.
 */
public class SamsungTV implements TV {
    SamsungTVDriver driver;
    Room room;

    public SamsungTV(Room room) {
        this.driver = new SamsungTVDriver();
        this.room = room;
    }

    @Override
    public void shutdown() {
        System.out.printf("[%s] ", room);
        driver.shutdown();
    }

    @Override
    public Room getRoom() {
        return room;
    }
}
