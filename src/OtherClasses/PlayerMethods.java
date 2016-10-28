package OtherClasses;

import Interface.PlayerInterface;
import jaco.mp3.player.MP3Player;

public class PlayerMethods implements PlayerInterface {

	private MP3Player mymp3player = new MP3Player();

	public MP3Player getMymp3player() {
		return mymp3player;
	}

	public void setMymp3player(MP3Player mymp3player) {
		this.mymp3player = mymp3player;
	}

	public void Vopen() {
		mymp3player.stop();
		mymp3player.play();

	}

	public void Vplay() {
		mymp3player.play();
	}

	public void Vstop() {
		mymp3player.stop();
	}

	public void Vpause() {
		mymp3player.pause();
	}
}
