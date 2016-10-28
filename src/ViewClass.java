//package com.editor.otherclasses;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.editor.otherclasses.JavaEditor;

import javax.swing.JFrame;

public class ViewClass extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	// Menu bar
	private MenuBar menuBar = new MenuBar();

	// Creating the menus
	private Menu mnFile = new Menu("File");
	private Menu mnHelp = new Menu("Help");

	// Creating the sub-menus for file menu
	private MenuItem mnINew = new MenuItem("New");
	private MenuItem mnIOpen = new MenuItem("Open");
	private MenuItem mnISave = new MenuItem("Save as..");
	private MenuItem mnIExit = new MenuItem("Exit");

	// Creating the sub-menus for help
	private MenuItem mnIAbout = new MenuItem("About");

	private TextArea textArea = new TextArea(5, 4);
	private Font fontTimesNewRoman = new Font("Times new roman", 0, 12);
	
	private JButton btnOpen = new JButton("");
	private JButton btnStop = new JButton("");
	private JButton btnPlay = new JButton("");
	private JButton btnPaus = new JButton("");
	

	//private FileHandler fileHandler = new FileHandler();

	// Create a file chooser
	final JFileChooser fileChooser = new JFileChooser();

	/**
	 * Constructor of the class
	 * 
	 * @param none
	 * @return none
	 */
	public ViewClass() {
		createUserInterface();
		addActionListerners();
	}

	/**
	 * Method for creating the GUI
	 * 
	 * @param none
	 * @return none
	 */
	public void createUserInterface() {
		// Setting some properties of the application
		setTitle("Java play application");
		setSize(600, 400);
		//setBounds(100, 100, 604, 342);
		this.getContentPane().setLayout(null);
		
		//setVisible(true);

		// adding sub-menus to the menu File
		mnFile.add(mnINew);
		mnFile.add(mnIOpen);
		mnFile.add(mnISave);
		mnFile.addSeparator();
		mnFile.add(mnIExit);

		// adding sub-menus to the menu Help
		mnHelp.add(mnIAbout);

		// Adding the menus to the menu bar
		menuBar.add(mnFile);
		menuBar.add(mnHelp);

		// setting the menu of the application to be the menu bar
		setMenuBar(menuBar);

		// Adding the text area in the program.
		//textArea.setFont(fontTimesNewRoman);
		
		btnOpen.setIcon(new ImageIcon("C:\\Users\\viktor\\Downloads\\openp.jpg"));
		btnOpen.setBounds(15, 130, 115, 29);

		btnPaus.setIcon(new ImageIcon("C:\\Users\\viktor\\Downloads\\pausep.jpg"));
		btnPaus.setBounds(145, 130, 115, 29);

		
		btnStop.setIcon(new ImageIcon("C:\\Users\\viktor\\Downloads\\stopp.jpg"));
		btnStop.setBounds(285, 130, 115, 29);

		
		btnPlay.setIcon(new ImageIcon("C:\\Users\\viktor\\Downloads\\playp.jpg"));
		btnPlay.setBounds(415, 130, 115, 29);

		
		//this.getContentPane().add(btnOpen);
		this.getContentPane().add(btnOpen,BorderLayout.NORTH);
		this.getContentPane().add(btnPaus,BorderLayout.WEST);
		this.getContentPane().add(btnStop,BorderLayout.CENTER);
		this.getContentPane().add(btnPlay,BorderLayout.EAST);
		//this.getContentPane().add(btnOpen);
		//this.getContentPane().add(textArea);
		
		//this.pack();
		this.setVisible(true);
		
	}

	/**
	 * Method for adding the action listeners
	 * 
	 * @param none
	 * @return none
	 */
	public void addActionListerners() {
		btnOpen.addActionListener(this);
		//mnIOpen.addActionListener(this);
		//mnISave.addActionListener(this);
		//mnIExit.addActionListener(this);
		//mnIAbout.addActionListener(this);

	}
	

	/**
	 * Implementation of the action performed for handling the actions on the
	 * application
	 * 
	 * @param none
	 * @return none
	 */
	public void actionPerformed(ActionEvent e) {
		// in case you click on new
		if (e.getSource() == mnINew) {
			// null string in unicode
			textArea.setText("" + '\u0000');

		}

		// in case you click on open
		if (e.getSource() == btnOpen) {
			int returnVal = fileChooser.showOpenDialog(ViewClass.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				System.out.println(file.getAbsolutePath());
				//textArea.setText(ViewClass.readFile(file));
			}
		}

		// in case you click on save as..
		if (e.getSource() == mnISave) {
			File file = fileChooser.getSelectedFile();
			String textOnTextArea = "";
			// fileChooser.setCurrentDirectory(new File("/home/me/Documents"));
			int retrival = fileChooser.showSaveDialog(null);
			if (retrival == JFileChooser.APPROVE_OPTION) {
				file = fileChooser.getSelectedFile();
				textOnTextArea = textArea.getText().toString();
				//fileHandler.saveFile(file, textOnTextArea);
			}

		}

		// in case you click on exit
		if (e.getSource() == mnIExit) {
			dispose();
			System.exit(0);

		}

		// in case you click on about
		if (e.getSource() == mnIAbout) {
			JOptionPane.showMessageDialog(this, "Java editor application\nVersion 1.0", "About",
					JOptionPane.INFORMATION_MESSAGE);

		}

		// in case you click on the close button of the window
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}
}
