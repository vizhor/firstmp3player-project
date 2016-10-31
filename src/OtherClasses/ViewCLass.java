/**
*@author Viktor Hamnholm Löfgren
*@version 1.0
*
*
*/
package OtherClasses;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 * The Class ViewClass.
 */
public class ViewClass implements ActionListener {

	/**
	 * Creating, frame, labels, buttons, string
	 */
	private JFrame frmPlayer;
	private PlayerMethods playermethods = new PlayerMethods();
	private JLabel lblMusic = new JLabel("Music: ");
	private JLabel lblSong = new JLabel("MySong");
	private JButton btnOpen = new JButton("");
	private JButton btnPlay = new JButton("");
	private JButton btnPause = new JButton("");
	private JButton btnStop = new JButton("");
	private String choosenSong;

	/**
	 * Create the application.
	 */

	public ViewClass() {
		Initialize();
		addComponentsToFrame();
		addActionListeners();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void Initialize() {
		frmPlayer = new JFrame();
		frmPlayer.getContentPane().setBackground(Color.RED);
		frmPlayer.setTitle("My music Player");
		frmPlayer.setBounds(100, 100, 314, 338);
		frmPlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlayer.getContentPane().setLayout(null);

		btnOpen.setIcon(new ImageIcon("Icons\\openp.jpg"));
		btnPlay.setIcon(new ImageIcon("Icons\\playp.jpg"));
		btnPause.setIcon(new ImageIcon("Icons\\pausep.jpg"));
		btnStop.setIcon(new ImageIcon("Icons\\stopp.jpg"));

		lblMusic.setBounds(10, 80, 67, 23);
		lblSong.setBounds(80, 80, 197, 23);
		btnOpen.setBounds(10, 139, 47, 23);
		btnPlay.setBounds(67, 139, 48, 23);
		btnPause.setBounds(125, 139, 47, 23);
		btnStop.setBounds(182, 139, 37, 23);

		frmPlayer.setVisible(true);
	}

	/**
	 * Adding components to frame.
	 * 
	 */
	public void addComponentsToFrame() {

		frmPlayer.getContentPane().add(lblSong);
		frmPlayer.getContentPane().add(lblMusic);
		frmPlayer.getContentPane().add(btnOpen);
		frmPlayer.getContentPane().add(btnPlay);
		frmPlayer.getContentPane().add(btnPause);
		frmPlayer.getContentPane().add(btnStop);

	}

	/**
	 * Adding the action listeners.
	 */
	public void addActionListeners() {
		btnOpen.addActionListener(this);
		btnPlay.addActionListener(this);
		btnPause.addActionListener(this);
		btnStop.addActionListener(this);
	}

	/**
	 * Adding action performed
	 *
	 */

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnStop) {
			playermethods.Vstop();
		}

		else if (e.getSource() == btnOpen) {
			JFileChooser fileChooser = new JFileChooser();
			int returnVal = fileChooser.showOpenDialog(frmPlayer);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				choosenSong = file.getAbsolutePath();
				lblSong.setText(file.getName().toString());
				playermethods.setSong(file.getAbsolutePath());

			}
		} else if (e.getSource() == btnPlay) {
			playermethods.Vplay();
		}

		else if (e.getSource() == btnPause) {
			playermethods.Vpause();
		}

	}
}
