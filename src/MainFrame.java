import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;

import jaco.mp3.player.MP3Player;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class MainFrame {

	private JFrame frmMyMusicPlayer;
	private JTextField txtMusic;
	private JTextField txtSong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frmMyMusicPlayer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMyMusicPlayer = new JFrame();
		frmMyMusicPlayer.setTitle("My Music Player");
		frmMyMusicPlayer.setBounds(100, 100, 604, 342);
		frmMyMusicPlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMyMusicPlayer.getContentPane().setLayout(null);
		
		JButton btnPlay = new JButton("");
		btnPlay.setIcon(new ImageIcon("C:\\Users\\viktor\\Downloads\\playp.jpg"));
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MP3Player(new File("C:\\Users\\viktor\\Desktop\\example music\\Kyla La Grange - Cut Your Teeth (Kygo Remix).mp3")).play();
				
			}
		});
		
		btnPlay.setBounds(15, 127, 115, 34);
		frmMyMusicPlayer.getContentPane().add(btnPlay);
		
		JButton btnOpen = new JButton("");
		btnOpen.setIcon(new ImageIcon("C:\\Users\\viktor\\Downloads\\openp.jpg"));
		btnOpen.setBounds(145, 130, 115, 29);
		frmMyMusicPlayer.getContentPane().add(btnOpen);
		
		JButton btnPaus = new JButton("");
		btnPaus.setIcon(new ImageIcon("C:\\Users\\viktor\\Downloads\\pausep.jpg"));
		btnPaus.setBounds(285, 130, 115, 29);
		frmMyMusicPlayer.getContentPane().add(btnPaus);
		
		JButton btnStop = new JButton("");
		btnStop.setIcon(new ImageIcon("C:\\Users\\viktor\\Downloads\\stopp.jpg"));
		btnStop.setBounds(415, 130, 115, 29);
		frmMyMusicPlayer.getContentPane().add(btnStop);
		
		txtMusic = new JTextField();
		txtMusic.setText("Music:");
		txtMusic.setBounds(15, 29, 75, 26);
		frmMyMusicPlayer.getContentPane().add(txtMusic);
		txtMusic.setColumns(10);
		
		txtSong = new JTextField();
		txtSong.setText("song");
		txtSong.setBounds(122, 29, 146, 26);
		frmMyMusicPlayer.getContentPane().add(txtSong);
		txtSong.setColumns(10);
	}
}
