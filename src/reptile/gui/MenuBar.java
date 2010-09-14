package reptile.gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * The default menu bar
 * 
 * @author Joe Williamson <huruey@gmail.com>
 */

public class MenuBar extends JMenuBar {
	
	//Instance Variables
	
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
					  cutMI;
	//Tools Menu
	private JMenu toolsMenu;
	private JMenuItem tileSearchMI;
	
	//Help Menu
	private JMenu helpMenu;
	private JMenuItem aboutMI;
	
	/**
	 * Constructor for objects of type MenuBar
	 */
	public MenuBar() {
		//File Menu
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		add(fileMenu);
		//New MenuItem
		newMI = new JMenuItem("New");
		newMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		//Open MenuItem
		openMI = new JMenuItem("Open...");
		openMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		//Save MenuItem
		saveMI = new JMenuItem("Save");
		saveMI.setIcon(getIcon("disk.png"));
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
			
			
		//Edit Menu
		editMenu = new JMenu("Edit");
		editMenu.setMnemonic(KeyEvent.VK_E);
		add(editMenu);
		//Undo MenuItem
		undoMI = new JMenuItem("Undo");
		undoMI.setIcon(getIcon("arrow_undo.png"));
		undoMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		//Redo MenuItem
		redoMI = new JMenuItem("Redo");
		redoMI.setIcon(getIcon("arrow_redo.png"));
		redoMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
		//Copy MenuItem
		copyMI = new JMenuItem("Copy");
		copyMI.setIcon(getIcon("page_white_copy.png"));
		copyMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		//Cut MenuItem
		cutMI = new JMenuItem("Cut");
		cutMI.setIcon(getIcon("cut.png"));
		cutMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		//Paste MenuItem
		pasteMI = new JMenuItem("Paste");
		pasteMI.setIcon(getIcon("page_white_paste.png"));
		pasteMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		
		//Add items to Edit menu
		editMenu.add(undoMI);
		editMenu.add(redoMI);
		editMenu.addSeparator();
		editMenu.add(copyMI);
		editMenu.add(pasteMI);
		editMenu.add(cutMI);
		
		
		//Tools Menu
		toolsMenu = new JMenu("Tools");
		toolsMenu.setMnemonic(KeyEvent.VK_T);
		add(toolsMenu);
		//Search MenuItem
		tileSearchMI = new JMenuItem("Tile Search...");
		tileSearchMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
		//Add items to Tools Menu
		toolsMenu.add(tileSearchMI);
		
		
		//Help Menu
		helpMenu = new JMenu("Help");
		helpMenu.setMnemonic(KeyEvent.VK_H);
		add(helpMenu);
		//About MenuItem
		aboutMI = new JMenuItem("About Reptile");
		
		//Add items to Help Menu
		helpMenu.add(aboutMI);
		
	}
	
	/**
	 * Get an icon from resources
	 * @param filename The filename of the icon
	 * @return The icon requested
	 */
	private Icon getIcon(String filename) {
		try {
			return ResourceManager.get().getIcon(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
