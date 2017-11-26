package d5_20171125.interfaces.smarthouse;

import d5_20171125.interfaces.smarthouse.music.MusicPlayer;
import d5_20171125.interfaces.smarthouse.music.players.Spotify;
import d5_20171125.interfaces.smarthouse.printers.HPPrinter;
import d5_20171125.interfaces.smarthouse.printers.LGPrinter;
import d5_20171125.interfaces.smarthouse.printers.NoPrinter;
import d5_20171125.interfaces.smarthouse.printers.Printer;
import d5_20171125.interfaces.smarthouse.tv.LGTV;
import d5_20171125.interfaces.smarthouse.tv.SamsungTV;
import d5_20171125.interfaces.smarthouse.tv.TV;

import java.util.ArrayList;
import java.util.List;

/**
 * Created: 25.11.17.
 */
public class SmartHouse {

    List<Printer> printer;
    List<TV> tvTab;
    List<MusicPlayer> musicPlayer;

    public SmartHouse() {
        getAvailableStuff();
    }

    private void getAvailableStuff() {
        printer = new ArrayList<>();
        tvTab = new ArrayList<>();
        musicPlayer = new ArrayList<>();

        printer.add(new LGPrinter(Room.BEDROOM));
        printer.add(new HPPrinter(Room.LIVING_ROOM));
        tvTab.add(new SamsungTV(Room.LIVING_ROOM));
        tvTab.add(new LGTV(Room.BEDROOM));
        tvTab.add(new LGTV(Room.KITCHEN));
        musicPlayer.add(new Spotify());
    }

    public void print(int i, String text) {
        printer.get(i).print(text);
    }

    public void printBW(int i, String text) {
        printer.get(i).printInBlackWhite(text);
    }

    public void shutdown() {
        for (TV tv : tvTab) {
            tv.shutdown();
        }
    }

    public void turnOffTV(Room room) {
        for (TV tv : tvTab) {
            if (tv.getRoom() == room) {
                tv.shutdown();
            }
        }
    }

    public void playMusic(int i) {
        musicPlayer.get(i).play();
    }

    public void stopMusic(int i) {
        musicPlayer.get(i).stop();
    }

    public void findTrack(int i, String str) {
        musicPlayer.get(i).findTrack(str).get(0);
    }


}
