package OtherClasses;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.editor.otherclasses.JavaEditor;

import jaco.mp3.player.MP3Player;

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
	private MP3Player mp3player;
	
	final JFileChooser fileChooser = new JFileChooser();
	//private Calculator calculator = new Calculator();
	//private JLabel lblResult = new JLabel("Result:");
	
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
		
		//txfFirstNumber = new JTextField();
		//txfFirstNumber.setBounds(116, 27, 108, 20);
		//frmCalculator.getContentPane().add(txfFirstNumber);
		//txfFirstNumber.setColumns(10);
		
		/*txfSecondNumber = new JTextField();
		txfSecondNumber.setBounds(116, 58, 108, 20);
		frmCalculator.getContentPane().add(txfSecondNumber);
		txfSecondNumber.setColumns(10);	
		
		lblFirstNumber.setBounds(10, 30, 96, 14);
		lblSecondNumber.setBounds(10, 61, 96, 14);
		lblResult.setBounds(10, 86, 223, 14);*/
		btnOpen.setIcon(new ImageIcon("C:\\Users\\viktor\\Desktop\\20sep\\firstmp3player-project\\Icons\\openp.jpg"));
		btnPlay.setIcon(new ImageIcon("C:\\Users\\viktor\\Desktop\\20sep\\firstmp3player-project\\Icons\\playp.jpg"));
		btnPause.setIcon(new ImageIcon("C:\\Users\\viktor\\Desktop\\20sep\\firstmp3player-project\\Icons\\pausep.jpg"));
		btnStop.setIcon(new ImageIcon("C:\\Users\\viktor\\Desktop\\20sep\\firstmp3player-project\\Icons\\stopp.jpg"));

		
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
		
	}
		
	
	public void addActionListeners(){
		btnOpen.addActionListener(this);
		btnPlay.addActionListener(this);
		btnPause.addActionListener(this);
		btnStop.addActionListener(this);
	}

	
	/**
	 *
	 * get value from text field
	 * 
	 * @return firstNUmber - Number that is written in the textfield
	 **/
	/*public double getValueFromTextField1(){		
		double firstNumber = 0.0;						
		firstNumber = Double.valueOf(txfFirstNumber.getText());		
		return firstNumber;		
	}
	
	public double getValueFromTextField2(){		
		double secondNumber = 0.0;						
		secondNumber = Double.valueOf(txfSecondNumber.getText());		
		return secondNumber;		
	}	*/
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOpen){
			int returnVal = fileChooser.showOpenDialog(frmPlayer);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				System.out.println(file.getAbsolutePath());
				choosenSong=file.getAbsolutePath();
				lblSong.setText(file.getName());
				mp3player=playermethods.getMymp3player();
				
				//playermethods.setMymp3player(mp3player);
				playermethods.getMymp3player
				playermethods.Vopen();
		}		
		
		if (e.getSource() == btnPlay){
			playermethods.setMymp3player(mp3player);
			playermethods.Vplay();
		}
		
		if (e.getSource() == btnPause){
			playermethods.setMymp3player(mp3player);
			playermethods.Vpause();
		}
		
		if (e.getSource() == btnStop){
			playermethods.setMymp3player(mp3player);
			playermethods.Vstop();
		}	
		
	}
}
}	


