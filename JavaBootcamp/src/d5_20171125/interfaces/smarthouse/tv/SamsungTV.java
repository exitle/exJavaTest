package d5_20171125.interfaces.smarthouse.tv;

import d5_20171125.interfaces.smarthouse.drivers.SamsungTVDriver;

/**
 * Created: 25.11.17.
 */
public class SamsungTV implements TV {
    SamsungTVDriver driver;

    public SamsungTV() {
        this.driver = new SamsungTVDriver();
    }

    @Override
    public void shutdown() {
        driver.shutdown();
    }
}
