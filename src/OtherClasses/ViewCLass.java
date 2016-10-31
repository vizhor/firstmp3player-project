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

public class ViewClass implements ActionListener{
	private JFrame frmPlayer;
	private PlayerMethods playermethods = new PlayerMethods();
	//private MP3Player mp3player;//=null
	
	
	
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
		createAndShowGUI();
		addComponentsToFrame();
		addActionListeners();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void createAndShowGUI() {
		frmPlayer = new JFrame();
		frmPlayer.getContentPane().setBackground(Color.CYAN);
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
	 * Addind components to frame.
	 * @param none
	 * @return none
	 */
	public void addComponentsToFrame(){
		
		frmPlayer.getContentPane().add(lblSong);
		frmPlayer.getContentPane().add(lblMusic);
		frmPlayer.getContentPane().add(btnOpen);
		frmPlayer.getContentPane().add(btnPlay);
		frmPlayer.getContentPane().add(btnPause);
		frmPlayer.getContentPane().add(btnStop);
		
		/*btnPlay.setEnabled(false);
		btnStop.setEnabled(false);
		btnPause.setEnabled(false);*/
		
	}
		
	
	public void addActionListeners(){
		btnOpen.addActionListener(this);
		btnPlay.addActionListener(this);
		btnPause.addActionListener(this);
		btnStop.addActionListener(this);
		//btnStop.addActionListener(frmPlayer.);
	}

	
	/**
	 *
	 * get value from text field
	 * 
	 * @return firstNUmber - Number that is written in the textfield
	 **/

	
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnStop){
			System.out.println("stop");
			playermethods.Vstop();
		}	
		
		else if (e.getSource() == btnOpen){
			System.out.println("open");
			JFileChooser fileChooser = new JFileChooser();
			int returnVal = fileChooser.showOpenDialog(frmPlayer);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				System.out.println(file.getAbsolutePath());
				choosenSong=file.getAbsolutePath();
				lblSong.setText(file.getName().toString());
				//mp3player=playermethods.getMymp3player();
				
				//if mp3player ! null then stop
				
				playermethods.setSong(file.getAbsolutePath());
				//playermethods.getMymp3player
				//playermethods.Vopen();
		    }		
		}
			else if (e.getSource() == btnPlay){
			//playermethods.setMymp3player(mp3player);
			System.out.println("play");
			playermethods.Vplay();
		}
		
			else if (e.getSource() == btnPause){
			System.out.println("pause");
			playermethods.Vpause();
		}
		

		
	}
}
	


