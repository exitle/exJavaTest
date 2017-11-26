package d5_20171125.interfaces.smarthouse.music.drivers;

/**
 * Created: 26.11.17.
 */
public class WinampDriver {

    public void play() {
        System.out.println("[Winamp] Play");
    }

    public void stop() {
        System.out.println("[Winamp] Stop");
    }

    public void next() {
        System.out.println("[Winamp] NextTrack");
    }

    public void previous() {
        System.out.println("[Winamp] PraviousTrack");
    }

    public void volumeUp() {
        System.out.println("[Winamp] Volume UP");
    }

    public void volumeDown() {
        System.out.println("[Winamp] Volume DOWN");
    }

}
