package d2_20171022.classes1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by exitle on 22.10.17.
 */
public class Mem {
    private String name;
    private String url;
    private String description;
    private boolean favourite;

    public Mem(String name, String url, String description, boolean favourite) {
        if(isCorrectUrl(url)) {
            this.name = name;
            this.url = url;
            this.description = description;
            this.favourite = favourite;
        } else {
            System.err.println("Invalid URL");
        }
    }

    public boolean isCorrectUrl(String url) {
        Pattern p = Pattern.compile("^(http:\\/\\/|https:\\/\\/)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$");
        Matcher m;
        m = p.matcher(url);
        return m.matches();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }
}
