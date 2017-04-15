package com.sys.sound;

import com.terminal.tools.*;

public class SoundControl {

	public SoundControl(String param) {
		new Execute("pactl -- set-sink-volume 0 " + param + "%");
	}

}
