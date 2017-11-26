package d5_20171125.interfaces.smarthouse.music.drivers;

/**
 * Created: 26.11.17.
 */
public class SpotifyDriver {

    public void play() {
        System.out.println("[Spotify] Play");
    }

    public void stop() {
        System.out.println("[Spotify] Stop");
    }

    public void next() {
        System.out.println("[Spotify] NextTrack");
    }

    public void previous() {
        System.out.println("[Spotify] PraviousTrack");
    }

    public void volumeUp() {
        System.out.println("[Spotify] Volume UP");
    }

    public void volumeDown() {
        System.out.println("[Spotify] Volume DOWN");
    }



}
