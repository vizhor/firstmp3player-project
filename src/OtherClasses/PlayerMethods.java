
package OtherClasses;

import java.io.File;

import Interface.PlayerInterface;
import jaco.mp3.player.MP3Player;

/**
 * @author Viktor Hamnholm Löfgren
 * @version 1.0
 *
 *Methods for program
 */

public class PlayerMethods implements PlayerInterface {

	private String song;
	private MP3Player mymp3player = new MP3Player();

	/**
	 * Sets the song.
	 *
	 * @param asong
	 *            the new song
	 */
	public void setSong(String asong) {
		song = asong;
	}
	
	/**
	 * Open new file
	 * 
	 */

	public void Vopen() {
		mymp3player.stop();

	}
	/**
	 * Saves file to string song
	 * Play file
	 */

	public void Vplay() {
		mymp3player.addToPlayList(new File(song));
		mymp3player.play();
	}
	
	/**
	 * Stops file from playing
	 * 
	 */

	public void Vstop() {
		mymp3player.stop();
	}
	
	/**
	 * Pause file from playing
	 * 
	 */

	public void Vpause() {
		mymp3player.pause();
	}
}
