package reptile.gui;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * Menu for creating a new file
 * 
 * @author Joe Williamson <huruey@gmail.com>
 */

public class NewFileMenu extends JMenu {
	
	private JMenuItem newProjectButton,
					  newMapButton,
					  newTileSetButton,
					  newObjectLibraryButton,
					  newObjectTypeButton,
					  newBrushLibraryButton,
					  newBrushButton;
	
	public NewFileMenu() {
		setText("New");
		
		ResourceManager res = ResourceManager.get();
		
		//TODO: Create and add (better) icons where necessary
		newProjectButton = new JMenuItem("Project...", res.getIcon("application_add.png"));
		newMapButton = new JMenuItem("Map...", res.getIcon("map_add.png"));
		newTileSetButton = new JMenuItem("Tile Set...");//TODO: Icon
		newObjectLibraryButton = new JMenuItem("Object Library...", res.getIcon("book_add.png"));//TODO: Better icon
		newObjectTypeButton = new JMenuItem("Object Type...", res.getIcon("brick_add.png"));
		newBrushLibraryButton = new JMenuItem("Brush Library...", res.getIcon("book_add.png"));//TODO: Better icon
		newBrushButton = new JMenuItem("Brush...", res.getIcon("paintbrush.png")); //TODO: better icon with "+"
		
		//Add buttons to menu
		add(newProjectButton);
		addSeparator();
		add(newMapButton);
		add(newTileSetButton);
		add(newObjectLibraryButton);
		add(newObjectTypeButton);
		add(newBrushLibraryButton);
		add(newBrushButton);
	}
	
}
