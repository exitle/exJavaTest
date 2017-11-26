package d5_20171125.interfaces.smarthouse.music.players;

import d5_20171125.interfaces.smarthouse.music.MusicPlayer;
import d5_20171125.interfaces.smarthouse.music.Track;
import d5_20171125.interfaces.smarthouse.music.drivers.WinampDriver;

/**
 * Created: 26.11.17.
 */
public class Winamp extends MusicPlayer {

    WinampDriver driver;
    Track track;

    public Winamp() {
        super();
        this.track = super.getTrack();
    }

    @Override
    public void play() {
        driver.play();
    }

    @Override
    public void stop() {
        driver.stop();
    }

    @Override
    public void next() {
        driver.next();
    }

    @Override
    public void previous() {
        driver.previous();
    }

    @Override
    public void volumeUp() {
        driver.volumeUp();
    }

    @Override
    public void volumeDown() {
        driver.volumeDown();
    }
}
