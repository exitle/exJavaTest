package d5_20171125.interfaces.smarthouse.tv;

import d5_20171125.interfaces.smarthouse.drivers.LGTVDriver;

/**
 * Created: 25.11.17.
 */
public class LGTV implements TV {
    LGTVDriver driver;

    public LGTV() {
        this.driver = new LGTVDriver();
    }

    @Override
    public void shutdown() {
        driver.powerOff();
    }
}
