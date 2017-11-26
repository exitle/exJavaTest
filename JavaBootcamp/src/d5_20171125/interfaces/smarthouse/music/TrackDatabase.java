package d5_20171125.interfaces.smarthouse.music;

import java.util.ArrayList;
import java.util.List;

/**
 * Created: 26.11.17.
 */
public class TrackDatabase {
    private List<Track> trackList;

    public TrackDatabase() {
        trackList = getDatabaseFromAPI();
        this.trackList = trackList;
    }

    public List<Track> FindTrack(String str){
        List<Track> searchResults = new ArrayList<>();

        for(Track track : trackList){
            boolean checkTitle = track.getTitle().toLowerCase().contains(str.toLowerCase());
            boolean checkAuthor = track.getAuthor().toLowerCase().contains(str.toLowerCase());
            boolean checkId = track.getId().toLowerCase().contains(str.toLowerCase());
            boolean checkAlbum = track.getAlbum().toLowerCase().contains(str.toLowerCase());

            if(checkTitle || checkAuthor || checkId || checkAlbum){
                searchResults.add(track);
            }
        }

        return searchResults;
    }

    public List<Track> getDatabaseFromAPI(){
        List<Track> trackList = new ArrayList<>();
        trackList.add(new Track("Song","Author", "ID", "Album"));
        return trackList;
    }

    public List<Track> getTrackList() {
        return trackList;
    }
}
