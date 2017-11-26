package d5_20171125.interfaces.smarthouse.music;

/**
 * Created: 26.11.17.
 */
public class Track {

    private String title;
    private String author;
    private String id;
    private String album;

    public Track(String title, String author, String id, String album) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getId() {
        return id;
    }

    public String getAlbum() {
        return album;
    }
}
