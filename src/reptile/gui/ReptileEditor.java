package reptile.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import reptile.gui.widget.MapComponent;

/**
 * The main class of the Reptile Map Editor
 * 
 * @author Joe Williamson
 * @version 10/09/2010
 */

public class ReptileEditor extends JFrame {
	
	//Menu Bar
	private JMenuBar menuBar;
	//File Menu
	private JMenu fileMenu;
	private JMenuItem newMI,
					  openMI,
					  saveMI,
					  saveAsMI,
					  exitMI;
	//Edit Menu
	private JMenu editMenu;
	private JMenuItem undoMI,
					  redoMI,
					  copyMI,
					  pasteMI,
					  cutTileMI;
	//Tools Menu
	private JMenu toolsMenu;
	private JMenuItem tileSearchMI;
	
	//Help Menu
	private JMenu helpMenu;
	private JMenuItem aboutMI;
	
	//Main panels
	private JPanel toolbarPanel,
				   leftPanel,
				   middlePanel,
				   rightPanel,
				   footerPanel;
	
	private JTabbedPane pallettePane;
	private JDesktopPane editorPane;
	
	/**
	 * Constructor for objects of type ReptileEditor
	 */
	public ReptileEditor() {
		//Set Icon
		setIconImage(Toolkit.getDefaultToolkit().createImage("data/icon.png"));
		
		//Set default close operation		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create and set Menu Bar
		menuBar = new JMenuBar();		
		setJMenuBar(menuBar);
		
		//File Menu ------------------------------
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(fileMenu);
		//New MenuItem
		newMI = new JMenuItem("New");
		newMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		//Open MenuItem
		openMI = new JMenuItem("Open...");
		openMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		//Save MenuItem
		saveMI = new JMenuItem("Save");
		saveMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		//Save As MenuItem
		saveAsMI = new JMenuItem("Save As...");
		//Exit MenuItem
		exitMI = new JMenuItem("Exit");
		exitMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
			
		//Add items to File menu
		fileMenu.add(newMI);
		fileMenu.add(openMI);
		fileMenu.add(saveMI);
		fileMenu.add(saveAsMI);
		fileMenu.addSeparator();
		fileMenu.add(exitMI);
			
			
		//Edit Menu ------------------------------
		editMenu = new JMenu("Edit");
		editMenu.setMnemonic(KeyEvent.VK_E);
		menuBar.add(editMenu);
		//Undo MenuItem
		undoMI = new JMenuItem("Undo");
		undoMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		//Redo MenuItem
		redoMI = new JMenuItem("Redo");
		redoMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
		//Copy MenuItem
		copyMI = new JMenuItem("Copy Tile");
		copyMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		//Cut MenuItem
		cutTileMI = new JMenuItem("Cut Tile");
		cutTileMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		//Paste MenuItem
		pasteMI = new JMenuItem("Paste Tile");
		pasteMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		
		//Add items to Edit menu
		editMenu.add(undoMI);
		editMenu.add(redoMI);
		editMenu.addSeparator();
		editMenu.add(copyMI);
		editMenu.add(pasteMI);
		editMenu.add(cutTileMI);
		
			
		//Tools Menu ------------------------------
		toolsMenu = new JMenu("Tools");
		toolsMenu.setMnemonic(KeyEvent.VK_T);
		menuBar.add(toolsMenu);
		//Search MenuItem
		tileSearchMI = new JMenuItem("Tile Search...");
		tileSearchMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
		//Add items to Tools Menu
		toolsMenu.add(tileSearchMI);
		
		//Set layout
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		//Add panels
		toolbarPanel = new JPanel();
		toolbarPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		toolbarPanel.setPreferredSize(new Dimension(300, 40));
		add(toolbarPanel);
		
		JPanel splitPanePanel = new JPanel();
		splitPanePanel.setLayout(new BoxLayout(splitPanePanel, BoxLayout.X_AXIS));
		add(splitPanePanel);
		leftPanel = new JPanel();
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		middlePanel = new JPanel();
		middlePanel.add(new MapComponent());
		middlePanel.add(new JLabel(new ImageIcon("data/logo.png")));
		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
		rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		JSplitPane outerSplitPane = new JSplitPane();
		outerSplitPane.setBorder(null);
		outerSplitPane.setOneTouchExpandable(true);
		splitPanePanel.add(outerSplitPane);
		JSplitPane innerSplitPane = new JSplitPane();
		innerSplitPane.setBorder(null);
		innerSplitPane.setOneTouchExpandable(true);
		outerSplitPane.setLeftComponent(innerSplitPane);
		outerSplitPane.setRightComponent(rightPanel);
		innerSplitPane.setLeftComponent(leftPanel);
		innerSplitPane.setRightComponent(middlePanel);
		footerPanel = new JPanel();
		footerPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 60)));
		add(footerPanel);
		
	}
	
	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//Set the look and feel
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception ex){
			System.out.println("Error: " + ex);
		}
		
		ReptileEditor app = new ReptileEditor();
		app.setTitle("Reptile Map Editor");
		app.setSize(800, 500);
		app.setMinimumSize(new Dimension(650, 400));
		app.setLocationRelativeTo(null);
		app.setVisible(true);
		app.setResizable(true);
	}

}
