package reptile.gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * The default menu bars
 * 
 * @author Joe Williamson <huruey@gmail.com>
 */

public class MenuBar extends JMenuBar {
	
	//Instance Variables
	
	//File Menu
	private JMenu fileMenu;
	private JMenu newMenu;
	private JMenuItem openProjectMI,
					  openFileMI,
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
	
	//Map Menu
	private JMenu mapMenu;
	private JMenuItem mapPropertiesMI;
	
	//Layer Menu
	private JMenu layerMenu;
	private JMenuItem layerAddTileMI,
					  layerAddObjectMI,
					  layerDeleteMI,
					  layerDuplicateMI,
					  layerPropertiesMI;
	
	//Window Menu
	private JMenu windowMenu;
	private JMenu workspaceMenu;
	private JMenuItem workspaceSaveMI,
					  workspaceDeleteMI,
					  workspaceResetMI;
	private JCheckBoxMenuItem toolbarCheck,
							  statusBarCheck,
							  projectExplorerCheck,
							  layerManagerCheck,
							  editorCheck,
							  paletteCheck,
							  miniMapCheck,
							  historyExplorerCheck,
							  cellInspectorCheck,
							  objectInspectorCheck;
	
	//Help Menu
	private JMenu helpMenu;
	private JMenuItem aboutMI;
	
	/**
	 * Constructor for objects of type MenuBar
	 */
	public MenuBar() {
		//Get ResourceManager
		ResourceManager res = ResourceManager.get();
		
		//File Menu
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		add(fileMenu);
		//New MenuItem
		newMenu = new NewFileMenu();
		//newMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		//Open Project MenuItem
		openProjectMI = new JMenuItem("Open Project...");
		openProjectMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		//Open File MenuItem
		openFileMI = new JMenuItem("Open File...");
		openFileMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
		//Save MenuItem
		saveMI = new JMenuItem("Save");
		saveMI.setIcon(res.getIcon("disk.png"));
		saveMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		//Save As MenuItem
		saveAsMI = new JMenuItem("Save As...");
		//Exit MenuItem
		exitMI = new JMenuItem("Exit");
		exitMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
			
		//Add items to File menu
		fileMenu.add(newMenu);
		fileMenu.add(openProjectMI);
		fileMenu.add(openFileMI);
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
		undoMI.setIcon(res.getIcon("arrow_undo.png"));
		undoMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		//Redo MenuItem
		redoMI = new JMenuItem("Redo");
		redoMI.setIcon(res.getIcon("arrow_redo.png"));
		redoMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
		//Copy MenuItem
		copyMI = new JMenuItem("Copy");
		copyMI.setIcon(res.getIcon("page_white_copy.png"));
		copyMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		//Cut MenuItem
		cutMI = new JMenuItem("Cut");
		cutMI.setIcon(res.getIcon("cut.png"));
		cutMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		//Paste MenuItem
		pasteMI = new JMenuItem("Paste");
		pasteMI.setIcon(res.getIcon("page_white_paste.png"));
		pasteMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		
		//Add items to Edit menu
		editMenu.add(undoMI);
		editMenu.add(redoMI);
		editMenu.addSeparator();
		editMenu.add(copyMI);
		editMenu.add(pasteMI);
		editMenu.add(cutMI);
		
		
		//Map Menu
		mapMenu = new JMenu("Map");
		mapMenu.setMnemonic(KeyEvent.VK_M);
		add(mapMenu);
		//Map Properties MenuItem
		mapPropertiesMI = new JMenuItem("Properties");
		
		//Add items to Map menu
		mapMenu.add(mapPropertiesMI);
		
		
		//Layer Menu
		layerMenu = new JMenu("Layer");
		layerMenu.setMnemonic(KeyEvent.VK_L);
		add(layerMenu);
		
		layerAddTileMI = new JMenuItem("Add Tile Layer");
		layerAddObjectMI = new JMenuItem("Add Object Layer");
		layerDeleteMI = new JMenuItem("Delete Layer");
		layerDuplicateMI = new JMenuItem("Duplicate Layer");
		layerPropertiesMI = new JMenuItem("Properties");
		
		//Add items to Layer menu
		layerMenu.add(layerAddTileMI);
		layerMenu.add(layerAddObjectMI);
		layerMenu.addSeparator();
		layerMenu.add(layerDeleteMI);
		layerMenu.addSeparator();
		layerMenu.add(layerDuplicateMI);
		layerMenu.addSeparator();
		layerMenu.add(layerPropertiesMI);
				
		
		//Window Menu
		windowMenu = new JMenu("Window");
		windowMenu.setMnemonic(KeyEvent.VK_W);
		add(windowMenu);
		
		workspaceMenu = new JMenu("Workspace");
		workspaceResetMI = new JMenuItem("Reset Workspace");
		workspaceSaveMI = new JMenuItem("Save Workspace");
		workspaceDeleteMI = new JMenuItem("Delete Workspace");
		workspaceMenu.add(workspaceResetMI);
		workspaceMenu.addSeparator();
		workspaceMenu.add(workspaceSaveMI);
		workspaceMenu.add(workspaceDeleteMI);
		workspaceMenu.addSeparator();
		
		toolbarCheck = new JCheckBoxMenuItem("Toolbar");
		statusBarCheck = new JCheckBoxMenuItem("Status Bar");
		projectExplorerCheck = new JCheckBoxMenuItem("Project Explorer");
		layerManagerCheck = new JCheckBoxMenuItem("Layer Manager");
		editorCheck = new JCheckBoxMenuItem("Editor");
		paletteCheck = new JCheckBoxMenuItem("Palette");
		miniMapCheck = new JCheckBoxMenuItem("Mini Map");
		cellInspectorCheck = new JCheckBoxMenuItem("Cell Inspector");
		objectInspectorCheck = new JCheckBoxMenuItem("Object Inspector");
		historyExplorerCheck = new JCheckBoxMenuItem("History Explorer");
		
		//Add items to Window menu
		windowMenu.add(workspaceMenu);
		windowMenu.addSeparator();
		windowMenu.add(toolbarCheck);
		windowMenu.add(statusBarCheck);
		windowMenu.addSeparator();
		windowMenu.add(projectExplorerCheck);
		windowMenu.add(layerManagerCheck);
		windowMenu.addSeparator();
		windowMenu.add(editorCheck);
		windowMenu.add(paletteCheck);
		windowMenu.addSeparator();
		windowMenu.add(miniMapCheck);
		windowMenu.addSeparator();
		windowMenu.add(cellInspectorCheck);
		windowMenu.add(objectInspectorCheck);
		windowMenu.addSeparator();
		windowMenu.add(historyExplorerCheck);
		
		
		//Help Menu
		helpMenu = new JMenu("Help");
		helpMenu.setMnemonic(KeyEvent.VK_H);
		add(helpMenu);
		//About MenuItem
		aboutMI = new JMenuItem("About Reptile");
		
		//Add items to Help Menu
		helpMenu.add(aboutMI);
		
	}
	
}
