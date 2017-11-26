package d5_20171125.interfaces.smarthouse.users;

import d5_20171125.interfaces.smarthouse.Room;
import d5_20171125.interfaces.smarthouse.music.MusicPlayer;
import d5_20171125.interfaces.smarthouse.printers.Printer;
import d5_20171125.interfaces.smarthouse.tv.TV;

/**
 * Created: 26.11.17.
 */
public class User extends MusicPlayer implements TV, Printer {

    String userName;

    public User(String userName){
        this.userName=userName;
    }

    @Override
    public void print(String text) {

    }

    @Override
    public void printInBlackWhite(String text) {

    }

    @Override
    public void shutdown() {

    }

    @Override
    public Room getRoom() {
        return null;
    }

    @Override
    public void play() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void next() {

    }

    @Override
    public void previous() {

    }

    @Override
    public void volumeUp() {

    }

    @Override
    public void volumeDown() {

    }
}
