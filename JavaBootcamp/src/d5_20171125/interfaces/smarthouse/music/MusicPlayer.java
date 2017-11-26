package d5_20171125.interfaces.smarthouse.music;

import java.util.List;

/**
 * Created: 26.11.17.
 */
public abstract class MusicPlayer {

    private Track track;
    private TrackDatabase trackDatabase;

    public MusicPlayer() {
        this.trackDatabase = new TrackDatabase();
        this.track=trackDatabase.getTrackList().get(0);
    }

    public abstract void play();
    public abstract void stop();
    public abstract void next();
    public abstract void previous();
    public abstract void volumeUp();
    public abstract void volumeDown();

    public List<Track> findTrack(String search){
        return trackDatabase.FindTrack(search);
    }

    public Track getTrack() {
        return track;
    }

}
