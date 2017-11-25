package com.sys.sound;

import com.terminal.tools.*;

public class SoundControl {

   public SoundControl(String param) {
      String sink = new Execute("pactl list sinks | grep -B 1 State | grep -oP '(?<=#).*'").getParam();
//      String sink = new Execute("pactl list sinks | grep -B 1 RUNNING | grep -oP '(?<=#).*'").getParam();
      new Execute("pactl -- set-sink-volume " + sink + " " + param + "%");
   }

}
